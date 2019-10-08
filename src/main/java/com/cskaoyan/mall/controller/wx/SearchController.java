package com.cskaoyan.mall.controller.wx;

import com.cskaoyan.mall.bean.SearchHistory;
import com.cskaoyan.mall.service.wx.SearchService;
import com.cskaoyan.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SearchController {
    @Autowired
    SearchService searchService;

    public BaseRespVo getSearchList(){
        Map searchList = searchService.getSearchList();
        BaseRespVo ok = BaseRespVo.ok(searchList);
        return ok;
    }
    public BaseRespVo searchHelper(String keyword){
        List helperData = searchService.searchHelper(keyword);
        BaseRespVo ok = BaseRespVo.ok(helperData);
        return ok;
    }
    public BaseRespVo cleanHistory(SearchHistory searchHistory){
        searchService.cleanHistory(searchHistory);
        BaseRespVo ok = BaseRespVo.ok(null);
        return ok;
    }

}
