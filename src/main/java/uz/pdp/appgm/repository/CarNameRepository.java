package uz.pdp.appgm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import uz.pdp.appgm.entity.Car;
import uz.pdp.appgm.entity.CarName;

import java.util.UUID;
@CrossOrigin
@RepositoryRestResource(path = "carNAme",collectionResourceRel = "list")
public interface CarNameRepository extends JpaRepository<CarName, Integer> {
}
