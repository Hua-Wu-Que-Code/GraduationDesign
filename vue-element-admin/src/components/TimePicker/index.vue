<template>
  <el-time-picker
    is-range
    v-model="value"
    range-separator="至"
    start-placeholder="开始时间"
    end-placeholder="结束时间"
    placeholder="选择时间范围">
  </el-time-picker>
</template>

<script>
export default {
  props: {
    time: [

    ]
  },
  data() {
    return {

    };
  },
  computed: {
    value() {
      let timeList = [];
      this.time.forEach(item=> {
        timeList.push(new Date(item.year,item.month,item.date,item.hours,item.minutes))
      })
      return timeList
    }
  }
}
</script>
