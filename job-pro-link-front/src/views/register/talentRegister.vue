<template>
    <div class="talentRegister">
        <el-form :model="talentForm" :rules="rules" ref="talentForms" label-position="top">
            <p class="subtitle">基本情報</p>
            <el-row>
                <el-col :span="6" :xs="24">
                    <el-row>
                        <el-form-item prop="userName" label="ユーザー名(ID)" class="leftForm label">
                            <el-input v-model="talentForm.userName"></el-input>
                        </el-form-item>
                    </el-row>
                    <el-row>
                        <el-form-item prop="mobilePhone" label="電話番号" class="leftForm label">
                            <el-input v-model="talentForm.mobilePhone"></el-input>
                        </el-form-item>
                    </el-row>
                    <el-row>
                        <el-form-item prop="birthday" label="生年月日" class="label">
                            <el-date-picker v-model="talentForm.birthday" type="date" value-format="YYYY-MM-DD"
                                placeholder="生年月日" :disabled-date="disabledbirthdate" style="width: 100%;" clearable />
                        </el-form-item>
                    </el-row>
                </el-col>
                <el-col :span="6" :xs="24" class="right">
                    <el-row>
                        <el-form-item prop="password" label="パスワード" class="rightForm label">
                            <el-input type="password" v-model="talentForm.password" show-password></el-input>
                        </el-form-item>
                    </el-row>
                    <el-row>
                        <el-form-item prop="countryKbn" label="国籍" class="rightForm label">
                            <el-select v-model="talentForm.countryKbn" class="m-1 country">
                                <el-option v-for="item in countrys" :key="item.value" :label="item.label"
                                    :value="item.value" />
                            </el-select>
                        </el-form-item>
                    </el-row>
                    <el-row>
                        <el-form-item prop="genderKbn" label="性別" class="gender label">
                            <el-radio-group v-model="talentForm.genderKbn">
                                <el-radio :label="1">男</el-radio>
                                <el-radio :label="2">女</el-radio>
                            </el-radio-group>
                        </el-form-item>
                    </el-row>
                </el-col>

                <el-col :span="6" :xs="24">
                    <el-form-item label="写真添付" style="padding-left:30px;" class="label">
                        <el-upload class="avatar-uploader" :show-file-list="false" :auto-upload="false"
                            :on-change="handleChange">
                            <img v-if="isShow" :src="talentForm.icon" class="avatar" />
                            <el-icon v-else class="avatar-uploader-icon">
                                <Plus />
                            </el-icon>
                        </el-upload>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="6">
                    <el-form-item prop="email" label="メールアドレス" class="label" style=" width: 59%;">
                        <el-input v-model="talentForm.email"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="7">
                    <el-form-item style=" width: 70%; " label="住所/アドレス" class="label">
                        <el-input v-model="talentForm.address"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="5" class="leftForm">
                    <p class="subtitle">最終教育学歴</p>
                    <el-form-item label="学位" class="label" style="padding-top: 5px;width: 66%;padding-bottom: 10px;">
                        <el-select v-model="talentForm.educationKbn" class="m-1 country" placeholder="学位">
                            <el-option v-for="item in degrees" :key="item.value" :label="item.label" :value="item.value" />
                        </el-select>
                    </el-form-item>
                    <el-form-item label="専攻" class="label" style="width:66%;">
                        <el-input v-model="talentForm.specialty"></el-input>
                    </el-form-item>
                </el-col>

                <el-col :span="10" style="padding: 96px 0px 0px 50px;">
                    <el-row>
                        <el-form-item label="学校" class="label" style="width:44%;">
                            <el-input v-model="talentForm.school"></el-input>
                        </el-form-item>
                    </el-row>

                    <el-row>
                        <el-form-item label="在学期間" class="label" style="margin-top: 10px;">
                            <el-date-picker v-model="talentForm.admissionDate" type="date"
                                :disabled-date="disabledDateStart" value-format="YYYY-MM-DD" placeholder="入校年月日"
                                clearable />
                        </el-form-item>
                        <span style="margin-top: 50px;margin-left: 7px;margin-right: 7px;">—</span>
                        <el-form-item class="label" style="margin-top: 45px;">
                            <el-date-picker v-model="talentForm.graduationDate" type="date" :disabled-date="disabledDateEnd"
                                value-format="YYYY-MM-DD" placeholder="卒業年月日" clearable />
                        </el-form-item>
                    </el-row>
                </el-col>
            </el-row>
            <p class="subtitle">習得能力</p>
            <el-form-item>
                <span class="tableAdd">
                    <skillAdd></skillAdd>
                </span>
            </el-form-item>

            <el-form-item>
                <span class="tableAdd">
                    <languageAdd></languageAdd>
                </span>
            </el-form-item>
            <el-form-item label="自己PR" class="label" style="width: 60%;">
                <el-input v-model="talentForm.description" type="textarea" />
            </el-form-item>

            <p class="subtitle">職務経験</p>
            <el-form-item>
                <span class="tableAdd">
                    <careerAdd></careerAdd>
                </span>
            </el-form-item>
            <el-form-item>
                <span class="tableAdd">
                    <projectAdd></projectAdd>
                </span>
            </el-form-item>
            <el-form-item>
                <span class="tableAdd">
                    <courseAdd></courseAdd>
                </span>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="register" size="large"
                    style="margin-left: 85%;font-size: 16px;">登録</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
  
