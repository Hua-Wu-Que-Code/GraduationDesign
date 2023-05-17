<template>
  <div class="app-container">
    <div class="filter-container">
      <el-input v-model="listQuery.title" placeholder="Title" style="width: 200px;" class="filter-item" @keyup.enter.native="handleFilter" />
      <el-select v-model="listQuery.importance" placeholder="Imp" clearable style="width: 90px" class="filter-item">
        <el-option v-for="item in importanceOptions" :key="item" :label="item" :value="item" />
      </el-select>
      <el-select v-model="listQuery.type" placeholder="Type" clearable class="filter-item" style="width: 130px">
        <el-option v-for="item in calendarTypeOptions" :key="item.key" :label="item.display_name+'('+item.key+')'" :value="item.key" />
      </el-select>
      <el-select v-model="listQuery.sort" style="width: 140px" class="filter-item" @change="handleFilter">
        <el-option v-for="item in sortOptions" :key="item.key" :label="item.label" :value="item.key" />
      </el-select>
      <el-button v-waves class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">
        Search
      </el-button>
      <el-button class="filter-item" style="margin-left: 10px;" type="primary" icon="el-icon-edit" @click="">
        Add
      </el-button>
      <el-button v-waves :loading="downloadLoading" class="filter-item" type="primary" icon="el-icon-download" @click="handleDownload">
        Export
      </el-button>
    </div>

    <el-table
      ref="filterTable"
      :data="list"
      border
      style="width: 100%"
    >
      <el-table-column
        prop="drugid"
        label="id"
        width="300"
        align="center">
      </el-table-column>
      <el-table-column
        prop="drugname"
        label="药品名称"
        width="200"
        align="center">
      </el-table-column>
      <el-table-column
        prop="manu"
        label="生产厂家"
        width="300"
        align="center">
      </el-table-column>
      <el-table-column
        prop="pzwh"
        label="批准文号"
        width="200"
        align="center">
      </el-table-column>

      <el-table-column label="操作">
        <template #default="scope">
          <el-button
            size="mini"
            @click="handleEdit(scope.row)">查看</el-button>
          <el-button
            size="mini"
            @click="handleEdit(scope.$index, scope.row)">停用</el-button>
          <el-popconfirm title="确定删除吗？" @onConfirm="handleDelete(scope.row)" style="margin-left: 10px">
            <template #reference>
              <el-button size="mini" type="danger">删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog title="药品详细" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="药品名称" :label-width="formLabelWidth">
          <el-input v-model="form.drugName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="规格" :label-width="formLabelWidth">
          <el-input v-model="form.gg" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="禁忌" :label-width="formLabelWidth">
          <el-input v-model="form.jj" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="形状" :label-width="formLabelWidth">
          <el-input v-model="form.xz" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="商品通称" :label-width="formLabelWidth">
          <el-input v-model="form.spmc" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item type="textarea"
                      :rows="2"
                      label="介绍" :label-width="formLabelWidth">
          <el-input
            type="textarea"
            :rows="2"
            v-model="form.syz"
            autocomplete="off">
          </el-input>
        </el-form-item>
        <el-form-item label="适应症" :label-width="formLabelWidth">
          <el-input v-model="form.yfyl" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="用法用量" :label-width="formLabelWidth">
          <el-input v-model="form.zycf" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="主要成分" :label-width="formLabelWidth">
          <el-input v-model="form.etyy" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item type="textarea"
                      :rows="2"
                      label="注意事项" :label-width="formLabelWidth">
          <el-input
            type="textarea"
            :rows="2"
            v-model="form.zysx"
            autocomplete="off">
          </el-input>
        </el-form-item>
        <el-form-item label="儿童用药" :label-width="formLabelWidth">
          <el-input v-model="form.etyy" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="孕妇及哺乳期" :label-width="formLabelWidth">
          <el-input v-model="form.fyjbrqfnyy" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="生产厂家" :label-width="formLabelWidth">
          <el-input v-model="form.manu" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="贮存" :label-width="formLabelWidth">
          <el-input v-model="form.zc" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="汉语拼音" :label-width="formLabelWidth">
          <el-input v-model="form.hypy" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="通用名称" :label-width="formLabelWidth">
          <el-input v-model="form.tymc" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="批准文号" :label-width="formLabelWidth">
          <el-input v-model="form.pzwh" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="执行标准" :label-width="formLabelWidth">
          <el-input v-model="form.zxbz" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="药物相互作用" :label-width="formLabelWidth">
          <el-input v-model="form.ywxhzy" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="有效期" :label-width="formLabelWidth">
          <el-input v-model="form.yxq" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="不良反应" :label-width="formLabelWidth">
          <el-input v-model="form.blfy" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
      </div>
    </el-dialog>

    <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit" @pagination="getList" />


  </div>
</template>

<script>
import waves from '@/directive/waves' // waves directive
import { parseTime } from '@/utils'
import Pagination from '@/components/Pagination'
import detail from '@/api/detail.json'
import {addDrug, addDrugClass, andDrugDetailInfo, andDrugDetailInfoLocal, fetchDrugList} from "@/api/drug";
import {getDrugInfo, getClassifyInfo, getDrugDetailInfo} from "@/api/drugNew";
import source from "echarts/src/data/Source"; // secondary package based on el-pagination

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
  name: 'DoctorAdmin',
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
      class:[],
      drugList:[],
      tableKey: 0,
      list: [
      ],
      form:{},
      total: 0,
      listLoading: true,
      listQuery: {
        page: 1,
        limit: 20,
        importance: '',
        title: '',
        type: ''
      },
      formLabelWidth: '100px',
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

    /*andDrugDetailInfoLocal().then(res => {
      console.log(res)
    })
    andDrugDetailInfo(detail).then(res => {
          console.log(res)
    })*/
    this.getList();
  },
  methods: {
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
      /*getClassifyInfo().then(res=> {
        const {showapi_res_body} =res;
        const {data} = showapi_res_body;
        this.class = data;

        for (let i = 40;i<=50;i++) {
          let id = this.class[i].classifyId;
          getDrugInfo(1,id).then(res=> {
            const {showapi_res_body} =res;
            const {data} = showapi_res_body;
            addDrug(data).then(res => {
              console.log(res)
            })
          })

        }
      })*/

      this.listLoading = true
      fetchDrugList(this.listQuery).then(res =>{
        const { data } = res
        const {list,total} = data;


        this.list = list;
        this.total = total;
        this.listLoading = false



      })

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
    handleEdit(row) {
      console.log(row);
      this.dialogFormVisible = true;
      getDrugDetailInfo(row.drugid).then(res => {
        console.log(res)
        const {data} = res;
        this.form = data;
      })
      /*this.$router.push({path:'/accountInfoAdmin/info' , query: {user: row}});*/
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
