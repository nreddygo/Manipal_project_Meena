package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.readexcel.ApachePOIExcelRead;

public class RealEstateDataProviders {
	
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\MeenaAmbati\\Desktop\\sendmail.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}

}
