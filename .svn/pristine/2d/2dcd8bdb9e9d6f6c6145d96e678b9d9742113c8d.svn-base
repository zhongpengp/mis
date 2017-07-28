package common.vo;

import java.util.ArrayList;
import java.util.List;

public class CompanyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public CompanyExample() {
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

        public Criteria andGsIdIsNull() {
            addCriterion("GS_ID is null");
            return (Criteria) this;
        }

        public Criteria andGsIdIsNotNull() {
            addCriterion("GS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGsIdEqualTo(String value) {
            addCriterion("GS_ID =", value, "gsId");
            return (Criteria) this;
        }

        public Criteria andGsIdNotEqualTo(String value) {
            addCriterion("GS_ID <>", value, "gsId");
            return (Criteria) this;
        }

        public Criteria andGsIdGreaterThan(String value) {
            addCriterion("GS_ID >", value, "gsId");
            return (Criteria) this;
        }

        public Criteria andGsIdGreaterThanOrEqualTo(String value) {
            addCriterion("GS_ID >=", value, "gsId");
            return (Criteria) this;
        }

        public Criteria andGsIdLessThan(String value) {
            addCriterion("GS_ID <", value, "gsId");
            return (Criteria) this;
        }

        public Criteria andGsIdLessThanOrEqualTo(String value) {
            addCriterion("GS_ID <=", value, "gsId");
            return (Criteria) this;
        }

        public Criteria andGsIdLike(String value) {
            addCriterion("GS_ID like", value, "gsId");
            return (Criteria) this;
        }

        public Criteria andGsIdNotLike(String value) {
            addCriterion("GS_ID not like", value, "gsId");
            return (Criteria) this;
        }

        public Criteria andGsIdIn(List<String> values) {
            addCriterion("GS_ID in", values, "gsId");
            return (Criteria) this;
        }

        public Criteria andGsIdNotIn(List<String> values) {
            addCriterion("GS_ID not in", values, "gsId");
            return (Criteria) this;
        }

        public Criteria andGsIdBetween(String value1, String value2) {
            addCriterion("GS_ID between", value1, value2, "gsId");
            return (Criteria) this;
        }

        public Criteria andGsIdNotBetween(String value1, String value2) {
            addCriterion("GS_ID not between", value1, value2, "gsId");
            return (Criteria) this;
        }

        public Criteria andGsNameIsNull() {
            addCriterion("GS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andGsNameIsNotNull() {
            addCriterion("GS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andGsNameEqualTo(String value) {
            addCriterion("GS_NAME =", value, "gsName");
            return (Criteria) this;
        }

        public Criteria andGsNameNotEqualTo(String value) {
            addCriterion("GS_NAME <>", value, "gsName");
            return (Criteria) this;
        }

        public Criteria andGsNameGreaterThan(String value) {
            addCriterion("GS_NAME >", value, "gsName");
            return (Criteria) this;
        }

        public Criteria andGsNameGreaterThanOrEqualTo(String value) {
            addCriterion("GS_NAME >=", value, "gsName");
            return (Criteria) this;
        }

        public Criteria andGsNameLessThan(String value) {
            addCriterion("GS_NAME <", value, "gsName");
            return (Criteria) this;
        }

        public Criteria andGsNameLessThanOrEqualTo(String value) {
            addCriterion("GS_NAME <=", value, "gsName");
            return (Criteria) this;
        }

        public Criteria andGsNameLike(String value) {
            addCriterion("GS_NAME like", value, "gsName");
            return (Criteria) this;
        }

        public Criteria andGsNameNotLike(String value) {
            addCriterion("GS_NAME not like", value, "gsName");
            return (Criteria) this;
        }

        public Criteria andGsNameIn(List<String> values) {
            addCriterion("GS_NAME in", values, "gsName");
            return (Criteria) this;
        }

        public Criteria andGsNameNotIn(List<String> values) {
            addCriterion("GS_NAME not in", values, "gsName");
            return (Criteria) this;
        }

        public Criteria andGsNameBetween(String value1, String value2) {
            addCriterion("GS_NAME between", value1, value2, "gsName");
            return (Criteria) this;
        }

        public Criteria andGsNameNotBetween(String value1, String value2) {
            addCriterion("GS_NAME not between", value1, value2, "gsName");
            return (Criteria) this;
        }

        public Criteria andGsDescIsNull() {
            addCriterion("GS_DESC is null");
            return (Criteria) this;
        }

        public Criteria andGsDescIsNotNull() {
            addCriterion("GS_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andGsDescEqualTo(String value) {
            addCriterion("GS_DESC =", value, "gsDesc");
            return (Criteria) this;
        }

        public Criteria andGsDescNotEqualTo(String value) {
            addCriterion("GS_DESC <>", value, "gsDesc");
            return (Criteria) this;
        }

        public Criteria andGsDescGreaterThan(String value) {
            addCriterion("GS_DESC >", value, "gsDesc");
            return (Criteria) this;
        }

        public Criteria andGsDescGreaterThanOrEqualTo(String value) {
            addCriterion("GS_DESC >=", value, "gsDesc");
            return (Criteria) this;
        }

        public Criteria andGsDescLessThan(String value) {
            addCriterion("GS_DESC <", value, "gsDesc");
            return (Criteria) this;
        }

        public Criteria andGsDescLessThanOrEqualTo(String value) {
            addCriterion("GS_DESC <=", value, "gsDesc");
            return (Criteria) this;
        }

        public Criteria andGsDescLike(String value) {
            addCriterion("GS_DESC like", value, "gsDesc");
            return (Criteria) this;
        }

        public Criteria andGsDescNotLike(String value) {
            addCriterion("GS_DESC not like", value, "gsDesc");
            return (Criteria) this;
        }

        public Criteria andGsDescIn(List<String> values) {
            addCriterion("GS_DESC in", values, "gsDesc");
            return (Criteria) this;
        }

        public Criteria andGsDescNotIn(List<String> values) {
            addCriterion("GS_DESC not in", values, "gsDesc");
            return (Criteria) this;
        }

        public Criteria andGsDescBetween(String value1, String value2) {
            addCriterion("GS_DESC between", value1, value2, "gsDesc");
            return (Criteria) this;
        }

        public Criteria andGsDescNotBetween(String value1, String value2) {
            addCriterion("GS_DESC not between", value1, value2, "gsDesc");
            return (Criteria) this;
        }

        public Criteria andGsStateIsNull() {
            addCriterion("GS_STATE is null");
            return (Criteria) this;
        }

        public Criteria andGsStateIsNotNull() {
            addCriterion("GS_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andGsStateEqualTo(Integer value) {
            addCriterion("GS_STATE =", value, "gsState");
            return (Criteria) this;
        }

        public Criteria andGsStateNotEqualTo(Integer value) {
            addCriterion("GS_STATE <>", value, "gsState");
            return (Criteria) this;
        }

        public Criteria andGsStateGreaterThan(Integer value) {
            addCriterion("GS_STATE >", value, "gsState");
            return (Criteria) this;
        }

        public Criteria andGsStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("GS_STATE >=", value, "gsState");
            return (Criteria) this;
        }

        public Criteria andGsStateLessThan(Integer value) {
            addCriterion("GS_STATE <", value, "gsState");
            return (Criteria) this;
        }

        public Criteria andGsStateLessThanOrEqualTo(Integer value) {
            addCriterion("GS_STATE <=", value, "gsState");
            return (Criteria) this;
        }

        public Criteria andGsStateIn(List<Integer> values) {
            addCriterion("GS_STATE in", values, "gsState");
            return (Criteria) this;
        }

        public Criteria andGsStateNotIn(List<Integer> values) {
            addCriterion("GS_STATE not in", values, "gsState");
            return (Criteria) this;
        }

        public Criteria andGsStateBetween(Integer value1, Integer value2) {
            addCriterion("GS_STATE between", value1, value2, "gsState");
            return (Criteria) this;
        }

        public Criteria andGsStateNotBetween(Integer value1, Integer value2) {
            addCriterion("GS_STATE not between", value1, value2, "gsState");
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