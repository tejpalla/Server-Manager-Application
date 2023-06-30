package io.tej.server.service;

import java.io.IOException;
import java.util.Collection;

import io.tej.server.model.Server;

public interface ServerService {

    Server create(Server server);
    Collection<Server> list(int lim);
    Server ping(String ipAddress) throws IOException;
    Server get(Long id);
    Server update(Server server);
    Boolean delete(Long id);
}
