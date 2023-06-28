package io.tej.server.service;

import java.util.Collection;

import io.tej.server.model.Server;

public interface ServerService {

    Server create(Server server);
    Collection<Server> list(int lim);
    Server ping(String ipAddress);
    Server get(Long id);
    Server update(Server server);
    Server delete(Long id);
}
