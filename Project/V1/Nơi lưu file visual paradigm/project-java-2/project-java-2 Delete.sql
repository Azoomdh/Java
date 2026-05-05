DELETE FROM DsspBan WHERE VatPhamid = ? AND MotLuotBanid = ?;
DELETE FROM DsspNhap WHERE MotLuotNhapid = ? AND VatPhamid = ?;
DELETE FROM MotLuotBan WHERE id = ?;
DELETE FROM MotLuotNhap WHERE id = ?;
DELETE FROM Role WHERE id = ?;
DELETE FROM RolesOfUser WHERE Userid = ? AND Roleid = ?;
DELETE FROM [User] WHERE id = ?;
DELETE FROM VatPham WHERE id = ?;

