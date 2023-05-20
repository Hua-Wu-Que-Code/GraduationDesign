<template>
<div>

  <el-col :span="20" :offset="2">
    <el-card style="margin-top: 40px">
      <el-form ref="form" :model="healthCare" label-width="100px" :key="key">

        <el-row>
          <el-col :span="6">
            <el-form-item label="姓名">
              <el-input v-model="healthCare.name"></el-input>
            </el-form-item>
          </el-col>

          <el-col :span="6">

            <el-form-item label="性别">
              <el-select v-model="healthCare.sex">
                <el-option v-for="item in healthCareInfo.sexes" :label="item.name" :value="item.name"></el-option>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="6">

            <el-form-item label="民族">
              <el-select v-model="healthCare.ethnicGroup" filterable>
                <el-option v-for="item in healthCareInfo.ethnicgroup" :label="item.name" :value="item.name"></el-option>
              </el-select>
            </el-form-item>
          </el-col>


          <el-col :span="6">
            <el-form-item label="血型">
              <el-select v-model="healthCare.bloodType">
                <el-option v-for="item in healthCareInfo.bloodtype" :label="item.name" :value="item.name"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>


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

        <el-row>
          <el-col :span="6">
            <el-form-item label="职业">
              <el-select v-model="healthCare.work">
                <el-option v-for="item in healthCareInfo.works" :label="item.name" :value="item.name"></el-option>
              </el-select>
            </el-form-item>
          </el-col>



          <el-col :span="18">
            <el-form-item label="工作单位">
              <el-input v-model="healthCare.workplace"></el-input>
            </el-form-item>
          </el-col>
        </el-row>



        <el-form-item label="电话号码">
          <el-input v-model="healthCare.telephone"></el-input>
        </el-form-item>


        <el-row>
          <el-col :span="6">
            <el-form-item label="联系人姓名">
              <el-input v-model="healthCare.contactname"></el-input>
            </el-form-item>
          </el-col>



          <el-col :span="18">
            <el-form-item label="联系人电话">
              <el-input v-model="healthCare.contactphone"></el-input>
            </el-form-item>
          </el-col>
        </el-row>


        <el-row>
          <el-col :span="8">
            <el-form-item label="文化程度">
              <el-select v-model="healthCare.education">
                <el-option v-for="item in healthCareInfo.education" :label="item.name" :value="item.name"></el-option>
              </el-select>
            </el-form-item>
          </el-col>



          <el-col :span="16">
            <el-form-item label="婚姻状况">
              <el-select v-model="healthCare.marriage">
                <el-option v-for="item in healthCareInfo.marriage" :label="item.name" :value="item.name"></el-option>
              </el-select>
            </el-form-item>
          </el-col>

        </el-row>


        <el-row>

          <el-col :span="8">
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
          </el-col>

          <el-col :span="16">
            <el-form-item label="支付方式">
              <el-select v-model="healthCare.pamentmeth">
                <el-option v-for="item in healthCareInfo.pamentmeth" :label="item.name" :value="item.name"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>


        <el-row>

          <el-col :span="8">

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
          </el-col>

          <el-col :span="16">
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
          </el-col>
        </el-row>





        <el-form-item>
          <el-button type="primary" @click="onSubmit">更新</el-button>
          <el-button type="primary" @click="cancelSubmit">取消</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </el-col>

</div>
</template>

<script>
import th from "element-ui/src/locale/lang/th";
import {update} from "script-ext-html-webpack-plugin/lib/elements";
import {updateHealthCard} from "@/api/doctor";

export default {
  props: {
    healthCare:{},
    originalHealthCare: {},
    healthCareInfo:{}
  },
  name: "HealthRecord",
  data() {
    return {
      key: 0,
      playLoad: {},
      editing: false,
      healthCareJSON: '',
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
    this.playLoad = this.$route.query.playLoad;
    const {healthCareInfo,healthrecord} = this.playLoad
    this.healthCare = healthrecord;
    this.healthCareInfo = healthCareInfo;
    this.originalHealthCare = this.healthCare;
    this.healthCareJSON = JSON.stringify(this.healthCare);
  },
  methods: {
    onSubmit() {
      if (JSON.stringify(this.healthCare) != this.healthCareJSON) {
        updateHealthCard(this.healthCare).then(res => {
          this.$notify({
            title: 'Success',
            message: '更新成功',
            type: 'success',
            duration: 2000
          })
        })
      } else {
        this.$notify({
          title: 'error',
          message: '未作出修改',
          type: 'error',
          duration: 2000
        })
      }
    },
    cancelSubmit() {
      this.healthCare = this.originalHealthCare;
      this.key+=1;
      console.log(this.key)
      this.$notify({
        title: 'Info',
        message: '不进行修改',
        type: 'info',
        duration: 2000
      })
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
