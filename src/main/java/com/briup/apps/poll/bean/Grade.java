package com.briup.apps.poll.bean;

public class Grade {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_grade.id
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_grade.name
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_grade.description
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_grade.school_id
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    private Long schoolId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_grade.id
     *
     * @return the value of poll_grade.id
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_grade.id
     *
     * @param id the value for poll_grade.id
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_grade.name
     *
     * @return the value of poll_grade.name
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_grade.name
     *
     * @param name the value for poll_grade.name
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_grade.description
     *
     * @return the value of poll_grade.description
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_grade.description
     *
     * @param description the value for poll_grade.description
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_grade.school_id
     *
     * @return the value of poll_grade.school_id
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    public Long getSchoolId() {
        return schoolId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_grade.school_id
     *
     * @param schoolId the value for poll_grade.school_id
     *
     * @mbg.generated Mon Jun 25 16:40:33 CST 2018
     */
    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }
}