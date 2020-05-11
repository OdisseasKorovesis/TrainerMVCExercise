/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.trainermvcexercise.controllers;

import java.util.List;
import java.util.Locale;
import javax.validation.Valid;
import org.afdemp.trainermvcexercise.entities.Trainer;
import org.afdemp.trainermvcexercise.services.ITrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Odisseas KD
 */
@Controller
@RequestMapping("/")
public class TrainerController {

    private String listurl = "list";
    private String editurl = "edit";
    private String deleteurl = "delete";
    private String newtrainer = "new";

    @Autowired
    ITrainerService trainerService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String allTrainers(ModelMap view, @RequestParam(required = false) String msg) {
        List<Trainer> trainers = trainerService.findAllTrainers();
        view.addAttribute("trainers", trainers);
        view.addAttribute("editurl", editurl);
        view.addAttribute("deleteurl", deleteurl);
        view.addAttribute("newurl", newtrainer);
        view.addAttribute("msg", msg);
        return ("alltrainers");
    }

    // get form for new student
    @RequestMapping("/new")
    public String newTrainer(ModelMap view) {
        Trainer trainer = new Trainer();
        view.addAttribute("trainer", trainer);
        view.addAttribute("listurl", listurl);
        return ("registertrainer");
    }

    // post form for new student
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveTrainer(ModelMap view, @Valid Trainer trainer, BindingResult result) {
        if (result.hasErrors()) {
            return "registertrainer";
        }

        if (trainerService.save(trainer)) {
            view.addAttribute("msg", new String("Trainer " + trainer.getFirstName() + " " + trainer.getLastName() + " has been registered successfully."));
        } else {
            view.addAttribute("msg", new String("Something went wrong, trainer not registered."));
        }
        view.addAttribute("listurl", listurl);
        return ("redirect:/list");
    }

    // delete for an existing student
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTrainer(ModelMap view, @PathVariable int id) {
        if (trainerService.delete(id)) {
            view.addAttribute("msg", new String("Trainer deleted successfully."));
        } else {
            view.addAttribute("msg", new String("Trainer could not be deleted."));
        }
        return ("redirect:/list");
    }

    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.GET)
    public String editTrainer(@PathVariable int id, ModelMap view) {
        Trainer trainer = trainerService.findTrainerById(id);
        view.addAttribute("trainer", trainer);;
        return "edittrainer";
    }

    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.POST)
    public String updateTrainer(@Valid Trainer trainer, BindingResult result, ModelMap view, @PathVariable int id) {

        if (result.hasErrors()) {
            return "edittrainer";
        }

        if (trainerService.updateTrainer(trainer)) {
            view.addAttribute(view.addAttribute("msg", "Trainer " + trainer.getFirstName() + " " + trainer.getLastName() + " updated successfully"));
        } else {
            view.addAttribute(view.addAttribute("msg", "Trainer " + trainer.getFirstName() + " " + trainer.getLastName() + " could not updated"));
        }

        //view.addAttribute("msg", "Trainer " + trainer.getFirstName() + " " + trainer.getLastName() + " updated successfully");
        return "redirect:/list";
    }

}
