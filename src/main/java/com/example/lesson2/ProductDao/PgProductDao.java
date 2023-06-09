package com.example.lesson2.ProductDao;

import com.example.lesson2.ProductRecord.ProductRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PgProductDao implements ProductDao{
    @Autowired
    private NamedParameterJdbcTemplate template;

    @Override
    public List<ProductRecord> findAll(){
        return template.query("SELECT * FROM products",
                new DataClassRowMapper<>(ProductRecord.class));
    }
    @Override
    public ProductRecord findById(int id){
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id",id);
        var list = template.query("SELECT * FROM products WHERE id = :id"
                ,param,new DataClassRowMapper<>(ProductRecord.class));
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public int insert(ProductRecord record) {
        MapSqlParameterSource param = new MapSqlParameterSource();
    //    param.addValue("id", record.id());
        param.addValue("name", record.name());
        param.addValue("price", record.price());
        return template.update("INSERT INTO products(name,price) VALUES(:name, :price)", param);

    }

    @Override
        public int update(ProductRecord record) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("name", record.name());
        param.addValue("price", record.price());
        param.addValue("id", record.id());
        return template.update("UPDATE products SET name = :name, price = :price WHERE id = :id", param);
    }

    @Override
        public int delete(int id){
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id",id);
        var deleteCount = template.update("DELETE FROM products WHERE id = :id",param);
        return deleteCount;
    }
}
