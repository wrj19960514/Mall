package com.cskaoyan.mall.bean;

import java.util.ArrayList;
import java.util.List;

public class OrderHandleoptionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderHandleoptionExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andCancelIsNull() {
            addCriterion("cancel is null");
            return (Criteria) this;
        }

        public Criteria andCancelIsNotNull() {
            addCriterion("cancel is not null");
            return (Criteria) this;
        }

        public Criteria andCancelEqualTo(Boolean value) {
            addCriterion("cancel =", value, "cancel");
            return (Criteria) this;
        }

        public Criteria andCancelNotEqualTo(Boolean value) {
            addCriterion("cancel <>", value, "cancel");
            return (Criteria) this;
        }

        public Criteria andCancelGreaterThan(Boolean value) {
            addCriterion("cancel >", value, "cancel");
            return (Criteria) this;
        }

        public Criteria andCancelGreaterThanOrEqualTo(Boolean value) {
            addCriterion("cancel >=", value, "cancel");
            return (Criteria) this;
        }

        public Criteria andCancelLessThan(Boolean value) {
            addCriterion("cancel <", value, "cancel");
            return (Criteria) this;
        }

        public Criteria andCancelLessThanOrEqualTo(Boolean value) {
            addCriterion("cancel <=", value, "cancel");
            return (Criteria) this;
        }

        public Criteria andCancelIn(List<Boolean> values) {
            addCriterion("cancel in", values, "cancel");
            return (Criteria) this;
        }

        public Criteria andCancelNotIn(List<Boolean> values) {
            addCriterion("cancel not in", values, "cancel");
            return (Criteria) this;
        }

        public Criteria andCancelBetween(Boolean value1, Boolean value2) {
            addCriterion("cancel between", value1, value2, "cancel");
            return (Criteria) this;
        }

        public Criteria andCancelNotBetween(Boolean value1, Boolean value2) {
            addCriterion("cancel not between", value1, value2, "cancel");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(Boolean value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(Boolean value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(Boolean value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(Boolean value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(Boolean value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(Boolean value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<Boolean> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<Boolean> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(Boolean value1, Boolean value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(Boolean value1, Boolean value2) {
            addCriterion("comment not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andConfirmIsNull() {
            addCriterion("confirm is null");
            return (Criteria) this;
        }

        public Criteria andConfirmIsNotNull() {
            addCriterion("confirm is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmEqualTo(Boolean value) {
            addCriterion("confirm =", value, "confirm");
            return (Criteria) this;
        }

        public Criteria andConfirmNotEqualTo(Boolean value) {
            addCriterion("confirm <>", value, "confirm");
            return (Criteria) this;
        }

        public Criteria andConfirmGreaterThan(Boolean value) {
            addCriterion("confirm >", value, "confirm");
            return (Criteria) this;
        }

        public Criteria andConfirmGreaterThanOrEqualTo(Boolean value) {
            addCriterion("confirm >=", value, "confirm");
            return (Criteria) this;
        }

        public Criteria andConfirmLessThan(Boolean value) {
            addCriterion("confirm <", value, "confirm");
            return (Criteria) this;
        }

        public Criteria andConfirmLessThanOrEqualTo(Boolean value) {
            addCriterion("confirm <=", value, "confirm");
            return (Criteria) this;
        }

        public Criteria andConfirmIn(List<Boolean> values) {
            addCriterion("confirm in", values, "confirm");
            return (Criteria) this;
        }

        public Criteria andConfirmNotIn(List<Boolean> values) {
            addCriterion("confirm not in", values, "confirm");
            return (Criteria) this;
        }

        public Criteria andConfirmBetween(Boolean value1, Boolean value2) {
            addCriterion("confirm between", value1, value2, "confirm");
            return (Criteria) this;
        }

        public Criteria andConfirmNotBetween(Boolean value1, Boolean value2) {
            addCriterion("confirm not between", value1, value2, "confirm");
            return (Criteria) this;
        }

        public Criteria andDeleteIsNull() {
            addCriterion("delete is null");
            return (Criteria) this;
        }

        public Criteria andDeleteIsNotNull() {
            addCriterion("delete is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteEqualTo(Boolean value) {
            addCriterion("delete =", value, "delete");
            return (Criteria) this;
        }

        public Criteria andDeleteNotEqualTo(Boolean value) {
            addCriterion("delete <>", value, "delete");
            return (Criteria) this;
        }

        public Criteria andDeleteGreaterThan(Boolean value) {
            addCriterion("delete >", value, "delete");
            return (Criteria) this;
        }

        public Criteria andDeleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("delete >=", value, "delete");
            return (Criteria) this;
        }

        public Criteria andDeleteLessThan(Boolean value) {
            addCriterion("delete <", value, "delete");
            return (Criteria) this;
        }

        public Criteria andDeleteLessThanOrEqualTo(Boolean value) {
            addCriterion("delete <=", value, "delete");
            return (Criteria) this;
        }

        public Criteria andDeleteIn(List<Boolean> values) {
            addCriterion("delete in", values, "delete");
            return (Criteria) this;
        }

        public Criteria andDeleteNotIn(List<Boolean> values) {
            addCriterion("delete not in", values, "delete");
            return (Criteria) this;
        }

        public Criteria andDeleteBetween(Boolean value1, Boolean value2) {
            addCriterion("delete between", value1, value2, "delete");
            return (Criteria) this;
        }

        public Criteria andDeleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("delete not between", value1, value2, "delete");
            return (Criteria) this;
        }

        public Criteria andPayIsNull() {
            addCriterion("pay is null");
            return (Criteria) this;
        }

        public Criteria andPayIsNotNull() {
            addCriterion("pay is not null");
            return (Criteria) this;
        }

        public Criteria andPayEqualTo(Boolean value) {
            addCriterion("pay =", value, "pay");
            return (Criteria) this;
        }

        public Criteria andPayNotEqualTo(Boolean value) {
            addCriterion("pay <>", value, "pay");
            return (Criteria) this;
        }

        public Criteria andPayGreaterThan(Boolean value) {
            addCriterion("pay >", value, "pay");
            return (Criteria) this;
        }

        public Criteria andPayGreaterThanOrEqualTo(Boolean value) {
            addCriterion("pay >=", value, "pay");
            return (Criteria) this;
        }

        public Criteria andPayLessThan(Boolean value) {
            addCriterion("pay <", value, "pay");
            return (Criteria) this;
        }

        public Criteria andPayLessThanOrEqualTo(Boolean value) {
            addCriterion("pay <=", value, "pay");
            return (Criteria) this;
        }

        public Criteria andPayIn(List<Boolean> values) {
            addCriterion("pay in", values, "pay");
            return (Criteria) this;
        }

        public Criteria andPayNotIn(List<Boolean> values) {
            addCriterion("pay not in", values, "pay");
            return (Criteria) this;
        }

        public Criteria andPayBetween(Boolean value1, Boolean value2) {
            addCriterion("pay between", value1, value2, "pay");
            return (Criteria) this;
        }

        public Criteria andPayNotBetween(Boolean value1, Boolean value2) {
            addCriterion("pay not between", value1, value2, "pay");
            return (Criteria) this;
        }

        public Criteria andRebuyIsNull() {
            addCriterion("rebuy is null");
            return (Criteria) this;
        }

        public Criteria andRebuyIsNotNull() {
            addCriterion("rebuy is not null");
            return (Criteria) this;
        }

        public Criteria andRebuyEqualTo(Boolean value) {
            addCriterion("rebuy =", value, "rebuy");
            return (Criteria) this;
        }

        public Criteria andRebuyNotEqualTo(Boolean value) {
            addCriterion("rebuy <>", value, "rebuy");
            return (Criteria) this;
        }

        public Criteria andRebuyGreaterThan(Boolean value) {
            addCriterion("rebuy >", value, "rebuy");
            return (Criteria) this;
        }

        public Criteria andRebuyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("rebuy >=", value, "rebuy");
            return (Criteria) this;
        }

        public Criteria andRebuyLessThan(Boolean value) {
            addCriterion("rebuy <", value, "rebuy");
            return (Criteria) this;
        }

        public Criteria andRebuyLessThanOrEqualTo(Boolean value) {
            addCriterion("rebuy <=", value, "rebuy");
            return (Criteria) this;
        }

        public Criteria andRebuyIn(List<Boolean> values) {
            addCriterion("rebuy in", values, "rebuy");
            return (Criteria) this;
        }

        public Criteria andRebuyNotIn(List<Boolean> values) {
            addCriterion("rebuy not in", values, "rebuy");
            return (Criteria) this;
        }

        public Criteria andRebuyBetween(Boolean value1, Boolean value2) {
            addCriterion("rebuy between", value1, value2, "rebuy");
            return (Criteria) this;
        }

        public Criteria andRebuyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("rebuy not between", value1, value2, "rebuy");
            return (Criteria) this;
        }

        public Criteria andRefundIsNull() {
            addCriterion("refund is null");
            return (Criteria) this;
        }

        public Criteria andRefundIsNotNull() {
            addCriterion("refund is not null");
            return (Criteria) this;
        }

        public Criteria andRefundEqualTo(Boolean value) {
            addCriterion("refund =", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundNotEqualTo(Boolean value) {
            addCriterion("refund <>", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundGreaterThan(Boolean value) {
            addCriterion("refund >", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundGreaterThanOrEqualTo(Boolean value) {
            addCriterion("refund >=", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundLessThan(Boolean value) {
            addCriterion("refund <", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundLessThanOrEqualTo(Boolean value) {
            addCriterion("refund <=", value, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundIn(List<Boolean> values) {
            addCriterion("refund in", values, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundNotIn(List<Boolean> values) {
            addCriterion("refund not in", values, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundBetween(Boolean value1, Boolean value2) {
            addCriterion("refund between", value1, value2, "refund");
            return (Criteria) this;
        }

        public Criteria andRefundNotBetween(Boolean value1, Boolean value2) {
            addCriterion("refund not between", value1, value2, "refund");
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