INSERT INTO DsspBan(VatPhamid, MotLuotBanid, soluong, gia) VALUES (?, ?, ?, ?);
INSERT INTO DsspNhap(MotLuotNhapid, VatPhamid, soluong, gia) VALUES (?, ?, ?, ?);
INSERT INTO MotLuotBan(id, thoigian, dathanhtoan, UseridNhanvien) VALUES (?, ?, ?, ?);
INSERT INTO MotLuotNhap(id, thoigian, dathanhtoan, UseridNhanvien) VALUES (?, ?, ?, ?);
INSERT INTO Role(id, name, mota) VALUES (?, ?, ?);
INSERT INTO RolesOfUser(Userid, Roleid) VALUES (?, ?);
INSERT INTO [User](id, username, password, email, sodienthoai, enabled) VALUES (?, ?, ?, ?, ?, ?);
INSERT INTO VatPham(id, ten, gia, donvi, mota, urlanh, soluong) VALUES (?, ?, ?, ?, ?, ?, ?);

