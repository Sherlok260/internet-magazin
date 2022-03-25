package onlineshop.internetmagazin.service;

import onlineshop.internetmagazin.entity.Notebook;
import onlineshop.internetmagazin.repository.NotebookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotebookService {
    private final NotebookRepository notebookRepository;

    public NotebookService(NotebookRepository notebookRepository) {
        this.notebookRepository = notebookRepository;
    }

    public void create(Notebook notebook) {
        notebookRepository.save(notebook);
    }

    public List<Notebook> getAll() {
        return notebookRepository.findAll();
    }
}
