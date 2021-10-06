package com.elec.demo.model;

import java.util.Date;

public class AdminUserModel {

    private int adminid=0;
    private String m_zhanghao=null;
    private String m_mima=null;
    private Date m_firsttime=null;

    public int getAdminid() {
        return adminid;
    }

    public void setAdminid(int adminid) {
        this.adminid = adminid;
    }

    public String getM_zhanghao() {
        return m_zhanghao;
    }

    public void setM_zhanghao(String m_zhanghao) {
        this.m_zhanghao = m_zhanghao;
    }

    public String getM_mima() {
        return m_mima;
    }

    public void setM_mima(String m_mima) {
        this.m_mima = m_mima;
    }

    public Date getM_firsttime() {
        return m_firsttime;
    }

    public void setM_firsttime(Date m_firsttime) {
        this.m_firsttime = m_firsttime;
    }
}
