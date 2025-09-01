CREATE TABLE CuaHang (
  id          bigint IDENTITY NOT NULL, 
  name        nvarchar(255) NOT NULL, 
  diachi      nvarchar(255) NOT NULL, 
  sodienthoai nvarchar(255) NOT NULL, 
  mota        nvarchar(255) NULL, 
  PRIMARY KEY (id));
CREATE TABLE DsspBan (
  VatPhamid    bigint NOT NULL, 
  MotLuotBanid bigint NOT NULL, 
  soluong      int NOT NULL, 
  gia          bigint NOT NULL, 
  PRIMARY KEY (VatPhamid, 
  MotLuotBanid));
CREATE TABLE DsspNhap (
  MotLuotNhapid bigint NOT NULL, 
  VatPhamid     bigint NOT NULL, 
  soluong       int NOT NULL, 
  gia           bigint NOT NULL, 
  PRIMARY KEY (MotLuotNhapid, 
  VatPhamid));
CREATE TABLE HoaDonBan (
  id                 bigint IDENTITY NOT NULL, 
  thoigian           datetime NOT NULL, 
  sotien             bigint NOT NULL, 
  lathanhtoantienmat bit NOT NULL, 
  MotLuotBanid       bigint NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE HoaDonNhap (
  id                 bigint IDENTITY NOT NULL, 
  thoigian           datetime NOT NULL, 
  sotien             bigint NOT NULL, 
  lathanhtoantienmat bit NOT NULL, 
  MotLuotNhapid      bigint NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE KhachHang (
  Userid bigint NOT NULL, 
  PRIMARY KEY (Userid));
CREATE TABLE MotLuotBan (
  id              bigint IDENTITY NOT NULL, 
  thoigian        datetime NOT NULL, 
  dathanhtoan     bit NOT NULL, 
  CuaHangid       bigint NOT NULL, 
  KhachHangUserid bigint NOT NULL, 
  NhanVienUserid  bigint NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE MotLuotNhap (
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
  id    bigint IDENTITY NOT NULL, 
  ten   varchar(255) NOT NULL, 
  gia   bigint NOT NULL, 
  donvi nvarchar(255) NOT NULL, 
  mota  varchar(255) NULL, 
  PRIMARY KEY (id));
ALTER TABLE NhanVien ADD CONSTRAINT FKNhanVien91737 FOREIGN KEY (Userid) REFERENCES [User] (id);
ALTER TABLE KhachHang ADD CONSTRAINT FKKhachHang878764 FOREIGN KEY (Userid) REFERENCES [User] (id);
ALTER TABLE RolesOfUser ADD CONSTRAINT FKRolesOfUse55470 FOREIGN KEY (Userid) REFERENCES [User] (id);
ALTER TABLE RolesOfUser ADD CONSTRAINT FKRolesOfUse576874 FOREIGN KEY (Roleid) REFERENCES Role (id);
ALTER TABLE MotLuotNhap ADD CONSTRAINT FKMotLuotNha568529 FOREIGN KEY (NhaCungCapid) REFERENCES NhaCungCap (id);
ALTER TABLE MotLuotNhap ADD CONSTRAINT FKMotLuotNha382053 FOREIGN KEY (CuaHangid) REFERENCES CuaHang (id);
ALTER TABLE MotLuotNhap ADD CONSTRAINT FKMotLuotNha949606 FOREIGN KEY (NhanVienUserid) REFERENCES NhanVien (Userid);
ALTER TABLE HoaDonNhap ADD CONSTRAINT FKHoaDonNhap351577 FOREIGN KEY (MotLuotNhapid) REFERENCES MotLuotNhap (id);
ALTER TABLE DsspNhap ADD CONSTRAINT FKDsspNhap875965 FOREIGN KEY (MotLuotNhapid) REFERENCES MotLuotNhap (id);
ALTER TABLE DsspNhap ADD CONSTRAINT FKDsspNhap729905 FOREIGN KEY (VatPhamid) REFERENCES VatPham (id);
ALTER TABLE MotLuotBan ADD CONSTRAINT FKMotLuotBan178926 FOREIGN KEY (CuaHangid) REFERENCES CuaHang (id);
ALTER TABLE MotLuotBan ADD CONSTRAINT FKMotLuotBan284212 FOREIGN KEY (KhachHangUserid) REFERENCES KhachHang (Userid);
ALTER TABLE MotLuotBan ADD CONSTRAINT FKMotLuotBan510586 FOREIGN KEY (NhanVienUserid) REFERENCES NhanVien (Userid);
ALTER TABLE DsspBan ADD CONSTRAINT FKDsspBan510298 FOREIGN KEY (VatPhamid) REFERENCES VatPham (id);
ALTER TABLE DsspBan ADD CONSTRAINT FKDsspBan947010 FOREIGN KEY (MotLuotBanid) REFERENCES MotLuotBan (id);
ALTER TABLE HoaDonBan ADD CONSTRAINT FKHoaDonBan217708 FOREIGN KEY (MotLuotBanid) REFERENCES MotLuotBan (id);

