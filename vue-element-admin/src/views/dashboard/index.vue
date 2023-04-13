<template>
  <div class="dashboard-container">
    <component :is="currentRole" />
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import adminDashboard from './admin'
import doctorDashboard from './doctor'
import applierDashboard from './supplier'
import patientDashboard from './patient'

export default {
  name: 'Dashboard',
  components: { adminDashboard, doctorDashboard,  applierDashboard, patientDashboard},
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
