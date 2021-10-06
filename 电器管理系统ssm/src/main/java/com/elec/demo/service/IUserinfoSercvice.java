package com.elec.demo.service;

import com.elec.demo.dao.UserinfoDao;
import com.elec.demo.model.AgentsModel;
import com.elec.demo.model.UserInfoModel;
import org.apache.catalina.User;

import java.util.List;

public interface IUserinfoSercvice {
    void insert(UserInfoModel userInfoModel);
    UserInfoModel selectone(UserInfoModel userInfoModel);
    UserInfoModel selectonebyfirsttime(UserInfoModel userInfoModel);
    void delete(UserInfoModel userInfoModel);
    void update(UserInfoModel userInfoModel);
    UserInfoModel selectinfoandac(int UserinfoID);
    int selectAllCount();//取得个数总数
    int selectAllPageCount(int rows);//取得总页数
    List<UserInfoModel> getAll(int page, int rows);//获取产品对象列表
}
