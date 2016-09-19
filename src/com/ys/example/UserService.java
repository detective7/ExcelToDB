package com.ys.example;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;

public class UserService {
	
	/**
	 * 查询user表中所有的数据
	 */
	public static List<UserBean> getAllUser(){
		List<UserBean> list = new ArrayList<UserBean>();
		try{
			DBHelper db = new DBHelper();
			String sql = "select * from user;";
			ResultSet rs = db.Search(sql, null);
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String nickname = rs.getString("nickname");
				int sex = rs.getInt("sex");
				String password = rs.getString("password");
				list.add(new UserBean(id,name,nickname,sex,password));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 查询指定目录中电子表格中所有的数据
	 */
	 public static List<UserBean> getAllByExcel(String file){
	        List<UserBean> list=new ArrayList<UserBean>();
	        try {
	            Workbook rwb=Workbook.getWorkbook(new File(file));
	            Sheet rs=rwb.getSheet("Sheet1");//或者rwb.getSheet(0)
	            int clos=rs.getColumns();//得到所有的列
	            int rows=rs.getRows();//得到所有的行
	            
	            System.out.println(clos+" rows:"+rows);
	            for (int i = 1; i < rows; i++) {
	                for (int j = 0; j < clos; j++) {
	                    //第一个是列数，第二个是行数
	                    String id=rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
	                    String name=rs.getCell(j++, i).getContents();
	                    String nickname=rs.getCell(j++, i).getContents();
	                    String sex=rs.getCell(j++, i).getContents();
	                    String password=rs.getCell(j++, i).getContents();
	                    
	                    System.out.println("id:"+id+" name:"+name+" nickname:"+nickname+" sex:"+sex+" password:"+password);
	                    list.add(new UserBean(Integer.parseInt(id), name, nickname,Integer.valueOf(sex), password));
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } 
	        return list;
	    }
	 
	 /**
	     * 通过Id判断是否存在
	     * @param id
	     * @return
	     */
	    public static boolean isExist(String name){
	        try {
	            DBHelper db=new DBHelper();
	            ResultSet rs=db.Search("select * from user where name=?", new String[]{name+""});
	            if (rs.next()) {
	                return true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	    
	    public static void main(String[] args) {
	        /*List<StuEntity> all=getAllByDb();
	        for (StuEntity stuEntity : all) {
	            System.out.println(stuEntity.toString());
	        }*/
	        
	        System.out.println(isExist("赵1"));
	        
	    }
	 
	 
	 
}
