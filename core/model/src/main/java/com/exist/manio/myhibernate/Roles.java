package com.exist.manio.myfirsthibernate.core.model;

import java.util.Set;
import java.util.HashSet;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "roles")
public class Roles {

    private String role;
    private String roleDesc;
    private Set<Person> personSet;

    public void setRole(String role) {
        this.role = role;
    }

    @Id
    @Column(name = "role", unique = true, nullable = false)
    public String getRole() {
        return this.role;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Column(name = "role_desc", nullable = false)
    public String getRoleDesc() {
        return this.roleDesc;
    }

    public void setPersonSet(Set<Person> personSet) {
        if(personSet != null) {
            this.personSet = personSet;
        }
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "rolesSet")
    public Set<Person> getPersonSet() {
        return this.personSet;
    }

    public String toString() {
        return "Role:" + roleDesc + " (" + role + ")";
    }

    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) return true;

        if (!(obj instanceof Roles)) return false;

        Roles obj2 = (Roles)obj;

        if (!this.role.equals(obj2.getRole())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int tmp = 0;
        tmp = role.hashCode();
        return tmp;
    }

    public Roles() {

    }

    public Roles(String role, String roleDesc) {
        this.role = role;
        this.roleDesc = roleDesc;
    }

}