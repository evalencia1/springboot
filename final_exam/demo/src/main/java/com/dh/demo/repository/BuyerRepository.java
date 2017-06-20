package com.dh.demo.repository;

import com.dh.demo.domain.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ElmerVL on 19/06/2017.
 */
public interface BuyerRepository extends JpaRepository<Buyer, Long> {
}
