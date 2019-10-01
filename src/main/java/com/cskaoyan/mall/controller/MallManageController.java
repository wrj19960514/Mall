package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Brand;
import com.cskaoyan.mall.bean.Issue;
import com.cskaoyan.mall.bean.Keyword;
import com.cskaoyan.mall.service.MallManageService;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.mallManage.BrandCreateVo;
import com.cskaoyan.mall.vo.mallManage.BrandInfoVo;
import com.cskaoyan.mall.vo.mallManage.BrandListBean;
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
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        respVo.setData(mallManageService.getRegionList(11, 65));
        return respVo;
    }

    @RequestMapping("/admin/brand/list")
    public BaseRespVo brand(BrandInfoVo brandInfoVo) {
        PageHelper.startPage(brandInfoVo.getPage(), brandInfoVo.getLimit());
        BrandListBean brandListBean = new BrandListBean();
        List brandList = mallManageService.getBrandList(brandInfoVo);
        PageInfo brandPageInfo = new PageInfo<>(brandList);
        brandListBean.setItems(brandList);
        brandListBean.setTotal(brandPageInfo.getTotal());
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        respVo.setData(brandListBean);
        return respVo;
    }

    @RequestMapping("/admin/brand/create")
    public BaseRespVo brandCreate(@RequestBody BrandCreateVo brandCreateVo) {
        mallManageService.createBrand(brandCreateVo);
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        respVo.setData(null);
        return respVo;
    }

    @RequestMapping("/admin/brand/delete")
    public BaseRespVo brandDelete(@RequestBody Brand brand) {
        mallManageService.deleteBrand(brand.getId(),brand.getDeleted());
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        respVo.setData(null);
        return respVo;
    }

    @RequestMapping("/admin/order/list")
    public BaseRespVo order(OrderListVo orderListVo) {
        PageHelper.startPage(orderListVo.getPage(), orderListVo.getLimit());
        BrandListBean brandListBean = new BrandListBean();
        List brandList = mallManageService.getOrderList(orderListVo);
        PageInfo brandPageInfo = new PageInfo<>(brandList);
        brandListBean.setItems(brandList);
        brandListBean.setTotal(brandPageInfo.getTotal());
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        respVo.setData(brandListBean);
        return respVo;
    }

    @RequestMapping("/admin/order/detail")
    public BaseRespVo orderDetail(int id) {
        OrderDetailedVo orderDetailed = mallManageService.getOrderDetailed(id);
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        respVo.setData(orderDetailed);
        return respVo;
    }

    @RequestMapping("/admin/category")
    public BaseRespVo category() {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        return respVo;
    }

    @RequestMapping("/admin/issue/list")
    public BaseRespVo issue(IssueListVo issueListVo) {
        PageHelper.startPage(issueListVo.getPage(), issueListVo.getLimit());
        BrandListBean brandListBean = new BrandListBean();
        List brandList = mallManageService.getIssueList(issueListVo);
        PageInfo brandPageInfo = new PageInfo<>(brandList);
        brandListBean.setItems(brandList);
        brandListBean.setTotal(brandPageInfo.getTotal());
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        respVo.setData(brandListBean);
        return respVo;
    }

    @RequestMapping("/admin/issue/create")
    public BaseRespVo issueCreate(@RequestBody Question question) {
        mallManageService.createissue(question);
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        respVo.setData(null);
        return respVo;
    }

    @RequestMapping("/admin/issue/delete")
    public BaseRespVo issueDelete(@RequestBody Issue issue) {
        mallManageService.deleteIssue(issue);
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        respVo.setData(null);
        return respVo;
    }

    @RequestMapping("/admin/issue/update")
    public BaseRespVo issueUpdate(@RequestBody Issue issue) {
        mallManageService.updateIssue(issue);
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        respVo.setData(null);
        return respVo;
    }

    @RequestMapping("/admin/keyword/list")
    public BaseRespVo keywordList(KeywordListVo keywordListVo) {
        PageHelper.startPage(keywordListVo.getPage(), keywordListVo.getLimit());
        BrandListBean brandListBean = new BrandListBean();
        List brandList = mallManageService.getKeywordList(keywordListVo);
        PageInfo brandPageInfo = new PageInfo<>(brandList);
        brandListBean.setItems(brandList);
        brandListBean.setTotal(brandPageInfo.getTotal());
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        respVo.setData(brandListBean);
        return respVo;
    }

    @RequestMapping("/admin/keyword/create")
    public BaseRespVo keywordCreate(@RequestBody Keyword keyword) {
        mallManageService.createKeyword(keyword);
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        respVo.setData(null);
        return respVo;
    }

    @RequestMapping("/admin/keyword/update")
    public BaseRespVo keywordUpdate(@RequestBody Keyword keyword) {
        mallManageService.updateKeyword(keyword);
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        respVo.setData(null);
        return respVo;
    }

    @RequestMapping("/admin/keyword/delete")
    public BaseRespVo keywordDelete(@RequestBody Keyword keyword) {
        mallManageService.deleteKeyword(keyword);
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        respVo.setErrno(0);
        respVo.setErrmsg("成功");
        respVo.setData(null);
        return respVo;
    }
}
