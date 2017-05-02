package com.kpg.diary.service;

import java.util.List;

import com.kpg.diary.bean.AddressBean;
import com.kpg.diary.dto.AddressDto;
import com.kpg.diary.dto.AddressViewDto;
import com.kpg.diary.model.Address;

/**
 * The Interface AddressService.
 *
 * @author Ankit Sood Dec 5, 2016
 */
public interface AddressService extends IService<Address> {

    /**
     * Save address.
     *
     * @param addressBean
     *            the address bean
     */
    public void saveAddress(AddressBean addressBean);

    /**
     * Delete by id.
     *
     * @param id
     *            the id
     */
    public void deleteById(Integer id);

    /**
     * Find all address dto.
     *
     * @return the list
     */
    public List<AddressDto> findAllAddressDto();

    public List<Address> findByPersonId(Integer id);
    
    List<AddressViewDto> findAllAddressViewDto(Integer id);
    
    public AddressDto createAddressDto(Address address);

}
