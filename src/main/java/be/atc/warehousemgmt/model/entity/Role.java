package be.atc.warehousemgmt.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ahmed idoumhaidi
 * @since 24/04/2016
 */

@Entity
public class Role extends AbstractAuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleId;
    @Enumerated(EnumType.STRING)
    @Column(name = "roleName", nullable = false, unique = false)
    private RoleName roleName;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    public enum RoleName {ROLE_USER, ROLE_ADMIN}
}