<script  setup lang="ts">
import { reactive, ref, onMounted } from 'vue';
import { ElMessage } from 'element-plus'
import { Plus } from '@element-plus/icons-vue'
import type { UploadProps } from 'element-plus'
import useUserStore from '@/store/modules/user'
import { ElNotification } from 'element-plus'
import skillAdd from '@/components/skillAdd.vue'
import languageAdd from '@/components/languageAdd.vue'
import careerAdd from '@/components/careerAdd.vue'
import projectAdd from '@/components/projectAdd.vue'
import courseAdd from '@/components/courseAdd.vue';
import emitter from '@/utils/event-bus'
import { useRouter } from 'vue-router'
import dealObjectValue from '@/utils/filter';
import errorHandler from '@/utils/errorHandler';

let useStore = useUserStore();
let talentForms = ref()
let $router = useRouter()
const talentForm = reactive({
    icon: "",
    userName: "",
    password: "",
    email: "",
    birthday: "",
    genderKbn: 1,
    mobilePhone: "",
    countryKbn: "中国",
    address: "",
    educationKbn: "",
    specialty: "",
    admissionDate: "",
    graduationDate: "",
    school: "",
    skills: [],
    languages: [],
    description: "",
    workHistories: [],
    projectHistories: [],
    courses: []
})
const countrys = [
    {
        value: 'アメリカ',
        label: 'アメリカ',
    },
    {
        value: '中国',
        label: '中国',
    },
    {
        value: '日本',
        label: '日本',
    },
    {
        value: '韓国',
        label: '韓国'
    },
    {
        value: 'イギリス',
        label: 'イギリス',
    },]
const degrees = [
    {
        value: '専門学校',
        label: '専門学校',
    },
    {
        value: '修士',
        label: '修士',
    },
    {
        value: '博士',
        label: '博士',
    },
    {
        value: '高等学校',
        label: '高等学校'
    },
]

const disabledbirthdate = (time: Date) => {
    return time.getTime() > Date.now() - 8.64e7;
}

const disabledDateStart = (time: Date) => {
    let endDateVal = talentForm.graduationDate;
    if (endDateVal) {
        return (time.getTime() > new Date(endDateVal).getTime() - 1);
    }
}

