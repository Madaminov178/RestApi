package uz.pdp.appgm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appgm.entity.Client;
import uz.pdp.appgm.entity.enums.PersonType;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
    Optional<Client> findByPassportSerialEqualsIgnoreCaseAndPassportNumberAndPersonType(String passportSerial, String passportNumber, PersonType personType);
}
