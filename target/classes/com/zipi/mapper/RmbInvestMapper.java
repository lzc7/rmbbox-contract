package com.zipi.mapper;

import com.zipi.entity.CoreUser;
import com.zipi.entity.RmbInvest;
import com.zipi.enums.bbt.InvestStatus;
import com.zipi.enums.loan.LoanStatus;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface RmbInvestMapper {

    int insert(RmbInvest record);

    List<RmbInvest> getRmbInvestsByLoanIdAndInvestStatus(Map<String, Object> paramMap);

    BigDecimal sumInvestedAmountByLoanId(@Param("loanId") String loanId);



    public int countRmbInvestRecordsByLoanIdAndStatus(@Param("loanId") String loanId, @Param("investStatuses") InvestStatus... investStatuses);
    
    public int countRmbInvestUsersByLoanIdAndStatus(@Param("loanId") String loanId, @Param("investStatuses") InvestStatus... investStatuses);
    /**
     * 根据loanId和投资状态获取投资金额总数
     *
     * @param paramMap
     * @return
     */
    BigDecimal sumByLoanAndStatus(Map<String, Object> paramMap);


    public int countBbtInvestRecords(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("loginName") String loginName);

    public int countRmbInvestRecords(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("loginName") String loginName);

    RmbInvest selectByInvestId(String investId);

    public List<RmbInvest> listInvestsByLoanIdAndInvestStatus(@Param("loanId") String loanId, @Param("statuses") InvestStatus... statuses);

    public List<RmbInvest> selectByUserAndStatusAndTime(@Param("start") int start, @Param("end") int end,
                                                        @Param("userId") String userId, @Param("startDate") Date startDate,
                                                        @Param("endDate") Date endDate, @Param("status") String status);

    int countByUserAndStatusAndTime(@Param("userId") String userId, @Param("startDate") Date startDate,
                                    @Param("endDate") Date endDate, @Param("status") LoanStatus status);

    public int update(RmbInvest rmbInvest);
    /**
     *
    * @Title: countByUserAndStatus
   	  @author haojunfu
     */
    public int countByUserAndStatus(@Param("userId") String userId, @Param("statusList") List<InvestStatus> statusList);

    public BigDecimal  sumMarketAllInvestMoneyByStatus(@Param("statusList") List<InvestStatus> statusList);


    int countInvestRecords(@Param("startDate") Date start, @Param("endDate") Date end, @Param("search") String search);

    public RmbInvest getInvestById(String investId);

    List<RmbInvest> listTopInvest(Map<String, Object> paramMap);

	int countByLoanAndStatus(Map<String, Object> paramMap);

    List<RmbInvest> listByUserAndSubmitTime(@Param("userId") String userId, @Param("from") Date from, @Param("to") Date to);


    int countByUserIdAndStatusForApp(@Param("userId") String userId, @Param("statusList") List<InvestStatus> statusList);

    public int countInvestByUserId(@Param("userId") String userId);


    public int countInvestBbtAndUplan(@Param("startDate") Date startDate, @Param("endDate") Date endDate);



    /**
     * 获取用户投资总次数（包括直投和优选）
     * @param userId
     * @return
     */
    public int countInvestAll(@Param("userId") String userId);

    public int countInvestmentWithout(@Param("userId") String userId, @Param("product") String product);

    public int countInvestAllExceptCurrentDeposit(@Param("userId") String userId);



	BigDecimal investMoeyByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("userId") String userId);

    BigDecimal sumInvestByUserAndStatus(@Param("userId") String userId, @Param("statusList") List<InvestStatus> statusList, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    public int countRaiseList(@Param("userId") String userId, @Param("status") String status);


    BigDecimal getInvestAmountById(@Param("userId") String userId);

    BigDecimal getTotalDueIn(@Param("userId") String userId);

    /**
     * 统计投资金额
     * @param userId
     * @return
     */
    List<RmbInvest> statisticInvestAmount(@Param("userId") String userId);

	List<RmbInvest> getInvestDetailListByUserId(@Param("userId") String userId);

	int updateInvestStatusWhenLastPeriods(@Param("investId") String investId);
    /**
     * 根据LoanId查询投资过该标的的用户id
     * @param loanId
     * @return
     */
    String queryOneInvestorIdByLoanId(@Param("loanId") String loanId);

    List<Map> waitRepayCouponInterestList(@Param("loanId") String loanId, @Param("currentPeriod") int currentPeriod);

    /**
     * 查询加息券收益
     * @param userId
     * @return
     */
    BigDecimal queryInterestAmount(@Param("userId") String userId);

    /**
     * 根据订单号查询投资记录
     * @param orderId
     * @return
     */
    RmbInvest getInvestByOrderId(@Param("orderId") String orderId);

    /**
     * 查询标的第一位出借人
     * @param loanId
     * @return
     */
    List<RmbInvest> getFirstInvestLoanRecord(@Param("loanId") String loanId);

    /**
     * 更新标的加息券收益
     * @param investId
     * @param raiseAmount
     * @return
     */
    int updateRaiseAmount(@Param("investId") String investId, @Param("raiseAmount") BigDecimal raiseAmount);

    int queryCountCreditInvest(@Param("userId") String userId, @Param("status") LoanStatus status);

    int updateInvestStatusWhenInvestPreCancel(@Param("investId") String investId);

    List<Map> queryListCreditInvestByUserId(@Param("userId") String userId);

    List<RmbInvest> selectClearedByUserAndTime(@Param("start") int start, @Param("end") int end,
                                               @Param("userId") String userId, @Param("startDate") Date startDate,
                                               @Param("endDate") Date endDate);

    RmbInvest getInvestInfoByInvetId(@Param("investId")String investId);

    RmbInvest selectInvestByInvestIdAndUserId(@Param("investId")String investId, @Param("userId")String userId);

    List<RmbInvest> selectInvestByLoanId(@Param("loanId")String loanId);

    /**
     * 查询看借款企业(或个人)的信息：loanId
     * 注：除 userId为借款人信息，其余字段为出借人信息
     * @return
     */
    CoreUser selectEnterpriseInfoByLoanId(@Param("loanId")String loanId);
}