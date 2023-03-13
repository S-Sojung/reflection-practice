package reflection.ex01.controller;

import reflection.ex01.Controller;
import reflection.ex01.RequestMapping;

@Controller
public class BoardController {

    @RequestMapping(uri = "/save")
    public void save() {
        System.out.println("save() 호출됨");
    }
}
