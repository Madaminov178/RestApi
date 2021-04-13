package uz.pdp.appgm.payload;

import lombok.Data;
import uz.pdp.appgm.entity.enums.GenderEnum;
import uz.pdp.appgm.entity.enums.PersonType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ReqClient {
    private String firstName;
    private String lastName;
    private String middleName;
    private String tin;
    private String passportSerial;
    private String passportNumber;
    private Date birthDate;
    private GenderEnum gender;
    private ReqContact reqContact;
    @NotNull
    private PersonType personType;
    private String companyName;
    private String licenceNumber;
    private Date licenceExpire;
}
