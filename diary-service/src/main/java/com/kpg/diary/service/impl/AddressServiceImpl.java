package com.kpg.diary.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpg.diary.bean.AddressBean;
import com.kpg.diary.dao.AddressRepository;
import com.kpg.diary.dto.AddressDto;
import com.kpg.diary.dto.AddressViewDto;
import com.kpg.diary.model.Address;
import com.kpg.diary.model.Person;
import com.kpg.diary.service.AddressService;
import com.kpg.diary.service.BaseService;

/**
 * The Class AddressServiceImpl.
 *
 * @author Ankit Sood Dec 5, 2016
 */
@Service("addressService")
public class AddressServiceImpl extends BaseService<Address> implements AddressService {

    private AddressRepository addressRepository;

    /**
     * Sets the address repository.
     *
     * @param addressRepository
     *            the new address repository
     */
    @Autowired
    public void setAddressRepository(AddressRepository addressRepository) {
	this.addressRepository = addressRepository;
	setGenericRepository(addressRepository);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.kpg.diary.service.AddressService#saveAddress(com.kpg.diary.bean.
     * AddressBean)
     */
    @Override
    public void saveAddress(AddressBean addressBean) {
	Address address = new Address();
	address.setLine1(addressBean.getLine1());
	address.setLine2(addressBean.getLine2());
	address.setCity(addressBean.getCity());
	address.setZip(addressBean.getZip());
	address.setPhone(addressBean.getPhone());
	address.setCountry(addressBean.getCountry());
	address.setState(addressBean.getState());
	address.setPrimaryAddress(addressBean.getPrimary());
	address.setNumber(addressBean.getNumber());
	if (addressBean.getPersonId() != null) {
	    address.setPerson(new Person(addressBean.getPersonId()));
	}

	if (addressBean.getAddressId() != null) {
	    address.setAddressId(addressBean.getAddressId());
	}

	addressRepository.save(address);

    }

    @Override
    public void deleteById(Integer entityId) {
	addressRepository.delete(entityId);
    }

    @Override
    public List<AddressDto> findAllAddressDto() {
	return addressRepository.findAllAddressDto();
    }

    @Override
    public Address findOne(Integer id) {
	// TODO Auto-generated method stub
	return super.findOne(id);
    }

    public List<Address> findByPersonId(Integer id) {
	return addressRepository.findByPersonId(id);
    }

    @Override
    public List<AddressViewDto> findAllAddressViewDto(Integer id) {
	return addressRepository.findAllAddressViewDto(id);
    }

    public AddressDto createAddressDto(Address address) {
	AddressDto addressDto = new AddressDto();
	addressDto.setAddressId(address.getAddressId());
	addressDto.setCity(address.getCity());
	addressDto.setCountry(address.getCountry());
	addressDto.setLine1(address.getLine1());
	addressDto.setLine2(address.getLine2());
	addressDto.setNumber(address.getNumber());
	if (null != address.getPerson()) {
	    addressDto.setPersonId(address.getPerson().getId());
	}
	addressDto.setPhone(address.getPhone());
	addressDto.setPrimary(address.getPrimaryAddress());
	addressDto.setState(address.getState());
	addressDto.setZip(address.getZip());
	return addressDto;
    }

}
