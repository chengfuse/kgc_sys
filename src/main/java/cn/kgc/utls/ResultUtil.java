package cn.kgc.utls;


import cn.kgc.dto.ResultDto;

/**
 * @Auther: wangxiaodan
 * @Date:2021/3/15 9:14
 * @Description:
 **/
public class ResultUtil {
    public static ResultDto returnSuccess(Object data, int count){
        ResultDto dto = new ResultDto<>();
        dto.setCode(0);
        dto.setData(data);
        dto.setCount(count);
        return dto;
    }
    public static ResultDto returnSuccess(){
        ResultDto dto = new ResultDto<>();
        dto.setCode(0);
        return dto;
    }

    /**
     * 返回失败的方法
     * @param code
     * @param msg
     * @return
     */
    public static ResultDto returnFail(int code,String msg){
        ResultDto dto = new ResultDto();
        dto.setCode(code);
        dto.setMsg(msg);
        return dto;
    }
}
