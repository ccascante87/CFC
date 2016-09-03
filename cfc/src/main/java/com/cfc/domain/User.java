package com.cfc.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class User implements Serializable {
	private long id;
	private String name;
	private long defaultBranchId;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getDefaultBranchId() {
		return defaultBranchId;
	}

	public void setDefaultBranchId(long defaultBranchId) {
		this.defaultBranchId = defaultBranchId;
	}
}
