package com.testmobydigital.projection;

import java.util.Date;

public interface CandidateByTechnologiesNameProjection {

    String getName();

    void setName(String name);

    String getLastname();

    void setLastname(String lastname);

    Integer getDocument_number();

    void setDocument_number(Integer document_number);

    Date getBirthdate();

    void setBirthdate(Date birthdate);

    String getTechnology_name();

    void setTechnology_name(String technology_name);

    Integer getVersion();

    void setVersion(Integer version);

    Integer getYears_experience();

    void setYears_experience();
}
