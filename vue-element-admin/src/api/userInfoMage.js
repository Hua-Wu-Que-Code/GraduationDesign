import request from '@/utils/request'

export function fetchList(query) {
  return request.post('/user/list',{
    page:  query.page,
    limit: query.limit,
    importance: query.importance,
    title: query.title,
    type: query.type
  })
}

export function fetchDelete(id) {
  return request.post('/user/delete',{
    id:id
  })
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
