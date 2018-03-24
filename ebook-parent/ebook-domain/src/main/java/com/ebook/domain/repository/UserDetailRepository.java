package com.ebook.domain.repository;

import com.ebook.domain.entity.UserDetail;

public interface UserDetailRepository extends AbstractRepository<UserDetail, Long> {
	
	UserDetail findByEmailId(String userName);

	

}
