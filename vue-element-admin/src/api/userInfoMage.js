import request from '@/utils/request'

/*查询用户列表*/
export function fetchList(query) {
  return request.post('/user/list',{
    page:  query.page,
    limit: query.limit,
    importance: query.importance,
    title: query.title,
    type: query.type
  })
}
/*删除用户*/
export function fetchDelete(id) {
  return request.post('/user/delete',{
    id:id
  })
}
/*查询用户健康档案*/
export function fetchHealthCare(id) {
  return request.post('/user/fetchMedicalExaminationFile',{
    id:id
  })
}
/*健康档案基础信息*/
export function healthCareInfo() {
  return request.post('/user/healthCareInfo')
}
export function fetchPv(pv) {
  return request({
    url: '/article/pv',
    method: 'get',
    params: { pv }
  })
}


export function createArticle(data) {
  return request({
    url: '/article/create',
    method: 'post',
    data
  })
}

export function updateArticle(data) {
  return request({
    url: '/article/update',
    method: 'post',
    data
  })
}
