package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.RETC_074Bean;
import com.training.dao.RETC_074DAO;
import com.training.readexcel.ApachePOIExcelRead;

public class RETC_075DataProviders {
	
	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<RETC_074Bean> list = new RETC_074DAO().getrolechange(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(RETC_074Bean temp : list){
			Object[]  obj = new Object[4]; 
			obj[0] = temp.getusername(); 
			obj[1] = temp.getpassword(); 
			obj[2] = temp.getnew_role();
			obj[3] = temp.getmessage();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs1")
    public Object[][] getExcelData1(){
        String fileName ="C:\\Users\\MeenaAmbati\\Desktop\\newpost.xlsx";
        return new ApachePOIExcelRead().getExcelContent(fileName);
    }
	}
	
	


