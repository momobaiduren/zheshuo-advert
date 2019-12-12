package com.zheshuo.advert.repository.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zheshuo.advert.entity.StockInfo;
import com.zheshuo.advert.mapper.StockInfoMapper;
import com.zheshuo.advert.repository.StockInfoRepository;
import org.springframework.stereotype.Repository;


/**
 * (StockInfo)
 * @author ZhangLong
 * @since 2019-12-12 10:55:01
 */
@Repository
public class StockInfoRepositoryImpl extends ServiceImpl<StockInfoMapper, StockInfo> implements StockInfoRepository {

}