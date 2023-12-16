package com.metehan.AndroidBackend;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="actor")
public class Actor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="actor_id")
    @JsonProperty("actor_id")
    private int id;

    @Column(name="first_name")
    @JsonProperty("first_name")
    private String firstName;

    @Column(name="last_name")
    @JsonProperty("last_name")
    private String lastName;
}
