package com.elec.demo.dao;

import com.elec.demo.model.KindModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface KindDao {
    void insert(KindModel kindModel);
    void update(KindModel kindModel);
    void delete(KindModel kindModel);
    int selectAllCount();
    KindModel selectById(@Param("kid") int id);
    List<KindModel> selectAll(@Param("page")  int page, @Param("rows" )int rows);
}
