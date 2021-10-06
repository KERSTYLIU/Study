package com.elec.demo.dao;

import com.elec.demo.model.AdminUserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminDao {

    @Select("select * from t_ex_users where m_zhanghao = #{m_zhanghao} and m_mima = #{m_mima}")
    AdminUserModel login(AdminUserModel adminUserModel);
}
