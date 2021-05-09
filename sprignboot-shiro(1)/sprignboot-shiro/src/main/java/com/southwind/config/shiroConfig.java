package com.southwind.config;

import com.southwind.entity.Account;
import com.southwind.realm.AccoutRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

@Configuration
public class shiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager")DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean factoryBean= new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(defaultWebSecurityManager);

        //权限设置
        Map<String,String> map=new Hashtable<>();
        map.put("/main","authc");
        map.put("/manage","perms[manage]");
        map.put("/administator","roles[administrator]");
        factoryBean.setFilterChainDefinitionMap(map);
        factoryBean.setLoginUrl("/login");
        factoryBean.setUnauthorizedUrl("/una");
        return factoryBean;
    }


    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("realm") AccoutRealm accoutRealm){
        DefaultWebSecurityManager manager=new DefaultWebSecurityManager();
        manager.setRealm(accoutRealm);
        return manager;
    }

    @Bean
    public AccoutRealm realm(){
        return new AccoutRealm();
    }

}
