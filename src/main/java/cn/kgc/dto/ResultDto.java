package cn.kgc.dto;

/**
 * @Auther: wangxiaodan
 * @Date:2021/3/15 9:10
 * @Description: 返回前端页面的dto
 **/
public class ResultDto<T> {
    private int code;
    private String msg;
    private int count;
    private T data;

    public ResultDto() {
    }

    public ResultDto(int code, String msg, int count, T data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
