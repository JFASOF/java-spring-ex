package com.saas.adress.domain;

/*Created by J.Fırat ©
    Date : 18.04.2022
    Time : 23:01
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ADRESS")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CITY_CODE",nullable = false)
    private Integer cityCode;
    @Column(name = "CITY_NAME",nullable = false)
    private String cityName;
    @Column(name = "DISTRICT_NAME",nullable = false)
    private String districtName;
}
