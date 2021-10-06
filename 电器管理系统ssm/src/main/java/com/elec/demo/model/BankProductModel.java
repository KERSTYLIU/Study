package com.elec.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


public class BankProductModel {
    private int bp_id = 0;
    private  String bp_name = null;
    @JsonIgnore
    private byte[] bp_tupian = null;
    private String bp_contenttype = null;
    private String bp_filename = null;
    private String bp_lilv =null;
    private String bp_kaishishijian = null;
    private String bp_jieshushijian = null;
    private String bp_jieshao = null;
    private String bp_dingqi = null;

    public String getBp_name() {
        return bp_name;
    }

    public void setBp_name(String bp_name) {
        this.bp_name = bp_name;
    }
    public int getBp_id() {
        return bp_id;
    }

    public void setBp_id(int bp_id) {
        this.bp_id = bp_id;
    }

    public byte[] getBp_tupian() {
        return bp_tupian;
    }

    public void setBp_tupian(byte[] bp_tupian) {
        this.bp_tupian = bp_tupian;
    }

    public String getBp_lilv() {
        return bp_lilv;
    }

    public void setBp_lilv(String bp_lilv) {
        this.bp_lilv = bp_lilv;
    }

    public String getBp_kaishishijian() {
        return bp_kaishishijian;
    }

    public void setBp_kaishishijian(String bp_kaishishijian) {
        this.bp_kaishishijian = bp_kaishishijian;
    }

    public String getBp_jieshushijian() {
        return bp_jieshushijian;
    }

    public void setBp_jieshushijian(String bp_jieshushijian) {
        this.bp_jieshushijian = bp_jieshushijian;
    }

    public String getBp_jieshao() {
        return bp_jieshao;
    }

    public void setBp_jieshao(String bp_jieshao) {
        this.bp_jieshao = bp_jieshao;
    }

    public String getBp_dingqi() {
        return bp_dingqi;
    }

    public void setBp_dingqi(String bp_dingqi) {
        this.bp_dingqi = bp_dingqi;
    }

    public String getBp_contenttype() {
        return bp_contenttype;
    }

    public void setBp_contenttype(String bp_contenttype) {
        this.bp_contenttype = bp_contenttype;
    }

    public String getBp_filename() {
        return bp_filename;
    }

    public void setBp_filename(String bp_filename) {
        this.bp_filename = bp_filename;
    }
}
