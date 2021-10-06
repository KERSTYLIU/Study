package com.elec.demo.service.impl;

import com.elec.demo.dao.AgentsDao;
import com.elec.demo.model.AgentsModel;
import com.elec.demo.model.BankProductModel;
import com.elec.demo.service.IAgentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentsServiceImpl implements IAgentsService {
    @Autowired
    AgentsDao agentsDao;

    @Override
    public void insert(AgentsModel agentsModel) {
        agentsDao.insert(agentsModel);
    }

    @Override
    public AgentsModel selectone(AgentsModel agentsModel) {
        return agentsDao.selectone(agentsModel);
    }

    @Override
    public void delete(AgentsModel agentsModel) {
        agentsDao.delete(agentsModel);
    }

    @Override
    public void update(AgentsModel agentsModel) {
        agentsDao.update(agentsModel);
    }

    @Override
    public int selectAllCount() {
        return agentsDao.selectAllCount();
    }

    @Override
    public int selectAllPageCount(int rows) {
        int count= agentsDao.selectAllCount();
        int pagecount = (int) Math.ceil(count/(rows/1.0));
        return pagecount;
    }

    @Override
    public List<AgentsModel> getAll(int page, int rows) {
        List<AgentsModel> list = agentsDao.selectAll(page,rows);
        return list;
    }
}
