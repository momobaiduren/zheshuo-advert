package com.zheshuo.advert.repository.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zheshuo.advert.entity.AccountInfo;
import com.zheshuo.advert.mapper.AccountInfoMapper;
import com.zheshuo.advert.repository.AccountInfoRepository;
import org.springframework.stereotype.Repository;


/**
 * 自定义demo表(AccountInfo)
 * @author ZhangLong
 * @since 2019-12-11 18:42:26
 */
@Repository
public class AccountInfoRepositoryImpl extends ServiceImpl<AccountInfoMapper, AccountInfo> implements AccountInfoRepository {

}