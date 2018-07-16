package com.zipi.core.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public abstract class BasePdfUtil {
	
	protected static final Logger logger = LoggerFactory.getLogger(BasePdfUtil.class);
	
	public static final SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
	
	public static final String dateformatParten= "yyyy-MM-dd";
	
	public static final DecimalFormat formateCapital = new DecimalFormat("#,##0.00");
	
	private static final String CN_FONT_FAMILY = "STSongStd-Light";
	
	private static final String ENCODING = "UniGB-UCS2-H";
	
	public static final String image_path = "/var/logo/bbtLogo.png";
	
	
	public static Document createReportDocument(){
		Document document = new Document(PageSize.A4);
		document.setMargins(40.0F, 40.0F, 80.0F, 50.0F);
		return document;
	}

	public static Document createDocument(Float marginLeft,Float marginRight,Float marginTop,Float marginBottom){
		Document document = new Document(PageSize.A4);
		document.setMargins(marginLeft, marginRight, marginTop, marginBottom);
		return document;
	}

	/**
	 * 关闭Document 对象
	 * @param document 
	 */
	protected static void closeDocument(Document document){
		if(document!=null && document.isOpen()){
			document.close();
		}
	}
	
	public PdfWriter getInstanceForPdfWriter(Document document,ByteArrayOutputStream out) throws Exception{
		PdfWriter writer = PdfWriter.getInstance(document, out);
		writer.setPageEvent(new PdfPageEventHelper(){
			@Override
			public void onEndPage(PdfWriter writer, Document document) {
				PdfContentByte cb = writer.getDirectContent();
		        cb.saveState();
		        cb.beginText();
		        BaseFont bf = null;
		        try {
//		            bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.EMBEDDED);
		            bf = createBaseFont();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        cb.setFontAndSize(bf, 10);
		        Image image;
				try {
					image = Image.getInstance(image_path);
					image.setAbsolutePosition(10, 5);
					image.setAlignment(Image.LEFT | Image.TEXTWRAP);
					image.scaleToFit(138, 48);//大小
					PdfTemplate tphead = cb.createTemplate(150, 50);
		            tphead.addImage(image);
		            cb.addTemplate(tphead, 30, 780);
		            
//		            if(lenderNo!=null && !"".equals(lenderNo)){
//		            	Paragraph paragraph = new Paragraph("协议编号", getParagraphFont());
//			            ColumnText.showTextAligned(cb, Element.ALIGN_RIGHT, paragraph, document.right(), document.top(-40), 0);
//			            Paragraph paragraph2 = new Paragraph(lenderNo, getParagraphFont());
//			            ColumnText.showTextAligned(cb, Element.ALIGN_RIGHT, paragraph2, document.right(), document.top(-20), 0);
//		            }
//		          //Header
//		            float x = document.top(-20);
//		             
//		            //左
//		            cb.showTextAligned(PdfContentByte.ALIGN_LEFT,
//		                               "H-Left",
//		                               document.left(), x, 0);
//		            //中
//		            cb.showTextAligned(PdfContentByte.ALIGN_CENTER,
//		                                writer.getPageNumber()+ " page",
//		                               (document.right() + document.left())/2,
//		                               x, 0);
//		            //右
//		            cb.showTextAligned(PdfContentByte.ALIGN_RIGHT,
//		                               "H-Right",
//		                               document.right(), x, 0);
//		     
//		            //Footer
//		            float y = document.bottom(-20);
//		     
//		            //左
//		            cb.showTextAligned(PdfContentByte.ALIGN_LEFT,
//		                               "F-Left",
//		                               document.left(), y, 0);
//		            //中
//		            cb.showTextAligned(PdfContentByte.ALIGN_CENTER,
//		                                writer.getPageNumber()+" page",
//		                               (document.right() + document.left())/2,
//		                               y, 0);
//		            //右
//		            cb.showTextAligned(PdfContentByte.ALIGN_RIGHT,
//		                               "F-Right",
//		                               document.right(), y, 0);
				} catch (BadElementException e) {
					e.printStackTrace();
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (DocumentException e) {
					e.printStackTrace();
				}
		        cb.endText();
		        cb.restoreState();
			}
		});
		return writer;
	}
	/**
	 * 初始化PDF  不带LOGO
	 * @param document
	 * @param out
	 * @return
	 * @throws Exception 
	 * 2016年11月30日  下午2:48:32
	 * zhaoqiang
	 */
	public static PdfWriter getInstanceForPdfWriterWithoutLogo(Document document,ByteArrayOutputStream out) throws Exception{
		PdfWriter writer = PdfWriter.getInstance(document, out);
		writer.setPageEvent(new PdfPageEventHelper(){
			@Override
			public void onEndPage(PdfWriter writer, Document document) {
				PdfContentByte cb = writer.getDirectContent();
				cb.saveState();
				cb.beginText();
				BaseFont bf = null;
				try {
					bf = createBaseFont();
					//Footer
					cb.setFontAndSize(bf, 10);
					
		            float y = document.bottom(-20);
		     
		            //右
		            cb.showTextAligned(PdfContentByte.ALIGN_RIGHT,
		            		writer.getPageNumber()+"",
		                               document.right(), y, 0);
				} catch (Exception e) {
					e.printStackTrace();
				}
				cb.setFontAndSize(bf, 10);
				PdfTemplate tphead = cb.createTemplate(150, 50);
				cb.addTemplate(tphead, 30, 780);
				cb.endText();
				cb.restoreState();
			}
		});
		return writer;
	}
	/**
	 * 创建基本字体
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static BaseFont createBaseFont() throws DocumentException, IOException{
//		return BaseFont.createFont("/SONGGBK.TTF",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		return BaseFont.createFont(CN_FONT_FAMILY,ENCODING, BaseFont.NOT_EMBEDDED);
//		return BaseFont.createFont(CN_FONT_FAMILY,ENCODING, BaseFont.NOT_EMBEDDED);
	}
	/**
	 * 构造 title标题字体
	 * @return
	 */
	public static Font getTitleFont(){
		try {
			return new Font(createBaseFont(), 16.0F, 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 构造 段落字体
	 * @return
	 */
	public static Font getParagraphFont(){
		try {
			return new Font(createBaseFont(), 12.0F, 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 构造 加粗字体
	 * @return
	 */
	public static Font getBlockFont(){
		try {
			return new Font(createBaseFont(), 10.0F, Font.BOLD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 构造 表格字体
	 * @return
	 */
	public static Font getTableFont(){
		try {
			return new Font(createBaseFont(), 9.0F, 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 构造 自定义大小的字体
	 * @return
	 */
	public static Font getCustomFont(float size, int style){
		try {
			return new Font(createBaseFont(), size, style);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Paragraph createTitleParagraph(String stringTitle, Font titleFont,int alignment){
		Paragraph titleP = new Paragraph(stringTitle, titleFont);
		titleP.setSpacingBefore(10.0F);
		titleP.setAlignment(alignment);//对齐方式
		return titleP;
	}

	/**
	 * 自定义段落
	 * @param stringTitle
	 * @param titleFont
	 * @param alignment
	 * @param spacingBefore
	 * @param spacingAfter
	 * @param firstLineIndent
	 * @return
	 */
	public static Paragraph createCustomerParagraph(String stringTitle, Font titleFont,int alignment,
			float spacingBefore,float spacingAfter,float firstLineIndent){
		Paragraph titleP = new Paragraph(stringTitle, titleFont);
		titleP.setSpacingBefore(spacingBefore);
		titleP.setFirstLineIndent(firstLineIndent);
		titleP.setSpacingAfter(spacingAfter);
		titleP.setAlignment(alignment);//对齐方式
		return titleP;
	}
	
	public static Paragraph createHelloParagraph(String userName, Font helloFont,int alignment){
		Paragraph helloP = new Paragraph("尊敬的", helloFont);
		Chunk chunkName = new Chunk(" " + String.valueOf(userName) + " ", getBlockFont());
		chunkName.setUnderline(0.2F, -1.0F);
		helloP.add(chunkName.getContent());
		chunkName = new Chunk("先生/女士：", helloFont);
		helloP.add(chunkName);
		helloP.setAlignment(0);
		helloP.setSpacingBefore(10.0F);
		return helloP;
		
	}
	/**
	 * 
	 * @param underLineBeforeStr  下划线之前文本
	 * @param underLineAfterStr	 下划线之后文本
	 * @param underLine	 下划线文本
	 * @param helloFont
	 * @param alignment
	 * @return
	 */
	public static Paragraph createUnderLineParagraph(String underLineBeforeStr,String underLine,String underLineAfterStr,
			Font helloFont,int alignment){
		Paragraph paragraph = new Paragraph(underLineBeforeStr, helloFont);
		paragraph.setFirstLineIndent(20f);
		Chunk underLineC = new Chunk(" " + String.valueOf(underLine) + " ", getBlockFont());
		underLineC.setUnderline(0.5F, -2.0F);
		paragraph.add(underLineC);
		paragraph.add(underLineAfterStr);
		paragraph.setAlignment(0);
		paragraph.setSpacingBefore(10.0F);
		return paragraph;
		
	}
	/**
	 * 
	 * @param underLineBeforeStr  下划线之前文本
	 * @param underLineAfterStr	 下划线之后文本
	 * @param underLine	 下划线文本
	 * @param helloFont
	 * @param alignment
	 * @return
	 */
	public static Paragraph createStrampParagraph(String underLineBeforeStr,String underLine,String underLineAfterStr,
			Font helloFont,int alignment){
		Paragraph paragraph = new Paragraph(underLineBeforeStr, helloFont);
		paragraph.setFirstLineIndent(20f);
		Chunk underLineC = new Chunk(" " + String.valueOf(underLine) + " ", getParagraphFont());
		underLineC.setUnderline(0.5F, -2.0F);
		paragraph.add(underLineC);
		paragraph.add(underLineAfterStr);
		paragraph.setAlignment(0);
		paragraph.setSpacingBefore(10.0F);
		return paragraph;
		
	}

	/**
	 *
	 * @param underLineBeforeStr
	 * @param underLine
	 * @param underLineAfterStr
	 * @param helloFont
	 * @param alignment
	 * @return
	 */
	public static Paragraph createStrampParagraphWithoutSpacingBefore(String underLineBeforeStr,String underLine,String underLineAfterStr,
												  Font helloFont,int alignment){
		Paragraph paragraph = new Paragraph(underLineBeforeStr, helloFont);
		paragraph.setFirstLineIndent(20f);
		Chunk underLineC = new Chunk(" " + String.valueOf(underLine) + " ", getParagraphFont());
		underLineC.setUnderline(0.5F, -2.0F);
		paragraph.add(underLineC);
		paragraph.add(underLineAfterStr);
		paragraph.setAlignment(0);
		return paragraph;

	}public PdfPTable createCustomerPdfTable(int numColumns){
		PdfPTable customerPdfTable = new PdfPTable(numColumns);
		customerPdfTable.setWidthPercentage(100);
		customerPdfTable.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);// 设置垂直居中 
		customerPdfTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);//设置内容水平居中显示
		return customerPdfTable;
	}
	
	/**
	 * 批量创建表头
	 * @param table 添加表头的Table
	 * @param tableHeaders 表头信息数组
	 * @param headerFont 表头字体
	 */
	protected static void createTableHeader(PdfPTable table,String[] tableHeaders,Font headerFont){
		for(String tableHeader:tableHeaders){
			table.addCell(createTableHeader(tableHeader,headerFont));
		}
	}
	/**
	 * 创建表头
	 * @param tableHeaderStr 表头信息
	 * @param headerFont 表头字体
	 * @return PdfPCell
	 */
	protected static PdfPCell createTableHeader(String tableHeaderStr,Font headerFont){
		PdfPCell tableHeaderCell = createCell(tableHeaderStr,headerFont);
		return tableHeaderCell;
	}
	/**
	 * 创建指定字体的表格Cell,
	 * @param content 表格内容
	 * @param font 字体
	 * @return PdfPCell
	 */
	public static PdfPCell createCell(String content,Font font){
		PdfPCell cell = null;
		if(content == null){
			cell = new PdfPCell();
		}else{
			cell = new PdfPCell(new Paragraph(content,font));
		}
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(25f);
		return cell;
	}
	/**
	 * 创建指定字体的表格Cell,
	 * @param content 表格内容
	 * @param font 字体
	 * @return PdfPCell
	 */
	public static PdfPCell createCellByCustomerBorderColor(String content, Font font, BaseColor color){
		PdfPCell cell = null;
		if(content == null){
			cell = new PdfPCell();
		}else{
			cell = new PdfPCell(new Paragraph(content,font));
		}
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(25f);
		cell.setBorderColor(color);
		return cell;
	}
	/**
	 * 创建指定字体的表格Cell,
	 * @param content 表格内容
	 * @param font 字体
	 * @return PdfPCell
	 */
	public static PdfPCell createCustomerCell(String content,Font font,int horizontalAlignment,int verticalAlignment){
		PdfPCell cell = null;
		if(content == null){
			cell = new PdfPCell();
		}else{
			cell = new PdfPCell(new Paragraph(content,font));
		}
		cell.setHorizontalAlignment(horizontalAlignment);
		cell.setVerticalAlignment(verticalAlignment);
		return cell;
	}
	
	public static Paragraph createUnderLineForDate(String str, LocalDate date1, LocalDate date2, String str2, Font helloFont, int alignment){
		
		Paragraph paragraph = new Paragraph(str, helloFont);
		if(date1!=null){
			Chunk underLineC = new Chunk(" " + date1.getYear() + " ", getBlockFont());
			underLineC.setUnderline(0.5F, -2.0F);
			paragraph.add(underLineC);
			underLineC = new Chunk(" 年 ", getParagraphFont());
			paragraph.add(underLineC);
			underLineC = new Chunk(" " + date1.getMonthOfYear() + " ", getBlockFont());
			underLineC.setUnderline(0.5F, -2.0F);
			paragraph.add(underLineC);
			underLineC = new Chunk(" 月 ", getParagraphFont());
			paragraph.add(underLineC);
			underLineC = new Chunk(" " + date1.getDayOfMonth() + " ", getBlockFont());
			underLineC.setUnderline(0.5F, -2.0F);
			paragraph.add(underLineC);
			underLineC = new Chunk(" 日 ", getParagraphFont());
			paragraph.add(underLineC);
		}
		if(date2!=null){
			Chunk underLineC = new Chunk(" 至   ", getParagraphFont());
			paragraph.add(underLineC);
			underLineC = new Chunk("" + date2.getYear() + " ", getBlockFont());
			underLineC.setUnderline(0.5F, -2.0F);
			paragraph.add(underLineC);
			underLineC = new Chunk(" 年 ", getParagraphFont());
			paragraph.add(underLineC);
			underLineC = new Chunk(" " + date2.getMonthOfYear() + " ", getBlockFont());
			underLineC.setUnderline(0.5F, -2.0F);
			paragraph.add(underLineC);
			underLineC = new Chunk(" 月 ", getParagraphFont());
			paragraph.add(underLineC);
			underLineC = new Chunk(" " + date2.getDayOfMonth() + " ", getBlockFont());
			underLineC.setUnderline(0.5F, -2.0F);
			paragraph.add(underLineC);
			underLineC = new Chunk(" 日 。", getParagraphFont());
			paragraph.add(underLineC);
		}
		Chunk underLineC = new Chunk(str2, getParagraphFont());
		paragraph.add(underLineC);
		paragraph.setFirstLineIndent(20f);
		paragraph.setAlignment(0);
		paragraph.setSpacingBefore(10.0F);
		return paragraph;
	}


	public static Font getDarkGrayFont(float size){
		try {
			return new Font(BaseFont.createFont("/config/SONGGBK.TTF",BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED),size, 0,BaseColor.DARK_GRAY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
