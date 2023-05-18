/**
 * @description 精确乘法 处理js高精度计算缺陷
 * @param num1
 * @param num2
 * @returns {number}
 */
function accMul(num1, num2) {
  var m = 0, s1 = num1.toString(), s2 = num2.toString();
  try {
    m += s1.split(".")[1].length;
  } catch (e) {
  }
  try {
    m += s2.split(".")[1].length;
  } catch (e) {
  }
  let res=Number(s1.replace(".", "")) * Number(s2.replace(".", ""))
    / Math.pow(10, m);
  if (Math.abs(res) == 0)
  {
    res=0//发现0乘以负数的结果是 -0 稍微处理一下
  }
  return res;
}

export default accMul
