package com.slezak.projekt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class KredytController {

    @PostMapping("/odbior")
    public String hello(Model model,
        @RequestParam(name= "PESEL") String pesel,
        @RequestParam(name = "Adres") String adres) {
        List lista = new ArrayList<String>();
        lista.add("Dziękujemy za podanie numeru " + pesel +" twoj Iphone zostanie wyslany na adres " + adres);
        String lista1 = (String) lista.get(0);
        model.addAttribute("lista", lista1);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String data = formatter.format(date);
        model.addAttribute("data", data);
        return "odbior";
    }

    @PostMapping("/kredyt")
    public void kredyt(Model model,
        @RequestParam(name= "wysokosc") float wysokosc,
        @RequestParam(name = "ile") float wielkosc) {
        model.addAttribute("wysokosc", wysokosc);
        model.addAttribute("wielkosc", wielkosc);
        float rata = Calc.kredyt(wysokosc, wielkosc);
        float ratakredytu = rata;
        model.addAttribute("rata", ratakredytu);
        float wysokosc1 = Calc.wysokosc(wysokosc);
        float wysokosckredytu = wysokosc1;
        model.addAttribute("wysokosc", wysokosckredytu);

    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/style.css")
    public String style(){
        return "style.css";
    }
    @GetMapping("/stylekredyt.css")
    public String stylekredyt(){
        return "stylekredyt.css";
    }

}
