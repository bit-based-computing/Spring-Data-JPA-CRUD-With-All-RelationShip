package com.jpa.curd.curd.repositories;

import com.jpa.curd.curd.domains.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
