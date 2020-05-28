package com.wsfzsc.pojo;

import java.util.ArrayList;
import java.util.List;

public class CDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CDetailExample() {
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

        public Criteria andCartIdIsNull() {
            addCriterion("cart_id is null");
            return (Criteria) this;
        }

        public Criteria andCartIdIsNotNull() {
            addCriterion("cart_id is not null");
            return (Criteria) this;
        }

        //修改过
        public Criteria andCartIdEqualTo(Integer value) {
            addCriterion("cd.cart_id =", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdNotEqualTo(Integer value) {
            addCriterion("cart_id <>", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdGreaterThan(Integer value) {
            addCriterion("cart_id >", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cart_id >=", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdLessThan(Integer value) {
            addCriterion("cart_id <", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdLessThanOrEqualTo(Integer value) {
            addCriterion("cart_id <=", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdIn(List<Integer> values) {
            addCriterion("cart_id in", values, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdNotIn(List<Integer> values) {
            addCriterion("cart_id not in", values, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdBetween(Integer value1, Integer value2) {
            addCriterion("cart_id between", value1, value2, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cart_id not between", value1, value2, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartCommodityIdIsNull() {
            addCriterion("cart_commodity_id is null");
            return (Criteria) this;
        }

        public Criteria andCartCommodityIdIsNotNull() {
            addCriterion("cart_commodity_id is not null");
            return (Criteria) this;
        }

        public Criteria andCartCommodityIdEqualTo(Integer value) {
            addCriterion("cart_commodity_id =", value, "cartCommodityId");
            return (Criteria) this;
        }

        public Criteria andCartCommodityIdNotEqualTo(Integer value) {
            addCriterion("cart_commodity_id <>", value, "cartCommodityId");
            return (Criteria) this;
        }

        public Criteria andCartCommodityIdGreaterThan(Integer value) {
            addCriterion("cart_commodity_id >", value, "cartCommodityId");
            return (Criteria) this;
        }

        public Criteria andCartCommodityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cart_commodity_id >=", value, "cartCommodityId");
            return (Criteria) this;
        }

        public Criteria andCartCommodityIdLessThan(Integer value) {
            addCriterion("cart_commodity_id <", value, "cartCommodityId");
            return (Criteria) this;
        }

        public Criteria andCartCommodityIdLessThanOrEqualTo(Integer value) {
            addCriterion("cart_commodity_id <=", value, "cartCommodityId");
            return (Criteria) this;
        }

        //修改
        public Criteria andCartCommodityIdIn(List<Integer> values) {
            addCriterion("cd.cart_commodity_id in", values, "cartCommodityId");
            return (Criteria) this;
        }

        public Criteria andCartCommodityIdNotIn(List<Integer> values) {
            addCriterion("cart_commodity_id not in", values, "cartCommodityId");
            return (Criteria) this;
        }

        public Criteria andCartCommodityIdBetween(Integer value1, Integer value2) {
            addCriterion("cart_commodity_id between", value1, value2, "cartCommodityId");
            return (Criteria) this;
        }

        public Criteria andCartCommodityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cart_commodity_id not between", value1, value2, "cartCommodityId");
            return (Criteria) this;
        }

        public Criteria andCartCommodityNumbeIsNull() {
            addCriterion("cart_commodity_numbe is null");
            return (Criteria) this;
        }

        public Criteria andCartCommodityNumbeIsNotNull() {
            addCriterion("cart_commodity_numbe is not null");
            return (Criteria) this;
        }

        public Criteria andCartCommodityNumbeEqualTo(Integer value) {
            addCriterion("cart_commodity_numbe =", value, "cartCommodityNumbe");
            return (Criteria) this;
        }

        public Criteria andCartCommodityNumbeNotEqualTo(Integer value) {
            addCriterion("cart_commodity_numbe <>", value, "cartCommodityNumbe");
            return (Criteria) this;
        }

        public Criteria andCartCommodityNumbeGreaterThan(Integer value) {
            addCriterion("cart_commodity_numbe >", value, "cartCommodityNumbe");
            return (Criteria) this;
        }

        public Criteria andCartCommodityNumbeGreaterThanOrEqualTo(Integer value) {
            addCriterion("cart_commodity_numbe >=", value, "cartCommodityNumbe");
            return (Criteria) this;
        }

        public Criteria andCartCommodityNumbeLessThan(Integer value) {
            addCriterion("cart_commodity_numbe <", value, "cartCommodityNumbe");
            return (Criteria) this;
        }

        public Criteria andCartCommodityNumbeLessThanOrEqualTo(Integer value) {
            addCriterion("cart_commodity_numbe <=", value, "cartCommodityNumbe");
            return (Criteria) this;
        }

        public Criteria andCartCommodityNumbeIn(List<Integer> values) {
            addCriterion("cart_commodity_numbe in", values, "cartCommodityNumbe");
            return (Criteria) this;
        }

        public Criteria andCartCommodityNumbeNotIn(List<Integer> values) {
            addCriterion("cart_commodity_numbe not in", values, "cartCommodityNumbe");
            return (Criteria) this;
        }

        public Criteria andCartCommodityNumbeBetween(Integer value1, Integer value2) {
            addCriterion("cart_commodity_numbe between", value1, value2, "cartCommodityNumbe");
            return (Criteria) this;
        }

        public Criteria andCartCommodityNumbeNotBetween(Integer value1, Integer value2) {
            addCriterion("cart_commodity_numbe not between", value1, value2, "cartCommodityNumbe");
            return (Criteria) this;
        }

        public Criteria andCartCommodityMoneyIsNull() {
            addCriterion("cart_commodity_money is null");
            return (Criteria) this;
        }

        public Criteria andCartCommodityMoneyIsNotNull() {
            addCriterion("cart_commodity_money is not null");
            return (Criteria) this;
        }

        public Criteria andCartCommodityMoneyEqualTo(Float value) {
            addCriterion("cart_commodity_money =", value, "cartCommodityMoney");
            return (Criteria) this;
        }

        public Criteria andCartCommodityMoneyNotEqualTo(Float value) {
            addCriterion("cart_commodity_money <>", value, "cartCommodityMoney");
            return (Criteria) this;
        }

        public Criteria andCartCommodityMoneyGreaterThan(Float value) {
            addCriterion("cart_commodity_money >", value, "cartCommodityMoney");
            return (Criteria) this;
        }

        public Criteria andCartCommodityMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("cart_commodity_money >=", value, "cartCommodityMoney");
            return (Criteria) this;
        }

        public Criteria andCartCommodityMoneyLessThan(Float value) {
            addCriterion("cart_commodity_money <", value, "cartCommodityMoney");
            return (Criteria) this;
        }

        public Criteria andCartCommodityMoneyLessThanOrEqualTo(Float value) {
            addCriterion("cart_commodity_money <=", value, "cartCommodityMoney");
            return (Criteria) this;
        }

        public Criteria andCartCommodityMoneyIn(List<Float> values) {
            addCriterion("cart_commodity_money in", values, "cartCommodityMoney");
            return (Criteria) this;
        }

        public Criteria andCartCommodityMoneyNotIn(List<Float> values) {
            addCriterion("cart_commodity_money not in", values, "cartCommodityMoney");
            return (Criteria) this;
        }

        public Criteria andCartCommodityMoneyBetween(Float value1, Float value2) {
            addCriterion("cart_commodity_money between", value1, value2, "cartCommodityMoney");
            return (Criteria) this;
        }

        public Criteria andCartCommodityMoneyNotBetween(Float value1, Float value2) {
            addCriterion("cart_commodity_money not between", value1, value2, "cartCommodityMoney");
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