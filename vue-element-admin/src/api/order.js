import request from "@/utils/request";

export function toBuyDrug(Order) {
  return request.post('/order/newOrder',{
    order:Order
  })
}

export function toBuyDrugNoPay(Order) {
  return request.post('/order/newOrderNoPay',{
    order:Order
  })
}
export function ClinicOrderList(query) {
  return request.post('/order/clinicOrderList',{
    page:  query.page,
    limit: query.limit,
    importance: query.importance,
    title: query.title,
    type: query.type
  })

}

export function supplierOrderList(query) {
  return request.post('/order/supplierOrderList',{
    page:  query.page,
    limit: query.limit,
    importance: query.importance,
    title: query.title,
    type: query.type
  })

}

export function upgradeOrderStatus(id,status) {
  return request.post('/order/upgradeOrder',{
    id:id,
    status:status
  })

}
