package uz.pdp.appgm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appgm.entity.Car;

import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
}
