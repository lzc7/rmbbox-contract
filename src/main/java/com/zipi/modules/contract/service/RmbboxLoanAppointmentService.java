package com.zipi.modules.contract.service;


import com.zipi.modules.contract.entity.CoreUser;
import com.zipi.modules.contract.entity.RmbboxLoanAppointment;


public interface RmbboxLoanAppointmentService {


    RmbboxLoanAppointment selectByPrimaryKey(String key);

    RmbboxLoanAppointment getAppointmentInfoByIdAndUserId(String appointmentId, String userId);

    CoreUser queryEnterpriseInfoByAppointmentId(String investId);
}