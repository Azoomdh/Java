CREATE TABLE DsspBan (
  VatPhamid    bigint(20) NOT NULL, 
  MotLuotBanid bigint(20) NOT NULL, 
  soluong      int(10) NOT NULL, 
  gia          bigint(20) NOT NULL, 
  PRIMARY KEY (VatPhamid, 
  MotLuotBanid));
CREATE TABLE DsspNhap (
  MotLuotNhapid bigint(20) NOT NULL, 
  VatPhamid     bigint(20) NOT NULL, 
  soluong       int(10) NOT NULL, 
  gia           bigint(20) NOT NULL, 
  PRIMARY KEY (MotLuotNhapid, 
  VatPhamid));
CREATE TABLE MotLuotBan (
  id             bigint(20) NOT NULL AUTO_INCREMENT, 
  thoigian       timestamp NOT NULL, 
  dathanhtoan    bit(1) NOT NULL, 
  UseridNhanvien bigint(20) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE MotLuotNhap (
  id             bigint(20) NOT NULL AUTO_INCREMENT, 
  thoigian       timestamp NOT NULL, 
  dathanhtoan    bit(1) NOT NULL, 
  UseridNhanvien bigint(20) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE Role (
  id   bigint(20) NOT NULL AUTO_INCREMENT, 
  name varchar(255) NOT NULL, 
  mota varchar(255) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE RolesOfUser (
  Userid bigint(20) NOT NULL, 
  Roleid bigint(20) NOT NULL, 
  PRIMARY KEY (Userid, 
  Roleid));
CREATE TABLE `User` (
  id          bigint(20) NOT NULL AUTO_INCREMENT, 
  username    varchar(255) NOT NULL UNIQUE, 
  password    varchar(255) NOT NULL, 
  email       varchar(255) NOT NULL, 
  sodienthoai varchar(255) NOT NULL, 
  enabled     bit(1) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE VatPham (
  id      bigint(20) NOT NULL AUTO_INCREMENT, 
  ten     varchar(255) NOT NULL, 
  gia     bigint(20) NOT NULL, 
  donvi   varchar(255) NOT NULL, 
  mota    varchar(255), 
  urlanh  varchar(255) NOT NULL, 
  soluong int(11) NOT NULL, 
  PRIMARY KEY (id));
ALTER TABLE DsspNhap ADD CONSTRAINT FKDsspNhap729905 FOREIGN KEY (VatPhamid) REFERENCES VatPham (id);
ALTER TABLE DsspNhap ADD CONSTRAINT FKDsspNhap875965 FOREIGN KEY (MotLuotNhapid) REFERENCES MotLuotNhap (id);
ALTER TABLE MotLuotNhap ADD CONSTRAINT FKMotLuotNha302647 FOREIGN KEY (UseridNhanvien) REFERENCES `User` (id);
ALTER TABLE MotLuotBan ADD CONSTRAINT FKMotLuotBan258332 FOREIGN KEY (UseridNhanvien) REFERENCES `User` (id);
ALTER TABLE RolesOfUser ADD CONSTRAINT FKRolesOfUse576874 FOREIGN KEY (Roleid) REFERENCES Role (id);
ALTER TABLE RolesOfUser ADD CONSTRAINT FKRolesOfUse55470 FOREIGN KEY (Userid) REFERENCES `User` (id);
ALTER TABLE DsspBan ADD CONSTRAINT FKDsspBan947010 FOREIGN KEY (MotLuotBanid) REFERENCES MotLuotBan (id);
ALTER TABLE DsspBan ADD CONSTRAINT FKDsspBan510298 FOREIGN KEY (VatPhamid) REFERENCES VatPham (id);

