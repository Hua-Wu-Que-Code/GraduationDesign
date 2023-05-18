<template>
  <div id="app">
    <el-cascader
      size="large"
      :options="classInfo"
      v-model="selectedOptions">
    </el-cascader>
  </div>
</template>

<script>
import classInfo from '@/assets/class/classInfo.json'
export default {
  props: {
    selectedOptions:[],
  },
  data () {
    return {
      classInfo,
    }
  },
  computed:{
  }
}
</script>
