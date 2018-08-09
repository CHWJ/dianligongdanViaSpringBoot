package com.hdtech.dianligongdan.controller;

import com.hdtech.dianligongdan.domain.entity.Account;
import com.hdtech.dianligongdan.domain.result.Response;
import com.hdtech.dianligongdan.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/account")
public class AccountController extends BaseController {
    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView();
        view.setViewName("account/index");
        return view;
    }

    @PostMapping("/login")
    public Response login(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(account!=null){
            String newpassword = DigestUtils.md5DigestAsHex(account.getPassword().getBytes()).toLowerCase();
            Account result = accountRepository.findByUsernameAndPassword(account.getUsername(),newpassword);
            if(result!=null){
                // todo loinglog
                String contextPath = request.getContextPath();
                response.sendRedirect(contextPath+"/home/index");
            }else {
                return new Response("","用户名或者密码错误！");
            }
        }
        return new Response("","登录失败！");
    }
}
