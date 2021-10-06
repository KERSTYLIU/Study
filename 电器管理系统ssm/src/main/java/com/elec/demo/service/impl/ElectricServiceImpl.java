package com.elec.demo.service.impl;

import com.elec.demo.dao.ElectricDao;
import com.elec.demo.model.ElectricModel;
import com.elec.demo.service.IElectricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ElectricServiceImpl implements IElectricService {
    @Autowired
    ElectricDao electricDao;
    public void setElectricDao(ElectricDao electricDao){
        this.electricDao = electricDao;
    }
    @Override
    public void add(ElectricModel electricModel) {
        electricDao.insert(electricModel);
    }

    @Override
    public void addkind(int eid, int[] kinds) {

            electricDao.insertKind(eid,kinds);


    }

    @Override
    public void modify(ElectricModel electricModel) {
        electricDao.update(electricModel);
    }

    @Override
    public void modifykind(int eid, int[] kinds) {
        electricDao.deleteKind(eid);
        electricDao.insertKind(eid,kinds);
    }

    @Override
    public void delete(ElectricModel electricModel) {
        electricDao.delete(electricModel);
        electricDao.deleteKind(electricModel.getEid());
    }

    @Override//根据id获取对象
    public ElectricModel getById(int id) {
        ElectricModel electricModel = electricDao.selectById(id);
        return electricModel;
    }

    @Override//获取总列表，分页
    public List<ElectricModel> getAll(int page, int rows) {
        List<ElectricModel> list = electricDao.selectAll(page,rows);
        return list;
    }

    @Override//获取总数
    public int selectAllCount() {
        return electricDao.selectAllCount();
    }

    @Override//获取总页数
    public int selectAllPageCount(int rows) {
        int count= electricDao.selectAllCount();
        int pagecount = (int) Math.ceil(count/(rows/1.0));
        return pagecount;
    }
}
