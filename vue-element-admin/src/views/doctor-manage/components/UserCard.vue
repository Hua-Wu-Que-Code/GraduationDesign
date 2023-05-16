<template>
  <el-card style="margin-bottom:20px;">
    <div slot="header" class="clearfix">
      <span>个人信息</span>
    </div>

    <div class="user-profile">
      <div class="box-center">
        <pan-thumb :image="doctor.avatar" :height="'100px'" :width="'100px'" :hoverable="false">
          <div>Hello</div>
          {{ doctor.roles[0] }}
        </pan-thumb>
      </div>
      <div class="box-center">
        <div class="user-name text-center">{{ doctor.name }}</div>
        <div class="user-role text-center text-muted">{{ doctor.roles[0]}}</div>
      </div>
    </div>

    <div class="user-bio">
      <div class="user-education user-bio-section">
        <div class="user-bio-section-header"><span>👩🏻‍⚕️介绍</span></div>
        <div class="user-bio-section-body">
          <div class="text-muted">
            十年老中医,专治疑难杂症
          </div>
        </div>
      </div>
    </div>

    <div class="user-bio">
      <div class="user-education user-bio-section">
        <div class="user-bio-section-header"><span>👩🏻‍⚕️标签</span></div>
        <div class="user-bio-section-body">
          <div class="text-muted">
            <el-tag v-for="item in doctor.tag">{{item}}</el-tag>
          </div>
        </div>
      </div>
    </div>


  </el-card>
</template>

<script>
import PanThumb from '@/components/PanThumb'

export default {
  components: { PanThumb },
  props: {
    doctor: {
    },
  },
  data() {
    return {

    }
  },
  created() {
    console.log(this.doctor)
  }
}
</script>

<style lang="scss" scoped>
.box-center {
  margin: 0 auto;
  display: table;
}

.text-muted {
  color: #777;
}

.user-profile {
  .user-name {
    font-weight: bold;
  }

  .box-center {
    padding-top: 10px;
  }

  .user-role {
    padding-top: 10px;
    font-weight: 400;
    font-size: 14px;
  }

  .box-social {
    padding-top: 30px;

    .el-table {
      border-top: 1px solid #dfe6ec;
    }
  }

  .user-follow {
    padding-top: 20px;
  }
}

.user-bio {
  margin-top: 20px;
  color: #606266;

  span {
    padding-left: 4px;
  }

  .user-bio-section {
    font-size: 14px;
    padding: 15px 0;

    .user-bio-section-header {
      border-bottom: 1px solid #dfe6ec;
      padding-bottom: 10px;
      margin-bottom: 10px;
      font-weight: bold;
    }
  }
}
</style>
