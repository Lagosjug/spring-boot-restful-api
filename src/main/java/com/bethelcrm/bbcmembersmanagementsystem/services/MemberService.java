package com.bethelcrm.bbcmembersmanagementsystem.services;

import java.util.List;

import com.bethelcrm.bbcmembersmanagementsystem.models.MemberSchema;

public interface MemberService {
    public void createMember(MemberSchema member);
    public List<MemberSchema> getMember();
    public MemberSchema getById(Long id);
    public void delete(Long id);
    // public void update(Long id);
}