package casino.manager.attendent.service;


import casino.manager.attendent.entity.Accountant;
import casino.manager.attendent.repository.AccountantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountantService {

    @Autowired
    private AccountantRepository accountantRepository;

    public List<Accountant> getAllAccountant(){
        return  this.accountantRepository.findAll(Sort.by("time"));
    }
}
