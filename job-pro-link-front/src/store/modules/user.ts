import { defineStore } from 'pinia'
import { reqLogin, reqTalentRegister, reqNameRule, reqPasswordRule } from '@/api/user'
import { SET_TOKEN, GET_TOKEN } from '@/utils/token'
import type { LoginFormData, LoginResponseData, TalentRegisterData, RegisterResponseData, NameRuleResponseData, PasswordRuleResponseData } from '@/api/user/type.ts'
import { UserState } from './types/type'


const useUserStore = defineStore('User', {
    state: (): UserState => {
        return {
            token: GET_TOKEN(),
        }
    },

    actions: {
        //ログイン
        async userLogin(data: LoginFormData) {
            const result: LoginResponseData = await reqLogin(data)
            if (result.code == "TAL200") {
                this.token = result.data.token
                SET_TOKEN(result.data.token)
                return Promise.resolve('ok')
            } else {
                return Promise.reject(result.data)
            }
        },
        //登録
        async talentLogin(data: TalentRegisterData) {
            const result: RegisterResponseData = await reqTalentRegister(data)
            if (result.code = "TAL200") {
                return result
            }
            return Promise.reject(result.message)
        },

        async nameRule(data: string) {
            const result: NameRuleResponseData = await reqNameRule(data)
            return result;
        },

        async passwordRule(data: string) {
            const result: PasswordRuleResponseData = await reqPasswordRule(data)
            return result;
        },
    },

    getters: {}
});

export default useUserStore
