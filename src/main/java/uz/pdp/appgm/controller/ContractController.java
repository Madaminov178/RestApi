package uz.pdp.appgm.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.appgm.payload.ReqContract;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/contract")
public class ContractController {

    @PostMapping
    public HttpEntity<?> addContract(@Valid @RequestBody ReqContract reqContract) {
        return null;
    }
}
