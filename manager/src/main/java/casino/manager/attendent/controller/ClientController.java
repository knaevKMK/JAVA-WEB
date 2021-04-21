package casino.manager.attendent.controller;

import casino.manager.attendent.entity.Client;
import casino.manager.attendent.service.ClientService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;


    @GetMapping("/")
    public List<Client> getAllClients(){
        return  this.clientService.getAllClients();
    }
    @GetMapping("/{id}")
    public Client getClientById(@PathVariable UUID id){

        return this.clientService.getClientById(id);
    }

    @DeleteMapping("/del/{id}")
    public String deleteClient(@PathVariable UUID id){
      return   this.clientService.deleteClient(id);
    }


    @PostMapping("/create")
    public Client addClient(@RequestBody Client client){
      return   this.clientService.addClient(client);
    }

    @PutMapping("/edit/{id}")
    public  Client updateClient(@PathVariable UUID id,
                                @RequestBody Client client){
        return  this.clientService.updateClient(id,client);

    }
}
