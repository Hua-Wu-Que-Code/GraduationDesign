<template>
  <div id="app">
    <el-cascader
      size="large"
      :options="pcaTextArr"
      v-model="selectedOptions">
    </el-cascader>
  </div>
</template>

<script>
import { pcaTextArr } from 'element-china-area-data'
export default {
  props: {
    selectedOptions:[],
  },
  data () {
    return {
      pcaTextArr,
    }
  },
}
</script>
