<template>
  <div class="app-container">
    <div class="filter-container">
      <el-table
        ref="filterTable"
        :data="list"
        border
        show-summary
        :summary-method="getSummaries"
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
          label="药品厂家"
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
          label="单价"
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
        <el-table-column
          label="数量"
          width="200"
          align="center">
          <template slot-scope="scope">
            <el-input-number size="small" :min="1"  v-model="scope.row.buyNum" @change="changeByNum(scope.row)"></el-input-number>
          </template>
        </el-table-column>

        <el-table-column
          label="价格"
          width="200"
          align="center">
          <template slot-scope="scope">
            {{scope.row.itemMony}}
          </template>
        </el-table-column>


      </el-table>


      <div class="footer-buy">
        <el-button v-waves class="filter-item" type="primary" icon="el-icon-search" @click="open()">
          取消
        </el-button>
        <el-button v-waves class="filter-item" type="primary" icon="el-icon-search" @click="open()">
          提交订单
        </el-button>
      </div>
    </div>
  </div>
</template>

<script>
import waves from '@/directive/waves' // waves directive
import { parseTime } from '@/utils'
import Pagination from '@/components/Pagination'
import detail from '@/api/detail.json'
import accMul from "@/utils/accMul";
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
import {toBuyDrug, toBuyDrugNoPay} from "@/api/order";

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
      totalMoney: 0,
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
    getSummaries(param){
      const { columns, data } = param;
      const sums = [];
      columns.forEach((column, index) => {
        if (index === 0) {
          sums[index] = '总价';
          return;
        }
        if (index === 5) {
          sums[index] = this.totalMoney + '元';
          return;
        }
        else sums[index] = '-';
      });

      return sums;
    },
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
    changeByNum(row){
      this.$set(row,'itemMony',accMul(row.price,row.buyNum))    //必须要这样赋值
      this.totalMoney = 0;
      this.list.forEach(item => {
        this.totalMoney+=item.itemMony
      })
    },
    changeVal() {
      this.$forceUpdate();//解决点击计数器失效问题
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
        this.list.forEach(item=> {
          this.$set(item,'buyNum',10)    //必须要这样赋值
          item.itemMony = accMul(10,item.price)
          this.totalMoney += item.itemMony;
        })
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
    handleChange(value) {
      console.log(value);
    },
    AddDrug() {
      this.AdddialogFormVisible = true;
      this.addForm = {};
    },
    numFilter (value) {
      // 截取当前数据到小数点后三位
      let tempVal = parseFloat(value).toFixed(3)
      let realVal = tempVal.substring(0, tempVal.length - 1)
      return realVal
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
    open(){
      this.$confirm('确认支付', '确认信息', {
        distinguishCancelAndClose: true,
        confirmButtonText: '支付',
        cancelButtonText: '取消'
      })
        .then(() => {
          this.$message({
            type: 'info',
            message: '支付成功'
          });
          toBuyDrug(this.list).then(res => {
            console.log(res)
          })
        })
        .catch(action => {
          this.$message({
            type: 'info',
            message: action === 'cancel'
              ? '放弃保存并离开页面'
              : '停留在当前页面'
          });
          toBuyDrugNoPay(this.list).then(res=> {
            console.log(res)
          })
        });
    },
    toBuy(){
      this.$alert('<img src="http://cloud.songyuxin.top/picture/IMG_0690.JPG" width="300px"  alt="">', {
        dangerouslyUseHTMLString: true,
        confirmButtonText: '已支付',
        cancelButtonText: '未支付',
        distinguishCancelAndClose: true,
      }).then(() => {
        this.$message({
          type: 'success',
          message: '支付成功'
        });
        toBuyDrug(this.list).then(res => {
          console.log(res)
        })
      }).catch(action => {
        /*toBuyDrugNoPay.then(res=> {
          console.log(res)
        })*/
          this.$message({
            type: 'info',
            message: action === 'cancel'
              ? '取消支付'
              : '停留在当前页面'
          })
        });
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
.footer-buy {
  margin-top: 30px;
  margin-right: 10px;
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
}
.el-message-box__message p {
  margin: 0;
  line-height: 24px;
  text-align: center;
}
</style>
