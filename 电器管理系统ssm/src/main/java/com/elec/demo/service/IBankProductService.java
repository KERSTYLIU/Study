package com.elec.demo.service;

import com.elec.demo.model.BankProductModel;
import com.elec.demo.model.ElectricModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IBankProductService {
    void insert(BankProductModel bankProductModel);
    BankProductModel selectone(BankProductModel bankProductModel);
    List<BankProductModel> selectall();
    void delete(BankProductModel bankProductModel);
    void update(BankProductModel bankProductModel);
    int selectAllCount();//取得个数总数
    int selectAllPageCount(int rows);//取得总页数
    List<BankProductModel> getAll(int page, int rows);//获取产品对象列表
}
