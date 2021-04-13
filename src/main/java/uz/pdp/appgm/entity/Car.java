package uz.pdp.appgm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.appgm.entity.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car extends AbsEntity {
    @ManyToOne(optional = false)
    private CarTemplate carTemplate;

    @ManyToOne(optional = false)
    private Color color;

    @OneToOne(optional = false)
    private Attachment attachment;

    @Column(nullable = false)
    private double price;

    private boolean active = true;

}
