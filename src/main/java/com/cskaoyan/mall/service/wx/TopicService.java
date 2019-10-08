package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.bean.Topic;
import com.cskaoyan.mall.vo.TopicManage.ListBeanVo;

import java.util.List;
import java.util.Map;

public interface TopicService {
    ListBeanVo getTopicList(int page, int size);

    Map getTopicDetail(int id);

    List<Topic>  getRelatedTopic(int id);
}
