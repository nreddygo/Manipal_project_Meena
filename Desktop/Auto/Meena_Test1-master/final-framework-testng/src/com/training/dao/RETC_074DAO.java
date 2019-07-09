package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.RETC_074Bean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

public class RETC_074DAO {
	
Properties properties; 
	
	public RETC_074DAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<RETC_074Bean> getrolechange(){
		String sql = properties.getProperty("get.roleChange"); 
		
		GetConnection gc  = new GetConnection(); 
		List<RETC_074Bean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<RETC_074Bean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				RETC_074Bean temp = new RETC_074Bean(); 
				temp.setusername(gc.rs1.getString(1));
				temp.setpassword(gc.rs1.getString(2));
				temp.setnewRole(gc.rs1.getString(3));
				temp.setmessage(gc.rs1.getString(4));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new RETC_074DAO().getrolechange().forEach(System.out :: println);
	}
	

}
