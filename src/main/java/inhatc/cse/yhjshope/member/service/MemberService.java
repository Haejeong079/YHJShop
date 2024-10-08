package inhatc.cse.yhjshope.member.service;

import inhatc.cse.yhjshope.member.entity.Member;
import inhatc.cse.yhjshope.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {


    private final MemberRepository memberRepository;


    public Member saveMember(Member member){
        validateDuplicateMember(member);
        Member newMember = memberRepository.save(member);
        return newMember;
    }

    private void validateDuplicateMember(Member member) {
//        Optional<Member> mem = memberRepository.findByEmail(member.getEmail());
//        if(!mem.isPresent()){
//            Member m = mem.get();
//            System.out.println(m);
//            throw new IllegalStateException("이미 가입된 회원입니다.");
//        }

        Member m2 = memberRepository.findByEmail(member.getEmail())
                .orElseThrow(()-> new IllegalStateException("이미 가입된 회원입니다."));
        System.out.println(m2);
    }

}
