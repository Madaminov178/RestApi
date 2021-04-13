package uz.pdp.appgm.payload;

import lombok.Data;

import java.util.List;

@Data
public class ReqContact {
    private Integer districtId;
    private String address;
    private String email;
    private String fax;
    private List<String> phoneNumbers;
}
