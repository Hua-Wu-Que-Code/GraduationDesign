<template>
  <el-col :span="20" :offset="2">
    <el-card style="margin-top: 40px">
      <div class="user-activity">

        <el-form ref="form" :model="form" label-width="100px" class="el-form-exe">
          <el-row>
            <el-col :span="6">
              <el-form-item label="真算时间">
                <el-date-picker
                  v-model="form.date"
                  type="date"
                  placeholder="选择日期">
                </el-date-picker>
              </el-form-item>
            </el-col>

            <el-col :span="8">
              <el-form-item label="患者ID">
                <el-input v-model="form.userid"></el-input>
              </el-form-item>
            </el-col>

            <el-col :span="6">
              <el-form-item label="姓名">
                <el-input v-model="form.name" style="width:200px"></el-input>
              </el-form-item>
            </el-col>
          </el-row>

          <el-form-item label="患者ID">
            <el-input
              type="textarea"
              autosize
              style="width:500px"
              placeholder="输入病情诊断"
              v-model="form.des">
            </el-input>
          </el-form-item>
          <el-form-item
            v-for="(cureorderitems, index) in  form.cureorderitems"
            :label="'药品' + (index+1)"
            :key="cureorderitems.key"
            :prop="'cureorderitems.' + index + '.value'"
          >
            <el-select filterable v-model="cureorderitems.drugid" filterable placeholder="请选择">
              <el-option
                v-for="item in drug"
                :key="item.drug.drugid"
                :label="item.drug.drugname"
                :value="item.drug.drugid">
              </el-option>
            </el-select>
            <el-input placeholder="请输入个数" v-model="cureorderitems.num" style="width:200px;margin-left: 50px">
              <template slot="append">个</template>
            </el-input>
            <el-button style="margin-left: 50px" @click.prevent="removeDomain(cureorderitems)">删除</el-button>
          </el-form-item>

        </el-form>
      </div>
      <div class="addClick">
        <el-button @click="addDomain">新增药品</el-button>
        <el-button @click="submit()">确 定</el-button>
      </div>
    </el-card>
  </el-col>
</template>

<script>

import {formatDate} from "@/utils/dateFormate";
import MedicalExaminationFile from "@/views/doctor/healthExmMage/components/MedicalExaminationFile.vue";
import {findDetailExam, findDetailInfo, insertDetail} from "@/api/exam";
import {id} from "html-webpack-plugin/lib/chunksorter";
import {allDrugs} from "@/api/drug";
import {insertCure} from "@/api/doctor";

export default {
  components: {},
  props: {

  },
  created() {
    allDrugs().then(res => {
      const {data} = res
      this.drug = data
    })
  },
  filters: {
    formatDate(time) {
      var date = new Date(time);
      return formatDate(date, 'yyyy-MM-dd hh:mm');
    }
  },
  methods: {
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    removeDomain(item) {
      var index = this.form.cureorderitems.indexOf(item)
      if (index !== -1) {
        this.form.cureorderitems.splice(index, 1)
      }
    },
    addDomain() {
      this.form.cureorderitems.push({
        drugid: '',
        num:'',
        key: Date.now()
      });
    },
    submit() {
      console.log(this.form)
      insertCure(this.form).then(res => {
        console.log(res)
      })
    },
  },
  data() {
    return {
      drug:[],
      form: {
        cureorderitems: [{
          drugid: '',
          num:''
        }],
      },
      drinksOpt: [],
      exefresOpt:[],
      linteningsOpt:[],
      pharynexOpt:[],
      sexesOpt:[],
      smokesOpt:[],
      sportsOpt:[],
      id: '',
      add: false,
      listQuery: {
        page: 1,
        limit: 20,
        importance: '',
        title: '',
        type: ''
      },
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
.el-form-exe el-form-item {

}
.box-center {
  margin: 0 auto;
  display: table;
}

.text-muted {
  color: #777;
}
.addClick {
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
}
</style>
