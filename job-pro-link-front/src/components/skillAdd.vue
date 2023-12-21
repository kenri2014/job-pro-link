<template>
    <p class="label">スキル</p>
    <el-table :data="skillData" :key="reflush" border :header-cell-style="{ background: '#eef1f4', color: '#606266' }"
        empty-text="データなし">
        <el-table-column prop="name" label="スキル名" width="120" />
        <el-table-column prop="useDuration" label="経験期間" width="120" />
        <el-table-column prop="level" label="レベル" width="120" />
        <el-table-column prop="credentials" label="証書/資格" />
        <el-table-column width="180">
            <template #default="scope">
                <el-button type="primary" @click="handleEdit(scope.$index, scope.row)" class="option">更新</el-button>
                <el-button type="danger" @click="handleDelete(scope.$index)" class="option">削除</el-button>
            </template>
        </el-table-column>
    </el-table>
    <el-button type="primary" plain @click="openDialog" class="addButton">+追加スキル</el-button>

    <el-dialog v-model="addSkill" :title="title" width="30%" draggable :before-close="handleClose">
        <el-form :model="skillDialogData" label-position="top" :rules="rules" ref="skillDialogForms">
            <el-form-item label="スキル名" prop="skillName" style="padding-bottom: 12px;">
                <el-select v-model="skillDialogData.skillName" placeholder="選んでください" class="virtual-scroll-select"
                    :virtual-scroll="true" :virtual-scroll-item-size="30" :virtual-scroll-overscan="10" clearable>
                    <el-option v-for="item in SkillNameList" :key="item.value" :label="item.label"
                        :value="item.value"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="経験期間" prop="useDuration" style="padding-bottom: 12px;">
                <el-input v-model="skillDialogData.useDuration" placeholder="月" class="timeInput"></el-input>
            </el-form-item>

            <el-form-item label="レベル" prop="level" style="padding-bottom: 12px;">
                <el-select v-model="skillDialogData.level" placeholder="選んでください" class="virtual-scroll-select"
                    :virtual-scroll="true" :virtual-scroll-item-size="30" :virtual-scroll-overscan="10" clearable="">
                    <el-option v-for="item in LevelList" :key="item.value" :label="item.label"
                        :value="item.value"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="証書/資格" style="padding-bottom: 12px;">
                <el-row style="width: 100%;" v-for="(item, index) in skillDialogData.arrayCreadentials" :key="item.id">
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

const addSkill = ref(false)

let skillDialogData = reactive({ skillName: '', useDuration: '', level: '', arrayCreadentials: [{ id: 1, data: "" }] })

let skillDialogForms = ref()
let dataNum = 1;

let title = ref("追加スキル")
let skillDataIndex = ref()

let reflush = true

const openDialog = () => { addSkill.value = true, title.value = "追加スキル" }
const SkillNameList = reactive([
    {
        value: 'HTML・CSS',
        label: 'HTML・CSS'
    }, {
        value: 'JavaScript',
        label: 'JavaScript'
    }, {
        value: 'Java',
        label: 'Java'
    }, {
        value: 'C++',
        label: 'C++'
    }, {
        value: 'なし',
        label: 'なし'
    }
]);
const LevelList = reactive([
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

interface Skill {
    name: string,
    useDuration: string,
    level: string,
    credentials: string[]
}

let skillData: Skill[] = reactive([])

const rules = {
    skillName: [{ required: true, message: 'スキルを選択してください', trigger: "change" }],
    useDuration: [{ required: true, message: '経験期間を入力してください', trigger: "blur" }],
    level: [{ required: true, message: 'レベルを選択してください', trigger: "change" }],
}

const handleEdit = (index: number, row: Skill) => {
    addSkill.value = true
    title.value = "更新スキル"

    skillDataIndex.value = index
    skillDialogData.skillName = row.name;
    skillDialogData.useDuration = row.useDuration;
    skillDialogData.level = row.level;
    row.credentials.forEach((item) => {
        skillDialogData.arrayCreadentials.push(
            {
                id: dataNum++,
                data: item
            })
    })
}

const handleDelete = (index: number) => {
    skillData.splice(index, 1);
    reflush = !reflush
}

const deleteInput = (index: number) => {
    if (skillDialogData.arrayCreadentials.length <= 1) {
        return false
    }
    skillDialogData.arrayCreadentials.splice(index, 1)
}

const add = () => {
    skillDialogData.arrayCreadentials.push(
        {
            id: dataNum++,
            data: ""
        })
}

const clearForm = () => {
    skillDialogData.skillName = ""
    skillDialogData.level = ""
    skillDialogData.useDuration = ""
    skillDialogData.arrayCreadentials = []
    setTimeout(() => {
        skillDialogForms.value.clearValidate();
    }, 30);
}

const confirm = async () => {
    await skillDialogForms.value.validate();
    let newArr: string[] = [];
    skillDialogData.arrayCreadentials.forEach((item) => {
        newArr.push(item.data);
    })

    if (title.value == "追加スキル") {
        skillData.push({
            name: skillDialogData.skillName,
            useDuration: skillDialogData.useDuration,
            level: skillDialogData.level,
            credentials: newArr
        })
        reflush = !reflush

    } else if (title.value == "更新スキル") {
        let skillItem = {
            name: skillDialogData.skillName,
            useDuration: skillDialogData.useDuration,
            level: skillDialogData.level,
            credentials: newArr
        }
        skillData[skillDataIndex.value] = skillItem
    }
    clearForm();
    emitter.emit('sendSkillData', skillData)
    addSkill.value = false
}

const handleClose = () => {
    ElMessageBox.confirm('このダイアログを閉じてよろしいですか?', {
        confirmButtonText: '確定',
        cancelButtonText: 'キャンセル',
    }).then(() => {
        addSkill.value = false
    })
    clearForm();
}
</script>

<style scoped>
.label {
    font: 16px "Arial";
    font-weight: 500;
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