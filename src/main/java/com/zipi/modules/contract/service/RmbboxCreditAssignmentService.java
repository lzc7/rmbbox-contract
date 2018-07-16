package com.zipi.modules.contract.service;

import com.zipi.modules.contract.entity.RmbboxCreditAssignment;

import java.util.List;
import java.util.Map;

public interface RmbboxCreditAssignmentService {

    RmbboxCreditAssignment selectByPrimaryKey(Integer key);

    RmbboxCreditAssignment queryByIdWithUserInfo(Integer integer);

    List<Map> queryAssignInfo(Long id);

}