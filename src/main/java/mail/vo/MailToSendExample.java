package mail.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MailToSendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public MailToSendExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMailTitleIsNull() {
            addCriterion("mail_title is null");
            return (Criteria) this;
        }

        public Criteria andMailTitleIsNotNull() {
            addCriterion("mail_title is not null");
            return (Criteria) this;
        }

        public Criteria andMailTitleEqualTo(String value) {
            addCriterion("mail_title =", value, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleNotEqualTo(String value) {
            addCriterion("mail_title <>", value, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleGreaterThan(String value) {
            addCriterion("mail_title >", value, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleGreaterThanOrEqualTo(String value) {
            addCriterion("mail_title >=", value, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleLessThan(String value) {
            addCriterion("mail_title <", value, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleLessThanOrEqualTo(String value) {
            addCriterion("mail_title <=", value, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleLike(String value) {
            addCriterion("mail_title like", value, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleNotLike(String value) {
            addCriterion("mail_title not like", value, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleIn(List<String> values) {
            addCriterion("mail_title in", values, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleNotIn(List<String> values) {
            addCriterion("mail_title not in", values, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleBetween(String value1, String value2) {
            addCriterion("mail_title between", value1, value2, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailTitleNotBetween(String value1, String value2) {
            addCriterion("mail_title not between", value1, value2, "mailTitle");
            return (Criteria) this;
        }

        public Criteria andMailContextIsNull() {
            addCriterion("mail_context is null");
            return (Criteria) this;
        }

        public Criteria andMailContextIsNotNull() {
            addCriterion("mail_context is not null");
            return (Criteria) this;
        }

        public Criteria andMailContextEqualTo(String value) {
            addCriterion("mail_context =", value, "mailContext");
            return (Criteria) this;
        }

        public Criteria andMailContextNotEqualTo(String value) {
            addCriterion("mail_context <>", value, "mailContext");
            return (Criteria) this;
        }

        public Criteria andMailContextGreaterThan(String value) {
            addCriterion("mail_context >", value, "mailContext");
            return (Criteria) this;
        }

        public Criteria andMailContextGreaterThanOrEqualTo(String value) {
            addCriterion("mail_context >=", value, "mailContext");
            return (Criteria) this;
        }

        public Criteria andMailContextLessThan(String value) {
            addCriterion("mail_context <", value, "mailContext");
            return (Criteria) this;
        }

        public Criteria andMailContextLessThanOrEqualTo(String value) {
            addCriterion("mail_context <=", value, "mailContext");
            return (Criteria) this;
        }

        public Criteria andMailContextLike(String value) {
            addCriterion("mail_context like", value, "mailContext");
            return (Criteria) this;
        }

        public Criteria andMailContextNotLike(String value) {
            addCriterion("mail_context not like", value, "mailContext");
            return (Criteria) this;
        }

        public Criteria andMailContextIn(List<String> values) {
            addCriterion("mail_context in", values, "mailContext");
            return (Criteria) this;
        }

        public Criteria andMailContextNotIn(List<String> values) {
            addCriterion("mail_context not in", values, "mailContext");
            return (Criteria) this;
        }

        public Criteria andMailContextBetween(String value1, String value2) {
            addCriterion("mail_context between", value1, value2, "mailContext");
            return (Criteria) this;
        }

        public Criteria andMailContextNotBetween(String value1, String value2) {
            addCriterion("mail_context not between", value1, value2, "mailContext");
            return (Criteria) this;
        }

        public Criteria andTimeAddIsNull() {
            addCriterion("time_add is null");
            return (Criteria) this;
        }

        public Criteria andTimeAddIsNotNull() {
            addCriterion("time_add is not null");
            return (Criteria) this;
        }

        public Criteria andTimeAddEqualTo(Date value) {
            addCriterion("time_add =", value, "timeAdd");
            return (Criteria) this;
        }

        public Criteria andTimeAddNotEqualTo(Date value) {
            addCriterion("time_add <>", value, "timeAdd");
            return (Criteria) this;
        }

        public Criteria andTimeAddGreaterThan(Date value) {
            addCriterion("time_add >", value, "timeAdd");
            return (Criteria) this;
        }

        public Criteria andTimeAddGreaterThanOrEqualTo(Date value) {
            addCriterion("time_add >=", value, "timeAdd");
            return (Criteria) this;
        }

        public Criteria andTimeAddLessThan(Date value) {
            addCriterion("time_add <", value, "timeAdd");
            return (Criteria) this;
        }

        public Criteria andTimeAddLessThanOrEqualTo(Date value) {
            addCriterion("time_add <=", value, "timeAdd");
            return (Criteria) this;
        }

        public Criteria andTimeAddIn(List<Date> values) {
            addCriterion("time_add in", values, "timeAdd");
            return (Criteria) this;
        }

        public Criteria andTimeAddNotIn(List<Date> values) {
            addCriterion("time_add not in", values, "timeAdd");
            return (Criteria) this;
        }

        public Criteria andTimeAddBetween(Date value1, Date value2) {
            addCriterion("time_add between", value1, value2, "timeAdd");
            return (Criteria) this;
        }

        public Criteria andTimeAddNotBetween(Date value1, Date value2) {
            addCriterion("time_add not between", value1, value2, "timeAdd");
            return (Criteria) this;
        }

        public Criteria andTimeSendIsNull() {
            addCriterion("time_send is null");
            return (Criteria) this;
        }

        public Criteria andTimeSendIsNotNull() {
            addCriterion("time_send is not null");
            return (Criteria) this;
        }

        public Criteria andTimeSendEqualTo(Date value) {
            addCriterion("time_send =", value, "timeSend");
            return (Criteria) this;
        }

        public Criteria andTimeSendNotEqualTo(Date value) {
            addCriterion("time_send <>", value, "timeSend");
            return (Criteria) this;
        }

        public Criteria andTimeSendGreaterThan(Date value) {
            addCriterion("time_send >", value, "timeSend");
            return (Criteria) this;
        }

        public Criteria andTimeSendGreaterThanOrEqualTo(Date value) {
            addCriterion("time_send >=", value, "timeSend");
            return (Criteria) this;
        }

        public Criteria andTimeSendLessThan(Date value) {
            addCriterion("time_send <", value, "timeSend");
            return (Criteria) this;
        }

        public Criteria andTimeSendLessThanOrEqualTo(Date value) {
            addCriterion("time_send <=", value, "timeSend");
            return (Criteria) this;
        }

        public Criteria andTimeSendIn(List<Date> values) {
            addCriterion("time_send in", values, "timeSend");
            return (Criteria) this;
        }

        public Criteria andTimeSendNotIn(List<Date> values) {
            addCriterion("time_send not in", values, "timeSend");
            return (Criteria) this;
        }

        public Criteria andTimeSendBetween(Date value1, Date value2) {
            addCriterion("time_send between", value1, value2, "timeSend");
            return (Criteria) this;
        }

        public Criteria andTimeSendNotBetween(Date value1, Date value2) {
            addCriterion("time_send not between", value1, value2, "timeSend");
            return (Criteria) this;
        }

        public Criteria andMailStateIsNull() {
            addCriterion("mail_state is null");
            return (Criteria) this;
        }

        public Criteria andMailStateIsNotNull() {
            addCriterion("mail_state is not null");
            return (Criteria) this;
        }

        public Criteria andMailStateEqualTo(Integer value) {
            addCriterion("mail_state =", value, "mailState");
            return (Criteria) this;
        }

        public Criteria andMailStateNotEqualTo(Integer value) {
            addCriterion("mail_state <>", value, "mailState");
            return (Criteria) this;
        }

        public Criteria andMailStateGreaterThan(Integer value) {
            addCriterion("mail_state >", value, "mailState");
            return (Criteria) this;
        }

        public Criteria andMailStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("mail_state >=", value, "mailState");
            return (Criteria) this;
        }

        public Criteria andMailStateLessThan(Integer value) {
            addCriterion("mail_state <", value, "mailState");
            return (Criteria) this;
        }

        public Criteria andMailStateLessThanOrEqualTo(Integer value) {
            addCriterion("mail_state <=", value, "mailState");
            return (Criteria) this;
        }

        public Criteria andMailStateIn(List<Integer> values) {
            addCriterion("mail_state in", values, "mailState");
            return (Criteria) this;
        }

        public Criteria andMailStateNotIn(List<Integer> values) {
            addCriterion("mail_state not in", values, "mailState");
            return (Criteria) this;
        }

        public Criteria andMailStateBetween(Integer value1, Integer value2) {
            addCriterion("mail_state between", value1, value2, "mailState");
            return (Criteria) this;
        }

        public Criteria andMailStateNotBetween(Integer value1, Integer value2) {
            addCriterion("mail_state not between", value1, value2, "mailState");
            return (Criteria) this;
        }

        public Criteria andReceiveUseraddressIsNull() {
            addCriterion("receive_userAddress is null");
            return (Criteria) this;
        }

        public Criteria andReceiveUseraddressIsNotNull() {
            addCriterion("receive_userAddress is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveUseraddressEqualTo(String value) {
            addCriterion("receive_userAddress =", value, "receiveUseraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveUseraddressNotEqualTo(String value) {
            addCriterion("receive_userAddress <>", value, "receiveUseraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveUseraddressGreaterThan(String value) {
            addCriterion("receive_userAddress >", value, "receiveUseraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveUseraddressGreaterThanOrEqualTo(String value) {
            addCriterion("receive_userAddress >=", value, "receiveUseraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveUseraddressLessThan(String value) {
            addCriterion("receive_userAddress <", value, "receiveUseraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveUseraddressLessThanOrEqualTo(String value) {
            addCriterion("receive_userAddress <=", value, "receiveUseraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveUseraddressLike(String value) {
            addCriterion("receive_userAddress like", value, "receiveUseraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveUseraddressNotLike(String value) {
            addCriterion("receive_userAddress not like", value, "receiveUseraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveUseraddressIn(List<String> values) {
            addCriterion("receive_userAddress in", values, "receiveUseraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveUseraddressNotIn(List<String> values) {
            addCriterion("receive_userAddress not in", values, "receiveUseraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveUseraddressBetween(String value1, String value2) {
            addCriterion("receive_userAddress between", value1, value2, "receiveUseraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveUseraddressNotBetween(String value1, String value2) {
            addCriterion("receive_userAddress not between", value1, value2, "receiveUseraddress");
            return (Criteria) this;
        }

        public Criteria andSendUseraddressIsNull() {
            addCriterion("send_userAddress is null");
            return (Criteria) this;
        }

        public Criteria andSendUseraddressIsNotNull() {
            addCriterion("send_userAddress is not null");
            return (Criteria) this;
        }

        public Criteria andSendUseraddressEqualTo(String value) {
            addCriterion("send_userAddress =", value, "sendUseraddress");
            return (Criteria) this;
        }

        public Criteria andSendUseraddressNotEqualTo(String value) {
            addCriterion("send_userAddress <>", value, "sendUseraddress");
            return (Criteria) this;
        }

        public Criteria andSendUseraddressGreaterThan(String value) {
            addCriterion("send_userAddress >", value, "sendUseraddress");
            return (Criteria) this;
        }

        public Criteria andSendUseraddressGreaterThanOrEqualTo(String value) {
            addCriterion("send_userAddress >=", value, "sendUseraddress");
            return (Criteria) this;
        }

        public Criteria andSendUseraddressLessThan(String value) {
            addCriterion("send_userAddress <", value, "sendUseraddress");
            return (Criteria) this;
        }

        public Criteria andSendUseraddressLessThanOrEqualTo(String value) {
            addCriterion("send_userAddress <=", value, "sendUseraddress");
            return (Criteria) this;
        }

        public Criteria andSendUseraddressLike(String value) {
            addCriterion("send_userAddress like", value, "sendUseraddress");
            return (Criteria) this;
        }

        public Criteria andSendUseraddressNotLike(String value) {
            addCriterion("send_userAddress not like", value, "sendUseraddress");
            return (Criteria) this;
        }

        public Criteria andSendUseraddressIn(List<String> values) {
            addCriterion("send_userAddress in", values, "sendUseraddress");
            return (Criteria) this;
        }

        public Criteria andSendUseraddressNotIn(List<String> values) {
            addCriterion("send_userAddress not in", values, "sendUseraddress");
            return (Criteria) this;
        }

        public Criteria andSendUseraddressBetween(String value1, String value2) {
            addCriterion("send_userAddress between", value1, value2, "sendUseraddress");
            return (Criteria) this;
        }

        public Criteria andSendUseraddressNotBetween(String value1, String value2) {
            addCriterion("send_userAddress not between", value1, value2, "sendUseraddress");
            return (Criteria) this;
        }

        public Criteria andSendUseridIsNull() {
            addCriterion("send_userID is null");
            return (Criteria) this;
        }

        public Criteria andSendUseridIsNotNull() {
            addCriterion("send_userID is not null");
            return (Criteria) this;
        }

        public Criteria andSendUseridEqualTo(String value) {
            addCriterion("send_userID =", value, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridNotEqualTo(String value) {
            addCriterion("send_userID <>", value, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridGreaterThan(String value) {
            addCriterion("send_userID >", value, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridGreaterThanOrEqualTo(String value) {
            addCriterion("send_userID >=", value, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridLessThan(String value) {
            addCriterion("send_userID <", value, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridLessThanOrEqualTo(String value) {
            addCriterion("send_userID <=", value, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridLike(String value) {
            addCriterion("send_userID like", value, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridNotLike(String value) {
            addCriterion("send_userID not like", value, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridIn(List<String> values) {
            addCriterion("send_userID in", values, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridNotIn(List<String> values) {
            addCriterion("send_userID not in", values, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridBetween(String value1, String value2) {
            addCriterion("send_userID between", value1, value2, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridNotBetween(String value1, String value2) {
            addCriterion("send_userID not between", value1, value2, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andReceiveUseridIsNull() {
            addCriterion("receive_userID is null");
            return (Criteria) this;
        }

        public Criteria andReceiveUseridIsNotNull() {
            addCriterion("receive_userID is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveUseridEqualTo(String value) {
            addCriterion("receive_userID =", value, "receiveUserid");
            return (Criteria) this;
        }

        public Criteria andReceiveUseridNotEqualTo(String value) {
            addCriterion("receive_userID <>", value, "receiveUserid");
            return (Criteria) this;
        }

        public Criteria andReceiveUseridGreaterThan(String value) {
            addCriterion("receive_userID >", value, "receiveUserid");
            return (Criteria) this;
        }

        public Criteria andReceiveUseridGreaterThanOrEqualTo(String value) {
            addCriterion("receive_userID >=", value, "receiveUserid");
            return (Criteria) this;
        }

        public Criteria andReceiveUseridLessThan(String value) {
            addCriterion("receive_userID <", value, "receiveUserid");
            return (Criteria) this;
        }

        public Criteria andReceiveUseridLessThanOrEqualTo(String value) {
            addCriterion("receive_userID <=", value, "receiveUserid");
            return (Criteria) this;
        }

        public Criteria andReceiveUseridLike(String value) {
            addCriterion("receive_userID like", value, "receiveUserid");
            return (Criteria) this;
        }

        public Criteria andReceiveUseridNotLike(String value) {
            addCriterion("receive_userID not like", value, "receiveUserid");
            return (Criteria) this;
        }

        public Criteria andReceiveUseridIn(List<String> values) {
            addCriterion("receive_userID in", values, "receiveUserid");
            return (Criteria) this;
        }

        public Criteria andReceiveUseridNotIn(List<String> values) {
            addCriterion("receive_userID not in", values, "receiveUserid");
            return (Criteria) this;
        }

        public Criteria andReceiveUseridBetween(String value1, String value2) {
            addCriterion("receive_userID between", value1, value2, "receiveUserid");
            return (Criteria) this;
        }

        public Criteria andReceiveUseridNotBetween(String value1, String value2) {
            addCriterion("receive_userID not between", value1, value2, "receiveUserid");
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