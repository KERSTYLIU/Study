package com.elec.demo.service.impl;

import com.elec.demo.dao.ReckoningRecoderDao;
import com.elec.demo.model.ReckoningRecoderModel;
import com.elec.demo.service.IReckoningRecoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReckoningRecoderImpl implements IReckoningRecoderService {
    @Autowired
    ReckoningRecoderDao reckoningRecoderDao;
    @Override
    public ReckoningRecoderModel selectbyid(int r_id) {
        return reckoningRecoderDao.selectbyid(r_id);
    }

    @Override
    public void add(ReckoningRecoderModel reckoningRecoderModel) {
        reckoningRecoderDao.add(reckoningRecoderModel);
    }

    @Override
    public List<ReckoningRecoderModel> selectall(ReckoningRecoderModel reckoningRecoderModel) {
        return reckoningRecoderDao.selectall(reckoningRecoderModel);
    }
}
