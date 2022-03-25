package onlineshop.internetmagazin.controller;

import onlineshop.internetmagazin.entity.Notebook;
import onlineshop.internetmagazin.repository.NotebookRepository;
import onlineshop.internetmagazin.service.NotebookService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class NotebookController {
    private final NotebookService notebookService;

    public NotebookController(NotebookService notebookService) {
        this.notebookService = notebookService;
    }

    @PostMapping("/notebook/create")
    public HttpEntity<?> create(@RequestParam String model,
                                @RequestParam String cover,
                                @RequestParam String processor,
                                @RequestParam String color,
                                @RequestParam String ram,
                                @RequestParam String hdd,
                                @RequestParam String ssd,
                                @RequestParam String videocard,
                                @RequestParam String price) {
        Notebook notebook = new Notebook();
        notebook.setModel(model);
        notebook.setColor(color);
        notebook.setCover(cover);
        notebook.setHDD(hdd);
        notebook.setProcessor(processor);
        notebook.setRAM(ram);
        notebook.setVideoCard(videocard);
        notebook.setSSD(ssd);
        notebook.setPrice(price);
        notebookService.create(notebook);
        return ResponseEntity.ok("Ma'lumot saqlandi");
    }

    @GetMapping("/notebook")
    public String getAll(Model model) {
        model.addAttribute("notebooks", notebookService.getAll());
        return "notebook";
    }
}
