# Mall
这是一个商城项目，包含前台和后台两部分。
前台主要通过微信小程序和 `SpringBoot` 来实现的，后台通过 `Vue.js` 和 `SpringBoot` 来实现的，通过前后端分离，实现商城的功能。

## 小组成员列表
- [x] 吴翀
- [x] 汪仁俊
- [x] 焦继武
- [x] 刘幸垚 
- [x] 邢文才
- [x] 戚永华

## 项目分工
### 后台业务模块
功能模块 | 模块数量 | 成员姓名
--------- | ---------- | -------
1.1.2	用户管理 | 6 | 焦继武
1.1.3	商场管理 | 6 | 吴翀 
1.1.4	商品管理 + 1.1.8	统计报表  | 6 | 刘幸垚      
1.1.5	推广管理  | 5 | 戚永华
1.1.6	系统管理  | 4 | 邢文才
1.1.7	配置管理+ 1.1.1 首页 | 6 | 汪仁俊

### 微信小程序业务模块
功能模块 | 模块数量 | 成员姓名
--------- | ---------- | -------
null | 13 | 焦继武
null | 14 | 吴翀 
null | 12 | 刘幸垚      
null | 11 | 戚永华
null | 12 | 邢文才
null | 11 | 汪仁俊

## 相关配置
### Node.js版本
`10.x`
### 数据库名称
`cskaoyanmall`

## 1.1	后台业务模块
### 1.1.1	首页 (汪仁俊)
功能模块 | 请求地址
--------- | ----------
首页 | admin/dashboard
### 1.1.2	用户管理 (焦继武)
功能模块 | 请求地址
--------- | ----------
会员管理 | admin/user
收货地址 | admin/address
会员收藏 | admin/collect
会员足记 | admin/footprint
搜索历史 | admin/history
意见反馈 | admin/feedback
### 1.1.3	商场管理 (吴翀)
功能模块 | 请求地址
--------- | ----------
行政区域 | admin/region
品牌制造商 | admin/brand
商品类目 | admin/category
订单管理 | admin/order
通用问题 | admin/issue
关键词 | admin/keyword
### 1.1.4	商品管理 (刘幸垚)
功能模块 | 请求地址
--------- | ----------
商品列表 | admin/goods/list
商品上架 | admin/goods/catAndBrand
商品评论 | admin/comment
### 1.1.5	推广管理 (戚永华)
功能模块 | 请求地址
--------- | ----------
广告管理 | admin/ad
优惠券管理 | admin/coupon
专题管理 | admin/topic
团购规则 | admin/groupon/list
团购活动 | admin/groupon/listRecord
### 1.1.6	系统管理 (邢文才)
功能模块 | 请求地址
--------- | ----------
管理员 | admin/role/options
操作日志 | admin/log
角色管理 | admin/role/list
对象存储 | admin/storage
### 1.1.7	配置管理 (汪仁俊)
功能模块 | 请求地址
--------- | ----------
商场配置 | admin/config/mall
运费配置 | admin/config/express
订单配置 | admin/config/order
小程序配置 | admin/config/wx
### 1.1.8	统计报表 (刘幸垚)
功能模块 | 请求地址
--------- | ----------
用户统计 | admin/stat/user
订单统计 | admin/stat/order
商品统计 | admin/stat/goods

## 1.2	微信小程序业务模块
### 1.2.1 部分一:11（汪仁俊）
功能模块 | 请求地址 | 接口名称
IndexUrl: |`home/index` | 首页数据接口
CatalogList: |`catalog/index` | 分类目录全部分类数据接口
CatalogCurrent: |`catalog/current` | 分类目录当前分类数据接口
--------- | ---------- | -------
AuthLoginByWeixin: |`auth/login_by_weixin` | 微信登录
AuthLoginByAccount: |`auth/login` | 账号登录
AuthLogout: |`auth/logout` | 账号登出
AuthRegister: |`auth/register` | 账号注册
AuthReset: |`auth/reset` | 账号密码重置
AuthRegisterCaptcha: |`auth/regCaptcha` | 验证码
AuthBindPhone: |`auth/bindPhone` | 绑定微信手机号
--------- | ---------- | -------
UserIndex: |`user/index` | 个人页面用户相关信息

