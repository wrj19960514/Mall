package com.cskaoyan.mall.bean;

public class OrderHandleOptions {
    private int orderId;

    private boolean cancel;

    private boolean comment;

    private boolean confirm;

    private boolean delete;

    private boolean pay;

    private boolean rebuy;

    private boolean refund;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    public boolean isComment() {
        return comment;
    }

    public void setComment(boolean comment) {
        this.comment = comment;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean isPay() {
        return pay;
    }

    public void setPay(boolean pay) {
        this.pay = pay;
    }

    public boolean isRebuy() {
        return rebuy;
    }

    public void setRebuy(boolean rebuy) {
        this.rebuy = rebuy;
    }

    public boolean isRefund() {
        return refund;
    }

    public void setRefund(boolean refund) {
        this.refund = refund;
    }

    @Override
    public String toString() {
        return "OrderHandleOptions{" +
                "orderId=" + orderId +
                ", cancel=" + cancel +
                ", comment=" + comment +
                ", confirm=" + confirm +
                ", delete=" + delete +
                ", pay=" + pay +
                ", rebuy=" + rebuy +
                ", refund=" + refund +
                '}';
    }
}
