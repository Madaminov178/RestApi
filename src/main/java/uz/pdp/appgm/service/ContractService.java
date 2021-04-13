package uz.pdp.appgm.service;

import uz.pdp.appgm.payload.ApiResponse;
import uz.pdp.appgm.payload.ReqContract;

public interface ContractService {
    ApiResponse addContract(ReqContract reqContract);

}
