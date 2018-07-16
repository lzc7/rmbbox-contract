package com.zipi.modules.contract.utils;

import com.itextpdf.text.DocumentException;
import com.zipi.core.util.BasePdfUtil;
import com.zipi.core.util.DateUtils;
import com.zipi.modules.contract.entity.RmbContractTemplate;
import com.zipi.modules.contract.entity.RmbboxLoanAppointment;
import com.zipi.modules.contract.enums.SealFileType;
import com.zipi.modules.contract.enums.ContractType;
import com.zipi.modules.contract.service.ContractTemplateService;
import com.zipi.modules.contract.service.RmbboxLoanAppointmentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * author linzhicheng
 * 2018年4月11日13:15:49
 * 自动出借服务协议util
 */
@Component
public class AppointmentAgreementUtil extends BasePdfUtil {
    @Autowired
    private ContractTemplateService contractTemplateService;
    @Autowired
    private RmbboxLoanAppointmentService rmbboxLoanAppointmentService;

    public byte[] createFile(String appointmentId, String userId, SealFileType fileType) throws Exception{
        //数据校验
        if(StringUtils.isBlank(appointmentId) || StringUtils.isBlank(userId)){
            logger.error("自动出借服务协议失败：参数不足");
            throw new RuntimeException("params error");
        }

        //模版类型校验
        if(!SealFileType.AppointmentAgreement.equals(fileType)){
            logger.error("自动出借服务协议失败：暂不支持{}文件的生成",fileType.name());
            throw new RuntimeException("params error");
        }

        PDFUtils.MediatorFields fields = this.appointmentInfo(appointmentId,userId,fileType);
        // 获取template模板
        RmbContractTemplate template = contractTemplateService.getByType(ContractType.TEMPLET4APPOINTMENT.name());
        if (null == template){
            logger.info("模板不存在");
            throw new RuntimeException("cannot find templet");
        }
        // 生成pdf
        return PDFUtils.templateToMediatorPdf(fields, template.getContent());
    }

    /**
     * 出借金额、期限、利率等
     * @throws DocumentException
     */
    private PDFUtils.MediatorFields appointmentInfo(String appointmentId, String userId,SealFileType fileType) throws Exception{
        //出借方名称
        RmbboxLoanAppointment appointment=rmbboxLoanAppointmentService.getAppointmentInfoByIdAndUserId(appointmentId,userId);
        if(null == appointment) throw new RuntimeException("no appointment record");
        String lenderName = appointment.getUserName();
        String lenderIdNo = appointment.getIdNumber();
        BigDecimal lenderAmount = appointment.getAppointmentAmount();
        String lenderAmountChar = MoneyFormateUtil.number2CNMontrayUnit(lenderAmount);//预约金额【大写】
        String signTime= DateUtils.sdf_YMD_local.format(appointment.getCreateTime());
        String period= appointment.getDaysMin()+"-"+appointment.getDaysMax()+"天";//期限

        Map<String,Object> keyValue = new HashMap<>();
        keyValue.put("signTime",signTime);

        keyValue.put("lenderName",lenderName);
        keyValue.put("lenderIdNo",lenderIdNo);
        keyValue.put("lenderAmount",lenderAmount);
        keyValue.put("lenderAmountChar",lenderAmountChar);
        keyValue.put("period",period);

        return PDFUtils.convertToPdfMediatorField(keyValue,fileType);
    }
}
