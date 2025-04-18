let checkYear = +prompt("Nhập năm ");
if (checkYear % 4 == 0 && checkYear % 100 != 0 || checkYear % 100 == 0 && checkYear % 400 == 0) {
  alert("Năm " + checkYear + " là năm nhuận");
} else if (checkYear % 100 == 0 && checkYear % 400 != 0) {
  alert("Năm " + checkYear + " không phải là năm nhuận")
}