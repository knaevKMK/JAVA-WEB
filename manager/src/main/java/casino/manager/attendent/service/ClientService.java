package casino.manager.attendent.service;

import casino.manager.attendent.entity.Client;
import casino.manager.attendent.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return this.clientRepository.findAll();
    }

    public Client addClient(Client client) {
        Client exist = this.clientRepository.findClientByEgn(client.getEgn());
        if (exist != null) {
            throw new IllegalArgumentException("Client with this EGN: " + client.getEgn() + " EXIST");
        }
//       validate fields
        return this.clientRepository.save(client);
    }

    public Client getClientById(UUID id) {
        System.out.println(id);
        return this.clientRepository.findById(id).orElse(null);
    }

    public String deleteClient(UUID id) {
        this.clientRepository.deleteById(id);
        return "Deleted Successfully!";
    }

    public Client updateClient(UUID id, Client client) {
        Client temp = this.getClientById(id);
        if (temp == null) {
            throw new IllegalArgumentException("Client does not exist");
        }
        System.out.println(client);
        Client tempEgn = this.clientRepository.findClientByEgn(client.getEgn());
        if (tempEgn!=null ) {
            if (temp.getId() != tempEgn.getId()) {
                throw new IllegalArgumentException("Another client with same EGN exist");
            }
        }

        temp.setEgn(client.getEgn());
        temp.setName(client.getName());
        return this.clientRepository.save(temp);
    }
}
