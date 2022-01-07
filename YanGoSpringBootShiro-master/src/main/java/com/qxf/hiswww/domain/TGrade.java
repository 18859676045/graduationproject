package com.qxf.hiswww.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class TGrade {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_grade.id
     *
     * @mbg.generated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_grade.student_id
     *
     * @mbg.generated
     */
    private String studentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_grade.course_id
     *
     * @mbg.generated
     */
    private String courseId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_grade.exam_time
     *
     * @mbg.generated
     */
    private LocalDate examTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_grade.exam_type
     *
     * @mbg.generated
     */
    private Integer examType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_grade.score
     *
     * @mbg.generated
     */
    private Double score;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_grade.teacher_id
     *
     * @mbg.generated
     */
    private String teacherId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_grade.status
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_grade.id
     *
     * @return the value of t_grade.id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_grade.id
     *
     * @param id the value for t_grade.id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_grade.student_id
     *
     * @return the value of t_grade.student_id
     *
     * @mbg.generated
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_grade.student_id
     *
     * @param studentId the value for t_grade.student_id
     *
     * @mbg.generated
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_grade.course_id
     *
     * @return the value of t_grade.course_id
     *
     * @mbg.generated
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_grade.course_id
     *
     * @param courseId the value for t_grade.course_id
     *
     * @mbg.generated
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_grade.exam_time
     *
     * @return the value of t_grade.exam_time
     *
     * @mbg.generated
     */
    public LocalDate getExamTime() {
        return examTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_grade.exam_time
     *
     * @param examTime the value for t_grade.exam_time
     *
     * @mbg.generated
     */
    public void setExamTime(LocalDate examTime) {
        this.examTime = examTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_grade.exam_type
     *
     * @return the value of t_grade.exam_type
     *
     * @mbg.generated
     */
    public Integer getExamType() {
        return examType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_grade.exam_type
     *
     * @param examType the value for t_grade.exam_type
     *
     * @mbg.generated
     */
    public void setExamType(Integer examType) {
        this.examType = examType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_grade.score
     *
     * @return the value of t_grade.score
     *
     * @mbg.generated
     */
    public Double getScore() {
        return score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_grade.score
     *
     * @param score the value for t_grade.score
     *
     * @mbg.generated
     */
    public void setScore(Double score) {
        this.score = score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_grade.teacher_id
     *
     * @return the value of t_grade.teacher_id
     *
     * @mbg.generated
     */
    public String getTeacherId() {
        return teacherId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_grade.teacher_id
     *
     * @param teacherId the value for t_grade.teacher_id
     *
     * @mbg.generated
     */
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_grade.status
     *
     * @return the value of t_grade.status
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_grade.status
     *
     * @param status the value for t_grade.status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_grade
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", studentId=").append(studentId);
        sb.append(", courseId=").append(courseId);
        sb.append(", examTime=").append(examTime);
        sb.append(", examType=").append(examType);
        sb.append(", score=").append(score);
        sb.append(", teacherId=").append(teacherId);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_grade
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TGrade other = (TGrade) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStudentId() == null ? other.getStudentId() == null : this.getStudentId().equals(other.getStudentId()))
            && (this.getCourseId() == null ? other.getCourseId() == null : this.getCourseId().equals(other.getCourseId()))
            && (this.getExamTime() == null ? other.getExamTime() == null : this.getExamTime().equals(other.getExamTime()))
            && (this.getExamType() == null ? other.getExamType() == null : this.getExamType().equals(other.getExamType()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getTeacherId() == null ? other.getTeacherId() == null : this.getTeacherId().equals(other.getTeacherId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_grade
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStudentId() == null) ? 0 : getStudentId().hashCode());
        result = prime * result + ((getCourseId() == null) ? 0 : getCourseId().hashCode());
        result = prime * result + ((getExamTime() == null) ? 0 : getExamTime().hashCode());
        result = prime * result + ((getExamType() == null) ? 0 : getExamType().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getTeacherId() == null) ? 0 : getTeacherId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table t_grade
     *
     * @mbg.generated
     */
    public enum Column {
        id("id", "id", "VARCHAR", false),
        studentId("student_id", "studentId", "VARCHAR", false),
        courseId("course_id", "courseId", "VARCHAR", false),
        examTime("exam_time", "examTime", "DATE", false),
        examType("exam_type", "examType", "INTEGER", false),
        score("score", "score", "DOUBLE", false),
        teacherId("teacher_id", "teacherId", "VARCHAR", false),
        status("status", "status", "INTEGER", true);

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table t_grade
         *
         * @mbg.generated
         */
        private static final String BEGINNING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table t_grade
         *
         * @mbg.generated
         */
        private static final String ENDING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table t_grade
         *
         * @mbg.generated
         */
        private final String column;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table t_grade
         *
         * @mbg.generated
         */
        private final boolean isColumnNameDelimited;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table t_grade
         *
         * @mbg.generated
         */
        private final String javaProperty;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table t_grade
         *
         * @mbg.generated
         */
        private final String jdbcType;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_grade
         *
         * @mbg.generated
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_grade
         *
         * @mbg.generated
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_grade
         *
         * @mbg.generated
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_grade
         *
         * @mbg.generated
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_grade
         *
         * @mbg.generated
         */
        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_grade
         *
         * @mbg.generated
         */
        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_grade
         *
         * @mbg.generated
         */
        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_grade
         *
         * @mbg.generated
         */
        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_grade
         *
         * @mbg.generated
         */
        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_grade
         *
         * @mbg.generated
         */
        public String getAliasedEscapedColumnName() {
            return this.getEscapedColumnName();
        }
    }
}