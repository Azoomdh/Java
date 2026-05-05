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
CREATE TABLE MotLuotBan (
  id             bigint IDENTITY NOT NULL, 
  thoigian       datetime NOT NULL, 
  dathanhtoan    bit NOT NULL, 
  UseridNhanvien bigint NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE MotLuotNhap (
  id             bigint IDENTITY NOT NULL, 
  thoigian       datetime NOT NULL, 
  dathanhtoan    bit NOT NULL, 
  UseridNhanvien bigint NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE Role (
  id   bigint IDENTITY NOT NULL, 
  name nvarchar(255) NOT NULL, 
  mota nvarchar(255) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE RolesOfUser (
  Userid bigint NOT NULL, 
  Roleid bigint NOT NULL, 
  PRIMARY KEY (Userid, 
  Roleid));
CREATE TABLE [User] (
  id          bigint IDENTITY NOT NULL, 
  username    nvarchar(255) NOT NULL UNIQUE, 
  password    nvarchar(255) NOT NULL, 
  email       nvarchar(255) NOT NULL, 
  sodienthoai nvarchar(255) NOT NULL, 
  enabled     bit NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE VatPham (
  id      bigint IDENTITY NOT NULL, 
  ten     nvarchar(255) NOT NULL, 
  gia     bigint NOT NULL, 
  donvi   nvarchar(255) NOT NULL, 
  mota    nvarchar(255) NULL, 
  urlanh  nvarchar(255) NOT NULL, 
  soluong int NOT NULL, 
  PRIMARY KEY (id));
ALTER TABLE DsspNhap ADD CONSTRAINT FKDsspNhap729905 FOREIGN KEY (VatPhamid) REFERENCES VatPham (id);
ALTER TABLE DsspNhap ADD CONSTRAINT FKDsspNhap875965 FOREIGN KEY (MotLuotNhapid) REFERENCES MotLuotNhap (id);
ALTER TABLE MotLuotNhap ADD CONSTRAINT FKMotLuotNha302647 FOREIGN KEY (UseridNhanvien) REFERENCES [User] (id);
ALTER TABLE MotLuotBan ADD CONSTRAINT FKMotLuotBan258332 FOREIGN KEY (UseridNhanvien) REFERENCES [User] (id);
ALTER TABLE RolesOfUser ADD CONSTRAINT FKRolesOfUse576874 FOREIGN KEY (Roleid) REFERENCES Role (id);
ALTER TABLE RolesOfUser ADD CONSTRAINT FKRolesOfUse55470 FOREIGN KEY (Userid) REFERENCES [User] (id);
ALTER TABLE DsspBan ADD CONSTRAINT FKDsspBan947010 FOREIGN KEY (MotLuotBanid) REFERENCES MotLuotBan (id);
ALTER TABLE DsspBan ADD CONSTRAINT FKDsspBan510298 FOREIGN KEY (VatPhamid) REFERENCES VatPham (id);

