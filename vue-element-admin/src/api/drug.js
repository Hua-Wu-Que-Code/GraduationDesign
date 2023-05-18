import request from "@/utils/request";
import drugRequest from "@/utils/drugRequest";
import LocalRequest from "@/utils/localRequest";


export function fetchDrugList(query) {
  return request.post('/drug/list',{
    page:  query.page,
    limit: query.limit,
    importance: query.importance,
    title: query.title,
    type: query.type
  })
}
export function upgradeStatus(id,status) {
  return request.post('/drug/upgradeStatus',{
    drugid:id,
    status:status
  })
}
export function addDrug(jsonArray) {
  return request.post('/drug/add',{
    json: jsonArray
  })
}

export function addDrugClass(jsonArray) {
  return request.post('/drug/addClass',{
    json: jsonArray
  })
}

export function andDrugDetailInfo(drug) {
  return request.post('/drug/addDetail',{
    drug:drug
  })
}
export function andDrugDetailInfoLocal() {
  return LocalRequest.get('./detail.json')
}

export function SearchDrug(title,type) {
  return request.post('/drug/search',{
    title:title,
    type:type
  })
}
export function ClinicDrugList(query) {
  return request.post('/drug/clinicList',{
    page:  query.page,
    limit: query.limit,
    importance: query.importance,
    title: query.title,
    type: query.type
  })
}
export function DrugSoleList(query) {
  return request.post('/drug/soleList',{
    page:  query.page,
    limit: query.limit,
    importance: query.importance,
    title: query.title,
    type: query.type
  })
}
