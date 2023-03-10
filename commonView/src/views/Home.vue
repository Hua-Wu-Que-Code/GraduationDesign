<template>

  <div stype="margin: 10px 0">

  </div>
  
  <div style="padding: 10px">
    <el-row :gutter="10">
      <el-col :span="12">
        <el-card>
          <div id="myChart" :style="{width: '600px', height: '500px'}"></div>
        </el-card>
      </el-col>
    </el-row>

  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "Home",
  data() {
    return {}
  },
  mounted() {

  },
  methods: {

  }
}
</script>

<style scoped>

</style>
