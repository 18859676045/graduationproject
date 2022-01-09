
<template>
	<el-row>
		<!--工具条-->
		<el-col :span="64" class="toolbar" style="padding-bottom: 0px;with:100%;height:100%">
			<el-form :inline="true" :model="filters" ref="filters">
				<el-form-item>
					<el-input placeholder="学生姓名" v-model="filters.keyword1"></el-input>
				</el-form-item>
				<el-form-item>
					<el-button type="primary" class="el-icon-search" v-on:click="getFormData1">查询</el-button>
				</el-form-item>
				<el-form-item>
					<el-button type="success" class="el-icon-plus" v-on:click="showDialogForm">新增</el-button>
				</el-form-item>
				<el-form-item>
					<el-button type="danger" class="el-icon-delete" @click="delAttr">删除</el-button>
				</el-form-item>
                <el-upload class="upload-demo"
                           :action="uploadUrl2"
                           :before-upload="handleBeforeUpload2"
                           :on-error="handleUploadError"
                           :before-remove="beforeRemove"
                           multiple
                           :limit="1"
                           :on-exceed="handleExceed"
                           accept=".csv, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel"
                           :file-list="fileList">
                    <el-button size="small" type="primary">批量导入用户</el-button>
                </el-upload>
			</el-form>
		</el-col>

		<el-col>
			<el-table
			v-loading="listLoading" element-loading-text="拼命加载中" :data="tableData1" @selection-change="handleSelectionChange1">
			<el-table-column type="selection" width="55">
			</el-table-column>
<!--      <el-table-column
        prop="id"
        label="id">
      </el-table-column> -->
                <el-table-column
                        prop="studentNumber"
                        label="学生学号" sortable>
                </el-table-column>
	  <el-table-column
	    prop="name"
	    label="学生姓名" sortable>
	  </el-table-column>
      <el-table-column
        prop="cname"
        label="实习类型" sortable>
      </el-table-column>
	  <el-table-column
	    prop="score"
	    label="成绩" sortable>
	  </el-table-column>
	  <el-table-column
	    prop="tname"
	    label="实习导师" sortable>
	  </el-table-column>
	  <el-table-column
	    prop="phone"
	    label="学生联系方式" sortable>
	  </el-table-column>
<!--                <template slot-scope="scope">-->
<!--                    <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>-->
<!--                    <el-button type="text" size="small">编辑</el-button>-->
<!--                </template>-->
<!-- 			<el-table-column fixed="right" label="操作" width="180px" align="center">-->
<!--			      <template slot-scope="scope">-->
<!--			      	<el-button @click.native="editOne(scope.row.id)" type="text" size="small">-->
<!--			          编辑-->
<!--			        </el-button>-->
<!--                      <el-button @click.native="selDetails(scope.row.id)" type="text" size="small">-->
<!--                          查看详情-->
<!--                      </el-button>-->
<!--			      </template>-->
<!--			  </el-table-column>-->
                <el-table-column label="操作">
                    <template slot-scope="scope">
                        <el-button
                                size="mini"
                                @click="selDetails(scope.row.id)">详情</el-button>
                    </template>

                </el-table-column>
                <el-table-column label="邮件消息提醒">
                    <template slot-scope="scope">
                        <el-button
                                size="danger"
                                @click="setGrade(scope.row.TEmail)">导师打分</el-button>
                    </template>
                </el-table-column>
                <el-table-column label="邮件消息通知">
                    <template slot-scope="scope">
                        <el-button
                                size="danger"
                                @click="fillIn (scope.row.SEmail)">学生填写信息</el-button>
                    </template>
                </el-table-column>


    </el-table>
		</el-col>

		<el-col>
			<div class="block" style="float: right;margin-right: 10px;margin-top: 10px;">
				<el-pagination
					@size-change="handleSizeChange1"
					@current-change="handleCurrentChange1"
					:current-page="startPage1"
					:page-sizes="pageSizes1"
					:page-size="pageSize1"
					layout="total, sizes, prev, pager, next, jumper"
					:total="total1">
				</el-pagination>
		 </div>
	</el-col>

