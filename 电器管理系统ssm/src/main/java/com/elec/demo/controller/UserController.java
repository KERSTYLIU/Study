package com.elec.demo.controller;

import com.elec.demo.model.AgentsModel;
import com.elec.demo.model.BankProductModel;
import com.elec.demo.model.UserInfoModel;
import com.elec.demo.model.UserModel;
import com.elec.demo.result.ResultList;
import com.elec.demo.result.ResultOne;
import com.elec.demo.service.IBankProductService;
import com.elec.demo.service.IUserService;
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins="*",maxAge=3600)
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private IUserService uerService;
    @Autowired
    IUserinfoSercvice userinfoSercvice;
    @Autowired
    IBankProductService bankProductService;

//    //显示图片
//    @RequestMapping("/photo")
//    public ResponseEntity<byte[]> showPhoto(@RequestParam int id) throws Exception{
//        UserModel bm=uerService.getById(id);
//        if(bm!=null&&!bm.getContenttype().equals(null)) {
//            HttpHeaders responseHeaders = new HttpHeaders();
//            responseHeaders.set("Content-Type", bm.getContenttype());
//            return new ResponseEntity<byte[]>(bm.getPhoto(), responseHeaders, HttpStatus.OK);
//        }
//        else {
//            return null;
//        }
//    }
//查询前分发方法
@RequestMapping(value="/tolist")
public ResultList<UserModel> tofrontlist(@RequestParam(value="page",required=false,defaultValue="0") int page, @RequestParam(value="rows",required=false,defaultValue="5") int rows) throws Exception{
    List<UserModel> list=uerService.selectAllac(page,rows);
    ResultList<UserModel> result=new ResultList();
    result.setPage(page);
    result.setPageCount(uerService.selectAllacPageCount(rows));
    result.setRows(rows);
    result.setStatus("OK");
    result.setList(list);
    //System.out.println("分页"+list);
    result.setMessage("查看小页面前分发");
    return result;
}
    @RequestMapping(value="/delete")
    public ResultOne<String> delete(UserModel userModel) throws Exception{
        //System.out.println("进入代理删除方法");
        uerService.deleteac(userModel);
        ResultOne<String> result=new ResultOne();
        result.setStatus("OK");
        result.setMessage("删除页面后处理");
        return result;
    }

    //增加后处理方法
    @RequestMapping(value="/regist")
    public ResultOne<UserModel> regist(UserModel userModel) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        int i=10/0;
        //System.out.println("userModel: "+userModel.getU_zhanghao());
        Date d = new Date();
        String sDate=df.format(d);
        System.out.println(sDate);

        UserInfoModel uim = new UserInfoModel();
        uim.setU_ac_firsttime(sDate);
        userinfoSercvice.insert(uim);
        UserInfoModel userInfoModel = userinfoSercvice.selectonebyfirsttime(uim);
        System.out.println("取得新增infoId为："+userInfoModel.getUserinfoid());
        userModel.setUserinfoid(userInfoModel.getUserinfoid());
        System.out.println(userModel.getUserinfoid());
        ResultOne<UserModel> result=new ResultOne();
        uerService.regist(userModel);
        result.setStatus("OK");
        result.setMessage("增加页面后处理");


        return result;
    }
