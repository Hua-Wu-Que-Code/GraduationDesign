<template>
  <div class="app-container">
    <div class="filter-container">


    <el-table
      ref="filterTable"
      :data="list"
      border
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
        label="供货商"
        width="100"
        align="center">
        <template slot-scope="scope">
          {{scope.row.supplier.name}}
        </template>
      </el-table-column>
      <el-table-column
        label="供货商地址"
        width="200"
        align="center">
        <template slot-scope="scope">
          {{scope.row.supplier.address}}
        </template>
      </el-table-column>
      <el-table-column
        label="供货商联系方式"
        width="200"
        align="center">
        <template slot-scope="scope">
          {{scope.row.supplier.phone}}
        </template>
      </el-table-column>

      <el-table-column
        label="零售价"
        width="100"
        sortable
        align="center">
        <template slot-scope="scope">
          <el-tag
            :class="roleType(scope.row)"
            disable-transitions>
            {{scope.row.price}}</el-tag>
        </template>
      </el-table-column>

      <el-table-column label="操作">
        <template #default="scope">
          <el-button
            size="mini"
            @click="byDrug(scope.row)">购买</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit" @pagination="getList" />

    </div>
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
  andDrugDetailInfoLocal, ClinicDrugList, DrugSoleList,
  fetchDrugList, SearchDrug,
  upgradeStatus
} from "@/api/drug";
import {getDrugInfo, getClassifyInfo, getDrugDetailInfo} from "@/api/drugNew";
import source from "echarts/src/data/Source";
import ClassSelect from "@/components/ClassSelect/index.vue";
import item from "@/layout/components/Sidebar/Item.vue";

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
      drug:{},
      listQuery: {
        page: 1,
        limit: 20,
        importance: '',
        title: '',
        type: ''
      },
      list:[],
      formJSON: '',
      drugList:[],
      downloadLoading: false
    }
  },
  created() {
    this.drug = this.$route.query.drug;
    this.getList(this.drug.drugid);
  },
  methods: {
    formatter(row, column) {
      return row.address;
    },
    filterTag(value, row) {
      return row.statusStr === value;
    },
    roleType(row){
      if (row.price >= row.drug.tjsj) return "Pet"
      else return "Bathe"
    },
    getList(id) {
      this.listLoading = true
      this.listQuery.title = id;
      DrugSoleList(this.listQuery).then(res =>{
        const { data } = res
        const {list,total} = data;
        this.list = list;
        this.total = total;
        this.listLoading = false
        console.log(res)

      })

    },
    byDrug(row) {
      this.$router.push({path:'/clinicDrugAdmin/orderInfo', query: {drug: row}})
    },
    handleEdit(row) {
      this.dialogFormVisible = true;
      getDrugDetailInfo(row.drugid).then(res => {
        const {data} = res;
        this.form = data;
        this.form.select= [row.drugclass.classname,row.drugclass.classify]
        this.formJSON = JSON.stringify(this.form);
      })

    },
    AddDrug() {
      this.AdddialogFormVisible = true;
      this.addForm = {};
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
  },
  computed: {

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
