package com.wsfzsc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IndentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IndentExample() {
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

        public Criteria andIndentIdIsNull() {
            addCriterion("indent_id is null");
            return (Criteria) this;
        }

        public Criteria andIndentIdIsNotNull() {
            addCriterion("indent_id is not null");
            return (Criteria) this;
        }

        public Criteria andIndentIdEqualTo(Integer value) {
            addCriterion("indent_id =", value, "indentId");
            return (Criteria) this;
        }

        public Criteria andIndentIdNotEqualTo(Integer value) {
            addCriterion("indent_id <>", value, "indentId");
            return (Criteria) this;
        }

        public Criteria andIndentIdGreaterThan(Integer value) {
            addCriterion("indent_id >", value, "indentId");
            return (Criteria) this;
        }

        public Criteria andIndentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("indent_id >=", value, "indentId");
            return (Criteria) this;
        }

        public Criteria andIndentIdLessThan(Integer value) {
            addCriterion("indent_id <", value, "indentId");
            return (Criteria) this;
        }

        public Criteria andIndentIdLessThanOrEqualTo(Integer value) {
            addCriterion("indent_id <=", value, "indentId");
            return (Criteria) this;
        }

        public Criteria andIndentIdIn(List<Integer> values) {
            addCriterion("indent_id in", values, "indentId");
            return (Criteria) this;
        }

        public Criteria andIndentIdNotIn(List<Integer> values) {
            addCriterion("indent_id not in", values, "indentId");
            return (Criteria) this;
        }

        public Criteria andIndentIdBetween(Integer value1, Integer value2) {
            addCriterion("indent_id between", value1, value2, "indentId");
            return (Criteria) this;
        }

        public Criteria andIndentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("indent_id not between", value1, value2, "indentId");
            return (Criteria) this;
        }

        public Criteria andIndentUserIdIsNull() {
            addCriterion("indent_user_id is null");
            return (Criteria) this;
        }

        public Criteria andIndentUserIdIsNotNull() {
            addCriterion("indent_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andIndentUserIdEqualTo(Integer value) {
            addCriterion("indent_user_id =", value, "indentUserId");
            return (Criteria) this;
        }

        public Criteria andIndentUserIdNotEqualTo(Integer value) {
            addCriterion("indent_user_id <>", value, "indentUserId");
            return (Criteria) this;
        }

        public Criteria andIndentUserIdGreaterThan(Integer value) {
            addCriterion("indent_user_id >", value, "indentUserId");
            return (Criteria) this;
        }

        public Criteria andIndentUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("indent_user_id >=", value, "indentUserId");
            return (Criteria) this;
        }

        public Criteria andIndentUserIdLessThan(Integer value) {
            addCriterion("indent_user_id <", value, "indentUserId");
            return (Criteria) this;
        }

        public Criteria andIndentUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("indent_user_id <=", value, "indentUserId");
            return (Criteria) this;
        }

        public Criteria andIndentUserIdIn(List<Integer> values) {
            addCriterion("indent_user_id in", values, "indentUserId");
            return (Criteria) this;
        }

        public Criteria andIndentUserIdNotIn(List<Integer> values) {
            addCriterion("indent_user_id not in", values, "indentUserId");
            return (Criteria) this;
        }

        public Criteria andIndentUserIdBetween(Integer value1, Integer value2) {
            addCriterion("indent_user_id between", value1, value2, "indentUserId");
            return (Criteria) this;
        }

        public Criteria andIndentUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("indent_user_id not between", value1, value2, "indentUserId");
            return (Criteria) this;
        }

        public Criteria andIndentRecIdIsNull() {
            addCriterion("indent_rec_id is null");
            return (Criteria) this;
        }

        public Criteria andIndentRecIdIsNotNull() {
            addCriterion("indent_rec_id is not null");
            return (Criteria) this;
        }

        public Criteria andIndentRecIdEqualTo(Integer value) {
            addCriterion("indent_rec_id =", value, "indentRecId");
            return (Criteria) this;
        }

        public Criteria andIndentRecIdNotEqualTo(Integer value) {
            addCriterion("indent_rec_id <>", value, "indentRecId");
            return (Criteria) this;
        }

        public Criteria andIndentRecIdGreaterThan(Integer value) {
            addCriterion("indent_rec_id >", value, "indentRecId");
            return (Criteria) this;
        }

        public Criteria andIndentRecIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("indent_rec_id >=", value, "indentRecId");
            return (Criteria) this;
        }

        public Criteria andIndentRecIdLessThan(Integer value) {
            addCriterion("indent_rec_id <", value, "indentRecId");
            return (Criteria) this;
        }

        public Criteria andIndentRecIdLessThanOrEqualTo(Integer value) {
            addCriterion("indent_rec_id <=", value, "indentRecId");
            return (Criteria) this;
        }

        public Criteria andIndentRecIdIn(List<Integer> values) {
            addCriterion("indent_rec_id in", values, "indentRecId");
            return (Criteria) this;
        }

        public Criteria andIndentRecIdNotIn(List<Integer> values) {
            addCriterion("indent_rec_id not in", values, "indentRecId");
            return (Criteria) this;
        }

        public Criteria andIndentRecIdBetween(Integer value1, Integer value2) {
            addCriterion("indent_rec_id between", value1, value2, "indentRecId");
            return (Criteria) this;
        }

        public Criteria andIndentRecIdNotBetween(Integer value1, Integer value2) {
            addCriterion("indent_rec_id not between", value1, value2, "indentRecId");
            return (Criteria) this;
        }

        public Criteria andIndentStatusIsNull() {
            addCriterion("indent_status is null");
            return (Criteria) this;
        }

        public Criteria andIndentStatusIsNotNull() {
            addCriterion("indent_status is not null");
            return (Criteria) this;
        }

        public Criteria andIndentStatusEqualTo(Integer value) {
            addCriterion("indent_status =", value, "indentStatus");
            return (Criteria) this;
        }

        public Criteria andIndentStatusNotEqualTo(Integer value) {
            addCriterion("indent_status <>", value, "indentStatus");
            return (Criteria) this;
        }

        public Criteria andIndentStatusGreaterThan(Integer value) {
            addCriterion("indent_status >", value, "indentStatus");
            return (Criteria) this;
        }

        public Criteria andIndentStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("indent_status >=", value, "indentStatus");
            return (Criteria) this;
        }

        public Criteria andIndentStatusLessThan(Integer value) {
            addCriterion("indent_status <", value, "indentStatus");
            return (Criteria) this;
        }

        public Criteria andIndentStatusLessThanOrEqualTo(Integer value) {
            addCriterion("indent_status <=", value, "indentStatus");
            return (Criteria) this;
        }

        public Criteria andIndentStatusIn(List<Integer> values) {
            addCriterion("indent_status in", values, "indentStatus");
            return (Criteria) this;
        }

        public Criteria andIndentStatusNotIn(List<Integer> values) {
            addCriterion("indent_status not in", values, "indentStatus");
            return (Criteria) this;
        }

        public Criteria andIndentStatusBetween(Integer value1, Integer value2) {
            addCriterion("indent_status between", value1, value2, "indentStatus");
            return (Criteria) this;
        }

        public Criteria andIndentStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("indent_status not between", value1, value2, "indentStatus");
            return (Criteria) this;
        }

        public Criteria andIndentDeleteStatusIsNull() {
            addCriterion("indent_delete_status is null");
            return (Criteria) this;
        }

        public Criteria andIndentDeleteStatusIsNotNull() {
            addCriterion("indent_delete_status is not null");
            return (Criteria) this;
        }

        public Criteria andIndentDeleteStatusEqualTo(Integer value) {
            addCriterion("indent_delete_status =", value, "indentDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andIndentDeleteStatusNotEqualTo(Integer value) {
            addCriterion("indent_delete_status <>", value, "indentDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andIndentDeleteStatusGreaterThan(Integer value) {
            addCriterion("indent_delete_status >", value, "indentDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andIndentDeleteStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("indent_delete_status >=", value, "indentDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andIndentDeleteStatusLessThan(Integer value) {
            addCriterion("indent_delete_status <", value, "indentDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andIndentDeleteStatusLessThanOrEqualTo(Integer value) {
            addCriterion("indent_delete_status <=", value, "indentDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andIndentDeleteStatusIn(List<Integer> values) {
            addCriterion("indent_delete_status in", values, "indentDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andIndentDeleteStatusNotIn(List<Integer> values) {
            addCriterion("indent_delete_status not in", values, "indentDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andIndentDeleteStatusBetween(Integer value1, Integer value2) {
            addCriterion("indent_delete_status between", value1, value2, "indentDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andIndentDeleteStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("indent_delete_status not between", value1, value2, "indentDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andIndentTotalIsNull() {
            addCriterion("indent_total is null");
            return (Criteria) this;
        }

        public Criteria andIndentTotalIsNotNull() {
            addCriterion("indent_total is not null");
            return (Criteria) this;
        }

        public Criteria andIndentTotalEqualTo(Float value) {
            addCriterion("indent_total =", value, "indentTotal");
            return (Criteria) this;
        }

        public Criteria andIndentTotalNotEqualTo(Float value) {
            addCriterion("indent_total <>", value, "indentTotal");
            return (Criteria) this;
        }

        public Criteria andIndentTotalGreaterThan(Float value) {
            addCriterion("indent_total >", value, "indentTotal");
            return (Criteria) this;
        }

        public Criteria andIndentTotalGreaterThanOrEqualTo(Float value) {
            addCriterion("indent_total >=", value, "indentTotal");
            return (Criteria) this;
        }

        public Criteria andIndentTotalLessThan(Float value) {
            addCriterion("indent_total <", value, "indentTotal");
            return (Criteria) this;
        }

        public Criteria andIndentTotalLessThanOrEqualTo(Float value) {
            addCriterion("indent_total <=", value, "indentTotal");
            return (Criteria) this;
        }

        public Criteria andIndentTotalIn(List<Float> values) {
            addCriterion("indent_total in", values, "indentTotal");
            return (Criteria) this;
        }

        public Criteria andIndentTotalNotIn(List<Float> values) {
            addCriterion("indent_total not in", values, "indentTotal");
            return (Criteria) this;
        }

        public Criteria andIndentTotalBetween(Float value1, Float value2) {
            addCriterion("indent_total between", value1, value2, "indentTotal");
            return (Criteria) this;
        }

        public Criteria andIndentTotalNotBetween(Float value1, Float value2) {
            addCriterion("indent_total not between", value1, value2, "indentTotal");
            return (Criteria) this;
        }

        public Criteria andIndentCarriageIsNull() {
            addCriterion("indent_carriage is null");
            return (Criteria) this;
        }

        public Criteria andIndentCarriageIsNotNull() {
            addCriterion("indent_carriage is not null");
            return (Criteria) this;
        }

        public Criteria andIndentCarriageEqualTo(Float value) {
            addCriterion("indent_carriage =", value, "indentCarriage");
            return (Criteria) this;
        }

        public Criteria andIndentCarriageNotEqualTo(Float value) {
            addCriterion("indent_carriage <>", value, "indentCarriage");
            return (Criteria) this;
        }

        public Criteria andIndentCarriageGreaterThan(Float value) {
            addCriterion("indent_carriage >", value, "indentCarriage");
            return (Criteria) this;
        }

        public Criteria andIndentCarriageGreaterThanOrEqualTo(Float value) {
            addCriterion("indent_carriage >=", value, "indentCarriage");
            return (Criteria) this;
        }

        public Criteria andIndentCarriageLessThan(Float value) {
            addCriterion("indent_carriage <", value, "indentCarriage");
            return (Criteria) this;
        }

        public Criteria andIndentCarriageLessThanOrEqualTo(Float value) {
            addCriterion("indent_carriage <=", value, "indentCarriage");
            return (Criteria) this;
        }

        public Criteria andIndentCarriageIn(List<Float> values) {
            addCriterion("indent_carriage in", values, "indentCarriage");
            return (Criteria) this;
        }

        public Criteria andIndentCarriageNotIn(List<Float> values) {
            addCriterion("indent_carriage not in", values, "indentCarriage");
            return (Criteria) this;
        }

        public Criteria andIndentCarriageBetween(Float value1, Float value2) {
            addCriterion("indent_carriage between", value1, value2, "indentCarriage");
            return (Criteria) this;
        }

        public Criteria andIndentCarriageNotBetween(Float value1, Float value2) {
            addCriterion("indent_carriage not between", value1, value2, "indentCarriage");
            return (Criteria) this;
        }

        public Criteria andIndentCreateTimeIsNull() {
            addCriterion("indent_create_time is null");
            return (Criteria) this;
        }

        public Criteria andIndentCreateTimeIsNotNull() {
            addCriterion("indent_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andIndentCreateTimeEqualTo(Date value) {
            addCriterion("indent_create_time =", value, "indentCreateTime");
            return (Criteria) this;
        }

        public Criteria andIndentCreateTimeNotEqualTo(Date value) {
            addCriterion("indent_create_time <>", value, "indentCreateTime");
            return (Criteria) this;
        }

        public Criteria andIndentCreateTimeGreaterThan(Date value) {
            addCriterion("indent_create_time >", value, "indentCreateTime");
            return (Criteria) this;
        }

        public Criteria andIndentCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("indent_create_time >=", value, "indentCreateTime");
            return (Criteria) this;
        }

        public Criteria andIndentCreateTimeLessThan(Date value) {
            addCriterion("indent_create_time <", value, "indentCreateTime");
            return (Criteria) this;
        }

        public Criteria andIndentCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("indent_create_time <=", value, "indentCreateTime");
            return (Criteria) this;
        }

        public Criteria andIndentCreateTimeIn(List<Date> values) {
            addCriterion("indent_create_time in", values, "indentCreateTime");
            return (Criteria) this;
        }

        public Criteria andIndentCreateTimeNotIn(List<Date> values) {
            addCriterion("indent_create_time not in", values, "indentCreateTime");
            return (Criteria) this;
        }

        public Criteria andIndentCreateTimeBetween(Date value1, Date value2) {
            addCriterion("indent_create_time between", value1, value2, "indentCreateTime");
            return (Criteria) this;
        }

        public Criteria andIndentCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("indent_create_time not between", value1, value2, "indentCreateTime");
            return (Criteria) this;
        }

        public Criteria andIndentWayIsNull() {
            addCriterion("indent_way is null");
            return (Criteria) this;
        }

        public Criteria andIndentWayIsNotNull() {
            addCriterion("indent_way is not null");
            return (Criteria) this;
        }

        public Criteria andIndentWayEqualTo(Integer value) {
            addCriterion("indent_way =", value, "indentWay");
            return (Criteria) this;
        }

        public Criteria andIndentWayNotEqualTo(Integer value) {
            addCriterion("indent_way <>", value, "indentWay");
            return (Criteria) this;
        }

        public Criteria andIndentWayGreaterThan(Integer value) {
            addCriterion("indent_way >", value, "indentWay");
            return (Criteria) this;
        }

        public Criteria andIndentWayGreaterThanOrEqualTo(Integer value) {
            addCriterion("indent_way >=", value, "indentWay");
            return (Criteria) this;
        }

        public Criteria andIndentWayLessThan(Integer value) {
            addCriterion("indent_way <", value, "indentWay");
            return (Criteria) this;
        }

        public Criteria andIndentWayLessThanOrEqualTo(Integer value) {
            addCriterion("indent_way <=", value, "indentWay");
            return (Criteria) this;
        }

        public Criteria andIndentWayIn(List<Integer> values) {
            addCriterion("indent_way in", values, "indentWay");
            return (Criteria) this;
        }

        public Criteria andIndentWayNotIn(List<Integer> values) {
            addCriterion("indent_way not in", values, "indentWay");
            return (Criteria) this;
        }

        public Criteria andIndentWayBetween(Integer value1, Integer value2) {
            addCriterion("indent_way between", value1, value2, "indentWay");
            return (Criteria) this;
        }

        public Criteria andIndentWayNotBetween(Integer value1, Integer value2) {
            addCriterion("indent_way not between", value1, value2, "indentWay");
            return (Criteria) this;
        }

        public Criteria andIndentPaidTimeIsNull() {
            addCriterion("indent_paid_time is null");
            return (Criteria) this;
        }

        public Criteria andIndentPaidTimeIsNotNull() {
            addCriterion("indent_paid_time is not null");
            return (Criteria) this;
        }

        public Criteria andIndentPaidTimeEqualTo(Date value) {
            addCriterion("indent_paid_time =", value, "indentPaidTime");
            return (Criteria) this;
        }

        public Criteria andIndentPaidTimeNotEqualTo(Date value) {
            addCriterion("indent_paid_time <>", value, "indentPaidTime");
            return (Criteria) this;
        }

        public Criteria andIndentPaidTimeGreaterThan(Date value) {
            addCriterion("indent_paid_time >", value, "indentPaidTime");
            return (Criteria) this;
        }

        public Criteria andIndentPaidTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("indent_paid_time >=", value, "indentPaidTime");
            return (Criteria) this;
        }

        public Criteria andIndentPaidTimeLessThan(Date value) {
            addCriterion("indent_paid_time <", value, "indentPaidTime");
            return (Criteria) this;
        }

        public Criteria andIndentPaidTimeLessThanOrEqualTo(Date value) {
            addCriterion("indent_paid_time <=", value, "indentPaidTime");
            return (Criteria) this;
        }

        public Criteria andIndentPaidTimeIn(List<Date> values) {
            addCriterion("indent_paid_time in", values, "indentPaidTime");
            return (Criteria) this;
        }

        public Criteria andIndentPaidTimeNotIn(List<Date> values) {
            addCriterion("indent_paid_time not in", values, "indentPaidTime");
            return (Criteria) this;
        }

        public Criteria andIndentPaidTimeBetween(Date value1, Date value2) {
            addCriterion("indent_paid_time between", value1, value2, "indentPaidTime");
            return (Criteria) this;
        }

        public Criteria andIndentPaidTimeNotBetween(Date value1, Date value2) {
            addCriterion("indent_paid_time not between", value1, value2, "indentPaidTime");
            return (Criteria) this;
        }

        public Criteria andIndentEndTimeIsNull() {
            addCriterion("indent_end_time is null");
            return (Criteria) this;
        }

        public Criteria andIndentEndTimeIsNotNull() {
            addCriterion("indent_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andIndentEndTimeEqualTo(Date value) {
            addCriterion("indent_end_time =", value, "indentEndTime");
            return (Criteria) this;
        }

        public Criteria andIndentEndTimeNotEqualTo(Date value) {
            addCriterion("indent_end_time <>", value, "indentEndTime");
            return (Criteria) this;
        }

        public Criteria andIndentEndTimeGreaterThan(Date value) {
            addCriterion("indent_end_time >", value, "indentEndTime");
            return (Criteria) this;
        }

        public Criteria andIndentEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("indent_end_time >=", value, "indentEndTime");
            return (Criteria) this;
        }

        public Criteria andIndentEndTimeLessThan(Date value) {
            addCriterion("indent_end_time <", value, "indentEndTime");
            return (Criteria) this;
        }

        public Criteria andIndentEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("indent_end_time <=", value, "indentEndTime");
            return (Criteria) this;
        }

        public Criteria andIndentEndTimeIn(List<Date> values) {
            addCriterion("indent_end_time in", values, "indentEndTime");
            return (Criteria) this;
        }

        public Criteria andIndentEndTimeNotIn(List<Date> values) {
            addCriterion("indent_end_time not in", values, "indentEndTime");
            return (Criteria) this;
        }

        public Criteria andIndentEndTimeBetween(Date value1, Date value2) {
            addCriterion("indent_end_time between", value1, value2, "indentEndTime");
            return (Criteria) this;
        }

        public Criteria andIndentEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("indent_end_time not between", value1, value2, "indentEndTime");
            return (Criteria) this;
        }

        public Criteria andIndentDrawbackTimeIsNull() {
            addCriterion("indent_drawback_time is null");
            return (Criteria) this;
        }

        public Criteria andIndentDrawbackTimeIsNotNull() {
            addCriterion("indent_drawback_time is not null");
            return (Criteria) this;
        }

        public Criteria andIndentDrawbackTimeEqualTo(Date value) {
            addCriterion("indent_drawback_time =", value, "indentDrawbackTime");
            return (Criteria) this;
        }

        public Criteria andIndentDrawbackTimeNotEqualTo(Date value) {
            addCriterion("indent_drawback_time <>", value, "indentDrawbackTime");
            return (Criteria) this;
        }

        public Criteria andIndentDrawbackTimeGreaterThan(Date value) {
            addCriterion("indent_drawback_time >", value, "indentDrawbackTime");
            return (Criteria) this;
        }

        public Criteria andIndentDrawbackTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("indent_drawback_time >=", value, "indentDrawbackTime");
            return (Criteria) this;
        }

        public Criteria andIndentDrawbackTimeLessThan(Date value) {
            addCriterion("indent_drawback_time <", value, "indentDrawbackTime");
            return (Criteria) this;
        }

        public Criteria andIndentDrawbackTimeLessThanOrEqualTo(Date value) {
            addCriterion("indent_drawback_time <=", value, "indentDrawbackTime");
            return (Criteria) this;
        }

        public Criteria andIndentDrawbackTimeIn(List<Date> values) {
            addCriterion("indent_drawback_time in", values, "indentDrawbackTime");
            return (Criteria) this;
        }

        public Criteria andIndentDrawbackTimeNotIn(List<Date> values) {
            addCriterion("indent_drawback_time not in", values, "indentDrawbackTime");
            return (Criteria) this;
        }

        public Criteria andIndentDrawbackTimeBetween(Date value1, Date value2) {
            addCriterion("indent_drawback_time between", value1, value2, "indentDrawbackTime");
            return (Criteria) this;
        }

        public Criteria andIndentDrawbackTimeNotBetween(Date value1, Date value2) {
            addCriterion("indent_drawback_time not between", value1, value2, "indentDrawbackTime");
            return (Criteria) this;
        }

        public Criteria andIndentDrawbackMoneyTimeIsNull() {
            addCriterion("indent_drawback_money_time is null");
            return (Criteria) this;
        }

        public Criteria andIndentDrawbackMoneyTimeIsNotNull() {
            addCriterion("indent_drawback_money_time is not null");
            return (Criteria) this;
        }

        public Criteria andIndentDrawbackMoneyTimeEqualTo(Date value) {
            addCriterion("indent_drawback_money_time =", value, "indentDrawbackMoneyTime");
            return (Criteria) this;
        }

        public Criteria andIndentDrawbackMoneyTimeNotEqualTo(Date value) {
            addCriterion("indent_drawback_money_time <>", value, "indentDrawbackMoneyTime");
            return (Criteria) this;
        }

        public Criteria andIndentDrawbackMoneyTimeGreaterThan(Date value) {
            addCriterion("indent_drawback_money_time >", value, "indentDrawbackMoneyTime");
            return (Criteria) this;
        }

        public Criteria andIndentDrawbackMoneyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("indent_drawback_money_time >=", value, "indentDrawbackMoneyTime");
            return (Criteria) this;
        }

        public Criteria andIndentDrawbackMoneyTimeLessThan(Date value) {
            addCriterion("indent_drawback_money_time <", value, "indentDrawbackMoneyTime");
            return (Criteria) this;
        }

        public Criteria andIndentDrawbackMoneyTimeLessThanOrEqualTo(Date value) {
            addCriterion("indent_drawback_money_time <=", value, "indentDrawbackMoneyTime");
            return (Criteria) this;
        }

        public Criteria andIndentDrawbackMoneyTimeIn(List<Date> values) {
            addCriterion("indent_drawback_money_time in", values, "indentDrawbackMoneyTime");
            return (Criteria) this;
        }

        public Criteria andIndentDrawbackMoneyTimeNotIn(List<Date> values) {
            addCriterion("indent_drawback_money_time not in", values, "indentDrawbackMoneyTime");
            return (Criteria) this;
        }

        public Criteria andIndentDrawbackMoneyTimeBetween(Date value1, Date value2) {
            addCriterion("indent_drawback_money_time between", value1, value2, "indentDrawbackMoneyTime");
            return (Criteria) this;
        }

        public Criteria andIndentDrawbackMoneyTimeNotBetween(Date value1, Date value2) {
            addCriterion("indent_drawback_money_time not between", value1, value2, "indentDrawbackMoneyTime");
            return (Criteria) this;
        }
    }

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