/**
 * 
 */
package com.cfc.model;

/**
 * @author JIO
 *
 */
import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MONEDA database table.
 * 
 */
@Entity
@NamedQuery(name="Moneda.findAll", query="SELECT m FROM Moneda m")
public class Moneda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERMASTER_ID_SEQ")
	@SequenceGenerator(name = "USERMASTER_ID_SEQ", sequenceName = "USERMASTER_ID_SEQ", allocationSize = 1, initialValue = 1)
	private long id;
	@Column(name="DESCRIPCION")
	private String descripcion;
	@Column(name="SIMBOLO")
	private String simbolo;

	public Moneda() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getSimbolo() {
		return this.simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

}