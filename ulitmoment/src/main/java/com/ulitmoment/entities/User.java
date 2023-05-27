package com.ulitmoment.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String about;
    private String surname;
    private String name;
    private String patronymic;
    private Date birthday;
    private String phone;

    @OneToOne
    private FileDetails pic;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User(String email) {
        this.email = email;
    }

    public User(String email, String surname, String name, String patronymic) {
        this.email = email;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public User(String email, String password, String surname, String name, String patronymic) {
        this.email = email;
        this.password = password;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getFullname() {
        return surname + " " + name + " " + patronymic;
    }

    public Role getRole() {
        return this.roles.stream().findFirst().get();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
