package casino.manager.attendent.service;


import casino.manager.attendent.entity.GamblingMachine;
import casino.manager.attendent.repository.GamblingMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GamblingMachineService {
    @Autowired
    private GamblingMachineRepository gamblingMachineRepository;

    public List<GamblingMachine> getAllIA(){
        return this.gamblingMachineRepository.findAll(Sort.by("numPlace"));
    }

    public GamblingMachine add(GamblingMachine gamblingMachine) { return this.gamblingMachineRepository.save(gamblingMachine);
    }

    public String deleteIA(UUID id) {
        this.gamblingMachineRepository.deleteById(id);
        return "Successfully delete this Machine";
    }

    public GamblingMachine upadateIA(UUID id, GamblingMachine gamblingMachine) {
        GamblingMachine temp = this.getIAById(id);
        if(temp==null){
            throw new NullPointerException("This IA does not exist");
        }
        //validate new data
        temp.setNumber(gamblingMachine.getNumber());
        temp.setNumPlace(gamblingMachine.getNumPlace());
        temp.setVersion(gamblingMachine.getVersion());

        return this.gamblingMachineRepository.save(temp);
    }

    public GamblingMachine getIAById(UUID id){
        return  this.gamblingMachineRepository.findById(id).orElse(null);
    }
}
