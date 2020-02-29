/**
 *@author TuanBTD
 *@date Dec 27, 2019
 *@version version
 */

package model.bean;

public class ThongTinKhachHangSuDungMayVaDV {
//	Mã KH, Tên KH, Mã máy, Vị trí, Trạng thái, Ngày bắt đầu sử dụng máy, Giờ bắt đầu sử dụng máy, Thời gian sử dụng máy,
//	Mã dịch vụ, Ngày sử dụng dịch vụ, Giờ sử dụng dịch vụ, Số lượng, Tổng tiền.
	private String maKH;
	private String tenKH;
	private String maMay;
	private String viTri;
	private String trangThai;
	private String ngayBDSDMay;
	private String gioBDSDMay;
	private String thoiGianSDMay;
	private String maDV;
	private String ngaySD;
	private String gioSD;
	private int soLuong;
	private int tongTien;

	public ThongTinKhachHangSuDungMayVaDV() {
		super();
	}

	public ThongTinKhachHangSuDungMayVaDV(String maKH, String tenKH, String maMay, String viTri, String trangThai,
			String ngayBDSD, String gioBDSD, String thoiGianSDMay, String maDV, String ngaySD, String gioSD,
			int soLuong, int tongTien) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.maMay = maMay;
		this.viTri = viTri;
		this.trangThai = trangThai;
		this.ngayBDSDMay = ngayBDSD;
		this.gioBDSDMay = gioBDSD;
		this.thoiGianSDMay = thoiGianSDMay;
		this.maDV = maDV;
		this.ngaySD = ngaySD;
		this.gioSD = gioSD;
		this.soLuong = soLuong;
		this.tongTien = tongTien;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getMaMay() {
		return maMay;
	}

	public void setMaMay(String maMay) {
		this.maMay = maMay;
	}

	public String getViTri() {
		return viTri;
	}

	public void setViTri(String viTri) {
		this.viTri = viTri;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getNgayBDSDMay() {
		return ngayBDSDMay;
	}

	public void setNgayBDSDMay(String ngayBDSDMay) {
		this.ngayBDSDMay = ngayBDSDMay;
	}

	public String getGioBDSDMay() {
		return gioBDSDMay;
	}

	public void setGioBDSDMay(String gioBDSDMay) {
		this.gioBDSDMay = gioBDSDMay;
	}

	public String getThoiGianSDMay() {
		return thoiGianSDMay;
	}

	public void setThoiGianSDMay(String thoiGianSDMay) {
		this.thoiGianSDMay = thoiGianSDMay;
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

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

}
