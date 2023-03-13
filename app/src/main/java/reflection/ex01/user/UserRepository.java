package reflection.ex01.user;

import reflection.ex01.Controller;
import reflection.ex01.RequestMapping;

@Controller
public class UserRepository {

    @RequestMapping(uri = "/insert") // 위치를 잡고, 무엇을 할지 정해야함
    public void insert() {
        System.out.println("userinsert() 호출됨");
    }

}
