import { ElMessage } from "element-plus";

export default function errorHandler(error: any) {
    if (error.response) {
        let msg = ''
        let status = error.response.status
        switch (status) {
            case 401:
                msg = 'tokenの有効期限が切れました'
                break
            case 403:
                msg = 'アクセス権限がありません'
                break
            case 404:
                msg = 'リクエスト アドレスエラー'
                break
            case 500:
                msg = 'サーバーエラー'
                break
            default:
                msg = 'ネットワークなし'
        }
        ElMessage({
            type: 'error',
            message: msg,
        })
        return Promise.reject(error)
    } else if (error.request) {
        ElMessage({
            type: 'error',
            message: "リクエストに失敗しました。後でもう一度お試しください。",
        })
    }

}