package com.taotao.controller;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.pojo.TbItemParam;
import com.taotao.service.ItemParamService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by zhangchun on 2017/4/6.
 */
public class TestItemParam {
    @Test
    public void testGetItemParamList(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        ItemParamService itemParamService = context.getBean(ItemParamService.class);
        EUDataGridResult result = itemParamService.getItemParamList(1, 30);
        System.out.print(result);
    }
}
