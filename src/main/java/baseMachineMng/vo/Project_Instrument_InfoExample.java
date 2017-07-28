package baseMachineMng.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Project_Instrument_InfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public Project_Instrument_InfoExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGyxIdIsNull() {
            addCriterion("GYX_ID is null");
            return (Criteria) this;
        }

        public Criteria andGyxIdIsNotNull() {
            addCriterion("GYX_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGyxIdEqualTo(String value) {
            addCriterion("GYX_ID =", value, "gyxId");
            return (Criteria) this;
        }

        public Criteria andGyxIdNotEqualTo(String value) {
            addCriterion("GYX_ID <>", value, "gyxId");
            return (Criteria) this;
        }

        public Criteria andGyxIdGreaterThan(String value) {
            addCriterion("GYX_ID >", value, "gyxId");
            return (Criteria) this;
        }

        public Criteria andGyxIdGreaterThanOrEqualTo(String value) {
            addCriterion("GYX_ID >=", value, "gyxId");
            return (Criteria) this;
        }

        public Criteria andGyxIdLessThan(String value) {
            addCriterion("GYX_ID <", value, "gyxId");
            return (Criteria) this;
        }

        public Criteria andGyxIdLessThanOrEqualTo(String value) {
            addCriterion("GYX_ID <=", value, "gyxId");
            return (Criteria) this;
        }

        public Criteria andGyxIdLike(String value) {
            addCriterion("GYX_ID like", value, "gyxId");
            return (Criteria) this;
        }

        public Criteria andGyxIdNotLike(String value) {
            addCriterion("GYX_ID not like", value, "gyxId");
            return (Criteria) this;
        }

        public Criteria andGyxIdIn(List<String> values) {
            addCriterion("GYX_ID in", values, "gyxId");
            return (Criteria) this;
        }

        public Criteria andGyxIdNotIn(List<String> values) {
            addCriterion("GYX_ID not in", values, "gyxId");
            return (Criteria) this;
        }

        public Criteria andGyxIdBetween(String value1, String value2) {
            addCriterion("GYX_ID between", value1, value2, "gyxId");
            return (Criteria) this;
        }

        public Criteria andGyxIdNotBetween(String value1, String value2) {
            addCriterion("GYX_ID not between", value1, value2, "gyxId");
            return (Criteria) this;
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

        public Criteria andMachineNameIsNull() {
            addCriterion("MACHINE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMachineNameIsNotNull() {
            addCriterion("MACHINE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMachineNameEqualTo(String value) {
            addCriterion("MACHINE_NAME =", value, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameNotEqualTo(String value) {
            addCriterion("MACHINE_NAME <>", value, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameGreaterThan(String value) {
            addCriterion("MACHINE_NAME >", value, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameGreaterThanOrEqualTo(String value) {
            addCriterion("MACHINE_NAME >=", value, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameLessThan(String value) {
            addCriterion("MACHINE_NAME <", value, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameLessThanOrEqualTo(String value) {
            addCriterion("MACHINE_NAME <=", value, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameLike(String value) {
            addCriterion("MACHINE_NAME like", value, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameNotLike(String value) {
            addCriterion("MACHINE_NAME not like", value, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameIn(List<String> values) {
            addCriterion("MACHINE_NAME in", values, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameNotIn(List<String> values) {
            addCriterion("MACHINE_NAME not in", values, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameBetween(String value1, String value2) {
            addCriterion("MACHINE_NAME between", value1, value2, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameNotBetween(String value1, String value2) {
            addCriterion("MACHINE_NAME not between", value1, value2, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineTypeIsNull() {
            addCriterion("MACHINE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMachineTypeIsNotNull() {
            addCriterion("MACHINE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMachineTypeEqualTo(String value) {
            addCriterion("MACHINE_TYPE =", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeNotEqualTo(String value) {
            addCriterion("MACHINE_TYPE <>", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeGreaterThan(String value) {
            addCriterion("MACHINE_TYPE >", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MACHINE_TYPE >=", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeLessThan(String value) {
            addCriterion("MACHINE_TYPE <", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeLessThanOrEqualTo(String value) {
            addCriterion("MACHINE_TYPE <=", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeLike(String value) {
            addCriterion("MACHINE_TYPE like", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeNotLike(String value) {
            addCriterion("MACHINE_TYPE not like", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeIn(List<String> values) {
            addCriterion("MACHINE_TYPE in", values, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeNotIn(List<String> values) {
            addCriterion("MACHINE_TYPE not in", values, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeBetween(String value1, String value2) {
            addCriterion("MACHINE_TYPE between", value1, value2, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeNotBetween(String value1, String value2) {
            addCriterion("MACHINE_TYPE not between", value1, value2, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineSizeIsNull() {
            addCriterion("MACHINE_SIZE is null");
            return (Criteria) this;
        }

        public Criteria andMachineSizeIsNotNull() {
            addCriterion("MACHINE_SIZE is not null");
            return (Criteria) this;
        }

        public Criteria andMachineSizeEqualTo(String value) {
            addCriterion("MACHINE_SIZE =", value, "machineSize");
            return (Criteria) this;
        }

        public Criteria andMachineSizeNotEqualTo(String value) {
            addCriterion("MACHINE_SIZE <>", value, "machineSize");
            return (Criteria) this;
        }

        public Criteria andMachineSizeGreaterThan(String value) {
            addCriterion("MACHINE_SIZE >", value, "machineSize");
            return (Criteria) this;
        }

        public Criteria andMachineSizeGreaterThanOrEqualTo(String value) {
            addCriterion("MACHINE_SIZE >=", value, "machineSize");
            return (Criteria) this;
        }

        public Criteria andMachineSizeLessThan(String value) {
            addCriterion("MACHINE_SIZE <", value, "machineSize");
            return (Criteria) this;
        }

        public Criteria andMachineSizeLessThanOrEqualTo(String value) {
            addCriterion("MACHINE_SIZE <=", value, "machineSize");
            return (Criteria) this;
        }

        public Criteria andMachineSizeLike(String value) {
            addCriterion("MACHINE_SIZE like", value, "machineSize");
            return (Criteria) this;
        }

        public Criteria andMachineSizeNotLike(String value) {
            addCriterion("MACHINE_SIZE not like", value, "machineSize");
            return (Criteria) this;
        }

        public Criteria andMachineSizeIn(List<String> values) {
            addCriterion("MACHINE_SIZE in", values, "machineSize");
            return (Criteria) this;
        }

        public Criteria andMachineSizeNotIn(List<String> values) {
            addCriterion("MACHINE_SIZE not in", values, "machineSize");
            return (Criteria) this;
        }

        public Criteria andMachineSizeBetween(String value1, String value2) {
            addCriterion("MACHINE_SIZE between", value1, value2, "machineSize");
            return (Criteria) this;
        }

        public Criteria andMachineSizeNotBetween(String value1, String value2) {
            addCriterion("MACHINE_SIZE not between", value1, value2, "machineSize");
            return (Criteria) this;
        }

        public Criteria andRangeJingduIsNull() {
            addCriterion("RANGE_JINGDU is null");
            return (Criteria) this;
        }

        public Criteria andRangeJingduIsNotNull() {
            addCriterion("RANGE_JINGDU is not null");
            return (Criteria) this;
        }

        public Criteria andRangeJingduEqualTo(String value) {
            addCriterion("RANGE_JINGDU =", value, "rangeJingdu");
            return (Criteria) this;
        }

        public Criteria andRangeJingduNotEqualTo(String value) {
            addCriterion("RANGE_JINGDU <>", value, "rangeJingdu");
            return (Criteria) this;
        }

        public Criteria andRangeJingduGreaterThan(String value) {
            addCriterion("RANGE_JINGDU >", value, "rangeJingdu");
            return (Criteria) this;
        }

        public Criteria andRangeJingduGreaterThanOrEqualTo(String value) {
            addCriterion("RANGE_JINGDU >=", value, "rangeJingdu");
            return (Criteria) this;
        }

        public Criteria andRangeJingduLessThan(String value) {
            addCriterion("RANGE_JINGDU <", value, "rangeJingdu");
            return (Criteria) this;
        }

        public Criteria andRangeJingduLessThanOrEqualTo(String value) {
            addCriterion("RANGE_JINGDU <=", value, "rangeJingdu");
            return (Criteria) this;
        }

        public Criteria andRangeJingduLike(String value) {
            addCriterion("RANGE_JINGDU like", value, "rangeJingdu");
            return (Criteria) this;
        }

        public Criteria andRangeJingduNotLike(String value) {
            addCriterion("RANGE_JINGDU not like", value, "rangeJingdu");
            return (Criteria) this;
        }

        public Criteria andRangeJingduIn(List<String> values) {
            addCriterion("RANGE_JINGDU in", values, "rangeJingdu");
            return (Criteria) this;
        }

        public Criteria andRangeJingduNotIn(List<String> values) {
            addCriterion("RANGE_JINGDU not in", values, "rangeJingdu");
            return (Criteria) this;
        }

        public Criteria andRangeJingduBetween(String value1, String value2) {
            addCriterion("RANGE_JINGDU between", value1, value2, "rangeJingdu");
            return (Criteria) this;
        }

        public Criteria andRangeJingduNotBetween(String value1, String value2) {
            addCriterion("RANGE_JINGDU not between", value1, value2, "rangeJingdu");
            return (Criteria) this;
        }

        public Criteria andProducerOrdIsNull() {
            addCriterion("PRODUCER_ORD is null");
            return (Criteria) this;
        }

        public Criteria andProducerOrdIsNotNull() {
            addCriterion("PRODUCER_ORD is not null");
            return (Criteria) this;
        }

        public Criteria andProducerOrdEqualTo(String value) {
            addCriterion("PRODUCER_ORD =", value, "producerOrd");
            return (Criteria) this;
        }

        public Criteria andProducerOrdNotEqualTo(String value) {
            addCriterion("PRODUCER_ORD <>", value, "producerOrd");
            return (Criteria) this;
        }

        public Criteria andProducerOrdGreaterThan(String value) {
            addCriterion("PRODUCER_ORD >", value, "producerOrd");
            return (Criteria) this;
        }

        public Criteria andProducerOrdGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCER_ORD >=", value, "producerOrd");
            return (Criteria) this;
        }

        public Criteria andProducerOrdLessThan(String value) {
            addCriterion("PRODUCER_ORD <", value, "producerOrd");
            return (Criteria) this;
        }

        public Criteria andProducerOrdLessThanOrEqualTo(String value) {
            addCriterion("PRODUCER_ORD <=", value, "producerOrd");
            return (Criteria) this;
        }

        public Criteria andProducerOrdLike(String value) {
            addCriterion("PRODUCER_ORD like", value, "producerOrd");
            return (Criteria) this;
        }

        public Criteria andProducerOrdNotLike(String value) {
            addCriterion("PRODUCER_ORD not like", value, "producerOrd");
            return (Criteria) this;
        }

        public Criteria andProducerOrdIn(List<String> values) {
            addCriterion("PRODUCER_ORD in", values, "producerOrd");
            return (Criteria) this;
        }

        public Criteria andProducerOrdNotIn(List<String> values) {
            addCriterion("PRODUCER_ORD not in", values, "producerOrd");
            return (Criteria) this;
        }

        public Criteria andProducerOrdBetween(String value1, String value2) {
            addCriterion("PRODUCER_ORD between", value1, value2, "producerOrd");
            return (Criteria) this;
        }

        public Criteria andProducerOrdNotBetween(String value1, String value2) {
            addCriterion("PRODUCER_ORD not between", value1, value2, "producerOrd");
            return (Criteria) this;
        }

        public Criteria andMachineStateIsNull() {
            addCriterion("MACHINE_STATE is null");
            return (Criteria) this;
        }

        public Criteria andMachineStateIsNotNull() {
            addCriterion("MACHINE_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andMachineStateEqualTo(String value) {
            addCriterion("MACHINE_STATE =", value, "machineState");
            return (Criteria) this;
        }

        public Criteria andMachineStateNotEqualTo(String value) {
            addCriterion("MACHINE_STATE <>", value, "machineState");
            return (Criteria) this;
        }

        public Criteria andMachineStateGreaterThan(String value) {
            addCriterion("MACHINE_STATE >", value, "machineState");
            return (Criteria) this;
        }

        public Criteria andMachineStateGreaterThanOrEqualTo(String value) {
            addCriterion("MACHINE_STATE >=", value, "machineState");
            return (Criteria) this;
        }

        public Criteria andMachineStateLessThan(String value) {
            addCriterion("MACHINE_STATE <", value, "machineState");
            return (Criteria) this;
        }

        public Criteria andMachineStateLessThanOrEqualTo(String value) {
            addCriterion("MACHINE_STATE <=", value, "machineState");
            return (Criteria) this;
        }

        public Criteria andMachineStateLike(String value) {
            addCriterion("MACHINE_STATE like", value, "machineState");
            return (Criteria) this;
        }

        public Criteria andMachineStateNotLike(String value) {
            addCriterion("MACHINE_STATE not like", value, "machineState");
            return (Criteria) this;
        }

        public Criteria andMachineStateIn(List<String> values) {
            addCriterion("MACHINE_STATE in", values, "machineState");
            return (Criteria) this;
        }

        public Criteria andMachineStateNotIn(List<String> values) {
            addCriterion("MACHINE_STATE not in", values, "machineState");
            return (Criteria) this;
        }

        public Criteria andMachineStateBetween(String value1, String value2) {
            addCriterion("MACHINE_STATE between", value1, value2, "machineState");
            return (Criteria) this;
        }

        public Criteria andMachineStateNotBetween(String value1, String value2) {
            addCriterion("MACHINE_STATE not between", value1, value2, "machineState");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("UNIT is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("UNIT =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("UNIT <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("UNIT >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("UNIT >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("UNIT <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("UNIT <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("UNIT like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("UNIT not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("UNIT in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("UNIT not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("UNIT between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("UNIT not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andProducerIsNull() {
            addCriterion("PRODUCER is null");
            return (Criteria) this;
        }

        public Criteria andProducerIsNotNull() {
            addCriterion("PRODUCER is not null");
            return (Criteria) this;
        }

        public Criteria andProducerEqualTo(String value) {
            addCriterion("PRODUCER =", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerNotEqualTo(String value) {
            addCriterion("PRODUCER <>", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerGreaterThan(String value) {
            addCriterion("PRODUCER >", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCER >=", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerLessThan(String value) {
            addCriterion("PRODUCER <", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerLessThanOrEqualTo(String value) {
            addCriterion("PRODUCER <=", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerLike(String value) {
            addCriterion("PRODUCER like", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerNotLike(String value) {
            addCriterion("PRODUCER not like", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerIn(List<String> values) {
            addCriterion("PRODUCER in", values, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerNotIn(List<String> values) {
            addCriterion("PRODUCER not in", values, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerBetween(String value1, String value2) {
            addCriterion("PRODUCER between", value1, value2, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerNotBetween(String value1, String value2) {
            addCriterion("PRODUCER not between", value1, value2, "producer");
            return (Criteria) this;
        }

        public Criteria andOldNewIsNull() {
            addCriterion("OLD_NEW is null");
            return (Criteria) this;
        }

        public Criteria andOldNewIsNotNull() {
            addCriterion("OLD_NEW is not null");
            return (Criteria) this;
        }

        public Criteria andOldNewEqualTo(String value) {
            addCriterion("OLD_NEW =", value, "oldNew");
            return (Criteria) this;
        }

        public Criteria andOldNewNotEqualTo(String value) {
            addCriterion("OLD_NEW <>", value, "oldNew");
            return (Criteria) this;
        }

        public Criteria andOldNewGreaterThan(String value) {
            addCriterion("OLD_NEW >", value, "oldNew");
            return (Criteria) this;
        }

        public Criteria andOldNewGreaterThanOrEqualTo(String value) {
            addCriterion("OLD_NEW >=", value, "oldNew");
            return (Criteria) this;
        }

        public Criteria andOldNewLessThan(String value) {
            addCriterion("OLD_NEW <", value, "oldNew");
            return (Criteria) this;
        }

        public Criteria andOldNewLessThanOrEqualTo(String value) {
            addCriterion("OLD_NEW <=", value, "oldNew");
            return (Criteria) this;
        }

        public Criteria andOldNewLike(String value) {
            addCriterion("OLD_NEW like", value, "oldNew");
            return (Criteria) this;
        }

        public Criteria andOldNewNotLike(String value) {
            addCriterion("OLD_NEW not like", value, "oldNew");
            return (Criteria) this;
        }

        public Criteria andOldNewIn(List<String> values) {
            addCriterion("OLD_NEW in", values, "oldNew");
            return (Criteria) this;
        }

        public Criteria andOldNewNotIn(List<String> values) {
            addCriterion("OLD_NEW not in", values, "oldNew");
            return (Criteria) this;
        }

        public Criteria andOldNewBetween(String value1, String value2) {
            addCriterion("OLD_NEW between", value1, value2, "oldNew");
            return (Criteria) this;
        }

        public Criteria andOldNewNotBetween(String value1, String value2) {
            addCriterion("OLD_NEW not between", value1, value2, "oldNew");
            return (Criteria) this;
        }

        public Criteria andSendDateIsNull() {
            addCriterion("SEND_DATE is null");
            return (Criteria) this;
        }

        public Criteria andSendDateIsNotNull() {
            addCriterion("SEND_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andSendDateEqualTo(Date value) {
            addCriterion("SEND_DATE =", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateNotEqualTo(Date value) {
            addCriterion("SEND_DATE <>", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateGreaterThan(Date value) {
            addCriterion("SEND_DATE >", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateGreaterThanOrEqualTo(Date value) {
            addCriterion("SEND_DATE >=", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateLessThan(Date value) {
            addCriterion("SEND_DATE <", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateLessThanOrEqualTo(Date value) {
            addCriterion("SEND_DATE <=", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateIn(List<Date> values) {
            addCriterion("SEND_DATE in", values, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateNotIn(List<Date> values) {
            addCriterion("SEND_DATE not in", values, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateBetween(Date value1, Date value2) {
            addCriterion("SEND_DATE between", value1, value2, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateNotBetween(Date value1, Date value2) {
            addCriterion("SEND_DATE not between", value1, value2, "sendDate");
            return (Criteria) this;
        }

        public Criteria andImportDateIsNull() {
            addCriterion("IMPORT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andImportDateIsNotNull() {
            addCriterion("IMPORT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andImportDateEqualTo(Date value) {
            addCriterion("IMPORT_DATE =", value, "importDate");
            return (Criteria) this;
        }

        public Criteria andImportDateNotEqualTo(Date value) {
            addCriterion("IMPORT_DATE <>", value, "importDate");
            return (Criteria) this;
        }

        public Criteria andImportDateGreaterThan(Date value) {
            addCriterion("IMPORT_DATE >", value, "importDate");
            return (Criteria) this;
        }

        public Criteria andImportDateGreaterThanOrEqualTo(Date value) {
            addCriterion("IMPORT_DATE >=", value, "importDate");
            return (Criteria) this;
        }

        public Criteria andImportDateLessThan(Date value) {
            addCriterion("IMPORT_DATE <", value, "importDate");
            return (Criteria) this;
        }

        public Criteria andImportDateLessThanOrEqualTo(Date value) {
            addCriterion("IMPORT_DATE <=", value, "importDate");
            return (Criteria) this;
        }

        public Criteria andImportDateIn(List<Date> values) {
            addCriterion("IMPORT_DATE in", values, "importDate");
            return (Criteria) this;
        }

        public Criteria andImportDateNotIn(List<Date> values) {
            addCriterion("IMPORT_DATE not in", values, "importDate");
            return (Criteria) this;
        }

        public Criteria andImportDateBetween(Date value1, Date value2) {
            addCriterion("IMPORT_DATE between", value1, value2, "importDate");
            return (Criteria) this;
        }

        public Criteria andImportDateNotBetween(Date value1, Date value2) {
            addCriterion("IMPORT_DATE not between", value1, value2, "importDate");
            return (Criteria) this;
        }

        public Criteria andInstallDateIsNull() {
            addCriterion("INSTALL_DATE is null");
            return (Criteria) this;
        }

        public Criteria andInstallDateIsNotNull() {
            addCriterion("INSTALL_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andInstallDateEqualTo(Date value) {
            addCriterion("INSTALL_DATE =", value, "installDate");
            return (Criteria) this;
        }

        public Criteria andInstallDateNotEqualTo(Date value) {
            addCriterion("INSTALL_DATE <>", value, "installDate");
            return (Criteria) this;
        }

        public Criteria andInstallDateGreaterThan(Date value) {
            addCriterion("INSTALL_DATE >", value, "installDate");
            return (Criteria) this;
        }

        public Criteria andInstallDateGreaterThanOrEqualTo(Date value) {
            addCriterion("INSTALL_DATE >=", value, "installDate");
            return (Criteria) this;
        }

        public Criteria andInstallDateLessThan(Date value) {
            addCriterion("INSTALL_DATE <", value, "installDate");
            return (Criteria) this;
        }

        public Criteria andInstallDateLessThanOrEqualTo(Date value) {
            addCriterion("INSTALL_DATE <=", value, "installDate");
            return (Criteria) this;
        }

        public Criteria andInstallDateIn(List<Date> values) {
            addCriterion("INSTALL_DATE in", values, "installDate");
            return (Criteria) this;
        }

        public Criteria andInstallDateNotIn(List<Date> values) {
            addCriterion("INSTALL_DATE not in", values, "installDate");
            return (Criteria) this;
        }

        public Criteria andInstallDateBetween(Date value1, Date value2) {
            addCriterion("INSTALL_DATE between", value1, value2, "installDate");
            return (Criteria) this;
        }

        public Criteria andInstallDateNotBetween(Date value1, Date value2) {
            addCriterion("INSTALL_DATE not between", value1, value2, "installDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateIsNull() {
            addCriterion("CHECK_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCheckDateIsNotNull() {
            addCriterion("CHECK_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCheckDateEqualTo(Date value) {
            addCriterion("CHECK_DATE =", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotEqualTo(Date value) {
            addCriterion("CHECK_DATE <>", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateGreaterThan(Date value) {
            addCriterion("CHECK_DATE >", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CHECK_DATE >=", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateLessThan(Date value) {
            addCriterion("CHECK_DATE <", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateLessThanOrEqualTo(Date value) {
            addCriterion("CHECK_DATE <=", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateIn(List<Date> values) {
            addCriterion("CHECK_DATE in", values, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotIn(List<Date> values) {
            addCriterion("CHECK_DATE not in", values, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateBetween(Date value1, Date value2) {
            addCriterion("CHECK_DATE between", value1, value2, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotBetween(Date value1, Date value2) {
            addCriterion("CHECK_DATE not between", value1, value2, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodIsNull() {
            addCriterion("CHECK_PERIOD is null");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodIsNotNull() {
            addCriterion("CHECK_PERIOD is not null");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodEqualTo(String value) {
            addCriterion("CHECK_PERIOD =", value, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodNotEqualTo(String value) {
            addCriterion("CHECK_PERIOD <>", value, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodGreaterThan(String value) {
            addCriterion("CHECK_PERIOD >", value, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_PERIOD >=", value, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodLessThan(String value) {
            addCriterion("CHECK_PERIOD <", value, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodLessThanOrEqualTo(String value) {
            addCriterion("CHECK_PERIOD <=", value, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodLike(String value) {
            addCriterion("CHECK_PERIOD like", value, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodNotLike(String value) {
            addCriterion("CHECK_PERIOD not like", value, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodIn(List<String> values) {
            addCriterion("CHECK_PERIOD in", values, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodNotIn(List<String> values) {
            addCriterion("CHECK_PERIOD not in", values, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodBetween(String value1, String value2) {
            addCriterion("CHECK_PERIOD between", value1, value2, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodNotBetween(String value1, String value2) {
            addCriterion("CHECK_PERIOD not between", value1, value2, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andBaozhiqiIsNull() {
            addCriterion("BAOZHIQI is null");
            return (Criteria) this;
        }

        public Criteria andBaozhiqiIsNotNull() {
            addCriterion("BAOZHIQI is not null");
            return (Criteria) this;
        }

        public Criteria andBaozhiqiEqualTo(Date value) {
            addCriterion("BAOZHIQI =", value, "baozhiqi");
            return (Criteria) this;
        }

        public Criteria andBaozhiqiNotEqualTo(Date value) {
            addCriterion("BAOZHIQI <>", value, "baozhiqi");
            return (Criteria) this;
        }

        public Criteria andBaozhiqiGreaterThan(Date value) {
            addCriterion("BAOZHIQI >", value, "baozhiqi");
            return (Criteria) this;
        }

        public Criteria andBaozhiqiGreaterThanOrEqualTo(Date value) {
            addCriterion("BAOZHIQI >=", value, "baozhiqi");
            return (Criteria) this;
        }

        public Criteria andBaozhiqiLessThan(Date value) {
            addCriterion("BAOZHIQI <", value, "baozhiqi");
            return (Criteria) this;
        }

        public Criteria andBaozhiqiLessThanOrEqualTo(Date value) {
            addCriterion("BAOZHIQI <=", value, "baozhiqi");
            return (Criteria) this;
        }

        public Criteria andBaozhiqiIn(List<Date> values) {
            addCriterion("BAOZHIQI in", values, "baozhiqi");
            return (Criteria) this;
        }

        public Criteria andBaozhiqiNotIn(List<Date> values) {
            addCriterion("BAOZHIQI not in", values, "baozhiqi");
            return (Criteria) this;
        }

        public Criteria andBaozhiqiBetween(Date value1, Date value2) {
            addCriterion("BAOZHIQI between", value1, value2, "baozhiqi");
            return (Criteria) this;
        }

        public Criteria andBaozhiqiNotBetween(Date value1, Date value2) {
            addCriterion("BAOZHIQI not between", value1, value2, "baozhiqi");
            return (Criteria) this;
        }

        public Criteria andRepairNumIsNull() {
            addCriterion("REPAIR_NUM is null");
            return (Criteria) this;
        }

        public Criteria andRepairNumIsNotNull() {
            addCriterion("REPAIR_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andRepairNumEqualTo(Integer value) {
            addCriterion("REPAIR_NUM =", value, "repairNum");
            return (Criteria) this;
        }

        public Criteria andRepairNumNotEqualTo(Integer value) {
            addCriterion("REPAIR_NUM <>", value, "repairNum");
            return (Criteria) this;
        }

        public Criteria andRepairNumGreaterThan(Integer value) {
            addCriterion("REPAIR_NUM >", value, "repairNum");
            return (Criteria) this;
        }

        public Criteria andRepairNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("REPAIR_NUM >=", value, "repairNum");
            return (Criteria) this;
        }

        public Criteria andRepairNumLessThan(Integer value) {
            addCriterion("REPAIR_NUM <", value, "repairNum");
            return (Criteria) this;
        }

        public Criteria andRepairNumLessThanOrEqualTo(Integer value) {
            addCriterion("REPAIR_NUM <=", value, "repairNum");
            return (Criteria) this;
        }

        public Criteria andRepairNumIn(List<Integer> values) {
            addCriterion("REPAIR_NUM in", values, "repairNum");
            return (Criteria) this;
        }

        public Criteria andRepairNumNotIn(List<Integer> values) {
            addCriterion("REPAIR_NUM not in", values, "repairNum");
            return (Criteria) this;
        }

        public Criteria andRepairNumBetween(Integer value1, Integer value2) {
            addCriterion("REPAIR_NUM between", value1, value2, "repairNum");
            return (Criteria) this;
        }

        public Criteria andRepairNumNotBetween(Integer value1, Integer value2) {
            addCriterion("REPAIR_NUM not between", value1, value2, "repairNum");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNull() {
            addCriterion("UNIT_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNotNull() {
            addCriterion("UNIT_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceEqualTo(Double value) {
            addCriterion("UNIT_PRICE =", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotEqualTo(Double value) {
            addCriterion("UNIT_PRICE <>", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThan(Double value) {
            addCriterion("UNIT_PRICE >", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("UNIT_PRICE >=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThan(Double value) {
            addCriterion("UNIT_PRICE <", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThanOrEqualTo(Double value) {
            addCriterion("UNIT_PRICE <=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIn(List<Double> values) {
            addCriterion("UNIT_PRICE in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotIn(List<Double> values) {
            addCriterion("UNIT_PRICE not in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceBetween(Double value1, Double value2) {
            addCriterion("UNIT_PRICE between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotBetween(Double value1, Double value2) {
            addCriterion("UNIT_PRICE not between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andMachineClassifyIsNull() {
            addCriterion("MACHINE_CLASSIFY is null");
            return (Criteria) this;
        }

        public Criteria andMachineClassifyIsNotNull() {
            addCriterion("MACHINE_CLASSIFY is not null");
            return (Criteria) this;
        }

        public Criteria andMachineClassifyEqualTo(String value) {
            addCriterion("MACHINE_CLASSIFY =", value, "machineClassify");
            return (Criteria) this;
        }

        public Criteria andMachineClassifyNotEqualTo(String value) {
            addCriterion("MACHINE_CLASSIFY <>", value, "machineClassify");
            return (Criteria) this;
        }

        public Criteria andMachineClassifyGreaterThan(String value) {
            addCriterion("MACHINE_CLASSIFY >", value, "machineClassify");
            return (Criteria) this;
        }

        public Criteria andMachineClassifyGreaterThanOrEqualTo(String value) {
            addCriterion("MACHINE_CLASSIFY >=", value, "machineClassify");
            return (Criteria) this;
        }

        public Criteria andMachineClassifyLessThan(String value) {
            addCriterion("MACHINE_CLASSIFY <", value, "machineClassify");
            return (Criteria) this;
        }

        public Criteria andMachineClassifyLessThanOrEqualTo(String value) {
            addCriterion("MACHINE_CLASSIFY <=", value, "machineClassify");
            return (Criteria) this;
        }

        public Criteria andMachineClassifyLike(String value) {
            addCriterion("MACHINE_CLASSIFY like", value, "machineClassify");
            return (Criteria) this;
        }

        public Criteria andMachineClassifyNotLike(String value) {
            addCriterion("MACHINE_CLASSIFY not like", value, "machineClassify");
            return (Criteria) this;
        }

        public Criteria andMachineClassifyIn(List<String> values) {
            addCriterion("MACHINE_CLASSIFY in", values, "machineClassify");
            return (Criteria) this;
        }

        public Criteria andMachineClassifyNotIn(List<String> values) {
            addCriterion("MACHINE_CLASSIFY not in", values, "machineClassify");
            return (Criteria) this;
        }

        public Criteria andMachineClassifyBetween(String value1, String value2) {
            addCriterion("MACHINE_CLASSIFY between", value1, value2, "machineClassify");
            return (Criteria) this;
        }

        public Criteria andMachineClassifyNotBetween(String value1, String value2) {
            addCriterion("MACHINE_CLASSIFY not between", value1, value2, "machineClassify");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
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