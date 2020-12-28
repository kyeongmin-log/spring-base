package base.springbase.controller;

import org.springframework.stereotype.Controller;

@Controller
public class MemberForm {
    //createMemberForm.html form 에서 name="name" 으로 넘어온 값이 setName()을 통해 값이 들어간다.
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
