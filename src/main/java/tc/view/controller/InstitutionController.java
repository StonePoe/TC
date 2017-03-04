package tc.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by stonezhang on 2017/3/2.
 */
@Controller
@RequestMapping("/institution")
public class InstitutionController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String doLoginPage() {
        return "institution/institutionLogin";
    }
}
