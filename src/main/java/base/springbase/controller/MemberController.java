package base.springbase.controller;

import base.springbase.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    //스프링 빈과 스프링 빈을 연결한다.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
