/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thuchanh.BaiTapNhom;

import com.mycompany.thuchanh.Interface.RepoInterface;
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
public class BaiTapNhomRepo implements RepoInterface<BaiTapNhom, Integer>{

    private static final String url= "jdbc:sqlserver://localhost:1433;databaseName=ThucHanhJava1;encrypt=false;trustServerCertificate=true";
    private static final String username = "a0000";
    private static final String password = "a0000";
    
    public BaiTapNhomRepo() {
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public BaiTapNhom getFromResultSet(ResultSet rs) {
        try {
            BaiTapNhom t = new BaiTapNhom(
                    rs.getInt(BaiTapNhom.ListTenThuocTinh.mabaitap),
                    rs.getString(BaiTapNhom.ListTenThuocTinh.tenbaitap),
                    rs.getInt(BaiTapNhom.ListTenThuocTinh.kieubaitap),
                    rs.getInt(BaiTapNhom.ListTenThuocTinh.tongthoigian)
            );
            
            return t;
            
        }
        catch (SQLException ex) {
            Logger.getLogger(BaiTapNhomRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public BaiTapNhom findById(Integer id) {
        String sql = "SELECT mabaitap, tenbaitap, kieubaitap, tongthoigian FROM BaiTapNhom WHERE mabaitap = ?;";
        
        try 
        /*resource*/ (
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            
            if(rs.next()==true ){
                BaiTapNhom t= this.getFromResultSet(rs);
                return t;
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
                
        return null;
    }

    @Override
    public List<BaiTapNhom> getList() {
        String sql = "SELECT DISTINCT * FROM BaiTapNhom WHERE 1=1 ORDER BY mabaitap DESC; ";
        
        List<BaiTapNhom> dsT = new ArrayList<>();
        
        try
        /*resource*/(
                Connection con = this.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()== true){
                BaiTapNhom t = this.getFromResultSet(rs);
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
    public BaiTapNhom create(BaiTapNhom t) {
        
        String sql = "INSERT INTO BaiTapNhom(tenbaitap, kieubaitap, tongthoigian) VALUES (?, ?, ?);";
        
        t.setMabaitap(null);

        try 
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        )
        {
            ps.setString(1, t.getTenbaitap());
            ps.setInt(2, t.getKieubaitap());
            ps.setInt(3, t.getTongthoigian());
            
            ps.executeUpdate();
            
            try
            /*resource*/(
                ResultSet rs = ps.getGeneratedKeys();
            )
            {
                if(rs.next()==true){
                    Integer id1 = rs.getInt(1);
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
    public BaiTapNhom update(Integer id, BaiTapNhom t) {
        t.setMabaitap(id);
        String sql = "        UPDATE BaiTapNhom SET tenbaitap = ?, kieubaitap = ?, tongthoigian = ? WHERE mabaitap = ?;";
        
        try
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setString(1, t.getTenbaitap());
            ps.setInt(2, t.getKieubaitap());
            ps.setInt(3, t.getTongthoigian());
            ps.setInt(4, t.getMabaitap());
            
            ps.executeUpdate();
            
            return this.findById(t.getMabaitap());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        String sql= "DELETE FROM BaiTapNhom WHERE mabaitap = ?;";
        
        try
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
            return true;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    
}
