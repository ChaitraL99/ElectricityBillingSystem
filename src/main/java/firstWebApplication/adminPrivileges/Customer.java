package firstWebApplication.adminPrivileges;

public class Customer {

	private String name;
	private String password;
	private String state;
	private int meterNo;

	public Customer(String name, String password, String state, int meterNo) {
		super();
		this.name = name;
		this.password = password;
		this.state = state;
		this.meterNo = meterNo;
	}
	public Customer(String name, String state, int meterNo) {
		super();
		this.name = name;
		this.state = state;
		this.meterNo = meterNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return String.format("Customer [name=%s, password=%s, state=%s, meterNo=%s]", name, password, state, meterNo);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}