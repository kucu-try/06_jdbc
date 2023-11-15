package com.ohgiraffers.understand;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class Test02 {
    public static void main(String[] args) {
        //선동일 사원의 사번 , 이름, 연락처, 전화번호, 직급이 무엇인지 출력하세요(직업은 job 테이블에 존재)
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
                System.out.println(rset.getString("EMP_NAME") + " " + rset.getString("SALARY")
                        + " " + rset.getString("EMP_NO") + " " + rset.getString("EMAIL")
                        + " " + rset.getString("PHONE"));
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
