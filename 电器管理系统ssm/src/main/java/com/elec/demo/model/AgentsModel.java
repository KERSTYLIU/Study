package com.elec.demo.model;

import java.util.Date;

public class AgentsModel {
    private int as_id=0;
//    private String as_jiage=null;
//    private String as_geshu=null;
    private int as_jiage=0;
    private int as_geshu=0;
    private String as_beizhu=null;

    public int getAs_id() {
        return as_id;
    }

    public void setAs_id(int as_id) {
        this.as_id = as_id;
    }

//    public String getAs_jiage() {
//        return as_jiage;
//    }
//
//    public void setAs_jiage(String as_jiage) {
//        this.as_jiage = as_jiage;
//    }
//
//    public String getAs_geshu() {
//        return as_geshu;
//    }
//
//    public void setAs_geshu(String as_geshu) {
//        this.as_geshu = as_geshu;
//    }


    public int getAs_jiage() {
        return as_jiage;
    }

    public void setAs_jiage(int as_jiage) {
        this.as_jiage = as_jiage;
    }

    public int getAs_geshu() {
        return as_geshu;
    }

    public void setAs_geshu(int as_geshu) {
        this.as_geshu = as_geshu;
    }

    public String getAs_beizhu() {
        return as_beizhu;
    }

    public void setAs_beizhu(String as_beizhu) {
        this.as_beizhu = as_beizhu;
    }
}
