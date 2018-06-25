package com.briup.apps.poll.dao;

import com.briup.apps.poll.bean.survey;
import com.briup.apps.poll.bean.surveyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface surveyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_survey
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    long countByExample(surveyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_survey
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    int deleteByExample(surveyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_survey
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_survey
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    int insert(survey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_survey
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    int insertSelective(survey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_survey
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    List<survey> selectByExample(surveyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_survey
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    survey selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_survey
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    int updateByExampleSelective(@Param("record") survey record, @Param("example") surveyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_survey
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    int updateByExample(@Param("record") survey record, @Param("example") surveyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_survey
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    int updateByPrimaryKeySelective(survey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_survey
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    int updateByPrimaryKey(survey record);
}