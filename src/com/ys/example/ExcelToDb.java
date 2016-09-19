package com.ys.example;

import java.util.List;

public class ExcelToDb {
	public static void main(String[] args) {
        //得到表格中所有的数据
        List<UserBean> listExcel=UserService.getAllByExcel("d://test.xls");
        /*//得到数据库表中所有的数据
        List<StuEntity> listDb=StuService.getAllByDb();*/
        
        DBHelper db=new DBHelper();
        
        for (UserBean user : listExcel) {
            String name =user.getName();
            if (!UserService.isExist(name)) {
                //不存在就添加
                String sql="insert into user (name,nickname,sex,password) values(?,?,?,?)";
                String[] str=new String[]{user.getName(),user.getNickName(),user.getSex()+"",user.getPassword()};
                System.out.println(""+db.AddU(sql, str));
            }else {
                //存在就更新
                String sql="update user set nickname=?,sex=?,password=? where name=?;";
                String[] str=new String[]{user.getNickName(),user.getSex()+"",user.getPassword(),user.getName()};
                System.out.println(""+db.AddU(sql, str));
            }
        }
    }
}
