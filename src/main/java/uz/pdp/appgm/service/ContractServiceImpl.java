package uz.pdp.appgm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.appgm.entity.Car;
import uz.pdp.appgm.entity.Client;
import uz.pdp.appgm.entity.Contact;
import uz.pdp.appgm.entity.Contract;
import uz.pdp.appgm.entity.enums.ContractStatus;
import uz.pdp.appgm.entity.enums.PersonType;
import uz.pdp.appgm.payload.ApiResponse;
import uz.pdp.appgm.payload.ReqClient;
import uz.pdp.appgm.payload.ReqContact;
import uz.pdp.appgm.payload.ReqContract;
import uz.pdp.appgm.repository.*;

import java.util.HashSet;
import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    DistrictRepository districtRepository;
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    CarRepository carRepository;
    @Autowired
    ContractRepository contractRepository;

    @Override
    public ApiResponse addContract(ReqContract reqContract) {
        Client client;
        Optional<Client> optionalClient = clientRepository.findByPassportSerialEqualsIgnoreCaseAndPassportNumberAndPersonType(reqContract.getReqClient().getPassportSerial(), reqContract.getReqClient().getPassportNumber(), reqContract.getReqClient().getPersonType());
        if (!optionalClient.isPresent()) {
            ReqClient reqClient = reqContract.getReqClient();
            client = new Client(
                    reqClient.getFirstName(),
                    reqClient.getLastName(),
                    reqClient.getMiddleName(),
                    reqClient.getTin(),
                    reqClient.getPassportSerial(),
                    reqClient.getPassportNumber(),
                    reqClient.getBirthDate(),
                    reqClient.getGender(),
                    addContact(reqClient.getReqContact()),
                    reqClient.getPersonType(),
                    reqClient.getPersonType().equals(PersonType.PHYSICAL) ? null : reqClient.getCompanyName(),
                    reqClient.getPersonType().equals(PersonType.PHYSICAL) ? null : reqClient.getLicenceNumber(),
                    reqClient.getPersonType().equals(PersonType.PHYSICAL) ? null : reqClient.getLicenceExpire()
            );
            client = clientRepository.save(client);
        } else {
            client = optionalClient.get();
        }
        Car car = carRepository.findById(reqContract.getCarId()).orElseThrow(() -> new ResourceNotFoundException("getCar"));
        Contract contract = new Contract();
        contract.setClient(client);
        contract.setStatus(ContractStatus.CONTRACTED);
        contract.setCar(car);
        contract.setPrice(car.getPrice());
        Contract savedContract = contractRepository.save(contract);
        return new ApiResponse("Shartnoma tuzildi", true, savedContract.getId());
    }

    public Contact addContact(ReqContact reqContact) {
        Contact contact = new Contact();
        contact.setAddress(reqContact.getAddress());
        contact.setEmail(reqContact.getEmail());
        contact.setFax(reqContact.getFax());
        contact.setPhoneNumbers(new HashSet<>(reqContact.getPhoneNumbers()));
        contact.setDistrict(districtRepository.findById(reqContact.getDistrictId()).orElseThrow(() -> new ResourceNotFoundException("getDistrict")));
        return contactRepository.save(contact);
    }
}
