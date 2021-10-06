package com.elec.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserInfoModel {
    private int userinfoid = 0;
    private String u_xingming = null;
    private String u_xingbie = null;
    private  String u_ac_firsttime = null;
    private String u_shoujihao = null;
    @JsonIgnore
    private byte[] u_touxiang = null;
    private  String u_contenttype = null;
    private String u_filename = null;
    private  int u_nianlin = 0;
    private String u_xueli = null;
    private String u_youxiang = null;

    public int getUserinfoid() {
        return userinfoid;
    }

    public void setUserinfoid(int userinfoid) {
        this.userinfoid = userinfoid;
    }

    public String getU_xingming() {
        return u_xingming;
    }

    public void setU_xingming(String u_xingming) {
        this.u_xingming = u_xingming;
    }

    public String getU_xingbie() {
        return u_xingbie;
    }

    public void setU_xingbie(String u_xingbie) {
        this.u_xingbie = u_xingbie;
    }

    public String getU_ac_firsttime() {
        return u_ac_firsttime;
    }

    public void setU_ac_firsttime(String u_ac_firsttime) {
        this.u_ac_firsttime = u_ac_firsttime;
    }

    public String getU_shoujihao() {
        return u_shoujihao;
    }

    public void setU_shoujihao(String u_shoujihao) {
        this.u_shoujihao = u_shoujihao;
    }

    public byte[] getU_touxiang() {
        return u_touxiang;
    }

    public String getU_contenttype() {
        return u_contenttype;
    }

    public void setU_contenttype(String u_contenttype) {
        this.u_contenttype = u_contenttype;
    }

    public String getU_filename() {
        return u_filename;
    }

    public void setU_filename(String u_filename) {
        this.u_filename = u_filename;
    }

    public void setU_touxiang(byte[] u_touxiang) {
        this.u_touxiang = u_touxiang;
    }

    public int getU_nianlin() {
        return u_nianlin;
    }

    public void setU_nianlin(int u_nianlin) {
        this.u_nianlin = u_nianlin;
    }

    public String getU_xueli() {
        return u_xueli;
    }

    public void setU_xueli(String u_xueli) {
        this.u_xueli = u_xueli;
    }

    public String getU_youxiang() {
        return u_youxiang;
    }

    public void setU_youxiang(String u_youxiang) {
        this.u_youxiang = u_youxiang;
    }

}
