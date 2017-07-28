package mail.vo;

import java.util.ArrayList;
import java.util.List;

public class UserMailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public UserMailExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andMailAddressIsNull() {
            addCriterion("mail_address is null");
            return (Criteria) this;
        }

        public Criteria andMailAddressIsNotNull() {
            addCriterion("mail_address is not null");
            return (Criteria) this;
        }

        public Criteria andMailAddressEqualTo(String value) {
            addCriterion("mail_address =", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressNotEqualTo(String value) {
            addCriterion("mail_address <>", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressGreaterThan(String value) {
            addCriterion("mail_address >", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressGreaterThanOrEqualTo(String value) {
            addCriterion("mail_address >=", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressLessThan(String value) {
            addCriterion("mail_address <", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressLessThanOrEqualTo(String value) {
            addCriterion("mail_address <=", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressLike(String value) {
            addCriterion("mail_address like", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressNotLike(String value) {
            addCriterion("mail_address not like", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressIn(List<String> values) {
            addCriterion("mail_address in", values, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressNotIn(List<String> values) {
            addCriterion("mail_address not in", values, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressBetween(String value1, String value2) {
            addCriterion("mail_address between", value1, value2, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressNotBetween(String value1, String value2) {
            addCriterion("mail_address not between", value1, value2, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailSmtpHostIsNull() {
            addCriterion("mail_smtp_host is null");
            return (Criteria) this;
        }

        public Criteria andMailSmtpHostIsNotNull() {
            addCriterion("mail_smtp_host is not null");
            return (Criteria) this;
        }

        public Criteria andMailSmtpHostEqualTo(String value) {
            addCriterion("mail_smtp_host =", value, "mailSmtpHost");
            return (Criteria) this;
        }

        public Criteria andMailSmtpHostNotEqualTo(String value) {
            addCriterion("mail_smtp_host <>", value, "mailSmtpHost");
            return (Criteria) this;
        }

        public Criteria andMailSmtpHostGreaterThan(String value) {
            addCriterion("mail_smtp_host >", value, "mailSmtpHost");
            return (Criteria) this;
        }

        public Criteria andMailSmtpHostGreaterThanOrEqualTo(String value) {
            addCriterion("mail_smtp_host >=", value, "mailSmtpHost");
            return (Criteria) this;
        }

        public Criteria andMailSmtpHostLessThan(String value) {
            addCriterion("mail_smtp_host <", value, "mailSmtpHost");
            return (Criteria) this;
        }

        public Criteria andMailSmtpHostLessThanOrEqualTo(String value) {
            addCriterion("mail_smtp_host <=", value, "mailSmtpHost");
            return (Criteria) this;
        }

        public Criteria andMailSmtpHostLike(String value) {
            addCriterion("mail_smtp_host like", value, "mailSmtpHost");
            return (Criteria) this;
        }

        public Criteria andMailSmtpHostNotLike(String value) {
            addCriterion("mail_smtp_host not like", value, "mailSmtpHost");
            return (Criteria) this;
        }

        public Criteria andMailSmtpHostIn(List<String> values) {
            addCriterion("mail_smtp_host in", values, "mailSmtpHost");
            return (Criteria) this;
        }

        public Criteria andMailSmtpHostNotIn(List<String> values) {
            addCriterion("mail_smtp_host not in", values, "mailSmtpHost");
            return (Criteria) this;
        }

        public Criteria andMailSmtpHostBetween(String value1, String value2) {
            addCriterion("mail_smtp_host between", value1, value2, "mailSmtpHost");
            return (Criteria) this;
        }

        public Criteria andMailSmtpHostNotBetween(String value1, String value2) {
            addCriterion("mail_smtp_host not between", value1, value2, "mailSmtpHost");
            return (Criteria) this;
        }

        public Criteria andMailSmtpPortIsNull() {
            addCriterion("mail_smtp_port is null");
            return (Criteria) this;
        }

        public Criteria andMailSmtpPortIsNotNull() {
            addCriterion("mail_smtp_port is not null");
            return (Criteria) this;
        }

        public Criteria andMailSmtpPortEqualTo(String value) {
            addCriterion("mail_smtp_port =", value, "mailSmtpPort");
            return (Criteria) this;
        }

        public Criteria andMailSmtpPortNotEqualTo(String value) {
            addCriterion("mail_smtp_port <>", value, "mailSmtpPort");
            return (Criteria) this;
        }

        public Criteria andMailSmtpPortGreaterThan(String value) {
            addCriterion("mail_smtp_port >", value, "mailSmtpPort");
            return (Criteria) this;
        }

        public Criteria andMailSmtpPortGreaterThanOrEqualTo(String value) {
            addCriterion("mail_smtp_port >=", value, "mailSmtpPort");
            return (Criteria) this;
        }

        public Criteria andMailSmtpPortLessThan(String value) {
            addCriterion("mail_smtp_port <", value, "mailSmtpPort");
            return (Criteria) this;
        }

        public Criteria andMailSmtpPortLessThanOrEqualTo(String value) {
            addCriterion("mail_smtp_port <=", value, "mailSmtpPort");
            return (Criteria) this;
        }

        public Criteria andMailSmtpPortLike(String value) {
            addCriterion("mail_smtp_port like", value, "mailSmtpPort");
            return (Criteria) this;
        }

        public Criteria andMailSmtpPortNotLike(String value) {
            addCriterion("mail_smtp_port not like", value, "mailSmtpPort");
            return (Criteria) this;
        }

        public Criteria andMailSmtpPortIn(List<String> values) {
            addCriterion("mail_smtp_port in", values, "mailSmtpPort");
            return (Criteria) this;
        }

        public Criteria andMailSmtpPortNotIn(List<String> values) {
            addCriterion("mail_smtp_port not in", values, "mailSmtpPort");
            return (Criteria) this;
        }

        public Criteria andMailSmtpPortBetween(String value1, String value2) {
            addCriterion("mail_smtp_port between", value1, value2, "mailSmtpPort");
            return (Criteria) this;
        }

        public Criteria andMailSmtpPortNotBetween(String value1, String value2) {
            addCriterion("mail_smtp_port not between", value1, value2, "mailSmtpPort");
            return (Criteria) this;
        }

        public Criteria andMailAuthUserIsNull() {
            addCriterion("mail_auth_user is null");
            return (Criteria) this;
        }

        public Criteria andMailAuthUserIsNotNull() {
            addCriterion("mail_auth_user is not null");
            return (Criteria) this;
        }

        public Criteria andMailAuthUserEqualTo(String value) {
            addCriterion("mail_auth_user =", value, "mailAuthUser");
            return (Criteria) this;
        }

        public Criteria andMailAuthUserNotEqualTo(String value) {
            addCriterion("mail_auth_user <>", value, "mailAuthUser");
            return (Criteria) this;
        }

        public Criteria andMailAuthUserGreaterThan(String value) {
            addCriterion("mail_auth_user >", value, "mailAuthUser");
            return (Criteria) this;
        }

        public Criteria andMailAuthUserGreaterThanOrEqualTo(String value) {
            addCriterion("mail_auth_user >=", value, "mailAuthUser");
            return (Criteria) this;
        }

        public Criteria andMailAuthUserLessThan(String value) {
            addCriterion("mail_auth_user <", value, "mailAuthUser");
            return (Criteria) this;
        }

        public Criteria andMailAuthUserLessThanOrEqualTo(String value) {
            addCriterion("mail_auth_user <=", value, "mailAuthUser");
            return (Criteria) this;
        }

        public Criteria andMailAuthUserLike(String value) {
            addCriterion("mail_auth_user like", value, "mailAuthUser");
            return (Criteria) this;
        }

        public Criteria andMailAuthUserNotLike(String value) {
            addCriterion("mail_auth_user not like", value, "mailAuthUser");
            return (Criteria) this;
        }

        public Criteria andMailAuthUserIn(List<String> values) {
            addCriterion("mail_auth_user in", values, "mailAuthUser");
            return (Criteria) this;
        }

        public Criteria andMailAuthUserNotIn(List<String> values) {
            addCriterion("mail_auth_user not in", values, "mailAuthUser");
            return (Criteria) this;
        }

        public Criteria andMailAuthUserBetween(String value1, String value2) {
            addCriterion("mail_auth_user between", value1, value2, "mailAuthUser");
            return (Criteria) this;
        }

        public Criteria andMailAuthUserNotBetween(String value1, String value2) {
            addCriterion("mail_auth_user not between", value1, value2, "mailAuthUser");
            return (Criteria) this;
        }

        public Criteria andMailAuthPasswordIsNull() {
            addCriterion("mail_auth_password is null");
            return (Criteria) this;
        }

        public Criteria andMailAuthPasswordIsNotNull() {
            addCriterion("mail_auth_password is not null");
            return (Criteria) this;
        }

        public Criteria andMailAuthPasswordEqualTo(String value) {
            addCriterion("mail_auth_password =", value, "mailAuthPassword");
            return (Criteria) this;
        }

        public Criteria andMailAuthPasswordNotEqualTo(String value) {
            addCriterion("mail_auth_password <>", value, "mailAuthPassword");
            return (Criteria) this;
        }

        public Criteria andMailAuthPasswordGreaterThan(String value) {
            addCriterion("mail_auth_password >", value, "mailAuthPassword");
            return (Criteria) this;
        }

        public Criteria andMailAuthPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("mail_auth_password >=", value, "mailAuthPassword");
            return (Criteria) this;
        }

        public Criteria andMailAuthPasswordLessThan(String value) {
            addCriterion("mail_auth_password <", value, "mailAuthPassword");
            return (Criteria) this;
        }

        public Criteria andMailAuthPasswordLessThanOrEqualTo(String value) {
            addCriterion("mail_auth_password <=", value, "mailAuthPassword");
            return (Criteria) this;
        }

        public Criteria andMailAuthPasswordLike(String value) {
            addCriterion("mail_auth_password like", value, "mailAuthPassword");
            return (Criteria) this;
        }

        public Criteria andMailAuthPasswordNotLike(String value) {
            addCriterion("mail_auth_password not like", value, "mailAuthPassword");
            return (Criteria) this;
        }

        public Criteria andMailAuthPasswordIn(List<String> values) {
            addCriterion("mail_auth_password in", values, "mailAuthPassword");
            return (Criteria) this;
        }

        public Criteria andMailAuthPasswordNotIn(List<String> values) {
            addCriterion("mail_auth_password not in", values, "mailAuthPassword");
            return (Criteria) this;
        }

        public Criteria andMailAuthPasswordBetween(String value1, String value2) {
            addCriterion("mail_auth_password between", value1, value2, "mailAuthPassword");
            return (Criteria) this;
        }

        public Criteria andMailAuthPasswordNotBetween(String value1, String value2) {
            addCriterion("mail_auth_password not between", value1, value2, "mailAuthPassword");
            return (Criteria) this;
        }

        public Criteria andMailNameIsNull() {
            addCriterion("mail_name is null");
            return (Criteria) this;
        }

        public Criteria andMailNameIsNotNull() {
            addCriterion("mail_name is not null");
            return (Criteria) this;
        }

        public Criteria andMailNameEqualTo(String value) {
            addCriterion("mail_name =", value, "mailName");
            return (Criteria) this;
        }

        public Criteria andMailNameNotEqualTo(String value) {
            addCriterion("mail_name <>", value, "mailName");
            return (Criteria) this;
        }

        public Criteria andMailNameGreaterThan(String value) {
            addCriterion("mail_name >", value, "mailName");
            return (Criteria) this;
        }

        public Criteria andMailNameGreaterThanOrEqualTo(String value) {
            addCriterion("mail_name >=", value, "mailName");
            return (Criteria) this;
        }

        public Criteria andMailNameLessThan(String value) {
            addCriterion("mail_name <", value, "mailName");
            return (Criteria) this;
        }

        public Criteria andMailNameLessThanOrEqualTo(String value) {
            addCriterion("mail_name <=", value, "mailName");
            return (Criteria) this;
        }

        public Criteria andMailNameLike(String value) {
            addCriterion("mail_name like", value, "mailName");
            return (Criteria) this;
        }

        public Criteria andMailNameNotLike(String value) {
            addCriterion("mail_name not like", value, "mailName");
            return (Criteria) this;
        }

        public Criteria andMailNameIn(List<String> values) {
            addCriterion("mail_name in", values, "mailName");
            return (Criteria) this;
        }

        public Criteria andMailNameNotIn(List<String> values) {
            addCriterion("mail_name not in", values, "mailName");
            return (Criteria) this;
        }

        public Criteria andMailNameBetween(String value1, String value2) {
            addCriterion("mail_name between", value1, value2, "mailName");
            return (Criteria) this;
        }

        public Criteria andMailNameNotBetween(String value1, String value2) {
            addCriterion("mail_name not between", value1, value2, "mailName");
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