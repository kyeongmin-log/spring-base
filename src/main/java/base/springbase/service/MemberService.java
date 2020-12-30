package base.springbase.service;

import base.springbase.domain.Member;
import base.springbase.repository.MemberRepository;
import base.springbase.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Service
@Transactional
public class MemberService {
    //인터페이스로 선언 구현된 클래스로 인스턴스를 생성
    private final MemberRepository memberRepository;
    /*
        해당 객체의 인스턴스가 여러 개 생기게 되면, 각각의 인스턴스에 값을 저장할 가능성이 있다.
        (같은 DB를 사용하는 것이 아닌 서로 다른 DB를 사용하고 있다는 것)
        이렇게 사용할 경우, 후에 데이터를 수정하거나 바꾸는데 매우 불편하므로
        (해당 데이터를 찾기 위해 여러 개의 인스턴스를 다 둘러봐야함으로)
        이를 방지하기 위해 객체를 생성하는 부분을 외부에서 '넣어' 주도록 바꿔준다.
        (이러면 하나의 인스턴스로 관리할 수 있다. - 싱글톤 패턴)
        이를 DI(Dependency Injection)이라고 한다.
    */
    //@Autowired
    //여기서 보면 MemberService는 MemberRepository를 필요로 하기에(즉, 의존하기에)
    //@Autowired 로 연결시켜 준 모습니다.
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입
    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        //예시 상황. 회원 가입 중 같은 이름이 있는 회원은 안된다는 상황을 가정(비즈니스 요구사항)
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회웝입니다.");
//        });
        //위처럼 사용할 수 있지만 callback 을 이용해서 더 간소화 시킬 수 있다.
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    //전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    //단일 회원 조회
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
