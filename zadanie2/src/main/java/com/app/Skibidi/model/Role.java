package com.app.Skibidi.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {
    private int roleId;
    private String role;
    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="role",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<User> userList;

    @Id
    @Column(name = "role_id")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role1 = (Role) o;

        if (roleId != role1.roleId) return false;
        if (role != null ? !role.equals(role1.role) : role1.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
