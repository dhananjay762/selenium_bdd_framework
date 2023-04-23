package com.automation.support;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class FilloExcelReader {
	
	private Fillo fillo;
	private Connection conn;
	private String excelPath;
	
	public FilloExcelReader(String excelPath) throws FilloException {
		this.excelPath = excelPath;
	}
	
	
	public Map<String, String> getDataMapFromCol(String sheetName, String columnName) throws FilloException{
		fillo = new Fillo();
		conn = fillo.getConnection(excelPath);
		Map<String, String> testDataMap = new HashMap<String, String>();
		String query = "select Fields, "+columnName+" from "+sheetName;
		Recordset recordSet = conn.executeQuery(query);
		while(recordSet.next()) {
			testDataMap.put(recordSet.getField("Fields"), recordSet.getField(columnName));
		}
		conn.close();
		return testDataMap;
	}
	
	public String getDataFromCol(String sheetName, String columnName, String fieldName) throws FilloException {
		fillo = new Fillo();
		conn = fillo.getConnection(excelPath);
		String query = "select Fields, "+columnName+" from "+sheetName;
		Recordset recordSet = conn.executeQuery(query);
		String fieldVal = null;
		while(recordSet.next()) {
			if(recordSet.getField("Fields").equalsIgnoreCase(fieldName)) {
				fieldVal = recordSet.getField(columnName);
				break;
			}
		}
		conn.close();
		return fieldVal;
	}
	
	public List<Map<String, String>> runCustomQueryAndGetAllData(String query) throws FilloException {
		fillo = new Fillo();
		conn = fillo.getConnection(excelPath);
		Recordset recordSet = conn.executeQuery(query);
		List<String> fieldNames = recordSet.getFieldNames();
		Map<String, String> temp = new HashMap<String, String>();
		List<Map<String, String>> testDataMapList = new ArrayList<Map<String,String>>();
		while(recordSet.next()) {
			for(String fieldName:fieldNames) {
				temp.put(fieldName, recordSet.getField(fieldName));
			}
			testDataMapList.add(temp);
		}
		conn.close();
		return testDataMapList;
	}
	
	public void updateFieldValueForCol(String sheetName, String columnName, String fieldName, String fieldValue) throws FilloException {
		fillo = new Fillo();
		conn = fillo.getConnection(excelPath);
		String query = "update "+sheetName+" set "+columnName+" = '"+fieldValue+"' where Fields='"+fieldName+"'";
		conn.executeUpdate(query);
		conn.close();
	}
	
	public void runCustomQueryAndUpdateData(String query) throws FilloException {
		fillo = new Fillo();
		conn = fillo.getConnection(excelPath);
		conn.executeUpdate(query);
		conn.close();
	}

}
