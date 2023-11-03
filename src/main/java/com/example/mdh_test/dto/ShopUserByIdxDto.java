package com.example.mdh_test.dto;

import com.example.mdh_test.entity.ShopUser;

public class ShopUserByIdxDto {
	
	private Long idx;
    private String userId;
    private String userName;

    public ShopUserByIdxDto() {
        // 기본 생성자
    }
    
    public ShopUserByIdxDto(ShopUser shopUser) {
        this.idx = shopUser.getIdx();
        this.userId = shopUser.getUserId();
        this.userName = shopUser.getUserName();
    }

    public Long getIdx() {
		return idx;
	}

	public void setIdx(Long idx) {
		this.idx = idx;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}