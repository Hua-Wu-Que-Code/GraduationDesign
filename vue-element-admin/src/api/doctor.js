import request from "@/utils/request";


export function fetchDoctorList(query) {
  return request.post('/doctor/list',{
    page:  query.page,
    limit: query.limit,
    importance: query.importance,
    title: query.title,
    type: query.type
  })
}

export function patientList(query) {
  return request.post('/doctor/patientList',{
    page:  query.page,
    limit: query.limit,
    importance: query.importance,
    title: query.title,
    type: query.type
  })
}
