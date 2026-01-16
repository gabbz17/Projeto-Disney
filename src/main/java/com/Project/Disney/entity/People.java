package com.Project.Disney.entity;

import com.Project.Disney.entity.more.Active;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    @Column(unique = true)
    private String cpf;
    @NotBlank
    @Column(unique = true)
    private String email;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Active active;
    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

}
