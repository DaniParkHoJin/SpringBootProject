package com.hojin.controller;


import com.hojin.domain.Item3;
import com.hojin.service.Item3Service;
import com.hojin.util.MediaUtils;
import com.hojin.util.UploadFileUtils;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/item3")
@MapperScan(basePackages = "com.hojin.mapper")
public class Item3Controller {

    @Autowired
    private Item3Service item3Service;

    @Value("${upload.path}")
    private String uploadPath;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public void list(Model model) throws Exception {
        List<Item3> item3List = this.item3Service.list();
        model.addAttribute("item3List", item3List);
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute(new Item3());
        return "item3/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Item3 item3, Model model) throws Exception {
        log.info("register item3.getFiles() : " + item3.toString());
        String[] files = item3.getFiles();
        for (int i = 0; i < files.length; i++) {
            log.info("register files[i] = {}" , files[i]);
        }
        this.item3Service.regist(item3);
        model.addAttribute("msg", "등록이 완료되었습니다.");
        return "item3/success";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String modifyForm(Integer itemId, Model model) throws Exception {
        Item3 item3 = this.item3Service.read(itemId);
        model.addAttribute(item3);
        return "item3/modify";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modify(Item3 item3, Model model) throws Exception {
        String[] files = item3.getFiles();
        for (int i = 0; i < files.length; i++) {
            log.info("files[i] ={} ", files[i]);
        }
        this.item3Service.modify(item3);
        model.addAttribute("msg", "수정이 완료되었습니다.");
        return "item3/success";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String removeForm(Integer itemId, Model model) throws Exception {
        Item3 item3 = this.item3Service.read(itemId);
        model.addAttribute(item3);
        return "item3/remove";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(Item3 item3, Model model) throws Exception {
        this.item3Service.remove(item3.getItemId());
        model.addAttribute("msg", "삭제가 완료되었습니다.");
        return "item3/success";
    }

    @ResponseBody
    @RequestMapping(value = "/uploadAjax", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception {
        log.info("originalName: " + file.getOriginalFilename());
        String savedName = UploadFileUtils.UploadFile(uploadPath,
                file.getOriginalFilename(), file.getBytes());
        log.info("savedName :{} ", savedName);
        return new ResponseEntity<String>(savedName, HttpStatus.CREATED);
    }

    @ResponseBody
    @RequestMapping("/displayFile")
    public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {
        InputStream in = null;
        ResponseEntity<byte[]> entity = null;
        log.info("displayFile NAME:{} ", fileName);
        try {

            String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
            MediaType mType = MediaUtils.getMediaType(formatName);
            HttpHeaders headers = new HttpHeaders();
            in = new FileInputStream(uploadPath + fileName);
            if (mType != null) {
                headers.setContentType(mType);
            } else {
                fileName = fileName.substring(fileName.indexOf("_") + 1);
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                headers.add("Content-Disposition", "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
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
    @RequestMapping("/getAttach/{itemId}")
    @ResponseBody
    public List<String> getAttach(@PathVariable("itemId") Integer itemId) throws
            Exception {

        log.info("getAttach itemId:{} ", itemId);
        List<String> list = item3Service.getAttach(itemId);

        list.forEach(filename->{
            log.info("filename: {}", filename);
        });

        return list;
    }
}
