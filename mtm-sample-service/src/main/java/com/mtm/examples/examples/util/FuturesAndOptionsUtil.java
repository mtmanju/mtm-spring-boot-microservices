package com.mtm.examples.examples.util;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;

public class FuturesAndOptionsUtil {

    private FuturesAndOptionsUtil() {
    }

    public static String getOrderType(Row row, String type) {
        int convertColStringToIndex = CellReference.convertColStringToIndex(type);
        return row.getCell(convertColStringToIndex).getStringCellValue();
    }

    public static Double getOrderQuantity(Row row, String quantity) {
        int convertColStringToIndex = CellReference.convertColStringToIndex(quantity);
        return row.getCell(convertColStringToIndex).getNumericCellValue();
    }

    public static String getAveragePrice(Row row, String avgPrice) {
        int convertColStringToIndex = CellReference.convertColStringToIndex(avgPrice);
        return row.getCell(convertColStringToIndex).getStringCellValue();
    }
}
