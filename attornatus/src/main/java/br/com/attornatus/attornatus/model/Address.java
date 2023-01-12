package br.com.attornatus.attornatus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private Integer number;
    private String publicPlace;
    private  String zipCode;
    private Boolean mainAddres;

    @ManyToOne
    @JoinColumn(name="people_id")
    @JsonIgnore
    private Person people;



}
