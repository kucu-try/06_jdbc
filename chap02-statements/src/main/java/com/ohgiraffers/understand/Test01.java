package com.ohgiraffers.understand;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.*;
public class Test01 {
    public static void main(String[] args) {
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery("SELECT \n" +
                    "\t*\n" +
                    "  FROM EMPLOYEE\n" +
                    "  WHERE salary = (SELECT MAX(salary) FROM employee)");
            while (rset.next()){
                System.out.println(rset.getString("EMP_NAME") + " " + rset.getString("SALARY"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(con);
            close(rset);
            close(stmt);
        }
    }
}
