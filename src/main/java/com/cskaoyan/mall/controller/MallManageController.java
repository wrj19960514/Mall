package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Brand;
import com.cskaoyan.mall.service.MallManageService;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.mallManage.BrandCreateVo;
import com.cskaoyan.mall.vo.mallManage.BrandInfoVo;
import com.cskaoyan.mall.vo.mallManage.BrandListBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public BaseRespVo order() {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        return respVo;
    }

    @RequestMapping("/admin/category")
    public BaseRespVo category() {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        return respVo;
    }

    @RequestMapping("/admin/issue")
    public BaseRespVo issue() {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        return respVo;
    }

    @RequestMapping("/admin/keyword")
    public BaseRespVo keyword() {
        BaseRespVo<Object> respVo = new BaseRespVo<>();
        return respVo;
    }
}
