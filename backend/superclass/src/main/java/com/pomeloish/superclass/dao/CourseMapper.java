package com.pomeloish.superclass.dao;

import com.pomeloish.superclass.model.Course;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface CourseMapper {
    @Delete({
        "delete from superclass..course",
        "where course_id = #{courseId,jdbcType=INTEGER}",
          "and school_id = #{schoolId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(@Param("courseId") Integer courseId, @Param("schoolId") Integer schoolId);

    @Insert({
        "insert into superclass..course (course_id, school_id, ",
        "course_name, teacher_name)",
        "values (#{courseId,jdbcType=INTEGER}, #{schoolId,jdbcType=INTEGER}, ",
        "#{courseName,jdbcType=VARCHAR}, #{teacherName,jdbcType=VARCHAR})"
    })
    int insert(Course record);

    @Select({
        "select",
        "course_id, school_id, course_name, teacher_name",
        "from superclass..course",
        "where course_id = #{courseId,jdbcType=INTEGER}",
          "and school_id = #{schoolId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="school_id", property="schoolId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="course_name", property="courseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="teacher_name", property="teacherName", jdbcType=JdbcType.VARCHAR)
    })
    Course selectByPrimaryKey(@Param("courseId") Integer courseId, @Param("schoolId") Integer schoolId);

    @Select({
        "select",
        "course_id, school_id, course_name, teacher_name",
        "from superclass..course"
    })
    @Results({
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="school_id", property="schoolId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="course_name", property="courseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="teacher_name", property="teacherName", jdbcType=JdbcType.VARCHAR)
    })
    List<Course> selectAll();

    @Update({
        "update superclass..course",
        "set course_name = #{courseName,jdbcType=VARCHAR},",
          "teacher_name = #{teacherName,jdbcType=VARCHAR}",
        "where course_id = #{courseId,jdbcType=INTEGER}",
          "and school_id = #{schoolId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Course record);
}