<template>
  <div class="app-container">
    <div class="filter-container">
      <el-input v-model="SearchQuery.title" placeholder="请输入" style="width: 200px;" class="filter-item"/>

      <el-select v-model="SearchQuery.type" placeholder="Type" clearable class="filter-item" style="width: 130px">
        <el-option v-for="item in calendarTypeOptions" :key="item.key" :label="item.display_name+'('+item.key+')'" :value="item.key" />
      </el-select>
      <el-button v-waves class="filter-item" type="primary" icon="el-icon-search" @click="Search()">
        查找
      </el-button>
      <el-button v-waves class="filter-item" type="primary" icon="el-icon-search" @click="getList">
        清空
      </el-button>
    </div>

    <el-table
      ref="filterTable"
      :data="list"
      border fit highlight-current-row
      style="width: 100%"
    >
      <el-table-column
        label="药品名称"
        width="200"
        align="center">
        <template slot-scope="scope">
          {{scope.row.drug.drugname}}
        </template>
      </el-table-column>
      <el-table-column
        label="生产厂家"
        width="300"
        align="center">
        <template slot-scope="scope">
          {{scope.row.drug.manu}}
        </template>
      </el-table-column>
      <el-table-column
        label="批准文号"
        width="200"
        align="center">
        <template slot-scope="scope">
          {{scope.row.drug.pzwh}}
        </template>
      </el-table-column>
      <el-table-column
        prop="num"
        label="库存"
        width="200"
        align="center">
      </el-table-column>
      <el-table-column  label="售价" width="200" align="center">
        <template slot-scope="{row}">
          <template v-if="row.edit">
            <el-input v-model="row.price" class="edit-input" style="width: 80px" size="mini" />
            <el-button
              class="cancel-btn"
              size="mini"
              icon="el-icon-refresh"
              type="warning"
              @click="cancelEdit(row)"
            >
              cancel
            </el-button>
          </template>
          <span v-else>{{ row.price }}</span>
        </template>
      </el-table-column>

      <el-table-column label="操作">
        <template #default="scope">
          <el-button
            v-if="scope.row.edit"
            type="success"
            size="small"
            icon="el-icon-circle-check-outline"
            @click="confirmEdit(scope.row)"
          >
            Ok
          </el-button>
          <el-button
            v-else
            type="primary"
            size="mini"
            icon="el-icon-edit"
            @click="editItem(scope.row)"
          >
            Edit
          </el-button>
          <el-button
            size="mini"
            @click="addDrug(scope.row)">补货</el-button>
          <el-button
            v-if="scope.row.status == 1"
            size="mini"
            @click="handleStatus(scope.row)">启用</el-button>
          <el-popconfirm title="确定删除吗？" @onConfirm="handleDelete(scope.row)" style="margin-left: 10px">
            <template #reference>
              <el-button size="mini" type="danger">删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit" @pagination="getList" />


  </div>
</template>

<script>
import waves from '@/directive/waves' // waves directive
import { parseTime } from '@/utils'
import Pagination from '@/components/Pagination'
import detail from '@/api/detail.json'
import {
  addDrug,
  addDrugClass,
  andDrugDetailInfo,
  andDrugDetailInfoLocal, ClinicDrugList,
  fetchDrugList, SearchDrug,
  upgradeStatus
} from "@/api/drug";
import {getDrugInfo, getClassifyInfo, getDrugDetailInfo} from "@/api/drugNew";
import source from "echarts/src/data/Source";
import ClassSelect from "@/components/ClassSelect/index.vue";
import item from "@/layout/components/Sidebar/Item.vue";
import {supplierAddDrug, SupplierDrugList, supplierUpgradeDrug} from "@/api/supplier";

const calendarTypeOptions = [
  { key: 'ID', display_name: 'ID' },
  { key: 'Name', display_name: '名称' },
]

// arr to obj, such as { CN : "China", US : "USA" }
const calendarTypeKeyValue = calendarTypeOptions.reduce((acc, cur) => {
  acc[cur.key] = cur.display_name
  return acc
}, {})

