DELETE FROM CuaHang 
  WHERE id = ?;
DELETE FROM DsSanPhamTrongMotLuotBan 
  WHERE VatPhamid = ? AND MotLuotBanSanPhamid = ?;
DELETE FROM DsSanPhamTrongMotLuotNhap 
  WHERE MotLuotNhapSanPhamid = ? AND VatPhamid = ?;
DELETE FROM HoaDonBan 
  WHERE id = ?;
DELETE FROM HoaDonThanhToanNhap 
  WHERE id = ?;
DELETE FROM KhachHang 
  WHERE Userid = ?;
DELETE FROM MotLuotBanSanPham 
  WHERE id = ?;
DELETE FROM MotLuotNhapSanPham 
  WHERE id = ?;
DELETE FROM NhaCungCap 
  WHERE id = ?;
DELETE FROM NhanVien 
  WHERE Userid = ?;
DELETE FROM Role 
  WHERE id = ?;
DELETE FROM RolesOfUser 
  WHERE Userid = ? AND Roleid = ?;
DELETE FROM [User] 
  WHERE id = ?;
DELETE FROM VatPham 
  WHERE id = ?;

