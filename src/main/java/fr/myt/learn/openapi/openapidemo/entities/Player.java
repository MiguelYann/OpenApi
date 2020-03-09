package fr.myt.learn.openapi.openapidemo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    @Id

    private Long id;

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
}
