package com.saas.adress.repository;
/*Created by J.Fırat ©
    Date : 18.04.2022
    Time : 23:15
*/

import com.saas.adress.domain.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Adress,Long> {
}
