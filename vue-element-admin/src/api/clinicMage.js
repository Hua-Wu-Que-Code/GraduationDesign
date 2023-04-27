import request from "@/utils/request";


export function fetchClinicList(query) {
  return request.post('/clinic/list',{
    page:  query.page,
    limit: query.limit,
    importance: query.importance,
    title: query.title,
    type: query.type
  })
}