export default {
  name: 'DoctorAdmin',
  components: {ClassSelect, Pagination },
  directives: { waves },
  filters: {
    statusFilter(status) {
      const statusMap = {
        published: 'success',
        draft: 'info',
        deleted: 'danger'
      }
      return statusMap[status]
    },
  },
  data() {
    return {
      class:[],
      filters: [
        {
          text: '正常',
          value: '正常'
        },
        {
          text: '停用',
          value: '停用'
        }
      ],
      formJSON: '',
      drugList:[],
      tableKey: 0,
      show:false,
      resData:[],
      list: [
      ],
      form:{},
      addForm:{
        select:[]
      },
      total: 0,
      listLoading: true,
      SearchQuery: {
        title:'',
        type:''
      },
      listQuery: {
        page: 1,
        limit: 20,
        importance: '',
        title: '',
        type: ''
      },
      formLabelWidth: '100px',
      AdddialogFormVisible: false,
      importanceOptions: [1, 2, 3],
      calendarTypeOptions,
      sortOptions: [{ label: 'ID Ascending', key: '+id' }, { label: 'ID Descending', key: '-id' }],
      statusOptions: ['published', 'draft', 'deleted'],
      showReviewer: false,
      temp: {
        id: undefined,
        importance: 1,
        remark: '',
        timestamp: new Date(),
        title: '',
        type: '',
        status: 'published'
      },
      dialogFormVisible: false,
      dialogStatus: '',
      textMap: {
        update: 'Edit',
        create: 'Create'
      },
      dialogPvVisible: false,
      pvData: [],
      rules: {
        type: [{ required: true, message: 'type is required', trigger: 'change' }],
        timestamp: [{ type: 'date', required: true, message: 'timestamp is required', trigger: 'change' }],
        title: [{ required: true, message: 'title is required', trigger: 'blur' }]
      },
      downloadLoading: false
    }
  },
  created() {

    this.getList();
  },
  methods: {
    cancelEdit(row) {
      row.price = row.originalPrice
      row.edit = false
      this.$message({
        message: 'The title has been restored to the original value',
        type: 'warning'
      })
    },
    Search(){
      SearchDrug(this.SearchQuery.title,this.SearchQuery.type).then(res=> {
        this.list = res.data
      })
    },
    formatter(row, column) {
      return row.address;
    },
    filterTag(value, row) {
      return row.statusStr === value;
    },
    roleType(role){
      if (role == "正常") return 'Pet'
      if (role == "停用") return 'Bathe'
    },
    cancel(){
      this.show = false;
      console.log("jjjj")
    },
    getList() {


      this.listLoading = true
      SupplierDrugList(this.listQuery).then(res =>{
        const { data } = res
        const {list,total} = data;
        this.list = list;
        this.total = total;
        this.list.forEach(v => {
          this.$set(v, 'edit', false) // https://vuejs.org/v2/guide/reactivity.html
          v.originalPrice = v.price //  will be used when user click the cancel botton
          return v
        })
        this.listLoading = false
      })

    },
    handleEdit(row) {
      this.show = true;
      getDrugDetailInfo(row.drugid).then(res => {
        const {data} = res;
        console.log(res)
        this.form = data;
        this.form.select= [row.drug.drugclass.classname,row.drug.drugclass.classify]
        this.formJSON = JSON.stringify(this.form);
      })

    },
    editItem(row){
      row.edit = !row.edit;
      console.log(row)
    },
    confirmEdit(row) {
      row.edit = false
      console.log(row)
      supplierUpgradeDrug(row.price,row.drugid).then(res => {
        console.log(res)
        this.$message({
          message: '更新成功',
          type: 'success'
        })
      })
    },
    addDrug(row) {
      supplierAddDrug(row.drugid).then(res=> {
        console.log(res)
        this.$message({
          message: '补货成功',
          type: 'success'
        })
        this.getList()
      })
    },
    SubmitAdd() {
      console.log(this.addForm)
      /*andDrugDetailInfo(this.addForm).then(res=> {
        console.log(res)
      })*/
      this.AdddialogFormVisible = false;
      this.addForm = {}

    },
    handleStatus(row){
      upgradeStatus(row.drugid,row.status).then(res=> {
        if (res.code === 100) {
          this.getList();
          this.$notify({
            title: 'Success',
            message: '操作Success',
            type: 'success',
            duration: 2000
          })
        }

      })
    },
    Submit(){
      this.dialogFormVisible = false;
      if (this.formJSON == JSON.stringify(this.form)) {
        this.$notify({
          title: '提示',
          message: '您未作出修改',
          type: 'error',
          duration: 2000
        })
      } else {
        this.$notify({
          title: 'Success',
          message: '操作Success',
          type: 'success',
          duration: 2000
        })
      }
    },
    handleFilter() {
      this.listQuery.page = 1
      this.getList()
    },
    handleModifyStatus(row, status) {
      this.$message({
        message: '操作Success',
        type: 'success'
      })
      row.status = status
    },
    sortChange(data) {
      const { prop, order } = data
      if (prop === 'id') {
        this.sortByID(order)
      }
    },
    sortByID(order) {
      if (order === 'ascending') {
        this.listQuery.sort = '+id'
      } else {
        this.listQuery.sort = '-id'
      }
      this.handleFilter()
    },
    resetTemp() {
      this.temp = {
        id: undefined,
        importance: 1,
        remark: '',
        timestamp: new Date(),
        title: '',
        status: 'published',
        type: ''
      }
    },
    handleDelete(row) {
      console.log(row.id)
      fetchDelete(row.id).then(res => {
        console.log(res)
        if (res.code === 100 ) {
          this.$notify({
            title: 'Success',
            message: '删除成功',
            type: 'success',
            duration: 2000
          })
        }
        this.getList();
      })

    },
    handleDownload() {
      this.downloadLoading = true
      import('@/vendor/Export2Excel').then(excel => {
        const tHeader = ['timestamp', 'title', 'type', 'importance', 'status']
        const filterVal = ['timestamp', 'title', 'type', 'importance', 'status']
        const data = this.formatJson(filterVal)
        excel.export_json_to_excel({
          header: tHeader,
          data,
          filename: 'table-list'
        })
        this.downloadLoading = false
      })
    },
    formatJson(filterVal) {
      return this.list.map(v => filterVal.map(j => {
        if (j === 'timestamp') {
          return parseTime(v[j])
        } else {
          return v[j]
        }
      }))
    },

  }
}
</script>

<style>
.Pet {
  background-color: #C06F98;
  color: white;
}
.Insurance {
  background-color: #E77C8E;
  color: white;
}
.Bathe {
  background-color: #1661AB;
  color: white;
}
.Hairdressing {
  background-color: #61649F;
  color: white;
}
</style>
