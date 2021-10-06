package com.elec.demo.service;

import com.elec.demo.model.AgentsModel;
import com.elec.demo.model.BankProductModel;

import java.util.List;

public interface IAgentsService {
    void insert(AgentsModel agentsModel);
    AgentsModel selectone(AgentsModel agentsModel);
    void delete(AgentsModel agentsModel);
    void update(AgentsModel agentsModel);
    int selectAllCount();//取得个数总数
    int selectAllPageCount(int rows);//取得总页数
    List<AgentsModel> getAll(int page, int rows);//获取产品对象列表
}
