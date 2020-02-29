/*
 *@user: TuanBTD
 *@date: Feb 5, 2020
 */

package model.BO;

import java.time.LocalDate;

public class ValidateBO {
	public static boolean validateMaKH(String maKH){
		boolean check = false;
		String regex = "/^KH\\d{5}$/";
		check = maKH.matches(regex);
		return check;
	}
	public static boolean validateMaMay(String maMay){
		boolean check = false;
		String regex = "/^MAY\\d{4}$/";
		check = maMay.matches(regex);
		return check;
	}
	public static boolean validateMaDV(String maDV){
		boolean check = false;
		String regex = "/^DV\\d{3}$/";
		check = maDV.matches(regex);
		return check;
	}
	
	public static boolean validateNumber(String numberSt) {
		boolean check = true;
		try {
			Integer.parseInt(numberSt);
		}
		catch(Exception e) {
			check = false;
			e.printStackTrace();
		}
		return check;
	}

	public static boolean validatePhone(String phone){
		boolean check = false;
		String regex = "/^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$/";
		check = phone.matches(regex);
		return check;
	}

	public static boolean validateEmail(String email){
		boolean check = false;
		String regex = "/^\\S+@\\S+\\.\\S+$/";
		check = email.matches(regex);
		return check;
	}
	
	public static boolean validateDate(String date) {
		boolean check = false;
		String[] splitValues = date.split("/");
		if(splitValues.length==3) {
			try {
				int day = Integer.parseInt(splitValues[0]);
				int month = Integer.parseInt(splitValues[1]);
				int year = Integer.parseInt(splitValues[2]);
				LocalDate.of(year, month, day);
				check = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		return check;
	}
	
	public static void main(String[] args) {
		System.out.println(validateDate("12/10/1029"));
	}
}
