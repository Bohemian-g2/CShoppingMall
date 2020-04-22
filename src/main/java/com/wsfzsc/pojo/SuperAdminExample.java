package com.wsfzsc.pojo;

import java.util.ArrayList;
import java.util.List;

public class SuperAdminExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SuperAdminExample() {
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

        public Criteria andSuperadminIdIsNull() {
            addCriterion("superadmin_id is null");
            return (Criteria) this;
        }

        public Criteria andSuperadminIdIsNotNull() {
            addCriterion("superadmin_id is not null");
            return (Criteria) this;
        }

        public Criteria andSuperadminIdEqualTo(Integer value) {
            addCriterion("superadmin_id =", value, "superadminId");
            return (Criteria) this;
        }

        public Criteria andSuperadminIdNotEqualTo(Integer value) {
            addCriterion("superadmin_id <>", value, "superadminId");
            return (Criteria) this;
        }

        public Criteria andSuperadminIdGreaterThan(Integer value) {
            addCriterion("superadmin_id >", value, "superadminId");
            return (Criteria) this;
        }

        public Criteria andSuperadminIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("superadmin_id >=", value, "superadminId");
            return (Criteria) this;
        }

        public Criteria andSuperadminIdLessThan(Integer value) {
            addCriterion("superadmin_id <", value, "superadminId");
            return (Criteria) this;
        }

        public Criteria andSuperadminIdLessThanOrEqualTo(Integer value) {
            addCriterion("superadmin_id <=", value, "superadminId");
            return (Criteria) this;
        }

        public Criteria andSuperadminIdIn(List<Integer> values) {
            addCriterion("superadmin_id in", values, "superadminId");
            return (Criteria) this;
        }

        public Criteria andSuperadminIdNotIn(List<Integer> values) {
            addCriterion("superadmin_id not in", values, "superadminId");
            return (Criteria) this;
        }

        public Criteria andSuperadminIdBetween(Integer value1, Integer value2) {
            addCriterion("superadmin_id between", value1, value2, "superadminId");
            return (Criteria) this;
        }

        public Criteria andSuperadminIdNotBetween(Integer value1, Integer value2) {
            addCriterion("superadmin_id not between", value1, value2, "superadminId");
            return (Criteria) this;
        }

        public Criteria andSuperadminUsernameIsNull() {
            addCriterion("superadmin_username is null");
            return (Criteria) this;
        }

        public Criteria andSuperadminUsernameIsNotNull() {
            addCriterion("superadmin_username is not null");
            return (Criteria) this;
        }

        public Criteria andSuperadminUsernameEqualTo(String value) {
            addCriterion("superadmin_username =", value, "superadminUsername");
            return (Criteria) this;
        }

        public Criteria andSuperadminUsernameNotEqualTo(String value) {
            addCriterion("superadmin_username <>", value, "superadminUsername");
            return (Criteria) this;
        }

        public Criteria andSuperadminUsernameGreaterThan(String value) {
            addCriterion("superadmin_username >", value, "superadminUsername");
            return (Criteria) this;
        }

        public Criteria andSuperadminUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("superadmin_username >=", value, "superadminUsername");
            return (Criteria) this;
        }

        public Criteria andSuperadminUsernameLessThan(String value) {
            addCriterion("superadmin_username <", value, "superadminUsername");
            return (Criteria) this;
        }

        public Criteria andSuperadminUsernameLessThanOrEqualTo(String value) {
            addCriterion("superadmin_username <=", value, "superadminUsername");
            return (Criteria) this;
        }

        public Criteria andSuperadminUsernameLike(String value) {
            addCriterion("superadmin_username like", value, "superadminUsername");
            return (Criteria) this;
        }

        public Criteria andSuperadminUsernameNotLike(String value) {
            addCriterion("superadmin_username not like", value, "superadminUsername");
            return (Criteria) this;
        }

        public Criteria andSuperadminUsernameIn(List<String> values) {
            addCriterion("superadmin_username in", values, "superadminUsername");
            return (Criteria) this;
        }

        public Criteria andSuperadminUsernameNotIn(List<String> values) {
            addCriterion("superadmin_username not in", values, "superadminUsername");
            return (Criteria) this;
        }

        public Criteria andSuperadminUsernameBetween(String value1, String value2) {
            addCriterion("superadmin_username between", value1, value2, "superadminUsername");
            return (Criteria) this;
        }

        public Criteria andSuperadminUsernameNotBetween(String value1, String value2) {
            addCriterion("superadmin_username not between", value1, value2, "superadminUsername");
            return (Criteria) this;
        }

        public Criteria andSuperadminPasswordIsNull() {
            addCriterion("superadmin_password is null");
            return (Criteria) this;
        }

        public Criteria andSuperadminPasswordIsNotNull() {
            addCriterion("superadmin_password is not null");
            return (Criteria) this;
        }

        public Criteria andSuperadminPasswordEqualTo(String value) {
            addCriterion("superadmin_password =", value, "superadminPassword");
            return (Criteria) this;
        }

        public Criteria andSuperadminPasswordNotEqualTo(String value) {
            addCriterion("superadmin_password <>", value, "superadminPassword");
            return (Criteria) this;
        }

        public Criteria andSuperadminPasswordGreaterThan(String value) {
            addCriterion("superadmin_password >", value, "superadminPassword");
            return (Criteria) this;
        }

        public Criteria andSuperadminPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("superadmin_password >=", value, "superadminPassword");
            return (Criteria) this;
        }

        public Criteria andSuperadminPasswordLessThan(String value) {
            addCriterion("superadmin_password <", value, "superadminPassword");
            return (Criteria) this;
        }

        public Criteria andSuperadminPasswordLessThanOrEqualTo(String value) {
            addCriterion("superadmin_password <=", value, "superadminPassword");
            return (Criteria) this;
        }

        public Criteria andSuperadminPasswordLike(String value) {
            addCriterion("superadmin_password like", value, "superadminPassword");
            return (Criteria) this;
        }

        public Criteria andSuperadminPasswordNotLike(String value) {
            addCriterion("superadmin_password not like", value, "superadminPassword");
            return (Criteria) this;
        }

        public Criteria andSuperadminPasswordIn(List<String> values) {
            addCriterion("superadmin_password in", values, "superadminPassword");
            return (Criteria) this;
        }

        public Criteria andSuperadminPasswordNotIn(List<String> values) {
            addCriterion("superadmin_password not in", values, "superadminPassword");
            return (Criteria) this;
        }

        public Criteria andSuperadminPasswordBetween(String value1, String value2) {
            addCriterion("superadmin_password between", value1, value2, "superadminPassword");
            return (Criteria) this;
        }

        public Criteria andSuperadminPasswordNotBetween(String value1, String value2) {
            addCriterion("superadmin_password not between", value1, value2, "superadminPassword");
            return (Criteria) this;
        }

        public Criteria andSuperadminNameIsNull() {
            addCriterion("superadmin_name is null");
            return (Criteria) this;
        }

        public Criteria andSuperadminNameIsNotNull() {
            addCriterion("superadmin_name is not null");
            return (Criteria) this;
        }

        public Criteria andSuperadminNameEqualTo(String value) {
            addCriterion("superadmin_name =", value, "superadminName");
            return (Criteria) this;
        }

        public Criteria andSuperadminNameNotEqualTo(String value) {
            addCriterion("superadmin_name <>", value, "superadminName");
            return (Criteria) this;
        }

        public Criteria andSuperadminNameGreaterThan(String value) {
            addCriterion("superadmin_name >", value, "superadminName");
            return (Criteria) this;
        }

        public Criteria andSuperadminNameGreaterThanOrEqualTo(String value) {
            addCriterion("superadmin_name >=", value, "superadminName");
            return (Criteria) this;
        }

        public Criteria andSuperadminNameLessThan(String value) {
            addCriterion("superadmin_name <", value, "superadminName");
            return (Criteria) this;
        }

        public Criteria andSuperadminNameLessThanOrEqualTo(String value) {
            addCriterion("superadmin_name <=", value, "superadminName");
            return (Criteria) this;
        }

        public Criteria andSuperadminNameLike(String value) {
            addCriterion("superadmin_name like", value, "superadminName");
            return (Criteria) this;
        }

        public Criteria andSuperadminNameNotLike(String value) {
            addCriterion("superadmin_name not like", value, "superadminName");
            return (Criteria) this;
        }

        public Criteria andSuperadminNameIn(List<String> values) {
            addCriterion("superadmin_name in", values, "superadminName");
            return (Criteria) this;
        }

        public Criteria andSuperadminNameNotIn(List<String> values) {
            addCriterion("superadmin_name not in", values, "superadminName");
            return (Criteria) this;
        }

        public Criteria andSuperadminNameBetween(String value1, String value2) {
            addCriterion("superadmin_name between", value1, value2, "superadminName");
            return (Criteria) this;
        }

        public Criteria andSuperadminNameNotBetween(String value1, String value2) {
            addCriterion("superadmin_name not between", value1, value2, "superadminName");
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