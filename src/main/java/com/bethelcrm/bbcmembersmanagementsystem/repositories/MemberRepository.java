package com.bethelcrm.bbcmembersmanagementsystem.repositories;

import com.bethelcrm.bbcmembersmanagementsystem.models.MemberSchema;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberSchema, Long> {
   
}