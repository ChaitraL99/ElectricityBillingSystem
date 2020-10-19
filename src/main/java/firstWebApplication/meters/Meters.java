package firstWebApplication.meters;

public class Meters {
	
	private String state;
	private int meterNo;
	private int custId;
	
	public Meters(int meterNo, int custId) {
		super();
		this.meterNo = meterNo;
		this.custId = custId;
	}

	public int getMeterNo() {
		return meterNo;
	}

	public void setMeterNo(int meterNo) {
		this.meterNo = meterNo;
	}
	
	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	@Override
	public String toString() {
		return String.format("Meters [state=%s, meterNo=%s, custId=%s]", state, meterNo, custId);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + meterNo;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		Meters other = (Meters) obj;
		if (meterNo != other.meterNo)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
}
