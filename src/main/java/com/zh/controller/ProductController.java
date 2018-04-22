package com.zh.controller;

import com.zh.repository.ProductRepository;
import com.zh.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangheng on 2017/12/11.
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/product/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable Long id){
        Product findOne = this.productRepository.findOne(id);
        return findOne;
    }

    @GetMapping("/product/getList")
    public List hello(){
        List allList = this.productRepository.findAll();
        return allList;
    }

    @RequestMapping(value = "/getByParme",method = RequestMethod.POST)
    public Product findByParme(@RequestBody Map<String,Object> reqMap){
        List products = this.productRepository.findAll();
        return null;
    }
}
