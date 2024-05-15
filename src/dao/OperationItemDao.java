package dao;

import model.OperationItem;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class OperationItemDao {
    public void insertOperationItem(Connection con, OperationItem opitem) throws SQLException {
        QueryRunner r=new QueryRunner();
        String sql="insert into operationitem(op_datetime,operation,ip_address,user_id) values(?,?,?,?)";
        r.update(con,sql,opitem.getOp_datetime(),opitem.getOperation(),opitem.getIp_address(),opitem.getUser_id());
    }
}
