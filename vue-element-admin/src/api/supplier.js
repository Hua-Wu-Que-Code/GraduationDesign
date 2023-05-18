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
export function SupplierDrugList(query) {
  return request.post('/drug/supplierDrugList',{
    page:  query.page,
    limit: query.limit,
    importance: query.importance,
    title: query.title,
    type: query.type
  })
}


