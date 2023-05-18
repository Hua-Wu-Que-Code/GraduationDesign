<template>
  <div class="app-container">
    <el-table
      ref="filterTable"
      :data="list"
      border
      style="width: 100%"
    >
      <el-table-column
        label="订单ID"
        width="300"
        align="center">
        <template slot-scope="scope">
          {{scope.row.orderid}}
        </template>
      </el-table-column>
      <el-table-column
        label="药品名称"
        width="100"
        align="center">
        <template slot-scope="scope">
          {{scope.row.drug.drugname}}
        </template>
      </el-table-column>
      <el-table-column
        label="购买数量"
        width="100"
        align="center">
        <template slot-scope="scope">
          {{scope.row.buynum}}
        </template>
      </el-table-column>
      <el-table-column
        label="总金额"
        width="100"
        align="center">
        <template slot-scope="scope">
          {{scope.row.itemmony}}
        </template>
      </el-table-column>
      <el-table-column
        label="卖家名称"
        width="200"
        align="center">
        <template slot-scope="scope">
          {{scope.row.supplier.name}}
        </template>
      </el-table-column>
      <el-table-column
        label="卖家联系方式"
        width="200"
        align="center">
        <template slot-scope="scope">
          {{scope.row.supplier.phone}}
        </template>
      </el-table-column>
      <el-table-column
        label="订单状态"
        width="100"
        :filters="filters"
        :filter-method="filterTag"
        align="center"
        filter-placement="bottom-end">
        <template slot-scope="scope">
          <el-tag
            :class="roleType(scope.row.statusStr)"
            disable-transitions>{{scope.row.statusStr}}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template #default="scope">
          <el-button
            size="mini"
            v-if="scope.row.status == 2"
            @click="handleEdit(scope.row)">收货</el-button>
          <el-button
            size="mini"
            v-if="scope.row.status == 1"
            @click="handleEdit(scope.row)">支付</el-button>
          <el-button
            size="mini"
            v-if="scope.row.status == 5"
            @click="handleEdit(scope.row)">申请退货</el-button>
          <el-button
            size="mini"
            v-if="scope.row.status == 0 || scope.row.status == 2 || scope.row.status == 1"
            @click="handleStatus(scope.row,3)">取消</el-button>
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
import {SupplierDrugList} from "@/api/supplier";
import {ClinicOrderList, supplierOrderList, upgradeOrderStatus} from "@/api/order";

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
          text: '待发货',
          value: '待发货'
        },
        {
          text: '待支付',
          value: '待支付'
        },
        {
          text: '待收货',
          value: '待收货'
        },
        {
          text: '申请取消',
          value: '申请取消'
        },
        {
          text: '订单取消',
          value: '订单取消'
        },
        {
          text: '订单完成',
          value: '订单完成'
        },
        {
          text: '商家取消',
          value: '商家取消'
        },
        {
          text: '申请退货',
          value: '商家取消'
        },
        {
          text: '申请退货',
          value: '商家取消'
        },
        {
          text: '订单超时',
          value: '订单超时'
        },{
          text: '商家拒绝',
          value: '商家拒绝'
        }
      ],
      formJSON: '',
      drugList:[],
      tableKey: 0,
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
      if (role == "待发货") return 'Pet'
      if (role == "待支付") return 'Bathe'
      if (role == "待收货") return 'Pet'
      if (role == "申请取消") return 'Bathe'
      if (role == "订单取消") return 'Pet'
      if (role == "订单完成") return 'Bathe'
      if (role == "商家取消") return 'Pet'
      if (role == "申请退货") return 'Bathe'
      if (role == "同意退货") return 'Pet'
      if (role == "订单超时") return 'Bathe'
      if (role == "商家拒绝") return 'Pet'
    },
    cancel(){
      this.dialogFormVisible = false;
    },
    getList() {


      this.listLoading = true
      ClinicOrderList(this.listQuery).then(res =>{
        const { data } = res
        const {list,total} =data
        this.list = list;
        this.total = total;
        console.log(this.list)
        this.listLoading = false
      })

    },
    handleEdit(row) {
      console.log(row)
      let flag = 0;
      if (row.status == 2) flag = 5;
      if (row.status == 5) flag = 7;
      upgradeOrderStatus(row.id,flag).then(res=> {
        console.log(res)
        this.getList()
        this.$notify({
          title: 'Success',
          message: '操作成功',
          type: 'success',
          duration: 2000
        })
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
    handleStatus(row,flag){
      upgradeOrderStatus(row.id,flag).then(res=> {
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
