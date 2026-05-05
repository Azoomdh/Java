DELETE FROM BaiTapNhom WHERE mabaitap = ?;
DELETE FROM BangPhanCong WHERE BaiTapNhom_mabaitap = ? AND SinhVien_masv = ?;
DELETE FROM SinhVien WHERE masv = ?;

