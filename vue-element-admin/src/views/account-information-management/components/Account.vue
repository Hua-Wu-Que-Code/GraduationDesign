<template>
  <el-form>
    <el-form-item label="账号">
      <el-input v-model.trim="user.username" />
    </el-form-item>
    <el-form-item label="账号">
      <el-input v-model.trim="user.username" />
    </el-form-item>
    <el-form-item label="账号">
      <el-input v-model.trim="user.username" />
    </el-form-item>
    <el-form-item label="账号">
    <el-input v-model.trim="user.username" />
  </el-form-item>
    <el-form-item label="账号">
      <el-input v-model.trim="user.username" />
    </el-form-item>
    <el-form-item label="Email">
      <el-input v-model.trim="user.email" />
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submit">Update</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  props: {
    user: {
      type: Object,
      default: () => {
        return {
          username: '',
          email: ''
        }
      }
    }
  },
  methods: {
    submit() {
      this.$message({
        message: 'User information has been updated successfully',
        type: 'success',
        duration: 1 * 1000
      })
    }
  }
}
</script>
