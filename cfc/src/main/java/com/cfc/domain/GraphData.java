package com.cfc.domain;

import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class GraphData {
	private List<GraphicItem> yAxisValues = new ArrayList<GraphicItem>();
	private List<String> xAxisValues = new ArrayList<>();
	private int x = 0;

	public GraphData() {
//		yAxisValues.add(new GraphicItem("LClx", "line"));
	}
	public List<GraphicItem> getyAxisValues() {
		return yAxisValues;
	}

	public List<String> getxAxisValues() {
		return xAxisValues;
	}

	public void addItem() {
//		xAxisValues.add(String.valueOf(Calendar.getInstance().getTime().getTime()));
//		// xAxisValues.add(LocalTime.now().toString());
//		// System.out.println("x: " + x + ", y: ");
//		for (GraphicItem item : yAxisValues) {
//			if (item.getLabel().equals("LCx"))
//				item.getItemValues().add(String.valueOf(10));
//			else if (item.getLabel().equals("LCSx"))
//				item.getItemValues().add(String.valueOf(15));
//			else
//				item.getItemValues().add(String.valueOf(new Integer((int) (10 + (Math.random() + 1)))));
//		}
	}
	
	public void addItem(String xAxisLabel, String yAxisValue){
		xAxisValues.add(String.valueOf(Calendar.getInstance().getTime().getTime()));
	}
	
	public void setyAxisValues(List<GraphicItem> yAxisValues) {
		this.yAxisValues = yAxisValues;
	}
}
