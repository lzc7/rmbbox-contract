package com.zipi.service;


import com.zipi.entity.CoreUser;
import com.zipi.entity.RmbboxLoanAppointment;


public interface RmbboxLoanAppointmentService {


    RmbboxLoanAppointment selectByPrimaryKey(String key);

    RmbboxLoanAppointment getAppointmentInfoByIdAndUserId(String appointmentId, String userId);

    CoreUser queryEnterpriseInfoByAppointmentId(String investId);
}