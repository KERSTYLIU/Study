package com.elec.demo.dao;

import com.elec.demo.model.AgentsModel;
import com.elec.demo.model.UserInfoModel;
import com.elec.demo.model.UserModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserinfoDao {
    //增加一个
    @Insert("insert into t_sp_users_info(u_xingming,u_xingbie,u_ac_firsttime,u_shoujihao,u_touxiang,u_contenttype,u_filename,u_nianlin,u_xueli,u_youxiang) values(#{u_xingming},#{u_xingbie},#{u_ac_firsttime},#{u_shoujihao},#{u_touxiang},#{u_contenttype},#{u_filename},#{u_nianlin},#{u_xueli},#{u_youxiang})")
    void insert(UserInfoModel userInfoModel);
    //查询一个
    @Select("select * from t_sp_users_info where u_ac_firsttime = #{u_ac_firsttime}")
    UserInfoModel selectonebyfirsttime(UserInfoModel userInfoModel);
    //查询一个
    @Select("select * from t_sp_users_info where userinfoid = #{userinfoid}")
    UserInfoModel selectone(UserInfoModel userInfoModel);
    //用户账号表与信息表关联查询一个
    @Select("SELECT * from t_sp_users_info where UserinfoID = #{UserinfoID}")
    UserInfoModel selectinfoandac(int UserinfoID);
    //删除一条
    @Delete("delete from t_sp_users_info where userinfoid = #{userinfoid}")
    void delete(UserInfoModel userInfoModel);
    @Update("update t_sp_users_info set u_xingming = #{u_xingming},u_xingbie = #{u_xingbie},u_ac_firsttime = #{u_ac_firsttime},u_shoujihao = #{u_shoujihao},u_touxiang = #{u_touxiang},u_contenttype = #{u_contenttype},u_filename = #{u_filename},u_nianlin = #{u_nianlin},u_xueli = #{u_xueli},u_youxiang = #{u_youxiang} where userinfoid =#{userinfoid} ")
    void update(UserInfoModel userInfoModel);
    @Select("select count(*) from t_sp_users_info")
    int selectAllCount();
    @Select("select * from t_sp_users_info order by userinfoid asc limit #{page},#{rows}")
    List<UserInfoModel> selectAll(@Param("page")  int page, @Param("rows" )int rows);
}
