//package com.film.sakila.controller;
//
//import com.film.sakila.dto.UserDto;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/admin/websocket")
//public class SocketController {
//    @MessageMapping("/message")
//    @SendTo("/api/admin/users/insert")
//    public UserDto getMessage(UserDto userDto) throws Exception {
//        Thread.sleep(1000);
//        return userDto;
//    }
//}
