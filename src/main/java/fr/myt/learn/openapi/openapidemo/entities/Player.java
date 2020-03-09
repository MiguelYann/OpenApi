package fr.myt.learn.openapi.openapidemo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;
}