
<template>
	<el-row>
		<!--工具条-->
		<el-col :span="64" class="toolbar" style="padding-bottom: 0px;with:100%;height:100%">
			<el-form :inline="true" :model="filters" ref="filters">
				<el-form-item>
					<el-input placeholder="材料名称" v-model="filters.keyword1"></el-input>
				</el-form-item>
				<el-form-item>
					<el-button type="primary" class="el-icon-search" v-on:click="getFormData1">查询</el-button>
				</el-form-item>
                <el-form-item>
                    <el-button type="danger" class="el-icon-delete" v-if="user.roleId != '3'" @click="batchDelete">删除</el-button>
                </el-form-item>

                <el-upload v-if="user.roleId != '3'"
                        class="upload-demo"
                        action="https://jsonplaceholder.typicode.com/posts/"
                        :on-preview="handlePreview"
                        :on-remove="handleRemove"
                        :before-upload="handleBeforeUpload"
                        :on-error="handleUploadError"
                        :before-remove="beforeRemove"
                        multiple
                        :limit="2"
                        :on-exceed="handleExceed"
                        :file-list="fileList">
                    <el-button size="small" type="primary">点击上传</el-button>
                </el-upload>

			</el-form>
		</el-col>

		<el-col>
			<el-table
			v-loading="listLoading" element-loading-text="拼命加载中"
      :data="tableData1"
			@selection-change="handleSelectionChange1">
			<el-table-column type="selection"  width="55"  v-if="user.roleId != '3'">
			</el-table-column>
<!--      <el-table-column
        prop="id"
        label="id">
      </el-table-column> -->
	  <el-table-column
	    prop="fileName"
	    label="文件名称" sortable>
	  </el-table-column>
	  <el-table-column
	    prop="uploadTime"
	    label="上传时间" sortable >
          <template slot-scope="scope">
              <span>{{scope.row.uploadTime, "-", false | dataFormat}}</span>
          </template>
	  </el-table-column>
                <el-table-column
                        prop="size"
                        label="文件大小（B）" sortable>
                </el-table-column>
                <el-table-column
                        prop="uploader"
                        label="上传者" sortable>
                </el-table-column>
                <el-table-column
                        prop="downCount"
                        label="下载次数" sortable>
                </el-table-column>
                <el-table-column
                        prop="lastdownTime"
                        label="最后下载时间" sortable >
                    <template slot-scope="scope">
                        <span v-if="scope.row.lastdownTime">{{scope.row.lastdownTime, "-", false | dataFormat}}</span>
                        <span v-else>尚未下载</span>
                    </template>

                </el-table-column>
<!--                <el-table-column label="预览">-->
<!--                    <template slot-scope="scope">-->
<!--                        <el-button-->
<!--                                size="success"-->
<!--                                @click="preDown (scope.row.id)">预览</el-button>-->
<!--                    </template>-->
<!--                </el-table-column>-->
                <el-table-column label="下载">
                    <template slot-scope="scope">
                        <el-button
                                size="danger"
                                @click="down (scope.row.id)">下载</el-button>
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



	</el-row>


</template>

<script>

