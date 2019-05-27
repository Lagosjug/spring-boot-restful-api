package com.bethelcrm.bbcmembersmanagementsystem.services;

import java.util.List;

import com.bethelcrm.bbcmembersmanagementsystem.models.MemberSchema;
import com.bethelcrm.bbcmembersmanagementsystem.repositories.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberServiceImp implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public void createMember(MemberSchema member) {
        memberRepository.save(member);
    }

    public List<MemberSchema> getMember(){
        return memberRepository.findAll();
    }

    public MemberSchema getById(Long id) throws IllegalArgumentException {
        return memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }
    
    public void delete(Long id) throws IllegalArgumentException {
        MemberSchema memberSchema = getById(id);
        memberRepository.delete(memberSchema);
    }

}