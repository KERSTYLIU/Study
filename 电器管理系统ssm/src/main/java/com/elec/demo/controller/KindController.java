package com.elec.demo.controller;

import com.elec.demo.model.KindModel;
import com.elec.demo.result.ResultList;
import com.elec.demo.result.ResultOne;
import com.elec.demo.service.IKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins="*",maxAge=3600)
@RequestMapping(value="/kind")
public class KindController {
    @Autowired
    IKindService kindService;
    //增加页面后处理方法
    @RequestMapping(value="/add")
    public ResultOne<String> add(KindModel dm) throws Exception{
        kindService.add(dm);
        ResultOne<String> result=new ResultOne();
        result.setStatus("OK");
        result.setMessage("增加页面后处理");
        return result;
    }
    //修改页面前分发方法
    @RequestMapping(value="/toupdate")
    public ResultOne<KindModel> toupdate(@RequestParam int no) throws Exception{
        KindModel am=kindService.getById(no);
        ResultOne<KindModel> result=new ResultOne();
        result.setStatus("OK");
        result.setResult(am);
        result.setMessage("修改页面前分发");
        return result;
    }
    //修改页面后处理方法
    @RequestMapping(value="/update")
    public ResultOne<String> modify(KindModel dm) throws Exception{
        kindService.modify(dm);
        ResultOne<String> result=new ResultOne();
        result.setStatus("OK");
        result.setMessage("修改页面后处理");
        return result;
    }
    //删除页面前分发方法
    @RequestMapping(value="/todalete")
    public ResultOne<KindModel> todelete(@RequestParam int no) throws Exception{
        KindModel am=kindService.getById(no);

        ResultOne<KindModel> result=new ResultOne();
        result.setStatus("OK");
        result.setResult(am);
        result.setMessage("删除页面前分发");
        return result;
    }
    //删除页面后处理方法
    @RequestMapping(value="/delete")
    public ResultOne<String> delete(KindModel dm) throws Exception{
        kindService.delete(dm);
        ResultOne<String> result=new ResultOne();
        result.setStatus("OK");
        result.setMessage("删除页面后处理");
        return result;
    }
    //查看单个页面的前分发方法
    @RequestMapping(value="/toone")
    public ResultOne<KindModel> toview(@RequestParam int no) throws Exception{
        KindModel am=kindService.getById(no);
        ResultOne<KindModel> result=new ResultOne();
        result.setResult(am);
        result.setStatus("OK");
        result.setMessage("查看单个前分发");
        return result;
    }
    //查询前分发方法
    @RequestMapping(value="/tolist")
    public ResultList<KindModel> tofrontlist(@RequestParam(value="page",required=false,defaultValue="0") int page, @RequestParam(value="rows",required=false,defaultValue="5") int rows) throws Exception{
        List<KindModel> list=kindService.getAll(page,rows);
        ResultList<KindModel> result=new ResultList();
        result.setCount(kindService.selectAllCount());
        result.setPage(page);
        result.setPageCount(kindService.selectAllPageCount(rows));
        result.setRows(rows);
        result.setStatus("OK");
        result.setList(list);
        System.out.println("分页"+list);
        result.setMessage("查看页面前分发");
        return result;
    }
}
