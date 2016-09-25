package com.cfc.model;

import java.io.Serializable;
import java.util.HashMap;

public class Usuario implements Serializable{

	private static final long serialVersionUID = -893973223171124627L;
	private int id;
	private String name;
	private String loginName;
	private Sucursal defaultBranch;
	private Moneda defaultCurrency;
	private boolean admin;
	private HashMap<String, String> applicationParameters = new HashMap<>();
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Sucursal getDefaultBranch() {
		return defaultBranch;
	}

	public void setDefaultBranch(Sucursal defaultBranch) {
		this.defaultBranch = defaultBranch;
	}

	public Moneda getDefaultCurrency() {
		return defaultCurrency;
	}

	public void setDefaultCurrency(Moneda defaultCurrency) {
		this.defaultCurrency = defaultCurrency;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public HashMap<String, String> getApplicationParameters() {
		return applicationParameters;
	}

	public void setApplicationParameters(HashMap<String, String> applicationParameters) {
		this.applicationParameters = applicationParameters;
	}
	
	
}
