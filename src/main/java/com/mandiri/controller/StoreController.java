package com.mandiri.controller;

import com.mandiri.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {

    @Autowired
    StoreService storeService;
}
