package com.hojin.domin;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@ToString
public class MultiFileMember {
	private String userId;
	private String password;
	private List<MultipartFile> pictureList;
}
