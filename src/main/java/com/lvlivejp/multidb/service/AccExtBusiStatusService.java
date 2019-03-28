package com.lvlivejp.multidb.service;

import com.lvlivejp.multidb.seconddao.AccExtBusiStatusMapper;
import com.lvlivejp.multidb.model.AccExtBusiStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccExtBusiStatusService {

    @Autowired
    private AccExtBusiStatusMapper accExtBusiStatusMapper;

    public List<AccExtBusiStatus> selectAll(){
        return accExtBusiStatusMapper.selectAll();
    }

    @Transactional(transactionManager = "dataSourceTransactionManagerSecond")
    public void insert(AccExtBusiStatus accExtBusiStatus) {
        accExtBusiStatusMapper.insert(accExtBusiStatus);
        if("9".equals(accExtBusiStatus.getId())){
            throw new RuntimeException("seconddb error");
        }
    }

}
