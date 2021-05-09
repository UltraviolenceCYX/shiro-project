package com.southwind.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.southwind.entity.Account;
import com.southwind.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountMapper mapper;

    public Account findName(String username){
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("username",username);
        return mapper.selectOne(wrapper);
    }
}
