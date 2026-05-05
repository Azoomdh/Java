package com.example.demoJava6.MotLuotBan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demoJava6.Interface.RepoInterface;

@Repository
public class MotLuotBanRepo 
    implements RepoInterface<MotLuotBan, Long>
{
    private static final String url= "jdbc:sqlserver://localhost:1433;databaseName=DemoJava6;encrypt=false;trustServerCertificate=true";
    private static final String username = "a0000";
    private static final String password = "a0000";

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public MotLuotBan getFromResultSet(ResultSet rs) {
        try {
            MotLuotBan t = new MotLuotBan(
                rs.getLong("id"),
                rs.getTimestamp("thoigian"),
                rs.getBoolean("dathanhtoan"),
                rs.getLong("UseridKhachhang")
            ); 
            return t;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public MotLuotBan findById(Long id) {
        String sql = "SELECT id, thoigian, dathanhtoan, UseridKhachhang FROM MotLuotBan WHERE id = ? ;";
        try 
        /*resource*/ (
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();
            
            if(rs.next()==true ){
                MotLuotBan t= this.getFromResultSet(rs);
                return t;
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
                
        return null;
    }

    @Override
    public List<MotLuotBan> getList(Integer sttPage, Integer sizePage) {
        String sql = "SELECT DISTINCT * FROM MotLuotBan WHERE 1=1 ORDER BY id DESC OFFSET ? ROW FETCH NEXT ? ROW ONLY ";
        
        List<MotLuotBan> dsT = new ArrayList<>();
        
        try
        /*resource*/(
                Connection con = this.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setInt(1, ((sttPage-1)*sizePage));
            ps.setInt(2, sizePage);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()== true){
                MotLuotBan t = this.getFromResultSet(rs);
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
    public MotLuotBan create(MotLuotBan t) {
        String sql = "INSERT INTO MotLuotBan(thoigian, dathanhtoan, UseridKhachhang) VALUES (?, ?, ?);";

        t.setId(null);

        try 
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        )
        {
            ps.setTimestamp(1, t.getThoigian());
            ps.setBoolean(2, t.getDathanhtoan());
            ps.setLong(3, t.getUseridKhachhang());
            
            ps.executeUpdate();
            
            try
            /*resource*/(
                ResultSet rs = ps.getGeneratedKeys();
            )
            {
                if(rs.next()==true){
                    Long id1 = (Long)rs.getLong(1);
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
    public MotLuotBan update(Long id, MotLuotBan t) {
        t.setId(id);
        
        String sql = "UPDATE MotLuotBan SET thoigian = ?, dathanhtoan = ?, UseridKhachhang = ? WHERE id = ?;";
        
        try
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setTimestamp(1, t.getThoigian());
            ps.setBoolean(2, t.getDathanhtoan());
            ps.setLong(3, t.getUseridKhachhang());
            
            ps.setLong(5, t.getId());
            
            ps.executeUpdate();
            
            return this.findById(t.getId());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        String sql= "DELETE FROM MotLuotBan WHERE id = ?;";
        
        try
        /*resource*/(
            Connection con = this.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setLong(1, id);
            
            ps.executeUpdate();
            
            return true;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
