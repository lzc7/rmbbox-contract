package com.zipi.modules.contract.mapper;

import com.zipi.modules.contract.entity.CoreUser;
import com.zipi.modules.contract.entity.RmbboxLoanAppointment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RmbboxLoanAppointmentMapper {



    RmbboxLoanAppointment selectByPrimaryKey(String key);

    RmbboxLoanAppointment getAppointmentInfoByIdAndUserId(@Param("appointmentId")String appointmentId,
                                                          @Param("userId")String userId);

    CoreUser queryEnterpriseInfoByAppointmentId(@Param("appointmentId")String appointmentId);

}