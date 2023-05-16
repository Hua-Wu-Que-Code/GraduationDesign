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
      <el-select v-model="healthCare.ethnicGroup" filterable>
        <el-option v-for="item in healthCareInfo.ethnicgroup" :label="item.name" :value="item.name"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="血型">
      <el-select v-model="healthCare.bloodType">
        <el-option v-for="item in healthCareInfo.bloodtype" :label="item.name" :value="item.name"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="身份证号">
      <el-input v-model="healthCare.idcard"></el-input>
    </el-form-item>
    <el-form-item label="出生日期">
      <div class="block">
        <el-date-picker
          v-model="healthCare.date"
          type="date"
          placeholder="选择日期">
        </el-date-picker>
      </div>
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
      <el-radio-group v-model="healthCare.typeofpermanent">
        <el-radio :label="0">户籍</el-radio>
        <el-radio :label="1">非户籍</el-radio>
      </el-radio-group>
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
    <el-form-item label="遗传病历史">
      <el-select v-model="healthCare.heredityhistory" multiple collapse-tags filterable default-first-option @change="(val) => handleChange(val,'heritage')">
        <el-option
          v-for="item in healthCareInfo.heritageDiseases"
          :key="item.name"
          :label="item.name"
          :value="item.name">
        </el-option>
      </el-select>
    </el-form-item>

    <el-form-item label="残疾情况">
      <el-select v-model="healthCare.disabilities" multiple collapse-tags filterable default-first-option
                 @change="(val) => handleChange(val,'disabilities')">
        <el-option
          v-for="item in healthCareInfo.disabilities"
          :key="item.name"
          :label="item.name"
          :value="item.name">
        </el-option>
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
      pickerOptions: {
        disabledDate(time) {
          return time.getTime() > Date.now();
        },
        shortcuts: [{
          text: '今天',
          onClick(picker) {
            picker.$emit('pick', new Date());
          }
        }, {
          text: '昨天',
          onClick(picker) {
            const date = new Date();
            date.setTime(date.getTime() - 3600 * 1000 * 24);
            picker.$emit('pick', date);
          }
        }, {
          text: '一周前',
          onClick(picker) {
            const date = new Date();
            date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
            picker.$emit('pick', date);
          }
        }]
      },
    }
  },
  created() {
  },
  methods: {
    onSubmit() {
      console.log(this.healthCare)
    },
    handleChange(val,flag){
      console.log(flag)
      if (flag == 'allergyMul'){
        if (val.includes('无')) {
          this.healthCare.allergyhistory = ['无'];
        }
      } else if (flag == 'diseases'){
        if (val.includes('无')) {
          this.healthCare.diseases = ['无'];
        }
      } else if (flag == 'disabilities') {
        if(val.includes('无残疾')) {
          this.healthCare.disabilities = ['无残疾'];
        }
      } else if (flag == 'heritage') {
        if (val.includes('无')) {
          this.healthCare.heredityhistory= ['无']

        }
      }

    }
  }
}
</script>

<style scoped>

</style>
