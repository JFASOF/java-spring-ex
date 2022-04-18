package com.saas.adress.service.impl;/*Created by J.Fırat ©
    Date : 18.04.2022
    Time : 23:18
*/

import com.saas.adress.domain.Adress;
import com.saas.adress.dto.AdressDTO;
import com.saas.adress.repository.AdressRepository;
import com.saas.adress.service.AdressService;
import com.saas.adress.util.exception.ResourceNotFoundExc;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdressServiceImpl implements AdressService {
    private AdressRepository adressRepository;
    private ModelMapper modelMapper;

    public AdressServiceImpl(AdressRepository adressRepository, ModelMapper modelMapper) {
        this.adressRepository = adressRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AdressDTO addAdress(AdressDTO adressDTO) {
        Adress post= modelMapper.map(adressDTO, Adress.class);
        AdressDTO adressDTO1 = modelMapper.map(adressRepository.save(post),AdressDTO.class);
        return adressDTO1;
    }

    @Override
    public List<AdressDTO> getAllAdress() {
        List<Adress> adresses= adressRepository.findAll();
        return adresses.stream().map(post -> modelMapper.map(post,AdressDTO.class)).collect(Collectors.toList());
    }

    @Override
    public AdressDTO deleteAdress(Long id) {
        Adress adress= adressRepository.findById(id).orElseThrow(()-> new ResourceNotFoundExc("Adress","id",id));
        adressRepository.delete(adress);
        return modelMapper.map(adress,AdressDTO.class);
    }

    @Override
    public AdressDTO updateAdress(AdressDTO adressDTO, Long id) {
        Adress adress = adressRepository.findById(id).orElseThrow(()-> new ResourceNotFoundExc("Adress","id",id));
        adress.setCityCode(adressDTO.getCityCode());
        adress.setCityName(adressDTO.getCityName());
        adress.setDistrictName(adressDTO.getDistrictName());
        AdressDTO adressDTO1 = modelMapper.map(adressRepository.save(adress),AdressDTO.class);
        return adressDTO1;
    }
}
