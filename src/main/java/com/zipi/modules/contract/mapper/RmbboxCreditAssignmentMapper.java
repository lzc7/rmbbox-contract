package com.zipi.modules.contract.mapper;

import com.zipi.modules.contract.entity.RmbboxCreditAssignment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
public interface RmbboxCreditAssignmentMapper {

    RmbboxCreditAssignment selectByPrimaryKey(Integer key);

    RmbboxCreditAssignment queryByIdWithUserInfo(@Param("id")Integer id);

    List<Map> queryAssignInfo(@Param("assignmentId")Long assignmentId);

}