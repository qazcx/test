package com.fh.demotest.controller;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("demo")
public class domeController {

    @GetMapping("test1")
    public  String  test1(){
        return  "SUCCESS---get";
    }
    @PostMapping("test1")
    public  String  test2(){
        return  "SUCCESS---post";
    }
    @DeleteMapping("test1")
    public  String  test3(){
        return  "SUCCESS---del";
    }
    @PutMapping ("test1")
    public  String  test4(){
        return  "SUCCESS---put";
    }
    public static void  main(String[] arge){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            //创建httpGet
            HttpGet httpget = new HttpGet("http://localhost:8080/demo/test1");
            // 执行get请求.
            response = httpClient.execute(httpget);
            HttpEntity entity = response.getEntity();
            String str = EntityUtils.toString(entity, "utf-8");
            System.out.print(str);
            Map map = JSON.parseObject(str, Map.class);
            if (map.get("code").equals(110)){
                System.out.print(map.get("data")+"000000s");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (response==null){
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
