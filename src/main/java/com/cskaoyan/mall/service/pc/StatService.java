package com.cskaoyan.mall.service.pc;

import com.cskaoyan.mall.vo.Statement.StatVo;

/**
 * @author adore
 * @date 2019/10/1 17:12
 */
public interface StatService {
    /**用户报表统计
     * @return 报表数据
     */
    StatVo userStatement();

    /**订单报表统计
     * @return  报表数据
     */
    StatVo orderStatement();

    /**商品报表统计
     * @return 报表数据
     */
    StatVo goodsStatement();
}
