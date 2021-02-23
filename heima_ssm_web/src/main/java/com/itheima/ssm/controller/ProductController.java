package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    //产品添加
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll.do";
    }

    //查询全部产品
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,@RequestParam(name = "size",required = true,defaultValue = "3") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll(page, size);
        //PageInfo就是一个分页Bean
        PageInfo pageInfo = new PageInfo(ps);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("product-list");
        return mv;

    }
}
