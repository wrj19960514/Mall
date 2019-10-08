package com.cskaoyan.mall.vo.wx;

public class WxOrderstateVo {

    int unpaid;

    int unship;

    int unrecv;

    int uncomment;

    public int getUnpaid() {
        return unpaid;
    }

    public void setUnpaid(int unpaid) {
        this.unpaid = unpaid;
    }

    public int getUnship() {
        return unship;
    }

    public void setUnship(int unship) {
        this.unship = unship;
    }

    public int getUnrecv() {
        return unrecv;
    }

    public void setUnrecv(int unrecv) {
        this.unrecv = unrecv;
    }

    public int getUncomment() {
        return uncomment;
    }

    public void setUncomment(int uncomment) {
        this.uncomment = uncomment;
    }

    @Override
    public String toString() {
        return "WxOrderstateVo{" +
                "unpaid=" + unpaid +
                ", unship=" + unship +
                ", unrecv=" + unrecv +
                ", uncomment=" + uncomment +
                '}';
    }
}
