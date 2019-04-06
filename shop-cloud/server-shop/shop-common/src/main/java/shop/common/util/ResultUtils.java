package shop.common.util;

import shop.common.pojo.Result;

/**
 * 前后端交互结果集工具类
 *
 * @author mingzhi.xie
 * @date 2019/4/6
 */
public class ResultUtils<T> {

    private Result<T> result;

    public ResultUtils(){
        result=new Result<>();
        result.setSuccess(true);
        result.setMessage("success");
        result.setCode(ResultStatus.OK);
    }

    public Result<T> setData(T t){
        this.result.setResult(t);
        this.result.setCode(ResultStatus.OK);
        return this.result;
    }

    public Result<T> setData(T t, String msg){
        this.result.setResult(t);
        this.result.setCode(ResultStatus.OK);
        this.result.setMessage(msg);
        return this.result;
    }

    public Result<T> setErrorMsg(String msg){
        this.result.setSuccess(false);
        this.result.setMessage(msg);
        this.result.setCode(ResultStatus.ERROR);
        return this.result;
    }

    public Result<T> setErrorMsg(Integer code, String msg){
        this.result.setSuccess(false);
        this.result.setMessage(msg);
        this.result.setCode(ResultStatus.valueOf(code));
        return this.result;
    }
}
