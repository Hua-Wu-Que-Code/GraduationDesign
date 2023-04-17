<template>
<div>
  <el-form ref="form" :model="healthCare" label-width="100px">
    <el-form-item label="姓名">
      <el-input v-model="healthCare.name"></el-input>
    </el-form-item>
    <el-form-item label="性别">
      <el-select v-model="healthCare.sex">
        <el-option label="男" value="0"></el-option>
        <el-option label="女" value="1"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="民族">
      <el-select v-model="healthCare.group" :placeholder="healthCare.group" filterable>
        <el-option v-for="item in ethnicgroup" :label="item.name" :value="item.name"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="血型">
      <el-select v-model="healthCare.group" :placeholder="healthCare.group">
        <el-option v-for="item in bloodtype" :label="item.name" :value="item.name"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="身份证号">
      <el-input v-model="healthCare.idcard"></el-input>
    </el-form-item>
    <el-form-item label="出生日期">
      <el-input v-model="healthCare.date"></el-input>
    </el-form-item>
    <el-form-item label="工作单位">
      <el-input v-model="healthCare.workplace"></el-input>
    </el-form-item>
    <el-form-item label="电话号码">
      <el-input v-model="healthCare.telephonenumer"></el-input>
    </el-form-item>
    <el-form-item label="联系人姓名">
      <el-input v-model="healthCare.contactname"></el-input>
    </el-form-item>
    <el-form-item label="联系人电话">
      <el-input v-model="healthCare.contactphone"></el-input>
    </el-form-item>
    <el-form-item label="常住类型">
      <template>
        <el-radio v-model="healthCare.typeOfPermanent" label="1">户籍</el-radio>
        <el-radio v-model="healthCare.typeOfPermanent" label="2">非户籍</el-radio>
      </template>
    </el-form-item>
    <el-form-item label="文化程度">
      <el-select v-model="healthCare.group" :placeholder="healthCare.group">
        <el-option v-for="item in education" :label="item.name" :value="item.name"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="婚姻状况">
      <el-select v-model="healthCare.group" :placeholder="healthCare.group">
        <el-option v-for="item in marriage" :label="item.name" :value="item.name"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="支付方式">
      <el-select v-model="healthCare.group" :placeholder="healthCare.group">
        <el-option v-for="item in pamentmeth" :label="item.name" :value="item.name"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="过敏历史">
      <el-select v-model="healthCare.group" :placeholder="healthCare.group">
        <el-option v-for="item in allergyhistory" :label="item.name" :value="item.name"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="疾病历史">
      <el-select v-model="healthCare.group" :placeholder="healthCare.group">
        <el-option label="男" value="0"></el-option>
        <el-option label="女" value="1"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="外伤记录">
      <el-select v-model="healthCare.group" :placeholder="healthCare.group">
        <el-option label="男" value="0"></el-option>
        <el-option label="女" value="1"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="输血历史">
      <el-select v-model="healthCare.group" :placeholder="healthCare.group">
        <el-option label="男" value="0"></el-option>
        <el-option label="女" value="1"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="遗传病历史">
      <el-select v-model="healthCare.group" :placeholder="healthCare.group">
        <el-option label="男" value="0"></el-option>
        <el-option label="女" value="1"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="残疾情况">
      <el-select v-model="healthCare.group" :placeholder="healthCare.group">
        <el-option label="男" value="0"></el-option>
        <el-option label="女" value="1"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="getInfo()">立即创建</el-button>
      <el-button @click="getInfo">取消</el-button>
    </el-form-item>
  </el-form>
</div>
</template>

<script>
export default {
  props: {
    healthCare:{},
    healthCareInfo:{}
  },
  name: "HealthRecord",
  data() {
    return {
      allergyhistory: [],
      bloodtype: [],
      education: [],
      ethnicgroup: [],
      marriage: [],
      pamentmeth: []
    }
  },
  created() {
    this.getInfo();
  },
  methods: {
    getInfo() {
      const {allergyhistory,bloodtype,education,ethnicgroup,marriage,pamentmeth} = this.healthCareInfo
      console.log(this.healthCareInfo)
      this.allergyhistory = allergyhistory;
      this.bloodtype = bloodtype;
      this.education = education;
      this.ethnicgroup = ethnicgroup;
      this.marriage = marriage;
      this.pamentmeth = pamentmeth;
      console.log("hhhh")
      console.log(this.pamentmeth)
    },
    onSubmit() {
      console.log('submit!');
    }
  }
}
</script>

<style scoped>

</style>
