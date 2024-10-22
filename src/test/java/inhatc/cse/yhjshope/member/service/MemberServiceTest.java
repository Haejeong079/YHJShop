package inhatc.cse.yhjshope.member.service;

import inhatc.cse.yhjshope.member.dto.MemberDto;
import inhatc.cse.yhjshope.member.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Test
    @DisplayName("회원 가입 테스트")
    void saveMember() {
        Member member = createMember();
        System.out.println(member);
        Member saveMember = memberService.saveMember(member);
        System.out.println(saveMember);

        assertEquals(member.getEmail(), saveMember.getEmail());
    }

    private Member createMember() {
        MemberDto memberDto = MemberDto.builder()
                .address("인천 미추홀구")
                .email("test@test.com")
                .name("홍길동")
                .password("111111")
                .build();
        System.out.println(memberDto);
        Member member = Member.createMember(memberDto,passwordEncoder);

        return member;
    }
}