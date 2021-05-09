package com.southwind.controller;

import com.southwind.entity.Account;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
//import java.net.http.HttpResponse;

@Controller
@CrossOrigin
public class AccountController {


    @GetMapping("/manage")
    @ResponseBody
    @CrossOrigin
    public String manage(){

        return "manage";
    }

//    @GetMapping("/{url}")
//    public String redirect(@PathVariable("url") String url){
//        return url;
//    }
    @GetMapping("/logout")

    public String logout(){
        Subject subject=SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }


    @PostMapping("/login")
    @ResponseBody
    public Object login(String username, String password, Model model){
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Credentials","true");
        Subject subject= SecurityUtils.getSubject();
        System.out.println(username+password);
        UsernamePasswordToken token= new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            Account account=(Account) subject.getPrincipal();
            subject.getSession().setAttribute("account",account);
            return subject.getSession();
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            model.addAttribute("msg","用户名不存在");
            return "login";
        } catch (IncorrectCredentialsException r){
            model.addAttribute("msg","密码不对");
            r.printStackTrace();
            return "login";
        }

    }


    @GetMapping("favicon.ico")
    @ResponseBody
    void returnNoFavicon() {
    }

    @GetMapping("/una")
    @ResponseBody
    public String una(){
        return "未授权";
    }

}
