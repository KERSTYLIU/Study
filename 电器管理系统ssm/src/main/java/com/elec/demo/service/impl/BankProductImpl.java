package com.elec.demo.service.impl;

import com.elec.demo.dao.BankProductDao;
import com.elec.demo.model.BankProductModel;
import com.elec.demo.model.ElectricModel;
import com.elec.demo.service.IBankProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankProductImpl implements IBankProductService {
    @Autowired
    BankProductDao bankProductDao;
    @Override
    public void insert(BankProductModel bankProductModel) {
       bankProductDao.insert(bankProductModel);
    }

    @Override
    public BankProductModel selectone(BankProductModel bankProductModel) {
        return bankProductDao.selectone(bankProductModel);
    }

    @Override
    public List<BankProductModel> selectall() {
        return null;
    }


    @Override
    public void delete(BankProductModel bankProductModel) {
        bankProductDao.delete(bankProductModel);
    }

    @Override
    public void update(BankProductModel bankProductModel) {
        bankProductDao.update(bankProductModel);
    }

    @Override
    public int selectAllCount() {
        return bankProductDao.selectAllCount();
    }

    @Override
    public int selectAllPageCount(int rows) {
        int count= bankProductDao.selectAllCount();
        int pagecount = (int) Math.ceil(count/(rows/1.0));
        return pagecount;
    }

    @Override
    public List<BankProductModel> getAll(int page, int rows) {
        List<BankProductModel> list = bankProductDao.selectAll(page,rows);
        return list;
    }

}
