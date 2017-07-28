package common.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegisterApplyGSExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public RegisterApplyGSExample() {
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

        public Criteria andApplyGsNameIsNull() {
            addCriterion("APPLY_GS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andApplyGsNameIsNotNull() {
            addCriterion("APPLY_GS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andApplyGsNameEqualTo(String value) {
            addCriterion("APPLY_GS_NAME =", value, "applyGsName");
            return (Criteria) this;
        }

        public Criteria andApplyGsNameNotEqualTo(String value) {
            addCriterion("APPLY_GS_NAME <>", value, "applyGsName");
            return (Criteria) this;
        }

        public Criteria andApplyGsNameGreaterThan(String value) {
            addCriterion("APPLY_GS_NAME >", value, "applyGsName");
            return (Criteria) this;
        }

        public Criteria andApplyGsNameGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_GS_NAME >=", value, "applyGsName");
            return (Criteria) this;
        }

        public Criteria andApplyGsNameLessThan(String value) {
            addCriterion("APPLY_GS_NAME <", value, "applyGsName");
            return (Criteria) this;
        }

        public Criteria andApplyGsNameLessThanOrEqualTo(String value) {
            addCriterion("APPLY_GS_NAME <=", value, "applyGsName");
            return (Criteria) this;
        }

        public Criteria andApplyGsNameLike(String value) {
            addCriterion("APPLY_GS_NAME like", value, "applyGsName");
            return (Criteria) this;
        }

        public Criteria andApplyGsNameNotLike(String value) {
            addCriterion("APPLY_GS_NAME not like", value, "applyGsName");
            return (Criteria) this;
        }

        public Criteria andApplyGsNameIn(List<String> values) {
            addCriterion("APPLY_GS_NAME in", values, "applyGsName");
            return (Criteria) this;
        }

        public Criteria andApplyGsNameNotIn(List<String> values) {
            addCriterion("APPLY_GS_NAME not in", values, "applyGsName");
            return (Criteria) this;
        }

        public Criteria andApplyGsNameBetween(String value1, String value2) {
            addCriterion("APPLY_GS_NAME between", value1, value2, "applyGsName");
            return (Criteria) this;
        }

        public Criteria andApplyGsNameNotBetween(String value1, String value2) {
            addCriterion("APPLY_GS_NAME not between", value1, value2, "applyGsName");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserNameIsNull() {
            addCriterion("APPLY_GS_USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserNameIsNotNull() {
            addCriterion("APPLY_GS_USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserNameEqualTo(String value) {
            addCriterion("APPLY_GS_USER_NAME =", value, "applyGsUserName");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserNameNotEqualTo(String value) {
            addCriterion("APPLY_GS_USER_NAME <>", value, "applyGsUserName");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserNameGreaterThan(String value) {
            addCriterion("APPLY_GS_USER_NAME >", value, "applyGsUserName");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_GS_USER_NAME >=", value, "applyGsUserName");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserNameLessThan(String value) {
            addCriterion("APPLY_GS_USER_NAME <", value, "applyGsUserName");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserNameLessThanOrEqualTo(String value) {
            addCriterion("APPLY_GS_USER_NAME <=", value, "applyGsUserName");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserNameLike(String value) {
            addCriterion("APPLY_GS_USER_NAME like", value, "applyGsUserName");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserNameNotLike(String value) {
            addCriterion("APPLY_GS_USER_NAME not like", value, "applyGsUserName");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserNameIn(List<String> values) {
            addCriterion("APPLY_GS_USER_NAME in", values, "applyGsUserName");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserNameNotIn(List<String> values) {
            addCriterion("APPLY_GS_USER_NAME not in", values, "applyGsUserName");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserNameBetween(String value1, String value2) {
            addCriterion("APPLY_GS_USER_NAME between", value1, value2, "applyGsUserName");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserNameNotBetween(String value1, String value2) {
            addCriterion("APPLY_GS_USER_NAME not between", value1, value2, "applyGsUserName");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserIdnumIsNull() {
            addCriterion("APPLY_GS_USER_IDNUM is null");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserIdnumIsNotNull() {
            addCriterion("APPLY_GS_USER_IDNUM is not null");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserIdnumEqualTo(String value) {
            addCriterion("APPLY_GS_USER_IDNUM =", value, "applyGsUserIdnum");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserIdnumNotEqualTo(String value) {
            addCriterion("APPLY_GS_USER_IDNUM <>", value, "applyGsUserIdnum");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserIdnumGreaterThan(String value) {
            addCriterion("APPLY_GS_USER_IDNUM >", value, "applyGsUserIdnum");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserIdnumGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_GS_USER_IDNUM >=", value, "applyGsUserIdnum");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserIdnumLessThan(String value) {
            addCriterion("APPLY_GS_USER_IDNUM <", value, "applyGsUserIdnum");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserIdnumLessThanOrEqualTo(String value) {
            addCriterion("APPLY_GS_USER_IDNUM <=", value, "applyGsUserIdnum");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserIdnumLike(String value) {
            addCriterion("APPLY_GS_USER_IDNUM like", value, "applyGsUserIdnum");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserIdnumNotLike(String value) {
            addCriterion("APPLY_GS_USER_IDNUM not like", value, "applyGsUserIdnum");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserIdnumIn(List<String> values) {
            addCriterion("APPLY_GS_USER_IDNUM in", values, "applyGsUserIdnum");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserIdnumNotIn(List<String> values) {
            addCriterion("APPLY_GS_USER_IDNUM not in", values, "applyGsUserIdnum");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserIdnumBetween(String value1, String value2) {
            addCriterion("APPLY_GS_USER_IDNUM between", value1, value2, "applyGsUserIdnum");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserIdnumNotBetween(String value1, String value2) {
            addCriterion("APPLY_GS_USER_IDNUM not between", value1, value2, "applyGsUserIdnum");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserPhoneIsNull() {
            addCriterion("APPLY_GS_USER_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserPhoneIsNotNull() {
            addCriterion("APPLY_GS_USER_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserPhoneEqualTo(String value) {
            addCriterion("APPLY_GS_USER_PHONE =", value, "applyGsUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserPhoneNotEqualTo(String value) {
            addCriterion("APPLY_GS_USER_PHONE <>", value, "applyGsUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserPhoneGreaterThan(String value) {
            addCriterion("APPLY_GS_USER_PHONE >", value, "applyGsUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_GS_USER_PHONE >=", value, "applyGsUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserPhoneLessThan(String value) {
            addCriterion("APPLY_GS_USER_PHONE <", value, "applyGsUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("APPLY_GS_USER_PHONE <=", value, "applyGsUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserPhoneLike(String value) {
            addCriterion("APPLY_GS_USER_PHONE like", value, "applyGsUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserPhoneNotLike(String value) {
            addCriterion("APPLY_GS_USER_PHONE not like", value, "applyGsUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserPhoneIn(List<String> values) {
            addCriterion("APPLY_GS_USER_PHONE in", values, "applyGsUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserPhoneNotIn(List<String> values) {
            addCriterion("APPLY_GS_USER_PHONE not in", values, "applyGsUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserPhoneBetween(String value1, String value2) {
            addCriterion("APPLY_GS_USER_PHONE between", value1, value2, "applyGsUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserPhoneNotBetween(String value1, String value2) {
            addCriterion("APPLY_GS_USER_PHONE not between", value1, value2, "applyGsUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserDescIsNull() {
            addCriterion("APPLY_GS_USER_DESC is null");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserDescIsNotNull() {
            addCriterion("APPLY_GS_USER_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserDescEqualTo(String value) {
            addCriterion("APPLY_GS_USER_DESC =", value, "applyGsUserDesc");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserDescNotEqualTo(String value) {
            addCriterion("APPLY_GS_USER_DESC <>", value, "applyGsUserDesc");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserDescGreaterThan(String value) {
            addCriterion("APPLY_GS_USER_DESC >", value, "applyGsUserDesc");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserDescGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_GS_USER_DESC >=", value, "applyGsUserDesc");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserDescLessThan(String value) {
            addCriterion("APPLY_GS_USER_DESC <", value, "applyGsUserDesc");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserDescLessThanOrEqualTo(String value) {
            addCriterion("APPLY_GS_USER_DESC <=", value, "applyGsUserDesc");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserDescLike(String value) {
            addCriterion("APPLY_GS_USER_DESC like", value, "applyGsUserDesc");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserDescNotLike(String value) {
            addCriterion("APPLY_GS_USER_DESC not like", value, "applyGsUserDesc");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserDescIn(List<String> values) {
            addCriterion("APPLY_GS_USER_DESC in", values, "applyGsUserDesc");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserDescNotIn(List<String> values) {
            addCriterion("APPLY_GS_USER_DESC not in", values, "applyGsUserDesc");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserDescBetween(String value1, String value2) {
            addCriterion("APPLY_GS_USER_DESC between", value1, value2, "applyGsUserDesc");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserDescNotBetween(String value1, String value2) {
            addCriterion("APPLY_GS_USER_DESC not between", value1, value2, "applyGsUserDesc");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserEmailIsNull() {
            addCriterion("APPLY_GS_USER_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserEmailIsNotNull() {
            addCriterion("APPLY_GS_USER_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserEmailEqualTo(String value) {
            addCriterion("APPLY_GS_USER_EMAIL =", value, "applyGsUserEmail");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserEmailNotEqualTo(String value) {
            addCriterion("APPLY_GS_USER_EMAIL <>", value, "applyGsUserEmail");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserEmailGreaterThan(String value) {
            addCriterion("APPLY_GS_USER_EMAIL >", value, "applyGsUserEmail");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_GS_USER_EMAIL >=", value, "applyGsUserEmail");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserEmailLessThan(String value) {
            addCriterion("APPLY_GS_USER_EMAIL <", value, "applyGsUserEmail");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserEmailLessThanOrEqualTo(String value) {
            addCriterion("APPLY_GS_USER_EMAIL <=", value, "applyGsUserEmail");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserEmailLike(String value) {
            addCriterion("APPLY_GS_USER_EMAIL like", value, "applyGsUserEmail");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserEmailNotLike(String value) {
            addCriterion("APPLY_GS_USER_EMAIL not like", value, "applyGsUserEmail");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserEmailIn(List<String> values) {
            addCriterion("APPLY_GS_USER_EMAIL in", values, "applyGsUserEmail");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserEmailNotIn(List<String> values) {
            addCriterion("APPLY_GS_USER_EMAIL not in", values, "applyGsUserEmail");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserEmailBetween(String value1, String value2) {
            addCriterion("APPLY_GS_USER_EMAIL between", value1, value2, "applyGsUserEmail");
            return (Criteria) this;
        }

        public Criteria andApplyGsUserEmailNotBetween(String value1, String value2) {
            addCriterion("APPLY_GS_USER_EMAIL not between", value1, value2, "applyGsUserEmail");
            return (Criteria) this;
        }

        public Criteria andApplyGsTimeIsNull() {
            addCriterion("APPLY_GS_TIME is null");
            return (Criteria) this;
        }

        public Criteria andApplyGsTimeIsNotNull() {
            addCriterion("APPLY_GS_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andApplyGsTimeEqualTo(Date value) {
            addCriterion("APPLY_GS_TIME =", value, "applyGsTime");
            return (Criteria) this;
        }

        public Criteria andApplyGsTimeNotEqualTo(Date value) {
            addCriterion("APPLY_GS_TIME <>", value, "applyGsTime");
            return (Criteria) this;
        }

        public Criteria andApplyGsTimeGreaterThan(Date value) {
            addCriterion("APPLY_GS_TIME >", value, "applyGsTime");
            return (Criteria) this;
        }

        public Criteria andApplyGsTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("APPLY_GS_TIME >=", value, "applyGsTime");
            return (Criteria) this;
        }

        public Criteria andApplyGsTimeLessThan(Date value) {
            addCriterion("APPLY_GS_TIME <", value, "applyGsTime");
            return (Criteria) this;
        }

        public Criteria andApplyGsTimeLessThanOrEqualTo(Date value) {
            addCriterion("APPLY_GS_TIME <=", value, "applyGsTime");
            return (Criteria) this;
        }

        public Criteria andApplyGsTimeIn(List<Date> values) {
            addCriterion("APPLY_GS_TIME in", values, "applyGsTime");
            return (Criteria) this;
        }

        public Criteria andApplyGsTimeNotIn(List<Date> values) {
            addCriterion("APPLY_GS_TIME not in", values, "applyGsTime");
            return (Criteria) this;
        }

        public Criteria andApplyGsTimeBetween(Date value1, Date value2) {
            addCriterion("APPLY_GS_TIME between", value1, value2, "applyGsTime");
            return (Criteria) this;
        }

        public Criteria andApplyGsTimeNotBetween(Date value1, Date value2) {
            addCriterion("APPLY_GS_TIME not between", value1, value2, "applyGsTime");
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

        public Criteria andApplyStateIsNull() {
            addCriterion("APPLY_STATE is null");
            return (Criteria) this;
        }

        public Criteria andApplyStateIsNotNull() {
            addCriterion("APPLY_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andApplyStateEqualTo(Integer value) {
            addCriterion("APPLY_STATE =", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateNotEqualTo(Integer value) {
            addCriterion("APPLY_STATE <>", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateGreaterThan(Integer value) {
            addCriterion("APPLY_STATE >", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("APPLY_STATE >=", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateLessThan(Integer value) {
            addCriterion("APPLY_STATE <", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateLessThanOrEqualTo(Integer value) {
            addCriterion("APPLY_STATE <=", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateIn(List<Integer> values) {
            addCriterion("APPLY_STATE in", values, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateNotIn(List<Integer> values) {
            addCriterion("APPLY_STATE not in", values, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateBetween(Integer value1, Integer value2) {
            addCriterion("APPLY_STATE between", value1, value2, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateNotBetween(Integer value1, Integer value2) {
            addCriterion("APPLY_STATE not between", value1, value2, "applyState");
            return (Criteria) this;
        }

        public Criteria andReplyDetailIsNull() {
            addCriterion("REPLY_DETAIL is null");
            return (Criteria) this;
        }

        public Criteria andReplyDetailIsNotNull() {
            addCriterion("REPLY_DETAIL is not null");
            return (Criteria) this;
        }

        public Criteria andReplyDetailEqualTo(String value) {
            addCriterion("REPLY_DETAIL =", value, "replyDetail");
            return (Criteria) this;
        }

        public Criteria andReplyDetailNotEqualTo(String value) {
            addCriterion("REPLY_DETAIL <>", value, "replyDetail");
            return (Criteria) this;
        }

        public Criteria andReplyDetailGreaterThan(String value) {
            addCriterion("REPLY_DETAIL >", value, "replyDetail");
            return (Criteria) this;
        }

        public Criteria andReplyDetailGreaterThanOrEqualTo(String value) {
            addCriterion("REPLY_DETAIL >=", value, "replyDetail");
            return (Criteria) this;
        }

        public Criteria andReplyDetailLessThan(String value) {
            addCriterion("REPLY_DETAIL <", value, "replyDetail");
            return (Criteria) this;
        }

        public Criteria andReplyDetailLessThanOrEqualTo(String value) {
            addCriterion("REPLY_DETAIL <=", value, "replyDetail");
            return (Criteria) this;
        }

        public Criteria andReplyDetailLike(String value) {
            addCriterion("REPLY_DETAIL like", value, "replyDetail");
            return (Criteria) this;
        }

        public Criteria andReplyDetailNotLike(String value) {
            addCriterion("REPLY_DETAIL not like", value, "replyDetail");
            return (Criteria) this;
        }

        public Criteria andReplyDetailIn(List<String> values) {
            addCriterion("REPLY_DETAIL in", values, "replyDetail");
            return (Criteria) this;
        }

        public Criteria andReplyDetailNotIn(List<String> values) {
            addCriterion("REPLY_DETAIL not in", values, "replyDetail");
            return (Criteria) this;
        }

        public Criteria andReplyDetailBetween(String value1, String value2) {
            addCriterion("REPLY_DETAIL between", value1, value2, "replyDetail");
            return (Criteria) this;
        }

        public Criteria andReplyDetailNotBetween(String value1, String value2) {
            addCriterion("REPLY_DETAIL not between", value1, value2, "replyDetail");
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