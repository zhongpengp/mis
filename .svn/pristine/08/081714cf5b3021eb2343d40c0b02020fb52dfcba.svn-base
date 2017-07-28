package common.vo;

import java.util.ArrayList;
import java.util.List;

public class XM_GYSExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public XM_GYSExample() {
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

        public Criteria andXmUserIdIsNull() {
            addCriterion("XM_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andXmUserIdIsNotNull() {
            addCriterion("XM_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andXmUserIdEqualTo(String value) {
            addCriterion("XM_USER_ID =", value, "xmUserId");
            return (Criteria) this;
        }

        public Criteria andXmUserIdNotEqualTo(String value) {
            addCriterion("XM_USER_ID <>", value, "xmUserId");
            return (Criteria) this;
        }

        public Criteria andXmUserIdGreaterThan(String value) {
            addCriterion("XM_USER_ID >", value, "xmUserId");
            return (Criteria) this;
        }

        public Criteria andXmUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("XM_USER_ID >=", value, "xmUserId");
            return (Criteria) this;
        }

        public Criteria andXmUserIdLessThan(String value) {
            addCriterion("XM_USER_ID <", value, "xmUserId");
            return (Criteria) this;
        }

        public Criteria andXmUserIdLessThanOrEqualTo(String value) {
            addCriterion("XM_USER_ID <=", value, "xmUserId");
            return (Criteria) this;
        }

        public Criteria andXmUserIdLike(String value) {
            addCriterion("XM_USER_ID like", value, "xmUserId");
            return (Criteria) this;
        }

        public Criteria andXmUserIdNotLike(String value) {
            addCriterion("XM_USER_ID not like", value, "xmUserId");
            return (Criteria) this;
        }

        public Criteria andXmUserIdIn(List<String> values) {
            addCriterion("XM_USER_ID in", values, "xmUserId");
            return (Criteria) this;
        }

        public Criteria andXmUserIdNotIn(List<String> values) {
            addCriterion("XM_USER_ID not in", values, "xmUserId");
            return (Criteria) this;
        }

        public Criteria andXmUserIdBetween(String value1, String value2) {
            addCriterion("XM_USER_ID between", value1, value2, "xmUserId");
            return (Criteria) this;
        }

        public Criteria andXmUserIdNotBetween(String value1, String value2) {
            addCriterion("XM_USER_ID not between", value1, value2, "xmUserId");
            return (Criteria) this;
        }

        public Criteria andGysUserIdIsNull() {
            addCriterion("GYS_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andGysUserIdIsNotNull() {
            addCriterion("GYS_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGysUserIdEqualTo(String value) {
            addCriterion("GYS_USER_ID =", value, "gysUserId");
            return (Criteria) this;
        }

        public Criteria andGysUserIdNotEqualTo(String value) {
            addCriterion("GYS_USER_ID <>", value, "gysUserId");
            return (Criteria) this;
        }

        public Criteria andGysUserIdGreaterThan(String value) {
            addCriterion("GYS_USER_ID >", value, "gysUserId");
            return (Criteria) this;
        }

        public Criteria andGysUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("GYS_USER_ID >=", value, "gysUserId");
            return (Criteria) this;
        }

        public Criteria andGysUserIdLessThan(String value) {
            addCriterion("GYS_USER_ID <", value, "gysUserId");
            return (Criteria) this;
        }

        public Criteria andGysUserIdLessThanOrEqualTo(String value) {
            addCriterion("GYS_USER_ID <=", value, "gysUserId");
            return (Criteria) this;
        }

        public Criteria andGysUserIdLike(String value) {
            addCriterion("GYS_USER_ID like", value, "gysUserId");
            return (Criteria) this;
        }

        public Criteria andGysUserIdNotLike(String value) {
            addCriterion("GYS_USER_ID not like", value, "gysUserId");
            return (Criteria) this;
        }

        public Criteria andGysUserIdIn(List<String> values) {
            addCriterion("GYS_USER_ID in", values, "gysUserId");
            return (Criteria) this;
        }

        public Criteria andGysUserIdNotIn(List<String> values) {
            addCriterion("GYS_USER_ID not in", values, "gysUserId");
            return (Criteria) this;
        }

        public Criteria andGysUserIdBetween(String value1, String value2) {
            addCriterion("GYS_USER_ID between", value1, value2, "gysUserId");
            return (Criteria) this;
        }

        public Criteria andGysUserIdNotBetween(String value1, String value2) {
            addCriterion("GYS_USER_ID not between", value1, value2, "gysUserId");
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