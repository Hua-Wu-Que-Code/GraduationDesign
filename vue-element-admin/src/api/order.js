import request from "@/utils/request";

export function toBuyDrug(Order) {
  return request.post('/order/newOrder',{
    order:Order
  })
}
