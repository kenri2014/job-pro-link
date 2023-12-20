<template>
    <p class="label">言語能力</p>
    <el-table :data="languageData" :key="reflush" border :header-cell-style="{ background: '#eef1f4', color: '#606266' }"
        empty-text="データなし">
        <el-table-column prop="language" label="語種" width="120" />
        <el-table-column prop="conversationLevel" label="会話能力" width="120" />
        <el-table-column prop="readingLevel" label="読解力" width="120" />
        <el-table-column prop="credentials" label="証書/資格" />
        <el-table-column width="180">
            <template #default="scope">
                <el-button type="primary" @click="handleEdit(scope.$index, scope.row)" class="option">更新</el-button>
                <el-button type="danger" @click="handleDelete(scope.$index)" class="option">削除</el-button>
            </template>
        </el-table-column>
    </el-table>
    <el-button type="primary" plain @click="openDialog" class="addButton">+追加言語能力</el-button>

    <el-dialog v-model="addLanguage" :title="title" width="30%" draggable :before-close="handleClose">
        <el-form :model="languageDialogData" label-position="top" :rules="rules" ref="languageDialogForms">
            <el-form-item label="語種" prop="languageName" style="padding-bottom: 12px;">
                <el-select v-model="languageDialogData.languageName" placeholder="選んでください" class="virtual-scroll-select"
                    :virtual-scroll="true" :virtual-scroll-item-size="30" :virtual-scroll-overscan="10" clearable>
                    <el-option v-for="item in languageList" :key="item.value" :label="item.label"
                        :value="item.value"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="会話能力" prop="conversationLevel" style="padding-bottom: 12px;">
                <el-select v-model="languageDialogData.conversationLevel" placeholder="選んでください"
                    class="virtual-scroll-select" :virtual-scroll="true" :virtual-scroll-item-size="30"
                    :virtual-scroll-overscan="10" clearable>
                    <el-option v-for="item in levelList" :key="item.value" :label="item.label"
                        :value="item.value"></el-option>
                </el-select>
            </el-form-item>

            <el-form-item label="読解力" prop="readingLevel" style="padding-bottom: 12px;">
                <el-select v-model="languageDialogData.readingLevel" placeholder="選んでください" class="virtual-scroll-select"
                    :virtual-scroll="true" :virtual-scroll-item-size="30" :virtual-scroll-overscan="10" clearable>
                    <el-option v-for="item in levelList" :key="item.value" :label="item.label"
                        :value="item.value"></el-option>
                </el-select>
            </el-form-item>

            <el-form-item label="証書/資格">
                <el-row style="width: 100%;" v-for="(item, index) in languageDialogData.arrayCreadentials" :key="item.id">
                    <el-col :span="22">
                        <el-input type="input" placeholder="証書/資格" v-model="item.data" style="width: 99%;"
                            clearable></el-input>
                    </el-col>
                    <el-col :span="2">
                        <el-button type="danger" @click="deleteInput(index)" class="deleteInput">-</el-button>
                    </el-col>
                </el-row>
                <el-button class="addCreadentials" @click="add" style="margin-top: 12px;">+追加証書</el-button>
            </el-form-item>
        </el-form>


        <template #footer>
            <span class="dialog-footer">
                <el-button type="primary" @click="confirm">確定</el-button>
                <el-button @click="handleClose">閉じる</el-button>
            </span>
        </template>
    </el-dialog>
</template>
  
<script lang="ts" setup>
import { ref, reactive } from 'vue'
import { ElMessageBox } from 'element-plus'
import emitter from '@/utils/event-bus'

const addLanguage = ref(false)

let languageDialogData = reactive({ languageName: '', conversationLevel: '', readingLevel: '', arrayCreadentials: [{ id: 1, data: "" }] })

let languageDialogForms = ref()
let dataNum = 1;

let title = ref("追加言語能力")
let languageDataIndex = ref()

let reflush = true

