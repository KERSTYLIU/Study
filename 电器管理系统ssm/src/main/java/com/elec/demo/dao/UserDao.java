package com.elec.demo.dao;

import com.elec.demo.model.AgentsModel;
import com.elec.demo.model.UserModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserDao {
    @Select("select * from t_sp_users_ac where userid = #{userid}")
    @Results(value = {
            @Result(property = "userInfoModel", column = "userinfoid",
                    many = @Many(select = "com.elec.demo.dao.UserinfoDao.selectinfoandac"))
    })
    UserModel selectone (UserModel userModel);
    @Select("select * from t_sp_users_ac where u_zhanghao = #{u_zhanghao} and u_mima = #{u_mima}")
    UserModel login (UserModel userModel);
    @Delete("delete from t_sp_users_ac where userid = #{userid}")
    void deleteac(UserModel userModel);
    @Insert("insert into t_sp_users_ac(u_zhanghao,u_mima,userinfoid) values(#{u_zhanghao},#{u_mima},#{userinfoid})")
    void regist(UserModel userModel);
    @Update("update t_sp_users_ac set u_mima = #{u_mima} where userid =#{userid} ")
    void updatemima(UserModel userModel);
    @Select("select count(*) from t_sp_users_ac")
    int selectAllacCount();
    @Select("select * from t_sp_users_ac limit #{page},#{rows}")
    List<UserModel> selectAllac(@Param("page")  int page, @Param("rows" )int rows);

}
