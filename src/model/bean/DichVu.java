/**
 *@author TuanBTD
 *@date Dec 27, 2019
 *@version version
 */

package model.bean;

public class DichVu {
	private String maDV;
	private String tenDV;
	private String donViTinh;
	private int donGia;


	public DichVu() {
		super();
	}

	public DichVu(String maDV, String tenDV, String donViTinh, int donGia) {
		super();
		this.maDV = maDV;
		this.tenDV = tenDV;
		this.donViTinh = donViTinh;
		this.donGia = donGia;
	}

	public String getMaDV() {
		return maDV;
	}

	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}

	public String getTenDV() {
		return tenDV;
	}

	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

}
