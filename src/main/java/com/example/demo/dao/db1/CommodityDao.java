package com.example.demo.dao.db1;

import com.example.demo.entity.Commodity;

import java.util.List;

public interface CommodityDao {
    //获取全部商品
    List<Commodity> findAll();

    //新增商品
    void insertCommodity(Commodity commodity);

    //修改商品
    void updateCommodity(Commodity commodity);

    //根据id获取商品
    Commodity findById(Integer id);

    //根据id删除商品
    void deleteById(Integer id);
}
