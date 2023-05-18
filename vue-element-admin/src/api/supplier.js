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
export function supplierUpgradeDrug(price,id) {
  return request.post('/drug/supplierUpgradeDrug',{
    price:price,
    drugid:id
  })
}
export function supplierAddDrug(id) {
  return request.post('/drug/supplierAddDrug',{
    drugid:id
  })
}