import http from '../../utils/http'
import axios from "_axios@0.16.2@axios";
export default {
	data() {
		return {
			filters: {
				keyword1: ''
			},
			attr: {
				name2: '',
				majorId2: '',
				instituteId: ''
			},
            user:JSON.parse(sessionStorage.getItem("user")),
            institutes:[],    //学院列表
			majors:[],       //专业列表
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
			dialogFormVisible2: false,
			innerVisible: false,
			attrIds: [], // 属性ids集合
			detailIds: [], // 属性明细ids
			attrId: ''
		}
	},
	methods: {
       async down(id){
            console.log(id)
            let _this = this

           let params = {
               id:id
           }

            let data = await http.get('materials/dowload',params)
            if(!data.data) {
                return
            }
            if (data.data.status === 200) {
                // alert(data.data.msg);
                _this.message(true,data.data.msg,'success')
                window.location.href=data.data.data
            } else {
                _this.message(true,data.data.msg,'error')
            }
        },
        async preDown(){
            console.log(id)
            let _this = this
            let params = {
                id:id
            }
            let data = await http.get('materials/preDown',params)
            if(!data.data) {
                return
            }
            if (data.data.status === 200) {
                _this.message(true,data.data.msg,'success')
                window.location.href=data.data.data
            } else {
                _this.message(true,"预览失败，稍后再试",'error')
            }
        },

        //测试下载文件(注意web的上下文)
        handleDownLoad() {
            window.location.href = `/file/download?fileName=` + this.form.fileName
        },
        handleExceed(files, fileList) {//当前限制选择 5 个文件，本次选择了 1 个文件，共选择了 2 个文件
            this.$message.warning(`当前限制选择 2 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
        },
        beforeRemove(file, fileList) {
            return this.$confirm(`确定移除 ${ file.name }？`);
        },
        handleUploadError(error, file) {
            console.log("文件上传出错："+error)
            // this.$notify.error({
            //          title: 'error',
            //          message: '上传出错:' +  error,
            //          type: 'error',
            //          position: 'bottom-right'
            //        })
        },
        //上传文件(注意web的上下文)
        handleBeforeUpload(file){
            let user = JSON.parse(sessionStorage.getItem("user"))
            this.uploadUrl = 'http://localhost:8089/materials/upload'
            console.log("开始上传，上传的文件为："+file)
            let formData = new FormData();
            formData.append("myFile", file);
            formData.append("id",user.id)
            console.log("开始上传，上传的文件为："+formData)
            axios({
                method: 'post',
                url: 'http://localhost:8089/materials/upload',
                data: formData,
                headers: {'Content-Type': 'multipart/form-data' }
            }).then((res) => {
                this.getFormData1()
                this.$message({
                    type: 'success',
                    message: '上传成功！'
                })
                console.log("文件上传返回："+res)
            }).catch(error => {
                this.$message({
                    type: 'error',
                    message: '上传失败！'
                })
                console.log("文件上传异常:"+error)
            })

            // this.uploadUrl ='http://localhost:8089/file/upload'
        },
        //导入
        handleBeforeUpload2(file){

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




		// 查询属性
		async getFormData1 () {
			let _this = this
			_this.listLoading = true
			let params = {
				startPage: _this.startPage1,
				pageSize: _this.pageSize1,
				name: _this.filters.keyword1
			}
			let data = await http.get('materials/list', params)

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
			this.getInstituteData()
		},
		// 查询学院列表
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
				instituteId: _this.attr.instituteId2
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

		// 添加属性表单提交
		submitForm(formName) {
			this.$refs[formName].validate((valid) => {
				if (valid) {
					this.addInstitute()
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
		async addInstitute() {
			let _this = this
			let params = {
				name: _this.attr.name2,
				majorId: _this.attr.majorId2,
				instituteId: _this.attr.instituteId2
			}
			let data = await http.post("clazz/add", params)

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
		// 批量删除
		batchDelete () {
			if (this.attrIds.length === 0) {
				 this.message(true,'请选择需要删除的数据','error')
				 return
			}
			this.$confirm('此操作将永久删除该数据, 是否继续?', '提示', {
				confirmButtonText: '确定',
				cancelButtonText: '取消',
				type: 'error'
			}).then(() => {
                this.doDelete()
			}).catch(() => {
				this.message(true,'已取消删除','error')
			})
		},
		// 执行删除操作
		async doDelete () {
			let params = {
				ids: this.attrIds
			}
			let data =await http.post('materials/delete', params)
			if(!data.data) {
				return
			}
			if (data.data.status === 200) {
				 this.message(true,data.data.msg,'success')
			} else {
				 this.message(true,data.data.msg,'error')
			}
			this.getFormData1()
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
        //日期转换器
        formatDate(row, column) {
            // 获取单元格数据
            let data = row[column.property]
            if (this.$MyComm.isEmpty(data)) {
                return ''
            }
            let dt = new Date(data)
            return dt.getFullYear() + '-' + (dt.getMonth() + 1) + '-' + dt.getDate() + ' ' + dt.getHours() + ':' + dt.getMinutes() + ':' + dt.getSeconds()
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
