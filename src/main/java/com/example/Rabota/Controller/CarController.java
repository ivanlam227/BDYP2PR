package com.example.Rabota.Controller;

import com.example.Rabota.Models.Car;
import com.example.Rabota.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class CarController {
    @Autowired
    private CarRepository carRepository;
    @GetMapping("/Car")
    public String GetRab(Model model)
    {
        Iterable<Car> car = carRepository.findAll();
        model.addAttribute("car",car);
        return "MainModel";
    }
    @GetMapping("/Add/Car")
    public String GetAddCar(Model model)
    {
        return "Add-Car";
    }
    @PostMapping("/Add/Car")
    public String blogPostAdd(@RequestParam(value="marks") String marks,
                              @RequestParam(value ="vin" ) String vin,
                              @RequestParam(value = "numberengen") int numberengen,
                              @RequestParam(value ="year" ) String year,
                              @RequestParam(value = "color") String color,
                              Model model)
    {
        Car car = new Car(marks,vin,numberengen,year,color);
        carRepository.save(car);
        return "redirect:/Car";
    }
    @GetMapping( path = "/Search/Car")
    public String blogFilter(Model model)
    {
        return "Search-Car";
    }

    @GetMapping("/Search/Car-result")
    public String blogResult(@RequestParam String marks, Model model)
    {
        List<Car> cars = carRepository.findByMarks(marks);
        model.addAttribute("result", cars);
        return "Search-Car";
    }
    @PostMapping("/Search/Car")
    public String simpleSearch(@RequestParam String marks, Model model)
    {
        List<Car> cars = carRepository.findByMarksContains(marks);
        model.addAttribute("result", cars);
        return "Search-Car";
    }
}
