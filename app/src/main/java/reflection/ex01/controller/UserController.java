package reflection.ex01.controller;

import reflection.ex01.Controller;
import reflection.ex01.RequestMapping;

@Controller
public class UserController {

    @RequestMapping(uri = "/login") // 위치를 잡고, 무엇을 할지 정해야함
    public void login() {
        System.out.println("login() 호출됨");
    }

    @RequestMapping(uri = "/join")
    public void join() {
        System.out.println("join() 호출됨");
    }

    @RequestMapping(uri = "/joinForm")
    public void joinForm() {
        System.out.println("joinForm() 호출됨");
    }

    @RequestMapping(uri = "/userInfo")
    public void userInfo() {
        System.out.println("userInfo() 호출됨");
    }
}
