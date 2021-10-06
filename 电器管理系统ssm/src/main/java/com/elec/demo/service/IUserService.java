package com.elec.demo.service;

import com.elec.demo.model.UserInfoModel;
import com.elec.demo.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserService {
    UserModel selectone (UserModel userModel);
    UserModel login (UserModel userModel);
    void regist(UserModel userModel);
    void updatemima(UserModel userModel);
    void deleteac(UserModel userModel);
    int selectAllacCount();//取得个数总数
    int selectAllacPageCount(int rows);//取得总页数
    List<UserModel> selectAllac(int page, int rows);//获取产品对象列表

}
