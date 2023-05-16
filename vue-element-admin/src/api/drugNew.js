import drugRequest from "@/utils/drugRequest";

/**
 * {
 *
 *   "showapi_res_body": {
 *     "ret_code": "0",
 *     "msg": "查询成功！",
 *     "page": 1,
 *     "maxResult": 10,
 *     "count": 1,
 *     "drugList": [
 *       {
 *         "jx": "丸剂(水丸)",
 *         "zysx": "1.本品宜饭后服。 2.服用本品三天后症状未见改善或加重者，应到医院就诊。 3.对本品过敏者禁用，过敏体质者慎用。 4.本品性状发生改变时禁止使用。 5.儿童必须在成人监护下使用。 6.请将本品放在儿童不能接触的地方。 7.如正在使用其他药品，使用本品前请咨询医师或药师。",
 *         "etyy": "尚不明确",
 *         "zc": "密封。",
 *         "pzwh": "国药准字Z11020957",
 *         "drugName": "同仁堂 泻肝安神丸",
 *         "jj": "外感发热患者忌服；脾胃虚弱便溏者忌服。",
 *         "yfjbrqfnyy": "尚不明确",
 *         "yxq": "48个月。",
 *         "drugId": "59c9aa2f0b5b76e52ff0c440",
 *         "syz": "清肝泻火，重镇安神。用于失眠，心烦，惊悸及神经衰弱。",
 *         "blfy": "",
 *         "spmc": "",
 *         "hypy": "",
 *         "yfyl": "口服。一次6克，一日2次。",
 *         "lryy": "尚不明确",
 *         "xz": "本品为绿褐色的水丸；味微苦。",
 *         "tymc": "泻肝安神丸",
 *         "price": "41.00",
 *         "manu": "北京同仁堂制药有限公司(国产)",
 *         "zxbz": "《中华人民共和国卫生部药品标准》中药成方制剂第四册，标准标号：WS<sub>3</sub>-B-0756-91",
 *         "gg": "6g*12袋",
 *         "zycf": "龙胆、黄芩、栀子（姜炙）、珍珠母、牡蛎、龙骨、柏子仁、酸枣仁（炒）、远志（去心甘草炙）、当归、地黄、麦冬、蒺藜（去刺盐炙）、茯苓、车前子（盐炙）、泽泻（盐炙）、甘草。",
 *         "ywxhzy": "如与其他药物同时使用可能会发生药物相互作用，详情请咨询医师或药师。"
 *       }
 *     ]
 *   }
 * }
 */

export function getDrugInfo(page,id) {
  return drugRequest.get('/drugInfo',{
    params: {
      classifyId: id,
      maxResult: '20',
      page: page
    }
  })
}

export function getClassifyInfo() {
  return drugRequest.get('/classify',{
  })
}



