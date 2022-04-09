package com.example.midterm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class HumanController {

    private final HumanService humanService;

    @Autowired
    public HumanController(HumanService humanService) {
        this.humanService = humanService;
    }

    @GetMapping
    public String homePage(){
        return "home";
    }

    @GetMapping(path = "/getPeople")
    public String peopleTable(Model model){
        List<Human> humanList = humanService.getPeople();
        model.addAttribute("humanList", humanList);
        return "table";
    }

    @GetMapping(path = "/newHuman")
    public String createHumanPage(Model model){
        model.addAttribute("human", new Human());
        return "newHuman";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String createHuman(@ModelAttribute ("human")Human human){
        humanService.createHuman(human);
        return "redirect:/getPeople";
    }

    @RequestMapping(path = "/edit/{humanId}")
    public ModelAndView editHuman(
            @PathVariable ("humanId") Long humanId
    ){
        ModelAndView modelAndView = new ModelAndView("newHuman");
        Human human = humanService.getHumanById(humanId);
        modelAndView.addObject("human", human);
        return modelAndView;
    }

    @RequestMapping(path = "/delete/{humanId}")
    public String deleteHuman(@PathVariable ("humanId") Long humanId){
        humanService.deleteHuman(humanId);
        return "redirect:/getPeople";
    }
}
