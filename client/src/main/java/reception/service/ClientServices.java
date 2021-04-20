package reception.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reception.entity.Client;
import reception.repository.ClientRepository;

import java.util.List;

@Service
public class ClientServices {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients(){
        return this.clientRepository.findAll();
    }
}
