package com.hojin.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Item3 implements Serializable {
     private static final long serialVersionUID = 1L;
     private Integer itemId;
     private String itemName;
     private String price;
     private String description;
     private String[] files;
}
