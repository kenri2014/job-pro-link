//axiosの二次包装
import axios from 'axios'
import { ElMessage } from 'element-plus'
import errorHandler from './errorHandler';
let request = axios.create({
    //import.meta.env.VITE_APP_BASE_API
    baseURL: 'http://localhost:8888',
    timeout: 5000,
});

//リクエストインターセプター
request.interceptors.request.use((config) => {
    return config
})
//レスポンス・インターセプター
request.interceptors.response.use(
    (response) => {
        if (response.data.code == "TAL200") {
            return response.data
        }
        ElMessage({
            type: 'error',
            message: response.data.message,
        })
        return Promise.reject(response.data.message)
    },
    (error) => {
        errorHandler(error)
    },
)
export default request
