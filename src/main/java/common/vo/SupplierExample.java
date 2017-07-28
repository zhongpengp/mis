package common.vo;

import java.util.ArrayList;
import java.util.List;

public class SupplierExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public SupplierExample() {
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

        public Criteria andSupplierIdIsNull() {
            addCriterion("SUPPLIER_ID is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIsNotNull() {
            addCriterion("SUPPLIER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdEqualTo(String value) {
            addCriterion("SUPPLIER_ID =", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotEqualTo(String value) {
            addCriterion("SUPPLIER_ID <>", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThan(String value) {
            addCriterion("SUPPLIER_ID >", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThanOrEqualTo(String value) {
            addCriterion("SUPPLIER_ID >=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThan(String value) {
            addCriterion("SUPPLIER_ID <", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThanOrEqualTo(String value) {
            addCriterion("SUPPLIER_ID <=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLike(String value) {
            addCriterion("SUPPLIER_ID like", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotLike(String value) {
            addCriterion("SUPPLIER_ID not like", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIn(List<String> values) {
            addCriterion("SUPPLIER_ID in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotIn(List<String> values) {
            addCriterion("SUPPLIER_ID not in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdBetween(String value1, String value2) {
            addCriterion("SUPPLIER_ID between", value1, value2, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotBetween(String value1, String value2) {
            addCriterion("SUPPLIER_ID not between", value1, value2, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierNameIsNull() {
            addCriterion("SUPPLIER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSupplierNameIsNotNull() {
            addCriterion("SUPPLIER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierNameEqualTo(String value) {
            addCriterion("SUPPLIER_NAME =", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameNotEqualTo(String value) {
            addCriterion("SUPPLIER_NAME <>", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameGreaterThan(String value) {
            addCriterion("SUPPLIER_NAME >", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameGreaterThanOrEqualTo(String value) {
            addCriterion("SUPPLIER_NAME >=", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameLessThan(String value) {
            addCriterion("SUPPLIER_NAME <", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameLessThanOrEqualTo(String value) {
            addCriterion("SUPPLIER_NAME <=", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameLike(String value) {
            addCriterion("SUPPLIER_NAME like", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameNotLike(String value) {
            addCriterion("SUPPLIER_NAME not like", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameIn(List<String> values) {
            addCriterion("SUPPLIER_NAME in", values, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameNotIn(List<String> values) {
            addCriterion("SUPPLIER_NAME not in", values, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameBetween(String value1, String value2) {
            addCriterion("SUPPLIER_NAME between", value1, value2, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameNotBetween(String value1, String value2) {
            addCriterion("SUPPLIER_NAME not between", value1, value2, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierStateIsNull() {
            addCriterion("SUPPLIER_STATE is null");
            return (Criteria) this;
        }

        public Criteria andSupplierStateIsNotNull() {
            addCriterion("SUPPLIER_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierStateEqualTo(Integer value) {
            addCriterion("SUPPLIER_STATE =", value, "supplierState");
            return (Criteria) this;
        }

        public Criteria andSupplierStateNotEqualTo(Integer value) {
            addCriterion("SUPPLIER_STATE <>", value, "supplierState");
            return (Criteria) this;
        }

        public Criteria andSupplierStateGreaterThan(Integer value) {
            addCriterion("SUPPLIER_STATE >", value, "supplierState");
            return (Criteria) this;
        }

        public Criteria andSupplierStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("SUPPLIER_STATE >=", value, "supplierState");
            return (Criteria) this;
        }

        public Criteria andSupplierStateLessThan(Integer value) {
            addCriterion("SUPPLIER_STATE <", value, "supplierState");
            return (Criteria) this;
        }

        public Criteria andSupplierStateLessThanOrEqualTo(Integer value) {
            addCriterion("SUPPLIER_STATE <=", value, "supplierState");
            return (Criteria) this;
        }

        public Criteria andSupplierStateIn(List<Integer> values) {
            addCriterion("SUPPLIER_STATE in", values, "supplierState");
            return (Criteria) this;
        }

        public Criteria andSupplierStateNotIn(List<Integer> values) {
            addCriterion("SUPPLIER_STATE not in", values, "supplierState");
            return (Criteria) this;
        }

        public Criteria andSupplierStateBetween(Integer value1, Integer value2) {
            addCriterion("SUPPLIER_STATE between", value1, value2, "supplierState");
            return (Criteria) this;
        }

        public Criteria andSupplierStateNotBetween(Integer value1, Integer value2) {
            addCriterion("SUPPLIER_STATE not between", value1, value2, "supplierState");
            return (Criteria) this;
        }

        public Criteria andSupplierDescIsNull() {
            addCriterion("SUPPLIER_DESC is null");
            return (Criteria) this;
        }

        public Criteria andSupplierDescIsNotNull() {
            addCriterion("SUPPLIER_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierDescEqualTo(String value) {
            addCriterion("SUPPLIER_DESC =", value, "supplierDesc");
            return (Criteria) this;
        }

        public Criteria andSupplierDescNotEqualTo(String value) {
            addCriterion("SUPPLIER_DESC <>", value, "supplierDesc");
            return (Criteria) this;
        }

        public Criteria andSupplierDescGreaterThan(String value) {
            addCriterion("SUPPLIER_DESC >", value, "supplierDesc");
            return (Criteria) this;
        }

        public Criteria andSupplierDescGreaterThanOrEqualTo(String value) {
            addCriterion("SUPPLIER_DESC >=", value, "supplierDesc");
            return (Criteria) this;
        }

        public Criteria andSupplierDescLessThan(String value) {
            addCriterion("SUPPLIER_DESC <", value, "supplierDesc");
            return (Criteria) this;
        }

        public Criteria andSupplierDescLessThanOrEqualTo(String value) {
            addCriterion("SUPPLIER_DESC <=", value, "supplierDesc");
            return (Criteria) this;
        }

        public Criteria andSupplierDescLike(String value) {
            addCriterion("SUPPLIER_DESC like", value, "supplierDesc");
            return (Criteria) this;
        }

        public Criteria andSupplierDescNotLike(String value) {
            addCriterion("SUPPLIER_DESC not like", value, "supplierDesc");
            return (Criteria) this;
        }

        public Criteria andSupplierDescIn(List<String> values) {
            addCriterion("SUPPLIER_DESC in", values, "supplierDesc");
            return (Criteria) this;
        }

        public Criteria andSupplierDescNotIn(List<String> values) {
            addCriterion("SUPPLIER_DESC not in", values, "supplierDesc");
            return (Criteria) this;
        }

        public Criteria andSupplierDescBetween(String value1, String value2) {
            addCriterion("SUPPLIER_DESC between", value1, value2, "supplierDesc");
            return (Criteria) this;
        }

        public Criteria andSupplierDescNotBetween(String value1, String value2) {
            addCriterion("SUPPLIER_DESC not between", value1, value2, "supplierDesc");
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