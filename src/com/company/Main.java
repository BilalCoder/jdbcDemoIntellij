package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/invoicing?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            //here invoicing is database name, root is username and password=""
            //from use-------UTC, it is for the time matching for the database server
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from invoices");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+"  "+rs.getDate(6)+"  "+rs.getDate(7)+"  "+rs.getDate(8));
            con.close();
        }
        catch(Exception e){ System.out.println(e);}
    }
}
