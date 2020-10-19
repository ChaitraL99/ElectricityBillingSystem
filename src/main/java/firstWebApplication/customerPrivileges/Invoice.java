package firstWebApplication.customerPrivileges;

import firstWebApplication.adminPrivileges.Customer;

public class Invoice {

	private int custId;
	private String name;
	private String state;
	private int meterNo;
	private int units;
	private int price;
	private int totalAmount;
	
	public Invoice(int custId, String name, String state, int meterNo, int units, int price, int totalAmount) {
		super();
		this.custId = custId;
		this.name = name;
		this.state = state;
		this.meterNo = meterNo;
		this.units = units;
		this.price = price;
		this.totalAmount = totalAmount;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getMeterNo() {
		return meterNo;
	}

	public void setMeterNo(int meterNo) {
		this.meterNo = meterNo;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	
}
