package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.bean.Keyword;
import com.cskaoyan.mall.bean.SearchHistory;
import com.cskaoyan.mall.mapper.KeywordMapper;
import com.cskaoyan.mall.mapper.SearchHistoryMapper;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    SearchHistoryMapper searchHistoryMapper;
    @Autowired
    KeywordMapper keywordMapper;

    @Override
    public Map getSearchList() {
        Keyword keyword = keywordMapper.queryDefaultKeyWord();
        List<Keyword> keywords = keywordMapper.queryHotKeyWord();
        List list = searchHistoryMapper.querySearchHistory();
        HashMap<String, Object> map = new HashMap<>();
        map.put("defaultKeyword",keyword);
        map.put("historyKeywordList",list);
        map.put("hotKeywordList",keywords);
        return map;
    }

    @Override
    public List searchHelper(String keyword) {
        return new ArrayList();
    }

    @Override
    public void cleanHistory(Integer id) {
        searchHistoryMapper.deleteSearchHistoryById(id);
    }
}
