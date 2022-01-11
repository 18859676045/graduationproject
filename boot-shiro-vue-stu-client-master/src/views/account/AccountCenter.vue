
<template>
	<el-row>

        <div class="demo-image__preview" style="padding-top: 30px">
            <el-image
                    style="width: 100px; height: 100px"
                    :src="this.user.photoUrl"
                    :preview-src-list="srcList">
            </el-image>
        </div>


<!--    user用户-->
        <el-descriptions v-if="user.id!=''" class="margin-top" title="用户信息" :column="3" :size="size" border>
<!--user用户-->
<!--            <div v-if="JSON.stringify(this.user)!='{}'">-->
<!--                666-->
<!--            </div>-->
<!--            <div v-if="this.user.id!=''">-->
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-user"></i>
                    <p>用户名</p>
                </template>
                {{ user. username}}
            </el-descriptions-item>
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-user"></i>
                    <p>创建</p>
                </template>
                {{ user. createTime}}
            </el-descriptions-item>
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-user"></i>
                    <p>最后登陆</p>
                </template>
                {{ user. lastLoginTime}}
            </el-descriptions-item>
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-user"></i>
                    <p>名称</p>
                </template>
                {{ user. name}}
            </el-descriptions-item>
<!--            </div>-->
        </el-descriptions>
        <!--            角色-->
        <el-descriptions  v-if="role.id!=''" class="margin-top" title="网站信息" :column="3" :size="size" border>

            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-tickets"></i>
                    网站角色
                </template>
                <el-tag size="small">{{ role.name }}</el-tag>
            </el-descriptions-item>
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-tickets"></i>
                    权限
                </template>
                <el-tag size="small">{{ role.roleDesc }}</el-tag>
            </el-descriptions-item>
        </el-descriptions>

<!--            teacher老师-->
        <el-descriptions  v-if="teacher.id!=''" class="margin-top" title="老师信息" :column="3" :size="size" border>
            <template slot="extra">
                <el-button type="primary" v-on:click="showDialogForm1" size="small">修改老师信息</el-button>
            </template>
            <el-descriptions-item >
                <template slot="label">
                    <i class="el-icon-user"></i>
                    年龄
                </template>
                {{ teacher. age}}
            </el-descriptions-item>
            <el-descriptions-item >
                <template slot="label">
                    <i class="el-icon-user"></i>
                    性别
                </template>
                <p v-if="teacher. sex == 1">男</p>
                <p v-else>女</p>
            </el-descriptions-item>
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-location-outline"></i>
                    email
                </template>
                {{ teacher. email}}
            </el-descriptions-item>
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-mobile-phone"></i>
                    phone
                </template>
                {{ teacher. phone}}
            </el-descriptions-item>
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-tickets"></i>
                    职称
                </template>
                <el-tag size="small">{{ teacher.teacherPost }}</el-tag>
            </el-descriptions-item>
        </el-descriptions>

<!--        教学秘书-->
        <el-descriptions  v-if="secretary.id!=''" class="margin-top" title="教学秘书信息" :column="3" :size="size" border>
            <template slot="extra">
                <el-button type="primary" v-on:click="showDialogForm3" size="small">修改教学秘书信息</el-button>
            </template>
            <el-descriptions-item >
                <template slot="label">
                    <i class="el-icon-user"></i>
                    年龄
                </template>
                {{ secretary. age}}
            </el-descriptions-item>
            <el-descriptions-item >
                <template slot="label">
                    <i class="el-icon-user"></i>
                    性别
                </template>
                <p v-if="secretary. sex == '1'">男</p>
                <p v-else>女</p>
            </el-descriptions-item>
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-location-outline"></i>
                    email
                </template>
                {{ secretary. email}}
            </el-descriptions-item>
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-mobile-phone"></i>
                    phone
                </template>
                {{ secretary. phone}}
            </el-descriptions-item>
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-tickets"></i>
                    管理的专业
                </template>
                <el-tag size="small">{{ major.name }}</el-tag>
            </el-descriptions-item>
        </el-descriptions>

