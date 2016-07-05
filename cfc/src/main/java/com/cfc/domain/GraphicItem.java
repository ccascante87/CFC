package com.cfc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class GraphicItem implements Serializable {

	private static final long serialVersionUID = 1L;
	private String label = "";
	private String type = "";
	private List<String> itemValues = new ArrayList<String>();

	public GraphicItem() {
		// TODO Auto-generated constructor stub
	}

	public GraphicItem(String label, String type) {
		super();
		this.label = label;
		this.type = type;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getItemValues() {
		return itemValues;
	}

	public void setItemValues(List<String> itemValues) {
		this.itemValues = itemValues;
	}

}
