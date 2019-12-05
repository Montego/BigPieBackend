package com.bigpie.big_pie_project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Size(min = 3, message = "Name should have have at least 3 character")
    private String username;

    private String firstname;
    private String lastname;


    @JsonIgnore
    @NotNull
    @Size(min = 6, message = "Name should have have at least 6 character")
    private String password;

    private String email;

    private String activationCode;

    private boolean isActive;


//    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
//    @Enumerated(EnumType.STRING)
//    private Set<Role> roles;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

}
