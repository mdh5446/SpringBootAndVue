package com.example.mdh_test.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mdh_test.dto.ShopUserByIdxDto;
import com.example.mdh_test.entity.ShopUser;
import com.example.mdh_test.repository.CommonRepository;
import com.example.mdh_test.repository.ShopUserRepository;

@Service
public class ShopUserService {

    @Autowired
    private ShopUserRepository shopUserRepository;
    private final CommonRepository commonRepository;

    @Autowired
    public ShopUserService(ShopUserRepository shopUserRepository, CommonRepository commonRepository) {
		this.shopUserRepository = shopUserRepository;
		this.commonRepository = commonRepository;
	}
    
    public ShopUserByIdxDto getShopUser(Long idx) {
        ShopUser shopUser = shopUserRepository.findById(idx).orElse(new ShopUser());
        return new ShopUserByIdxDto(shopUser);
    }

    public ShopUserByIdxDto getShopUserByIdx(Long idx) {
    	Map<String, Object> parameters = new HashMap<>();
        parameters.put("p_idx", idx);

        return commonRepository.executeProcedure("sp_GetShopUserByIdx", parameters, ShopUserByIdxDto.class);
    }
}
