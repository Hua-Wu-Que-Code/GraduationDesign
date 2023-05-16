import request from "@/utils/request";
import drugRequest from "@/utils/drugRequest";


export function fetchDrugList(query) {
  return request.post('/drug/list',{
    page:  query.page,
    limit: query.limit,
    importance: query.importance,
    title: query.title,
    type: query.type
  })
}

export function addDrug(jsonArray) {
  return request.post('/drug/add',{
    jsonArray: jsonArray
  })
}
