package com.sdp.hms.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdp.hms.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByName(String name);

}
