package com.cskaoyan.mall.controller.pc;

import com.cskaoyan.mall.bean.Brand;
import com.cskaoyan.mall.bean.Issue;
import com.cskaoyan.mall.bean.Keyword;
import com.cskaoyan.mall.service.pc.MallManageService;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.mallManage.BrandCreateVo;
import com.cskaoyan.mall.vo.mallManage.BrandInfoVo;
import com.cskaoyan.mall.vo.mallManage.BrandListBean;
import com.cskaoyan.mall.vo.mallManage.CategoryVo;
import com.cskaoyan.mall.vo.mallManage.IssueListVo;
import com.cskaoyan.mall.vo.mallManage.KeywordListVo;
import com.cskaoyan.mall.vo.mallManage.OrderDetailedVo;
import com.cskaoyan.mall.vo.mallManage.OrderListVo;
import com.cskaoyan.mall.vo.mallManage.Question;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MallManageController {
    @Autowired
    MallManageService mallManageService;

    @RequestMapping("/admin/region/list")
    public BaseRespVo region() {
        return BaseRespVo.ok(mallManageService.getRegionList(11, 65));
    }

    @RequestMapping("/admin/brand/list")
    public BaseRespVo brandList(BrandInfoVo brandInfoVo) {
        PageHelper.startPage(brandInfoVo.getPage(), brandInfoVo.getLimit());
        BrandListBean brandListBean = new BrandListBean();
        List brandList = mallManageService.getBrandList(brandInfoVo);
        PageInfo brandPageInfo = new PageInfo<>(brandList);
        brandListBean.setItems(brandList);
        brandListBean.setTotal(brandPageInfo.getTotal());
        return BaseRespVo.ok(brandListBean);
    }

    @RequestMapping("/admin/brand/create")
    public BaseRespVo brandCreate(@RequestBody BrandCreateVo brandCreateVo) {
        mallManageService.createBrand(brandCreateVo);
        return BaseRespVo.ok(null);
    }

    @RequestMapping("/admin/brand/update")
    public BaseRespVo brandUpdate(@RequestBody Brand brand) {
        mallManageService.updateBrand(brand);
        return BaseRespVo.ok(null);
    }

    @RequestMapping("/admin/brand/delete")
    public BaseRespVo brandDelete(@RequestBody Brand brand) {
        mallManageService.deleteBrand(brand.getId(), brand.getDeleted());
        return BaseRespVo.ok(null);
    }

    @RequestMapping("/admin/order/list")
    public BaseRespVo order(OrderListVo orderListVo) {
        PageHelper.startPage(orderListVo.getPage(), orderListVo.getLimit());
        BrandListBean brandListBean = new BrandListBean();
        List brandList = mallManageService.getOrderList(orderListVo);
        PageInfo brandPageInfo = new PageInfo<>(brandList);
        brandListBean.setItems(brandList);
        brandListBean.setTotal(brandPageInfo.getTotal());
        return BaseRespVo.ok(brandListBean);
    }

    @RequestMapping("/admin/order/ship")
    public BaseRespVo orderShip() {
        return BaseRespVo.ok(null);
    }

    @RequestMapping("/admin/order/detail")
    public BaseRespVo orderDetail(int id) {
        OrderDetailedVo orderDetailed = mallManageService.getOrderDetailed(id);
        return BaseRespVo.ok(orderDetailed);
    }

    @RequestMapping("/admin/issue/list")
    public BaseRespVo issue(IssueListVo issueListVo) {
        PageHelper.startPage(issueListVo.getPage(), issueListVo.getLimit());
        BrandListBean brandListBean = new BrandListBean();
        List brandList = mallManageService.getIssueList(issueListVo);
        PageInfo brandPageInfo = new PageInfo<>(brandList);
        brandListBean.setItems(brandList);
        brandListBean.setTotal(brandPageInfo.getTotal());
        return BaseRespVo.ok(brandListBean);
    }

    @RequestMapping("/admin/issue/create")
    public BaseRespVo issueCreate(@RequestBody Question question) {
        mallManageService.createissue(question);
        return BaseRespVo.ok(null);
    }

    @RequestMapping("/admin/issue/delete")
    public BaseRespVo issueDelete(@RequestBody Issue issue) {
        mallManageService.deleteIssue(issue);
        return BaseRespVo.ok(null);
    }

    @RequestMapping("/admin/issue/update")
    public BaseRespVo issueUpdate(@RequestBody Issue issue) {
        mallManageService.updateIssue(issue);
        return BaseRespVo.ok(null);
    }

    @RequestMapping("/admin/keyword/list")
    public BaseRespVo keywordList(KeywordListVo keywordListVo) {
        PageHelper.startPage(keywordListVo.getPage(), keywordListVo.getLimit());
        BrandListBean brandListBean = new BrandListBean();
        List brandList = mallManageService.getKeywordList(keywordListVo);
        PageInfo brandPageInfo = new PageInfo<>(brandList);
        brandListBean.setItems(brandList);
        brandListBean.setTotal(brandPageInfo.getTotal());
        return BaseRespVo.ok(brandListBean);
    }

    @RequestMapping("/admin/keyword/create")
    public BaseRespVo keywordCreate(@RequestBody Keyword keyword) {
        mallManageService.createKeyword(keyword);
        return BaseRespVo.ok(null);
    }

    @RequestMapping("/admin/keyword/update")
    public BaseRespVo keywordUpdate(@RequestBody Keyword keyword) {
        mallManageService.updateKeyword(keyword);
        return BaseRespVo.ok(null);
    }

    @RequestMapping("/admin/keyword/delete")
    public BaseRespVo keywordDelete(@RequestBody Keyword keyword) {
        mallManageService.deleteKeyword(keyword);
        return BaseRespVo.ok(null);
    }

    @RequestMapping("/admin/category/l1")
    public BaseRespVo categoryL1() {
        List list = mallManageService.getCategoryL1();
        return BaseRespVo.ok(list);
    }


    @RequestMapping("/admin/category/list")
    public BaseRespVo categoryList() {
        List list = mallManageService.getCategoryListAndChildren();
        return BaseRespVo.ok(list);
    }

    @RequestMapping("/admin/category/create")
    public BaseRespVo categoryCreate(@RequestBody CategoryVo categoryVo) {
        mallManageService.createCategory(categoryVo);
        return BaseRespVo.ok(null);
    }

    @RequestMapping("/admin/category/delete")
    public BaseRespVo categoryDelete(@RequestBody CategoryVo categoryVo) {
        mallManageService.deleteCategory(categoryVo);
        return BaseRespVo.ok(null);
    }

    @RequestMapping("/admin/category/update")
    public BaseRespVo categoryUpdate(@RequestBody CategoryVo categoryVo) {
        mallManageService.updateCategory(categoryVo);
        return BaseRespVo.ok(null);
    }
}
