package com.example.demo.service;


import com.example.demo.entity.Commodity;

import java.util.List;

public interface CommodityService {
    //获取全部商品信息
    List<Commodity> findAll();

    //新增商品信息
    void insertCommodity(Commodity commodity);

    //修改商品信息
    void updateCommodity(Commodity commodity);

    //根据id查询获取商品信息
    Commodity findById(Integer id);

    //根据id删除商品信息
    void deleteById(Integer id);

}
