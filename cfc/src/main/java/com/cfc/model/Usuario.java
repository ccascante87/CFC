
package com.cfc.model;

import java.io.Serializable;

public class Usuario implements Serializable{

	private static final long serialVersionUID = -893973223171124627L;
	private int id;
	private String name;
	private String loginName;
	private Sucursal defaultBranch;
	private Moneda defaultCurrency;
	private boolean admin;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
}
