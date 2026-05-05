UPDATE BaiTapNhom SET tenbaitap = ?, kieubaitap = ?, tongthoigian = ? WHERE mabaitap = ?;
UPDATE BangPhanCong SET songaythamgia = ?, vitricongviec = ? WHERE BaiTapNhom_mabaitap = ? AND SinhVien_masv = ?;
UPDATE SinhVien SET hoten = ?, dienthoai = ?, lop = ? WHERE masv = ?;

