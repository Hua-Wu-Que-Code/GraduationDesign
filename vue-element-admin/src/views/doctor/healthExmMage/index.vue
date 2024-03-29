<template>
  <div class="app-container">
    <div class="filter-container">
      <el-input v-model="listQuery.title" placeholder="姓名" style="width: 200px;" class="filter-item" @keyup.enter.native="searchExam" />
      <el-button v-waves class="filter-item" type="primary" icon="el-icon-search" @click="searchExam">
        查找
      </el-button>
      <el-button v-waves class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">
        清空
      </el-button>
      <el-button v-waves class="filter-item" type="primary" icon="el-icon-search" @click="addExam">
        新增
      </el-button>
    </div>

    <el-table
      ref="filterTable"
      :data="list"
      border
      style="width: 100%"
    >
      <el-table-column
        prop="id"
        label="id"
        width="330"
        align="center">
      </el-table-column>
      <el-table-column
        prop="name"
        label="姓名"
        width="100"
        align="center">
      </el-table-column>
      <el-table-column
        prop="idcard"
        label="身份证号"
        width="300"
        align="center">
      </el-table-column>
      <el-table-column
        prop="sexStr"
        label="性别"
        width="100"
        align="center">
      </el-table-column>
      <el-table-column
        prop="age"
        label="年龄"
        width="100"
        align="center">
      </el-table-column>
      <el-table-column
        prop="groupStr"
        label="民族"
        width="100"
        align="center">
      </el-table-column>
      <el-table-column label="操作">
        <template #default="scope">
          <el-button
            size="mini"
            @click="handleEdit(scope.row)">查看</el-button>
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
import { fetchList, fetchDelete, createArticle, updateArticle } from '@/api/userInfoMage'
import waves from '@/directive/waves' // waves directive
import { parseTime } from '@/utils'
import Pagination from '@/components/Pagination'
import {patientList} from "@/api/doctor";
import {formatDate} from "@/utils/dateFormate";
import {date} from "jszip/lib/defaults"; // secondary package based on el-pagination

const calendarTypeOptions = [
  { key: 'CN', display_name: 'China' },
  { key: 'US', display_name: 'USA' },
  { key: 'JP', display_name: 'Japan' },
  { key: 'EU', display_name: 'Eurozone' }
]

// arr to obj, such as { CN : "China", US : "USA" }
const calendarTypeKeyValue = calendarTypeOptions.reduce((acc, cur) => {
  acc[cur.key] = cur.display_name
  return acc
}, {})

export default {
  name: 'AccountInfoAdmin',
  components: { Pagination },
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
      tableKey: 0,
      list: [
      ],
      filters: [
        {
          text: '管理员',
          value: '管理员'
        },
        {
          text: '医生',
          value: '医生'
        },
        {
          text: '供货商',
          value: '供货商'
        },{
          text: '患者',
          value: '患者'
        }
      ],
      total: 0,
      listLoading: true,
      listQuery: {
        page: 1,
        limit: 20,
        importance: '',
        title: '',
        type: ''
      },
      healthCareInfo: [],
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
    addExam() {
      this.$router.push({path:'/doctorHealthExm/detail' , query: {id: "addNewExm"}});
    },
    formatter(row, column) {
      return row.address;
    },
    filterTag(value, row) {
      return row.roles[0] === value;
    },
    roleType(role){
      if (role == "管理员") return 'Pet'
      if (role == "医生") return 'Insurance'
      if (role == "供货商") return 'Bathe'
      if (role == "患者") return 'Hairdressing'
      if (role == "正常") return 'Pet'
      if (role == "停用") return 'Bathe'
    },
    getList() {
      this.listLoading = true
      patientList(this.listQuery).then(res =>{
        const { data } = res
        const {healthCareInfo,list,total} = data
        this.healthCareInfo = healthCareInfo;
        this.total = total;
        this.list = list
        this.listLoading = false
      })
    },
    handleFilter() {
      this.listQuery.page = 1
      this.getList()
    },
    searchExam() {
      this.listQuery.type = "name"
      this.getList();
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
    handleEdit(row) {
      console.log(row)
      this.$router.push({path:'/doctorHealthExm/info' , query: {files: row.userInfo.medicalexaminationfile}});
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
