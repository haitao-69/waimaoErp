package cn.edu.bcu.demo.until;

public class Result {
    private Object data;
    private Integer code;
    private String msg;

    /**
     * 操作成功的情况
     */
    public static Result success(Object data) {
        return success(Code.IS_OK,"操作成功",data);
    }

    /**
     * 操作失败的情况
     */
    public static Result fail() {
        return success(Code.IS_ERROR,"操作失败",null);
    }

    public static Result fail(String msg) { return success(Code.IS_ERROR,msg,null); }

    public static Result fail404(String msg) { return success(Code.IS_NOTFOUNT,msg,null); }

    public static Result success(int code,String msg,Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static Result success(int code,String msg) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
