// let diemHocvien = +prompt("Nhập điểm học viên")
let diemHocvien = document.getElementById("diemHocvienid").value;
let passmodule = document.getElementById("passmodule");
function myDiemhocvien() {
  if (diemHocvien >= 75) {
    passmodule.innerHTML = "pass module"
  }
  else {
    passmodule.innerHTML = "fail module";
  }
}