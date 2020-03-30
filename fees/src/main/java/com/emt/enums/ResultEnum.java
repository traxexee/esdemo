package com.emt.enums;

//    UNKONW_ERROR(-1, "未知错误"),
//    SUCCESS(0, "成功"),
//    TOOLANG(1,"位数太长了"),
//    NOT_FIND(2,"没找到"),
//    STATE_ERROR(3,"状态异常"),
//    MONEY_ERROR(4,"金额异常"),
//    DEL_FAIL(5,"删除失败"),
//    ADD_FAIL(6,"添加失败"),
//    EDIT_FAIL(7,"修改失败"),
//    NO_USER(8,"用户名不存在"),
//    PWD_ERROR(9,"密码错误"),
//    TIME_OUT(11,"登录超时"),
//    PWD_DIFFER(12,"密码不一致")
public enum ResultEnum {
	
	UNKONW_ERROR(-1, "未知错误"),
	SUCCESS(0, "成功"),
	YZM_ERROR(1,"验证码错误"),
	LOGIN_ERROR(2,"用户名或密码错误"),
	MENU_ERROR(3,"菜单生成失败"),
	USER_ERROR(4,"用户已注销"),
	REP_ERROR(5,"请求错误"),
	
	DATA_ERROR(6,"数据格式错误"),
	INSER_ERROR(7,"数据添加失败"),
	QUERY_ERROR(8,"数据查询失败"),
	DELETE_ERROR(9,"数据删除失败"),
	UPDATE_ERROR(10,"数据更新失败"),
	USER_LOCK(11,"账号已被锁定")
	
	;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
