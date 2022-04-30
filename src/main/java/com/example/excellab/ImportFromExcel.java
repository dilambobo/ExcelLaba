package com.example.excellab;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;


public class ImportFromExcel {

    private double[][] doubles;
    private String[] strings;

    public void tablesExtract(File file) throws IOException, InvalidFormatException {

        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet;

        int variant = 4; // мой номер в списке

        sheet = workbook.getSheetAt(variant - 1);


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
