# zheshuo-advert
zhanglong

#使用单表操作的业务代码全部使用easycode模版生成器
实现增改查（分页查，列表差，详情查）、数据导出

入参数据校验相关使用注解在request实体中使用javax中自定义的校验器进行校验

只需要在controller（表现层）->service（业务层）->repository（业务数据层）->mapper（数据映射层）

* controller（表现层）（自定义request接收，response响应）
* service（业务层）业务处理（request,response数据与表实体之间的转换，业务处理）
* repository（业务数据层）业务数据处理
* mapper（数据映射层）自定义sqlmapper映射
