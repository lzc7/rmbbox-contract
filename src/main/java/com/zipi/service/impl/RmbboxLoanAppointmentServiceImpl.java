package com.zipi.service.impl;

import com.zipi.entity.CoreUser;
import com.zipi.entity.RmbboxLoanAppointment;
import com.zipi.mapper.RmbboxLoanAppointmentMapper;
import com.zipi.service.RmbboxLoanAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RmbboxLoanAppointmentServiceImpl implements RmbboxLoanAppointmentService {

    @Autowired
    private RmbboxLoanAppointmentMapper rmbboxLoanAppointmentMapper;

    public RmbboxLoanAppointment selectByPrimaryKey(String key) {
        return rmbboxLoanAppointmentMapper.selectByPrimaryKey(key);
    }

    @Override
    public RmbboxLoanAppointment getAppointmentInfoByIdAndUserId(String appointmentId, String userId) {
        return rmbboxLoanAppointmentMapper.getAppointmentInfoByIdAndUserId(appointmentId,userId);
    }

    @Override
    public CoreUser queryEnterpriseInfoByAppointmentId(String appointmentId) {
        return rmbboxLoanAppointmentMapper.queryEnterpriseInfoByAppointmentId(appointmentId);
    }
}