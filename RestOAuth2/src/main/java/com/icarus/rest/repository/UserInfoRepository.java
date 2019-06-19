package com.icarus.rest.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icarus.rest.model.UserInfo;

@Repository
@Transactional
public interface UserInfoRepository extends CrudRepository<UserInfo, Long>{
	public UserInfo findByUsernameAndEnabled(String username, boolean enabled);
	public List<UserInfo> findAllByEnabled(boolean enabled);
	public Optional<UserInfo> findById(Long id);
}
