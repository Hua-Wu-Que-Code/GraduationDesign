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
      options: [
        {
        value: 'zhinan',
        label: '指南',
        children: [
          {
          value: 'shejiyuanze',
          label: '设计原则',
          children: [{
            value: 'yizhi',
            label: '一致'
          }, {
            value: 'fankui',
            label: '反馈'
          }, {
            value: 'xiaolv',
            label: '效率'
          }, {
            value: 'kekong',
            label: '可控'
          }]
        }, {
          value: 'daohang',
          label: '导航',
          children: [{
            value: 'cexiangdaohang',
            label: '侧向导航'
          }, {
            value: 'dingbudaohang',
            label: '顶部导航'
          }]
        }]
      },
      ]
    }
  },
  computed:{
    classAndClassIfy(){

    }
  }
}
</script>
