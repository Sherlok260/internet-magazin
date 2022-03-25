package onlineshop.internetmagazin.repository;

import onlineshop.internetmagazin.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
//    Phone findById(Long id);
}