### 1.2.2 部分二:14（吴翀）
功能模块 | 请求地址 | 接口名称
OrderSubmit: |`order/submit`, | 提交订单
OrderPrepay: |`order/prepay`, | 订单的预支付会话
OrderList: |`order/list` | 订单列表
OrderDetail: |`order/detail` | 订单详情
OrderCancel: |`order/cancel` | 取消订单
OrderRefund: |`order/refund` | 退款取消订单
OrderDelete: |`order/delete` | 删除订单
OrderConfirm: |`order/confirm` | 确认收货
OrderGoods: |`order/goods`, | 代评价商品信息
OrderComment: |`order/comment`, | 评价订单商品信息

### 1.2.3 部分三:12（刘幸垚）
功能模块 | 请求地址 | 接口名称
GroupOnList: |`groupon/list` | 团购列表
GroupOn: |`groupon/query` | 团购API-查询
GroupOnMy: |`groupon/my` | 团购API-我的团购
GroupOnDetail: |`groupon/detail` | 团购API-详情
GroupOnJoin: |`groupon/join` | 团购API-详情
--------- | ---------- | -------
CouponList: |`coupon/list` | 优惠券列表
CouponMyList: |`coupon/mylist` | 我的优惠券列表
CouponSelectList: |`coupon/selectlist` | 当前订单可用优惠券列表
CouponReceive: |`coupon/receive` | 优惠券领取
CouponExchange: |`coupon/exchange` | 优惠券兑换
--------- | ---------- | -------
BrandList: |`brand/list` | 品牌列表
BrandDetail: |`brand/detail` | 品牌详情


### 1.2.4 部分四:13(焦继武)
功能模块 | 请求地址 | 接口名称
GoodsCount: |`goods/count` | 统计商品总数
GoodsList: |`goods/list` | 获得商品列表
GoodsCategory: |`goods/category` | 获得分类数据
GoodsDetail: |`goods/detail` | 获得商品的详情
GoodsRelated: |`goods/related` | 商品详情页的关联商品（大家都在看）
--------- | ---------- | -------
CartList: |`cart/index` | 获取购物车的数据
CartAdd: |`cart/add`, | 添加商品到购物车
CartFastAdd: |`cart/fastadd`, | 立即购买商品
CartUpdate: |`cart/update`, | 更新购物车的商品
CartDelete: |`cart/delete`, | 删除购物车的商品
CartChecked: |`cart/checked`, | 选择或取消选择商品
CartGoodsCount: |`cart/goodscount`, | 获取购物车商品件数
CartCheckout: |`cart/checkout`, | 下单前信息确认

### 1.2.5 部分五:12(邢文才)
功能模块 | 请求地址 | 接口名称
CollectList: |`collect/list` | 收藏列表
CollectAddOrDelete: |`collect/addordelete` | 添加或取消收藏
--------- | ---------- | -------
CommentList: |`comment/list` | 评论列表
CommentCount: |`comment/count` | 评论总数
CommentPost: |`comment/post` | 发表评论
--------- | ---------- | -------
TopicList: |`topic/list` | 专题列表
TopicDetail: |`topic/detail` | 专题详情
TopicRelated: |`topic/related` | 相关专题
--------- | ---------- | -------
SearchIndex: |`search/index` | 搜索关键字
SearchResult: |`search/result` | 搜索结果
SearchHelper: |`search/helper` | 搜索帮助
SearchClearHistory: |`search/clearhistory` | 搜索历史清楚

### 1.2.6 部分六:11(戚永华)
功能模块 | 请求地址 | 接口名称
AddressList: |`address/list` | 收货地址列表
AddressDetail: |`address/detail` | 收货地址详情
AddressSave: |`address/save` | 保存收货地址
AddressDelete: |`address/delete` | 保存收货地址
--------- | ---------- | -------
ExpressQuery: |`express/query` | 物流查询
RegionList: |`region/list` | 获取区域列表
--------- | ---------- | -------
FeedbackAdd: |`feedback/submit` | 添加反馈
FootprintList: |`footprint/list` | 足迹列表
FootprintDelete: |`footprint/delete` | 删除足迹
--------- | ---------- | -------
UserFormIdCreate: |`formid/create` | 用户FromId，用于发送模版消息
--------- | ---------- | -------
StorageUpload: |`storage/upload` | 图片上传,
