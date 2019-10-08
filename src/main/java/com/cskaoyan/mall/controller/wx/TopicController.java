package com.cskaoyan.mall.controller.wx;

import com.cskaoyan.mall.bean.Topic;
import com.cskaoyan.mall.service.wx.TopicService;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.TopicManage.ListBeanVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx/topic")
public class TopicController {

    @Autowired
    TopicService topicService;

    @RequestMapping("/list")
    public BaseRespVo getTopicList(int page,int size){
        ListBeanVo topicList = topicService.getTopicList(page, size);
        BaseRespVo ok = BaseRespVo.ok(topicList);
        return ok;
    }
    @RequestMapping("/detail")
    public BaseRespVo getTopicDetail(int id){
        Map map = topicService.getTopicDetail(id);
        BaseRespVo ok = BaseRespVo.ok(map);
        return ok;
    }
    @RequestMapping("/related")
    public BaseRespVo getTopicRelated(int id){
        List<Topic> relatedTopic = topicService.getRelatedTopic(id);
        BaseRespVo ok = BaseRespVo.ok(relatedTopic);
        return ok;
    }
}
