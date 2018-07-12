package com.zipi.base;

import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * Created by hbutt on 2014/11/17.
 */
public class BaseController {
    @Autowired
    protected HttpServletRequest request;



    public static final String DEFAULT_ENCODE = "UTF-8";

    protected ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    protected Validator validator = factory.getValidator();

    protected Logger logger = null;
    protected String className = "";

    protected final String lendingReturnPage = "/regOrLogin/lending-transition";
    protected final String lendingRegisterPage = "/account/setting/newNameCertify";
    protected final String lendingRegisterMPage = "/mstation/account/realName";


    /**
     * 后台管理返回数据
     *
     * @param response
     */
    public void pagerToXMLString(HttpServletResponse response, Object obj) {
        try {
            response.setCharacterEncoding(DEFAULT_ENCODE);
            response.setContentType(MediaType.APPLICATION_XML_VALUE);
            PrintWriter out = response.getWriter();
            if (obj.getClass().equals(String.class)) {
                out.print(obj);
            } else {
                out.print(convertToXml(obj, DEFAULT_ENCODE));
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String convertToXml(Object obj, String encoding) {
        String result = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);

            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            result = writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 为response添加头信息和内容类型信息，便于下载csv文件
     *
     * @param response
     * @param fileName
     * @return
     * @throws UnsupportedEncodingException
     */
    public HttpServletResponse modifyResponseForCSV(HttpServletResponse response, String fileName) throws UnsupportedEncodingException {
        response.setCharacterEncoding("GBK");
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment;filename=\""
        		+ new String(fileName.getBytes("GBK"), "ISO8859-1")+"\"");//兼容firefox文件名包括空格字符  modify by liangyu 2016-9-27

        return response;
    }

    /**
     * 判断是否是移动平台浏览器
     *
     * @return
     */
    protected boolean isMobile() {
        String userAgent = request.getHeader("user-agent");
        String regEx = "Android|webOS|iOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(userAgent);
        boolean result = m.find();
        logger.debug("Mobile 浏览器检测 : {} ", result);
        return result;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
        binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
            }

            @Override
            public String getAsText() {
                Object value = getValue();
                return value != null ? value.toString() : "";
            }
        });
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }









    private String getStringBylength(String str, int maxLength) {
        if (!StringUtils.isEmpty(str) && str.length() > maxLength) {
            return str.substring(0, maxLength);
        }
        return str;
    }


}
