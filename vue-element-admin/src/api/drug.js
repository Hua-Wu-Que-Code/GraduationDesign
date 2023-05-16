import request from "@/utils/request";


export function fetchDrugList(query) {
  return request.post('/drug/list',{
    page:  query.page,
    limit: query.limit,
    importance: query.importance,
    title: query.title,
    type: query.type
  })
}
