package uz.pdp.appgm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.appgm.entity.enums.GenderEnum;
import uz.pdp.appgm.entity.enums.PersonType;
import uz.pdp.appgm.entity.template.AbsEntity;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Client extends AbsEntity {
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    private String middleName;
    @Column(nullable = false)
    private String tin;
    @Column(nullable = false)
    private String passportSerial;
    @Column(nullable = false)
    private String passportNumber;
    @Column(nullable = false)
    private Date birthDate;
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;
    @OneToOne(optional = false)
    private Contact contact;
    @Enumerated(EnumType.STRING)
    private PersonType personType;
    private String companyName;
    private String licenceNumber;
    private Date licenceExpire;
}
