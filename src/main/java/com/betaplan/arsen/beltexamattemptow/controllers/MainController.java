package com.betaplan.arsen.beltexamattemptow.controllers;

import com.betaplan.arsen.beltexamattemptow.models.Hunter;
import com.betaplan.arsen.beltexamattemptow.models.LoginUser;
import com.betaplan.arsen.beltexamattemptow.models.Notes;
import com.betaplan.arsen.beltexamattemptow.models.User;
import com.betaplan.arsen.beltexamattemptow.services.HunterServices;
import com.betaplan.arsen.beltexamattemptow.services.NotesServices;
import com.betaplan.arsen.beltexamattemptow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private HunterServices hunterServices;

    @Autowired
    private NotesServices notesServices;



    @GetMapping("/")
    public String index(@ModelAttribute("user") User user, @ModelAttribute("loginUser") LoginUser loginUser, Model model) {
        model.addAttribute("user" ,new User());
        model.addAttribute("loginUser", new LoginUser());
        return "index";
    }

    @PostMapping("/register")
    public String registrantion(@Valid @ModelAttribute("user") User user, BindingResult result,
                                HttpSession session, Model model) {
        User createUsers = userService.register(user, result);
        if (result.hasErrors()) {
            model.addAttribute("loginUser", new LoginUser());
            return "index";
        }
        session.setAttribute("userId", createUsers.getId());
        return "redirect:/home";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result,HttpSession session , Model model) {
        User loggedUser = userService.loggin(loginUser, result);
        if (result.hasErrors()) {
            model.addAttribute("user", new User());
            return "index";
        }
        session.setAttribute("userId", loggedUser.getId());
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String dashboard(Model model, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/";
        }
        Long userId = (Long) session.getAttribute("userId");
        model.addAttribute("user", userService.findUserId(userId));
        model.addAttribute("hunter", hunterServices.getAllHunter());
        return "dashboard";
    }

    @GetMapping("/listing/new")
    public String createHunter(@ModelAttribute("newHunter") Hunter newHunter, HttpSession session , Model model){
        if (session.getAttribute("userId") == null){
            return "redirect:/";
        }
        return "create";
    }
    @PostMapping("/listing/new")
    public String newHunter(@Valid @ModelAttribute("newHunter")Hunter newHunter,BindingResult result , HttpSession session ,Model model){
        if (result.hasErrors()){
            return "create";
        }
        Date date = new Date();
        Long idUser= (Long) session.getAttribute("userId");
        User userID =userService.findUserId(idUser);
        newHunter.setAdded(userID);
        newHunter.setListedOn(date);
        hunterServices.createHunter(newHunter);

        return "redirect:/home";
    }

    @GetMapping("/listing/{id}")
    public String details(@PathVariable("id")Long id,@ModelAttribute("notes")Notes notes ,Model model, HttpSession session){
        model.addAttribute("hunter", hunterServices.getByIdHunter(id));
        Long idUser= (Long) session.getAttribute("userId");
        User userID =userService.findUserId(idUser);
        model.addAttribute("user" , userID);
        return "details";
    }

    @PostMapping("/listing/notes/{id}")
    public String addNotes(@PathVariable("id") Long id, @Valid @ModelAttribute("notes")Notes notes ,BindingResult result,HttpSession session , Model model){
        Long idUser= (Long) session.getAttribute("userId");
        User userID =userService.findUserId(idUser);
        Hunter hunterId = hunterServices.getByIdHunter(id);
       if (result.hasErrors()){
           model.addAttribute("hunter", hunterId);
           model.addAttribute("user" , userID);
           return "details";
       }
       notes.setUserNote(userID);
       notes.setHunterNote(hunterId);
       notesServices.createNotes(notes);
       return "redirect:/listing/{id}";

    }


    @GetMapping("/listing/{id}/edit")
    public String edit(@PathVariable("id")Long id,@ModelAttribute("newHunter")Hunter newHunter ,Model model ,HttpSession session){
        if (session.getAttribute("userId") == null){
            return "redirect:/";
        }
        Hunter editHunter = hunterServices.getByIdHunter(id);
        model.addAttribute("newHunter", editHunter);
        return "edit";
    }
    @PutMapping("/listing/{id}/edit")
    public String editHunter(@PathVariable("id") Long id,@Valid @ModelAttribute("newHunter")Hunter newHunter,BindingResult result , HttpSession session ,Model model) throws ParseException {
        Long idUser= (Long) session.getAttribute("userId");
        User userID =userService.findUserId(idUser);
        if (result.hasErrors()){
            return "edit";
        }
        newHunter.setAdded(userID);
        hunterServices.updateHunter(newHunter);
        return "redirect:/home";
    }


    @GetMapping("/notes/{id}")
    public String notes(@PathVariable("id") Long id, HttpSession session , Model model){
        Long idUser= (Long) session.getAttribute("userId");
        User userID =userService.findUserId(idUser);
        Hunter hunter = hunterServices.getByIdHunter(id);
            model.addAttribute("user" , userID);
            model.addAttribute("notes", notesServices.getByHunter(hunter));
            model.addAttribute("idNotes", notesServices.getNotesById(id));
        return "notes";
    }




    @GetMapping("/listing/delete/{id}")
    public String deleteListing(@PathVariable("id") Long id){
        Hunter ht = hunterServices.getByIdHunter(id);
        hunterServices.deleteHunterById(ht);
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
