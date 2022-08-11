package com.andryanstgkr.desmartweb.model;

import java.time.LocalDate;
import com.andryanstgkr.desmartweb.enums.GenderEnum;
import com.andryanstgkr.desmartweb.enums.MarriageEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Resident extends BaseEntity {
   private String icNo;

   private String firstName;

   private String middleName;

   private String lastName;

   private String nickName;

   private String phoneNo;

   private String email;

   private LocalDate dateOfBirth;

   private String address;

   private String occupation;

   private GenderEnum gender;

   private String religion;

   private MarriageEnum marriageStatus;

   private LocalDate marriageDate;

   private LocalDate divorceDate;

   private String education;

   private boolean isAlive = true;

   private Family family;

   private Resident partner;

   private SubVillage subVillage;

}
