package com.zh.repository;

import com.zh.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhangheng on 2017/12/11.
 */
public interface ProductRepository extends JpaRepository<Product,Long> {
}
