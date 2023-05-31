package com.example.lesson2.ProductService;

import com.example.lesson2.ProductDao.ProductDao;
import com.example.lesson2.ProductRecord.ProductRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PgProductService implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public List<ProductRecord> findAll() {
        return productDao.findAll();
    }

    @Override
    public ProductRecord findById(int id) {
        return productDao.findById(id);
    }

    @Override
    public int insert(ProductRecord record) {
        return productDao.insert(record);
    }

    @Override
    public int update(ProductRecord record){
        return productDao.update(record);
    }

    @Override
    public int delete(int id){
        return productDao.delete(id);
    }
}
