package com.lth.ecommerce_backend.repository;

import com.lth.ecommerce_backend.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
