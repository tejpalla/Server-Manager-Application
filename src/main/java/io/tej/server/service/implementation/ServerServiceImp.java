package io.tej.server.service.implementation;

import io.tej.server.enumeration.Status;
import io.tej.server.model.Server;
import io.tej.server.repo.ServerRepo;
import io.tej.server.service.ServerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Objects;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
 

public class ServerServiceImp implements ServerService {

    private final ServerRepo serverRepo;

    @Override
    public Server create(Server server) {
        // TODO Auto-generated method stub
        log.info("New Server is created : {}", server.getName());
        server.setImageURL(setServerImageURL());
        return serverRepo.save(server); 
    }


    @Override
    public Server ping(String ipAddress) throws IOException {
        // TODO Auto-generated method stub
        log.info("pinging the server: {}", ipAddress);
        Server server = serverRepo.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(server.getName());
        server.setStatus(address.isReachable(10000)? Status.SERVER_UP : Status.SERVER_DOWN);
        return serverRepo.save(server);
    }


    @Override
    public Collection<Server> list(int lim) {
        // TODO Auto-generated method stub
        return serverRepo.findAll(PageRequest.of(0, lim)).toList();
    }

    @Override
    public Server get(Long id) {
        // TODO Auto-generated method stub
        log.info("Fetching the server by Id {}",id);
       return serverRepo.findById(id).get();
    }

    @Override
    public Server update(Server server) {
        // TODO Auto-generated method stub
        log.info("Updating the Server {}",server.getName());
        return serverRepo.save(server);
    }

    @Override
    public Boolean delete(Long id) {
        // TODO Auto-generated method stub
        log.info("Deleting the Server with id {}", id);
        serverRepo.deleteById(id);
        return true ;
    }

    
    public String setServerImageURL() {

        return null;
    }
   
    
}
