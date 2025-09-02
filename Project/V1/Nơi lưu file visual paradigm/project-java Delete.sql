DELETE FROM CuaHang WHERE id = ?;
DELETE FROM DsspBan WHERE VatPhamid = ? AND MotLuotBanid = ?;
DELETE FROM DsspNhap WHERE MotLuotNhapid = ? AND VatPhamid = ?;
DELETE FROM HoaDonBan WHERE id = ?;
DELETE FROM HoaDonNhap WHERE id = ?;
DELETE FROM KhachHang WHERE Userid = ?;
DELETE FROM MotLuotBan WHERE id = ?;
DELETE FROM MotLuotNhap WHERE id = ?;
DELETE FROM NhaCungCap WHERE id = ?;
DELETE FROM NhanVien WHERE Userid = ?;
DELETE FROM Role WHERE id = ?;
DELETE FROM RolesOfUser WHERE Userid = ? AND Roleid = ?;
DELETE FROM [User] WHERE id = ?;
DELETE FROM VatPham WHERE id = ?;

