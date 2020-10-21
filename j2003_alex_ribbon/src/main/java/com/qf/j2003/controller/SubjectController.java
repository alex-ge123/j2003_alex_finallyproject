package com.qf.j2003.controller;

import com.qf.j2003.service.RemoteRibbonService;
import com.qf.j2003.util.ActionResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@Slf4j
public class SubjectController {

    @Autowired(required = false)
    private RemoteRibbonService remoteRibbonService;
    @RequestMapping(value = "/subjects",method = RequestMethod.GET)
    public ActionResult findSubject(){
        ActionResult subject = remoteRibbonService.findSubject();
        return subject;
    }
}
