package com.zheshuo.advert.repository.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zheshuo.advert.entity.AdminInfo;
import com.zheshuo.advert.mapper.AdminInfoMapper;
import com.zheshuo.advert.repository.AdminInfoRepository;
import org.springframework.stereotype.Repository;


/**
 * 用户(AdminInfo)
 * @author ZhangLong
 * @since 2019-12-12 15:54:30
 */
@Repository
public class AdminInfoRepositoryImpl extends ServiceImpl<AdminInfoMapper, AdminInfo> implements AdminInfoRepository {

}