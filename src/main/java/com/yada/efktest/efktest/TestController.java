package com.yada.efktest.efktest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/test")
    public String test(){
        String param = "param";
        logger.info("this is test log {}",param);
        return "test";
    }

    @GetMapping("/err")
    public String err(){
        int i =  1/0;
        return "err";
    }

    @GetMapping("/exp")
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
