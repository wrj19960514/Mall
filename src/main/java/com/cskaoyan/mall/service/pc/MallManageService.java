package com.cskaoyan.mall.service.pc;

import com.cskaoyan.mall.bean.Brand;
import com.cskaoyan.mall.bean.Issue;
import com.cskaoyan.mall.bean.Keyword;
import com.cskaoyan.mall.vo.mallManage.BrandCreateVo;
import com.cskaoyan.mall.vo.mallManage.BrandInfoVo;
import com.cskaoyan.mall.vo.mallManage.CategoryVo;
import com.cskaoyan.mall.vo.mallManage.IssueListVo;
import com.cskaoyan.mall.vo.mallManage.KeywordListVo;
import com.cskaoyan.mall.vo.mallManage.OrderDetailedVo;
import com.cskaoyan.mall.vo.mallManage.OrderListVo;
import com.cskaoyan.mall.vo.mallManage.Question;

import java.util.List;

public interface MallManageService {
    List getRegionList(int i, int i2);

    List getBrandList(BrandInfoVo brandInfoVo);

    void deleteBrand(Integer id, Boolean deleted);

    void createBrand(BrandCreateVo brandCreateVo);

    List getOrderList(OrderListVo orderListVo);

    OrderDetailedVo getOrderDetailed(int id);

    List getIssueList(IssueListVo issueListVo);

    void createissue(Question question);

    void deleteIssue(Issue issue);

    void updateIssue(Issue issue);

    List getKeywordList(KeywordListVo keywordListVo);

    void createKeyword(Keyword keyword);

    void updateKeyword(Keyword keyword);

    void deleteKeyword(Keyword keyword);

    List getCategoryL1();

    List getCategoryListAndChildren();

    void createCategory(CategoryVo categoryVo);

    void deleteCategory(CategoryVo categoryVo);

    void updateCategory(CategoryVo categoryVo);

    void updateBrand(Brand brand);
}
