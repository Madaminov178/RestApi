package uz.pdp.appgm.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.pdp.appgm.entity.Contract;
import uz.pdp.appgm.repository.ContractRepository;

import javax.persistence.PrePersist;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Component
public class GenerateContract {
    @Autowired
    ContractRepository contractRepository;

    @PrePersist
    public void generateCode(Object object) {
        Contract contract = (Contract) object;
        contract.setNumber(getCode());
    }

    public String getCode() {
        String[] letters = {"A", "B", "C", "Z"};
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        String year = dateFormat.format(new Date());
        String maxNumber = contractRepository.getMaxNumber();
        if (maxNumber == null || !maxNumber.substring(0, 4).equals(year)) {
            return year + "AAA001";
        } else {
            int number = Integer.parseInt(maxNumber.substring(maxNumber.length() - 3));
            String lastLetter = maxNumber.substring(6, 7);
            String middleLetter = maxNumber.substring(5, 6);
            String firstLetter = maxNumber.substring(4, 5);
            String numberString = "";
            if (number < 9) {
                number++;
                numberString = "00" + number;
            } else if (number < 99) {
                number++;
                numberString = "0" + number;
            } else if (number < 999) {
                number++;
                numberString = String.valueOf(number);
            } else {
                if (lastLetter.equals("Z") && middleLetter.equals("Z")) {
                    lastLetter = "A";
                    middleLetter = "A";
                    int index = Arrays.asList(letters).indexOf(firstLetter) + 1;
                    firstLetter = letters[index];
                } else if (lastLetter.equals("Z")) {
                    lastLetter = "A";
                    int index = Arrays.asList(letters).indexOf(middleLetter) + 1;
                    middleLetter = letters[index];
                } else {
                    int index = Arrays.asList(letters).indexOf(lastLetter) + 1;
                    lastLetter = letters[index];
                }
            }
            return year + firstLetter + middleLetter + lastLetter + (numberString.isEmpty() ? "001" : numberString);
        }
    }


}
