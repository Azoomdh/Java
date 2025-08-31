UPDATE CuaHang SET 
  name = ?, 
  diachi = ?, 
  sodienthoai = ?, 
  mota = ? 
WHERE
  id = ?;
UPDATE DsspBan SET 
  soluong = ?, 
  gia = ? 
WHERE
  VatPhamid = ? AND MotLuotBanid = ?;
UPDATE DsspNhap SET 
  soluong = ?, 
  gia = ? 
WHERE
  MotLuotNhapid = ? AND VatPhamid = ?;
UPDATE HoaDonBan SET 
  thoigian = ?, 
  sotien = ?, 
  lathanhtoantienmat = ?, 
  MotLuotBanid = ? 
WHERE
  id = ?;
UPDATE HoaDonNhap SET 
  thoigian = ?, 
  sotien = ?, 
  lathanhtoantienmat = ?, 
  MotLuotNhapid = ? 
WHERE
  id = ?;
UPDATE KhachHang SET 
   
WHERE
  Userid = ?;
UPDATE MotLuotBan SET 
  thoigian = ?, 
  dathanhtoan = ?, 
  CuaHangid = ?, 
  KhachHangUserid = ?, 
  NhanVienUserid = ? 
WHERE
  id = ?;
UPDATE MotLuotNhap SET 
  thoigian = ?, 
  dathanhtoan = ?, 
  NhaCungCapid = ?, 
  CuaHangid = ?, 
  NhanVienUserid = ? 
WHERE
  id = ?;
UPDATE NhaCungCap SET 
  name = ?, 
  address = ?, 
  sodienthoai = ?, 
  email = ?, 
  mota = ? 
WHERE
  id = ?;
UPDATE NhanVien SET 
   
WHERE
  Userid = ?;
UPDATE Role SET 
  name = ?, 
  mota = ? 
WHERE
  id = ?;
UPDATE RolesOfUser SET 
   
WHERE
  Userid = ? AND Roleid = ?;
UPDATE [User] SET 
  username = ?, 
  password = ?, 
  email = ?, 
  sodienthoai = ?, 
  enabled = ? 
WHERE
  id = ?;
UPDATE VatPham SET 
  ten = ?, 
  gia = ?, 
  donvicua1sanpham = ?, 
  mota = ? 
WHERE
  id = ?;

