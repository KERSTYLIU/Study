package com.elec.demo.controller;

import com.elec.demo.model.AgentsModel;
import com.elec.demo.model.BankProductModel;
import com.elec.demo.result.ResultList;
import com.elec.demo.result.ResultOne;
import com.elec.demo.service.IAgentsService;
import com.elec.demo.service.IBankProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins="*",maxAge=3600)
@RequestMapping(value="/agents")
public class AgentsController {
    @Autowired
    IAgentsService agentsService;

    //查询前分发方法
    @RequestMapping(value="/tolist")
    public ResultList<AgentsModel> tofrontlist(@RequestParam(value="page",required=false,defaultValue="0") int page, @RequestParam(value="rows",required=false,defaultValue="5") int rows) throws Exception{
        List<AgentsModel> list=agentsService.getAll(page,rows);
        ResultList<AgentsModel> result=new ResultList();
        result.setPage(page);
        result.setPageCount(agentsService.selectAllPageCount(rows));
        result.setRows(rows);
        result.setStatus("OK");
        result.setList(list);
        System.out.println("分页"+list);
        result.setMessage("查看小页面前分发");
        return result;
    }
    @RequestMapping(value = "/asadd")
    ResultOne<AgentsModel> bpadd( AgentsModel agentsModel) throws IOException {
        ResultOne<AgentsModel> result = new ResultOne();
        System.out.println("进入添加业务");
//        if(bppic!=null&&(!bppic.isEmpty())){
//            bankProductModel.setBp_filename(bppic.getOriginalFilename()+bppic.getOriginalFilename().substring(bppic.getOriginalFilename().lastIndexOf(".")));
//            bankProductModel.setBp_contenttype(bppic.getContentType());
//            bankProductModel.setBp_tupian(bppic.getBytes());
//        }

        agentsService.insert(agentsModel);
        result.setStatus("OK");
        result.setMessage("添加成功*-*");
        return  result;
    }
    //删除
    @RequestMapping(value="/delete")
    public ResultOne<String> delete(AgentsModel agentsModel) throws Exception{
        System.out.println("进入代理删除方法");
        agentsService.delete(agentsModel);
        ResultOne<String> result=new ResultOne();
        result.setStatus("OK");
        result.setMessage("删除页面后处理");
        return result;
    }
    //修改页面前分发方法
    @RequestMapping(value="/toupdate")
    public ResultOne<AgentsModel> toupdate(@RequestParam int no) throws Exception{
        System.out.println("修改页面前分发方法"+no);
        AgentsModel agentsModel = new AgentsModel();
        agentsModel.setAs_id(no);
        AgentsModel agm=agentsService.selectone(agentsModel);
        ResultOne<AgentsModel> result=new ResultOne();
        result.setStatus("OK");
        result.setResult(agm);
        result.setMessage("修改页面前分发");
        System.out.println("result:"+result);
        return result;
    }
    //修改页面后处理方法
    @RequestMapping(value="/update")
    public ResultOne<String> update(AgentsModel agentsModel) throws Exception{
        //dm.setUserModel(userModel);
        System.out.println("进入业务方法,修改后的介绍是："+agentsModel.getAs_beizhu());
        agentsService.update(agentsModel);
        ResultOne<String> result=new ResultOne();
        result.setStatus("OK");
        result.setMessage("修改页面后处理");
        return result;
    }

}
