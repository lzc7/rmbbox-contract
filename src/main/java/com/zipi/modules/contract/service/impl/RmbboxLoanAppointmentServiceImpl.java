package com.zipi.modules.contract.service.impl;

import com.zipi.modules.contract.entity.CoreUser;
import com.zipi.modules.contract.entity.RmbboxLoanAppointment;
import com.zipi.modules.contract.mapper.RmbboxLoanAppointmentMapper;
import com.zipi.modules.contract.service.RmbboxLoanAppointmentService;
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