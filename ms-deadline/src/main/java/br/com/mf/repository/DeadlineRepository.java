package br.com.mf.repository;

import br.com.mf.model.Deadline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeadlineRepository extends JpaRepository<Deadline,Long> {
    Deadline findByIdClient(long idClient);
}
