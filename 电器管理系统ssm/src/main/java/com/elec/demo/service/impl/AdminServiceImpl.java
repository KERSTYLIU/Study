package com.elec.demo.service.impl;

import com.elec.demo.dao.AdminDao;
import com.elec.demo.model.AdminUserModel;
import com.elec.demo.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    AdminDao admindao;
    @Override
    public AdminUserModel login(AdminUserModel adminUserModel) {
        return admindao.login(adminUserModel);
    }
}
