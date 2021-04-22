package casino.manager.attendent.controller;

import casino.manager.attendent.entity.Accountant;
import casino.manager.attendent.entity.Attendant;
import casino.manager.attendent.entity.Client;
import casino.manager.attendent.entity.GamblingMachine;
import casino.manager.attendent.service.AccountantService;
import casino.manager.attendent.service.AttendantService;
import casino.manager.attendent.service.ClientService;
import casino.manager.attendent.service.GamblingMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
public class ManagerController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private AttendantService attendantService;
    @Autowired
    private GamblingMachineService gamblingMachineService;
    @Autowired
    private AccountantService accountantService;


    //Accountant
    @GetMapping("/acc")
    public List<Accountant> getAllAccountant() {
        return this.accountantService.getAllAccountant();
    }

    //IA
    @GetMapping("/ia")
    public List<GamblingMachine> getAllMachine() {
        return gamblingMachineService.getAllIA();
    }

    @PostMapping("/ia/create")
    public GamblingMachine addIA(GamblingMachine gamblingMachine) {
        return this.gamblingMachineService.add(gamblingMachine);
    }

    @DeleteMapping("/ia/del/{id}")
    public String deleteGamblinMachine(@PathVariable UUID id) {
        return this.gamblingMachineService.deleteIA(id);
    }

    @PutMapping("/ia/edit/{id}")
    public  GamblingMachine updateIA(@PathVariable UUID id,
                                     @RequestBody GamblingMachine gamblingMachine){
     return    this.gamblingMachineService.upadateIA(id,gamblingMachine);
    }
    //ATTENDANT
    @GetMapping("/att")
    public List<Attendant> getAllAttendats() {
        return this.attendantService.getAllAttendents();
    }

    //CLIENT
    @GetMapping("/client")
    public List<Client> getAllClients() {
        return this.clientService.getAllClients();
    }

    @GetMapping("/client/{id}")
    public Client getClientById(@PathVariable UUID id) {

        return this.clientService.getClientById(id);
    }

    @DeleteMapping("/client/del/{id}")
    public String deleteClient(@PathVariable UUID id) {
        return this.clientService.deleteClient(id);
    }


    @PostMapping("/client/create")
    public Client addClient(@RequestBody Client client) {
        return this.clientService.addClient(client);
    }

    @PutMapping("/client/edit/{id}")
    public Client updateClient(@PathVariable UUID id,
                               @RequestBody Client client) {
        return this.clientService.updateClient(id, client);

    }
}
