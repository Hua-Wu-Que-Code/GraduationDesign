<template>
  <div class="app-container">
    <div v-if="clinic">
      你好
      <el-row :gutter="20">

        <el-col :span="6" :xs="24">
          <DoctorCard :doctor="doctor"/>
        </el-col>

        <el-col :span="18" :xs="24">
          <el-card>
            <ClinicInfoCard :clinic="clinic" />
          </el-card>
        </el-col>

      </el-row>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import DoctorCard from './components/Doctor.vue'
import ClinicInfoCard from "@/views/clinic-management/components/ClinicInfo.vue";
import th from "element-ui/src/locale/lang/th";

export default {
  name: 'detailInfo',
  components: { DoctorCard,ClinicInfoCard},
  data() {
    return {
      clinic: {},
      doctor: {},
      activeTab: 'account',
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
    this.doctor  = this.clinic.doctor;
    console.log(this.doctor)
  },
  methods: {

  }
}
</script>
