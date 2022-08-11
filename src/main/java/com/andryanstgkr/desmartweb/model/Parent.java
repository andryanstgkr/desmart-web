package com.andryanstgkr.desmartweb.model;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Parent extends BaseEntity {
   private Resident husband;

   private Resident wife;

   private LocalDate marriageDate;

   private LocalDate divorceDate;
}
