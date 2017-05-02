package com.kpg.diary.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kpg.diary.dto.AddressDto;
import com.kpg.diary.dto.AddressViewDto;
import com.kpg.diary.model.Address;

/**
 * @author Ankit Sood Dec 5, 2016
 */
@Repository
public interface AddressRepository extends BaseRepository<Address, Integer> {

    @Query("SELECT new com.kpg.diary.dto.AddressDto(a.addressId,p.id,a.line1,a.line2,a.city, CONCAT(p.firstName, ' ', p.lastName)"
    	+ " ,a.number, a.primaryAddress, a.state, a.country, a.zip, a.phone)"
    	+ " FROM Address a, Person p WHERE a.person.id = p.id")
    List<AddressDto> findAllAddressDto();
    
    @Query("SELECT new com.kpg.diary.dto.AddressViewDto(a.number,a.line1,a.line2,a.city,  a.state, a.country, a.zip, p.title, p.firstName, p.lastName"
	    	+ " ,p.mobile, p.email)"
	    	+ " FROM Address a, Person p WHERE a.person.id = p.id AND p.id = :id")
    List<AddressViewDto> findAllAddressViewDto(@Param("id") Integer id);
    
    
    public List<Address> findByPersonId(Integer id); 
    
    
}
