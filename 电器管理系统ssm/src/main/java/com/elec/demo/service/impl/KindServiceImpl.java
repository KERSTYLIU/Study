package com.elec.demo.service.impl;

import com.elec.demo.dao.KindDao;
import com.elec.demo.model.KindModel;
import com.elec.demo.service.IKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class KindServiceImpl implements IKindService {
    @Autowired
    KindDao kindDao;
    public void setKindDao(KindDao kindDao){
        this.kindDao = kindDao;
    }
    @Override//增加
    public void add(KindModel kindModel) {
        kindDao.insert(kindModel);
    }

    @Override//修改
    public void modify(KindModel kindModel) {
        kindDao.update(kindModel);
    }

    @Override//删除
    public void delete(KindModel kindModel) {
        kindDao.delete(kindModel);

    }

    @Override//根据id获取对象
    public KindModel getById(int id) {
        KindModel kindModel = kindDao.selectById(id);
        return kindModel;
    }

    @Override//获取全部列表，分页
    public List<KindModel> getAll(int page, int rows) {
        List<KindModel> list = kindDao.selectAll(page,rows);
        return list;
    }

    @Override//获取所有的个数
    public int selectAllCount() {
        return kindDao.selectAllCount();
    }

    @Override//获取总页数
    public int selectAllPageCount(int rows) {
        int count= kindDao.selectAllCount();
        int pagecount = (int) Math.ceil(count/(rows/1.0));
        return pagecount;
    }
}
