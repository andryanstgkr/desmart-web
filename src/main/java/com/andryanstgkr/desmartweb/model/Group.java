package com.andryanstgkr.desmartweb.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Group extends BaseEntity{

   private String name;

   private String description;

   private Organization parenOrganization;
}
