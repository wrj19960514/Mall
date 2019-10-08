package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.bean.SearchHistory;

import java.util.List;
import java.util.Map;

public interface SearchService {
    Map getSearchList();

    List searchHelper(String keyword);

    void cleanHistory(SearchHistory searchHistory);
}
