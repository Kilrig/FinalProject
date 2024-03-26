package utilities;

import java.io.IOException; 

import org.testng.annotations.DataProvider;



public class DataForTest {
	@DataProvider(name="DataForTest")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\mmtDataFile.xlsx";
		
		ExcelUtils util=new ExcelUtils(path);
		 
		int totalrows=util.getRowCount("Sheet1");	
		int totalcells=util.getCellCount("Sheet1",1);
				
		String data[][]=new String[totalrows][totalcells];
		
		for(int i=1;i<=totalrows;i++)  
		{		
			for(int j=0;j<totalcells;j++)  
			{
				data[i-1][j]= util.getCellData("Sheet1",i, j); 
			}
		}
	return data;
				
	}
}
