UPDATE DsspBan SET soluong = ?, gia = ? WHERE VatPhamid = ? AND MotLuotBanid = ?;
UPDATE DsspNhap SET soluong = ?, gia = ? WHERE MotLuotNhapid = ? AND VatPhamid = ?;
UPDATE MotLuotBan SET thoigian = ?, dathanhtoan = ?, UseridNhanvien = ? WHERE id = ?;
UPDATE MotLuotNhap SET thoigian = ?, dathanhtoan = ?, UseridNhanvien = ? WHERE id = ?;
UPDATE Role SET name = ?, mota = ? WHERE id = ?;
UPDATE RolesOfUser SET  WHERE Userid = ? AND Roleid = ?;
UPDATE [User] SET username = ?, password = ?, email = ?, sodienthoai = ?, enabled = ? WHERE id = ?;
UPDATE VatPham SET ten = ?, gia = ?, donvi = ?, mota = ?, urlanh = ?, soluong = ? WHERE id = ?;

