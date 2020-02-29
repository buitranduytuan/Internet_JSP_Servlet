/**
 *@author TuanBTD
 *@date Dec 27, 2019
 *@version version
 */

package model.bean;

public class SuDungMay {
	private String maKH;
	private String maMay;
	private String ngayBDSD;
	private String gioBDSD;
	private int thoiGianSD;
	public SuDungMay() {
		super();
	}
	public SuDungMay(String maKH, String maMay, String ngayBDSD, String gioBDSD, int thoiGianSD) {
		super();
		this.maKH = maKH;
		this.maMay = maMay;
		this.ngayBDSD = ngayBDSD;
		this.gioBDSD = gioBDSD;
		this.thoiGianSD = thoiGianSD;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getMaMay() {
		return maMay;
	}
	public void setMaMay(String maMay) {
		this.maMay = maMay;
	}
	public String getNgayBDSD() {
		return ngayBDSD;
	}
	public void setNgayBDSD(String ngayBDSD) {
		this.ngayBDSD = ngayBDSD;
	}
	public String getGioBDSD() {
		return gioBDSD;
	}
	public void setGioBDSD(String gioBDSD) {
		this.gioBDSD = gioBDSD;
	}
	public int getThoiGianSD() {
		return thoiGianSD;
	}
	public void setThoiGianSD(int thoiGianSD) {
		this.thoiGianSD = thoiGianSD;
	}
	
}
