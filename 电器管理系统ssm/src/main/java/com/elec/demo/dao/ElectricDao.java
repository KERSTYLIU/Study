package com.elec.demo.dao;

import com.elec.demo.model.ElectricModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ElectricDao {
    void insert(ElectricModel electricModel);
    void insertKind(@Param("eid") int id,@Param("kinds") int kinds[]);
    void update(ElectricModel electricModel);
    void deleteKind(@Param("eid") int id);
    void delete(ElectricModel electricModel);
    int selectAllCount();
    ElectricModel selectById(@Param("eid") int id);
    List<ElectricModel> selectAll(@Param("page")  int page, @Param("rows" )int rows);
}
