package com.alekseysamoylov.serviceiii.entity.security;

import com.alekseysamoylov.serviceiii.entity.AbstractSequenceIdEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

/**
 * Сущность - Роль пользователя системы
 */
@Entity
@Immutable
@Table(name = "user_role")
@NoArgsConstructor
@Getter
@Setter
public class UserRole extends AbstractSequenceIdEntity {

    public UserRole(Long id, User user, Role role) {
        this.setId(id);
        this.setUser(user);
        this.setRole(role);
    }

    public UserRole(User user, Role role) {
        this.setUser(user);
        this.setRole(role);
    }

    /**
     * Пользователь
     */
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * Роль.
     */
    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

}
