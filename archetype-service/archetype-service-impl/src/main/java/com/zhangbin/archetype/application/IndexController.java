package com.zhangbin.archetype.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangbin
 * @Type IndexController
 * @Desc
 * @date 2018-05-06
 * @Version V1.0
 */
@RestController
public class IndexController {

    @GetMapping("/")
    public String index() {
        System.out.println(" ============== " );
        return "ok";
    }
}
