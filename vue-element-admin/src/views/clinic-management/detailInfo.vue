<template>
  <div class="app-container">
    <div v-if="clinic">
      <el-row :gutter="20">

        <el-col :span="6" :xs="24">
          <ClinicCard :clinic="clinic"/>
        </el-col>

        <el-col :span="18" :xs="24">
          <el-card>
            <el-tabs v-model="activeTab">
              <el-tab-pane label="诊所信息" name="clinicInfo">
                <ClinicInfo :clinic="clinic" />
              </el-tab-pane>
              <el-tab-pane label="医生信息" name="doctorInfo">
                <DoctorInfo :doctorInfo="doctor"/>
              </el-tab-pane>
              <el-tab-pane label="诊所数据" name="clinicStasis">
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
import ClinicInfo from "@/views/clinic-management/components/ClinicInfo.vue";
import Account from "@/views/clinic-management/components/Account.vue";
import ClinicCard from "@/views/clinic-management/components/ClinicCard.vue";
import DoctorInfo from "@/views/clinic-management/components/DoctorInfo.vue";


export default {
  name: 'detailInfo',
  components: {ClinicInfo, Account, ClinicCard,DoctorInfo},
  data() {
    return {
      clinic: {},
      doctor: {},
      activeTab: 'clinicInfo',
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
    this.clinic = this.$route.query.clinic;
    console.log(this.clinic)
    this.doctor  = this.clinic.doctor;
  },
  methods: {

  }
}
</script>
