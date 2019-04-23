package org.softuni.AFIF.web.domain.entities;

import org.softuni.AFIF.web.domain.entities.BaseEntity;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity implements GrantedAuthority {

    @Column(name = "authority" , unique = true)
    @NotNull(message = "Authority cannot be null")
    private String authority;

    public Role() {
    }

    public Role(String grantedAuthority) {
        this.authority = grantedAuthority;
    }

    public void setAuthority(String grantedAuthority) {
        this.authority = grantedAuthority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }


}
