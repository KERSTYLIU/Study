package com.elec.demo.controller;

import com.elec.demo.model.BankProductModel;
import com.elec.demo.model.ElectricModel;
import com.elec.demo.model.UserModel;
import com.elec.demo.result.ResultList;
import com.elec.demo.result.ResultOne;
import com.elec.demo.service.IBankProductService;
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
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin(origins="*",maxAge=3600)
@RequestMapping(value="/bankproduct")
public class BankProductController {
    @Autowired
    IBankProductService bankProductService;
    //显示图片
    @RequestMapping("/photo")
    public ResponseEntity<byte[]> showPhoto(BankProductModel bankProductModel ) throws Exception{
        //System.out.println("回传的产品编号为："+bankProductModel.getBp_id());
        BankProductModel bpm=bankProductService.selectone(bankProductModel);
        //System.out.println("产品的图片类型是："+bpm.getBp_contenttype());
        if(bpm!=null&&!bpm.getBp_contenttype().equals(null)) {
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("Content-Type", bpm.getBp_contenttype());
            return new ResponseEntity<byte[]>(bpm.getBp_tupian(), responseHeaders, HttpStatus.OK);
        }
        else {
            return null;
        }
    }

    @RequestMapping(value = "/bpadd")
    ResultOne<BankProductModel> bpadd(@RequestParam(value = "bppic",required = false) MultipartFile bppic ,BankProductModel bankProductModel) throws IOException {
        ResultOne<BankProductModel> result = new ResultOne();
        System.out.println("进入添加产品");
        if(bppic!=null&&(!bppic.isEmpty())){
            bankProductModel.setBp_filename(bppic.getOriginalFilename()+bppic.getOriginalFilename().substring(bppic.getOriginalFilename().lastIndexOf(".")));
            bankProductModel.setBp_contenttype(bppic.getContentType());
            bankProductModel.setBp_tupian(bppic.getBytes());
        }

        bankProductService.insert(bankProductModel);
        result.setStatus("OK");
        result.setMessage("添加成功*-*");
        return  result;
    }

    //查询前分发方法
    @RequestMapping(value="/tolist")
    public ResultList<BankProductModel> tofrontlist(@RequestParam(value="page",required=false,defaultValue="0") int page, @RequestParam(value="rows",required=false,defaultValue="6") int rows) throws Exception{
        List<BankProductModel> list=bankProductService.getAll(page,rows);
        ResultList<BankProductModel> result=new ResultList();
        result.setPage(page);
        result.setPageCount(bankProductService.selectAllPageCount(rows));
        result.setRows(rows);
        result.setStatus("OK");
        result.setList(list);
        System.out.println("分页"+list);
        result.setMessage("查看小页面前分发");
        return result;
    }
    //删除
    @RequestMapping(value="/delete")
    public ResultOne<String> delete(BankProductModel bankProductModel) throws Exception{
        System.out.println("进入产品删除方法");
        bankProductService.delete(bankProductModel);
        ResultOne<String> result=new ResultOne();
        result.setStatus("OK");
        result.setMessage("删除页面后处理");
        return result;
    }
    //删除
    @RequestMapping(value="/todelete")
    public ResultOne<BankProductModel> todelete(@RequestParam int no) throws Exception{
        BankProductModel bankProductModel = new BankProductModel();
        bankProductModel.setBp_id(no);
        System.out.println("...................................................................");
        System.out.println("要删除产品的编号为："+no);
        BankProductModel bpm = bankProductService.selectone(bankProductModel);
        ResultOne<BankProductModel> result=new ResultOne();
        result.setStatus("OK");
        result.setResult(bpm);
        result.setMessage("删除页面前分发");
        return result;
    }
    //修改页面前分发方法
    @RequestMapping(value="/toupdate")
    public ResultOne<BankProductModel> toupdate(@RequestParam int no) throws Exception{
        System.out.println("修改页面前分发方法"+no);
        BankProductModel bankProductModel = new BankProductModel();
        bankProductModel.setBp_id(no);
        BankProductModel bpm=bankProductService.selectone(bankProductModel);
        ResultOne<BankProductModel> result=new ResultOne();
        result.setStatus("OK");
        result.setResult(bpm);
        result.setMessage("修改页面前分发");
        System.out.println("result:"+result);
        return result;
    }
    //修改页面后处理方法
    @RequestMapping(value="/update")
    public ResultOne<String> update(@RequestParam(value = "bppic",required = false) MultipartFile bppic ,BankProductModel bankProductModel) throws Exception{
        //dm.setUserModel(userModel);
        System.out.println("进入产品方法,修改后的介绍是："+bankProductModel.getBp_jieshao());
        if(bppic!=null&&(!bppic.isEmpty())){
            bankProductModel.setBp_filename(bppic.getOriginalFilename()+bppic.getOriginalFilename().substring(bppic.getOriginalFilename().lastIndexOf(".")));
            bankProductModel.setBp_contenttype(bppic.getContentType());
            bankProductModel.setBp_tupian(bppic.getBytes());
        }
        bankProductService.update(bankProductModel);
        ResultOne<String> result=new ResultOne();
        result.setStatus("OK");
        result.setMessage("修改页面后处理");
        return result;
    }
//    @RequestMapping(value="/add")
//    public ResultOne<String> add(@RequestParam(value ="userphoto",required=false) MultipartFile userphoto, UserModel userModel) throws Exception{
////        int i=10/0;
//        ResultOne<String> result=new ResultOne();
//        if(userphoto!=null&&(!userphoto.isEmpty()))
//        {
//            userModel.setFilename("photo"+userModel.getUserid()+userphoto.getOriginalFilename().substring(userphoto.getOriginalFilename().lastIndexOf(".")));
//            userModel.setContenttype(userphoto.getContentType());
//            userModel.setPhoto(userphoto.getBytes());
//        }
//        uerService.add(userModel);
//        result.setStatus("OK");
//        result.setMessage("增加页面后处理");
//
//
//        return result;
//    }


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



}
