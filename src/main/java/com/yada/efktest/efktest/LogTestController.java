package com.yada.efktest.efktest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogTestController {
    private Logger logger = LoggerFactory.getLogger(LogTestController.class);

    @GetMapping("/test1")
    public String test(){
        String param = "param";
        logger.info("this is test log {}",param);
        return "test";
    }

    @GetMapping("/err1")
    public String err(){
        int i =  1/0;
        return "err";
    }

    @GetMapping("/exp1")
    public String exp(){
        try {
            int i =  1/0;
        }catch (Exception e){
            System.out.println("==========================");
            e.printStackTrace();
            System.out.println("==========================");
            logger.error("this is test error log, error message",e);
            System.out.println("==========================");
        }
        return "exp";
    }
}
