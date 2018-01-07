package model;

import java.io.Serializable;

public class DataModel implements Serializable{
	private String status;
	private SinhVien sv;
	public DataModel(String status) {
		
		this.status = status;
	}
	public DataModel() {
		
	}
	public DataModel(String status, SinhVien sv) {
		
		this.status = status;
		this.sv = sv;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public SinhVien getSv() {
		return sv;
	}
	public void setSv(SinhVien sv) {
		this.sv = sv;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sv == null) ? 0 : sv.hashCode());
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
		DataModel other = (DataModel) obj;
		if (sv == null) {
			if (other.sv != null)
				return false;
		} else if (!sv.equals(other.sv))
			return false;
		return true;
	}
	
	
	
}
