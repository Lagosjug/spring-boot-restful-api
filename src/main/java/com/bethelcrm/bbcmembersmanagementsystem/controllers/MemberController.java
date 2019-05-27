package com.bethelcrm.bbcmembersmanagementsystem.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.bethelcrm.bbcmembersmanagementsystem.models.MemberSchema;
import com.bethelcrm.bbcmembersmanagementsystem.services.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // Create a new Member
    @PostMapping(value ="/members", headers="Accept=application/json")
    public  ResponseEntity<?> createMember(@Valid @RequestBody MemberSchema memberSchema, BindingResult result) {
        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error : result.getFieldErrors()){
              errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap,HttpStatus.BAD_REQUEST);
        }
        System.out.println("Creating Member "+memberSchema.getFirstName());
        memberService.createMember(memberSchema);
        HttpHeaders headers = new HttpHeaders();
       // headers.setLocation(ucBuilder.path("/members/{id}").buildAndExpand(memberSchema.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    // Get All Members
    @GetMapping(value = "/members")
    public List<MemberSchema> getAllMembers() {
        return memberService.getMember();
    }
     //Get a single member
    @GetMapping(value = "/members/{member_id}")
    public ResponseEntity<?> getMemberById(@PathVariable Long member_id) {
        MemberSchema memberSchema = memberService.getById(member_id);
        return new ResponseEntity<MemberSchema>(memberSchema, HttpStatus.OK);
    }
    //Delete a member
    @DeleteMapping(value = "/members/{member_id}")
    public ResponseEntity<?> deleteMember(@PathVariable(value = "member_id") Long member_id) {
        memberService.delete(member_id);
        return new ResponseEntity<String>("Member has been successfully deleted", HttpStatus.OK);
    }

     //Update a member
     @PutMapping(value = "/members/{member_id}")
     public ResponseEntity<?> updateMember(@PathVariable Long member_id, @Valid @RequestBody MemberSchema memberSchema) {
        MemberSchema findMember = memberService.getById(member_id);
        memberService.createMember(findMember);
         return new ResponseEntity<MemberSchema>(findMember, HttpStatus.OK);
     }

}