import request from "@/utils/request";

export function findDetailExam(query) {
  return request.post('/exam/detail',{
    page:  query.page,
    limit: query.limit,
    importance: query.importance,
    title: query.title,
    type: query.type
  })
}

export function findDetailInfo(query) {
  return request.post('/exam/findDetailInfo')
}

export function insertDetail(data) {
  return request.post('/exam/insert',{
    data:data
  })
}
