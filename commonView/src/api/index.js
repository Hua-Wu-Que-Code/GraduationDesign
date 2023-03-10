import request from "@/utils/request";

// 注意：这个文件是设置所有请求方法的
export function Login(form) {
    return request.post('/user/login',{
        username: form.username,
        password: form.password
    })
}

export function upgrade() {
    return request.post('/user/upgrade',{

    })
}