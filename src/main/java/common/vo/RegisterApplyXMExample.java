package common.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegisterApplyXMExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public RegisterApplyXMExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andApplyIdIsNull() {
            addCriterion("APPLY_ID is null");
            return (Criteria) this;
        }

        public Criteria andApplyIdIsNotNull() {
            addCriterion("APPLY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andApplyIdEqualTo(String value) {
            addCriterion("APPLY_ID =", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotEqualTo(String value) {
            addCriterion("APPLY_ID <>", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThan(String value) {
            addCriterion("APPLY_ID >", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_ID >=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThan(String value) {
            addCriterion("APPLY_ID <", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThanOrEqualTo(String value) {
            addCriterion("APPLY_ID <=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLike(String value) {
            addCriterion("APPLY_ID like", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotLike(String value) {
            addCriterion("APPLY_ID not like", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdIn(List<String> values) {
            addCriterion("APPLY_ID in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotIn(List<String> values) {
            addCriterion("APPLY_ID not in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdBetween(String value1, String value2) {
            addCriterion("APPLY_ID between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotBetween(String value1, String value2) {
            addCriterion("APPLY_ID not between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplierNameIsNull() {
            addCriterion("APPLIER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andApplierNameIsNotNull() {
            addCriterion("APPLIER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andApplierNameEqualTo(String value) {
            addCriterion("APPLIER_NAME =", value, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameNotEqualTo(String value) {
            addCriterion("APPLIER_NAME <>", value, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameGreaterThan(String value) {
            addCriterion("APPLIER_NAME >", value, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameGreaterThanOrEqualTo(String value) {
            addCriterion("APPLIER_NAME >=", value, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameLessThan(String value) {
            addCriterion("APPLIER_NAME <", value, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameLessThanOrEqualTo(String value) {
            addCriterion("APPLIER_NAME <=", value, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameLike(String value) {
            addCriterion("APPLIER_NAME like", value, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameNotLike(String value) {
            addCriterion("APPLIER_NAME not like", value, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameIn(List<String> values) {
            addCriterion("APPLIER_NAME in", values, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameNotIn(List<String> values) {
            addCriterion("APPLIER_NAME not in", values, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameBetween(String value1, String value2) {
            addCriterion("APPLIER_NAME between", value1, value2, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameNotBetween(String value1, String value2) {
            addCriterion("APPLIER_NAME not between", value1, value2, "applierName");
            return (Criteria) this;
        }

        public Criteria andIdcardNumIsNull() {
            addCriterion("IDCARD_NUM is null");
            return (Criteria) this;
        }

        public Criteria andIdcardNumIsNotNull() {
            addCriterion("IDCARD_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardNumEqualTo(String value) {
            addCriterion("IDCARD_NUM =", value, "idcardNum");
            return (Criteria) this;
        }

        public Criteria andIdcardNumNotEqualTo(String value) {
            addCriterion("IDCARD_NUM <>", value, "idcardNum");
            return (Criteria) this;
        }

        public Criteria andIdcardNumGreaterThan(String value) {
            addCriterion("IDCARD_NUM >", value, "idcardNum");
            return (Criteria) this;
        }

        public Criteria andIdcardNumGreaterThanOrEqualTo(String value) {
            addCriterion("IDCARD_NUM >=", value, "idcardNum");
            return (Criteria) this;
        }

        public Criteria andIdcardNumLessThan(String value) {
            addCriterion("IDCARD_NUM <", value, "idcardNum");
            return (Criteria) this;
        }

        public Criteria andIdcardNumLessThanOrEqualTo(String value) {
            addCriterion("IDCARD_NUM <=", value, "idcardNum");
            return (Criteria) this;
        }

        public Criteria andIdcardNumLike(String value) {
            addCriterion("IDCARD_NUM like", value, "idcardNum");
            return (Criteria) this;
        }

        public Criteria andIdcardNumNotLike(String value) {
            addCriterion("IDCARD_NUM not like", value, "idcardNum");
            return (Criteria) this;
        }

        public Criteria andIdcardNumIn(List<String> values) {
            addCriterion("IDCARD_NUM in", values, "idcardNum");
            return (Criteria) this;
        }

        public Criteria andIdcardNumNotIn(List<String> values) {
            addCriterion("IDCARD_NUM not in", values, "idcardNum");
            return (Criteria) this;
        }

        public Criteria andIdcardNumBetween(String value1, String value2) {
            addCriterion("IDCARD_NUM between", value1, value2, "idcardNum");
            return (Criteria) this;
        }

        public Criteria andIdcardNumNotBetween(String value1, String value2) {
            addCriterion("IDCARD_NUM not between", value1, value2, "idcardNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIsNull() {
            addCriterion("PHONE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIsNotNull() {
            addCriterion("PHONE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumEqualTo(String value) {
            addCriterion("PHONE_NUM =", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotEqualTo(String value) {
            addCriterion("PHONE_NUM <>", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumGreaterThan(String value) {
            addCriterion("PHONE_NUM >", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE_NUM >=", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLessThan(String value) {
            addCriterion("PHONE_NUM <", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLessThanOrEqualTo(String value) {
            addCriterion("PHONE_NUM <=", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLike(String value) {
            addCriterion("PHONE_NUM like", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotLike(String value) {
            addCriterion("PHONE_NUM not like", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIn(List<String> values) {
            addCriterion("PHONE_NUM in", values, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotIn(List<String> values) {
            addCriterion("PHONE_NUM not in", values, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumBetween(String value1, String value2) {
            addCriterion("PHONE_NUM between", value1, value2, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotBetween(String value1, String value2) {
            addCriterion("PHONE_NUM not between", value1, value2, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("PROJECT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("PROJECT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("PROJECT_NAME =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("PROJECT_NAME <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("PROJECT_NAME >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("PROJECT_NAME >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("PROJECT_NAME <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("PROJECT_NAME <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("PROJECT_NAME like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("PROJECT_NAME not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("PROJECT_NAME in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("PROJECT_NAME not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("PROJECT_NAME between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("PROJECT_NAME not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectDetailIsNull() {
            addCriterion("PROJECT_DETAIL is null");
            return (Criteria) this;
        }

        public Criteria andProjectDetailIsNotNull() {
            addCriterion("PROJECT_DETAIL is not null");
            return (Criteria) this;
        }

        public Criteria andProjectDetailEqualTo(String value) {
            addCriterion("PROJECT_DETAIL =", value, "projectDetail");
            return (Criteria) this;
        }

        public Criteria andProjectDetailNotEqualTo(String value) {
            addCriterion("PROJECT_DETAIL <>", value, "projectDetail");
            return (Criteria) this;
        }

        public Criteria andProjectDetailGreaterThan(String value) {
            addCriterion("PROJECT_DETAIL >", value, "projectDetail");
            return (Criteria) this;
        }

        public Criteria andProjectDetailGreaterThanOrEqualTo(String value) {
            addCriterion("PROJECT_DETAIL >=", value, "projectDetail");
            return (Criteria) this;
        }

        public Criteria andProjectDetailLessThan(String value) {
            addCriterion("PROJECT_DETAIL <", value, "projectDetail");
            return (Criteria) this;
        }

        public Criteria andProjectDetailLessThanOrEqualTo(String value) {
            addCriterion("PROJECT_DETAIL <=", value, "projectDetail");
            return (Criteria) this;
        }

        public Criteria andProjectDetailLike(String value) {
            addCriterion("PROJECT_DETAIL like", value, "projectDetail");
            return (Criteria) this;
        }

        public Criteria andProjectDetailNotLike(String value) {
            addCriterion("PROJECT_DETAIL not like", value, "projectDetail");
            return (Criteria) this;
        }

        public Criteria andProjectDetailIn(List<String> values) {
            addCriterion("PROJECT_DETAIL in", values, "projectDetail");
            return (Criteria) this;
        }

        public Criteria andProjectDetailNotIn(List<String> values) {
            addCriterion("PROJECT_DETAIL not in", values, "projectDetail");
            return (Criteria) this;
        }

        public Criteria andProjectDetailBetween(String value1, String value2) {
            addCriterion("PROJECT_DETAIL between", value1, value2, "projectDetail");
            return (Criteria) this;
        }

        public Criteria andProjectDetailNotBetween(String value1, String value2) {
            addCriterion("PROJECT_DETAIL not between", value1, value2, "projectDetail");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNull() {
            addCriterion("APPLY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNotNull() {
            addCriterion("APPLY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEqualTo(Date value) {
            addCriterion("APPLY_TIME =", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotEqualTo(Date value) {
            addCriterion("APPLY_TIME <>", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThan(Date value) {
            addCriterion("APPLY_TIME >", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("APPLY_TIME >=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThan(Date value) {
            addCriterion("APPLY_TIME <", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThanOrEqualTo(Date value) {
            addCriterion("APPLY_TIME <=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIn(List<Date> values) {
            addCriterion("APPLY_TIME in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotIn(List<Date> values) {
            addCriterion("APPLY_TIME not in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeBetween(Date value1, Date value2) {
            addCriterion("APPLY_TIME between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotBetween(Date value1, Date value2) {
            addCriterion("APPLY_TIME not between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyStatueIsNull() {
            addCriterion("APPLY_STATUE is null");
            return (Criteria) this;
        }

        public Criteria andApplyStatueIsNotNull() {
            addCriterion("APPLY_STATUE is not null");
            return (Criteria) this;
        }

        public Criteria andApplyStatueEqualTo(String value) {
            addCriterion("APPLY_STATUE =", value, "applyStatue");
            return (Criteria) this;
        }

        public Criteria andApplyStatueNotEqualTo(String value) {
            addCriterion("APPLY_STATUE <>", value, "applyStatue");
            return (Criteria) this;
        }

        public Criteria andApplyStatueGreaterThan(String value) {
            addCriterion("APPLY_STATUE >", value, "applyStatue");
            return (Criteria) this;
        }

        public Criteria andApplyStatueGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_STATUE >=", value, "applyStatue");
            return (Criteria) this;
        }

        public Criteria andApplyStatueLessThan(String value) {
            addCriterion("APPLY_STATUE <", value, "applyStatue");
            return (Criteria) this;
        }

        public Criteria andApplyStatueLessThanOrEqualTo(String value) {
            addCriterion("APPLY_STATUE <=", value, "applyStatue");
            return (Criteria) this;
        }

        public Criteria andApplyStatueLike(String value) {
            addCriterion("APPLY_STATUE like", value, "applyStatue");
            return (Criteria) this;
        }

        public Criteria andApplyStatueNotLike(String value) {
            addCriterion("APPLY_STATUE not like", value, "applyStatue");
            return (Criteria) this;
        }

        public Criteria andApplyStatueIn(List<String> values) {
            addCriterion("APPLY_STATUE in", values, "applyStatue");
            return (Criteria) this;
        }

        public Criteria andApplyStatueNotIn(List<String> values) {
            addCriterion("APPLY_STATUE not in", values, "applyStatue");
            return (Criteria) this;
        }

        public Criteria andApplyStatueBetween(String value1, String value2) {
            addCriterion("APPLY_STATUE between", value1, value2, "applyStatue");
            return (Criteria) this;
        }

        public Criteria andApplyStatueNotBetween(String value1, String value2) {
            addCriterion("APPLY_STATUE not between", value1, value2, "applyStatue");
            return (Criteria) this;
        }

        public Criteria andApplyIpIsNull() {
            addCriterion("APPLY_IP is null");
            return (Criteria) this;
        }

        public Criteria andApplyIpIsNotNull() {
            addCriterion("APPLY_IP is not null");
            return (Criteria) this;
        }

        public Criteria andApplyIpEqualTo(String value) {
            addCriterion("APPLY_IP =", value, "applyIp");
            return (Criteria) this;
        }

        public Criteria andApplyIpNotEqualTo(String value) {
            addCriterion("APPLY_IP <>", value, "applyIp");
            return (Criteria) this;
        }

        public Criteria andApplyIpGreaterThan(String value) {
            addCriterion("APPLY_IP >", value, "applyIp");
            return (Criteria) this;
        }

        public Criteria andApplyIpGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_IP >=", value, "applyIp");
            return (Criteria) this;
        }

        public Criteria andApplyIpLessThan(String value) {
            addCriterion("APPLY_IP <", value, "applyIp");
            return (Criteria) this;
        }

        public Criteria andApplyIpLessThanOrEqualTo(String value) {
            addCriterion("APPLY_IP <=", value, "applyIp");
            return (Criteria) this;
        }

        public Criteria andApplyIpLike(String value) {
            addCriterion("APPLY_IP like", value, "applyIp");
            return (Criteria) this;
        }

        public Criteria andApplyIpNotLike(String value) {
            addCriterion("APPLY_IP not like", value, "applyIp");
            return (Criteria) this;
        }

        public Criteria andApplyIpIn(List<String> values) {
            addCriterion("APPLY_IP in", values, "applyIp");
            return (Criteria) this;
        }

        public Criteria andApplyIpNotIn(List<String> values) {
            addCriterion("APPLY_IP not in", values, "applyIp");
            return (Criteria) this;
        }

        public Criteria andApplyIpBetween(String value1, String value2) {
            addCriterion("APPLY_IP between", value1, value2, "applyIp");
            return (Criteria) this;
        }

        public Criteria andApplyIpNotBetween(String value1, String value2) {
            addCriterion("APPLY_IP not between", value1, value2, "applyIp");
            return (Criteria) this;
        }

        public Criteria andApprovalDetailIsNull() {
            addCriterion("APPROVAL_DETAIL is null");
            return (Criteria) this;
        }

        public Criteria andApprovalDetailIsNotNull() {
            addCriterion("APPROVAL_DETAIL is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalDetailEqualTo(String value) {
            addCriterion("APPROVAL_DETAIL =", value, "approvalDetail");
            return (Criteria) this;
        }

        public Criteria andApprovalDetailNotEqualTo(String value) {
            addCriterion("APPROVAL_DETAIL <>", value, "approvalDetail");
            return (Criteria) this;
        }

        public Criteria andApprovalDetailGreaterThan(String value) {
            addCriterion("APPROVAL_DETAIL >", value, "approvalDetail");
            return (Criteria) this;
        }

        public Criteria andApprovalDetailGreaterThanOrEqualTo(String value) {
            addCriterion("APPROVAL_DETAIL >=", value, "approvalDetail");
            return (Criteria) this;
        }

        public Criteria andApprovalDetailLessThan(String value) {
            addCriterion("APPROVAL_DETAIL <", value, "approvalDetail");
            return (Criteria) this;
        }

        public Criteria andApprovalDetailLessThanOrEqualTo(String value) {
            addCriterion("APPROVAL_DETAIL <=", value, "approvalDetail");
            return (Criteria) this;
        }

        public Criteria andApprovalDetailLike(String value) {
            addCriterion("APPROVAL_DETAIL like", value, "approvalDetail");
            return (Criteria) this;
        }

        public Criteria andApprovalDetailNotLike(String value) {
            addCriterion("APPROVAL_DETAIL not like", value, "approvalDetail");
            return (Criteria) this;
        }

        public Criteria andApprovalDetailIn(List<String> values) {
            addCriterion("APPROVAL_DETAIL in", values, "approvalDetail");
            return (Criteria) this;
        }

        public Criteria andApprovalDetailNotIn(List<String> values) {
            addCriterion("APPROVAL_DETAIL not in", values, "approvalDetail");
            return (Criteria) this;
        }

        public Criteria andApprovalDetailBetween(String value1, String value2) {
            addCriterion("APPROVAL_DETAIL between", value1, value2, "approvalDetail");
            return (Criteria) this;
        }

        public Criteria andApprovalDetailNotBetween(String value1, String value2) {
            addCriterion("APPROVAL_DETAIL not between", value1, value2, "approvalDetail");
            return (Criteria) this;
        }

        public Criteria andApprovalDateIsNull() {
            addCriterion("APPROVAL_DATE is null");
            return (Criteria) this;
        }

        public Criteria andApprovalDateIsNotNull() {
            addCriterion("APPROVAL_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalDateEqualTo(Date value) {
            addCriterion("APPROVAL_DATE =", value, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateNotEqualTo(Date value) {
            addCriterion("APPROVAL_DATE <>", value, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateGreaterThan(Date value) {
            addCriterion("APPROVAL_DATE >", value, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateGreaterThanOrEqualTo(Date value) {
            addCriterion("APPROVAL_DATE >=", value, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateLessThan(Date value) {
            addCriterion("APPROVAL_DATE <", value, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateLessThanOrEqualTo(Date value) {
            addCriterion("APPROVAL_DATE <=", value, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateIn(List<Date> values) {
            addCriterion("APPROVAL_DATE in", values, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateNotIn(List<Date> values) {
            addCriterion("APPROVAL_DATE not in", values, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateBetween(Date value1, Date value2) {
            addCriterion("APPROVAL_DATE between", value1, value2, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateNotBetween(Date value1, Date value2) {
            addCriterion("APPROVAL_DATE not between", value1, value2, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalUseridIsNull() {
            addCriterion("APPROVAL_USERID is null");
            return (Criteria) this;
        }

        public Criteria andApprovalUseridIsNotNull() {
            addCriterion("APPROVAL_USERID is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalUseridEqualTo(String value) {
            addCriterion("APPROVAL_USERID =", value, "approvalUserid");
            return (Criteria) this;
        }

        public Criteria andApprovalUseridNotEqualTo(String value) {
            addCriterion("APPROVAL_USERID <>", value, "approvalUserid");
            return (Criteria) this;
        }

        public Criteria andApprovalUseridGreaterThan(String value) {
            addCriterion("APPROVAL_USERID >", value, "approvalUserid");
            return (Criteria) this;
        }

        public Criteria andApprovalUseridGreaterThanOrEqualTo(String value) {
            addCriterion("APPROVAL_USERID >=", value, "approvalUserid");
            return (Criteria) this;
        }

        public Criteria andApprovalUseridLessThan(String value) {
            addCriterion("APPROVAL_USERID <", value, "approvalUserid");
            return (Criteria) this;
        }

        public Criteria andApprovalUseridLessThanOrEqualTo(String value) {
            addCriterion("APPROVAL_USERID <=", value, "approvalUserid");
            return (Criteria) this;
        }

        public Criteria andApprovalUseridLike(String value) {
            addCriterion("APPROVAL_USERID like", value, "approvalUserid");
            return (Criteria) this;
        }

        public Criteria andApprovalUseridNotLike(String value) {
            addCriterion("APPROVAL_USERID not like", value, "approvalUserid");
            return (Criteria) this;
        }

        public Criteria andApprovalUseridIn(List<String> values) {
            addCriterion("APPROVAL_USERID in", values, "approvalUserid");
            return (Criteria) this;
        }

        public Criteria andApprovalUseridNotIn(List<String> values) {
            addCriterion("APPROVAL_USERID not in", values, "approvalUserid");
            return (Criteria) this;
        }

        public Criteria andApprovalUseridBetween(String value1, String value2) {
            addCriterion("APPROVAL_USERID between", value1, value2, "approvalUserid");
            return (Criteria) this;
        }

        public Criteria andApprovalUseridNotBetween(String value1, String value2) {
            addCriterion("APPROVAL_USERID not between", value1, value2, "approvalUserid");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNull() {
            addCriterion("PROJECT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNotNull() {
            addCriterion("PROJECT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeEqualTo(String value) {
            addCriterion("PROJECT_TYPE =", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotEqualTo(String value) {
            addCriterion("PROJECT_TYPE <>", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThan(String value) {
            addCriterion("PROJECT_TYPE >", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PROJECT_TYPE >=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThan(String value) {
            addCriterion("PROJECT_TYPE <", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThanOrEqualTo(String value) {
            addCriterion("PROJECT_TYPE <=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLike(String value) {
            addCriterion("PROJECT_TYPE like", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotLike(String value) {
            addCriterion("PROJECT_TYPE not like", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIn(List<String> values) {
            addCriterion("PROJECT_TYPE in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotIn(List<String> values) {
            addCriterion("PROJECT_TYPE not in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeBetween(String value1, String value2) {
            addCriterion("PROJECT_TYPE between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotBetween(String value1, String value2) {
            addCriterion("PROJECT_TYPE not between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("COMPANY_ID is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("COMPANY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(String value) {
            addCriterion("COMPANY_ID =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(String value) {
            addCriterion("COMPANY_ID <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(String value) {
            addCriterion("COMPANY_ID >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANY_ID >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(String value) {
            addCriterion("COMPANY_ID <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(String value) {
            addCriterion("COMPANY_ID <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLike(String value) {
            addCriterion("COMPANY_ID like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotLike(String value) {
            addCriterion("COMPANY_ID not like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<String> values) {
            addCriterion("COMPANY_ID in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<String> values) {
            addCriterion("COMPANY_ID not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(String value1, String value2) {
            addCriterion("COMPANY_ID between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(String value1, String value2) {
            addCriterion("COMPANY_ID not between", value1, value2, "companyId");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}