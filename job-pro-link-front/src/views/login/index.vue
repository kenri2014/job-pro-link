<template>
    <div class="login_container">
        <el-row>
            <el-col :span="12" :xs="0"></el-col>
            <el-col :span="12" :xs="24" class="right">
                <el-form class="login_form" action="javascript:;" method="post" :model="loginForm" :rules="rules"
                    ref="loginForms">
                    <h1 class="h1">Login</h1>
                    <el-form-item prop="email">
                        <label for="id" class="label">ID(メールアドレス)</label>
                        <el-input :prefix-icon="User" type="text" v-model="loginForm.email" id="id"></el-input>
                    </el-form-item>
                    <el-form-item prop="password">
                        <label for="password" class="label">Password</label>
                        <el-input :prefix-icon="Lock" type="password" v-model="loginForm.password" id="password"
                            show-password></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button class="login_btn" type="primary" size="default" @click="login">
                            ログイン
                        </el-button>
                    </el-form-item>
                    <hr>
                    <el-form-item>

                        <router-link to="/register/talent" class="a">人材新規登録の場合登録はこちら</router-link><br>
                        <router-link to="/register/company" class="a">企業新規登録の場合 登録はこちら</router-link>

                    </el-form-item>

                </el-form>
            </el-col>
        </el-row>
    </div>
</template>

<script setup lang="ts">
import { reactive, ref } from 'vue'
import { useRouter } from 'vue-router'
import { ElNotification } from 'element-plus'
import { Lock, User } from '@element-plus/icons-vue'
import useUserStore from '@/store/modules/user'
import errorHandler from "@/utils/errorHandler";

//メールアドレス　正則表現 
let reg: RegExp = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/

let useStore = useUserStore();

let loginForm = reactive({ email: '', password: '' })
let $router = useRouter();

let loginForms = ref()

let loading = ref(false)
const validateEmail: (rule: any, value: any, callback: any) => void = (rule, value, callback) => {
    if (!reg.test(value) && value != '') {
        console.log(rule, value)
        callback(new Error('正しいメールアドレスを入力してください！'));
    } else {
        callback();
    }
}

const rules = {
    email: [
        { required: true, message: 'IDを入力してください', trigger: "blur" },
        { required: true, validator: validateEmail, trigger: "blur" }
    ],
    password: [{ required: true, min: 6, message: 'パスワードは最低六桁入力してください', trigger: "blur" },]
}


const login = async () => {
    await loginForms.value.validate();
    loading.value = true;
    try {
        await useStore.userLogin(loginForm);
        $router.push('/');
        ElNotification({
            type: 'success',
            message: 'ログインできる'
        })
    } catch (error) {
        console.log(error)
        errorHandler(error)
    } finally {
        loading.value = false
    }
}
</script>

<style scoped>
.right {
    display: flex;
    justify-content: center;
}

.login_container {
    width: 100%;
    height: 100vh;
    background-image: url('@/assets/images/background.jpg');
    background-size: cover;


    .login_form {
        position: relative;
        top: 10vh;
        width: 60%;
        background-image: url('@/assets/images/login_form.png');
        background-size: cover;
        padding: 50px;


        .h1 {
            font-size: 50px;
            text-align: center;
            margin-top: 3%;
            margin-bottom: 30px;
        }


        .label {
            font: 18px 'MS Mincho';
            margin-bottom: 10px;
        }
    }

    .login_btn {
        width: 85%;
        margin: 10px auto 10px 7%;
    }

    .a {
        display: inline-block;
        text-decoration: none;
        color: black;
        padding-top: 8px;
        margin-left: 20%;
    }

    .a:hover {
        font-size: 16px;
    }
}
</style>


