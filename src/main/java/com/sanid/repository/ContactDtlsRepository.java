package com.sanid.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanid.entity.ContactDtlsEntity;

public interface ContactDtlsRepository extends JpaRepository<ContactDtlsEntity, Serializable>{
	

}
