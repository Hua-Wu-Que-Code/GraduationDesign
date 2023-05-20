<template>
  <el-form label-width="100px" style="margin-top: 40px">
    <el-form-item label="账号">
      <el-input style="width: 400px" v-model.trim="user.username" />
    </el-form-item>
    <el-form-item label="昵称">
      <el-input style="width: 400px" v-model.trim="user.nickname" />
    </el-form-item>
    <el-form-item label="密码">
      <el-input style="width: 400px" v-model.trim="user.password" />
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submit">Update</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import {getInfo, getUserInfo} from "@/api/user";

export default {
  props: {
    user: {
    },
    userJSON:''
  },
  created() {
    getUserInfo().then(res => {
      const {data} = res;
      console.log(data)
      this.user = data
      this.userJSON = JSON.stringify(data)
    })
  },
  methods: {
    submit() {
      if (this.userJSON != JSON.stringify(this.user)) {
        this.$message({
          message: '更新成功，请重新登录',
          type: 'success',
          duration: 5 * 1000
        })
      } else {
        this.$message({
          message: '未作出修改',
          type: 'info',
          duration: 5 * 1000
        })
      }
    }
  }
}
</script>
