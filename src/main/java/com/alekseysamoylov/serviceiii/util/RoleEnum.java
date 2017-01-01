package com.alekseysamoylov.serviceiii.util;

import com.alekseysamoylov.serviceiii.entity.security.Role;

/**
 * Идентификаторы ролей пользователей.
 */
public class RoleEnum {

    public static final Role ROLE_ADMIN = new Role(1L, "ROLE_CUSTOMER");

    public static final Role ROLE_MANAGER = new Role(2L, "ROLE_CUSTOMER");

    public static final Role ROLE_CUSTOMER = new Role(4L, "ROLE_CUSTOMER");
}
