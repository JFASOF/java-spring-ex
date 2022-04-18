package com.saas.adress.api.controller;
/*Created by J.Fırat ©
    Date : 18.04.2022
    Time : 23:30
*/

import com.saas.adress.dto.AdressDTO;
import com.saas.adress.service.AdressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adresses/v1")
public class AdressController {
    private AdressService adressService;

    public AdressController(AdressService adressService) {
        this.adressService = adressService;
    }

    @GetMapping("/get-adresses")
    public List<AdressDTO> getAllPost() {
        return adressService.getAllAdress();
    }

    @PostMapping("/add-adress")
    public ResponseEntity<AdressDTO> addPost(@RequestBody AdressDTO adressDTO) {
        return new ResponseEntity<>(adressService.addAdress(adressDTO), HttpStatus.CREATED);
    }

    @PostMapping("/update-adress/{adressId}")
    public ResponseEntity<AdressDTO> updatePost(@RequestBody AdressDTO adressDTO,@PathVariable(name = "adressId") Long id) {
        return new ResponseEntity<>(adressService.updateAdress(adressDTO,id),HttpStatus.OK);
    }

    @PostMapping("/delete-adress/{adressId}")
    public ResponseEntity<AdressDTO> deletePost(@PathVariable(name = "adressId") Long id) {
        return new ResponseEntity<>(adressService.deleteAdress(id),HttpStatus.OK);
    }

}
