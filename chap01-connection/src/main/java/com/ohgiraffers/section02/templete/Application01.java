package com.ohgiraffers.section02.templete;

import java.sql.Connection;
import com.ohgiraffers.section02.templete.JDBCTemplate;
import static com.ohgiraffers.section02.templete.JDBCTemplate.getConnection;
import static com.ohgiraffers.section02.templete.JDBCTemplate.close;
public class Application01 {

    public static void main(String[] args){
        Connection con = getConnection();
        System.out.println(con);
        close(con);
    }
}
