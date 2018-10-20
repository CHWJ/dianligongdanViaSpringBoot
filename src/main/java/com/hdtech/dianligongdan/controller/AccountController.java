package com.hdtech.dianligongdan.controller;

import com.hdtech.dianligongdan.domain.entity.Account;
import com.hdtech.dianligongdan.domain.entity.AccountModel;
import com.hdtech.dianligongdan.domain.result.Response;
import com.hdtech.dianligongdan.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController extends BaseController {
    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.setViewName("account/index");
        return view;
    }

    @PostMapping("/login")
    public Response login(Account account) {
        if (account != null) {
            String newpassword = DigestUtils.md5DigestAsHex(account.getPassword().getBytes()).toLowerCase();
            Account result = accountRepository.findByUsernameAndPassword(account.getUsername(), newpassword);
            if (result != null) {
                // todo loinglog
                return new Response("", "登录成功！", "/home/index");
            } else {
                return new Response("", "用户名或者密码错误！");
            }
        }
        return new Response("", "登录失败！");
    }

    @PostMapping("/findByOrganId")
    public List<AccountModel> findByOrganId(Integer id) {
        List<AccountModel> list = new ArrayList<>();
        if (id == null) return list;

        List<Account> accountList = accountRepository.findByOrganizationId(id);
        if (accountList == null) return list;

        for (Account a : accountList) {
            AccountModel temp = new AccountModel();
            temp.setId(a.getId());
            temp.setName(a.getName());
            temp.setOrganId(a.getOrganizationId());
            temp.setType(a.getType().name());
            list.add(temp);
        }

        return list;
    }
}
