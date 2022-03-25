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

    @PostMapping("/phone")
    public HttpEntity<?> create(@RequestBody Phone phone) {
        phoneService.create(phone);
        return ResponseEntity.ok("Ma'lumot qo'shildi.");
    }

    @GetMapping("/phone")
    public String phoneCard() {
        return "phone";
    }

    @GetMapping("/phone/getId")
    public String getById(@RequestParam Long id, Model model) {
        model.addAttribute("phone", phoneService.findById(id));
        return "onePhone";
    }

    @GetMapping("/phone/all")
    public String getAll(Model model) {
        model.addAttribute("phones", phoneService.getAll());
        return "phones";
    }

    @GetMapping("/")
    public String hello() {
        return "hello";
    }
}
