package com.example.dataapi.jpa;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@Builder
@Table(name = "pets")
@NoArgsConstructor
@AllArgsConstructor
public class pets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private Integer age;

    @Column(name = "animal")
    private String animal;
}