<!--             学生-->
            <el-descriptions v-if="student.id!=''"  class="margin-top" title="学生信息" :column="3" :size="size" border>
                <template slot="extra">
                    <el-button type="primary" v-on:click="showDialogForm2" size="small">修改学生信息</el-button>
                </template>
            <el-descriptions-item >
                <template slot="label">
                    <i class="el-icon-user"></i>
                    年龄
                </template>
                {{ student. age}}
            </el-descriptions-item>
            <el-descriptions-item >
                <template slot="label">
                    <i class="el-icon-user"></i>
                    性别
                </template>
                <p v-if="student. sex == 1">男</p>
                <p v-else>女</p>
            </el-descriptions-item>
            <el-descriptions-item >
                <template slot="label">
                    <i class="el-icon-user"></i>
                    学院
                </template>
                {{ institute.name }}
            </el-descriptions-item>
            <el-descriptions-item >
                <template slot="label">
                    <i class="el-icon-user"></i>
                    专业
                </template>
                {{major.name}}
            </el-descriptions-item>
            <el-descriptions-item >
                <template slot="label">
                    <i class="el-icon-user"></i>
                    班级
                </template>
                {{clazz.name}}
            </el-descriptions-item>
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-location-outline"></i>
                    email
                </template>
                {{ student. email}}
            </el-descriptions-item>
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-mobile-phone"></i>
                    phone
                </template>
                {{ student. phone}}
            </el-descriptions-item>
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-tickets"></i>
                    学号
                </template>
                <el-tag size="small">{{ student.studentNumber }}</el-tag>
            </el-descriptions-item>
        </el-descriptions>






<!-- 修改老师 -->
	<el-dialog title="修改老师信息" :visible.sync="dialogFormVisible1" v-if="teacher.id!=''">
	<div style="width:60%;margin: 0 auto">
	<el-form ref="attr" :model="teacher1" :inline="false" label-width="90px" class="demo-ruleForm">

	<el-form-item label="老师名称" prop="name" :rules="[{ required: true, message: '请输入老师名称', trigger: 'blur' }]">
		<el-input  type="text" v-model="teacher1.name" placeholder="请输入老师名称" auto-complete="off"></el-input>
	</el-form-item>
        <el-form-item label="性别" prop="sex" :rules="[{ required: true, message: '请选择性别', trigger: 'blur' }]">
            <el-select v-model="teacher1.sex" filterable placeholder="请选择">
                <el-option
                        v-for="item in sexs"
                        :key="item.dictCode"
                        :label="item.dictValue"
                        :value="item.dictCode">
                </el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="年龄" prop="age" :rules="[{ required: true, message: '请输入老师年龄', trigger: 'blur' },{validator: 'regexp', pattern: /^(?:[1-9][0-9]?|1[01][0-9]|120)$/, message: '年龄只能是0-120之间的整数', trigger: 'change,blur'}]">
            <el-input  type="number" v-model="teacher1.age" placeholder="请输入老师年龄" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="联系电话" prop="phone" :rules="[{ required: true, message: '请输入老师联系电话', trigger: 'blur' },{validator: 'regexp', pattern: /^[1][3,4,5,7,8,9][0-9]{9}$/, message: '手机号码不正确', trigger: 'change,blur'}]">
            <el-input  type="text" v-model="teacher1.phone" placeholder="请输入老师联系电话" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="老师邮箱" prop="email" :rules="[{ required: true, message: '请输入老师邮箱', trigger: 'blur' }]">
            <el-input  type="text" v-model="teacher1.email" placeholder="请输入老师邮箱" auto-complete="off"></el-input>
        </el-form-item>

	</el-form>
 </div>
	<div slot="footer" class="dialog-footer">
		<el-button @click="dialogFormVisible1 = false">取 消</el-button>
		<el-button type="primary" @click="submitForm('teacher1')">确 定</el-button>
	</div>
    </el-dialog>



