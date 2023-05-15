<template>
  <div class="app-container">
    <div v-if="user">
      <el-row :gutter="20">

        <el-col :span="6" :xs="24">
          <user-card :user="user" :tags="tags"/>
        </el-col>

        <el-col :span="18" :xs="24">
          <el-card>
            <el-tabs v-model="activeTab">
              <el-tab-pane label="体检档案" name="MedicalExaminationFile">
                <MedicalExaminationFile :MedicalExaminationFile="MedicalExaminationFile" />
              </el-tab-pane>
              <el-tab-pane label="健康档案" name="healthRecord">
                <HealthRecord :healthCare="healthCare" :healthCareInfo="healthCareInfo"/>
              </el-tab-pane>
              <el-tab-pane label="账号信息" name="account">
                <account :user="user" />
              </el-tab-pane>
            </el-tabs>
          </el-card>
        </el-col>

      </el-row>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import UserCard from './components/UserCard'
import MedicalExaminationFile from './components/MedicalExaminationFile.vue'
import Account from './components/Account'
import HealthRecord from "@/views/account-information-management/components/HealthRecord.vue";
import {fetchHealthCare} from "@/api/userInfoMage";
import th from "element-ui/src/locale/lang/th";

export default {
  name: 'detailInfo',
  components: { UserCard, MedicalExaminationFile,Account,HealthRecord},
  data() {
    return {
      user: {},
      activeTab: 'MedicalExaminationFile',
      MedicalExaminationFile: [],
      healthCare: {},
      healthCareInfo:{},
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
    this.user = this.$route.query.user;
    fetchHealthCare(this.user.id).then(res => {
      const {data} = res
      this.MedicalExaminationFile = data.medicalexaminationfile;
      this.healthCare = data.healthrecord;
      this.healthCareInfo = data.healthCareInfo;
      if (this.healthCare.allergyhistory.length != 0 ) this.tags.push({name:'过敏人群'})
      if (this.healthCare.diseases.length != 0 ) this.tags.push({name:'患病人群'})
      if (this.healthCare.heredityhistory.length != 0 ) this.tags.push({name:'遗传病人群'})
      console.log(this.tags)
    })
  },
  methods: {

  }
}
</script>
