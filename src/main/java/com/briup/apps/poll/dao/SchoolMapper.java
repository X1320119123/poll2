package com.briup.apps.poll.dao;

import com.briup.apps.poll.bean.School;
import com.briup.apps.poll.bean.SchoolExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SchoolMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_school
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    long countByExample(SchoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_school
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    int deleteByExample(SchoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_school
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_school
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    int insert(School record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_school
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    int insertSelective(School record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_school
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    List<School> selectByExampleWithBLOBs(SchoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_school
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    List<School> selectByExample(SchoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_school
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    School selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_school
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    int updateByExampleSelective(@Param("record") School record, @Param("example") SchoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_school
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    int updateByExampleWithBLOBs(@Param("record") School record, @Param("example") SchoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_school
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    int updateByExample(@Param("record") School record, @Param("example") SchoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_school
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    int updateByPrimaryKeySelective(School record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_school
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(School record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_school
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    int updateByPrimaryKey(School record);
}