package io.tej.server.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import io.tej.server.model.Server;


public interface ServerRepo extends JpaRepository<Server , Long> {

    Server findByIpAddress(String ipAddress);

}
 