package br.com.attornatus.attornatus.dto;


import lombok.*;

@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class PersonNewDto {

    private String name;
    private String birthDate;
    private String city;
    private Integer number;
    private String publicPlace;
    private  String zipCode;
    private Boolean mainAddres;

}