<!-- 新增属性 -->
	<el-dialog title="新增实习" :visible.sync="dialogFormVisible1">
	<div style="width:60%;margin: 0 auto">
	<el-form ref="attr" :model="attr" :inline="false" label-width="90px" class="demo-ruleForm">
		<el-form-item label="实习类型" prop="courseType2" :rules="[{ required: true, message: '请选择实习类型', trigger: 'change,blur' }]">
			<el-select v-model="attr.courseType2" filterable placeholder="请选择">
				<el-option
					v-for="item in courseTypes"
					:key="item.dictCode"
					:label="item.dictValue"
					:value="item.dictCode">
				</el-option>
			</el-select>
		</el-form-item>
		<el-form-item label="学生姓名" prop="name2" :rules="[{ required: true, message: '请输入学生姓名', trigger: 'blur' }]">
			<el-input  type="text" v-model="attr.name2" placeholder="请输入学生姓名" auto-complete="off"></el-input>
		</el-form-item>
        <el-form-item label="学生学号" prop="name2" :rules="[{ required: true, message: '请输入学生学号', trigger: 'blur' }]">
            <el-input  type="text" v-model="attr.studentNumber" placeholder="请输入学生学号" auto-complete="off"></el-input>
        </el-form-item>
		<el-form-item label="成绩" prop="credit2" :rules="[{ required: true, message: '请输入成绩', trigger: 'blur' },{validator: 'regexp', pattern: /^([1-9][0-9]{0,1}|100)$/, message: '成绩只能是1-100之间的整数', trigger: 'change,blur'}]">
			<el-input  type="number" v-model="attr.credit2" placeholder="请输入成绩" auto-complete="off"></el-input>
		</el-form-item>
		<el-form-item label="实习导师" prop="teacherIds" :rules="[{ required: true, message: '至少选择一名实习导师', trigger: 'change,blur' }]">
			<el-select v-model="attr.teacherIds" multiple filterable placeholder="请选择实习导师">
				<el-option
					v-for="item in teachers"
					:key="item.id"
					:label="item.name"
					:value="item.id">
				</el-option>
			</el-select>
		</el-form-item>

	</el-form>
 </div>
	<div slot="footer" class="dialog-footer">
		<el-button @click="dialogFormVisible1 = false">取 消</el-button>
		<el-button @click="resetForm('attr')">重置</el-button>
		<el-button type="primary" @click="submitForm('attr')">确 定</el-button>
	</div>
</el-dialog>

        <!-- 详情和修改 -->
        <el-dialog  title="实习学生详情" :visible.sync="dialogDetailEditvisble" width="1100px">
            <div style="width:600px;margin: 0 auto">




                <el-form ref="attr" :model="DetailEditvisbleMessage" :inline="false" label-width="170px" class="demo-ruleForm" label-position="left">
                    <el-form-item label="实习类型" prop="ccourseType" :rules="[{ required: true, message: '请选择实习类型', trigger: 'change,blur' }]">
                        <el-select v-model="DetailEditvisbleMessage.ccourseType" filterable placeholder="请选择">
                            <el-option
                                    v-for="item in courseTypes"
                                    :key="item.dictCode"
                                    :label="item.dictValue"
                                    :value="item.dictCode">
                            </el-option>
                        </el-select>
                    </el-form-item>

                    <el-form-item label="学生姓名" prop="sname" :rules="[{ required: true, message: '请输入学生姓名', trigger: 'blur' }]">
                        <el-input  type="text" v-model="DetailEditvisbleMessage.sname" placeholder="请输入学生姓名" auto-complete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="学生学号" prop="studentNumber" :rules="[{ required: true, message: '请输入学生学号', trigger: 'blur' }]">
                        <el-input  type="text" v-model="DetailEditvisbleMessage.studentNumber" placeholder="请输入学生学号" auto-complete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="学生手机号" prop="sphone" :rules="[{ required: true, message: '请输入学生手机号', trigger: 'blur' }]">
                        <el-input  type="text" v-model="DetailEditvisbleMessage.sphone" placeholder="请输入学生手机号" auto-complete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="学生邮箱" prop="semail" :rules="[{ required: true, message: '请输入学生邮箱', trigger: 'blur' }]">
                        <el-input  type="text" v-model="DetailEditvisbleMessage.semail" placeholder="请输入学生邮箱" auto-complete="off"></el-input>
                    </el-form-item>

                    <el-form-item label="公司名称" prop="gcompanyName">
                        <el-input  type="text" v-model="DetailEditvisbleMessage.gcompanyName" placeholder="请输入公司名称" auto-complete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="学生岗位" prop="gstudentsPost">
                        <el-input  type="text" v-model="DetailEditvisbleMessage.gstudentsPost" placeholder="请输入学生岗位" auto-complete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="公司简介" prop="gcDescribe">
                        <el-input type="textarea" v-model="DetailEditvisbleMessage.gcDescribe" placeholder="公司简介，框可下拉放大"></el-input>
                    </el-form-item>
                    <el-form-item label="校外导师名称" prop="goutSupervisor">
                        <el-input  type="text" v-model="DetailEditvisbleMessage.goutSupervisor" placeholder="请输入校外导师名称" auto-complete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="校外导师岗位" prop="supervisorPost">
                        <el-input  type="text" v-model="DetailEditvisbleMessage.supervisorPost" placeholder="请输入校外导师岗位" auto-complete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="校外导师联系方式" prop="goutorPhone">
                        <el-input  type="text" v-model="DetailEditvisbleMessage.goutorPhone" placeholder="请输入校外导师联系方式" auto-complete="off"></el-input>
                    </el-form-item>


                    <el-form-item label="实习时间" prop="validateTime" >
                        <!--                        <p>组件值：{{ DetailEditvisbleMessage.validateTime }}</p>-->
                        <el-date-picker
                                v-model="DetailEditvisbleMessage.validateTime"
                                type="daterange"
                                range-separator="至"
                                start-placeholder="开始日期"
                                end-placeholder="结束日期"
                                @blur="changePackageTime"
                        >
                        </el-date-picker>
                    </el-form-item>


