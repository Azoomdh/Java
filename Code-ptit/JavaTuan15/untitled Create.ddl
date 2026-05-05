CREATE TABLE BaiTapNhom (
  mabaitap     int IDENTITY NOT NULL, 
  tenbaitap    varchar(255) NOT NULL, 
  kieubaitap   int NOT NULL, 
  tongthoigian int NOT NULL, 
  PRIMARY KEY (mabaitap));
CREATE TABLE BangPhanCong (
  BaiTapNhom_mabaitap int NOT NULL, 
  SinhVien_masv       int NOT NULL, 
  songaythamgia       int NULL, 
  vitricongviec       varchar(255) NOT NULL, 
  PRIMARY KEY (BaiTapNhom_mabaitap, 
  SinhVien_masv));
CREATE TABLE SinhVien (
  masv      int IDENTITY NOT NULL, 
  hoten     varchar(255) NOT NULL, 
  dienthoai varchar(255) NOT NULL, 
  lop       varchar(255) NOT NULL, 
  PRIMARY KEY (masv));
ALTER TABLE BangPhanCong ADD CONSTRAINT FKBangPhanCo267271 FOREIGN KEY (BaiTapNhom_mabaitap) REFERENCES BaiTapNhom (mabaitap);
ALTER TABLE BangPhanCong ADD CONSTRAINT FKBangPhanCo473933 FOREIGN KEY (SinhVien_masv) REFERENCES SinhVien (masv);

