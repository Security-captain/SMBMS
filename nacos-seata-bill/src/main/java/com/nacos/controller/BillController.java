package com.nacos.controller;

import com.nacos.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BillController {
    @Autowired
    private BillService billService;

}
