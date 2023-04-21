<template>
  <div class="app-container">
    <div v-if="user">
      <el-row :gutter="20">

        <el-col :span="6" :xs="24">
          <user-card :user="user" />
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

export default {
  name: 'detailInfo',
  components: { UserCard, MedicalExaminationFile,Account,HealthRecord},
  data() {
    return {
      user: {},
      activeTab: 'MedicalExaminationFile',
      MedicalExaminationFile: [],
      healthCare: {},
      healthCareInfo:{}
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
      console.log(data)
      this.MedicalExaminationFile = data.medicalexaminationfile;
      this.healthCare = data.healthrecord;
      this.healthCareInfo = data.healthCareInfo;
      this.healthCare.bloodtype = data.healthCareInfo.bloodtype[this.healthCare.bloodtypeid].name;
      this.healthCare.education = data.healthCareInfo.education[this.healthCare.education].name;
      this.healthCare.ethnicgroup = data.healthCareInfo.ethnicgroup[this.healthCare.ethnicgroupid].name;
      this.healthCare.pamentmeth = data.healthCareInfo.pamentmeth[this.healthCare.pamentmeth].name;
      this.healthCare.marriage = data.healthCareInfo.marriage[this.healthCare.marriage].name;
      this.healthCare.sex = data.healthCareInfo.sexes[this.healthCare.sex].name;
      this.healthCare.work = data.healthCareInfo.works[this.healthCare.workId].name;
    })
  },
  methods: {
    getUser() {
      this.user = {
        username: this.username,
        role: this.roles.join(' | '),
        email: 'admin@test.com',
        avatar: this.avatar
      }
    }
  }
}
</script>
