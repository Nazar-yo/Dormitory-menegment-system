package com.example.dormitory.service;

import com.example.dormitory.model.Role;
import com.example.dormitory.model.enums.RoleName;

public interface RoleService {
    Role create(Role role);

    Role getRoleByName(RoleName roleName);
}
