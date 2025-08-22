package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders
{
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		//get the location of the file
		String path = ".\\testData\\Opencart_LoginData.xlsx";
		 
		//create an object for excelutility file to get row and columns
		ExcelUtility xlutil = new ExcelUtility(path);
		
		int rows= xlutil.getRowCount("sheet1");
		int cells=xlutil.getCellCount("sheet1", 1);
		
		//now create 2d variable to store both rows and cell count
		
		String loginData[][] = new String[rows][cells];
		for(int i=1;i<=rows;i++)
		{
			for(int j=0;j<=cells;j++)
			{
				loginData[i-1] [j] = xlutil.getCellData("sheet1", i, j);
			}
		}
			
		
		return loginData;
		
	}
}
