package com.elec.demo.service.impl;

import com.elec.demo.dao.UserDao;
import com.elec.demo.dao.UserinfoDao;
import com.elec.demo.model.AgentsModel;
import com.elec.demo.model.UserInfoModel;
import com.elec.demo.service.IUserinfoSercvice;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserinfoImpl implements IUserinfoSercvice {

    @Autowired
    UserinfoDao userinfoDao;

    @Override
    public UserInfoModel selectonebyfirsttime(UserInfoModel userInfoModel) {
        return userinfoDao.selectonebyfirsttime(userInfoModel);
    }

    @Override
    public UserInfoModel selectinfoandac(int UserinfoID) {
        return userinfoDao.selectinfoandac(UserinfoID);
    }

    @Override
    public void insert(UserInfoModel userInfoModel) {
        userinfoDao.insert(userInfoModel);
    }

    @Override
    public UserInfoModel selectone(UserInfoModel userInfoModel) {
        return userinfoDao.selectone(userInfoModel);
    }

    @Override
    public void delete(UserInfoModel userInfoModel) {
        userinfoDao.delete(userInfoModel);
    }

    @Override
    public void update(UserInfoModel userInfoModel) {
        userinfoDao.update(userInfoModel);
    }

    @Override
    public int selectAllCount() {

        return userinfoDao.selectAllCount();
    }

    @Override
    public int selectAllPageCount(int rows) {
        int count= userinfoDao.selectAllCount();
       // System.out.println("count:"+count);
        //System.out.println("rows："+rows);
        int pagecount = (int) Math.ceil(count/(rows/1.0));
        //System.out.println("pagecount"+pagecount);
        return pagecount;
    }

    @Override
    public List<UserInfoModel> getAll(int page, int rows) {
        List<UserInfoModel> list = userinfoDao.selectAll(page,rows);
        return list;
    }
}
