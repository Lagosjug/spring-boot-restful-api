package com.bethelcrm.bbcmembersmanagementsystem.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


 @Entity// This tells Hibernate to make a table out of this class
 @Table(name = "members")
 @EntityListeners(AuditingEntityListener.class)
 //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
 public class MemberSchema {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "member_id", updatable = false, nullable = false)
   private Long id;

   @NotNull
   @Size(max = 50)
   @NotBlank(message="First name can not be empty")
   private String firstName;
   
   @NotNull
   @Size(max = 50)
   @NotBlank(message="Last name can not be empty")
   private String lastName;

   @Size(max = 50)
   private String middleName;

   @Email
   @Size(max = 255)
   private String emailId;

   @NotBlank(message="Gender can not be empty")
   private String gender;

   private int age;
   private Date createdAt;
   private String createdBy;
   private Date updatedAt;
   private String updatedBy;

   public MemberSchema(){

   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }
   
   @NotBlank(message = "Firstname can not be blank")
   @Column(name = "first_name")
   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }
   
   @NotBlank(message = "Lastname can not be blank")
   @Column(name = "last_name")
   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   @Column(name = "middle_name")
   public String getMiddleName() {
      return middleName;
   }

   public void setMiddleName(String middleName) {
      this.middleName = middleName;
   }
   @Column(name = "gender")
   public String getGender() {
      return gender;
   }

   public void setGender(String gender) {
      this.gender = gender;
   }

   @Column(name = "age")
   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public String getEmailId() {
      return emailId;
   }

   @Column(name = "email_address", unique = true)
   public void setEmailId(String emailId) {
      this.emailId = emailId;
   }

   @Column(name = "created_at", nullable = false)
   @CreatedDate
   public Date getCreatedAt() {
      return createdAt;
   }

   public void setCreatedAt(Date createdAt) {
      this.createdAt = createdAt;
   }

   @Column(name = "created_by", nullable = false)
   @CreatedBy
   public String getCreatedBy() {
      return createdBy;
   }

   public void setCreatedBy(String createdBy) {
      this.createdBy = createdBy;
   }

   @Column(name = "updated_at", nullable = false)
   //@Column(name = "updated_at")
   @LastModifiedDate
   public Date getUpdatedAt() {
      return updatedAt;
   }

   public void setUpdatedAt(Date updatedAt) {
      this.updatedAt = updatedAt;
   }

   @Column(name = "updated_by", nullable = false)
   @LastModifiedBy
   public String getUpdatedBy() {
      return updatedBy;
   }

   public void setUpdatedBy(String updatedBy) {
      this.updatedBy = updatedBy;
   }

   public Object getTitle() {
      return null;
   }

   // @Column(name = "gender", nullable = false)
   // public String getGender() {
   //    return gender;
   // }

   // public void setGender(String gender) {
   //    this.gender = gender;
   // }
 }

