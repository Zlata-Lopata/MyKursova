package com.system.railway.controller;

import com.system.railway.model.Train;
import com.system.railway.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/trains")
public class TrainController {

    @Autowired
    private TrainRepository repository;

    @GetMapping
    public String listTrains(Model model) {
        List<Train> trains = repository.findAll();
        model.addAttribute("trains", trains);
        return "trains";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("train", new Train());
        return "addTrain";
    }


    @GetMapping("/search/number")
    public String showSearchByNumberForm() {
        return "searchByNumber";
    }


    @GetMapping("/search/destination")
    public String showSearchByDestinationForm() {
        return "searchByDestination";
    }


    @PostMapping("/add")
    public String addTrain(@ModelAttribute("train") Train train, RedirectAttributes redirectAttributes) {
        repository.save(train);
        redirectAttributes.addFlashAttribute("successMessage", "Потяг успішно додано!");
        return "redirect:/trains/add";
    }


//    @GetMapping("/trains/number/result")
//    public String searchByNumber(@RequestParam String trainNumber, Model model) {
//        Optional<Train> optionalTrain = repository.findByTrainNumber(trainNumber);
//        if (optionalTrain.isPresent()) {
//            Train train = optionalTrain.get();
//            model.addAttribute("train", train);
//            // Форматування часу в рядок
//            String formattedTime = train.getDepartureTime() != null
//                    ? train.getDepartureTime().format(DateTimeFormatter.ofPattern("HH:mm"))
//                    : "Час не вказано";
//            model.addAttribute("formattedTime", formattedTime);
//        } else {
//            model.addAttribute("train", null);
//        }
//        return "searchByNumberResult";
//    }
    @GetMapping("/number/result")
    public String getTrainsByNumber(@RequestParam String trainNumber, Model model) {
        List<Train> trains = repository.findByTrainNumber(trainNumber);
        model.addAttribute("trains", trains);
        return "searchByNumberResult :: resultFragment";
    }


    @GetMapping("/trains/destination")
    public String searchByDestinationPage() {
        return "searchByDestination"; // шаблон HTML
    }



    @GetMapping("/destination/result")
    public String searchByDestinationHtml(@RequestParam String destination, Model model) {
        List<Train> results = repository.findByDestinationContainingIgnoreCase(destination);
        model.addAttribute("trains", results);
        return "searchByDestinationResult :: resultFragment";
    }
    @GetMapping("/number/result/json")
    @ResponseBody
    public List<Train> getTrainsByNumberJson(@RequestParam String trainNumber) {
        return repository.findByTrainNumber(trainNumber.trim());
    }



}
