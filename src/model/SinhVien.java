package model;

import java.io.Serializable;

public class SinhVien implements Serializable{
	private int maSV;
	private String tenSV;
	private String email;
	
	public int getMaSV() {
		return maSV;
	}

	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}

	public String getTenSV() {
		return tenSV;
	}

	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public SinhVien(String tenSV, String email) {
		super();
		this.tenSV = tenSV;
		this.email = email;
	}

	public SinhVien() {
		super();
	}

	public SinhVien(int maSV, String tenSV, String email) {
		super();
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maSV;
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
		SinhVien other = (SinhVien) obj;
		if (maSV != other.maSV)
			return false;
		return true;
	}

	
	
	
}
