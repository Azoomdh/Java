/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitap1.Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author azoom
 */
public class SinhVienRepo 
        implements RepoInterface<SinhVien, String>
{
    private static final String url= "jdbc:sqlserver://localhost:1433;databaseName=BaiTapJava1;encrypt=false;trustServerCertificate=true";
    private static final String username = "a0000";
    private static final String password = "a0000";

    public SinhVienRepo() {
    }
    

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public SinhVien getFromResultSet(ResultSet rs) {
        try {
            SinhVien t = new SinhVien(
                    rs.getString(SinhVien.ListTenThuocTinh.masv),
                    rs.getString(SinhVien.ListTenThuocTinh.hoten),
                    rs.getString(SinhVien.ListTenThuocTinh.tenlop),
                    rs.getDouble(SinhVien.ListTenThuocTinh.gpa)
            );
            
            return t;
        }
        catch (SQLException ex) {
            Logger.getLogger(SinhVienRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public SinhVien findById(String id) {
        String sql = "SELECT * FROM SinhVien WHERE id = ? ;";
        
        try 
        /*resource*/ (
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();
            
            if(rs.next()==true ){
                SinhVien t= this.getFromResultSet(rs);
                return t;
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
                
        return null;
    }

    @Override
    public List<SinhVien> getList() {
        String sql = "SELECT DISTINCT * FROM VatPham WHERE 1=1 ORDER BY id DESC; ";
        
        List<SinhVien> dsT = new ArrayList<>();
        
        try
        /*resource*/(
                Connection con = this.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()== true){
                SinhVien t = this.getFromResultSet(rs);
                dsT.add(t);
            }
            
            return dsT;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SinhVien create(SinhVien t) {
        String sql = "INSERT INTO [dbo].[SinhVien]([masv],[hoten],[tenlop],[gpa]) VALUES (?, ?, ?, ?)";
        
        t.setMasv(null);

        try 
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        )
        {
            ps.setString(1, t.getMasv());
            ps.setString(2, t.getHoten());
            ps.setString(3, t.getTenlop());
            ps.setDouble(4, t.getGpa());
            
            ps.executeUpdate();
            
            try
            /*resource*/(
                ResultSet rs = ps.getGeneratedKeys();
            )
            {
                if(rs.next()==true){
                    String id1 = (String)rs.getString(1);
                    return this.findById(id1);
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SinhVien update(String id, SinhVien t) {
        t.setMasv(id);
        
        String sql = "UPDATE [dbo].[SinhVien] SET [hoten] = ?,[tenlop] = ? ,[gpa] = ? WHERE [masv] = ?;";
        
        try
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setString(1, t.getHoten());
            ps.setString(2, t.getTenlop());
            ps.setDouble(3, t.getGpa());
            ps.setString(4, t.getMasv());
            
            ps.executeUpdate();
            
            return this.findById(t.getMasv());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean delete(String id) {
        String sql= "DELETE FROM SinhVien WHERE masv = ?;";
        
        try
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setString(1, id);
            
            ps.executeUpdate();
            
            return true;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
}
