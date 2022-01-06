package com.qxf.hiswww.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TCourseExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_course
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_course
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_course
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    public TCourseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    public TCourseExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    public TCourseExample orderBy(String ... orderByClauses) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < orderByClauses.length; i++) {
            sb.append(orderByClauses[i]);
            if (i < orderByClauses.length - 1) {
                sb.append(" , ");
            }
        }
        this.setOrderByClause(sb.toString());
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria(this);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    public static Criteria newAndCreateCriteria() {
        TCourseExample example = new TCourseExample();
        return example.createCriteria();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    public TCourseExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated
     */
    public TCourseExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_course
     *
     * @mbg.generated
     */
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andIdEqualToColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andIdNotEqualToColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andIdGreaterThanColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andIdGreaterThanOrEqualToColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andIdLessThanColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andIdLessThanOrEqualToColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andNameEqualToColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("`name` = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andNameNotEqualToColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("`name` <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andNameGreaterThanColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("`name` > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andNameGreaterThanOrEqualToColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("`name` >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andNameLessThanColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("`name` < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andNameLessThanOrEqualToColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("`name` <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andStartStimeIsNull() {
            addCriterion("start_stime is null");
            return (Criteria) this;
        }

        public Criteria andStartStimeIsNotNull() {
            addCriterion("start_stime is not null");
            return (Criteria) this;
        }

        public Criteria andStartStimeEqualTo(LocalDate value) {
            addCriterion("start_stime =", value, "startStime");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andStartStimeEqualToColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("start_stime = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStartStimeNotEqualTo(LocalDate value) {
            addCriterion("start_stime <>", value, "startStime");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andStartStimeNotEqualToColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("start_stime <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStartStimeGreaterThan(LocalDate value) {
            addCriterion("start_stime >", value, "startStime");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andStartStimeGreaterThanColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("start_stime > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStartStimeGreaterThanOrEqualTo(LocalDate value) {
            addCriterion("start_stime >=", value, "startStime");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andStartStimeGreaterThanOrEqualToColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("start_stime >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStartStimeLessThan(LocalDate value) {
            addCriterion("start_stime <", value, "startStime");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andStartStimeLessThanColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("start_stime < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStartStimeLessThanOrEqualTo(LocalDate value) {
            addCriterion("start_stime <=", value, "startStime");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andStartStimeLessThanOrEqualToColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("start_stime <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStartStimeIn(List<LocalDate> values) {
            addCriterion("start_stime in", values, "startStime");
            return (Criteria) this;
        }

        public Criteria andStartStimeNotIn(List<LocalDate> values) {
            addCriterion("start_stime not in", values, "startStime");
            return (Criteria) this;
        }

        public Criteria andStartStimeBetween(LocalDate value1, LocalDate value2) {
            addCriterion("start_stime between", value1, value2, "startStime");
            return (Criteria) this;
        }

        public Criteria andStartStimeNotBetween(LocalDate value1, LocalDate value2) {
            addCriterion("start_stime not between", value1, value2, "startStime");
            return (Criteria) this;
        }

        public Criteria andEndEtimeIsNull() {
            addCriterion("end_etime is null");
            return (Criteria) this;
        }

        public Criteria andEndEtimeIsNotNull() {
            addCriterion("end_etime is not null");
            return (Criteria) this;
        }

        public Criteria andEndEtimeEqualTo(LocalDate value) {
            addCriterion("end_etime =", value, "endEtime");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andEndEtimeEqualToColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("end_etime = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEndEtimeNotEqualTo(LocalDate value) {
            addCriterion("end_etime <>", value, "endEtime");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andEndEtimeNotEqualToColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("end_etime <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEndEtimeGreaterThan(LocalDate value) {
            addCriterion("end_etime >", value, "endEtime");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andEndEtimeGreaterThanColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("end_etime > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEndEtimeGreaterThanOrEqualTo(LocalDate value) {
            addCriterion("end_etime >=", value, "endEtime");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andEndEtimeGreaterThanOrEqualToColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("end_etime >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEndEtimeLessThan(LocalDate value) {
            addCriterion("end_etime <", value, "endEtime");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andEndEtimeLessThanColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("end_etime < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEndEtimeLessThanOrEqualTo(LocalDate value) {
            addCriterion("end_etime <=", value, "endEtime");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andEndEtimeLessThanOrEqualToColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("end_etime <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEndEtimeIn(List<LocalDate> values) {
            addCriterion("end_etime in", values, "endEtime");
            return (Criteria) this;
        }

        public Criteria andEndEtimeNotIn(List<LocalDate> values) {
            addCriterion("end_etime not in", values, "endEtime");
            return (Criteria) this;
        }

        public Criteria andEndEtimeBetween(LocalDate value1, LocalDate value2) {
            addCriterion("end_etime between", value1, value2, "endEtime");
            return (Criteria) this;
        }

        public Criteria andEndEtimeNotBetween(LocalDate value1, LocalDate value2) {
            addCriterion("end_etime not between", value1, value2, "endEtime");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIsNull() {
            addCriterion("course_type is null");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIsNotNull() {
            addCriterion("course_type is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTypeEqualTo(String value) {
            addCriterion("course_type =", value, "courseType");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andCourseTypeEqualToColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("course_type = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotEqualTo(String value) {
            addCriterion("course_type <>", value, "courseType");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andCourseTypeNotEqualToColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("course_type <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCourseTypeGreaterThan(String value) {
            addCriterion("course_type >", value, "courseType");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andCourseTypeGreaterThanColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("course_type > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCourseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("course_type >=", value, "courseType");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andCourseTypeGreaterThanOrEqualToColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("course_type >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCourseTypeLessThan(String value) {
            addCriterion("course_type <", value, "courseType");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andCourseTypeLessThanColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("course_type < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCourseTypeLessThanOrEqualTo(String value) {
            addCriterion("course_type <=", value, "courseType");
            return (Criteria) this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria andCourseTypeLessThanOrEqualToColumn(TCourse.Column column) {
            addCriterion(new StringBuilder("course_type <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCourseTypeLike(String value) {
            addCriterion("course_type like", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotLike(String value) {
            addCriterion("course_type not like", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIn(List<String> values) {
            addCriterion("course_type in", values, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotIn(List<String> values) {
            addCriterion("course_type not in", values, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeBetween(String value1, String value2) {
            addCriterion("course_type between", value1, value2, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotBetween(String value1, String value2) {
            addCriterion("course_type not between", value1, value2, "courseType");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_course
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {
        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table t_course
         *
         * @mbg.generated
         */
        private TCourseExample example;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        protected Criteria(TCourseExample example) {
            super();
            this.example = example;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public TCourseExample example() {
            return this.example;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        @Deprecated
        public Criteria andIf(boolean ifAdd, ICriteriaAdd add) {
            if (ifAdd) {
                add.add(this);
            }
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria when(boolean condition, ICriteriaWhen then) {
            if (condition) {
                then.criteria(this);
            }
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        public Criteria when(boolean condition, ICriteriaWhen then, ICriteriaWhen otherwise) {
            if (condition) {
                then.criteria(this);
            } else {
                otherwise.criteria(this);
            }
            return this;
        }

        @Deprecated
        public interface ICriteriaAdd {
            /**
             * This method was generated by MyBatis Generator.
             * This method corresponds to the database table t_course
             *
             * @mbg.generated
             */
            Criteria add(Criteria add);
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_course
     *
     * @mbg.generated
     */
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

    public interface ICriteriaWhen {
        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        void criteria(Criteria criteria);
    }

    public interface IExampleWhen {
        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_course
         *
         * @mbg.generated
         */
        void example(com.qxf.hiswww.domain.TCourseExample example);
    }
}