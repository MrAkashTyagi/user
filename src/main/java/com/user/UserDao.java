package com.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("userDao")
    public class UserDao {
    @Autowired
   private static JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    public int save(UserData p){
        String sql="insert into userData(user_id, user_name,user_mobile) values('"+p.getId()+"','"+p.getName()+"','"+p.getMobile()+"')";
        return template.update(sql);
    }
    public static int update(UserData p){
        String sql="update userData set user_name='"+p.getName()+"',user_mobile='"+p.getMobile()+"' where user_id="+p.getId()+"";
        return template.update(sql);
    }
    public static int delete(int id){
        String sql="delete from userData where user_id="+id+"";
        return template.update(sql);
    }
    public static UserData getUserById(int id){
        String sql="select * from userData where user_id=?";
        return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<UserData>(UserData.class));
    }
    public List<UserData> getUsers(){
        return template.query("select * from userData",new RowMapper<UserData>(){
            public UserData mapRow(ResultSet rs, int row) throws SQLException {
                UserData e=new UserData();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setMobile(rs.getString(3));
                return e;
            }
        });
    }
}