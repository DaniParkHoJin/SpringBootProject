package com.hojin.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
public class Item2 implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer itemId;
    private String itemName;
    private Integer price;
    private String description;
    private List<MultipartFile> pictures;
    private String pictureUrl;
    private String pictureUrl2;

}
