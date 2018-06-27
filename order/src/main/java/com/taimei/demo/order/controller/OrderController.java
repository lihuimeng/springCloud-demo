package com.taimei.demo.order.controller;


import com.alibaba.fastjson.JSON;
import com.taimei.demo.order.entry.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getOrder")
    @ResponseBody
    public String getOder(String exceptionTest) {

        System.out.print(exceptionTest+"=========");
        System.out.println("现在调用了消费者----1");
        Order order = new Order();
        order.setId(654321);
        order.setOrderCode("201803694");
        order.setPrice("6691");
        return JSON.toJSONString(order);
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public String getUser() {
        return restTemplate.getForObject("http://demo-user/user/getUser", String.class);
    }
}
