function printError(idError, content){
	document.getElementById(idError).innerHTML = content;
}

function validateNumber(id, idError) {
	var x = document.getElementById(id).value;
	if (isNaN(x) || x < 1) {
		printError(idError, "Input not valid");
	} else {
		printError(idError, "");
	}
}

function validatePhone(id, idError){
	var phone = document.getElementById(id).value;
	var regex = /^(090|091|\(84\)\+90|\(84\)\+91)\d{7}$/;
	if(regex.test(phone) === false) {
		printError(idError, "Số điện thoại không đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx");
	} else {
		printError(idError, "");
	}
}

function validateEmail(id, idError){
	var email = document.getElementById(id).value;
	var regex = /^\S+@\S+\.\S+$/;
	if(regex.test(email) === false) {
		printError(idError, "Email không đúng định dạng");
	} else {
		printError(idError, "");
	}
}

function validateMaMay(){
	var maMay = document.getElementById("maMay").value;
	var regex =/^MAY\d{4}$/;
	if(regex.test(maMay)) {
		printError("errorMM", "");
	} else {
		printError("errorMM", "Mã máy phải có định dang (MAYxxxx) x: là ký tự số");
	}
}

function validateMaKH(){
	var maKH = document.getElementById("maKH").value;
	var regex = /^KH\d{5}$/;
	if(regex.test(maKH) === false) {
		printError("errorMaKH", "Mã Khách Hàng phải có định dạng (KHxxxxx) x: là ký tự số");
	} else {
		printError("errorMaKH", "");
	}
}

function validateMaDV(){
	var maDV = document.getElementById("maDV").value;
	var regex = /^DV\d{3}$/;
	if(regex.test(maDV) === false) {
		printError("errorMaDV", "Mã Dịch Vụ phải có định dạng (DVxxx) x: là ký tự số");
	} else {
		printError("errorMaDV", "");
	}
}

function validateFormTaoMay(){
	var maMay = document.getElementById("maMay").value;
	var viTri = document.getElementById("viTri").value;
	var regex = /^MAY\d{4}$/;
	if(viTri == "" || maMay == ""){
		printError("errorRong", "Hãy điền đầy đủ các trường");
		return false;
	}
	if(regex.test(maMay)) {
		return true;
	} else {
		return false;
	}
}

function validateFormTaoDV(){
	var maDV = document.getElementById("maDV").value;
	var tenDV = document.getElementById("tenDV").value;
	var donGia = document.getElementById("donGia").value;
	var regex = /^DV\d{3}$/;
	if(maDV == "" || tenDV == "" || donGia == ""){
		printError("errorRong", "Hãy điền đầy đủ các trường");
		return false;
	}
	if(regex.test(maDV) && !isNaN(donGia) && donGia>0) {
		return true;
	} else {
		return false;
	}
}

function validateTaoKH(){
	var maKH = document.getElementById("maKH").value;
	var regex = /^KH\d{5}$/;
	var phone = document.getElementById("sdt").value;
	var regexPhone = /^(090|091|\(84\)\+90|\(84\)\+91)\d{7}$/;
	var email = document.getElementById("email").value;
	var regexEmail =  /^\S+@\S+\.\S+$/;
	var tenKH = document.getElementById("tenKH").value;
	var diaChi = document.getElementById("diaChi").value;

	if(maKH == "" || tenKH == "" || diaChi == "" || phone == "" || email == ""){
		printError("errorRong", "Hãy điền đầy đủ các trường");
		return false;
	}
	
	if(regex.test(maKH) && regexPhone.test(phone) && regexEmail.test(email)){
		return true;
	}  
	return false;
}

function validateFormDKSDDV(){
	var maDV = document.getElementById("maDV").value;
	var regexDV = /^DV\d{3}$/;
	var maKH = document.getElementById("maKH").value;
	var regexKH = /^KH\d{5}$/;
	var soLuong = document.getElementById("soLuong").value;
	if( maKH == "" || maDV == "" || soLuong == "" ){
		printError("errorRong", "Hãy điền đầy đủ các trường");
		return false;
	}
	if(regexDV.test(maDV)===false || regexKH.test(maKH)===false){
		return false;
	}
	if (isNaN(soLuong) || soLuong < 1){
		return false;
	}
	return true;
}

function validateFormDKSDMay(){
	var maMay = document.getElementById("maMay").value;
	var regexMM = /^MAY\d{4}$/;
	var maKH = document.getElementById("maKH").value;
	var regexKH = /^KH\d{5}$/;
	var thoiGianSD = document.getElementById("thoiGianSD").value;
	if(maKH == "" || maMay == "" || thoiGianSD == "" ){
		printError("errorRong", "Hãy điền đầy đủ các trường");
		return false;
	}
	if(regexMM.test(maMay)===false || regexKH.test(maKH)===false){
		return false;
	}
	if (isNaN(thoiGianSD) || thoiGianSD < 1){
		return false;
	}	
	return true;
}

