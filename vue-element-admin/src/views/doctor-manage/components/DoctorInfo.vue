<template>
  <div class="user-activity">
    <el-form ref="form" :model="doctorInfo" label-width="100px">
      <el-form-item label="姓名">
        <el-input v-model="doctorInfo.name"></el-input>
      </el-form-item>
      <el-form-item label="联系电话">
        <el-input v-model="doctorInfo.telephone"></el-input>
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
  components: {CitySelect},
  props: {
    doctorInfo: {}
  },
  created() {
    console.log(this.doctorInfo)
  },
  data() {
    return {
    }
  }
}
</script>

<style lang="scss" scoped>
.user-activity {
  .user-block {

    .username,
    .date {
      display: block;
      margin-left: 50px;
      padding: 2px 0;
    }

    .username{
      font-size: 16px;
      color: #000;
    }

    :after {
      clear: both;
    }

    .img-circle {
      border-radius: 50%;
      width: 40px;
      height: 40px;
      float: left;
    }

    span {
      font-weight: 500;
      font-size: 12px;
    }
  }

  .post {
    font-size: 14px;
    border-bottom: 1px solid #d2d6de;
    margin-bottom: 15px;
    padding-bottom: 15px;
    color: #666;

    .image {
      width: 100%;
      height: 100%;

    }

    .user-images {
      padding-top: 20px;
    }
  }

  .list-inline {
    padding-left: 0;
    margin-left: -5px;
    list-style: none;

    li {
      display: inline-block;
      padding-right: 5px;
      padding-left: 5px;
      font-size: 13px;
    }

    .link-black {

      &:hover,
      &:focus {
        color: #999;
      }
    }

    .text {
      text-indent: +2em;
    }
  }

}

.box-center {
  margin: 0 auto;
  display: table;
}

.text-muted {
  color: #777;
}
</style>
