<template>
    <p class="label">職務経歴</p>
    <el-table :data="careerData" :key="reflush" border :header-cell-style="{ background: '#eef1f4', color: '#606266' }"
        empty-text="データなし">
        <el-table-column prop="careerName" label="職務" width="140" />
        <el-table-column prop="duration" label="時間" width="210" />
        <el-table-column prop="description" label="職務経歴説明" />
        <el-table-column width="180">
            <template #default="scope">
                <el-button type="primary" @click="handleEdit(scope.$index, scope.row)" class="option">更新</el-button>
                <el-button type="danger" @click="handleDelete(scope.$index)" class="option">削除</el-button>
            </template>
        </el-table-column>
    </el-table>
    <el-button type="primary" plain @click="openDialog" class="addButton">+追加職務経歴</el-button>

    <el-dialog v-model="addCareer" :title="title" width="30%" draggable :before-close="handleClose">
        <el-form :model="careerDialogData" label-position="top" :rules="rules" ref="careerDialogForms">
            <el-form-item label="職務名" prop="careerName" style="padding-bottom: 12px;">
                <el-input v-model="careerDialogData.careerName" placeholder="" class="timeInput"></el-input>
            </el-form-item>
            <el-row style="padding-bottom: 12px;">
                <el-col :span="12" :xs="24" class="left">
                    <el-form-item label="開始時間" prop="startDate" class="select">
                        <el-date-picker v-model="careerDialogData.startDate" type="date" placeholder="開始時間"
                            value-format="YYYY-MM-DD" :disabled-date="disabledDateStart" clearable />
                    </el-form-item>
                </el-col>
                <el-col :span="12" :xs="24" class="right">
                    <el-form-item label="終了時間" prop="endDate" class="select">
                        <el-date-picker v-model="careerDialogData.endDate" type="date" placeholder="終了時間"
                            value-format="YYYY-MM-DD" :disabled-date="disabledDateEnd" clearable />
                    </el-form-item>
                </el-col>
            </el-row>

            <el-form-item label="職務経歴説明" prop="description" style="padding-bottom: 12px;">
                <el-input v-model="careerDialogData.description" type="textarea" />
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


const addCareer = ref(false)

let careerDialogData = reactive({ careerName: '', startDate: '', endDate: '', description: '' })

let careerDialogForms = ref()


let title = ref("追加職務経歴")
let careerDataIndex = ref()

let reflush = true
const openDialog = () => { addCareer.value = true, title.value = "追加職務経歴" }
interface Career {
    careerName: string,
    duration: string,
    description: string
}
interface SendCareer {
    careerName: string,
    startDate: string,
    endDate: string,
    description: string
}

let careerData: Career[] = reactive([])

const disabledDateStart = (time: Date) => {
    let endDateVal = careerDialogData.endDate;
    if (endDateVal) {
        return time.getTime() > new Date(endDateVal).getTime() - 1 * 24 * 60 * 60 * 1000;
    }
}

const disabledDateEnd = (time: Date) => {
    let beginDateVal = careerDialogData.startDate;
    if (beginDateVal) {
        return (time.getTime() < new Date(beginDateVal).getTime());
    }
}

//親コンポーネントに送られるデータ
let sendCareerData: SendCareer[] = reactive([])

const rules = {
    careerName: [{ required: true, message: '職務を入力してください', trigger: "blur" }],
    startDate: [{ required: true, message: '開始時間を選択してください', trigger: "change" }],
    endDate: [{ required: true, message: '終了時間を選択してください', trigger: "change" }],
    description: [{ required: true, message: '職務経歴説明を入力してください', trigger: "blur" }],
}

const handleEdit = (index: number, row: Career) => {
    addCareer.value = true
    title.value = "更新職務経歴"
    careerDataIndex.value = index;
    careerDialogData.careerName = row.careerName;
    careerDialogData.startDate = row.duration.split("—")[0];
    careerDialogData.endDate = row.duration.split("—")[1];
    careerDialogData.description = row.description
}

const handleDelete = (index: number) => {
    careerData.splice(index, 1);
    reflush = !reflush
}

//フォームデータを消去する
const clearForm = () => {
    careerDialogData.careerName = ""
    careerDialogData.startDate = ""
    careerDialogData.endDate = ""
    careerDialogData.description = ""
    setTimeout(() => {
        careerDialogForms.value.clearValidate();
    }, 30);
}


const confirm = async () => {
    await careerDialogForms.value.validate();
    if (title.value == "追加職務経歴") {
        //テーブルの配列にデータを追加する
        careerData.push({
            careerName: careerDialogData.careerName,
            duration: careerDialogData.startDate + ' — ' + careerDialogData.endDate,
            description: careerDialogData.description
        })

        sendCareerData.push({
            careerName: careerDialogData.careerName,
            startDate: careerDialogData.startDate,
            endDate: careerDialogData.endDate,
            description: careerDialogData.description
        })

        reflush = !reflush

    } else {
        let careerItem = {
            careerName: careerDialogData.careerName,
            duration: careerDialogData.startDate + ' — ' + careerDialogData.endDate,
            description: careerDialogData.description
        }
        let careerItem2 = {
            careerName: careerDialogData.careerName,
            startDate: careerDialogData.startDate,
            endDate: careerDialogData.endDate,
            description: careerDialogData.description
        }
        careerData[careerDataIndex.value] = careerItem
        sendCareerData[careerDataIndex.value] = careerItem2
    }
    clearForm();
    emitter.emit('sendCareerData', sendCareerData)
    addCareer.value = false
}
const handleClose = () => {
    ElMessageBox.confirm('このダイアログを閉じてよろしいですか?', {
        confirmButtonText: '確定',
        cancelButtonText: 'キャンセル',
    }).then(() => {
        addCareer.value = false
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
    width: 98%;
    margin-bottom: 3px;
}
</style> 