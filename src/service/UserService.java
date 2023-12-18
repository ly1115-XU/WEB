package service;

import dao.UserDao;
import model.Page;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    private UserDao uDao=new UserDao();

    //注册功能
    public boolean register(User user){
//        System.out.println("11111");
        //用户是否注册，
        try {
            if(uDao.isUsernameExist(user.getUsername())){
                return false;
            }
            // 邮箱是否存在
            if(uDao.isEmailExist(user.getEmail())){
                return false;
            }
            uDao.addUser((user));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;

    }
    //登录业务
    public User login(String ue,String password){
        User user=null;
        try {
            //  1.username password登录方式
            user=uDao.selectUsernamePassword(ue,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // 2. email password 登录方式
        if(user!=null)
        {
            return user;
        }
        try {
            user=uDao.selectEmailPassword(ue,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if(user!=null){
            return user;
        }

        return null;
    }
    public User selectByID(int id){
        User u=null;
        try {
            u=uDao.selectById(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return u;
    }
    public void updateUserAddress(User user){
        try {
            uDao.updateUserAddress(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void updatePwd(User user){
        try {
            uDao.updatePwd(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
//    public Page getUserPage(int pageNumber){
//        Page p=new Page();
//        p.setPageNumber(pageNumber);
//        int pageSize=7;
//        int totalCount=0;
//        try {
//            totalCount = uDao.selectUserCount();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        p.SetPageSizeAndTotalCount(pageSize,totalCount);
//        List list=null;
//        try {
//            list=uDao.selectUserList(pageNumber,pageSize);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        p.setList(list);
//        return p;
//    }
    public List<User> getUser() throws SQLException {
        List<User>list=null;
        list=uDao.selectUserList();
        return list;
    }
    public boolean delete(int id){
        try {
            uDao.delete(id);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
}