const disabledDateEnd = (time: Date) => {
    let beginDateVal = talentForm.admissionDate;
    if (beginDateVal) {
        return (time.getTime() < new Date(beginDateVal).getTime() + 1);
    }
}
onMounted(() => {
    emitter.on('sendSkillData', showSkill);
    emitter.on('sendLanguageData', showLanguage);
    emitter.on('sendCareerData', showCareer);
    emitter.on('sendProjectData', showProject);
    emitter.on('sendCourseData', showCourse);
})
//サブコンポーネントからのデータの受け入れ
const showSkill: (skillData: any) => void = (skillData) => { talentForm.skills = skillData }
const showLanguage: (languageData: any) => void = (languageData) => { talentForm.languages = languageData }
const showCareer: (careerData: any) => void = (careerData) => { talentForm.workHistories = careerData }
const showProject: (projectData: any) => void = (projectData) => { talentForm.projectHistories = projectData }
const showCourse: (courseData: any) => void = (courseData) => { talentForm.courses = courseData }
//写真
let isShow = false
const handleChange: UploadProps['onChange'] = (uploadFile) => {
    if (uploadFile.status !== "ready") return;
    let suffName = uploadFile.name.substring(uploadFile.name.lastIndexOf('.') + 1)
    if (suffName !== 'jpg') {
        ElMessage.error('写真はJPG形式でなければならない!')
        isShow = false
    } else if (uploadFile.size && uploadFile.size / 1024 / 1024 > 2) {
        ElMessage.error('Avatar picture size can not exceed 2MB!')
        isShow = false
    } else {
        isShow = true
        if (isShow) { talentForm.icon = URL.createObjectURL(uploadFile.raw!) }
    }
}
//メールアドレスをチャックする
const reg: RegExp = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/
const validateEmail: (rule: any, value: any, callback: any) => void = (rule, value, callback) => {
    if (!reg.test(value) && value != '') {
        console.log(rule, value)
        callback(new Error('正しいメールアドレスを入力してください！'));
    } else {
        callback()
    }
}
//電話番号をチャックする
const telephoneReg: RegExp = /^1(3[0-9]|4[01456879]|5[0-35-9]|6[2567]|7[0-8]|8[0-9]|9[0-35-9])\d{8}$/
const validateTelephone: (rule: any, value: any, callback: any) => void = (rule, value, callback) => {
    if (!telephoneReg.test(value) && value != '') {
        console.log(rule, value)
        callback(new Error('正しい電話番号を入力してください！'));
    } else {
        callback()
    }
}
//ユーザー名が存在することを確認する
const validateUserName = async (rule: any, value: any, callback: any) => {
    console.log(rule)
    if (value != "") {
        const result = await useStore.nameRule(talentForm.userName);
        if (result.code == "TAL204") {
            callback(new Error("ユーザー名は既にあります。再度入力してください"))
        } else {
            callback()
        }
    } else {
        callback()
    }
};
//パスワードが存在することを確認する
const validatePassword = async (rule: any, value: any, callback: any) => {
    console.log(rule)
    if (value != "") {
        const result = await useStore.passwordRule(talentForm.password);
        if (result.code == "TAL205") {
            callback(new Error("パスワードは既にあります。再度入力してください"))
        } else {
            callback()
        }
    } else {
        callback()
    }
};

const rules = {
    userName: [
        { required: true, message: 'IDを入力してください', trigger: "blur" },
        { validator: validateUserName, trigger: "blur" }],
    password: [
        { required: true, min: 6, message: 'パスワードは少なくとも6文字以上で設定してください。', trigger: "blur" },
        { validator: validatePassword, trigger: "blur" }],
    email: [
        { required: true, message: 'メールアドレスを入力してください', trigger: "blur" },
        { required: true, validator: validateEmail, trigger: "blur" },],
    birthday: [{ required: true, type: 'date', message: '生年月日を選んでください', trigger: "change" }],
    genderKbn: [{ required: true, message: '性別を選んでください', trigger: "change" }],
    mobilePhone: [
        { required: true, message: '電話番号を入力してください', trigger: "blur" },
        { required: true, validator: validateTelephone, trigger: "blur" },],
    countryKbn: [{ required: true, message: '国籍を選んでください', trigger: "change" }],

}

let register = async () => {
    try {
        await talentForms.value.validate();
        const paramData = dealObjectValue(talentForm)
        console.log(paramData)
        //戻り値の取得
        const registResult = await useStore.talentLogin(paramData);
        console.log("userId:" + registResult.data);
        $router.push({ name: "talentShowcase", params: { talentId: registResult.data } });
        ElNotification({
            type: 'success',
            message: '登録できる！ID：' + registResult.data
        })
    } catch (error: any) {
        console.log(error)
        errorHandler(error)
    };
}
</script>
  
<style scoped>
.talentRegister {
    width: 100%;
    height: 100vh;
    margin-left: 7%;
}

.subtitle {
    margin-top: 50px;
    font: bold 18px 'Arial';
    font-weight: 600;
}

.leftForm {
    width: 59%;
    padding-top: 5px;
    padding-bottom: 10px;
}

.rightForm {
    width: 66%;
    padding-top: 5px;
    padding-bottom: 10px;
}

.label {
    font: 18px 'Arial';
    margin-bottom: 10px;
    font-weight: 900;
}

.gender {
    width: 100%;
    padding-bottom: 10px;
}


.country {
    display: block;
    width: 100%;
}

.avatar-uploader .avatar {
    width: 178px;
    height: 178px;
    display: block;
}

.tableAdd {
    width: 60%;
}
</style>
  
<style>
.avatar-uploader .el-upload {
    border: 1px dashed var(--el-border-color);
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
    transition: var(--el-transition-duration-fast);
    margin-top: 8px;
}

.avatar-uploader .el-upload:hover {
    border-color: var(--el-color-primary);
}

.el-icon.avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 120px;
    height: 140px;
    text-align: center;
}

.label {
    .el-form-item__label {
        font: 16px 'Arial';
        margin-bottom: 10px;
        margin-top: 5px;
        font-weight: 500;
    }
}
</style>
