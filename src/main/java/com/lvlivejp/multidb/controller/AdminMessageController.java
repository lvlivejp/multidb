package com.lvlivejp.multidb.controller;
import java.util.Date;

import com.lvlivejp.multidb.model.AccExtBusiStatus;
import com.lvlivejp.multidb.model.AdminMessage;
import com.lvlivejp.multidb.service.AccExtBusiStatusService;
import com.lvlivejp.multidb.service.AdminMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminMessageController {

    @Autowired
    AdminMessageService adminMessageService;

    @Autowired
    AccExtBusiStatusService accExtBusiStatusService;

    @GetMapping("/select")
    public List<AdminMessage> selectmaster(){
        return adminMessageService.selectAdminMaster();
    }

    @GetMapping("/selectsecond")
    public List<AccExtBusiStatus> selectslave(){
        return accExtBusiStatusService.selectAll();
    }

    @PostMapping("/insert/{id}")
    public AdminMessage insertMaster(@PathVariable Long id){
        AdminMessage adminMessage = new AdminMessage();
        adminMessage.setId(id);
        adminMessage.setCtime(new Date());
        adminMessage.setStatus(0);
        adminMessage.setUtime(new Date());
        adminMessage.setContent("Master");
        adminMessage.setMessageType(0);
        adminMessage.setNeedOpen(false);
        adminMessage.setTitle("");
        adminMessageService.insertMaster(adminMessage);
        return adminMessage;
    }
    @PostMapping("/insertsecond/{id}")
    public AccExtBusiStatus insertSlave(@PathVariable Long id){
        AccExtBusiStatus accExtBusiStatus = new AccExtBusiStatus();
        accExtBusiStatus.setId(id.toString());
        accExtBusiStatus.setCreateTime(new Date());
        accExtBusiStatus.setCreator("");
        accExtBusiStatus.setUpdateTime(new Date());
        accExtBusiStatus.setUpdator("");
        accExtBusiStatus.setDeleted("");
        accExtBusiStatus.setUsed("");
        accExtBusiStatus.setVersion(0);
        accExtBusiStatus.setAccountId("");
        accExtBusiStatus.setDebitDate(new Date());
        accExtBusiStatus.setDeductComplete("");
        accExtBusiStatus.setEnabled("");
        accExtBusiStatusService.insert(accExtBusiStatus);
        return accExtBusiStatus;
    }
}
