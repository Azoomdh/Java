INSERT INTO CuaHang
  (id, 
  name, 
  diachi, 
  sodienthoai, 
  mota) 
VALUES 
  (?, 
  ?, 
  ?, 
  ?, 
  ?);
INSERT INTO DsSanPhamTrongMotLuotBan
  (VatPhamid, 
  MotLuotBanSanPhamid, 
  soluong, 
  gia) 
VALUES 
  (?, 
  ?, 
  ?, 
  ?);
INSERT INTO DsSanPhamTrongMotLuotNhap
  (MotLuotNhapSanPhamid, 
  VatPhamid, 
  soluong, 
  gia) 
VALUES 
  (?, 
  ?, 
  ?, 
  ?);
INSERT INTO HoaDonBan
  (id, 
  thoigian, 
  sotien, 
  lathanhtoantienmat, 
  MotLuotBanSanPhamid) 
VALUES 
  (?, 
  ?, 
  ?, 
  ?, 
  ?);
INSERT INTO HoaDonThanhToanNhap
  (id, 
  thoigian, 
  sotien, 
  lathanhtoantienmat, 
  MotLuotNhapSanPhamid) 
VALUES 
  (?, 
  ?, 
  ?, 
  ?, 
  ?);
INSERT INTO KhachHang
  (Userid) 
VALUES 
  (?);
INSERT INTO MotLuotBanSanPham
  (id, 
  thoigian, 
  dathanhtoan, 
  CuaHangid, 
  KhachHangUserid, 
  NhanVienUserid) 
VALUES 
  (?, 
  ?, 
  ?, 
  ?, 
  ?, 
  ?);
INSERT INTO MotLuotNhapSanPham
  (id, 
  thoigian, 
  dathanhtoan, 
  NhaCungCapid, 
  CuaHangid, 
  NhanVienUserid) 
VALUES 
  (?, 
  ?, 
  ?, 
  ?, 
  ?, 
  ?);
INSERT INTO NhaCungCap
  (id, 
  name, 
  address, 
  sodienthoai, 
  email, 
  mota) 
VALUES 
  (?, 
  ?, 
  ?, 
  ?, 
  ?, 
  ?);
INSERT INTO NhanVien
  (Userid) 
VALUES 
  (?);
INSERT INTO Role
  (id, 
  name, 
  mota) 
VALUES 
  (?, 
  ?, 
  ?);
INSERT INTO RolesOfUser
  (Userid, 
  Roleid) 
VALUES 
  (?, 
  ?);
INSERT INTO [User]
  (id, 
  username, 
  password, 
  email, 
  sodienthoai, 
  enabled) 
VALUES 
  (?, 
  ?, 
  ?, 
  ?, 
  ?, 
  ?);
INSERT INTO VatPham
  (id, 
  ten, 
  gia, 
  donvicua1sanpham, 
  mota) 
VALUES 
  (?, 
  ?, 
  ?, 
  ?, 
  ?);

