<template>
  <el-col :span="20" :offset="2">
    <el-card style="margin-top: 40px">
      <div class="user-activity">





        <el-form ref="form" :model="form" label-width="100px" class="el-form-exe">
          <el-row>
            <el-col :span="6">
              <el-form-item label="体检时间">
                <el-date-picker
                  v-model="form.date"
                  type="date"
                  placeholder="选择日期">
                </el-date-picker>
              </el-form-item>
            </el-col>

            <el-col :span="9">
              <el-form-item label="患者ID">
                <el-input v-model="form.userid"></el-input>
              </el-form-item>
            </el-col>

          </el-row>


          <el-row>
            <el-col :span="6">
              <el-form-item label="姓名">
                <el-input v-model="form.username" style="width:200px"></el-input>
              </el-form-item>
            </el-col>

            <el-col :span="6">

              <el-form-item label="性别">
                <el-select v-model="form.sexid" placeholder="请选择">
                  <el-option
                    v-for="item in sexesOpt"
                    :key="item.id"
                    :label="item.name"
                    :value="item.id">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>

            <el-col :span="6">
              <el-form-item label="体温">
                <el-input v-model="form.temperature" style="width:200px"></el-input>
              </el-form-item>
            </el-col>

            <el-col :span="6">
              <el-form-item label="脉搏">
                <el-input v-model="form.pulse" style="width:200px"></el-input>
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :span="6">
              <el-form-item label="左侧收缩压">
                <el-input v-model="form.lsbp"></el-input>
              </el-form-item>
            </el-col>

            <el-col :span="6">
              <el-form-item label="左侧舒缓压力">
                <el-input v-model="form.lsrp" ></el-input>
              </el-form-item>
            </el-col>

            <el-col :span="6">
              <el-form-item label="右侧收缩压">
                <el-input v-model="form.rsbp" ></el-input>
              </el-form-item>
            </el-col>

            <el-col :span="6">
              <el-form-item label="右侧舒缓压">
                <el-input v-model="form.rsrp"></el-input>
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :span="6">
              <el-form-item label="身高">
                <el-input v-model="form.hight"></el-input>
              </el-form-item>
            </el-col>

            <el-col :span="6">
              <el-form-item label="体重">
                <el-input v-model="form.weight" ></el-input>
              </el-form-item>
            </el-col>

            <el-col :span="6">
              <el-form-item label="体质指数">
                <el-input v-model="form.bmi" ></el-input>
              </el-form-item>
            </el-col>

            <el-col :span="6">
              <el-form-item label="腰围">
                <el-input v-model="form.waistline"></el-input>
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :span="6">
              <el-form-item label="左眼视力">
                <el-input v-model="form.lacuity"></el-input>
              </el-form-item>
            </el-col>

            <el-col :span="6">
              <el-form-item label="左眼矫正视力">
                <el-input v-model="form.clv" ></el-input>
              </el-form-item>
            </el-col>

            <el-col :span="6">
              <el-form-item label="右眼视力">
                <el-input v-model="form.racuity" ></el-input>
              </el-form-item>
            </el-col>

            <el-col :span="6">
              <el-form-item label="右眼矫正视力">
                <el-input v-model="form.crv"></el-input>
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :span="6">
              <el-form-item label="饮酒">
                <el-select v-model="form.drinkid" placeholder="请选择">
                  <el-option
                    v-for="item in drinksOpt"
                    :key="item.id"
                    :label="item.name"
                    :value="item.id">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>

            <el-col :span="6">
              <el-form-item label="抽烟">
                <el-select v-model="form.smokeid" placeholder="请选择">
                  <el-option
                    v-for="item in smokesOpt"
                    :key="item.id"
                    :label="item.name"
                    :value="item.id">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>

            <el-col :span="6">
              <el-form-item label="锻炼">
                <el-select v-model="form.exefreid" placeholder="请选择">
                  <el-option
                    v-for="item in exefresOpt"
                    :key="item.id"
                    :label="item.name"
                    :value="item.id">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>

            <el-col :span="6">
              <el-form-item label="听力">
                <el-select v-model="form.lintenid" placeholder="请选择">
                <el-option
                  v-for="item in linteningsOpt"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id">
                </el-option>
              </el-select>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
      </div>
      <div class="addClick">
        <el-button v-if="add" @click="submit()">确 定</el-button>
      </div>
    </el-card>
  </el-col>
</template>

<script>

import {formatDate} from "@/utils/dateFormate";
import MedicalExaminationFile from "@/views/doctor/healthExmMage/components/MedicalExaminationFile.vue";
import {findDetailExam, findDetailInfo, insertDetail} from "@/api/exam";
import {id} from "html-webpack-plugin/lib/chunksorter";

export default {
  components: {},
  props: {

  },
  created() {
    this.id = this.$route.query.id;
    if (this.id == "addNewExm") {
      findDetailInfo().then(res => {
        const {data} = res
        const {examInfo} = data
        const {drinks,exefres,lintenings,pharynex,sexes,smokes,sports} = examInfo
        this.sexesOpt = sexes;
        this.drinksOpt = drinks;
        this.exefresOpt = exefres;
        this.linteningsOpt = lintenings;
        this.pharynexOpt = pharynex;
        this.smokesOpt = smokes;
        this.sportsOpt = sports;
        this.add = true;
      })
    }
    this.listQuery.limit = this.id;
    findDetailExam(this.listQuery).then(res => {
      const {data} = res
      const {exam,examInfo} = data
      const {drinks,exefres,lintenings,pharynex,sexes,smokes,sports} = examInfo
      this.sexesOpt = sexes;
      this.drinksOpt = drinks;
      this.exefresOpt = exefres;
      this.linteningsOpt = lintenings;
      this.pharynexOpt = pharynex;
      this.smokesOpt = smokes;
      this.sportsOpt = sports;
      this.form = exam;
    })
  },
  filters: {
    formatDate(time) {
      var date = new Date(time);
      return formatDate(date, 'yyyy-MM-dd hh:mm');
    }
  },
  methods: {
    submit() {
      console.log(this.form)
      insertDetail(this.form).then(res => {
        console.log(res)
      })
    },
  },
  data() {
    return {
      drinksOpt: [],
      exefresOpt:[],
      linteningsOpt:[],
      pharynexOpt:[],
      sexesOpt:[],
      smokesOpt:[],
      sportsOpt:[],
      id: '',
      add: false,
      form:{},
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
