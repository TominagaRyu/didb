package com.example.lesson2.ProductDao;

import com.example.lesson2.ProductRecord.ProductRecord;

import java.util.List;

public interface ProductDao {

    public List<ProductRecord> findAll();

    public ProductRecord findById(int id);

    public int insert (ProductRecord record);

    public int update (ProductRecord record);

    public int delete (int id);

}
