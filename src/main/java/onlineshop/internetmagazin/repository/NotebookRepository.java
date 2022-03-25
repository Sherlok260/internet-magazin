package onlineshop.internetmagazin.repository;

import onlineshop.internetmagazin.entity.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotebookRepository extends JpaRepository<Notebook, Long> {
    @Override
    List<Notebook> findAll();
}
