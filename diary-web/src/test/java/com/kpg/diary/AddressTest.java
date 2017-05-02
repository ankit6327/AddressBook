package com.kpg.diary;

import java.util.List;

import com.kpg.diary.model.Address;
import com.kpg.diary.service.AddressService;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Ankit Sood Dec 5, 2016
 */
public class AddressTest extends BaseTest {

	@Autowired
	private AddressService addressService;

	//@Test
	public void getAllAddress() {
		try {
			List<Address> addresses = addressService.findAll();
			Assert.assertNotNull(addresses);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
