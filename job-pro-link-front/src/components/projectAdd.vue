<template>
    <p class="label">項目経歴</p>
    <el-table :data="projectData" :key="reflush" border :header-cell-style="{ background: '#eef1f4', color: '#606266' }"
        empty-text="データなし">
        <el-table-column prop="projectName" label="項目名" width="140" />
        <el-table-column prop="duration" label="時間" width="210" />
        <el-table-column prop="description" label="項目経歴説明" />
        <el-table-column prop="media" label="作品" />
        <el-table-column width="180">
            <template #default="scope">
                <el-button type="primary" @click="handleEdit(scope.$index, scope.row)" class="option">更新</el-button>
                <el-button type="danger" @click="handleDelete(scope.$index)" class="option">削除</el-button>
            </template>
        </el-table-column>
    </el-table>
    <el-button type="primary" plain @click="openDialog" class="addButton">+追加項目経歴</el-button>

    <el-dialog v-model="addProject" :title="title" width="30%" draggable :before-close="handleClose">
        <el-form :model="projectDialogData" label-position="top" :rules="rules" ref="projectDialogForms">
            <el-form-item label="項目名" prop="projectName" class="input" style="padding-bottom: 12px;">
                <el-input v-model="projectDialogData.projectName" placeholder=""></el-input>
            </el-form-item>

            <el-row style="padding-bottom: 12px;">
                <el-col :span="11" :xs="24" class="left">
                    <el-form-item label="開始時間" prop="startDate">
                        <el-date-picker v-model="projectDialogData.startDate" type="date" placeholder="開始時間"
                            value-format="YYYY-MM-DD" :disabled-date="disabledDateStart" clearable />
                    </el-form-item>
                </el-col>
                <el-col :span="13" :xs="24" class="right">
                    <el-form-item label="終了時間" prop="endDate" class="select">
                        <el-date-picker v-model="projectDialogData.endDate" type="date" placeholder="終了時間"
                            value-format="YYYY-MM-DD" :disabled-date="disabledDateEnd" clearable />
                    </el-form-item>
                </el-col>
            </el-row>

            <el-form-item label="項目経歴説明" prop="description" style="padding-bottom: 12px;">
                <el-input v-model="projectDialogData.description" type="textarea" class="input" />
            </el-form-item>

            <el-form-item label="証書/資格">
                <el-row style="width: 100%;" v-for="(item, index) in projectDialogData.URLList" :key="item.id">
                    <el-col :span="22">
                        <el-input type="input" placeholder="証書/資格" v-model="item.url" style="width: 99%;"
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

const addProject = ref(false)

let projectDialogData = reactive({ projectName: '', startDate: '', endDate: '', description: '', URLList: [{ id: 1, url: "" }] })

let projectDialogForms = ref()

let dataNum = 1;
let title = ref("追加項目経歴")
let projectDataIndex = ref()
let reflush = true

const openDialog = () => { addProject.value = true, title.value = "追加項目経歴" }
interface Project {
    projectName: string,
    duration: string,
    description: string,
    media: string[]
}
interface SendProject {
    projectName: string,
    startDate: string,
    endDate: string,
    description: string,
    media: string[]
}
let projectData: Project[] = reactive([])
let sendProjectData: SendProject[] = reactive([])

const rules = {
    projectName: [{ required: true, message: '職務を入力してください', trigger: "blur" }],
    startDate: [{ required: true, message: '開始時間を選択してください', trigger: "change" }],
    endDate: [{ required: true, message: '終了時間を選択してください', trigger: "change" }],
    description: [{ required: true, message: '職務経歴説明を入力してください', trigger: "blur" }],
}

const handleEdit = (index: number, row: Project) => {
    addProject.value = true
    title.value = "更新項目経歴"
    projectDataIndex.value = index;
    projectDialogData.projectName = row.projectName;
    projectDialogData.startDate = row.duration.split("—")[0];
    projectDialogData.endDate = row.duration.split("—")[1];
    projectDialogData.description = row.description;
    row.media.forEach((item) => {
        projectDialogData.URLList.push(
            {
                id: dataNum++,
                url: item
            })
    })
}

const handleDelete = (index: number) => {
    projectData.splice(index, 1);
    reflush = !reflush
}
const disabledDateStart = (time: Date) => {
    let endDateVal = projectDialogData.endDate;
    if (endDateVal) {
        return time.getTime() > new Date(endDateVal).getTime() - 1 * 24 * 60 * 60 * 1000;
    }
}

const disabledDateEnd = (time: Date) => {
    let beginDateVal = projectDialogData.startDate;
    if (beginDateVal) {
        return (time.getTime() < new Date(beginDateVal).getTime());
    }
}
const deleteInput = (index: number) => {
    if (projectDialogData.URLList.length <= 1) {
        return false
    }
    projectDialogData.URLList.splice(index, 1)
}

const add = () => {
    projectDialogData.URLList.push(
        {
            id: dataNum++,
            url: ""
        })
}

const clearForm = () => {
    projectDialogData.projectName = ""
    projectDialogData.startDate = ""
    projectDialogData.endDate = ""
    projectDialogData.description = ''
    projectDialogData.URLList = []
    setTimeout(() => {
        projectDialogForms.value.clearValidate();
    }, 30);
}

const confirm = async () => {
    await projectDialogForms.value.validate();
    let newArr: string[] = [];
    projectDialogData.URLList.forEach((item) => {
        newArr.push(item.url);
    })
    if (title.value == "追加項目経歴") {
        projectData.push({
            projectName: projectDialogData.projectName,
            duration: projectDialogData.startDate + ' — ' + projectDialogData.endDate,
            description: projectDialogData.description,
            media: newArr
        })

        sendProjectData.push({
            projectName: projectDialogData.projectName,
            startDate: projectDialogData.startDate,
            endDate: projectDialogData.endDate,
            description: projectDialogData.description,
            media: newArr
        })
        reflush = !reflush

    } else {
        let projectItem = {
            projectName: projectDialogData.projectName,
            duration: projectDialogData.startDate + ' — ' + projectDialogData.endDate,
            description: projectDialogData.description,
            media: newArr
        }
        let projectItem2 = {
            projectName: projectDialogData.projectName,
            startDate: projectDialogData.startDate,
            endDate: projectDialogData.endDate,
            description: projectDialogData.description,
            media: newArr
        }
        projectData[projectDataIndex.value] = projectItem
        sendProjectData[projectDataIndex.value] = projectItem2
    }

    clearForm();
    emitter.emit('sendProjectData', sendProjectData)
    addProject.value = false
}

const handleClose = () => {
    ElMessageBox.confirm('このダイアログを閉じてよろしいですか?', {
        confirmButtonText: '確定',
        cancelButtonText: 'キャンセル',
    }).then(() => {
        addProject.value = false
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


.virtual-scroll-select,
.select {
    width: 86%;
    margin-bottom: 3px;
    margin-left: 3px;
}

.input {
    width: 90%;
    margin-bottom: 3px;
}
</style> 