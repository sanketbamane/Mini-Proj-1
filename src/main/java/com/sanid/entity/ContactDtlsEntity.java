package com.sanid.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="contact_dtls")
public class ContactDtlsEntity {
	
	@Id
	@Column(name = "contact_id")
	@GeneratedValue
	private Integer cid;
	@Column(name="contact_name")
	private String cname;
	@Column(name="contact_mail")
	private String email;
	@Column(name="contact_num")
	private Long cnum;
}
