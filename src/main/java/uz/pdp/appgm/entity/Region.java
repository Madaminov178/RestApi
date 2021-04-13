package uz.pdp.appgm.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.appgm.entity.template.AbsNameEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Region extends AbsNameEntity {
    @OneToMany(mappedBy = "region", cascade = CascadeType.REMOVE)
    private List<District> districts;

}
