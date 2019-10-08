package com.cskaoyan.mall.controller.wx;

import com.cskaoyan.mall.bean.SearchHistory;
import com.cskaoyan.mall.service.wx.SearchService;
import com.cskaoyan.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("wx/search")
public class SearchController {
    @Autowired
    SearchService searchService;

    @RequestMapping("index")
    public BaseRespVo getSearchList(){
        Map searchList = searchService.getSearchList();
        BaseRespVo ok = BaseRespVo.ok(searchList);
        return ok;
    }

    @RequestMapping("helper")
    public BaseRespVo searchHelper(String keyword){
        List helperData = searchService.searchHelper(keyword);
        BaseRespVo ok = BaseRespVo.ok(helperData);
        return ok;
    }

    @RequestMapping("clearhistory")
    public BaseRespVo cleanHistory(){
        int id= 1 ;
        searchService.cleanHistory(id);
        BaseRespVo ok = BaseRespVo.ok(null);
        return ok;
    }

}
