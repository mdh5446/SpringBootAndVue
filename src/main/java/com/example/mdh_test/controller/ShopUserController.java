package com.example.mdh_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.mdh_test.dto.ShopUserByIdxDto;
import com.example.mdh_test.service.ShopUserService;

@RestController
@RequestMapping("/users")
public class ShopUserController {

    @Autowired
    private ShopUserService userService;

    @GetMapping("/{idx}")
    public ShopUserByIdxDto getUser(@PathVariable Long idx) {
        return userService.getShopUser(idx);
    }

}