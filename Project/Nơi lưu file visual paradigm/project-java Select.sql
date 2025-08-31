SELECT id, name, diachi, sodienthoai, mota 
  FROM CuaHang;
SELECT VatPhamid, MotLuotBanSanPhamid, soluong, gia 
  FROM DsSanPhamTrongMotLuotBan;
SELECT MotLuotNhapSanPhamid, VatPhamid, soluong, gia 
  FROM DsSanPhamTrongMotLuotNhap;
SELECT id, thoigian, sotien, lathanhtoantienmat, MotLuotBanSanPhamid 
  FROM HoaDonBan;
SELECT id, thoigian, sotien, lathanhtoantienmat, MotLuotNhapSanPhamid 
  FROM HoaDonThanhToanNhap;
SELECT Userid 
  FROM KhachHang;
SELECT id, thoigian, dathanhtoan, CuaHangid, KhachHangUserid, NhanVienUserid 
  FROM MotLuotBanSanPham;
SELECT id, thoigian, dathanhtoan, NhaCungCapid, CuaHangid, NhanVienUserid 
  FROM MotLuotNhapSanPham;
SELECT id, name, address, sodienthoai, email, mota 
  FROM NhaCungCap;
SELECT Userid 
  FROM NhanVien;
SELECT id, name, mota 
  FROM Role;
SELECT Userid, Roleid 
  FROM RolesOfUser;
SELECT id, username, password, email, sodienthoai, enabled 
  FROM [User];
SELECT id, ten, gia, donvicua1sanpham, mota 
  FROM VatPham;

