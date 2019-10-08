package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.vo.ListBean;
import com.cskaoyan.mall.vo.collectManage.CollectVo;

import java.util.List;
import java.util.Map;

public interface CollectionService {
    Map queryCollectList(int type, int page, int size);

    Map addOrDeleteCollect(CollectVo collectVo);
}
