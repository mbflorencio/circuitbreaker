package br.com.mf.service;

import br.com.mf.model.Deadline;
import br.com.mf.repository.DeadlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeadlineService {
    @Autowired DeadlineRepository repo;

    public Deadline save(Deadline deadline){
        return repo.save(deadline);
    }
    public Deadline findByClientId(Long idClient){
        return repo.findByIdClient(idClient);
    }
    public List<Deadline> findAll(){
        List<Deadline> list = repo.findAll();
        return list;
    }
}
