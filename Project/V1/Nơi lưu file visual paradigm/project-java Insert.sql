INSERT INTO CuaHang(id, name, diachi, sodienthoai, mota) VALUES (?, ?, ?, ?, ?);
INSERT INTO DsspBan(VatPhamid, MotLuotBanid, soluong, gia) VALUES (?, ?, ?, ?);
INSERT INTO DsspNhap(MotLuotNhapid, VatPhamid, soluong, gia) VALUES (?, ?, ?, ?);
INSERT INTO HoaDonBan(id, thoigian, sotien, lathanhtoantienmat, MotLuotBanid) VALUES (?, ?, ?, ?, ?);
INSERT INTO HoaDonNhap(id, thoigian, sotien, lathanhtoantienmat, MotLuotNhapid) VALUES (?, ?, ?, ?, ?);
INSERT INTO KhachHang(Userid) VALUES (?);
INSERT INTO MotLuotBan(id, thoigian, dathanhtoan, CuaHangid, KhachHangUserid, NhanVienUserid) VALUES (?, ?, ?, ?, ?, ?);
INSERT INTO MotLuotNhap(id, thoigian, dathanhtoan, NhaCungCapid, CuaHangid, NhanVienUserid) VALUES (?, ?, ?, ?, ?, ?);
INSERT INTO NhaCungCap(id, name, address, sodienthoai, email, mota) VALUES (?, ?, ?, ?, ?, ?);
INSERT INTO NhanVien(Userid) VALUES (?);
INSERT INTO Role(id, name, mota) VALUES (?, ?, ?);
INSERT INTO RolesOfUser(Userid, Roleid) VALUES (?, ?);
INSERT INTO [User](id, username, password, email, sodienthoai, enabled) VALUES (?, ?, ?, ?, ?, ?);
INSERT INTO VatPham(id, ten, gia, donvi, mota, urlanh) VALUES (?, ?, ?, ?, ?, ?);

