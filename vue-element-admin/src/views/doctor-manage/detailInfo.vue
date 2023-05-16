<template>
  <div class="app-container">
    <div v-if="user">
      <el-row :gutter="20">

        <el-col :span="6" :xs="24">
          <user-card :doctor="doctor" />
        </el-col>

        <el-col :span="18" :xs="24">
          <el-card>
            <el-tabs v-model="activeTab">
              <el-tab-pane label="医生信息" name="doctorInfo">
                <DoctorInfo :doctorInfo="user" />
              </el-tab-pane>
              <el-tab-pane label="诊所信息" name="clinicInfo">
                <ClinicInfo :clinic="clinic"/>
              </el-tab-pane>
              <el-tab-pane label="账号信息" name="accountInfo">
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
import Account from "@/views/doctor-manage/components/Account.vue";
import ClinicInfo from "@/views/doctor-manage/components/ClinicInfo.vue";
import DoctorInfo from "@/views/doctor-manage/components/DoctorInfo.vue";



export default {
  name: 'detailInfo',
  components: { UserCard, ClinicInfo,Account,DoctorInfo},
  data() {
    return {
      user: {},
      activeTab: 'doctorInfo',
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
    this.doctor = this.user.doctor;
    this.clinic = this.user.clinic;
    const {address} = this.clinic;
    const {province,city,county,detail} = address;
    let select = [province,city,county]
    this.clinic.select = select;
    let tag = [];
    tag.push(this.user.education)
    tag.push(this.user.workexper+"工作经验")
    this.doctor.tag = tag;
    this.doctor.ability = this.user.ability;
  },
  methods: {

  }
}
</script>
