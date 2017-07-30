package com.georgiy.denga.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer trainNumber;

    private String type;

    @Temporal(TemporalType.DATE)
    private Date departDT;

    @Temporal(TemporalType.DATE)
    private Date destDT;

    private Integer sitsCount;

//  @OneToMany(mappedBy = "train", fetch = FetchType.EAGER)
//  private Set<Ticket> tickets;
//
//  @ManyToOne
//  @JoinColumn(name = "schedule")
//  private Schedule schedule;
}
