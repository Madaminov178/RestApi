package uz.pdp.appgm.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.appgm.entity.template.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CarTemplate extends AbsEntity {

    @ManyToOne
    private CarName carName;

    @ManyToOne(optional = false)
    private Position position;

    private boolean active=true;

    @OneToMany(mappedBy = "carTemplate")
    private List<CarTemplateValue> carTemplateValues;


}
