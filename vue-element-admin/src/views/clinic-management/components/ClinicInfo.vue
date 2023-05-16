<template>
  <div>
    <el-form ref="form" :model="clinic" label-width="100px">
      <el-form-item label="名称">
        <el-input v-model="clinic.name"></el-input>
      </el-form-item>
      <el-form-item label="地点">
        <CitySelect :selectedOptions="clinic.address" />
      </el-form-item>
      <el-form-item label="详细地址">
        <el-input v-model="clinic.detail"></el-input>
      </el-form-item>
      <el-form-item label="联系电话">
        <el-input v-model="clinic.telephone"></el-input>
      </el-form-item>
      <el-form-item label="营业时间">
        <TimePicker :time="clinic.time"/>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">立即创建</el-button>
        <el-button @click="getInfo">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import CitySelect from "@/components/CitySelect/index.vue";
import TimePicker from "@/components/TimePicker/index.vue";

export default {
  components: {
    CitySelect,TimePicker
  },
  props: {
    clinic:{},
  },
  name: "clinicInfo",
  data() {
    return {

    }
  },
  created() {

  },
  methods: {

  }
}
</script>

<style scoped>

</style>
