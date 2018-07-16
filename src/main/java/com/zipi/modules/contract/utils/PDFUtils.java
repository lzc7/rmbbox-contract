package com.zipi.modules.contract.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import com.zipi.core.util.BasePdfUtil;
import com.zipi.core.util.DateUtils;
import com.zipi.core.util.PrivacyDimmer;
import com.zipi.modules.contract.entity.*;
import com.zipi.modules.contract.enums.SealFileType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;


public class PDFUtils {

    public static Logger logger = LoggerFactory.getLogger(PDFUtils.class);

    public static BaseFont sFont;

    public static java.awt.Font sPrivateSealFont;

    static {
        try {
            BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            sFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            sPrivateSealFont = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT,
                    new File("SIMSUN.TTC")).deriveFont(
                    Font.BOLD, 12);
        } catch (FontFormatException | DocumentException | IOException e) {
        }
    }

    public static class Table {

        /**
         * 表标题
         */
        public String title;

        /**
         * 表数据（第一行为表头）
         */
        public List<List<String>> values = new CopyOnWriteArrayList<>();

        public float[] weights;

        public Table(String title, List<List<String>> values) {
            this.title = title;
            this.values = values;
        }

        public void setWeights(float[] weights) {
            this.weights = new float[weights.length];

            float totalNumber = 0;
            for (float weight : weights) {
                totalNumber += weight;
            }

            for (int i = 0, n = weights.length; i < n; i++) {
                this.weights[i] = weights[i] / totalNumber;
            }
        }
    }

    public static class Fields {

        public String serial = "";         // 借款序列号

        public String companyName = ""; // 公司名称

        public String companyAddress = ""; // 公司地址

        public String legalRepresentative = ""; // 法人代表

        public String debtorBankAccountName = ""; // 借款人户名

        public String debtorBankAccountBranch = ""; // 借款人开户行

        public String debtorBankAccountNumber = ""; // 借款人账号

        public String agreementNo = "";

        public String CJRName = ""; // 出借人姓名

        public String CJRloginName = ""; // 出借人登录名

        public String CJRIdNumber = "000000000000000000"; // 身份证号

        public String JKRName = "";

        public String JKRloginName = ""; // 登录名

        public String JKRIdNumber = ""; // 借款人身份证号

        public String JKRIdNumberPrivacy = ""; // 借款人身份证号

        public String amount = ""; // 金额

        public String amountUpper = ""; // 金额大写

        public String loanPurpose = ""; // 借款用途

        public String loanRate = ""; // 借款利率

        public String loanDate = ""; // 放款日

        public String endDate = ""; // 到期日

        public String cxrDate = ""; // 起息日

        public String repayMethod = ""; // 还款方式

        public String repayMethodOrdinal = "";// 还款方式序号

        public String repayDate = ""; // 还款日

        public String repayAmount = ""; // 还款金额

        public String repayAmountMonthly = ""; // 乙方每月应付金额

        public String advancedRepayFee = ""; // 提前还款违约金

        public String fxbzjRate = ""; // 风险保证金计提

        public String yzhglfRate = ""; // 乙方账户管理费

        public String loanManageFee = ""; // 乙方借款管理费

        public String loanManageFeeAmount = ""; // 乙方借款管理费金额

        public String zxRate = ""; // 乙方咨询服务费

        public String zxRateAmount = ""; // 乙方咨询服务费金额

        public String riskFee = ""; // 风险备用金

        public String riskFeeAmount = ""; // 风险备用金

        public String totalServiceRate = ""; // 乙方借款服务费（ 乙方服务费 + 风险保证金计提）

        public String jzhglfRate = ""; // 甲方账户管理费

        public String yqRate = ""; // 乙方逾期管理费

        public String yqfxRate = ""; // 乙方逾期罚息

        public String jklxRate = ""; // 乙方借款利息管理费

        public String daysToBreach = ""; // 逾期转违约天数

        public String loanVisitFee = ""; // 贷款实地调查费率，按照贷款金额比率收取，跟借款人收取

        public String withdrawFee = "";// 实地提现费用

        public String loanRiskFee = ""; // 风险管理费

        public String loanRiskFeeAmount = "";

        public String repaymentNo = ""; // 还款期数

        public String zqr = CJRName; // 债权人

        public String zwr = JKRName; // 债务人

        public String fr = ""; // 法人

        public String titleName = ""; // short name

        public String name = ""; // // short name

        public String url = "";
        // 签字日期
        public String signDate = "";

        // 还款详情（针对投资人）
        public List<Repayment> repaymentMonthlyListForInvestor = new CopyOnWriteArrayList<>();

        // 还款详情（针对投资人）
        public List<RmbLoanRepayment> repaymentMonthlyList = new CopyOnWriteArrayList<>();

        // 还款详情（针对借贷人）
        public List<RmbLoanRepayment> repaymentMonthlyListForObligator = new CopyOnWriteArrayList<>();

        // 投资人列表
        public List<Investor> investorList = new CopyOnWriteArrayList<>();

        public Map<String, Object> values = new ConcurrentHashMap<>();

        /**
         * 扩展值
         */
        public Map<String, String> extendValues = new ConcurrentHashMap<>();


    }

    public static class Investor {

        public String loginName;

        public String name;

        public String idNumberPrivacy;

        public String amount;

    }

    public static class RepaymentMonthly {

        public BigDecimal no; // 期数

        public BigDecimal principal; // 本金

        public BigDecimal repayDate; // 还款日期

        public BigDecimal interestAmount; // 付息金额

        public BigDecimal amount; // 还款金额

        public BigDecimal loanManageAmount; // 贷款管理费
    }

    /**
     * convert to Chinese Currency
     *
     * @param o
     * @return
     */
    public static String toChineseCurrency(Object o) {
        if (o instanceof Number) {
            String s = new DecimalFormat("#.00").format(o);
            s = s.replaceAll("\\.", "");
            char[] digit = {'零', '壹', '贰', '叁', '肆', '伍', '陆',
                    '柒', '捌', '玖'};
            String unit = "仟佰拾兆仟佰拾亿仟佰拾万仟佰拾元角分";
            int l = unit.length();
            StringBuffer sb = new StringBuffer(unit);
            for (int i = s.length() - 1; i >= 0; i--) {
                sb = sb.insert(l - s.length() + i,
                        digit[(s.charAt(i) - 0x30)]);
            }
            s = sb.substring(l - s.length(), l + s.length());
            s = s.replaceAll("零[拾佰仟]", "零")
                    .replaceAll("零{2,}", "零")
                    .replaceAll("零([兆万元])", "$1")
                    .replaceAll("零[角分]", "");
            return s;
        } else {
            throw new NumberFormatException();
        }
    }
    
    /**
     * 日期
     *
     * @param date
     * @return
     */
    public static String toPdfDateString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
        String dateString = formatter.format(date);
        return dateString;
    }

    public static String toStyleIdNumber(String idNumber) {
        return new StringBuffer(idNumber).replace(6, 14, "********").toString();
    }


    
	private static byte[] insertWaterMark(ByteArrayInputStream bis,
                                          PdfReader reader, byte[] watermark) throws DocumentException,
			IOException {
		// add watermark
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		reader = new PdfReader(bis);
		PdfStamper stamper = new PdfStamper(reader, bos);
		for (int i = 0, sum = reader.getNumberOfPages(); i < sum; i++) {
			waterMark(reader, stamper, watermark, i + 1);
		}
		stamper.close();

		byte[] ouput = bos.toByteArray();
		bos.close();
		return ouput;
	}
	/**
     * 在pdf文件中添加水印
     *
     * @param reader    原始文件
     * @param stamper   水印输出文件
     * @param watermark 水印名字
     */
    private static void waterMark(PdfReader reader, PdfStamper stamper,
                                  byte[] watermark, int page) throws BadElementException, MalformedURLException, IOException, DocumentException {
        Image image = Image.getInstance(watermark);
        float imageWidth = image.getWidth();
        float imageHeight = image.getHeight();
        PdfContentByte under = stamper.getUnderContent(page);
        Rectangle rectangle = reader.getPageSize(page);
        float h = rectangle.getHeight();
        float w = rectangle.getHeight();

        float dh = (float) ((h - imageHeight * 0.5) / 2);
        image.scalePercent(50);
        image.setAbsolutePosition(0, dh);
        under.addImage(image);
    }
    
    private static void setCIdNumber(AcroFields acro, String CJRIdNumber)
            throws IOException, DocumentException {
        char[] c = CJRIdNumber == null ? "000000000000000000".toCharArray() : CJRIdNumber.toCharArray();
        for (int i = 0; i < CJRIdNumber.length(); i++) {
            acro.setField("C" + i, String.valueOf(c[i]));
        }
    }

    private static void setJIdNumber(AcroFields acro, String jKRIdNumber)
            throws IOException, DocumentException {
        char[] c = jKRIdNumber.toCharArray();
        for (int i = 0; i < jKRIdNumber.length(); i++) {
            acro.setField("J" + i, String.valueOf(c[i]));
        }
    }

	private static byte[] insertTableToPdf(ByteArrayInputStream bis,
                                           PdfReader reader, Fields fields) throws DocumentException,
			IOException {
		// Create output PDF
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		Document document = new Document(PageSize.A4);
		PdfWriter writer = PdfWriter.getInstance(document, bos);
		document.open();
		PdfContentByte cb = writer.getDirectContent();

		// Load existing PDF
		reader = new PdfReader(bis);

		// Copy first page of existing PDF into output PDF
		int n = reader.getNumberOfPages();
		for (int i = 0; i < n; i++) {
			PdfImportedPage page = writer.getImportedPage(reader, i + 1);
			document.newPage();
			cb.addTemplate(page, 0, 0);
		}

		// Add your new data / text here
		document.newPage();

		insertTitleToDocument(document, "还款详情表", 20, Element.ALIGN_CENTER);

		document.add(addRepayTableForInvestor(fields));
		document.close();

		byte[] byteArray = bos.toByteArray();
		bos.close();
		return byteArray;
	}
    private static void insertTitleToDocument(Document document, String title, int textSize, int alignment) throws DocumentException, IOException {
    	String FONT = new PDFUtils().getClass().getResource("/")+ "config/SONGGBK.TTF";
    	BaseFont bfTable = BaseFont.createFont(FONT,
				BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		Font font = new Font(bfTable, 9.0F, 0);

       // Font font = new Font(baseFont);
        float fontSize = font.getSize();
        font.setSize(textSize);
        Paragraph preface = new Paragraph(title, font);
        preface.setAlignment(alignment);
        document.add(preface);

        font.setSize(fontSize);
        preface = new Paragraph("", font);
        document.add(preface);
    }
    /**
     * add 还款详情表(投资人)
     *
     * @param fields
     * @return
     */
    private static Paragraph addRepayTableForInvestor(Fields fields) throws DocumentException {
    	
    	String FONT = new PDFUtils().getClass().getResource("/")+ "config/SONGGBK.TTF";
        // 创建表格对象
        Paragraph ph = new Paragraph();

        PdfPTable t = new PdfPTable(5);

        t.setWidths(new float[]{0.10f, 0.24f, 0.22f, 0.22f, 0.22f});

        t.setSpacingBefore(25);

        t.setSpacingAfter(25);
    	
        FontSelector selector = new FontSelector();
        selector.addFont(FontFactory.getFont(FontFactory.TIMES_ROMAN,
                12));
        selector.addFont(FontFactory.getFont(FONT,
				BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
        PdfPCell c1 = new PdfPCell(selector.process("期数"));

        t.addCell(c1);

        PdfPCell c2 = new PdfPCell(selector.process("还款日期"));

        t.addCell(c2);

        PdfPCell c3 = new PdfPCell(selector.process("还款金额"));

        t.addCell(c3);

        PdfPCell c4 = new PdfPCell(selector.process("本金"));

        t.addCell(c4);

        PdfPCell c5 = new PdfPCell(selector.process("利息"));

        t.addCell(c5);

        int i = 0;
        if (!fields.repaymentMonthlyListForInvestor.isEmpty()) {
            for (Repayment repayment : fields.repaymentMonthlyListForInvestor) {

                t.addCell(selector.process(String.valueOf(++i)));

                t.addCell(selector.process(toPdfDateString(repayment.getDueDate())));

                t.addCell(selector.process("￥ " + repayment.getAmount()));

                t.addCell(selector.process("￥ " + repayment.getAmountPrincipal()));

                t.addCell(selector.process("￥ " + repayment.getAmountInterest()));

            }
        } else if (!fields.repayAmountMonthly.isEmpty()) {
            for (RmbLoanRepayment repayment : fields.repaymentMonthlyList) {

                t.addCell(selector.process(String.valueOf(++i)));

                t.addCell(selector.process(toPdfDateString(repayment.getRepayment().getDueDate())));

                t.addCell(selector.process("￥ " + repayment.getRepayment().getAmount()));

                t.addCell(selector.process("￥ " + repayment.getRepayment().getAmountPrincipal()));

                t.addCell(selector.process("￥ " + repayment.getRepayment().getAmountInterest()));

            }
        }

        ph.add(t);
        return ph;
    }

    /**
     * 居间合同域
     */
    public static class MediatorFields {
        /**
         * 合同编号
         */
        String contractNo = "";
        //结算年月日
        String year = "";
        String month = "";
        String day = "";
        /**
         * 借款方名称
         */
        String loanerName = "";
        String loanerIdNo = "";
        String loanerMobile = "";

        //借款年月日
        String lendDate="";//借款日期
        //借款到期年月日
        String dueDateStr="";//借款到期日
        //借款起息年月日
        String countDate="";//起息日

        //出借方名称
        String lenderName = "";
        String lenderIdNo = "";
        BigDecimal lenderAmount = BigDecimal.ZERO;
        String lenderAmountChar = "";
        Double lenderRate = 0.00;
        String purpose = "";
        BigDecimal lenderInterest = BigDecimal.ZERO;
        String period = "";
        String repayMethod = "";

        /**
         * 对应的借款合同编号
         */
        String loanAgreeNo = "";
        /**
         * 结算日期
         */
        String signDate = "";
        /**
         * 服务费
         */
        BigDecimal fee = BigDecimal.ZERO;
        /**
         * 服务费汉字大写
         */
        String feeChar = "";
        /**
         * 甲方签章处
         */
        String aSealPosition = "";
        /**
         * 乙方签章处（紫貔）
         */
        String bSealPosition = "乙方签章处";

        String loanAmount="";//借款金额
        String loanAmountChar="";//借款金额汉子
        String loanRate="";//借款利率
        String loanInterest="";//借款利息

        //担保方名称
        String guarantorName = "";
        String guarantorIdNo = "";
        String guarantorMobile = "";

        // 还款详情（借款方合同使用）
        public List<RmbLoanRepayment> repaymentList = new CopyOnWriteArrayList<>();
        //出借方列表（借款方合同使用）
        public List<RmbInvest> investList = new CopyOnWriteArrayList<>();

        //债权转让
        String assignorName = "";
        String assignorIdNo = "";
        BigDecimal creditShare = BigDecimal.ZERO;
        String creditShareChar = "";
        BigDecimal manageAmount = BigDecimal.ZERO;//转让管理费
        BigDecimal creditPrice = BigDecimal.ZERO;//最终转让价格
        String creditInvestRate = "";//认购利率
        BigDecimal creditInterest = BigDecimal.ZERO;//转让结息
        List<Map> assignList = new CopyOnWriteArrayList<>();

    }

    public static MediatorFields convertToPdfMediatorField(Map<String,Object> keyValue,SealFileType fileType) {

        MediatorFields fields = new MediatorFields();

        if (SealFileType.CarLoanMediatorContract.equals(fileType)){
            fields.contractNo = keyValue.get("orderId")+"-1";
        }else if (SealFileType.AgreementForGuarantor.equals(fileType)){
            fields.contractNo = keyValue.get("orderId")+"-2";
        }else {
            fields.contractNo = keyValue.get("orderId")+"";
        }
        fields.year = (String) keyValue.get("year");
        fields.month = (String) keyValue.get("month");
        fields.day = (String) keyValue.get("day");
        fields.loanerName = (String) keyValue.get("loanerName");
        fields.loanerIdNo = (String) keyValue.get("loanerIdNumber");
        fields.loanerMobile = (String) keyValue.get("loanerMobile");
        fields.loanAgreeNo = (String) keyValue.get("orderId");
        fields.signDate = (String) keyValue.get("signTime");
        fields.fee = (BigDecimal) keyValue.get("fee");
        fields.feeChar = (String) keyValue.get("feeChar");

        fields.lendDate = (String) keyValue.get("lendDate");
        fields.dueDateStr = (String) keyValue.get("dueDateStr");
        fields.countDate = (String) keyValue.get("countDate");
        fields.lenderName = (String) keyValue.get("lenderName");
        fields.lenderIdNo = (String) keyValue.get("lenderIdNo");
        fields.lenderAmount = (BigDecimal) keyValue.get("lenderAmount");
        fields.lenderAmountChar = (String) keyValue.get("lenderAmountChar");
        fields.lenderRate = (Double) keyValue.get("lenderRate");
        fields.purpose = (String) keyValue.get("purpose");
        fields.lenderInterest = (BigDecimal) keyValue.get("lenderInterest");
        fields.period = (String) keyValue.get("period");
        fields.repayMethod = (String) keyValue.get("repayMethod");
        fields.loanAmount = (String) keyValue.get("loanAmount");
        fields.loanAmountChar = (String) keyValue.get("loanAmountChar");
        fields.loanRate = (String) keyValue.get("loanRate");
        fields.loanInterest = (String) keyValue.get("loanInterest");
        fields.investList = (List<RmbInvest>) keyValue.get("investList");
        fields.repaymentList = (List<RmbLoanRepayment>) keyValue.get("repaymentList");

        fields.guarantorName = (String) keyValue.get("guarantorName");
        fields.guarantorIdNo = (String) keyValue.get("guarantorIdNo");
        fields.guarantorMobile = (String) keyValue.get("guarantorMobile");


        fields.assignorName = (String) keyValue.get("assignorName");
        fields.assignorIdNo = (String) keyValue.get("assignorIdNo");
        fields.creditShare = (BigDecimal) keyValue.get("creditShare");
        fields.creditShareChar = (String) keyValue.get("creditShareChar");
        fields.creditInterest = (BigDecimal) keyValue.get("creditInterest");
        fields.creditPrice = (BigDecimal) keyValue.get("creditPrice");
        fields.creditInvestRate = (String) keyValue.get("creditInvestRate");
        fields.manageAmount = (BigDecimal) keyValue.get("manageAmount");
        fields.assignList = (List<Map>) keyValue.get("assignList");

        if (null != keyValue.get("title")){
            fields.aSealPosition = (String) keyValue.get("title");
        }

        return fields;
    }

    /**
     * 生成pdf文件
     * @param fields
     * @param template
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    public static byte[] templateToMediatorPdf(MediatorFields fields, byte[] template) throws IOException, DocumentException,Exception {

        PdfReader reader = new PdfReader(template);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] pdf = resetMediatorFields(bos, reader, fields);
        ByteArrayInputStream bis = new ByteArrayInputStream(pdf);
        pdf = addTableToPdf(bis, reader, fields);
        return pdf;
    }


    private static byte[] resetMediatorFields(ByteArrayOutputStream bos,
                                              PdfReader reader, MediatorFields fields) throws IOException,
            DocumentException {
        String FONT = new PDFUtils().getClass().getResource("/")+ "config/SONGGBK.TTF";
        PdfStamper ps = new PdfStamper(reader, bos);
        BaseFont bf = BaseFont.createFont(FONT,
                BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

        AcroFields s = ps.getAcroFields();

        s.setFieldProperty("contractNo", "textfont", bf, null);
        s.setField("contractNo", fields.contractNo);

        s.setFieldProperty("year", "textfont", bf, null);
        s.setField("year", fields.year);

        s.setFieldProperty("month", "textfont", bf, null);
        s.setField("month", fields.month);

        s.setFieldProperty("day", "textfont", bf, null);
        s.setField("day", fields.day);

        s.setFieldProperty("loanerName", "textfont", sFont, null);
        s.setField("loanerName", fields.loanerName);

        s.setFieldProperty("loanerIdNo", "textfont", bf, null);
        s.setField("loanerIdNo", fields.loanerIdNo);

        s.setFieldProperty("loanerMobile", "textfont", bf, null);
        s.setField("loanerMobile", fields.loanerMobile);

        s.setFieldProperty("loanAgreeNo", "textfont", bf, null);
        s.setField("loanAgreeNo", fields.loanAgreeNo);

        s.setFieldProperty("signDate", "textfont", bf, null);
        s.setField("signDate", fields.signDate);

        s.setFieldProperty("fee", "textfont", bf, null);
        s.setField("fee", fields.fee+"");

        s.setFieldProperty("feeChar", "textfont", bf, null);
        s.setField("feeChar", fields.feeChar);

        s.setFieldProperty("aSealPosition", "textfont", bf, null);
        s.setField("aSealPosition", fields.aSealPosition);

        s.setFieldProperty("bSealPosition", "textfont", bf, null);
        s.setField("bSealPosition", fields.bSealPosition);
        ///////////////////////////////
        s.setFieldProperty("lendDate", "textfont", bf, null);
        s.setField("lendDate", fields.lendDate);

        s.setFieldProperty("dueDateStr", "textfont", bf, null);
        s.setField("dueDateStr", fields.dueDateStr);

        s.setFieldProperty("countDate", "textfont", bf, null);
        s.setField("countDate", fields.countDate);

        s.setFieldProperty("lenderName", "textfont", sFont, null);
        s.setField("lenderName", fields.lenderName);

        s.setFieldProperty("lenderIdNo", "textfont", bf, null);
        s.setField("lenderIdNo", fields.lenderIdNo);

        s.setFieldProperty("lenderAmount", "textfont", bf, null);
        s.setField("lenderAmount", fields.lenderAmount+"");

        s.setFieldProperty("lenderAmountChar", "textfont", bf, null);
        s.setField("lenderAmountChar", fields.lenderAmountChar);

        s.setFieldProperty("lenderRate", "textfont", bf, null);
        s.setField("lenderRate", fields.lenderRate+"");

        s.setFieldProperty("purpose", "textfont", bf, null);
        s.setField("purpose", fields.purpose);

        s.setFieldProperty("lenderInterest", "textfont", bf, null);
        s.setField("lenderInterest", fields.lenderInterest+"");

        s.setFieldProperty("period", "textfont", bf, null);
        s.setField("period", fields.period);

        s.setFieldProperty("repayMethod", "textfont", bf, null);
        s.setField("repayMethod", fields.repayMethod);
        /////////////////////////////////
        s.setFieldProperty("loanAmount", "textfont", bf, null);
        s.setField("loanAmount", fields.loanAmount);

        s.setFieldProperty("loanAmountChar", "textfont", bf, null);
        s.setField("loanAmountChar", fields.loanAmountChar);

        s.setFieldProperty("loanRate", "textfont", bf, null);
        s.setField("loanRate", fields.loanRate);

        s.setFieldProperty("loanInterest", "textfont", bf, null);
        s.setField("loanInterest", fields.loanInterest);

        ///////////////////////////////////////////////
        s.setFieldProperty("guarantorName", "textfont", sFont, null);
        s.setField("guarantorName", fields.guarantorName);

        s.setFieldProperty("guarantorIdNo", "textfont", bf, null);
        s.setField("guarantorIdNo", fields.guarantorIdNo);

        s.setFieldProperty("guarantorMobile", "textfont", bf, null);
        s.setField("guarantorMobile", fields.guarantorMobile);
        ////////////////////////////
        s.setFieldProperty("assignorName", "textfont", sFont, null);
        s.setField("assignorName", fields.assignorName);

        s.setFieldProperty("assignorIdNo", "textfont", bf, null);
        s.setField("assignorIdNo", fields.assignorIdNo);

        s.setFieldProperty("creditShare", "textfont", bf, null);
        s.setField("creditShare", fields.creditShare+"");

        s.setFieldProperty("creditShareChar", "textfont", bf, null);
        s.setField("creditShareChar", fields.creditShareChar);

        s.setFieldProperty("creditInterest", "textfont", bf, null);
        s.setField("creditInterest", fields.creditInterest+"");

        s.setFieldProperty("creditPrice", "textfont", bf, null);
        s.setField("creditPrice", fields.creditPrice+"");

        s.setFieldProperty("creditInvestRate", "textfont", bf, null);
        s.setField("creditInvestRate", fields.creditInvestRate+"");

        s.setFieldProperty("manageAmount", "textfont", bf, null);
        s.setField("manageAmount", fields.manageAmount+"");

        ps.setFormFlattening(true);
        ps.close();

        byte[] byteArray = bos.toByteArray();
        bos.close();

        return byteArray;
    }

    private static byte[] addTableToPdf(ByteArrayInputStream bis,
                                        PdfReader reader, MediatorFields fields) throws DocumentException,
            IOException,Exception {
        // Create output PDF
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4);
//        PdfWriter writer = PdfWriter.getInstance(document, bos);
        PdfWriter writer = BasePdfUtil.getInstanceForPdfWriterWithoutLogo(document,bos);
        document.open();
        document.addTitle(fields.aSealPosition);
        PdfContentByte cb = writer.getDirectContent();

        // Load existing PDF
        reader = new PdfReader(bis);

        // Copy first page of existing PDF into output PDF
        int n = reader.getNumberOfPages();
        for (int i = 0; i < n; i++) {
            PdfImportedPage page = writer.getImportedPage(reader, i + 1);
            document.newPage();
            cb.addTemplate(page, 0, 0);
        }

        document.newPage();

        addTableForLoanAgreement(fields,document);
        document.close();

        byte[] byteArray = bos.toByteArray();
        bos.close();
        return byteArray;
    }

    private static void addTableForLoanAgreement(MediatorFields fields,Document document) throws DocumentException, IOException {

        String FONT = new PDFUtils().getClass().getResource("/")+ "config/SONGGBK.TTF";
        if (null!=fields.investList && !fields.investList.isEmpty()){
            // 创建表格对象
            Paragraph ph = new Paragraph();
            insertTitleToDocument(document, "附件一：出借方列表", 13, Element.ALIGN_LEFT);
            PdfPTable t = new PdfPTable(4);

            t.setWidths(new float[]{0.16f, 0.30f, 0.22f, 0.22f});

            t.setSpacingBefore(25);

            t.setSpacingAfter(25);

            FontSelector selector = new FontSelector();
            selector.addFont(FontFactory.getFont(FontFactory.TIMES_ROMAN,
                    12));
            selector.addFont(FontFactory.getFont(FONT,
                    BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
            PdfPCell c1 = new PdfPCell(selector.process("姓名"));

            t.addCell(c1);

            PdfPCell c2 = new PdfPCell(selector.process("身份证号"));

            t.addCell(c2);

            PdfPCell c3 = new PdfPCell(selector.process("出借金额"));

            t.addCell(c3);

            PdfPCell c4 = new PdfPCell(selector.process("出借时间"));

            t.addCell(c4);

            int i = 0;

            for (RmbInvest invest : fields.investList) {

                t.addCell(selector.process(PrivacyDimmer.maskName(invest.getUserName())));

                t.addCell(selector.process(PrivacyDimmer.maskIdNumber(invest.getIdNumber())));

                t.addCell(selector.process(invest.getInvestAmount().setScale(2, RoundingMode.DOWN)+"元"));

                t.addCell(selector.process(DateUtils.sdf_YMD_local.format(invest.getSubmitTime())));

            }
            ph.add(t);
            document.add(ph);
            document.newPage();
        }
        if (null != fields.repaymentList && !fields.repaymentList.isEmpty()) {
            Paragraph ph = new Paragraph();
            insertTitleToDocument(document, "附件二：还款详情表", 13, Element.ALIGN_LEFT);
            PdfPTable t = new PdfPTable(5);

            t.setWidths(new float[]{0.10f, 0.24f, 0.22f, 0.22f, 0.22f});

            t.setSpacingBefore(25);

            t.setSpacingAfter(25);

            FontSelector selector = new FontSelector();
            selector.addFont(FontFactory.getFont(FontFactory.TIMES_ROMAN,
                    12));
            selector.addFont(FontFactory.getFont(FONT,
                    BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
            PdfPCell c1 = new PdfPCell(selector.process("期数"));

            t.addCell(c1);

            PdfPCell c2 = new PdfPCell(selector.process("还款日期"));

            t.addCell(c2);

            PdfPCell c3 = new PdfPCell(selector.process("还款金额"));

            t.addCell(c3);

            PdfPCell c4 = new PdfPCell(selector.process("借款金额"));

            t.addCell(c4);

            PdfPCell c5 = new PdfPCell(selector.process("借款费用"));

            t.addCell(c5);

            int i = 0;

            for (RmbLoanRepayment repayment : fields.repaymentList) {

                t.addCell(selector.process(repayment.getCurrentPeriod()+""));

                t.addCell(selector.process(toPdfDateString(repayment.getDueDate())));

                t.addCell(selector.process("￥ " + repayment.getAmountInterest().add(repayment.getAmountPrincipal()).add(repayment.getLoanAmountService())));

                t.addCell(selector.process("￥ " + repayment.getAmountPrincipal()));

                t.addCell(selector.process("￥ " + repayment.getAmountInterest().add(repayment.getLoanAmountService())));

            }
            ph.add(t);
            document.add(ph);
            document.newPage();
        }
        if (null!=fields.assignList && !fields.assignList.isEmpty()){
            // 创建表格对象
            Paragraph ph = new Paragraph();
            insertTitleToDocument(document, "附件一：受让方列表", 13, Element.ALIGN_LEFT);
            PdfPTable t = new PdfPTable(4);

            t.setWidths(new float[]{0.16f, 0.30f, 0.22f, 0.22f});

            t.setSpacingBefore(25);

            t.setSpacingAfter(25);

            FontSelector selector = new FontSelector();
            selector.addFont(FontFactory.getFont(FontFactory.TIMES_ROMAN,
                    12));
            selector.addFont(FontFactory.getFont(FONT,
                    BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
            PdfPCell c1 = new PdfPCell(selector.process("姓名"));

            t.addCell(c1);

            PdfPCell c2 = new PdfPCell(selector.process("身份证号"));

            t.addCell(c2);

            PdfPCell c3 = new PdfPCell(selector.process("出借金额"));

            t.addCell(c3);

            PdfPCell c4 = new PdfPCell(selector.process("出借时间"));

            t.addCell(c4);

            int i = 0;

            for (Map map : fields.assignList) {

                t.addCell(selector.process(PrivacyDimmer.maskName(map.get("user_name")+"")));

                t.addCell(selector.process(PrivacyDimmer.maskIdNumber(map.get("id_number")+"")));

                t.addCell(selector.process(map.get("amount")+"元"));

                t.addCell(selector.process(DateUtils.sdf_YMD_local.format(map.get("create_time"))));

            }
            ph.add(t);
            document.add(ph);
            document.newPage();
        }
    }
}
