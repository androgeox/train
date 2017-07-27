package com.georgiy.denga.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
public class Schedule {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  Date date;

  @OneToMany(mappedBy = "schedule")
  private Set<Train> trainSet;

}