<!--                    <div v-if="DetailEditvisbleMessage.sid == null">-->
                    <el-form-item label="成绩" prop="score" :rules="[{ required: true, message: '请输入成绩', trigger: 'blur' },{validator: 'regexp', pattern: /^([1-9][0-9]{0,1}|100)$/, message: '成绩只能是1-100之间的整数', trigger: 'change,blur'}]">
                        <el-input  type="number" v-model="DetailEditvisbleMessage.score" placeholder="请输入成绩" auto-complete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="导师评语" prop="teacherEstimate">
                        <el-input type="textarea" v-model="DetailEditvisbleMessage.teacherEstimate" placeholder="导师评语，框可下拉放大"></el-input>
                    </el-form-item>
                    <el-form-item label="实习导师" prop="tid" :rules="[{ required: true, message: '至少选择一名实习导师', trigger: 'change,blur' }]">
                        <el-select v-model="DetailEditvisbleMessage.tid" filterable placeholder="请选择实习导师">
                            <el-option
                                    v-for="item in teachers"
                                    :key="item.id"
                                    :label="item.name"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="导师手机号" prop="tphone" :rules="[{ required: true, message: '请输入导师手机号', trigger: 'blur' }]">
                        <el-input  type="text" v-model="DetailEditvisbleMessage.tphone" placeholder="请输入导师手机号" auto-complete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="导师邮箱" prop="temail" :rules="[{ required: true, message: '请输入导师邮箱', trigger: 'blur' }]">
                        <el-input  type="text" v-model="DetailEditvisbleMessage.temail" placeholder="请输入导师邮箱" auto-complete="off"></el-input>
                    </el-form-item>
<!--                    </div>-->


                </el-form>










            </div>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogDetailEditvisble = false">取 消</el-button>
                <el-button type="primary" @click="submitForm1('submitBigPojo')">提交</el-button>
            </div>
        </el-dialog>






	</el-row>


</template>

<script>
import http from '../../utils/http'
import axios from "_axios@0.16.2@axios";

