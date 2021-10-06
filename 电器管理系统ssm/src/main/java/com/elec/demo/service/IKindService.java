package com.elec.demo.service;


import com.elec.demo.model.KindModel;

import java.util.List;

public interface IKindService {
    void add(KindModel kindModel);
    void modify(KindModel kindModel);
    void delete(KindModel kindModel);
    KindModel getById(int id);
    List<KindModel> getAll(int page, int rows);
    int selectAllCount();
    int selectAllPageCount(int rows);
}
