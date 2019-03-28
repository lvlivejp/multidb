package com.lvlivejp.multidb.service;

import com.lvlivejp.multidb.dao.AdminMessageMapper;
import com.lvlivejp.multidb.model.AdminMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminMessageService {

    @Autowired
    private AdminMessageMapper adminMessageMapper;

    public List<AdminMessage> selectAdminMaster(){
        return adminMessageMapper.selectAll();
    }

    @Transactional
    public void insertMaster(AdminMessage adminMessage) {
        adminMessageMapper.insert(adminMessage);
        if(adminMessage.getId() == 9){
            throw new RuntimeException("firstdb error");
        }
    }

}
