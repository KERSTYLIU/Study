package com.elec.demo.controller;

import com.elec.demo.model.ElectricModel;
import com.elec.demo.model.UserModel;
import com.elec.demo.result.ResultList;
import com.elec.demo.result.ResultOne;
import com.elec.demo.service.IElectricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin(origins="*",maxAge=3600)
@RequestMapping(value="/electric")
public class ElectricController {
    @Autowired
    IElectricService electricService;
    //增加页面后处理方法
    @RequestMapping(value="/add")
    public ResultOne<String> add(ElectricModel dm, @RequestParam int[] kinds, @RequestParam int userid) throws Exception{
        UserModel userModel = new UserModel();//创建电器对象
        userModel.setUserid(userid);//给电器对象一个id
        dm.setUserModel(userModel);//将用户对象添加给电器对象
        electricService.add(dm);//增加电器对象到数据库  包含用户id
        electricService.addkind(dm.getEid(),kinds);//增加多对多关联到中间表
        ResultOne<String> result=new ResultOne();
        result.setStatus("OK");
        result.setMessage("增加页面后处理");
        return result;
    }
    //修改页面前分发方法
    @RequestMapping(value="/toupdate")
    public ResultOne<ElectricModel> toupdate(@RequestParam int no) throws Exception{
        ElectricModel am=electricService.getById(no);
        ResultOne<ElectricModel> result=new ResultOne();
        result.setStatus("OK");
        result.setResult(am);
        result.setMessage("修改页面前分发");
        return result;
    }
    //修改页面后处理方法
    @RequestMapping(value="/update")
    public ResultOne<String> modify(ElectricModel dm, @RequestParam int[] kinds, @RequestParam int userid) throws Exception{
        UserModel userModel = new UserModel();
        userModel.setUserid(userid);
        dm.setUserModel(userModel);
        electricService.modify(dm);
        electricService.modifykind(dm.getEid(),kinds);

        ResultOne<String> result=new ResultOne();
        result.setStatus("OK");
        result.setMessage("修改页面后处理");
        return result;
    }
    //删除页面前分发方法
    @RequestMapping(value="/todalete")
    public ResultOne<ElectricModel> todelete(@RequestParam int no) throws Exception{
        ElectricModel am=electricService.getById(no);

        ResultOne<ElectricModel> result=new ResultOne();
        result.setStatus("OK");
        result.setResult(am);
        result.setMessage("删除页面前分发");
        return result;
    }
    //删除页面后处理方法
    @RequestMapping(value="/delete")
    public ResultOne<String> delete(ElectricModel dm) throws Exception{
        electricService.delete(dm);
        ResultOne<String> result=new ResultOne();
        result.setStatus("OK");
        result.setMessage("删除页面后处理");
        return result;
    }
    //查看单个页面的前分发方法
    @RequestMapping(value="/toone")
    public ResultOne<ElectricModel> toview(@RequestParam int no) throws Exception{
        ElectricModel am=electricService.getById(no);
        ResultOne<ElectricModel> result=new ResultOne();
        result.setResult(am);
        result.setStatus("OK");
        result.setMessage("查看前分发");
        return result;
    }
    //查询前分发方法
    @RequestMapping(value="/tolist")
    public ResultList<ElectricModel> tofrontlist(@RequestParam(value="page",required=false,defaultValue="0") int page, @RequestParam(value="rows",required=false,defaultValue="5") int rows) throws Exception{
        List<ElectricModel> list=electricService.getAll(page,rows);
        ResultList<ElectricModel> result=new ResultList();
        result.setCount(electricService.selectAllCount());
        result.setPage(page);
        result.setPageCount(electricService. selectAllPageCount(rows));
        result.setRows(rows);
        result.setStatus("OK");
        result.setList(list);
        System.out.println("分页"+list);
        result.setMessage("查看小页面前分发");
        return result;
    }
}
