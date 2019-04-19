package org.softuni.AFIF.web.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity implements GrantedAuthority {

    private String authority;

    public Role() {
    }

    public Role(String grantedAuthority) {
        this.authority = grantedAuthority;
    }

    public void setGrantedAuthority(String grantedAuthority) {
        this.authority = grantedAuthority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }


}
