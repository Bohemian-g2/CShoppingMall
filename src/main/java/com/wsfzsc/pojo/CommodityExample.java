package com.wsfzsc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommodityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommodityExample() {
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

        public Criteria andCommodityIdIsNull() {
            addCriterion("commodity_id is null");
            return (Criteria) this;
        }

        public Criteria andCommodityIdIsNotNull() {
            addCriterion("commodity_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityIdEqualTo(Integer value) {
            addCriterion("commodity_id =", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdNotEqualTo(Integer value) {
            addCriterion("commodity_id <>", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdGreaterThan(Integer value) {
            addCriterion("commodity_id >", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("commodity_id >=", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdLessThan(Integer value) {
            addCriterion("commodity_id <", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdLessThanOrEqualTo(Integer value) {
            addCriterion("commodity_id <=", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdIn(List<Integer> values) {
            addCriterion("commodity_id in", values, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdNotIn(List<Integer> values) {
            addCriterion("commodity_id not in", values, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdBetween(Integer value1, Integer value2) {
            addCriterion("commodity_id between", value1, value2, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("commodity_id not between", value1, value2, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityKindIsNull() {
            addCriterion("commodity_kind is null");
            return (Criteria) this;
        }

        public Criteria andCommodityKindIsNotNull() {
            addCriterion("commodity_kind is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityKindEqualTo(Integer value) {
            addCriterion("commodity_kind =", value, "commodityKind");
            return (Criteria) this;
        }

        public Criteria andCommodityKindNotEqualTo(Integer value) {
            addCriterion("commodity_kind <>", value, "commodityKind");
            return (Criteria) this;
        }

        public Criteria andCommodityKindGreaterThan(Integer value) {
            addCriterion("commodity_kind >", value, "commodityKind");
            return (Criteria) this;
        }

        public Criteria andCommodityKindGreaterThanOrEqualTo(Integer value) {
            addCriterion("commodity_kind >=", value, "commodityKind");
            return (Criteria) this;
        }

        public Criteria andCommodityKindLessThan(Integer value) {
            addCriterion("commodity_kind <", value, "commodityKind");
            return (Criteria) this;
        }

        public Criteria andCommodityKindLessThanOrEqualTo(Integer value) {
            addCriterion("commodity_kind <=", value, "commodityKind");
            return (Criteria) this;
        }

        public Criteria andCommodityKindIn(List<Integer> values) {
            addCriterion("commodity_kind in", values, "commodityKind");
            return (Criteria) this;
        }

        public Criteria andCommodityKindNotIn(List<Integer> values) {
            addCriterion("commodity_kind not in", values, "commodityKind");
            return (Criteria) this;
        }

        public Criteria andCommodityKindBetween(Integer value1, Integer value2) {
            addCriterion("commodity_kind between", value1, value2, "commodityKind");
            return (Criteria) this;
        }

        public Criteria andCommodityKindNotBetween(Integer value1, Integer value2) {
            addCriterion("commodity_kind not between", value1, value2, "commodityKind");
            return (Criteria) this;
        }

        public Criteria andCommodityNameIsNull() {
            addCriterion("commodity_name is null");
            return (Criteria) this;
        }

        public Criteria andCommodityNameIsNotNull() {
            addCriterion("commodity_name is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityNameEqualTo(String value) {
            addCriterion("commodity_name =", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameNotEqualTo(String value) {
            addCriterion("commodity_name <>", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameGreaterThan(String value) {
            addCriterion("commodity_name >", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameGreaterThanOrEqualTo(String value) {
            addCriterion("commodity_name >=", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameLessThan(String value) {
            addCriterion("commodity_name <", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameLessThanOrEqualTo(String value) {
            addCriterion("commodity_name <=", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameLike(String value) {
            addCriterion("commodity_name like", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameNotLike(String value) {
            addCriterion("commodity_name not like", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameIn(List<String> values) {
            addCriterion("commodity_name in", values, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameNotIn(List<String> values) {
            addCriterion("commodity_name not in", values, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameBetween(String value1, String value2) {
            addCriterion("commodity_name between", value1, value2, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameNotBetween(String value1, String value2) {
            addCriterion("commodity_name not between", value1, value2, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityStatusIsNull() {
            addCriterion("commodity_status is null");
            return (Criteria) this;
        }

        public Criteria andCommodityStatusIsNotNull() {
            addCriterion("commodity_status is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityStatusEqualTo(Integer value) {
            addCriterion("commodity_status =", value, "commodityStatus");
            return (Criteria) this;
        }

        public Criteria andCommodityStatusNotEqualTo(Integer value) {
            addCriterion("commodity_status <>", value, "commodityStatus");
            return (Criteria) this;
        }

        public Criteria andCommodityStatusGreaterThan(Integer value) {
            addCriterion("commodity_status >", value, "commodityStatus");
            return (Criteria) this;
        }

        public Criteria andCommodityStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("commodity_status >=", value, "commodityStatus");
            return (Criteria) this;
        }

        public Criteria andCommodityStatusLessThan(Integer value) {
            addCriterion("commodity_status <", value, "commodityStatus");
            return (Criteria) this;
        }

        public Criteria andCommodityStatusLessThanOrEqualTo(Integer value) {
            addCriterion("commodity_status <=", value, "commodityStatus");
            return (Criteria) this;
        }

        public Criteria andCommodityStatusIn(List<Integer> values) {
            addCriterion("commodity_status in", values, "commodityStatus");
            return (Criteria) this;
        }

        public Criteria andCommodityStatusNotIn(List<Integer> values) {
            addCriterion("commodity_status not in", values, "commodityStatus");
            return (Criteria) this;
        }

        public Criteria andCommodityStatusBetween(Integer value1, Integer value2) {
            addCriterion("commodity_status between", value1, value2, "commodityStatus");
            return (Criteria) this;
        }

        public Criteria andCommodityStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("commodity_status not between", value1, value2, "commodityStatus");
            return (Criteria) this;
        }

        public Criteria andCommodityMoneyIsNull() {
            addCriterion("commodity_money is null");
            return (Criteria) this;
        }

        public Criteria andCommodityMoneyIsNotNull() {
            addCriterion("commodity_money is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityMoneyEqualTo(Float value) {
            addCriterion("commodity_money =", value, "commodityMoney");
            return (Criteria) this;
        }

        public Criteria andCommodityMoneyNotEqualTo(Float value) {
            addCriterion("commodity_money <>", value, "commodityMoney");
            return (Criteria) this;
        }

        public Criteria andCommodityMoneyGreaterThan(Float value) {
            addCriterion("commodity_money >", value, "commodityMoney");
            return (Criteria) this;
        }

        public Criteria andCommodityMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("commodity_money >=", value, "commodityMoney");
            return (Criteria) this;
        }

        public Criteria andCommodityMoneyLessThan(Float value) {
            addCriterion("commodity_money <", value, "commodityMoney");
            return (Criteria) this;
        }

        public Criteria andCommodityMoneyLessThanOrEqualTo(Float value) {
            addCriterion("commodity_money <=", value, "commodityMoney");
            return (Criteria) this;
        }

        public Criteria andCommodityMoneyIn(List<Float> values) {
            addCriterion("commodity_money in", values, "commodityMoney");
            return (Criteria) this;
        }

        public Criteria andCommodityMoneyNotIn(List<Float> values) {
            addCriterion("commodity_money not in", values, "commodityMoney");
            return (Criteria) this;
        }

        public Criteria andCommodityMoneyBetween(Float value1, Float value2) {
            addCriterion("commodity_money between", value1, value2, "commodityMoney");
            return (Criteria) this;
        }

        public Criteria andCommodityMoneyNotBetween(Float value1, Float value2) {
            addCriterion("commodity_money not between", value1, value2, "commodityMoney");
            return (Criteria) this;
        }

        public Criteria andCommodityStockIsNull() {
            addCriterion("commodity_stock is null");
            return (Criteria) this;
        }

        public Criteria andCommodityStockIsNotNull() {
            addCriterion("commodity_stock is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityStockEqualTo(Integer value) {
            addCriterion("commodity_stock =", value, "commodityStock");
            return (Criteria) this;
        }

        public Criteria andCommodityStockNotEqualTo(Integer value) {
            addCriterion("commodity_stock <>", value, "commodityStock");
            return (Criteria) this;
        }

        public Criteria andCommodityStockGreaterThan(Integer value) {
            addCriterion("commodity_stock >", value, "commodityStock");
            return (Criteria) this;
        }

        public Criteria andCommodityStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("commodity_stock >=", value, "commodityStock");
            return (Criteria) this;
        }

        public Criteria andCommodityStockLessThan(Integer value) {
            addCriterion("commodity_stock <", value, "commodityStock");
            return (Criteria) this;
        }

        public Criteria andCommodityStockLessThanOrEqualTo(Integer value) {
            addCriterion("commodity_stock <=", value, "commodityStock");
            return (Criteria) this;
        }

        public Criteria andCommodityStockIn(List<Integer> values) {
            addCriterion("commodity_stock in", values, "commodityStock");
            return (Criteria) this;
        }

        public Criteria andCommodityStockNotIn(List<Integer> values) {
            addCriterion("commodity_stock not in", values, "commodityStock");
            return (Criteria) this;
        }

        public Criteria andCommodityStockBetween(Integer value1, Integer value2) {
            addCriterion("commodity_stock between", value1, value2, "commodityStock");
            return (Criteria) this;
        }

        public Criteria andCommodityStockNotBetween(Integer value1, Integer value2) {
            addCriterion("commodity_stock not between", value1, value2, "commodityStock");
            return (Criteria) this;
        }

        public Criteria andCommoditySizeIsNull() {
            addCriterion("commodity_size is null");
            return (Criteria) this;
        }

        public Criteria andCommoditySizeIsNotNull() {
            addCriterion("commodity_size is not null");
            return (Criteria) this;
        }

        public Criteria andCommoditySizeEqualTo(String value) {
            addCriterion("commodity_size =", value, "commoditySize");
            return (Criteria) this;
        }

        public Criteria andCommoditySizeNotEqualTo(String value) {
            addCriterion("commodity_size <>", value, "commoditySize");
            return (Criteria) this;
        }

        public Criteria andCommoditySizeGreaterThan(String value) {
            addCriterion("commodity_size >", value, "commoditySize");
            return (Criteria) this;
        }

        public Criteria andCommoditySizeGreaterThanOrEqualTo(String value) {
            addCriterion("commodity_size >=", value, "commoditySize");
            return (Criteria) this;
        }

        public Criteria andCommoditySizeLessThan(String value) {
            addCriterion("commodity_size <", value, "commoditySize");
            return (Criteria) this;
        }

        public Criteria andCommoditySizeLessThanOrEqualTo(String value) {
            addCriterion("commodity_size <=", value, "commoditySize");
            return (Criteria) this;
        }

        public Criteria andCommoditySizeLike(String value) {
            addCriterion("commodity_size like", value, "commoditySize");
            return (Criteria) this;
        }

        public Criteria andCommoditySizeNotLike(String value) {
            addCriterion("commodity_size not like", value, "commoditySize");
            return (Criteria) this;
        }

        public Criteria andCommoditySizeIn(List<String> values) {
            addCriterion("commodity_size in", values, "commoditySize");
            return (Criteria) this;
        }

        public Criteria andCommoditySizeNotIn(List<String> values) {
            addCriterion("commodity_size not in", values, "commoditySize");
            return (Criteria) this;
        }

        public Criteria andCommoditySizeBetween(String value1, String value2) {
            addCriterion("commodity_size between", value1, value2, "commoditySize");
            return (Criteria) this;
        }

        public Criteria andCommoditySizeNotBetween(String value1, String value2) {
            addCriterion("commodity_size not between", value1, value2, "commoditySize");
            return (Criteria) this;
        }

        public Criteria andCommoditySexIsNull() {
            addCriterion("commodity_sex is null");
            return (Criteria) this;
        }

        public Criteria andCommoditySexIsNotNull() {
            addCriterion("commodity_sex is not null");
            return (Criteria) this;
        }

        public Criteria andCommoditySexEqualTo(Integer value) {
            addCriterion("commodity_sex =", value, "commoditySex");
            return (Criteria) this;
        }

        public Criteria andCommoditySexNotEqualTo(Integer value) {
            addCriterion("commodity_sex <>", value, "commoditySex");
            return (Criteria) this;
        }

        public Criteria andCommoditySexGreaterThan(Integer value) {
            addCriterion("commodity_sex >", value, "commoditySex");
            return (Criteria) this;
        }

        public Criteria andCommoditySexGreaterThanOrEqualTo(Integer value) {
            addCriterion("commodity_sex >=", value, "commoditySex");
            return (Criteria) this;
        }

        public Criteria andCommoditySexLessThan(Integer value) {
            addCriterion("commodity_sex <", value, "commoditySex");
            return (Criteria) this;
        }

        public Criteria andCommoditySexLessThanOrEqualTo(Integer value) {
            addCriterion("commodity_sex <=", value, "commoditySex");
            return (Criteria) this;
        }

        public Criteria andCommoditySexIn(List<Integer> values) {
            addCriterion("commodity_sex in", values, "commoditySex");
            return (Criteria) this;
        }

        public Criteria andCommoditySexNotIn(List<Integer> values) {
            addCriterion("commodity_sex not in", values, "commoditySex");
            return (Criteria) this;
        }

        public Criteria andCommoditySexBetween(Integer value1, Integer value2) {
            addCriterion("commodity_sex between", value1, value2, "commoditySex");
            return (Criteria) this;
        }

        public Criteria andCommoditySexNotBetween(Integer value1, Integer value2) {
            addCriterion("commodity_sex not between", value1, value2, "commoditySex");
            return (Criteria) this;
        }

        public Criteria andCommodityPictureIsNull() {
            addCriterion("commodity_picture is null");
            return (Criteria) this;
        }

        public Criteria andCommodityPictureIsNotNull() {
            addCriterion("commodity_picture is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityPictureEqualTo(String value) {
            addCriterion("commodity_picture =", value, "commodityPicture");
            return (Criteria) this;
        }

        public Criteria andCommodityPictureNotEqualTo(String value) {
            addCriterion("commodity_picture <>", value, "commodityPicture");
            return (Criteria) this;
        }

        public Criteria andCommodityPictureGreaterThan(String value) {
            addCriterion("commodity_picture >", value, "commodityPicture");
            return (Criteria) this;
        }

        public Criteria andCommodityPictureGreaterThanOrEqualTo(String value) {
            addCriterion("commodity_picture >=", value, "commodityPicture");
            return (Criteria) this;
        }

        public Criteria andCommodityPictureLessThan(String value) {
            addCriterion("commodity_picture <", value, "commodityPicture");
            return (Criteria) this;
        }

        public Criteria andCommodityPictureLessThanOrEqualTo(String value) {
            addCriterion("commodity_picture <=", value, "commodityPicture");
            return (Criteria) this;
        }

        public Criteria andCommodityPictureLike(String value) {
            addCriterion("commodity_picture like", value, "commodityPicture");
            return (Criteria) this;
        }

        public Criteria andCommodityPictureNotLike(String value) {
            addCriterion("commodity_picture not like", value, "commodityPicture");
            return (Criteria) this;
        }

        public Criteria andCommodityPictureIn(List<String> values) {
            addCriterion("commodity_picture in", values, "commodityPicture");
            return (Criteria) this;
        }

        public Criteria andCommodityPictureNotIn(List<String> values) {
            addCriterion("commodity_picture not in", values, "commodityPicture");
            return (Criteria) this;
        }

        public Criteria andCommodityPictureBetween(String value1, String value2) {
            addCriterion("commodity_picture between", value1, value2, "commodityPicture");
            return (Criteria) this;
        }

        public Criteria andCommodityPictureNotBetween(String value1, String value2) {
            addCriterion("commodity_picture not between", value1, value2, "commodityPicture");
            return (Criteria) this;
        }

        public Criteria andCommodityDescriptIsNull() {
            addCriterion("commodity_descript is null");
            return (Criteria) this;
        }

        public Criteria andCommodityDescriptIsNotNull() {
            addCriterion("commodity_descript is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityDescriptEqualTo(String value) {
            addCriterion("commodity_descript =", value, "commodityDescript");
            return (Criteria) this;
        }

        public Criteria andCommodityDescriptNotEqualTo(String value) {
            addCriterion("commodity_descript <>", value, "commodityDescript");
            return (Criteria) this;
        }

        public Criteria andCommodityDescriptGreaterThan(String value) {
            addCriterion("commodity_descript >", value, "commodityDescript");
            return (Criteria) this;
        }

        public Criteria andCommodityDescriptGreaterThanOrEqualTo(String value) {
            addCriterion("commodity_descript >=", value, "commodityDescript");
            return (Criteria) this;
        }

        public Criteria andCommodityDescriptLessThan(String value) {
            addCriterion("commodity_descript <", value, "commodityDescript");
            return (Criteria) this;
        }

        public Criteria andCommodityDescriptLessThanOrEqualTo(String value) {
            addCriterion("commodity_descript <=", value, "commodityDescript");
            return (Criteria) this;
        }

        public Criteria andCommodityDescriptLike(String value) {
            addCriterion("commodity_descript like", value, "commodityDescript");
            return (Criteria) this;
        }

        public Criteria andCommodityDescriptNotLike(String value) {
            addCriterion("commodity_descript not like", value, "commodityDescript");
            return (Criteria) this;
        }

        public Criteria andCommodityDescriptIn(List<String> values) {
            addCriterion("commodity_descript in", values, "commodityDescript");
            return (Criteria) this;
        }

        public Criteria andCommodityDescriptNotIn(List<String> values) {
            addCriterion("commodity_descript not in", values, "commodityDescript");
            return (Criteria) this;
        }

        public Criteria andCommodityDescriptBetween(String value1, String value2) {
            addCriterion("commodity_descript between", value1, value2, "commodityDescript");
            return (Criteria) this;
        }

        public Criteria andCommodityDescriptNotBetween(String value1, String value2) {
            addCriterion("commodity_descript not between", value1, value2, "commodityDescript");
            return (Criteria) this;
        }

        public Criteria andCommodityColorIsNull() {
            addCriterion("commodity_color is null");
            return (Criteria) this;
        }

        public Criteria andCommodityColorIsNotNull() {
            addCriterion("commodity_color is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityColorEqualTo(String value) {
            addCriterion("commodity_color =", value, "commodityColor");
            return (Criteria) this;
        }

        public Criteria andCommodityColorNotEqualTo(String value) {
            addCriterion("commodity_color <>", value, "commodityColor");
            return (Criteria) this;
        }

        public Criteria andCommodityColorGreaterThan(String value) {
            addCriterion("commodity_color >", value, "commodityColor");
            return (Criteria) this;
        }

        public Criteria andCommodityColorGreaterThanOrEqualTo(String value) {
            addCriterion("commodity_color >=", value, "commodityColor");
            return (Criteria) this;
        }

        public Criteria andCommodityColorLessThan(String value) {
            addCriterion("commodity_color <", value, "commodityColor");
            return (Criteria) this;
        }

        public Criteria andCommodityColorLessThanOrEqualTo(String value) {
            addCriterion("commodity_color <=", value, "commodityColor");
            return (Criteria) this;
        }

        public Criteria andCommodityColorLike(String value) {
            addCriterion("commodity_color like", value, "commodityColor");
            return (Criteria) this;
        }

        public Criteria andCommodityColorNotLike(String value) {
            addCriterion("commodity_color not like", value, "commodityColor");
            return (Criteria) this;
        }

        public Criteria andCommodityColorIn(List<String> values) {
            addCriterion("commodity_color in", values, "commodityColor");
            return (Criteria) this;
        }

        public Criteria andCommodityColorNotIn(List<String> values) {
            addCriterion("commodity_color not in", values, "commodityColor");
            return (Criteria) this;
        }

        public Criteria andCommodityColorBetween(String value1, String value2) {
            addCriterion("commodity_color between", value1, value2, "commodityColor");
            return (Criteria) this;
        }

        public Criteria andCommodityColorNotBetween(String value1, String value2) {
            addCriterion("commodity_color not between", value1, value2, "commodityColor");
            return (Criteria) this;
        }

        public Criteria andCommodityStyleIsNull() {
            addCriterion("commodity_style is null");
            return (Criteria) this;
        }

        public Criteria andCommodityStyleIsNotNull() {
            addCriterion("commodity_style is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityStyleEqualTo(String value) {
            addCriterion("commodity_style =", value, "commodityStyle");
            return (Criteria) this;
        }

        public Criteria andCommodityStyleNotEqualTo(String value) {
            addCriterion("commodity_style <>", value, "commodityStyle");
            return (Criteria) this;
        }

        public Criteria andCommodityStyleGreaterThan(String value) {
            addCriterion("commodity_style >", value, "commodityStyle");
            return (Criteria) this;
        }

        public Criteria andCommodityStyleGreaterThanOrEqualTo(String value) {
            addCriterion("commodity_style >=", value, "commodityStyle");
            return (Criteria) this;
        }

        public Criteria andCommodityStyleLessThan(String value) {
            addCriterion("commodity_style <", value, "commodityStyle");
            return (Criteria) this;
        }

        public Criteria andCommodityStyleLessThanOrEqualTo(String value) {
            addCriterion("commodity_style <=", value, "commodityStyle");
            return (Criteria) this;
        }

        public Criteria andCommodityStyleLike(String value) {
            addCriterion("commodity_style like", value, "commodityStyle");
            return (Criteria) this;
        }

        public Criteria andCommodityStyleNotLike(String value) {
            addCriterion("commodity_style not like", value, "commodityStyle");
            return (Criteria) this;
        }

        public Criteria andCommodityStyleIn(List<String> values) {
            addCriterion("commodity_style in", values, "commodityStyle");
            return (Criteria) this;
        }

        public Criteria andCommodityStyleNotIn(List<String> values) {
            addCriterion("commodity_style not in", values, "commodityStyle");
            return (Criteria) this;
        }

        public Criteria andCommodityStyleBetween(String value1, String value2) {
            addCriterion("commodity_style between", value1, value2, "commodityStyle");
            return (Criteria) this;
        }

        public Criteria andCommodityStyleNotBetween(String value1, String value2) {
            addCriterion("commodity_style not between", value1, value2, "commodityStyle");
            return (Criteria) this;
        }

        public Criteria andCommoditySourceIsNull() {
            addCriterion("commodity_source is null");
            return (Criteria) this;
        }

        public Criteria andCommoditySourceIsNotNull() {
            addCriterion("commodity_source is not null");
            return (Criteria) this;
        }

        public Criteria andCommoditySourceEqualTo(String value) {
            addCriterion("commodity_source =", value, "commoditySource");
            return (Criteria) this;
        }

        public Criteria andCommoditySourceNotEqualTo(String value) {
            addCriterion("commodity_source <>", value, "commoditySource");
            return (Criteria) this;
        }

        public Criteria andCommoditySourceGreaterThan(String value) {
            addCriterion("commodity_source >", value, "commoditySource");
            return (Criteria) this;
        }

        public Criteria andCommoditySourceGreaterThanOrEqualTo(String value) {
            addCriterion("commodity_source >=", value, "commoditySource");
            return (Criteria) this;
        }

        public Criteria andCommoditySourceLessThan(String value) {
            addCriterion("commodity_source <", value, "commoditySource");
            return (Criteria) this;
        }

        public Criteria andCommoditySourceLessThanOrEqualTo(String value) {
            addCriterion("commodity_source <=", value, "commoditySource");
            return (Criteria) this;
        }

        public Criteria andCommoditySourceLike(String value) {
            addCriterion("commodity_source like", value, "commoditySource");
            return (Criteria) this;
        }

        public Criteria andCommoditySourceNotLike(String value) {
            addCriterion("commodity_source not like", value, "commoditySource");
            return (Criteria) this;
        }

        public Criteria andCommoditySourceIn(List<String> values) {
            addCriterion("commodity_source in", values, "commoditySource");
            return (Criteria) this;
        }

        public Criteria andCommoditySourceNotIn(List<String> values) {
            addCriterion("commodity_source not in", values, "commoditySource");
            return (Criteria) this;
        }

        public Criteria andCommoditySourceBetween(String value1, String value2) {
            addCriterion("commodity_source between", value1, value2, "commoditySource");
            return (Criteria) this;
        }

        public Criteria andCommoditySourceNotBetween(String value1, String value2) {
            addCriterion("commodity_source not between", value1, value2, "commoditySource");
            return (Criteria) this;
        }

        public Criteria andCommodityDateIsNull() {
            addCriterion("commodity_date is null");
            return (Criteria) this;
        }

        public Criteria andCommodityDateIsNotNull() {
            addCriterion("commodity_date is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityDateEqualTo(Date value) {
            addCriterion("commodity_date =", value, "commodityDate");
            return (Criteria) this;
        }

        public Criteria andCommodityDateNotEqualTo(Date value) {
            addCriterion("commodity_date <>", value, "commodityDate");
            return (Criteria) this;
        }

        public Criteria andCommodityDateGreaterThan(Date value) {
            addCriterion("commodity_date >", value, "commodityDate");
            return (Criteria) this;
        }

        public Criteria andCommodityDateGreaterThanOrEqualTo(Date value) {
            addCriterion("commodity_date >=", value, "commodityDate");
            return (Criteria) this;
        }

        public Criteria andCommodityDateLessThan(Date value) {
            addCriterion("commodity_date <", value, "commodityDate");
            return (Criteria) this;
        }

        public Criteria andCommodityDateLessThanOrEqualTo(Date value) {
            addCriterion("commodity_date <=", value, "commodityDate");
            return (Criteria) this;
        }

        public Criteria andCommodityDateIn(List<Date> values) {
            addCriterion("commodity_date in", values, "commodityDate");
            return (Criteria) this;
        }

        public Criteria andCommodityDateNotIn(List<Date> values) {
            addCriterion("commodity_date not in", values, "commodityDate");
            return (Criteria) this;
        }

        public Criteria andCommodityDateBetween(Date value1, Date value2) {
            addCriterion("commodity_date between", value1, value2, "commodityDate");
            return (Criteria) this;
        }

        public Criteria andCommodityDateNotBetween(Date value1, Date value2) {
            addCriterion("commodity_date not between", value1, value2, "commodityDate");
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