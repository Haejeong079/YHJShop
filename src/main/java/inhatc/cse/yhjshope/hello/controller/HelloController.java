package inhatc.cse.yhjshope.hello.controller;

import inhatc.cse.yhjshope.hello.dto.HelloDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String hello(Model model) {
        System.out.println("======== 테스트 호출");

        HelloDto helloDto = HelloDto.builder()
                .name("양해정")
                .build();
        model.addAttribute("data", helloDto);
        return "test/test";
    }
}
