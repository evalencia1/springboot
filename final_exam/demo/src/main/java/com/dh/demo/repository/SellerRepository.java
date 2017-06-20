package com.dh.demo.repository;

import com.dh.demo.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ElmerVL on 19/06/2017.
 */
public interface SellerRepository extends JpaRepository<Seller, Long> {
}
