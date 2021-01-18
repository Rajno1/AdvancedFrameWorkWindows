package com.issi.utils;

import com.issi.constants.FrameWorkConstants;
import com.issi.exceptions.FrameWorkExceptions;
import com.issi.exceptions.InvalidExcelPathException;
import net.bytebuddy.implementation.bytecode.Throw;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public final class ExcelUtils {
    private ExcelUtils() {
    }
    public static List<Map<String,String>> getTestDetails(String sheetName) {
        List<Map<String, String>> list = null;

        /**
         *  Here we are using try-with-resources to close the input file
         *  by passing input file as an argument to the try block, it helps to avoid creating finally block
         *  for closing the file.
         */
        try(FileInputStream fs = new FileInputStream(FrameWorkConstants.getExcelPath())) {
            XSSFWorkbook workbook = new XSSFWorkbook(fs);
            XSSFSheet sheet = workbook.getSheet(sheetName);


            int lastRowNumber = sheet.getLastRowNum();
            int lastColumnum = sheet.getRow(0).getLastCellNum();

            Map<String, String> map = null;
            list = new ArrayList<Map<String, String>>();

            for (int i = 1; i <=lastRowNumber; i++) {
                map = new HashMap<String, String>();
                for (int j = 0; j < lastColumnum; j++) {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key, value);
                }
                list.add(map);
            }
        } catch (FileNotFoundException e) {
            throw new InvalidExcelPathException("Excel file you are trying to read is not found, Please check your file path");
            /**
             * with the help of above line we are throwing runtime exception
             * so it will terminate the program immediately after exception
             */
        } catch (IOException e) {
            throw new FrameWorkExceptions("Some IO Exception happen while reading data from excel");
        }
        return list;
    }
}
