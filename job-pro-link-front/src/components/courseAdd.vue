<template>
    <p class="label">研修履歴</p>
    <el-table :data="courseData" :key="reflush" border :header-cell-style="{ background: '#eef1f4', color: '#606266' }"
        empty-text="データなし">
        <el-table-column prop="courseName" label="研修内容" width="140" />
        <el-table-column prop="attendance" label="受講状況" width="140" />
        <el-table-column prop="startDate" label="受講日" width="200" />
        <el-table-column prop="pass" label="受講結果" />
        <el-table-column width="180">
            <template #default="scope">
                <el-button type="primary" @click="handleEdit(scope.$index, scope.row)" class="option">更新</el-button>
                <el-button type="danger" @click="handleDelete(scope.$index)" class="option">削除</el-button>
            </template>
        </el-table-column>
    </el-table>
    <el-button type="primary" plain @click="openDialog" class="addButton">+追加研修履歴</el-button>

    <el-dialog v-model="addCourse" :title="title" width="30%" draggable :before-close="handleClose">
        <el-form :model="courseDialogData" label-position="top" :rules="rules" ref="courseDialogForms">
            <el-form-item label="研修内容" prop="courseName" style="padding-bottom: 12px;">
                <el-input v-model="courseDialogData.courseName" placeholder="" class="timeInput"></el-input>
            </el-form-item>

            <el-row style="padding-bottom: 12px;">
                <el-col :span="12" :xs="24" class="left">
                    <el-form-item prop="attendance" label="受講状況" style="margin-top: 20px;">
                        <el-radio-group v-model="courseDialogData.attendance">
                            <el-radio :label="'受講'">受講</el-radio>
                            <el-radio :label="'受講しない'">受講しない</el-radio>
                        </el-radio-group>
                    </el-form-item>
                </el-col>
                <el-col :span="12" :xs="24" class="right">
                    <el-form-item label="受講日" prop="startDate" class="select" style="margin-top: 20px;">
                        <el-date-picker v-model="courseDialogData.startDate" type="date" placeholder="受講日"
                            value-format="YYYY-MM-DD" :disabled-date="disableddate" clearable />
                    </el-form-item>
                </el-col>
            </el-row>

            <el-form-item label="受講結果" prop="pass" style="padding-bottom: 12px;">
                <el-input v-model="courseDialogData.pass" placeholder="合格/不合格" />
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

const addCourse = ref(false)

let courseDialogData = reactive({ courseName: '', attendance: '', startDate: '', pass: '' })

let courseDialogForms = ref()


let title = ref("追加研修履歴")

const openDialog = () => { addCourse.value = true, title.value = "追加研修履歴" }
let courseDataIndex = ref()
let reflush = true

interface Course {
    courseName: string,
    attendance: string,
    startDate: string,
    pass: string
}

let courseData: Course[] = reactive([])

const disableddate = (time: Date) => {
    return time.getTime() > Date.now() - 8.64e7;
}

const validatePass: (rule: any, value: any, callback: any) => void = (rule, value, callback) => {
    if (value != '') {
        console.log(rule, value)
        if (value != '合格' && value != '不合格') {
            callback(new Error('"合格"か"不合格"しか入力できない'));
        } else {
            callback()
        }
    } else {
        callback()
    }
}

const rules = {
    courseName: [{ required: true, message: '研修内容を入力してください', trigger: "blur" }],
    startDate: [{ required: true, message: '受講日を選択してください', trigger: "change" }],
    attendance: [{ required: true, message: '受講状況を選択してください', trigger: "change" }],
    pass: [{ required: true, message: '研修結果を入力してください', trigger: "blur" },
    { validator: validatePass, trigger: "blur" }],
}

const handleEdit = (index: number, row: Course) => {
    addCourse.value = true
    title.value = "更新研修履歴"
    courseDataIndex.value = index
    courseDialogData.courseName = row.courseName;
    courseDialogData.attendance = row.attendance
    courseDialogData.startDate = row.startDate
    courseDialogData.pass = row.pass
}

const handleDelete = (index: number) => {
    courseData.splice(index, 1);
    reflush = !reflush
}

const clearForm = () => {
    courseDialogData.courseName = ""
    courseDialogData.startDate = ""
    courseDialogData.attendance = ""
    courseDialogData.pass = ''
    setTimeout(() => {
        courseDialogForms.value.clearValidate();
    }, 30);
}


const confirm = async () => {
    await courseDialogForms.value.validate();
    if (title.value == "追加研修履歴") {
        console.log(1111)
        courseData.push({
            courseName: courseDialogData.courseName,
            attendance: courseDialogData.attendance,
            startDate: courseDialogData.startDate,
            pass: courseDialogData.pass
        })
        reflush = !reflush
    } else {
        let courseItem = {
            courseName: courseDialogData.courseName,
            attendance: courseDialogData.attendance,
            startDate: courseDialogData.startDate,
            pass: courseDialogData.pass
        }
        courseData[courseDataIndex.value] = courseItem
    }
    clearForm();
    emitter.emit('sendCourseData', courseData)
    addCourse.value = false
}

const handleClose = () => {
    ElMessageBox.confirm('このダイアログを閉じてよろしいですか?', {
        confirmButtonText: '確定',
        cancelButtonText: 'キャンセル',
    }).then(() => {
        addCourse.value = false
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