<template>
  <div class="user-activity">
    <div class="post" v-for="i in MedicalExaminationFile">
      <div class="user-block">
        <img class="img-circle" :src=i.src>
        <span class="username text-muted">{{i.nickname}}</span>
        <span class="date">{{i.date}}</span>
      </div>
      <p class="text">
          {{i.description}}
      </p>
    </div>
  </div>
</template>

<script>

export default {
  props: {
    MedicalExaminationFile: []
  },
  created() {

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
