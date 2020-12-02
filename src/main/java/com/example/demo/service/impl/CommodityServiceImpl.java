package com.example.demo.service.impl;

import com.example.demo.dao.db1.CommodityDao;
import com.example.demo.entity.Commodity;
import com.example.demo.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityDao commodityDao;

    @Override
    public List<Commodity> findAll() {
        return commodityDao.findAll();
    }

    @Override
    public void insertCommodity(Commodity commodity) {
        commodityDao.insertCommodity(commodity);
    }

    @Override
    public void updateCommodity(Commodity commodity) {
        commodityDao.updateCommodity(commodity);

    }

    @Override
    public Commodity findById(Integer id) {
        return commodityDao.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        commodityDao.deleteById(id);

    }
}
