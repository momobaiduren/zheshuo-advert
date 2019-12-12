package com.zheshuo.advert.repository.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zheshuo.advert.entity.OrderInfo;
import com.zheshuo.advert.mapper.OrderInfoMapper;
import com.zheshuo.advert.repository.OrderInfoRepository;
import org.springframework.stereotype.Repository;


/**
 * (OrderInfo)
 * @author ZhangLong
 * @since 2019-12-12 09:47:25
 */
@Repository
public class OrderInfoRepositoryImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoRepository {

}