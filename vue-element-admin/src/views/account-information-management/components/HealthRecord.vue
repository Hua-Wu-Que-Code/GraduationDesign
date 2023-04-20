<template>
<div>
  <el-form ref="form" :model="healthCare" label-width="100px">
    <el-form-item label="姓名">
      <el-input v-model="healthCare.name"></el-input>
    </el-form-item>
    <el-form-item label="性别">
      <el-select v-model="healthCare.sex">
        <el-option v-for="item in healthCareInfo.sexes" :label="item.name" :value="item.name"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="民族">
      <el-select v-model="healthCare.ethnicgroup" filterable>
        <el-option v-for="item in healthCareInfo.ethnicgroup" :label="item.name" :value="item.name"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="血型">
      <el-select v-model="healthCare.bloodtype">
        <el-option v-for="item in healthCareInfo.bloodtype" :label="item.name" :value="item.name"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="身份证号">
      <el-input v-model="healthCare.idcard"></el-input>
    </el-form-item>
    <el-form-item label="出生日期">
      <el-input v-model="healthCare.date"></el-input>
    </el-form-item>
    <el-form-item label="职业">
      <el-select v-model="healthCare.work">
        <el-option v-for="item in healthCareInfo.works" :label="item.name" :value="item.name"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="工作单位">
      <el-input v-model="healthCare.workplace"></el-input>
    </el-form-item>
    <el-form-item label="电话号码">
      <el-input v-model="healthCare.telephone"></el-input>
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
      <el-select v-model="healthCare.education">
        <el-option v-for="item in healthCareInfo.education" :label="item.name" :value="item.name"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="婚姻状况">
      <el-select v-model="healthCare.marriage">
        <el-option v-for="item in healthCareInfo.marriage" :label="item.name" :value="item.name"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="支付方式">
      <el-select v-model="healthCare.pamentmeth">
        <el-option v-for="item in healthCareInfo.pamentmeth" :label="item.name" :value="item.name"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="过敏历史">
      <el-select v-model="healthCare.allergyhistory"
                 multiple
                 filterable
                 @change="(val) => handleChange(val, 'allergyMul')"
                 allow-create
                 default-first-option>
        <el-option v-for="item in healthCareInfo.allergyhistory"
                   :label="item.name"
                   :key="item.name"
                   :value="item.name">
        </el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="疾病历史">
      <el-select v-model="healthCare.diseases" multiple collapse-tags filterable default-first-option @change="(val) => handleChange(val,'diseases')">
        <el-option
          v-for="item in healthCareInfo.diseases"
          :key="item.name"
          :label="item.name"
          :value="item.name">
        </el-option>
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
      <el-select v-model="healthCare.heredityhistory">
        <el-option v-for="item in healthCareInfo.heredityhistory" :label="item.name" :value="item.name"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="残疾情况">
      <el-select v-model="healthCare.group" :placeholder="healthCare.group">
        <el-option label="男" value="0"></el-option>
        <el-option label="女" value="1"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">立即创建</el-button>
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
    }
  },
  created() {
  },
  methods: {
    onSubmit() {
      console.log(this.healthCare.diseases)
    },
    handleChange(val,flag){
      console.log(flag)
      if (flag == 'allergyMul'){
        if (val.includes('无')) {
          console.log("hello")
          this.healthCare.allergyhistory = ['无'];
        }
      } else if (flag == 'diseases'){
        console.log(val)
        if (val.includes('无')) {

          this.healthCare.diseases = ['无'];
        }
      }

    }
  }
}
</script>

<style scoped>

</style>
