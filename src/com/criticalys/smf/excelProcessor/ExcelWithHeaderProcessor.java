
package com.criticalys.smf.excelProcessor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**

 */
 public class ExcelWithHeaderProcessor {
	 public static void main(String[] args) throws FileNotFoundException, IOException 
	 {
		 int i,j=0;
		 try
		 {

			 String connectionURL = "mysql://bc498728f250b9:baa0ab8f@us-cdbr-azure-west-b.cleardb.com/smfMySQLDatabase";
			 FileInputStream file = new FileInputStream(new File("C:\\Users\\Shashank\\Desktop\\Book1.xlsx"));

			 //Create Workbook instance holding reference to .xlsx file
			 XSSFWorkbook workbook = new XSSFWorkbook(file);
			 //System.out.println(workbook.getNumCellStyles());

			 //Get first/desired sheet from the workbook
			 XSSFSheet sheet = workbook.getSheetAt(0);
			 String primaryKeyWord = "CBIT";
			 String excelTitle = "Results";
			 //excelDescription also to be kept
			 int MAX_COLUMN=0;
			 int rowStart = sheet.getFirstRowNum();
			 int rowEnd = sheet.getLastRowNum();

			 for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) 
			 {
				 Row r = sheet.getRow(rowNum);

				 int lastColumn = r.getLastCellNum();
				 if (MAX_COLUMN < lastColumn)
				 {
					 MAX_COLUMN = lastColumn;  
				 }

			 }


			 Iterator<Row> rowIterator = sheet.iterator();                
			 String sql="insert into threefields values (?, ?, ?) ";
			 Row headerRow = rowIterator.next();
			 //System.out.println(headerRow.getCell(1));//skip first row
			 Iterator<Cell> headerCellIterator = headerRow.cellIterator();
			 while (rowIterator.hasNext()) 
			 {

				 Class.forName("com.mysql.jdbc.Driver");
				 Connection connection = DriverManager.getConnection(connectionURL, "root", "root");
				 Statement s= connection.createStatement();

				 PreparedStatement pst = connection.prepareStatement(sql);
				 Row row = rowIterator.next();
				 //System.out.println(row.getCell(0));
				 Iterator<Cell> cellIterator = row.cellIterator();

				 String firstColumn = null;
				 String ColumnHeader = null;


				 for(int k=0;k<MAX_COLUMN;k++)
				 {   
					 Cell cell=row.getCell(k);
					 if (k == 0) 
					 {
						 if(cell == null) 
						 {
							 firstColumn = "noSecondaryKeyWord";
						 } 
						 else 
						 {
							 switch(cell.getCellType())
							 {
							 case Cell.CELL_TYPE_NUMERIC:
								 int ip= (int)cell.getNumericCellValue();
								 firstColumn=" "+ip;
								 break;
							 case Cell.CELL_TYPE_STRING:
								 firstColumn = cell.getStringCellValue();
								 break;
							 }

						 }
					 }
					 else
					 {
						 System.out.println("k value"+k);
						 if(cell== null)
						 {   
							 pst.setString(1,firstColumn);
							 //pst.executeUpdate();
							 System.out.println(firstColumn);
							 ColumnHeader = headerRow.getCell(k).toString();
							 System.out.println("hi am here");
							 pst.setString(2,ColumnHeader);
							 pst.setString(3,null);
							 //write code here to enter three values into database firstcolumn, header of that column, and cell
						 }
						 else 
						 {
							 pst.setString(1,firstColumn);
							 System.out.println(firstColumn);
							 ColumnHeader = headerRow.getCell(k).toString();
							 System.out.println("ColumnHeader"+ColumnHeader);
							 pst.setString(2,ColumnHeader);
							 switch (cell.getCellType()) 
							 {
							 case Cell.CELL_TYPE_NUMERIC:

								 int in= (int)cell.getNumericCellValue();
								 String st=" "+in;
								 pst.setString(3, st);
								 System.out.print(cell.getNumericCellValue() + "\t");
								 //System.out.println("here"+i);
								 break;
							 case Cell.CELL_TYPE_STRING:

								 pst.setString(3, cell.getStringCellValue());
								 System.out.print(cell.getStringCellValue() + "\t");
								 //System.out.println("here"+i);
								 break;
							 }
						 }
						 int nnum=pst.executeUpdate();

					 }

				 }
				 System.out.println(" ");
				 file.close();
				 // int nnum=pst.executeUpdate();
				 pst.close();
			 }


		 }





		 catch (Exception e) 
		 {
			 e.printStackTrace();
		 }
	 }
 }
