package com.zipi.mapper;

import com.zipi.entity.RmbboxCreditAssignment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RmbboxCreditAssignmentMapper {

    RmbboxCreditAssignment selectByPrimaryKey(Integer key);

    RmbboxCreditAssignment queryByIdWithUserInfo(@Param("id")Integer id);

    List<Map> queryAssignInfo(@Param("assignmentId")Long assignmentId);

}