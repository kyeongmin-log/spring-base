package base.springbase.repository;

import base.springbase.domain.Member;

import java.util.List; //배열리스트, 연결리스트, 스택, 큐 등을 사용 가능
import java.util.Optional; //넘어온 값이 null일 때, 따로 null값을 반환하지 않아도 null을 반환시켜준다.

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
