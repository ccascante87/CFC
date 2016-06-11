package com.cfc.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class GraphData {
	private static GraphData instance;
	private Map<String, List<String>> yAxisValues = new HashMap<String, List<String>>();
	private List<String> xAxisValues = new ArrayList<>();
	private int x = 0;
//	private int y = 10000;
	
	public static GraphData getInstance(){
		if(instance == null)
			instance = new GraphData();
		return instance;
	}
	
	private GraphData(){
		yAxisValues.put("Menudo", new ArrayList<>());
		yAxisValues.put("Reserva", new ArrayList<>());
		yAxisValues.put("Prestamos", new ArrayList<>());
		yAxisValues.put("LCSx", new ArrayList<>());
		yAxisValues.put("LCx", new ArrayList<>());
		yAxisValues.put("LClx", new ArrayList<>());
	}
	public Set<String> getLabels(){
		return yAxisValues.keySet();
	}
	public Map<String, List<String>> getyAxisValues() {
		return yAxisValues;
	}
	public List<String> getxAxisValues() {
		return xAxisValues;
	}
	
	public void addItem(){
		x++;
//		y++;
		xAxisValues.add(String.valueOf(Calendar.getInstance().getTimeInMillis()));
		
		System.out.println("x: " + x + ", y: ");
		for (List<String> item : yAxisValues.values()) {  
			
			System.out.println(String.valueOf( 10 + new Integer((int) Math.random())));
			item.add(String.valueOf( 10 ));
		}
	}
}

