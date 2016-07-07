package com.cfc.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class MainData implements Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal insuredAmount = BigDecimal.ZERO;
	private BigDecimal currentBalance = BigDecimal.ZERO;
	private BigDecimal lazyAmount = BigDecimal.ZERO;
	private BigDecimal autorizedBalance = BigDecimal.ZERO;
	private BigDecimal reorderPoint = BigDecimal.ZERO;
	private int utilizationRate;

	private List<Item> cashBehaviorDetail = new ArrayList<Item>();
	private List<Item> currentBalanceHistory = new ArrayList<Item>();
	private Forecast forecast = new Forecast();
	private GraphData compEfectivoGraph;
	private GraphData varEfectivoGraph;

	private List<Item> cashVariations = new ArrayList<Item>();
	private List<Item> cashValHistory = new ArrayList<Item>();
	
	public MainData() {
		// Linked
		compEfectivoGraph = new GraphData();
		compEfectivoGraph = new GraphData();
	}

	public BigDecimal getInsuredAmount() {
		return insuredAmount;
	}

	public void setInsuredAmount(BigDecimal insuredAmount) {
		this.insuredAmount = insuredAmount;
	}

	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}

	public BigDecimal getLazyAmount() {
		return lazyAmount;
	}

	public void setLazyAmount(BigDecimal lazyAmount) {
		this.lazyAmount = lazyAmount;
	}

	public BigDecimal getAutorizedBalance() {
		return autorizedBalance;
	}

	public void setAutorizedBalance(BigDecimal autorizedBalance) {
		this.autorizedBalance = autorizedBalance;
	}

	public BigDecimal getReorderPoint() {
		return reorderPoint;
	}

	public void setReorderPoint(BigDecimal reorderPoint) {
		this.reorderPoint = reorderPoint;
	}

	public int getUtilizationRate() {
		return utilizationRate;
	}

	public void setUtilizationRate(int utilizationRate) {
		this.utilizationRate = utilizationRate;
	}

	public List<Item> getCashBehaviorDetail() {
		return cashBehaviorDetail;
	}

	public void setCashBehaviorDetail(List<Item> cashBehaviorDetail) {
		this.cashBehaviorDetail = cashBehaviorDetail;
	}

	public Forecast getForecast() {
		return forecast;
	}

	public void setForecast(Forecast forecast) {
		this.forecast = forecast;
	}

	public GraphData getCompEfectivoGraph() {
		return compEfectivoGraph;
	}

	public void setCompEfectivoGraph(GraphData compEfectivoGraph) {
		this.compEfectivoGraph = compEfectivoGraph;
	}

	public GraphData getVarEfectivoGraph() {
		return varEfectivoGraph;
	}

	public void setVarEfectivoGraph(GraphData varEfectivoGraph) {
		this.varEfectivoGraph = varEfectivoGraph;
	}

	public List<Item> getCurrentBalanceHistory() {
		return currentBalanceHistory;
	}

	public void setCurrentBalanceHistory(List<Item> currentBalanceHistory) {
		this.currentBalanceHistory = currentBalanceHistory;
	}

	public List<Item> getCashVariations() {
		return cashVariations;
	}

	public void setCashVariations(List<Item> cashVariations) {
		this.cashVariations = cashVariations;
	}
	public List<Item> getCashValHistory() {
		return cashValHistory;
	}
	public void setCashValHistory(List<Item> cashValHistory) {
		this.cashValHistory = cashValHistory;
	}
}
