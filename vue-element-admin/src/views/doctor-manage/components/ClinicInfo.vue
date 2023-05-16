<template>
<div>
  <el-form ref="form" :model="clinic" label-width="100px">
    <el-form-item label="名称">
      <el-input v-model="clinic.name"></el-input>
    </el-form-item>
    <el-form-item label="地点">
      <CitySelect :selectedOptions="clinic.select" />
    </el-form-item>
    <el-form-item label="联系电话">
      <el-input v-model="clinic.telephone"></el-input>
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
export default {
  components: {
    CitySelect
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
    onSubmit() {

    }
  }
}
</script>

<style scoped>

</style>
