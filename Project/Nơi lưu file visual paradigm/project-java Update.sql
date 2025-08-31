UPDATE CuaHang SET 
  name = ?, 
  diachi = ?, 
  sodienthoai = ?, 
  mota = ? 
WHERE
  id = ?;
UPDATE DsSanPhamTrongMotLuotBan SET 
  soluong = ?, 
  gia = ? 
WHERE
  VatPhamid = ? AND MotLuotBanSanPhamid = ?;
UPDATE DsSanPhamTrongMotLuotNhap SET 
  soluong = ?, 
  gia = ? 
WHERE
  MotLuotNhapSanPhamid = ? AND VatPhamid = ?;
UPDATE HoaDonBan SET 
  thoigian = ?, 
  sotien = ?, 
  lathanhtoantienmat = ?, 
  MotLuotBanSanPhamid = ? 
WHERE
  id = ?;
UPDATE HoaDonThanhToanNhap SET 
  thoigian = ?, 
  sotien = ?, 
  lathanhtoantienmat = ?, 
  MotLuotNhapSanPhamid = ? 
WHERE
  id = ?;
UPDATE KhachHang SET 
   
WHERE
  Userid = ?;
UPDATE MotLuotBanSanPham SET 
  thoigian = ?, 
  dathanhtoan = ?, 
  CuaHangid = ?, 
  KhachHangUserid = ?, 
  NhanVienUserid = ? 
WHERE
  id = ?;
UPDATE MotLuotNhapSanPham SET 
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

