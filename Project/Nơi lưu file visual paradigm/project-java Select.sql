SELECT id, name, diachi, sodienthoai, mota 
  FROM CuaHang;
SELECT VatPhamid, MotLuotBanid, soluong, gia 
  FROM DsspBan;
SELECT MotLuotNhapid, VatPhamid, soluong, gia 
  FROM DsspNhap;
SELECT id, thoigian, sotien, lathanhtoantienmat, MotLuotBanid 
  FROM HoaDonBan;
SELECT id, thoigian, sotien, lathanhtoantienmat, MotLuotNhapid 
  FROM HoaDonNhap;
SELECT Userid 
  FROM KhachHang;
SELECT id, thoigian, dathanhtoan, CuaHangid, KhachHangUserid, NhanVienUserid 
  FROM MotLuotBan;
SELECT id, thoigian, dathanhtoan, NhaCungCapid, CuaHangid, NhanVienUserid 
  FROM MotLuotNhap;
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
SELECT id, ten, gia, donvi, mota 
  FROM VatPham;

