package com.elec.demo.service;


import com.elec.demo.model.ElectricModel;

import java.util.List;

public interface IElectricService {
    void add(ElectricModel electricModel);
    void addkind(int eid,int kinds[]);//增加课程
    void modify(ElectricModel electricModel);
    void modifykind(int eid, int kinds[]);
    void delete(ElectricModel electricModel);
    ElectricModel getById(int id);//根据id获取电器对象
    List<ElectricModel> getAll(int page, int rows);//获取电器对象列表
    int selectAllCount();//取得电器个数总数
    int selectAllPageCount(int rows);//取得总页数
}
