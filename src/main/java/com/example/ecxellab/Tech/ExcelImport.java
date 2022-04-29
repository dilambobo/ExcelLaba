package com.example.ecxellab.Tech;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

import java.io.File;

public class ExcelImport {
    private double[][] doubles;
    private String[] strings;

    public void arr(File file) throws IOException, InvalidFormatException {

        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet;

        int variant = 4;

        if (workbook.getNumberOfSheets() > 7) {
            sheet = workbook.getSheetAt(variant - 1);
        } else {
            sheet = workbook.getSheetAt(0);
        }

        int numLastCol = sheet.getRow(0).getLastCellNum();

        strings = new String[numLastCol];
        doubles = new double[numLastCol][sheet.getLastRowNum()];

        for (int i = 0; i < numLastCol; i++) {
            for (int j = 0; j <= sheet.getLastRowNum(); j++) {
                if (sheet.getRow(j).getCell(i) != null) {

                    if (sheet.getRow(j).getCell(i).getCellType() == CellType.STRING) {
                        strings[i] = sheet.getRow(j).getCell(i).getStringCellValue();
                    } else if (sheet.getRow(j).getCell(i).getCellType() == CellType.NUMERIC) {
                        doubles[i][j - 1] = sheet.getRow(j).getCell(i).getNumericCellValue();
                    }
                }
            }
        }
        workbook.close();
    }

    public double[][] getDoubles() {
        return doubles;
    }

    public String[] getStrings() {
        return strings;
    }
}
