<template>
  <div class="app-container">
    <el-row>

      <el-col :span="20" :offset="2">
        <div class="filter-container">
          <el-date-picker
            v-model="listQuery.title"
            type="date"
            placeholder="选择日期">
          </el-date-picker>
          <el-button v-waves class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">
            查找
          </el-button>
          <el-button v-waves class="filter-item" type="primary"  @click="handleFilter">
            添加
          </el-button>
        </div>
        <el-card>
          <div v-if="this.MedicalExaminationFile.length == 0" style="text-align: center">
            暂无数据
          </div>
          <MedicalExaminationFile v-else :MedicalExaminationFile="MedicalExaminationFile" />
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import UserCard from './components/UserCard'
import MedicalExaminationFile from './components/MedicalExaminationFile.vue'
export default {
  name: 'detailInfo',
  components: { UserCard, MedicalExaminationFile},
  data() {
    return {
      user: {},
      listQuery: {
        page: 1,
        limit: 20,
        importance: '',
        title: '',
        type: ''
      },
      MedicalExaminationFile: [],
      tags: []
    }
  },
  computed: {
    ...mapGetters([
      'name',
      'avatar',
      'roles'
    ])
  },
  created() {
    this.MedicalExaminationFile = this.$route.query.files;
    console.log(this.MedicalExaminationFile)
  },
  methods: {
    handleFilter() {
      console.log(this.listQuery)
      /*this.listQuery.page = 1
      this.getList()*/
    },
  }
}
</script>