//    //修改页面前分发方法
//    @RequestMapping(value="/toupdate")
//    public ResultOne<UserModel> toupdate(@RequestParam int id) throws Exception{
//        UserModel am=uerService.getById(id);
//        ResultOne<UserModel> result=new ResultOne();
//        result.setStatus("OK");
//        result.setResult(am);
//        result.setMessage("修改页面前分发");
//        return result;
//    }
//
//    //修改页面后处理方法
//    @RequestMapping(value="/update")
//    public ResultOne<String> modify(@RequestParam(value ="userphoto",required=false) MultipartFile userphoto, UserModel userModel) throws Exception{
//        ResultOne<String> result=new ResultOne();
//        if(userphoto!=null&&(!userphoto.isEmpty()))
//        {
//            userModel.setFilename("photo"+userModel.getUserid()+userphoto.getOriginalFilename().substring(userphoto.getOriginalFilename().lastIndexOf(".")));
//            userModel.setContenttype(userphoto.getContentType());
//            userModel.setPhoto(userphoto.getBytes());
//        }
//        uerService.add(userModel);
//        result.setStatus("OK");
//        result.setMessage("修改页面后处理");
//        return result;
//    }
//    //删除页面前分发方法
//    @RequestMapping(value="/todalete")
//    public ResultOne<UserModel> todelete(@RequestParam int id) throws Exception{
//        UserModel am=uerService.getById(id);
//
//        ResultOne<UserModel> result=new ResultOne();
//        result.setStatus("OK");
//        result.setResult(am);
//        result.setMessage("删除页面前分发");
//        return result;
//    }
//    //删除页面后处理方法
//    @RequestMapping(value="/delete")
//    public ResultOne<String> delete(UserModel um) throws Exception{
//        uerService.delete(um);
//        ResultOne<String> result=new ResultOne();
//        result.setStatus("OK");
//        result.setMessage("删除页面后处理");
//        return result;
//    }
//    //查看单个页面的前分发方法
//    @RequestMapping(value="/toone")
//    public ResultOne<UserModel> toview(@RequestParam int id) throws Exception{
//        UserModel am=uerService.getById(id);
//        ResultOne<UserModel> result=new ResultOne();
//        result.setResult(am);
//        result.setStatus("OK");
//        result.setMessage("查看单个前分发");
//        return result;
//    }
//    //查询前分发方法
//    @RequestMapping(value="/tolist")
//    public ResultList<UserModel> tofrontlist(@RequestParam(value="page",required=false,defaultValue="0") int page, @RequestParam(value="rows",required=false,defaultValue="5") int rows) throws Exception{
//        List<UserModel> list=uerService.getAll(page,rows);
//        ResultList<UserModel> result=new ResultList();
//        result.setCount(uerService.selectAllCount());
//        result.setPage(page);
//        result.setPageCount(uerService.selectAllPageCount(rows));
//        result.setRows(rows);
//        result.setStatus("OK");
//        result.setList(list);
//        result.setMessage("查看页面前分发");
//        return result;
//    }
    //登录检查
    @RequestMapping(value="/tologin")
    public ResultOne<UserModel> tologin(UserModel userModel){

        UserModel um=uerService.login(userModel);

        ResultOne<UserModel> result=new ResultOne();
        if (um==null)
        {
            result.setStatus("error");
            result.setMessage("登录失败");
        }
        else{
            result.setResult(um);
            result.setStatus("OK");
            result.setMessage("登录成功");
        }
        return result;
    }
    @RequestMapping(value="/selectuser")
    public ResultOne<UserModel> selectuser(UserModel userModel){
        //System.out.println("前端传进来的userid:"+userModel.getUserid()+"userindfoid为："+userModel.getUserinfoid());
        UserModel um = uerService.selectone(userModel);
        //System.out.println("后台传查找到的userid:"+um.getUserid()+"userindfoid为："+um.getUserinfoid());
        ResultOne<UserModel> result = new ResultOne();
        result.setResult(um);
        result.setStatus("OK");
        result.setMessage("成功");
        return result;
    }
    //修改页面后处理方法
    @RequestMapping(value="/update")
    public ResultOne<String> update(UserModel userModel) throws Exception{
        uerService.updatemima(userModel);
        ResultOne<String> result=new ResultOne();
        result.setStatus("OK");
        result.setMessage("修改页面后处理");
        return result;
    }

//    @RequestMapping(value="/useraddbp")
//    public ResultOne<String> useraddbp(BankProductModel bankProductModel) throws Exception{
//        BankProductModel bpm = bankProductService.selectone(bankProductModel);
//        UserModel um = new UserModel();
//        List<BankProductModel> bankProductModelList = new ArrayList();
//        bankProductModelList.add(bpm);
//        um.setBankProductModelLis(bankProductModelList);
//        ResultOne<String> result=new ResultOne();
//        result.setStatus("OK");
//        result.setMessage("修改页面后处理");
//        return result;
//    }


}