<!--修改教学秘书-->
        <el-dialog title="修改秘书信息" :visible.sync="dialogFormVisible3" v-if="secretary.id!=''">
            <div style="width:60%;margin: 0 auto">
                <el-form ref="attr" :model="secretary1" :inline="false" label-width="90px" class="demo-ruleForm">

                    <el-form-item label="秘书名称" prop="name" :rules="[{ required: true, message: '请输入秘书名称', trigger: 'blur' }]">
                        <el-input  type="text" v-model="secretary1.name" placeholder="请输入秘书名称" auto-complete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="性别" prop="sex" :rules="[{ required: true, message: '请选择性别', trigger: 'blur' }]">
                        <el-select v-model="secretary1.sex" filterable placeholder="请选择">
                            <el-option
                                    v-for="item in sexs"
                                    :key="item.dictCode"
                                    :label="item.dictValue"
                                    :value="item.dictCode">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="年龄" prop="age" :rules="[{ required: true, message: '请输入秘书年龄', trigger: 'blur' },{validator: 'regexp', pattern: /^(?:[1-9][0-9]?|1[01][0-9]|120)$/, message: '年龄只能是0-120之间的整数', trigger: 'change,blur'}]">
                        <el-input  type="number" v-model="secretary1.age" placeholder="请输入秘书年龄" auto-complete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="联系电话" prop="phone" :rules="[{ required: true, message: '请输入秘书联系电话', trigger: 'blur' },{validator: 'regexp', pattern: /^[1][3,4,5,7,8,9][0-9]{9}$/, message: '手机号码不正确', trigger: 'change,blur'}]">
                        <el-input  type="text" v-model="secretary1.phone" placeholder="请输入秘书联系电话" auto-complete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="秘书邮箱" prop="email" :rules="[{ required: true, message: '请输入秘书邮箱', trigger: 'blur' }]">
                        <el-input  type="text" v-model="secretary1.email" placeholder="请输入老师邮箱" auto-complete="off"></el-input>
                    </el-form-item>

                </el-form>
            </div>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible3 = false">取 消</el-button>
                <el-button type="primary" @click="submitForm('secretary1')">确 定</el-button>
            </div>
        </el-dialog>



<!-- 修改学生-->
        <el-dialog title="修改信息" :visible.sync="dialogFormVisible2">
            <div style="width:60%;margin: 0 auto">
                <el-form ref="attr" :model="student1" :inline="false" label-width="90px" class="demo-ruleForm">

                    <el-form-item label="所属学院" prop="iid" >
                        <el-select v-model="institute.id" filterable placeholder="请选择" @change="getMajorData">
                            <el-option
                                    v-for="item in institutes"
                                    :key="item.id"
                                    :label="item.name"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="所属专业" prop="mid">
                        <el-select v-model="major.id" filterable placeholder="请选择" @change="getClazzData">
                            <el-option
                                    v-for="item in majors"
                                    :key="item.id"
                                    :label="item.name"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="所属班级" prop="cid" :rules="[{ required: true, message: '请输入班级', trigger: 'blur' }]">
                        <el-select v-model="clazz.id" filterable placeholder="请选择">
                            <el-option
                                    v-for="item in clazzs"
                                    :key="item.id"
                                    :label="item.name"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="姓名" prop="name" :rules="[{ required: true, message: '请输入学生姓名', trigger: 'blur' }]">
                        <el-input  type="text" v-model="student1.name" placeholder="请输入学生姓名" auto-complete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="学号" prop="studentNumber" :rules="[{ required: true, message: '请输入学生学号', trigger: 'blur' }]">
                        <el-input  type="text" v-model="student1.studentNumber" placeholder="请输入学生学号" auto-complete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="邮箱" prop="email" :rules="[{ required: true, message: '请输入邮箱', trigger: 'blur' }]">
                        <el-input  type="text" v-model="student1.email" placeholder="请输入学生邮箱" auto-complete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="性别" prop="sex" :rules="[{ required: true, message: '请输入性别', trigger: 'blur' }]">
                        <el-select v-model="student1.sex" filterable placeholder="请选择">
                            <el-option
                                    v-for="item in sexs"
                                    :key="item.dictCode"
                                    :label="item.dictValue"
                                    :value="item.dictCode">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="年龄" prop="age" :rules="[{ required: true, message: '请输入学生年龄', trigger: 'blur' },{validator: 'regexp', pattern: /^(?:[1-9][0-9]?|1[01][0-9]|120)$/, message: '年龄只能是0-120之间的整数', trigger: 'change,blur'}]">
                        <el-input  type="number" v-model="student1.age" placeholder="请输入学生年龄" auto-complete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="联系电话" prop="phone" :rules="[{ required: true, message: '请输入学生联系电话', trigger: 'blur' },{validator: 'regexp', pattern: /^[1][3,4,5,7,8,9][0-9]{9}$/, message: '手机号码不正确', trigger: 'change,blur'}]">
                        <el-input  type="text" v-model="student1.phone" placeholder="请输入学生联系电话" auto-complete="off"></el-input>
                    </el-form-item>

                </el-form>
            </div>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible2 = false">取 消</el-button>
                <el-button type="primary" @click="submitForm('student1')">确 定</el-button>
            </div>
        </el-dialog>






	</el-row>
