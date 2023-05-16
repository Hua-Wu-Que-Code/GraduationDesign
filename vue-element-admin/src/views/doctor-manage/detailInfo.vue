<template>
  <div class="app-container">
    <div v-if="user">
      <el-row :gutter="20">

        <el-col :span="6" :xs="24">
          <user-card :doctor="user.doctor" />
        </el-col>

        <el-col :span="18" :xs="24">
          <el-card>
            <el-tabs v-model="activeTab">
              <el-tab-pane label="医生信息" name="MedicalExaminationFile">
                <MedicalExaminationFile :MedicalExaminationFile="MedicalExaminationFile" />
              </el-tab-pane>
              <el-tab-pane label="诊所信息" name="healthRecord">
                <ClinicInfo :clinic="clinic"/>
              </el-tab-pane>
              <el-tab-pane label="账号信息" name="account">
                <account :doctor="doctor" />
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

import UserCard from "@/views/doctor-manage/components/UserCard.vue";
import HealthRecord from "@/views/doctor-manage/components/ClinicInfo.vue";
import Account from "@/views/doctor-manage/components/Account.vue";
import ClinicInfo from "@/views/doctor-manage/components/ClinicInfo.vue";


export default {
  name: 'detailInfo',
  components: { UserCard, ClinicInfo,Account,HealthRecord},
  data() {
    return {
      user: {},
      activeTab: 'MedicalExaminationFile',
      MedicalExaminationFile: [],
      healthCare: {},
      healthCareInfo:{},
      doctor: {},
      clinic:{},
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
    console.log(this.user)
    this.doctor = this.user.doctor;
    this.clinic = this.user.clinic;
  },
  methods: {

  }
}
</script>
