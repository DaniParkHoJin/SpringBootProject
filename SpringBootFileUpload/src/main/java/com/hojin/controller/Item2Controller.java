package com.hojin.controller;

import com.hojin.domain.Item;
import com.hojin.domain.Item2;
import com.hojin.service.Item2Service;
import com.hojin.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@Slf4j
@Controller
@RequestMapping("/item2")
@MapperScan(basePackages = "com.hojin.mapper")
public class Item2Controller {

    @Autowired
    private Item2Service item2Service;

    @Value("${upload.path")
    private String uploadPath;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public void list(Model model) throws Exception {
        List<Item2> item2List = this.item2Service.list();
        model.addAttribute("item2List", item2List);
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute(new Item2());
        return "item2/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Item2 item2, Model model) throws Exception {
        List<MultipartFile> pictures = item2.getPictures();

        for (int i = 0; i < pictures.size(); i++) {
            MultipartFile file = pictures.get(i);

            log.info("originalName: " + file.getOriginalFilename());
            log.info("size: " + file.getSize());
            log.info("contentType: " + file.getContentType());
            String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());

            if (i == 0) {
                item2.setPictureUrl(savedName);
            } else if (i == 1) {
                item2.setPictureUrl2(savedName);
            }
        }
        this.item2Service.regist(item2);

        model.addAttribute("msa", "등록이 완료되었습니다.");
        return "item/success";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String modifyForm(Integer itemId, Model model) throws Exception {
        Item2 item2 = this.item2Service.read(itemId);
        model.addAttribute(item2);
        return "item2/modify";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modify(Item2 item2, Model model) throws Exception {
        List<MultipartFile> pictures = item2.getPictures();
        for (int i = 0; i < pictures.size(); i++) {
            MultipartFile file = pictures.get(i);

            if (file != null && file.getSize() > 0) {
                log.info("originalName: " + file.getOriginalFilename());
                log.info("size: " + file.getSize());
                log.info("contentType: " + file.getContentType());
                String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());

                if (i == 0) {
                    item2.setPictureUrl(savedName);
                } else if (i == 1) {
                    item2.setPictureUrl2(savedName);
                }
            }

        }
        this.item2Service.modify(item2);
        model.addAttribute("msg", "수정이 완료되었습니다.");
        return "item2/success";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String removeForm(Integer itemId, Model model) throws Exception {
        Item2 item = this.item2Service.read(itemId);
        model.addAttribute(item);
        return "item2/remove";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(Item2 item2, Model model) throws Exception {
        this.item2Service.remove(item2.getItemId());
        model.addAttribute("msg", "삭제가 완료되었습니다.");
        return "item2/success";
    }

    private String uploadFile(String originalName, byte[] fileData) throws
            Exception {
        UUID uid = UUID.randomUUID();
        String savedName = uid.toString() + "_" + originalName;
        File target = new File(uploadPath, savedName);
        FileCopyUtils.copy(fileData, target);
        return savedName;
    }

    @ResponseBody
    @RequestMapping("/display")
    public ResponseEntity<byte[]> displayFile(Integer itemId) throws Exception {
        InputStream in = null;
        ResponseEntity<byte[]> entity = null;
        String fileName = item2Service.getPicture(itemId);
        log.info("FILE NAME: " + fileName);
        try {
            String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
            MediaType mType = getMediaType(formatName);
            HttpHeaders headers = new HttpHeaders();
            in = new FileInputStream(uploadPath + File.separator + fileName);

            if (mType != null) {
                headers.setContentType(mType);
            }
            entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
        } finally {
            in.close();
        }
        return entity;
    }

    @ResponseBody
    @RequestMapping("/display2")
    public ResponseEntity<byte[]> displayFile2(Integer itemId) throws Exception {
        InputStream in = null;
        ResponseEntity<byte[]> entity = null;
        String fileName = item2Service.getPicture2(itemId);
        log.info("FILE NAME: " + fileName);
        try {
            String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
            MediaType mType = getMediaType(formatName);
            HttpHeaders headers = new HttpHeaders();
            in = new FileInputStream(uploadPath + File.separator + fileName);
            if (mType != null) {
                headers.setContentType(mType);
            }
            entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
        } finally {
            in.close();
        }
        return entity;

    }
    private MediaType getMediaType(String formatName) {
        if (formatName != null) {
            if (formatName.equals("JPG")) {
                return MediaType.IMAGE_JPEG;
            }
            if (formatName.equals("GIF")) {
                return MediaType.IMAGE_GIF;
            }
            if (formatName.equals("PNG")) {
                return MediaType.IMAGE_PNG;
            }
        }
        return null;
    }
}

