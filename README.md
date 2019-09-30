# Mall
这是一个商城项目，包含前台和后台两部分。
前台主要通过微信小程序和 `springboot` 来实现的，后台通过 `vue` 和 `springboot` 来实现的，通过前后端分离，实现商城的功能。

## 小组成员
- [x] 吴翀
- [x] 汪仁俊
- [x] 焦继武
- [x] 刘幸垚 
- [x] 邢文才
- [x] 戚永华

## 项目分工

功能模块 | 模块数量 | 成员姓名
--------- | ---------- | -------
1.1.2	用户管理 | 6 | 焦继武
1.1.3	商场管理 | 6 | 吴翀 
1.1.4	商品管理 + 1.1.8	统计报表  | 6 | 刘幸垚      
1.1.5	推广管理  | 5 | 戚永华
1.1.6	系统管理  | 4 | 邢文才
1.1.7	配置管理+ 首页admin/dashboard | 6 | 汪仁俊

## 1.1	后台业务模块
### 1.1.1	首页
功能模块 | 请求地址
--------- | ----------
首页 | admin/dashboard
### 1.1.2	用户管理
功能模块 | 请求地址
--------- | ----------
会员管理 | admin/user
收货地址 | admin/address
会员收藏 | admin/collect
会员足记 | admin/footprint
搜索历史 | admin/history
意见反馈 | admin/feedback
### 1.1.3	商场管理
功能模块 | 请求地址
--------- | ----------
行政区域 | admin/region
品牌制造商 | admin/brand
商品类目 | admin/category
订单管理 | admin/order
通用问题 | admin/issue
关键词 | admin/keyword
### 1.1.4	商品管理
功能模块 | 请求地址
--------- | ----------
商品列表 | admin/goods/list
商品上架 | admin/goods/catAndBrand
商品评论 | admin/comment
### 1.1.5	推广管理
功能模块 | 请求地址
--------- | ----------
广告管理 | admin/ad
优惠券管理 | admin/coupon
专题管理 | admin/topic
团购规则 | admin/groupon/list
团购活动 | admin/groupon/listRecord
### 1.1.6	系统管理
功能模块 | 请求地址
--------- | ----------
管理员 | admin/role/options
操作日志 | admin/log
角色管理 | admin/role/list
对象存储 | admin/storage
### 1.1.7	配置管理
功能模块 | 请求地址
--------- | ----------
商场配置 | admin/config/mall
运费配置 | admin/config/express
订单配置 | admin/config/order
小程序配置 | admin/config/wx
### 1.1.8	统计报表
功能模块 | 请求地址
--------- | ----------
用户统计 | admin/stat/user
订单统计 | admin/stat/order
商品统计 | admin/stat/goods
