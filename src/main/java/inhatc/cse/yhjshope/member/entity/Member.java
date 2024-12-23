package inhatc.cse.yhjshope.member.entity;


import inhatc.cse.yhjshope.common.entity.BaseEntity;
import inhatc.cse.yhjshope.member.constant.Role;
import inhatc.cse.yhjshope.member.dto.MemberDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(unique = true, length = 50)
    private String email;

    @Column(nullable = false, length = 200)
    private String password;

    @Column(length = 150)
    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;


    public static Member createMember(MemberDto memberDto,
                                      PasswordEncoder passwordEncoder){

        Member member = Member.builder()
                .name(memberDto.getName())
                .email(memberDto.getEmail())
                .address(memberDto.getAddress())
                .password(passwordEncoder.encode(memberDto.getPassword()))
                .role(Role.USER)
                .build();


        return member;

    }

}