const languageList = reactive([
    {
        value: '英語',
        label: '英語'
    }, {
        value: '中国語',
        label: '中国語'
    }, {
        value: '韓国語',
        label: '韓国語'
    }, {
        value: 'スペイン語',
        label: 'スペイン語'
    }, {
        value: '日本語',
        label: '日本語'
    }, {
        value: 'なし',
        label: 'なし'
    }
]);
const levelList = reactive([
    {
        value: '一般',
        label: '一般'
    }, {
        value: '熟練',
        label: '熟練'
    }, {
        value: '精通',
        label: '精通'
    }
]);

interface Language {
    language: string,
    conversationLevel: string,
    readingLevel: string,
    credentials: string[]
}

let languageData: Language[] = reactive([])

const rules = {
    languageName: [{ required: true, message: '語種を選択してください', trigger: "change" }],
    conversationLevel: [{ required: true, message: '会話能力を選択してください', trigger: "change" }],
    readingLevel: [{ required: true, message: '読解力を選択してください', trigger: "change" }],
}
const openDialog = () => { addLanguage.value = true, title.value = "追加言語能力" }

const handleEdit = (index: number, row: Language) => {
    addLanguage.value = true
    title.value = "更新言語能力"

    languageDataIndex.value = index
    languageDialogData.languageName = row.language;
    languageDialogData.conversationLevel = row.conversationLevel;
    languageDialogData.readingLevel = row.readingLevel;
    row.credentials.forEach((item) => {
        languageDialogData.arrayCreadentials.push(
            {
                id: dataNum++,
                data: item
            })
    })
}

const handleDelete = (index: number) => {
    languageData.splice(index, 1);
    reflush = !reflush
}


const deleteInput = (index: number) => {
    if (languageDialogData.arrayCreadentials.length <= 1) {
        return false
    }
    languageDialogData.arrayCreadentials.splice(index, 1)
}

const add = () => {
    languageDialogData.arrayCreadentials.push(
        {
            id: dataNum++,
            data: ""
        })
}

const clearForm = () => {
    languageDialogData.languageName = ""
    languageDialogData.conversationLevel = ""
    languageDialogData.readingLevel = ""
    languageDialogData.arrayCreadentials = []
    setTimeout(() => {
        languageDialogForms.value.clearValidate();
    }, 30);
}

const confirm = async () => {
    await languageDialogForms.value.validate();
    let newArr: string[] = [];
    languageDialogData.arrayCreadentials.forEach((item) => {
        newArr.push(item.data);
    })
    if (title.value == "追加言語能力") {
        languageData.push({
            language: languageDialogData.languageName,
            conversationLevel: languageDialogData.conversationLevel,
            readingLevel: languageDialogData.readingLevel,
            credentials: newArr
        })
        reflush = !reflush
    } else {
        let languageItem = {
            language: languageDialogData.languageName,
            conversationLevel: languageDialogData.conversationLevel,
            readingLevel: languageDialogData.readingLevel,
            credentials: newArr
        }
        languageData[languageDataIndex.value] = languageItem
    }
    clearForm();
    emitter.emit('sendLanguageData', languageData)
    addLanguage.value = false
}
const handleClose = () => {
    ElMessageBox.confirm('このダイアログを閉じてよろしいですか?', {
        confirmButtonText: '確定',
        cancelButtonText: 'キャンセル',
    }).then(() => {
        addLanguage.value = false
    })
    clearForm()
}
</script>

<style scoped>
.label {
    font: 16px "Arial";
    font-weight: 500;
    /* font: bold 18px 'MS Mincho'; */
}

.dialog-footer button:first-child {
    margin-right: 10px;
}

.option {
    width: 70px;
    height: 28px;
    font-size: 13px;
}

.addButton {
    margin-top: 25px;
    height: 35px;
}

.creadentialInput,
.timeInput,
.virtual-scroll-select {
    width: 90%;
    margin-bottom: 3px;
}
</style>  