package org.cx.designpattern.template;

import java.sql.ResultSet;
import java.util.List;

/**
 * @author grass
 * @date 2018/5/6
 */
public class UserDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(null);

    public List<?> query(){
        String sql = "select * from tab_user";
        return jdbcTemplate.executeQuery(sql,new RowMapper<User>(){
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws Exception {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("Name"));
                return user;
            }
        },null);
    }

}
