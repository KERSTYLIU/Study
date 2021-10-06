package com.elec.demo.dao;

import com.elec.demo.model.BankProductModel;
import com.elec.demo.model.ElectricModel;
import com.elec.demo.model.UserInfoModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BankProductDao {
    @Insert("insert into t_bankproduct(bp_name,bp_tupian,bp_contenttype,bp_filename,bp_lilv,bp_kaishishijian,bp_jieshushijian,bp_jieshao,bp_dingqi) values(#{bp_name},#{bp_tupian},#{bp_contenttype},#{bp_filename},#{bp_lilv},#{bp_kaishishijian},#{bp_jieshushijian},#{bp_jieshao},#{bp_dingqi})")
    void insert(BankProductModel bankProductModel);
    @Select("select * from t_bankproduct where bp_id = #{bp_id}")
    BankProductModel selectone(BankProductModel bankProductModel);
    @Select("select * from t_bankproduct where bp_id = #{bp_id}")
    BankProductModel selectonebyid(int  bp_id);
//    @Select("select * from t_bankproduct")
//    List<BankProductModel> selectall();
    @Delete("delete from t_bankproduct where bp_id = #{bp_id}")
    void delete(BankProductModel bankProductModel);
    @Update("update t_bankproduct set bp_name = #{bp_name},bp_tupian = #{bp_tupian},bp_contenttype = #{bp_contenttype},bp_filename = #{bp_filename},bp_lilv = #{bp_lilv},bp_kaishishijian = #{bp_kaishishijian},bp_jieshushijian = #{bp_jieshushijian},bp_jieshao = #{bp_jieshao},bp_dingqi = #{bp_dingqi} where bp_id =#{bp_id} ")
    void update(BankProductModel bankProductModel);
    @Select("select count(*) from t_bankproduct")
    int selectAllCount();
    @Select("select * from t_bankproduct order by bp_id asc limit #{page},#{rows}")
    List<BankProductModel> selectAll(@Param("page")  int page, @Param("rows" )int rows);
}
