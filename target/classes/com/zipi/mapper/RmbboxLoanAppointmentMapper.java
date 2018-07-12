package com.zipi.mapper;

import com.zipi.entity.CoreUser;
import com.zipi.entity.RmbboxLoanAppointment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RmbboxLoanAppointmentMapper {



    RmbboxLoanAppointment selectByPrimaryKey(String key);

    RmbboxLoanAppointment getAppointmentInfoByIdAndUserId(@Param("appointmentId")String appointmentId,
                                                          @Param("userId")String userId);

    CoreUser queryEnterpriseInfoByAppointmentId(@Param("appointmentId")String appointmentId);

}