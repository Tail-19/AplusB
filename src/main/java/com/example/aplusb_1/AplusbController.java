package com.example.aplusb_1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

public class AplusbController {
//    如果传的参数是@RequestBody ，多参或者传对象的情况下使用@PostMapping注解
//    无参，@RequestParam 和@PathVaiable的情况下使用GetMapping
    @GetMapping("/calc/sum1")
    @ResponseBody //responsbody修饰的是方法，表示返回的是某个对象（无法解析html）
    public Aplusb plus_1 (@RequestParam("a") int a, @RequestParam("b") int b) {
        return new Aplusb(a, b);
    }

    @GetMapping("/calc/sum2/{a}/{b}")
    @ResponseBody
    public Aplusb plus_2 (@PathVariable("a") int a, @PathVariable("b") int b) { //这里如果不写括号里的内容的话就会按照path里的顺序获取参数
        return new Aplusb(a, b);
    }

    @GetMapping("/calc/sum3")
    public String getAB() {
        return "aplusb";
    }
}
