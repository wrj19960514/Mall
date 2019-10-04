package com.cskaoyan.mall.vo;

/**
 * @author adore
 * @date 2019/9/30 11:28
 */
public class BaseRespVo<T> {
    int errno;
    T data;
    String errmsg;
    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }



    public static BaseRespVo ok(Object data) {
        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setErrno(0);
        baseRespVo.setData(data);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }

    public static BaseRespVo error(Object data) {
        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setErrno(-1);
        baseRespVo.setData(data);
        baseRespVo.setErrmsg("错误");
        return baseRespVo;
    }

    public static BaseRespVo fail() {
        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setErrno(500);
        baseRespVo.setErrmsg("登录失败");
        return baseRespVo;
    }

    @Override
    public String toString() {
        return "BaseRespVo{" +
                "errno=" + errno +
                ", data=" + data +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
