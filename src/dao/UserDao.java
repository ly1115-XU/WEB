package dao;

import model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DBUtil;

import java.sql.SQLException;
import java.util.List;

public class UserDao {
    //add方法
    public void addUser(User user) {

        //拿到执行对象
        try {
            QueryRunner r=new QueryRunner(DBUtil.getDataSource());
            //sql
            String sql="insert into user(username,password,email,name,phone, address, isadmin,ismanage,isvalidate,admintype) values(?,?,?,?,?,?,?,?,?,?)";
            //执行
            r.update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getName(),
                    user.getPhone(),user.getAddress(),user.isIsadmin(),user.isIsmanage(),user.isIsvalidate(),user.getAdmintype());
//            System.out.println("操作成功");
        } catch (SQLException e) {
            e.printStackTrace();
//            System.out.println("数据库操作失败: " + e.getMessage());
        }

    }
    //判断username是否存在
    public boolean isUsernameExist(String username){
        User user = null;
        try {
            //拿到执行者对象
            QueryRunner r=new QueryRunner(DBUtil.getDataSource());
            //sql
//        System.out.println("22222");
            String sql="select * from user where username=?";
            //执行
            user = r.query(sql,new BeanHandler<User>(User.class),username);
//            System.out.println("执行成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库操作失败: " + e.getMessage());
        }

        if(user==null){
            return false;
        } else{
            return true;
        }
    }
    //判断email是否存在
    public boolean isEmailExist(String email) throws SQLException {
        //拿到执行者对象
        QueryRunner r=new QueryRunner(DBUtil.getDataSource());
        //sql
        String sql="select * from user where email=?";
        //执行
        User user = r.query(sql,new BeanHandler<User>(User.class),email);

        if(user==null){
            return false;
        } else{
            return true;
        }

    }
    //username password
    public User selectUsernamePassword(String username,String password) throws SQLException {
        //拿到执行者对象
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        //sql
        String sql="select * from user where username = ? and password = ?";
        //执行sql
        return r.query(sql,new BeanHandler<User>(User.class),username,password);

    }

    //email password
    public User selectEmailPassword(String email,String password) throws SQLException {
        //执行者对象
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        //sql
        String sql="select *from user where email = ? and password = ?";
        //执行sql
        return r.query(sql,new BeanHandler<User>(User.class),email,password);
    }
    public User selectById(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql="select * from user where id=?";
        return r.query(sql,new BeanHandler<User>(User.class),id);
    }
    public void updateUserAddress(User user) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql="update user set name=?,phone=?,address=? where id=?";
        r.update(sql,user.getName(),user.getPhone(),user.getAddress(),user.getId());
    }
    public void updatePwd(User user) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql="update user set password=? where id=?";
        r.update(sql,user.getPassword(),user.getId());
    }
    public int selectUserCount() throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql="select count(*) from user";
        return ((int)(long)(r.query(sql,new ScalarHandler())));
    }
//    public List selectUserList(int pageNo, int pageSize) throws SQLException {
//        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
//        String sql="select * from user limit?,?";
//        return r.query(sql,new BeanListHandler<User>(User.class),(pageNo-1)*pageSize,pageSize);
//    }
    public List selectUserList() throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql="select * from user";
        return r.query(sql,new BeanListHandler<User>(User.class));
    }
    public List selectAdminUserList() throws SQLException {
        QueryRunner r=new QueryRunner(DBUtil.getDataSource());
        String sql="select * from user where isadmin=1";
        return r.query(sql,new BeanListHandler<User>(User.class));
    }

    public void delete(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql="delete from user where id=?";
//        System.out.println(id);
//        System.out.println(1);
        r.update(sql,id);

    }

    public void update(User user) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql="update user set username=?,email=?,password=? where id=?";
        r.update(sql,user.getUsername(),user.getEmail(),user.getPassword(),user.getId());
    }

    public List getAllUserid() throws SQLException {
        QueryRunner r=new QueryRunner(DBUtil.getDataSource());
        String sql="select id from user where isadmin=? and ismanage=?";
        return r.query(sql,new ColumnListHandler(),0,0);
    }

    public int getUserIdByName(String username) throws SQLException {
        QueryRunner r=new QueryRunner(DBUtil.getDataSource());
        String sql="select id from user where username=?";
        return (int)r.query(sql,new ScalarHandler(),username);

    }

    public List<User> getNormalUser() throws SQLException {
        QueryRunner r= new QueryRunner(DBUtil.getDataSource());
        String sql="select * from user where isadmin=? and ismanage=?";
        return r.query(sql,new BeanListHandler<User>(User.class),0,0);
    }
}
