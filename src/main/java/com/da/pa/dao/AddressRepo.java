package com.da.pa.dao;

import org.springframework.data.repository.CrudRepository;

import com.da.pa.model.Address;

public interface AddressRepo extends CrudRepository<Address, Long> {

}
