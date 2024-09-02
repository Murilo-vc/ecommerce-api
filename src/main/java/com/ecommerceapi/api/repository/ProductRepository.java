package com.ecommerceapi.api.repository;

import com.ecommerceapi.api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    List<Product> findAllByIsDeletedFalse();

    Optional<Product> getOneByIdAndIsDeletedFalse(final Long id);
}
