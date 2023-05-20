<template>
  <div class="dashboard-container">
    <component :is="currentRole" />
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import supplierDashboard from '../supplier/supplierDrugMage/index.vue'
import patientDashboard from './patient'
import doctorDashboard from '../doctor/clinicDrugMage/index.vue'
import adminDashboard from '../drug-admin/index.vue'
export default {
  name: 'Dashboard',
  components: { adminDashboard, doctorDashboard,  supplierDashboard, patientDashboard},
  data() {
    return {
      currentRole: 'adminDashboard'
    }
  },
  computed: {
    ...mapGetters([
      'roles'
    ])
  },
  created() {
    let role = this.roles[0]
    console.log(role)
    switch (role) {
      case 'doctor':
        this.currentRole = 'doctorDashboard'
        break;
      case 'supplier':
        this.currentRole = 'supplierDashboard'
        break;
      case 'patient':
        this.currentRole = 'patientDashboard'
        break;
    }
  }
}
</script>
