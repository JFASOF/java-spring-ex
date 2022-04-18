package com.saas.adress.service;/*Created by J.Fırat ©
    Date : 18.04.2022
    Time : 23:16
*/

import com.saas.adress.dto.AdressDTO;

import java.util.List;

public interface AdressService {
    AdressDTO addAdress(AdressDTO adressDTO);
    List<AdressDTO> getAllAdress();
    AdressDTO deleteAdress(Long id);
    AdressDTO updateAdress(AdressDTO adressDTO,Long id);
}
