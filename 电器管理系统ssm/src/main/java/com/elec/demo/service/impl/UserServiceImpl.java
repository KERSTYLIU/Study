package com.elec.demo.service.impl;

import com.elec.demo.dao.UserDao;
import com.elec.demo.model.UserInfoModel;
import com.elec.demo.model.UserModel;
import com.elec.demo.service.IUserService;
import org.apache.tomcat.util.buf.UDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    UserDao userDao;

    @Override
    public void deleteac(UserModel userModel) {
        userDao.deleteac(userModel);
    }

    @Override
    public int selectAllacCount() {
        return userDao.selectAllacCount();
    }

    @Override
    public int selectAllacPageCount(int rows) {
        int count= userDao.selectAllacCount();
        // System.out.println("count:"+count);
        //System.out.println("rows："+rows);
        int pagecount = (int) Math.ceil(count/(rows/1.0));
        //System.out.println("pagecount"+pagecount);
        return pagecount;
    }

    @Override
    public List<UserModel> selectAllac(int page, int rows) {
        List<UserModel> list = userDao.selectAllac(page,rows);
        return list;
    }

    @Override
    public void updatemima(UserModel userModel) {
        userDao.updatemima(userModel);
    }

    @Override
    public UserModel selectone(UserModel userModel) {
        return userDao.selectone(userModel);
    }

    @Override
    public UserModel login(UserModel userModel) {
        return userDao.login(userModel);
    }

    @Override
    public void regist(UserModel userModel) {
        userDao.regist(userModel);
    }
}
