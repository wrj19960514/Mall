package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.vo.WxListBean;
import com.cskaoyan.mall.vo.promote.GrouponDetailVo;

/**
 * @author adore
 * @date 2019/10/5 15:03
 */
public interface GrouponService {
    /**
     * 获取团购列表
     * @param page 当前页
     * @param size 条目数
     * @return 数据列表
     */
    WxListBean getGrouponList(int page, int size);

    /**获取用户团购信息
     * @param showType 0为发起的团购,1为参与的团购
     * @return 数据列表
     */
    WxListBean myGroupon(int showType);

    GrouponDetailVo detail(int grouponId);
}
