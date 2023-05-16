<template>
  <div>
    <el-form label-width="100px">
      <el-form-item label="账号">
        <el-input v-model.trim="doctor.username" />
      </el-form-item>
      <el-form-item label="昵称">
        <el-input v-model.trim="doctor.nickname" />
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model.trim="doctor.password" />
      </el-form-item>
      <el-form-item label="角色">
        <el-select v-model="doctor.roles[0]" >
          <el-option v-for="item in roles" :label="item.name" :value="item.name"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="状态">
        <el-select v-model="doctor.statusStr">
          <el-option v-for="item in Status" :label="item.name" :value="item.name"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submit">更新</el-button>
      </el-form-item>
    </el-form>
  </div>

</template>

<script>
export default {
  props: {
    doctor: {
      type: Object,
      default: () => {
        return {
          username: '',
          nickname:'',
          role: '',
          password:'',
          status:''
        }
      }
    }
  },
  data() {
    return {
      h1: {
        username: "王大壮"
      },
      roles: [
        {name:'管理员'},
        {name:'患者'},
        {name:'医生'},
        {name:'供货商'},
      ],
      Status: [
        {name:'正常'},
        {name:'停用'},
      ]
    }
  },
  methods: {
    submit() {
      this.$message({
        message: 'User information has been updated successfully',
        type: 'success',
        duration: 1 * 1000
      })
    },
  },
  created() {
    console.log(this.doctor)
  },
  watch: {

  }
}
</script>
