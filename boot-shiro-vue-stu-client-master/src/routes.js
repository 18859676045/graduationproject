import Test from './views/test/Test.vue'
import Login from './views/Login.vue'
import NotFound from './views/404.vue'
import Home from './views/Home.vue'
import Main from './views/Main.vue'
import UserList from './views/user/UserList.vue'
import PermiList from './views/permission/PermisList.vue'
import RoleList from './views/permission/RoleList.vue'
import DictionaryList from './views/dictionary/DictionaryList.vue'
import OperatingRecord from './views/system/OperatingRecord.vue'
import Statistics from './views/system/Statistics.vue'
import LoginLog from './views/system/LoginLog.vue'
import Ueditor from './views/ueditor.vue'
import InstituteList from './views/institute/InstituteList.vue'
import MajorList from './views/major/MajorList.vue'
import ClazzList from './views/clazz/ClazzList.vue'
import StudentList from './views/student/StudentList.vue'
import TeacherList from './views/teacher/TeacherList.vue'
import CourseList from './views/course/CourseList.vue'
import AccountCenter from './views/account/AccountCenter.vue'
import CourseCenter from './views/coursecenter/CourseCenter.vue'
import GradeCenter from './views/grade/GradeCenter.vue'
import materialsList from './views/materials/list.vue'
import materialsDelList from './views/materials/delList.vue'
import paperManager from './views/exam/paperManager.vue'
import questionManager from './views/exam/questionManager.vue'

let router = [
    {
        path: '/login',
        component: Login,
        name: '',
        hidden: true
    },
    {
        path: '/404',
        component: NotFound,
        name: '',
        hidden: true
    },
    //{ path: '/main', component: Main },
    {
        path: '/',
        component: Home,
        name: '用户管理',
        iconCls: 'icon iconfont icon-yonghurenxiang',//图标样式class
        children: [
            { path: '/main', component: Main, name: '主页', hidden: true },
            { path: '/user/list', component: UserList, name: '用户列表' },
            { path: '/ueditor', component: Ueditor, name: '富文本测试' },
        ]
    },
	{
		path: '/',
		component: Home,
		name: '用户管理',
		iconCls: 'icon iconfont icon-yonghurenxiang',//图标样式class
		children: [
			{ path: '/materials/list', component: materialsList, name: '材料中心' },
			{ path: '/materials/delList', component: materialsDelList, name: '失效文件' }
		]
	},
	{
	    path: '/',
	    component: Home,
	    name: '实习管理',
	    children: [
	        { path: '/paper', component: paperManager, name: '实习管理'},
	        { path: '/question', component: questionManager, name: '消息通知' }
	    ]
	},
    {
        path: '/',
        component: Home,
        name: '权限管理',
        iconCls: 'icon iconfont icon-Slice',
        children: [
            { path: '/perms/list', component: PermiList, name: '菜单列表' },
            { path: '/role/list', component: RoleList, name: '角色权限' },
        ]
    },
    {
        path: '/',
        component: Home,
        name: '数据字典',
        iconCls: 'icon iconfont icon-dic-manager',
        children: [
            { path: '/dict/list', component: DictionaryList, name: '字典属性' },
        ]
    },
	{
	    path: '/',
	    component: Home,
	    name: '学院管理',
	    iconCls: 'icon iconfont icon-dic-manager',
	    children: [
	        { path: '/institute/list', component: InstituteList, name: '学院列表' },
	    ]
	},
	{
	    path: '/',
	    component: Home,
	    name: '专业管理',
	    iconCls: 'icon iconfont icon-dic-manager',
	    children: [
	        { path: '/major/list', component: MajorList, name: '专业列表' },
	    ]
	},
	{
	    path: '/',
	    component: Home,
	    name: '班级管理',
	    iconCls: 'icon iconfont icon-dic-manager',
	    children: [
	        { path: '/clazz/list', component: ClazzList, name: '班级列表' },
	    ]
	},
	{
	    path: '/',
	    component: Home,
	    name: '学生管理',
	    iconCls: 'icon iconfont icon-dic-manager',
	    children: [
	        { path: '/student/list', component: StudentList, name: '学生列表' },
	    ]
	},
	{
	    path: '/',
	    component: Home,
	    name: '老师管理',
	    iconCls: 'icon iconfont icon-dic-manager',
	    children: [
	        { path: '/teacher/list', component: TeacherList, name: '老师列表' },
	    ]
	},
	{
	    path: '/',
	    component: Home,
	    name: '实习管理',
	    iconCls: 'icon iconfont icon-dic-manager',
	    children: [
	        { path: '/course/list', component: CourseList, name: '实习列表' },
			{ path: '/course/center', component: questionManager, name: '消息通知' }
	    ]
	},
	{
	    path: '/',
	    component: Home,
	    name: '个人中心',
	    iconCls: 'icon iconfont icon-dic-manager',
	    children: [
	        { path: '/account/center', component: AccountCenter, name: '个人信息' },
			{ path: '/account/security', component: CourseCenter, name: '密码管理' },
			{ path: '/grade/center', component: CourseCenter, name: '成绩统计' },
			{ path: '/course/mycourse', component: CourseCenter, name: '我的实习' },
			{ path: '/grade/mygrade', component: CourseCenter, name: '我的成绩' }
	    ]
	},
	{
	    path: '/',
	    component: Home,
	    name: '个人中心',
	    iconCls: 'icon iconfont icon-dic-manager',
	    children: [
	    	//尚未开发开发
	        { path: '/grade/center', component: GradeCenter, name: '成绩统计' },
			{ path: '/grade/list', component: GradeCenter, name: '成绩统计' },
			{ path: '/grade/mygrade', component: GradeCenter, name: '成绩统计' },
	    ]
	},
    {
        path: '/',
        component: Home,
        name: '系统管理',
        iconCls: 'icon iconfont icon-xitongguanli',
        children: [
            { path: '/sys/operateRecord', component: OperatingRecord, name: '操作记录' },
            { path: '/sys/loginLog', component: LoginLog, name: '登陆日志' },
            { path: '/sys/statistics', component: Statistics, name: '统计图表' },

        ]
    },
    {
        path: '/',
        component: Home,
        name: 'TEST',
        iconCls: 'icon iconfont icon-ceshi',
        children: [
            { path: '/Test', component: Test, name: '测试页面' },
        ]
    },
    {
        path: '*',
        hidden: true,
        redirect: { path: '/404' }
    }
];


export default router;
