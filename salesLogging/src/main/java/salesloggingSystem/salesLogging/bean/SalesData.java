package salesloggingSystem.salesLogging.bean;

import java.io.Serializable;
import java.util.Date;

public class SalesData implements Serializable {

	private int saleNumber = 0;
	private String saleType = null;
	private String saleItem = null;
	private double saleAmount = 0.0;
	private Date timestamp = null;
	
	public SalesData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SalesData(int saleNumber, String saleType, String saleItem, double saleAmount, Date timestamp) {
		this.saleNumber = saleNumber;
		this.saleType = saleType;
		this.saleItem = saleItem;
		this.saleAmount = saleAmount;
		this.timestamp = timestamp;
	}
	public int getSaleNumber() {
		return saleNumber;
	}
	public void setSaleNumber(int saleNumber) {
		this.saleNumber = saleNumber;
	}
	public String getSaleType() {
		return saleType;
	}
	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}
	public String getSaleItem() {
		return saleItem;
	}
	public void setSaleItem(String saleItem) {
		this.saleItem = saleItem;
	}
	public double getSaleAmount() {
		return saleAmount;
	}
	public void setSaleAmount(double saleAmount) {
		this.saleAmount = saleAmount;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "SalesData [saleNumber=" + saleNumber + ", saleType=" + saleType + ", saleItem=" + saleItem
				+ ", saleAmount=" + saleAmount + ", timestamp=" + timestamp + "]";
	}

	
}
