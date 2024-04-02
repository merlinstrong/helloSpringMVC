package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.Offer;
import kr.ac.hansung.cse.model.User;
import kr.ac.hansung.cse.service.LoginService;
import kr.ac.hansung.cse.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class LoginController {

    // Controller -> Service -> Dao
    @Autowired
    private LoginService loginService;


    @GetMapping("/login")
    public String showLogin( @RequestParam(value="error", required = false) String error,
                            @RequestParam(value="logout", required = false) String logout,
                            Model model) {

                model.addAttribute("user", new User());

//        for (User user : users) {
//            System.out.println(user);
//        }

        if(error != null) {
            model.addAttribute("errorMsg","Invalid username or password");
        }

        if(logout != null) {
            model.addAttribute("logoutMsg", "You have been logged out successfully ");
        }

        return "login";
    }

//    @PostMapping ("/login")
//    public String processLogin(@RequestParam("username") String username,
//                               @RequestParam("password") String password,
//                               Model model){
//        System.out.println("PostMapping"+username+password);
//
//        return "login";
//    }

}
