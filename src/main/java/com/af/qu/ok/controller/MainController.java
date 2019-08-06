package com.af.qu.ok.controller;

import com.af.qu.ok.service.AnswerService;
import com.af.qu.ok.service.QuestService;
import com.af.qu.ok.service.ResultDescriptionService;
import com.af.qu.ok.service.ResultService;
import com.af.qu.ok.util.QuestMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
@SessionAttributes("questMap")
public class MainController {

    @Autowired
    private QuestService questService;
    @Autowired
    private ResultService resultService;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private ResultDescriptionService resultDescriptionService;

    @GetMapping
    public String main() {
        return "index";
    }

    @PostMapping("/test")
    public RedirectView testPost(RedirectAttributes attributes, String name, Integer id) {
        id = id == null ? 0 : id;
        attributes.addFlashAttribute("id", id);
        attributes.addFlashAttribute("name", name);
        return new RedirectView("/test");
    }

    @GetMapping("/test")
    public String test(@ModelAttribute("name") String name, @ModelAttribute("id") Integer id, Model model) {
        id = id == null ? 0 : id;
        model.addAttribute("isLast", questService.findAll(id).isLast());
        model.addAttribute("isFirst", questService.findAll(id).isFirst());
        model.addAttribute("quests", questService.findAll(id).getContent());
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        return "test";
    }

    @PostMapping("/next")
    public RedirectView next(String name, Integer id, Long q_id, Long a_id, RedirectAttributes attributes,  @ModelAttribute("questMap") QuestMap questMap) {
        id = id == null ? 0 : id;
        id++;
        attributes.addFlashAttribute("id", id);
        attributes.addFlashAttribute("name", name);
        questMap.put(q_id, a_id);
        return new RedirectView("/test");
    }

    @PostMapping("/finish")
    public String finish(String name, Model model, Long q_id, Long a_id,  @ModelAttribute("questMap") QuestMap questMap) {
        questMap.put(q_id, a_id);
        resultService.saveAll(questMap, name);
        long score =  answerService.getScore(questMap);
        model.addAttribute("name", name);
        model.addAttribute("score", score );
        model.addAttribute("description",  resultDescriptionService.findCorrectDescription(score).getRd_text());
        return "result";
    }

    @ModelAttribute("questMap")
    private QuestMap questMap() {
        return new QuestMap();
    }
}
