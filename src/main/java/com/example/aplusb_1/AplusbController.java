package com.example.aplusb_1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    @GetMapping("/acc")
    @ResponseBody
    public String acc(@RequestParam("param") Integer para, HttpServletRequest request){
        if (request.getSession().getAttribute("a") == null){
            System.out.println("hello");
            request.getSession().setAttribute("a", para);
        } else{
            int b = (int) request.getSession().getAttribute("a");
            request.getSession().setAttribute("a", para+b);
        }
        System.out.println(request.getSession().getAttribute("a").toString());
        return request.getSession().getAttribute("a").toString();
    }

    @GetMapping("/session")
    @ResponseBody
    public String session(HttpSession session){
        session.setAttribute("a", 123);
        return session.getAttribute("a").toString();
    }
}