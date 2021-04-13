package uz.pdp.appgm.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.appgm.entity.template.AbsNameEntity;

import javax.persistence.Entity;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Detail extends AbsNameEntity {

}
