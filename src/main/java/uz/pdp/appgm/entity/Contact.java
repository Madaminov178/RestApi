package uz.pdp.appgm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.appgm.entity.District;
import uz.pdp.appgm.entity.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contact extends AbsEntity {

    @ManyToOne(optional = false)
    private District district;
    private String address;
    @Column(unique = true)
    private String email;
    private String fax;
    @ElementCollection
    private Set<String> phoneNumbers;
}
