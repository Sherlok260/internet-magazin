package onlineshop.internetmagazin.controller;

import onlineshop.internetmagazin.entity.Phone;
import onlineshop.internetmagazin.service.PhoneService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class PhoneController {
    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @PostMapping("/phone/create")
    public HttpEntity<?> create(@RequestParam String model,
                                @RequestParam String color,
                                @RequestParam String ram,
                                @RequestParam String memory,
                                @RequestParam String price) {
        Phone phone = new Phone();
        phone.setModel(model);
        phone.setColor(color);
        phone.setRam(ram);
        phone.setMemory(memory);
        phone.setPrice(price);
        phoneService.create(phone);
        return ResponseEntity.ok("Ma'lumot qo'shildi.");
    }

    @GetMapping("/phone")
    public String phoneCard(Model model) {
        model.addAttribute("phones", phoneService.getAll());
        return "phone";
    }

    @GetMapping("/back")
    public String back(){
        return "index";
    }
//    @GetMapping("/phone/all")
//    public String getAll(Model model) {
//        model.addAttribute("phones", phoneService.getAll());
//        return "phones";
//    }

    @GetMapping("/")
    public String hello() {

        return "index";
    }
}
