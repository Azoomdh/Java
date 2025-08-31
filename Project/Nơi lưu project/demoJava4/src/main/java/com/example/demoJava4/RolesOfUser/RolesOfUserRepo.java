package com.example.demoJava4.RolesOfUser;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.example.demoJava4.Interface.RepoInterface;

@Repository
public class RolesOfUserRepo 
    implements RepoInterface<RolesOfUser, RolesOfUserKey>
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RolesOfUserRowMapper rouRowMapper = new RolesOfUserRowMapper();

    @Override
    public RolesOfUser findById(RolesOfUserKey tKey) {
        String sql = 
            " SELECT "
            + " * "
            + " FROM RolesOfUser "
            + " WHERE "
                + " Userid= ? "
                + " AND Roleid= ? ";

        PreparedStatementCreator psCreator = con->{
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setLong(1, tKey.getUserid());
            ps.setLong(2, tKey.getRoleid());

            return ps;
        };

        return this.jdbcTemplate.query(psCreator, this.rouRowMapper).stream().findFirst().orElse(null);

    }

    @Override
    public List<RolesOfUser> getList(Integer sttPage, Integer sizePage) {
        String sql = 
            "SELECT "
            + " DISTINCT "
            + " * "
            + " FROM RolesOfUser "
            + " WHERE 1=1 "
            + " ORDER BY Userid DESC, Roleid DESC "
            + " OFFSET ? ROW "
            + " FETCH NEXT ? ROW ONLY ";

        PreparedStatementCreator psc = con-> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ( (sizePage-1)*sttPage) );
            ps.setInt(2, sizePage);

            return ps;
        };

        return this.jdbcTemplate.query(psc, this.rouRowMapper);
    }

    @Override
    public RolesOfUser create(RolesOfUser t) {
        // PK của rou là FK nên không được set null

        String sql =
            " INSERT INTO RolesOfUser "
            + " (Userid, Roleid) "
            + " VALUES (?, ?) ";

        // PK của rou là FK nên không cần get Key trả về

        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setLong(1, t.getRouKey().getUserid());
            ps.setLong(2, t.getRouKey().getRoleid());

            return ps;
        };

        jdbcTemplate.update(psc);

        return this.findById(t.getRouKey());
    }

    @Override
    public RolesOfUser update(RolesOfUserKey tKey, RolesOfUser t) {
        t.setRouKey(tKey);

        String sql = 
            " UPDATE RolesOfUser "
                + " SET " 
                    + " "
                + " WHERE "
                    + " Userid = ? " 
                    + " AND Roleid = ? ";

        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setLong(1, t.getRouKey().getUserid());
            ps.setLong(2, t.getRouKey().getRoleid());

            return ps;
        };

        jdbcTemplate.update(psc);

        return this.findById(t.getRouKey());
    }

    @Override
    public Boolean delete(RolesOfUserKey tKey) {
        String sql=
            " DELETE FROM RolesOfUser "
            + " WHERE "
                + " Userid = ? "
                + " AND Roleid = ? ";

        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setLong(1, tKey.getUserid());
            ps.setLong(2, tKey.getRoleid());

            return ps;
        };

        jdbcTemplate.update(psc);

        return true;
    }

    //🟩🟩🟩🟩🟩🟩hết phần implements🟩🟩🟩🟩🟩🟩//

    public List<RolesOfUser> findByIdUser(Long idUser){
        String sql = "SELECT * FROM RolesOfUser WHERE Userid = ?";

        PreparedStatementCreator psc = con->{
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setLong(1, idUser);

            return ps;
        };

        return jdbcTemplate.query(psc, this.rouRowMapper);
    }
}
