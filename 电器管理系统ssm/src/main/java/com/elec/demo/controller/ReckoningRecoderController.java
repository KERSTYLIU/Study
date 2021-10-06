package com.elec.demo.controller;

import com.elec.demo.model.ElectricModel;
import com.elec.demo.model.ReckoningRecoderModel;
import com.elec.demo.model.UserModel;
import com.elec.demo.result.ResultList;
import com.elec.demo.result.ResultOne;
import com.elec.demo.service.IReckoningRecoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins="*",maxAge=3600)
@RequestMapping(value="/reckoningrecoder")
public class ReckoningRecoderController {
    @Autowired
    IReckoningRecoderService reckoningRecoderService;
    //增加页面后处理方法
    @RequestMapping(value="/add")
    public ResultOne<String> add(ReckoningRecoderModel rm) throws Exception{
        reckoningRecoderService.add(rm);
        //System.out.println("userid"+rm.getUserid());
        ResultOne<String> result = new ResultOne();
        result.setStatus("OK");
        result.setMessage("增加页面后处理");
        return result;
    }
    //增加页面后处理方法
    @RequestMapping(value="/selectall")
    public ResultList<ReckoningRecoderModel> selectall(ReckoningRecoderModel rm) throws Exception{
        List<ReckoningRecoderModel> reckoningRecoderModelList = reckoningRecoderService.selectall(rm);
        System.out.println("userid"+rm.getUserid());
        ResultList<ReckoningRecoderModel>  result = new ResultList();
        result.setList(reckoningRecoderModelList);
        result.setStatus("OK");
        result.setMessage("增加页面后处理");
        return result;
    }
}
