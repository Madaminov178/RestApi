package uz.pdp.appgm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appgm.entity.Contact;

import java.util.UUID;

public interface ContactRepository extends JpaRepository<Contact, UUID> {
}
