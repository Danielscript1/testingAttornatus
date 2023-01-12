package br.com.attornatus.attornatus.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd",timezone = "GMT")
    private String birthDate;

    @OneToMany(mappedBy = "people",cascade = CascadeType.ALL)
    private List<Address> address = new ArrayList<>();

    public Person(Long id, String name, String birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }
}