</template>

<script>
import http from '../../utils/http'
export default {
	data() {
		return {
            sexs:[],
			filters: {
				keyword1: ''
			},
            institutes:[],    //学院列表
            majors:[],       //专业列表
            clazzs:[],       //班级列表
			dialogFormVisible1: false,
			dialogFormVisible2: false,
            dialogFormVisible3: false,
			innerVisible: false,
			attrIds: [], // 属性ids集合
			detailIds: [], // 属性明细ids
			attrId: '',
            //展示
            role:{
                id: "",
                name: "",
                roleDesc: ""
            },
            teacher:{
                age: 1,
                email: "",
                id: "",
                name: "",
                phone: "",
                sex: 1,
                title: "",
                teacherPost: ""
            },
            teacher1:{
                age: 1,
                email: "",
                id: "",
                name: "",
                phone: "",
                sex: "",
                title: "",
                teacherPost: ""
            },

            user:{
                createTime: "",
                enable: 1,
                id: "",
                lastLoginTime: "",
                name: "",
                password: "",
                username: ""
            },
            secretary:{
                age: 1,
                email: "",
                id: "",
                majorId: "",
                name: "",
                phone: "",
                photoUrl: "",
                sex: "",
                username: "",
            },
            secretary1:{
                age: 1,
                email: "",
                id: "",
                majorId: "",
                name: "",
                phone: "",
                photoUrl: "",
                sex: "",
                username: "教学秘书"
            },
            student:{
                age: 0,
                clazzId: "",
                email: "",
                id: "",
                instituteId: "",
                majorId: "",
                name: "",
                phone: "",
                sex: 1,
                studentNumber: ""
            },
            student1:{
                age: "",
                clazzId: "",
                email: "",
                id: "",
                instituteId: "",
                majorId: "",
                name: "",
                phone: "",
                sex: "",
                studentNumber: ""
            },major:{
                id: "",
                instituteId: "",
                majorNumber: "",
                name: ""
            },institute:{
                id: "",
                instituteNumber: "",
                name: "",
            },clazz:{
                id: "",
                instituteId: "",
                majorId: "",
                name: ""
            }


		}
	},
	methods: {
	    //老师
        showDialogForm1(){
            this.dialogFormVisible1 = true
            this.getSexData()
        },
        //学生
        showDialogForm2(){
            this.dialogFormVisible2 = true
            this.getInstituteData()
            this.getMajorData()
            this.getClazzData()
            this.getSexData()
        },
        showDialogForm3(){
            this.dialogFormVisible3 = true
            this.getSexData()
        },
        // 添加属性表单提交
        submitForm(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    this.editTeacherOrStudent()
                } else {
                    console.log('error submit!!');
                    return false
                }
            })
        },
        async  editTeacherOrStudent(){
            let _this = this
            // let params = {
            //     id: _this.student1.id,
            //     name: _this.student1.name,
            //     studentNumber: _this.student1.studentNumber,
            //     email: _this.student1.email,
            //     sex: _this.student1.sex,
            //     age: _this.student1.age,
            //     phone: _this.student1.phone,
            //     clazzId: _this.clazz.id,
            //     majorId: _this.major.id,
            //     instituteId: _this.institute.id
            // }
            let params={
                //老师
                tid:_this.teacher.id,
                tname:_this.teacher1.name,
                tsex:_this.teacher1.sex,
                tage:_this.teacher1.age,
                tphone:_this.teacher1.phone,
                temail:_this.teacher1.email,
                //教学秘书
                jid:_this.secretary.id,
                jname:_this.secretary1.name,
                jsex:_this.secretary1.sex,
                jage:_this.secretary1.age,
                jphone:_this.secretary1.phone,
                jemail:_this.secretary1.email,
                //学生
                sid:_this.student.id,
                clazzId:_this.clazz.id,
                majorId:_this.clazz.id,
                instituteId:_this.institute.id,
                snumber: _this.student1.studentNumber,
                semail: _this.student1.email,
                ssex: _this.student1.sex,
                sname:_this.student1.name,
                sage:_this.student1.age,
                sphone:_this.student1.phone
            }
            let data = await http.post('account/editMessage', params)

            if(!data.data) {
                return
            }

            if (data.data.status === 200) {
                console.log(data.data)
                _this.message(true,data.data.msg,'success')

            } else {
                _this.message(true,data.data.msg,'error')
                _this.formData2 = []
            }


        },



		// 查询属性
		async getFormData1 () {
			let _this = this
			_this.listLoading = true
            let user = JSON.parse(sessionStorage.getItem('user'))
			let params = {
                id:user.id,
                roleId:user.roleId,
                roleName:user.roleName,
                username:user.username
			}
			let data = await http.get('account/center', params)

			if(!data.data) {
				_this.listLoading = false
				return
			}

			if (data.data.status === 200) {
                let res = data.data.data.map
                console.log(res)
                if (res.role!=null){
                    _this.role = res.role
                }
                if (res.user!=null){
                    _this.user = res.user
                }
                if (res.teacher!=null){
                    _this.teacher = res.teacher
                    _this.teacher.sex = JSON.stringify(res.teacher.sex)

                    _this.teacher1 = Object.assign({},res.teacher)
                    _this.teacher1.sex = Object.assign({},JSON.stringify(res.teacher.sex))
                    // console.log( Object.assign({},JSON.stringify(res.teacher.sex)))
                }
                if (res.teacherPost!=null){
                    _this.teacher.teacherPost = res.teacherPost
                }
                if (res.student!=null){
                    _this.student = res.student
                    _this.student.sex = JSON.stringify(res.student.sex)


                    _this.student1 = Object.assign({},res.student)
                    // _this.student1.sex = Object.assign({},JSON.stringify(res.student.sex))
                    console.log(_this.student1)
                }
                if (res.secretary!=null){
                    _this.secretary = res.secretary
                    _this.secretary1 = Object.assign({},res.secretary)
                }
                if (res.clazz!=null){
                    _this.clazz = res.clazz
                }

                if (res.institute!=null){
                    _this.institute = res.institute
                }
                if (res.major!=null){
                    _this.major = res.major
                }
			} else {
				_this.message(true,data.data.msg,'error')
				_this.formData1 = []
			}
			_this.listLoading = false
		},

        // 查询性别列表
        async getSexData () {
            let _this = this
            let param = {
                dictTypeCode: 'SEX'
            }
            let data = await http.get('dict/findListByDictTypeCode',param)
            if(!data.data) {
                return
            }
            if (data.data.status === 200) {
                _this.sexs = data.data.data
            } else {
                _this.message(true,data.data.msg,'error')
                _this.sexs = []
            }
        },	// 查询学院列表
        async getInstituteData () {
            let _this = this
            let data = await http.get('institute/findAllInstitute')
            if(!data.data) {
                return
            }
            if (data.data.status === 200) {
                _this.institutes = data.data.data
            } else {
                _this.message(true,data.data.msg,'error')
                _this.institutes = []
            }
        },

        //获取专业列表
        async getMajorData (){
            let _this = this
            let param = {
                instituteId: _this.institute.id
            }
            let data = await http.get('major/findAllMajor',param);
            if(!data.data) {
                return
            }
            if (data.data.status === 200) {
                _this.majors = data.data.data
            } else {
                _this.message(true,data.data.msg,'error')
                _this.majors = []
            }
        },

        //获取班级列表
        async getClazzData (){
            let _this = this
            let param = {
                majorId: _this.major.id
            }
            let data = await http.get('clazz/findAllClazz',param);
            if(!data.data) {
                return
            }
            if (data.data.status === 200) {
                _this.clazzs = data.data.data
            } else {
                _this.message(true,data.data.msg,'error')
                _this.clazzs = []
            }
        },
		/**
		 * ifshow: true/false msg: message  type: error/warning/success
		 */
		message(ifshow,msg,type) {
			this.$message({
				showClose: ifshow,
				message: msg,
				type: type
			})
		}
	},
	mounted() {
		this.getFormData1()
	}
}
</script>
