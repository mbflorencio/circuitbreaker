package br.com.mf.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "deadline")
public class Deadline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0;
    @Column(name="client")
    private long idClient;
    @Column(name="deadline")
    private long deadline;
}
