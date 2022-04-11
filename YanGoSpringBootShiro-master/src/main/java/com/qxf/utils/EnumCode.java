package com.qxf.utils;

/**
 * @Auther: qiuxinfa
 * @Date: 2019/11/15
 * @Description: com.qxf.utils
 */
public enum  EnumCode {
    /**
     * 200请求成功
     */
    OK(200, "请求成功，修改功能请重新登陆生效"),
    /**
     * 666
     */
    NO_Count(666,"您没有录入成绩"),
    /**
     * 665
     */
    NO_PERSON(665,"查询失败，没有用户"),
    /**
     * 664
     */
    delete_error(664,"删除失败"),
    /**
     *错误的邮箱
     */
    BAD_EMAIL(662, "错误的邮箱，无法发送"),
    /**
     * 没有这个学生
     */
    NO_STUDENT(663,"没有这个学生"),
    /**
     *上传出错
     */
    BAD_UPLOAD(661, "上传出了错误"),
    /**
     *上传出错
     */
    BAD_DOWN(660, "下载了出差错，请稍后重试！"),
    /**
     *上传出错
     */
    EXIST_MESSAGE(659, "已经存在该学生数据！请勿重复添加"),
    /**
     *上传出错
     */
    BAD_CHECK(658, "验证码错误"),
    /**
     *填写完整
     */
    RISK_NULL(658, "请把资料填写完整,不能为空。"),
    /**
     *
     */
    BAD_INPUT(400, "输入的参数有误,请重新输入"),
    /**
     *
     */
    BAD_PASSWORD(657, "输入的旧密码有误,请重新输入"),
    /**
     * 303登录失败
     */
    LOGIN_FAIL(303, "登录失败"),
    /**
     * 400请求参数出错
     */
    BAD_REQUEST(400, "请求参数出错,请稍后再试"),
    /**
     * 401没有登录
     */
    UNAUTHORIZED(401, "没有登录"),
    /**
     * 403没有权限
     */
    FORBIDDEN(403, "没有权限"),
    /**
     * 410已被删除
     */
    GONE(410, "已被删除"),
    /**
     * 423已被锁定
     */
    LOCKED(423, "已被锁定"),
    /**
     * 500服务器出错
     */
    INTERNAL_SERVER_ERROR(500, "服务器出错"),
    /**
     * 异常
     */
    EXCPTION_ERROR(4001, "异常");

    private final Integer value;
    private final String text;

    private EnumCode(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    /**
     * 获取value
     */
    public Integer getValue() {
        return this.value;
    }

    /**
     * 获取Text
     */
    public String getText() {
        return this.text;
    }
}
