package com.example.manageyourexpenditures.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


@GetMapping("/")
    public String homeMethod(){

    return "index";
}


}