export default {
	data() {
		return {
		    //上传组件
            isAutoUpload: true,
            uploadUrl: 'http://localhost:8089/file/upload',
            uploadUrl2: 'http://localhost:8089/user/import',
            fileList: [],


            value1: '',
			filters: {
				keyword1: ''
			},
			attr: {
                studentNumber:'',
				name2: '',
				courseType2: '',
				credit2: '',
				teacherIds:[],
				signStime2:'',
				signEtime2:'',
				examStime2:'',
				examEtime2:''
			},
			courseTypes:[],     //实习类型列表
			teachers:[],       //实习导师列表
			listLoading: false, // 加载等待
			pageSizes1: [30, 50, 80, 100],
			pageSizes2: [5, 10],
			startPage1: 1,
			startPage2: 1,
			pageSize1: 30,
			pageSize2: 5,
			total1: 0,
			total2: 0,
			tableData1: [],
			tableData2: [],
			total1: 0,
			total2: 0,
			page1: 1,
			page2: 1,
			dialogTableVisible1: false,
			dialogFormVisible1: false,
            dialogDetailEditvisble:false,
            DetailEditvisbleMessage: {
			    score:'',
                teacherEstimate:'',
                stcId:'',
          //公司表
          gid:'', gcompanyName:'', supervisorPost:'',
          gstudentsPost:'',
          goutSupervisor:'',
          goutorPhone:'',
          gstudnetId:'',
          gcDescribe:'',
          //老师表
          tid:'',
          tname:'',
          tsex:'',
          tage:'',
          ttitle:'',
          temail:'',
          tphotoUrl:'',
          tphone:'',
          //学生表
          sid:'',
          studentNumber:'',
          sname:'',
          ssex:'',
          sage:'',
          sphone:'',
          semail:'',
          sphotoUrl:'',
          sclazzId:'',
          smajorId:'',
          sinstituteId:'',
          //实习表
          cid:'',
          cname:'',
          cstartStime:'',
          cendEtime:'',
          ccourseType:'',
          validateTime:[]
            },

			dialogFormVisible2: false,
			innerVisible: false,
			attrIds: [], // 属性ids集合
			detailIds: [], // 属性明细ids
			attrId: '',
			pickerBeginDateBefore:{
				disabledDate: (time) => {
					let beginDateVal = this.attr.signEtime2;
					if (beginDateVal) {
						return time.getTime() > beginDateVal;
					}
				}
			},
			pickerBeginDateAfter:{
				disabledDate: (time) => {
					let beginDateVal = this.attr.signStime2;
					if (beginDateVal) {
						return time.getTime() < beginDateVal;
					}
				}
			},
			pickerBeginDateBefore2:{
				disabledDate: (time) => {
					let beginDateVal = this.attr.examEtime2;
					if (beginDateVal) {
						return time.getTime() > beginDateVal;
					}
				}
			},
			pickerBeginDateAfter2:{
				disabledDate: (time) => {
					let beginDateVal = this.attr.examStime2;
					if (beginDateVal) {
						return time.getTime() < beginDateVal;
					}
				}
			}
		}
	},
	methods: {

	    //导入
        handleBeforeUpload2(file){
            debugger
            this.fileTemp = file
            let fileName = file.name
            let fileType = fileName.substring(fileName.lastIndexOf('.') + 1);

            // 判断上传文件格式
            if (this.fileTemp) {
                if ((fileType != 'xlsx') && (fileType != 'xls')) {
                    this.$message({
                        type: 'warning',
                        message: '附件格式错误，请删除后重新上传！'
                    })
                    return;
                }
            } else {
                this.$message({
                    type: 'warning',
                    message: '请上传附件！'
                })
                return;
            }

            this.uploadUrl = 'http://localhost:8089/user/import'
            console.log("开始上传，上传的文件为："+file)
            let formData = new FormData();
            formData.append("multipartFiles", file);
            axios({
                method: 'post',
                url: 'http://localhost:8089/user/import',
                data: formData,
                headers: {'Content-Type': 'multipart/form-data' }
            }).then((res) => {
                console.log("文件上传返回："+res)
            }).catch(error => {
                console.log("文件上传异常:"+error)
            })

            // this.uploadUrl ='http://localhost:8089/file/upload'
        },
        //上传异常提醒
        handleUploadError(error, file) {
            console.log("文件上传出错："+error)
            this.$notify.error({
                     title: 'error',
                     message: '上传出错:' +  error,
                     type: 'error',
                     position: 'bottom-right'
                   })
        },
        //移除
        beforeRemove(file, fileList) {
            return this.$confirm(`确定移除 ${ file.name }？`);
        },
        //限制上传数量
        handleExceed(files, fileList) {//当前限制选择 5 个文件，本次选择了 1 个文件，共选择了 2 个文件
            this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
        },



		// 查询属性
		async getFormData1 () {
			let _this = this
			_this.listLoading = true
			let params = {
				startPage: _this.startPage1,
				pageSize: _this.pageSize1,
				name: _this.filters.keyword1
			}
			let data = await http.get('course/list', params)
            console.log(data)

			if(!data.data) {
				_this.listLoading = false
				return
			}

			if (data.data.status === 200) {
				 _this.tableData1 = data.data.data
				 _this.total1 = data.data.total
			} else {
				_this.message(true,data.data.msg,'error')
				_this.formData1 = []
			}
			_this.listLoading = false
		},
		// 显示添加用户窗口
		showDialogForm() {
			this.dialogFormVisible1 = true
			this.getCourseType()
			this.getAllTeacher ()
		},
		// 查询实习类型列表
		async getCourseType () {
				let _this = this
				let param = {
					dictTypeCode:'COURSE_TYPE'
				}
				let data = await http.get('dict/findListByDictTypeCode',param)
				if(!data.data) {
					return
				}
				if (data.data.status === 200) {
				   _this.courseTypes = data.data.data
				 } else {
				  _this.message(true,data.data.msg,'error')
				  _this.courseTypes = []
				}
			},
		// 查询老师列表
		async getAllTeacher () {
				let _this = this
				let data = await http.get('teacher/findAllTeacher')
				if(!data.data) {
					return
				}
				if (data.data.status === 200) {
				   _this.teachers = data.data.data
				 } else {
				  _this.message(true,data.data.msg,'error')
				  _this.teachers = []
				}
			},

		// 添加属性表单提交
		submitForm(formName) {
			this.$refs[formName].validate((valid) => {
				if (valid) {
					this.addCourse()
				} else {
					console.log('error submit!!');
					return false
				}
			})
		},
		// 重置
		resetForm(formName) {
			this.$refs[formName].resetFields();
		},
		// 新增属性
		async addCourse() {
			let _this = this
			let params = {
			    studentNumber: _this.attr.studentNumber,
				name: _this.attr.name2,
				courseType: _this.attr.courseType2,
                score: _this.attr.credit2,
				teacherIds: _this.attr.teacherIds,
			}
			let data = await http.post("course/add", params)

			if(!data.data) {
				return
			}

			if (data.data.status === 200) {
				  _this.resetForm('attr')
				  _this.dialogFormVisible1=false
          _this.message(true,data.data.msg,'success')
					_this.getFormData1()
			} else {
         _this.message(true,data.data.msg,'error')
			}
		},
		// 删除属性提示
		async delAttr () {
			if (this.attrIds.length === 0) {
				 this.message(true,'请选择需要删除的实习','warning')
				 return
			}
			this.$confirm('此操作将永久删除, 是否继续?', '提示', {
				confirmButtonText: '确定',
				cancelButtonText: '取消',
				type: 'warning'
			}).then(() => {
				this.delAttrs()
			}).catch(() => {
				this.message(true,'已取消删除','warning')
			})
		},
		// 删除属性
		async delAttrs() {
      let _this = this
			let params = {
				ids: _this.attrIds
			}
			let data =await http.post('course/delete', params)

			if(!data.data) {
				return
			}

			if (data.data.status === 200) {
				 _this.message(true,data.data.msg,'success')
			} else {
				 _this.message(true,data.data.msg,'error')
			}
			_this.getFormData1()
		},
		// 获取选中集
		handleSelectionChange1(val) {
			this.attrIds = []
			if (val) {
			 val.forEach(row => {
				 this.attrIds.push(row.id)
			 });
		 }
		},
		// 每页大小改变时触发
		handleSizeChange1 (val) {
			this.pageSize1 = val
			this.getFormData1()
		},
		// 当前页码改变时触发
		handleCurrentChange1 (val) {
			this.startPage1 = val
			this.getFormData1()
		},

        //提醒导师打分
        async setGrade(email){
            let _this=this;
		    console.log(email)
            if (email == null){
                _this.message(true,"该用户没有邮箱信息",'error')
            }
            else {

                let params = {
                    email: email,
                }
                let data = await http.post('message/send', params)

                if(!data.data) {
                    return
                }
                if (data.data.status === 200) {
                    _this.message(true,data.data.msg,'success')
                } else {
                    _this.message(true,data.data.msg,'error')
                }
            }
        },
        //提醒学生
        async fillIn(email){
            let _this = this;
		    console.log(email)
            if (email == null){
                _this.message(true,"该用户没有邮箱信息",'error')
            }
            else {
                let params = {
                    email: email,
                }
                let data = await http.post('message/send', params)

                if (!data.data) {
                    return
                }
                if (data.data.status === 200) {
                    _this.message(true, data.data.msg, 'success')
                } else {
                    _this.message(true, data.data.msg, 'error')
                }
            }
        },

        // 实习详情明细
		async selDetails(id) {
		    let _this=this;

            this.dialogDetailEditvisble = true
            this.getCourseType()
            this.getAllTeacher ()
		    console.log(id)
            let params = {
            	id: id,
            }
			let data = await http.get('course/company', params)

			if(!data.data) {
				return
			}
			//this.data ={…res.data.第一个对象名,…res.data.第二个对象名}
			if (data.data.status === 200) {
			    let _data = data.data.data
				 this.DetailEditvisbleMessage = _data
                // let dateArray = new Array();
                // dateArray.push( data.data.data.cstartStime, data.data.data.cendEtime)
                // this.DetailEditvisbleMessage.validateTime = dateArray
               this.$set(this.DetailEditvisbleMessage,"validateTime",[""+_data.cstartStime+"",""+_data.cendEtime+""])

			} else {
				_this.message(true,data.data.msg,'error')
			}
		},
        //编辑提交按钮
        submitForm1(formName){
            console.log(formName)
            console.log(this.DetailEditvisbleMessage)
            //表单验证，后期优化
            // this.$refs[formName].validate((valid) => {
            //     if (valid) {
            //         alert('submit!');
            //     } else {
            //         console.log('error submit!!');
            //         return false;
            //     }
            // });
            this.editBigPojo()
        },
        async editBigPojo(){
            let _this=this;
         // let data2 =   JSON.stringify(this.DetailEditvisbleMessage)
            let params = {
                score:this.DetailEditvisbleMessage.score,
                teacherEstimate:this.DetailEditvisbleMessage.teacherEstimate,
                stcId:this.DetailEditvisbleMessage.stcId,
                //公司表
                gid:this.DetailEditvisbleMessage.gid,
                gcompanyName:this.DetailEditvisbleMessage.gcompanyName,
                supervisorPost:this.DetailEditvisbleMessage.supervisorPost,
                gstudentsPost:this.DetailEditvisbleMessage.gstudentsPost,
                goutSupervisor:this.DetailEditvisbleMessage.goutSupervisor,
                goutorPhone:this.DetailEditvisbleMessage.goutorPhone,
                gstudnetId:this.DetailEditvisbleMessage.gstudnetId,
                gcDescribe:this.DetailEditvisbleMessage.gcDescribe,
                //老师表
                tid:this.DetailEditvisbleMessage.tid,
                tname:this.DetailEditvisbleMessage.tname,
                tsex:this.DetailEditvisbleMessage.tsex,
                tage:this.DetailEditvisbleMessage.tage,
                ttitle:this.DetailEditvisbleMessage.ttitle,
                temail:this.DetailEditvisbleMessage.temail,
                tphotoUrl:this.DetailEditvisbleMessage.tphotoUrl,
                tphone:this.DetailEditvisbleMessage.tphone,
                //学生表
                sid:this.DetailEditvisbleMessage.sid,
                studentNumber:this.DetailEditvisbleMessage.studentNumber,
                sname:this.DetailEditvisbleMessage.sname,
                ssex:this.DetailEditvisbleMessage.ssex,
                sage:this.DetailEditvisbleMessage.sage,
                sphone:this.DetailEditvisbleMessage.sphone,
                semail:this.DetailEditvisbleMessage.semail,
                sphotoUrl:this.DetailEditvisbleMessage.sphotoUrl,
                sclazzId:this.DetailEditvisbleMessage.sclazzId,
                smajorId:this.DetailEditvisbleMessage.smajorId,
                sinstituteId:this.DetailEditvisbleMessage.sinstituteId,
                //实习表
                cid:this.DetailEditvisbleMessage.cid,
                courseId:this.DetailEditvisbleMessage.cid,
                cname:this.DetailEditvisbleMessage.cname,
                // cstartStime:this.DetailEditvisbleMessage.cstartStime,
                // cendEtime:this.DetailEditvisbleMessage.cendEtime,
                ccourseType:this.DetailEditvisbleMessage.ccourseType,
                validateTime:this.DetailEditvisbleMessage.validateTime
            }
            let data = await http.post("course/editBigPojo",params )

            if(!data.data) {
                return
            }

            if (data.data.status === 200) {
                _this.resetForm('attr')
                _this.dialogFormVisible1=false
                _this.message(true,data.data.msg,'success')
                _this.getFormData1()
            } else {
                _this.message(true,data.data.msg,'error')
            }
        },

		// 获取选中集
		handleSelectionChange2(val) {
			this.detailIds = []
			if (val) {
			 val.forEach(row => {
				 this.detailIds.push(row.id)
			 });
		 }
		},
		// 每页大小改变时触发
		handleSizeChange2 (val) {
			this.pageSize2 = val
			this.selDetails(this.attrId)
		},
		// 当前页码改变时触发
		handleCurrentChange2 (val) {
			this.startPage2 = val
			this.selDetails(this.attrId)
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
