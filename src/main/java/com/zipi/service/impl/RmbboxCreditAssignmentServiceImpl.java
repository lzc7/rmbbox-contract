package com.zipi.service.impl;

import com.zipi.entity.RmbboxCreditAssignment;
import com.zipi.mapper.RmbboxCreditAssignmentMapper;
import com.zipi.service.RmbboxCreditAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RmbboxCreditAssignmentServiceImpl implements RmbboxCreditAssignmentService {

    @Autowired
    private RmbboxCreditAssignmentMapper rmbboxCreditAssignmentMapper;

    public RmbboxCreditAssignment selectByPrimaryKey(Integer key) {
        return rmbboxCreditAssignmentMapper.selectByPrimaryKey(key);
    }

    @Override
    public List<Map> queryAssignInfo(Long assignmentId) {
        return rmbboxCreditAssignmentMapper.queryAssignInfo(assignmentId);
    }

    @Override
    public RmbboxCreditAssignment queryByIdWithUserInfo(Integer id) {
        return rmbboxCreditAssignmentMapper.queryByIdWithUserInfo(id);
    }
}