package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.bean.Topic;
import com.cskaoyan.mall.mapper.TopicMapper;
import com.cskaoyan.mall.vo.TopicManage.ListBeanVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicMapper topicMapper;

    @Override
    public ListBeanVo getTopicList(int page, int size) {
        PageHelper.startPage(page,size);
        List<Topic> topics = topicMapper.queryAllTopic();
        PageInfo<Topic> topicPageInfo = new PageInfo<>(topics);
        int total = (int)topicPageInfo.getTotal();
        ListBeanVo listBeanVo = new ListBeanVo();
        listBeanVo.setCount(total);
        listBeanVo.setData(topics);
        return listBeanVo;
    }

    @Override
    public Map getTopicDetail(int id) {
        Topic topic = topicMapper.queryTopicById(id);
        String[] goods = topic.getGoods();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("goods",goods);
        map.put("topic",topic);
        return map;
    }

    @Override
    public List<Topic> getRelatedTopic(int id) {

        List<Topic> topiclist = topicMapper.queryTopicRelatedList(id+1,id+4);
        return topiclist;
    }
}
