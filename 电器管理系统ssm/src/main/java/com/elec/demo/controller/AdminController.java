package com.elec.demo.controller;

import com.elec.demo.model.AdminUserModel;
import com.elec.demo.result.ResultOne;
import com.elec.demo.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*",maxAge=3600)
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    IAdminService iadminservice = null;

    @RequestMapping(value = "/login")
    public ResultOne<AdminUserModel> checklogin(AdminUserModel admin){
       AdminUserModel adminUserModel = iadminservice.login(admin);
        ResultOne<AdminUserModel> result = new ResultOne();
       if (adminUserModel==null){
            result.setStatus("error");
            result.setMessage("登陆失败");
            return result;
       }
       else{
           result.setStatus("OK");
           result.setMessage("登录成功");
           result.setResult(adminUserModel);
           return result;
       }
    }
}
