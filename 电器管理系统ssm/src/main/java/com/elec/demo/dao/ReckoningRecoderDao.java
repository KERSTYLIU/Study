package com.elec.demo.dao;

import com.elec.demo.model.ReckoningRecoderModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReckoningRecoderDao {
    @Select("select * from t_reckoning_recoder where r_id = #{r_id}")
    ReckoningRecoderModel selectbyid(int r_id);
    @Insert("insert into t_reckoning_recoder(r_zhifudangshi,r_fukuanshijian,r_shoukuanshijian,r_shoukuanfang,r_neirou,userid) values(#{r_zhifudangshi},#{r_fukuanshijian},#{r_shoukuanshijian},#{r_shoukuanfang},#{r_neirou},#{userid})")
    void add (ReckoningRecoderModel reckoningRecoderModel);
    @Select("select * from t_reckoning_recoder where userid = #{userid}")
    List<ReckoningRecoderModel> selectall(ReckoningRecoderModel reckoningRecoderModel);

}
