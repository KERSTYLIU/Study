package com.elec.demo.dao;

import com.elec.demo.model.AgentsModel;
import com.elec.demo.model.BankProductModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AgentsDao {
    //增加一个
    @Insert("insert into t_agents(as_jiage,as_geshu,as_beizhu) values(#{as_jiage},#{as_geshu},#{as_beizhu})")
    void insert(AgentsModel agentsModel);
    //查询一个
    @Select("select * from t_agents where as_id = #{as_id}")
    AgentsModel selectone(AgentsModel agentsModel);
    //删除一条
    @Delete("delete from t_agents where as_id = #{as_id}")
    void delete(AgentsModel agentsModel);
    @Update("update t_agents set as_jiage = #{as_jiage},as_geshu = #{as_geshu},as_beizhu = #{as_beizhu} where as_id =#{as_id} ")
    void update(AgentsModel agentsModel);
    @Select("select count(*) from t_agents")
    int selectAllCount();
    @Select("select * from t_agents order by as_id asc limit #{page},#{rows}")
    List<AgentsModel> selectAll(@Param("page")  int page, @Param("rows" )int rows);
}
