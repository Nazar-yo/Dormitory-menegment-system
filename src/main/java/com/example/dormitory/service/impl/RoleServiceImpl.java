package com.example.dormitory.service.impl;

import com.example.dormitory.model.Role;
import com.example.dormitory.model.enums.RoleName;
import com.example.dormitory.repository.RoleRepository;
import com.example.dormitory.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role create(Role role) {
       return roleRepository.save(role);
    }

    @Override
    public Role getRoleByName(RoleName roleName) {
        return roleRepository.findRoleByRoleName(roleName);
    }
}
