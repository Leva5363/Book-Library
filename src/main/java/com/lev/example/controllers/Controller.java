//package com.lev.example.controllers;
//
//import com.lev.example.services.ValidatorService;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class Controller {
//    @GetMapping ("/health")
//    public HttpStatus healthStatus (){
//      return HttpStatus.OK;
//    }
//
//    @PostMapping ("/checkingPassword")
//    public String post (@RequestBody String pas) {
//        return ValidatorService.checkPassword(pas);
//    }
//}
