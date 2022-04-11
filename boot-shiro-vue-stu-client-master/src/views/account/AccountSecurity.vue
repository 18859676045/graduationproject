
<template>


        <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" >
            <el-form-item label="原密码" prop="formerPass">
                <el-input  type="password"  placeholder="请输入原密码" auto-complete="off" v-model="ruleForm.formerPass" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="pass">
                <el-input  type="password"  placeholder="密码以字母开头，长度在6~18之间，只能包含字符、数字和下划线" auto-complete="off" v-model="ruleForm.pass" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="确认密码" prop="checkPass">
                <el-input type="password" placeholder="与新密码一致" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
        </el-form>


</template>

<script>
import http from '../../utils/http'
import md5 from "_js-md5@0.7.3@js-md5";
export default {
	data() {
        var checkAge = (rule, value, callback) => {
            if (!value) {
                return callback(new Error('年龄不能为空'));
            }
            setTimeout(() => {
                if (!Number.isInteger(value)) {
                    callback(new Error('请输入数字值'));
                } else {
                    if (value < 18) {
                        callback(new Error('必须年满18岁'));
                    } else {
                        callback();
                    }
                }
            }, 1000);
        };
        var validatePass = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请输入密码'));
            } else {
                if (this.ruleForm.checkPass !== '') {
                    this.$refs.ruleForm.validateField('checkPass');
                }
                callback();
            }
        };
        var validatePass2 = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请再次输入密码'));
            } else if (value !== this.ruleForm.pass) {
                callback(new Error('两次输入密码不一致!'));
            } else {
                callback();
            }
        };
		return {
            ruleForm: {
                pass: '',
                checkPass: '',
                age: '',
                formerPass:''
            },
            rules: {
                pass: [
                    { required: true, message: '请输入密码', trigger: 'blur' },
                    {validator: 'regexp', pattern: /^[a-zA-Z]\w{5,17}$/, message: '密码格式不正确', trigger: 'change,blur'}
                ],
                formerPass: [
                    { required: true, message: '请输入原密码', trigger: 'blur' },

                ],
                checkPass: [
                    { required: true, message: '请再次输入密码', trigger: 'blur' },
                    { validator: validatePass2, trigger: 'blur' }
                ],
            }
		}
	},
	methods: {
        submitForm(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    this.update()
                } else {
                    console.log('error submit!!');
                    return false;
                }
            });
        },
        //修改用户密码
        async update(){
            let _this = this
            let params = {
                password: md5(_this.ruleForm.pass),
                formerPass: md5(_this.ruleForm.formerPass),
            }
            let data = await http.post('account/security', params)

            if(!data.data) {
                return
            }

            if (data.data.status === 200) {
                this.message(true,data.data.msg,'success')
                _this.resetForm('ruleForm')
            } else {
                _this.message(true,data.data.msg,'error')
            }
        },
        resetForm(formName) {
            this.$refs[formName].resetFields();
        },
        message(ifshow,msg,type) {
            this.$message({
                showClose: ifshow,
                message: msg,
                type: type
            })
        }
	},
	mounted() {

	}
}
</script>
