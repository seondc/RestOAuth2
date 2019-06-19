package com.icarus.rest.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icarus.rest.model.ClientInfo;

@Repository
public interface ClientInfoRepository extends CrudRepository<ClientInfo, String>{
}
