/**
 *@author TuanBTD
 *@date Dec 27, 2019
 *@version version
 */

package model.bean;

public class SuDungDichVu {
	private String maKH;
	private String maDV;
	private String ngaySD;
	private String gioSD;
	private int soLuong;

	public SuDungDichVu() {
		super();
	}

	public SuDungDichVu(String maKH, String maDV, String ngaySD, String gioSD, int soLuong) {
		super();
		this.maKH = maKH;
		this.maDV = maDV;
		this.ngaySD = ngaySD;
		this.gioSD = gioSD;
		this.soLuong = soLuong;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getMaDV() {
		return maDV;
	}

	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}

	public String getNgaySD() {
		return ngaySD;
	}

	public void setNgaySD(String ngaySD) {
		this.ngaySD = ngaySD;
	}

	public String getGioSD() {
		return gioSD;
	}

	public void setGioSD(String gioSD) {
		this.gioSD = gioSD;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

}
