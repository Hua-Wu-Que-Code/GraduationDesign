import axios from 'axios'
import { MessageBox, Message } from 'element-ui'
import store from '@/store'
import { getToken } from '@/utils/auth'
import router from '@/router'

// create an axios instance
const service = axios.create({
  baseURL: 'http://drug.market.alicloudapi.com', // url = base url + request url
  // withCredentials: true, // send cookies when cross-domain requests
})
// 请求白名单，如果请求在白名单里面，将不会被拦截校验权限
// request interceptor
service.interceptors.request.use(
  config => {
    // do something before request is sent

    config.headers['Content-Type'] = 'application/json;charset=utf-8'

    config.headers['Authorization'] = 'APPCODE 1cdb65cec93042a09afa8146875f4fae'
    return config
  },
  error => {
    // do something with request error
    console.log(error) // for debug
    return Promise.reject(error)
  }
)

// response interceptor
service.interceptors.response.use(
  /**
   * If you want to get http information such as headers or status
   * Please return  response => response
   */

  /**
   * Determine the request status by custom code
   * Here is just an example
   * You can also judge the status by HTTP Status Code
   */
  response => {
    const res = response.data
    return res
  },
  error => {
    console.log('err' + error) // for debug
    return Promise.reject(error)
  }
)

export default service
