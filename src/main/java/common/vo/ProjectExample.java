package common.vo;

import java.util.ArrayList;
import java.util.List;

public class ProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ProjectExample() {
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

        public Criteria andProjectIdIsNull() {
            addCriterion("PROJECT_ID is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("PROJECT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(String value) {
            addCriterion("PROJECT_ID =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(String value) {
            addCriterion("PROJECT_ID <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(String value) {
            addCriterion("PROJECT_ID >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("PROJECT_ID >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(String value) {
            addCriterion("PROJECT_ID <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(String value) {
            addCriterion("PROJECT_ID <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLike(String value) {
            addCriterion("PROJECT_ID like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotLike(String value) {
            addCriterion("PROJECT_ID not like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<String> values) {
            addCriterion("PROJECT_ID in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<String> values) {
            addCriterion("PROJECT_ID not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(String value1, String value2) {
            addCriterion("PROJECT_ID between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(String value1, String value2) {
            addCriterion("PROJECT_ID not between", value1, value2, "projectId");
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

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andProjectStatueIsNull() {
            addCriterion("PROJECT_STATUE is null");
            return (Criteria) this;
        }

        public Criteria andProjectStatueIsNotNull() {
            addCriterion("PROJECT_STATUE is not null");
            return (Criteria) this;
        }

        public Criteria andProjectStatueEqualTo(String value) {
            addCriterion("PROJECT_STATUE =", value, "projectStatue");
            return (Criteria) this;
        }

        public Criteria andProjectStatueNotEqualTo(String value) {
            addCriterion("PROJECT_STATUE <>", value, "projectStatue");
            return (Criteria) this;
        }

        public Criteria andProjectStatueGreaterThan(String value) {
            addCriterion("PROJECT_STATUE >", value, "projectStatue");
            return (Criteria) this;
        }

        public Criteria andProjectStatueGreaterThanOrEqualTo(String value) {
            addCriterion("PROJECT_STATUE >=", value, "projectStatue");
            return (Criteria) this;
        }

        public Criteria andProjectStatueLessThan(String value) {
            addCriterion("PROJECT_STATUE <", value, "projectStatue");
            return (Criteria) this;
        }

        public Criteria andProjectStatueLessThanOrEqualTo(String value) {
            addCriterion("PROJECT_STATUE <=", value, "projectStatue");
            return (Criteria) this;
        }

        public Criteria andProjectStatueLike(String value) {
            addCriterion("PROJECT_STATUE like", value, "projectStatue");
            return (Criteria) this;
        }

        public Criteria andProjectStatueNotLike(String value) {
            addCriterion("PROJECT_STATUE not like", value, "projectStatue");
            return (Criteria) this;
        }

        public Criteria andProjectStatueIn(List<String> values) {
            addCriterion("PROJECT_STATUE in", values, "projectStatue");
            return (Criteria) this;
        }

        public Criteria andProjectStatueNotIn(List<String> values) {
            addCriterion("PROJECT_STATUE not in", values, "projectStatue");
            return (Criteria) this;
        }

        public Criteria andProjectStatueBetween(String value1, String value2) {
            addCriterion("PROJECT_STATUE between", value1, value2, "projectStatue");
            return (Criteria) this;
        }

        public Criteria andProjectStatueNotBetween(String value1, String value2) {
            addCriterion("PROJECT_STATUE not between", value1, value2, "projectStatue");
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

        public Criteria andProjectStepIsNull() {
            addCriterion("PROJECT_STEP is null");
            return (Criteria) this;
        }

        public Criteria andProjectStepIsNotNull() {
            addCriterion("PROJECT_STEP is not null");
            return (Criteria) this;
        }

        public Criteria andProjectStepEqualTo(String value) {
            addCriterion("PROJECT_STEP =", value, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepNotEqualTo(String value) {
            addCriterion("PROJECT_STEP <>", value, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepGreaterThan(String value) {
            addCriterion("PROJECT_STEP >", value, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepGreaterThanOrEqualTo(String value) {
            addCriterion("PROJECT_STEP >=", value, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepLessThan(String value) {
            addCriterion("PROJECT_STEP <", value, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepLessThanOrEqualTo(String value) {
            addCriterion("PROJECT_STEP <=", value, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepLike(String value) {
            addCriterion("PROJECT_STEP like", value, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepNotLike(String value) {
            addCriterion("PROJECT_STEP not like", value, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepIn(List<String> values) {
            addCriterion("PROJECT_STEP in", values, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepNotIn(List<String> values) {
            addCriterion("PROJECT_STEP not in", values, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepBetween(String value1, String value2) {
            addCriterion("PROJECT_STEP between", value1, value2, "projectStep");
            return (Criteria) this;
        }

        public Criteria andProjectStepNotBetween(String value1, String value2) {
            addCriterion("PROJECT_STEP not between", value1, value2, "projectStep");
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