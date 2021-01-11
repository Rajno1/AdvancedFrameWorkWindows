package com.issi.utils;

import com.issi.constants.FrameWorkConstants;
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

        FileInputStream fs = null;
        try {
            fs = new FileInputStream(FrameWorkConstants.getExcelPath());
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
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (Objects.nonNull(fs)) {
                    fs.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
