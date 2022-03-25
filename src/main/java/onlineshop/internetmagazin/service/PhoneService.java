package onlineshop.internetmagazin.service;

import onlineshop.internetmagazin.entity.Phone;
import onlineshop.internetmagazin.repository.PhoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {
    private final PhoneRepository phoneRepository;

    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public void create(Phone phone) {
        phoneRepository.save(phone);
    }

    public Phone findById(Long id) {
        return phoneRepository.getById(id);
    }

    public List<Phone> getAll() {
        return phoneRepository.findAll();
    }

    public void update(Phone phone, Long id) {
        phoneRepository.deleteById(id);
        phoneRepository.save(phone);
    }

    public void deleteById(Long id) {
        phoneRepository.deleteById(id);
    }
}
