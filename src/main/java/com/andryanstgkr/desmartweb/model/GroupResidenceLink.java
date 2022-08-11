package com.andryanstgkr.desmartweb.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupResidenceLink extends BaseEntity{
   private Group group;

   private Resident resident;

}
