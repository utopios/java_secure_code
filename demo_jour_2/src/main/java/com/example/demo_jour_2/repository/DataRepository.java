package com.example.demo_jour_2.repository;

import com.example.demo_jour_2.entity.DataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DataRepository extends JpaRepository<DataEntity, Long> {

    //Validation Injection SQL
    @Query("select d from DataEntity d where d.comment = :comment")
    DataEntity customRequest(@Param("comment") String comment);
}
