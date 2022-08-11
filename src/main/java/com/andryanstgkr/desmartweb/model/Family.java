package com.andryanstgkr.desmartweb.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Family extends BaseEntity{

   private String familyIcNo;

   private String name;

   private Parent parent;
   
   private List<Resident> children;

}
