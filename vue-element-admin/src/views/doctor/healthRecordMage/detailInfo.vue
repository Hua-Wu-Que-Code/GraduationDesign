<template>
  <div class="app-container">
    <div v-if="user">
      <el-row>

        <el-col :span="20" :offset="2">
          <el-card>
            <HealthRecord :healthCare="healthCare" :healthCareInfo="healthCareInfo"/>
          </el-card>
        </el-col>

      </el-row>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import {fetchHealthCare} from "@/api/userInfoMage";

import HealthRecord from "@/views/doctor/healthRecordMage/components/HealthRecord.vue";

export default {
  name: 'detailInfo',
  components: { HealthRecord},
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
    this.healthInfo = this.$route.query.healthInfo;
  },
  methods: {

  }
}
</script>
