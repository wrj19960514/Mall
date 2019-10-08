package com.cskaoyan.mall.controller.wx;

import com.cskaoyan.mall.service.wx.CollectionService;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.ListBean;
import com.cskaoyan.mall.vo.collectManage.CollectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/wx/collect")
public class CollectionController {
    @Autowired
    CollectionService collectionService;
    @RequestMapping("/list")
    public BaseRespVo getCollectionList(int type,int page,int size){
        Map map = collectionService.queryCollectList(type, page, size);
        BaseRespVo ok = BaseRespVo.ok(map);
        return ok;
    }
   @RequestMapping("/addordelete")
    public BaseRespVo addOrDeleteCollect(@RequestBody CollectVo collectVo){
        Map data = collectionService.addOrDeleteCollect(collectVo);
       BaseRespVo ok = BaseRespVo.ok(data);
       return ok;
}

}
