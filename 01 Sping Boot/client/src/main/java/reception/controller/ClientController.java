package reception.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reception.entity.Client;
import reception.service.ClientServices;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientServices clientServices;


    @GetMapping("/")
    public List<Client> getAllClients(){
        return this.clientServices.getAllClients();
    }
}
