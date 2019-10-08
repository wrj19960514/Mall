package com.cskaoyan.mall.vo.wx;

import java.util.List;

public class WxCartCheckedVo {

    private boolean isChecked;

    private List<Integer> productIds;

    public boolean getIsChecked() {
            return isChecked;
        }

    public void setIsChecked(boolean checked) {
            isChecked = checked;
        }

    public List<Integer> getProductIds() {
            return productIds;
        }

    public void setProductIds(List<Integer> productIds) {
            this.productIds = productIds;
        }
}
