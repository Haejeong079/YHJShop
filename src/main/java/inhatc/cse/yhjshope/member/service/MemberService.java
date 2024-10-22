package inhatc.cse.yhjshope.member.service;

import inhatc.cse.yhjshope.member.entity.Member;
import inhatc.cse.yhjshope.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {


    private final MemberRepository memberRepository;


    public Member saveMember(Member member){
        validateDuplicateMember(member);
        Member newMember = memberRepository.save(member);
        return newMember;
    }

    private void validateDuplicateMember(Member member) {


        Optional<Member> optMember = memberRepository.findByEmail(member.getEmail());
        if(optMember.isPresent()){
            Member member1 = optMember.get();
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

}
