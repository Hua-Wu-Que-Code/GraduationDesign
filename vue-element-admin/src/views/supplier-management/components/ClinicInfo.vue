<template>
  <el-form label-width="100px">
    <el-form-item label="账号">
      <el-input v-model.trim="user.username" />
    </el-form-item>
    <el-form-item label="昵称">
      <el-input v-model.trim="user.nickname" />
    </el-form-item>
    <el-form-item label="密码">
      <el-input v-model.trim="user.password" />
    </el-form-item>
    <el-form-item label="角色">
      <el-select v-model="user.roles[0]" >
        <el-option v-for="item in roles" :label="item.name" :value="item.name"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="状态">
      <el-select v-model="user.status">
        <el-option v-for="item in Status" :label="item.name" :value="item.name"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submit">Update</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
name: "ClinicInfo"
}
</script>

<style scoped>

</style>
