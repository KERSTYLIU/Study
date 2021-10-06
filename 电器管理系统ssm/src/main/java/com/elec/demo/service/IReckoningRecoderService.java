package com.elec.demo.service;

import com.elec.demo.model.ReckoningRecoderModel;

import java.util.List;

public interface IReckoningRecoderService {
    ReckoningRecoderModel selectbyid(int r_id);
    void add (ReckoningRecoderModel reckoningRecoderModel);
    List<ReckoningRecoderModel> selectall(ReckoningRecoderModel reckoningRecoderModel);
}
