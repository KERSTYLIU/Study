package com.elec.demo.controller;

import com.elec.demo.model.AgentsModel;
import com.elec.demo.model.BankProductModel;
import com.elec.demo.model.UserInfoModel;
import com.elec.demo.result.ResultList;
import com.elec.demo.result.ResultOne;
import com.elec.demo.service.IUserinfoSercvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins="*",maxAge=3600)
@RequestMapping(value="/userinfo")
public class UserinfoController {
    @Autowired
    IUserinfoSercvice userinfoSercvice;
    //分页查看
    @RequestMapping(value="/tolist")
    public ResultList<UserInfoModel> tofrontlist(@RequestParam(value="page",required=false,defaultValue="0") int page, @RequestParam(value="rows",required=false,defaultValue="4") int rows) throws Exception{
        List<UserInfoModel> list=userinfoSercvice.getAll(page,rows);
        ResultList<UserInfoModel> result=new ResultList();
        result.setPage(page);
        result.setPageCount(userinfoSercvice.selectAllPageCount(rows));
        result.setRows(rows);
        result.setStatus("OK");
        result.setList(list);
        System.out.println("分页"+list);
        result.setMessage("查看小页面前分发");
        return result;
    }
    //显示图片
    @RequestMapping("/photo")
    public ResponseEntity<byte[]> showPhoto(UserInfoModel userInfoModel ) throws Exception{
        //System.out.println("回传的userinfoid为："+userInfoModel.getUserinfoid());
        UserInfoModel uim=userinfoSercvice.selectone(userInfoModel);
        //System.out.println("产品的图片类型是："+bpm.getBp_contenttype());
        if(uim!=null&&!uim.getU_contenttype().equals(null)) {
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("Content-Type", uim.getU_contenttype());
            return new ResponseEntity<byte[]>(uim.getU_touxiang(), responseHeaders, HttpStatus.OK);
        }
        else {
            return null;
        }
    }
    //查询
    @RequestMapping(value="/select")
    public ResultOne<UserInfoModel> selectuserinfo(UserInfoModel userInfoModel) throws Exception{
        UserInfoModel uim=userinfoSercvice.selectone(userInfoModel);
        ResultOne<UserInfoModel> result=new ResultOne();
        result.setStatus("OK");
        result.setResult(uim);
        result.setMessage("修改页面前分发");
       // System.out.println("result:"+result);
        return result;
    }
    //修改页面后处理方法
    @RequestMapping(value="/update")
    public ResultOne<String> update(@RequestParam(value = "pic",required = false) MultipartFile pic ,UserInfoModel userInfoModel) throws Exception{
        //dm.setUserModel(userModel);
        //System.out.println("进入产品方法,修改后的邮箱是："+userInfoModel.getU_youxiang());
        if(pic!=null&&(!pic.isEmpty())){
            userInfoModel.setU_filename(pic.getOriginalFilename()+pic.getOriginalFilename().substring(pic.getOriginalFilename().lastIndexOf(".")));
            userInfoModel.setU_contenttype(pic.getContentType());
            userInfoModel.setU_touxiang(pic.getBytes());
        }
        userinfoSercvice.update(userInfoModel);
        ResultOne<String> result=new ResultOne();
        result.setStatus("OK");
        result.setMessage("修改页面后处理");
        return result;
    }

}
