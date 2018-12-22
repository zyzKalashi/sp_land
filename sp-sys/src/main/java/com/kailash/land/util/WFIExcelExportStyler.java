package com.kailash.land.util;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

import cn.afterturn.easypoi.excel.export.styler.ExcelExportStylerDefaultImpl;
import cn.afterturn.easypoi.excel.export.styler.IExcelExportStyler;

public class WFIExcelExportStyler extends ExcelExportStylerDefaultImpl implements IExcelExportStyler {

	public WFIExcelExportStyler(Workbook workbook) {
		super(workbook);
	}

	@SuppressWarnings("deprecation")
	@Override
	public CellStyle getTitleStyle(short color) {
		CellStyle titleStyle = workbook.createCellStyle();
		titleStyle.setAlignment(CellStyle.ALIGN_LEFT);
		titleStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		titleStyle.setWrapText(true);
		return titleStyle;
	}

	@SuppressWarnings("deprecation")
	@Override
	public CellStyle stringSeptailStyle(Workbook workbook, boolean isWarp) {
		CellStyle style = workbook.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_LEFT);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style.setDataFormat(STRING_FORMAT);

		if (isWarp) {
			style.setWrapText(true);
		}

		return style;
	}

	@SuppressWarnings("deprecation")
	@Override
	public CellStyle getHeaderStyle(short color) {
		CellStyle titleStyle = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("宋体");
		font.setFontHeightInPoints((short) 20);
		titleStyle.setFont(font);
		titleStyle.setAlignment(CellStyle.ALIGN_LEFT);
		titleStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		return titleStyle;
	}

	@SuppressWarnings("deprecation")
	@Override
	public CellStyle stringNoneStyle(Workbook workbook, boolean isWarp) {
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("宋体");
		// font.setFontHeightInPoints((short) 15);
		style.setFont(font);
		style.setAlignment(CellStyle.ALIGN_LEFT);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style.setDataFormat(STRING_FORMAT);

		if (isWarp) {
			style.setWrapText(true);
		}
		return style;
	}

}
