package com.nacos.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nacos.mapper.BillMapper;
import com.nacos.pojo.Bill;
import com.nacos.service.BillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BillServiceImpl extends ServiceImpl<BillMapper, Bill> implements BillService {

}
