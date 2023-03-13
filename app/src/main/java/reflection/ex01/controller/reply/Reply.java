package reflection.ex01.controller.reply;

import reflection.ex01.Controller;
import reflection.ex01.RequestMapping;

@Controller
public class Reply {

    @RequestMapping(uri = "/reply")
    public void reply() {
        System.out.println("reply() 호출됨");
    }
}
