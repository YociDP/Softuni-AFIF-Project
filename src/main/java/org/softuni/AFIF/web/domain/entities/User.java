package org.softuni.AFIF.web.domain.entities;

import org.softuni.AFIF.web.domain.entities.BaseEntity;
import org.softuni.AFIF.web.domain.entities.Club;
import org.softuni.AFIF.web.domain.entities.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity implements UserDetails{
    @Column(name = "username",  nullable = false)
    private String username;

    @Column(name = "password" , nullable = false)
    private String password;

    private boolean isAccountNonExpired;

    private boolean isAccountNonLocked;

    private boolean isCredentialsNonExpired;

    private boolean isEnabled;

    @OneToMany(mappedBy = "founder")
    private List<Club> clubs;

    @OneToMany(mappedBy = "owner")
    private List<Pitch> pitches;

    @ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id",
                    referencedColumnName = "id"
            )
    )
    private Set<Role> authorities;

    @Column(name = "firstName" , nullable = false)
    private String firstName;

    @Column(name = "lastName" , nullable = false)
    private String lastName;

    @Override
    public Set<Role> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    @Transient
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @Transient
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Club> getClubs() {
        return clubs;
    }

    public void setClubs(List<Club> clubs) {
        this.clubs = clubs;
    }

    public List<Pitch> getPitches() {
        return pitches;
    }

    public void setPitches(List<Pitch> pitches) {
        this.pitches = pitches;
    }
}

