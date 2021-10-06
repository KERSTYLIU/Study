package com.elec.demo.model;

import java.util.Date;

public class ReckoningRecoderModel {
    private int r_id = 0;
    private int userid = 0;
    private String r_zhifudangshi = null;
    private String r_fukuanshijian = null;
    private String r_shoukuanshijian = null;
    private String r_shoukuanfang = null;
    private String r_neirou = null;


    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getR_zhifudangshi() {
        return r_zhifudangshi;
    }

    public void setR_zhifudangshi(String r_zhifudangshi) {
        this.r_zhifudangshi = r_zhifudangshi;
    }

    public String getR_fukuanshijian() {
        return r_fukuanshijian;
    }

    public void setR_fukuanshijian(String r_fukuanshijian) {
        this.r_fukuanshijian = r_fukuanshijian;
    }

    public String getR_shoukuanshijian() {
        return r_shoukuanshijian;
    }

    public void setR_shoukuanshijian(String r_shoukuanshijian) {
        this.r_shoukuanshijian = r_shoukuanshijian;
    }

    public String getR_shoukuanfang() {
        return r_shoukuanfang;
    }

    public void setR_shoukuanfang(String r_shoukuanfang) {
        this.r_shoukuanfang = r_shoukuanfang;
    }

    public String getR_neirou() {
        return r_neirou;
    }

    public void setR_neirou(String r_neirou) {
        this.r_neirou = r_neirou;
    }
}
