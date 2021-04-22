package casino.manager.attendent.service;


import casino.manager.attendent.entity.Attendant;
import casino.manager.attendent.repository.AttendantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendantService {
    @Autowired
    private AttendantRepository attendantRepository;


    public List<Attendant> getAllAttendents() {
       return this.attendantRepository.findAll();
    }
}
