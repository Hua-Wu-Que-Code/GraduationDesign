import request from "@/utils/request";


export function fetchSupplierList(query) {
  return request.post('/supplier/list',{
    page:  query.page,
    limit: query.limit,
    importance: query.importance,
    title: query.title,
    type: query.type
  })
}
