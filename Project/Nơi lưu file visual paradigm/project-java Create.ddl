CREATE TABLE CuaHang (
  id          bigint IDENTITY NOT NULL, 
  name        int NOT NULL, 
  diachi      int NOT NULL, 
  sodienthoai int NOT NULL, 
  mota        int NULL, 
  PRIMARY KEY (id));
CREATE TABLE DsSanPhamTrongMotLuotBan (
  VatPhamid           bigint NOT NULL, 
  MotLuotBanSanPhamid bigint NOT NULL, 
  soluong             int NOT NULL, 
  gia                 int NOT NULL, 
  PRIMARY KEY (VatPhamid, 
  MotLuotBanSanPhamid));
CREATE TABLE DsSanPhamTrongMotLuotNhap (
  MotLuotNhapSanPhamid bigint NOT NULL, 
  VatPhamid            bigint NOT NULL, 
  soluong              int NOT NULL, 
  gia                  int NOT NULL, 
  PRIMARY KEY (MotLuotNhapSanPhamid, 
  VatPhamid));
CREATE TABLE HoaDonBan (
  id                  bigint IDENTITY NOT NULL, 
  thoigian            int NOT NULL, 
  sotien              int NOT NULL, 
  lathanhtoantienmat  int NOT NULL, 
  MotLuotBanSanPhamid bigint NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE HoaDonThanhToanNhap (
  id                   bigint IDENTITY NOT NULL, 
  thoigian             int NOT NULL, 
  sotien               int NOT NULL, 
  lathanhtoantienmat   bit NOT NULL, 
  MotLuotNhapSanPhamid bigint NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE KhachHang (
  Userid bigint NOT NULL, 
  PRIMARY KEY (Userid));
CREATE TABLE MotLuotBanSanPham (
  id              bigint IDENTITY NOT NULL, 
  thoigian        datetime NOT NULL, 
  dathanhtoan     bit NOT NULL, 
  CuaHangid       bigint NOT NULL, 
  KhachHangUserid bigint NOT NULL, 
  NhanVienUserid  bigint NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE MotLuotNhapSanPham (
  id             bigint IDENTITY NOT NULL, 
  thoigian       datetime NOT NULL, 
  dathanhtoan    bit NOT NULL, 
  NhaCungCapid   bigint NOT NULL, 
  CuaHangid      bigint NOT NULL, 
  NhanVienUserid bigint NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE NhaCungCap (
  id          bigint IDENTITY NOT NULL, 
  name        varchar(255) NOT NULL, 
  address     varchar(255) NOT NULL, 
  sodienthoai varchar(255) NOT NULL, 
  email       varchar(255) NOT NULL, 
  mota        varchar(255) NULL, 
  PRIMARY KEY (id));
CREATE TABLE NhanVien (
  Userid bigint NOT NULL, 
  PRIMARY KEY (Userid));
CREATE TABLE Role (
  id   bigint IDENTITY NOT NULL, 
  name varchar(255) NOT NULL, 
  mota varchar(255) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE RolesOfUser (
  Userid bigint NOT NULL, 
  Roleid bigint NOT NULL, 
  PRIMARY KEY (Userid, 
  Roleid));
CREATE TABLE [User] (
  id          bigint IDENTITY NOT NULL, 
  username    varchar(255) NOT NULL UNIQUE, 
  password    varchar(255) NOT NULL, 
  email       varchar(255) NOT NULL, 
  sodienthoai varchar(255) NOT NULL, 
  enabled     bit NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE VatPham (
  id               bigint IDENTITY NOT NULL, 
  ten              varchar(255) NOT NULL, 
  gia              int NOT NULL, 
  donvicua1sanpham int NOT NULL, 
  mota             varchar(255) NULL, 
  PRIMARY KEY (id));
ALTER TABLE HoaDonBan ADD CONSTRAINT FKHoaDonBan808050 FOREIGN KEY (MotLuotBanSanPhamid) REFERENCES MotLuotBanSanPham (id);
ALTER TABLE DsSanPhamTrongMotLuotBan ADD CONSTRAINT FKDsSanPhamT110730 FOREIGN KEY (MotLuotBanSanPhamid) REFERENCES MotLuotBanSanPham (id);
ALTER TABLE DsSanPhamTrongMotLuotBan ADD CONSTRAINT FKDsSanPhamT735639 FOREIGN KEY (VatPhamid) REFERENCES VatPham (id);
ALTER TABLE MotLuotBanSanPham ADD CONSTRAINT FKMotLuotBan209155 FOREIGN KEY (NhanVienUserid) REFERENCES NhanVien (Userid);
ALTER TABLE MotLuotBanSanPham ADD CONSTRAINT FKMotLuotBan536061 FOREIGN KEY (KhachHangUserid) REFERENCES KhachHang (Userid);
ALTER TABLE MotLuotBanSanPham ADD CONSTRAINT FKMotLuotBan430775 FOREIGN KEY (CuaHangid) REFERENCES CuaHang (id);
ALTER TABLE DsSanPhamTrongMotLuotNhap ADD CONSTRAINT FKDsSanPhamT532372 FOREIGN KEY (VatPhamid) REFERENCES VatPham (id);
ALTER TABLE DsSanPhamTrongMotLuotNhap ADD CONSTRAINT FKDsSanPhamT214956 FOREIGN KEY (MotLuotNhapSanPhamid) REFERENCES MotLuotNhapSanPham (id);
ALTER TABLE HoaDonThanhToanNhap ADD CONSTRAINT FKHoaDonThan464402 FOREIGN KEY (MotLuotNhapSanPhamid) REFERENCES MotLuotNhapSanPham (id);
ALTER TABLE MotLuotNhapSanPham ADD CONSTRAINT FKMotLuotNha251425 FOREIGN KEY (NhanVienUserid) REFERENCES NhanVien (Userid);
ALTER TABLE MotLuotNhapSanPham ADD CONSTRAINT FKMotLuotNha388505 FOREIGN KEY (CuaHangid) REFERENCES CuaHang (id);
ALTER TABLE MotLuotNhapSanPham ADD CONSTRAINT FKMotLuotNha202029 FOREIGN KEY (NhaCungCapid) REFERENCES NhaCungCap (id);
ALTER TABLE RolesOfUser ADD CONSTRAINT FKRolesOfUse576874 FOREIGN KEY (Roleid) REFERENCES Role (id);
ALTER TABLE RolesOfUser ADD CONSTRAINT FKRolesOfUse55470 FOREIGN KEY (Userid) REFERENCES [User] (id);
ALTER TABLE KhachHang ADD CONSTRAINT FKKhachHang878764 FOREIGN KEY (Userid) REFERENCES [User] (id);
ALTER TABLE NhanVien ADD CONSTRAINT FKNhanVien91737 FOREIGN KEY (Userid) REFERENCES [User] (id);

