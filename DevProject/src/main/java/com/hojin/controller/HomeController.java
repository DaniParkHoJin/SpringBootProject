package com.hojin.controller;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hojin.domin.Address;
import com.hojin.domin.Card;
import com.hojin.domin.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
//// 어느 클래스를 가나 동일하다. 클래스 시작하면 항상 가지고 붙여 사용한다. println 대신 사용한다.
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		// info 레벨의 로그를 출력한다.
//		//log.info("환영합니다. 지역은 {}", locale);
//		
//		logger.info("환영합니다. 지역은{}.", locale);
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		String formatterDate = dateFormat.format(date);
//		
//		model.addAttribute("서버 시간", formatterDate);
//		
//		logger.info("모델 정보:{},format:{}", model, formatterDate);
//		System.out.println(model);
//		
//		return "home";
//	}
	@GetMapping("/")
	public String home(Locale locale, Model model) {
		log.info("Welcome home! The client loacle is " + locale + ".");
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일 (E) a h시 m분 s초");
		String formattedNow = now.format(formatter);
		model.addAttribute("serverTime", formatter);

		return "home";
	}

	@GetMapping("/home01")
	public String home01(Locale locale, Model model) {
//		log.info("Welcome home! The client locale is " + locale + ".");
//		LocalDateTime now = LocalDateTime.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일 (E) a h시 m분 s초");
//		String formattedNow = now.format(formatter);
//		model.addAttribute("serverTime", formattedNow);
//		return "home01";

		return "home01";
	}

	@GetMapping("/home02")
	public String home2(Model model) {
		log.info("home2");
		Member member = new Member();

		member.setUserId("hong");
		member.setPassword("1234");
		member.setEmail("hong@ccc.com");
		member.setUserName("박호진");

		LocalDate dateOfBirth = LocalDate.of(1988, 11, 19);
		member.setDateOfBirth(dateOfBirth);
		model.addAttribute(member);

		return "home02";
	}

	@GetMapping("/home03")
	public String home03(Locale locale, Model model) {
		log.info("Welcome home! The client locale is " + locale + ".");
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일 (E) a h시 m분 s초");
		String formattedNow = now.format(formatter);
		model.addAttribute("serverTime", formattedNow);
		return "home03";
	}

	@GetMapping("/home04")
	public String home04() {

		return "home04";
	}

	@GetMapping("/home0101")
	public String home0101(Model model) {

		Member member = new Member();
//
//		member.setUserId("hongkd");
//		member.setPassword("1234");
//		member.setEmail("bbb@ccc.com");
//		member.setUserName("홍길동");
//		LocalDate dateOfBirth = LocalDate.of(1988, 10, 7);
//		member.setDateOfBirth(dateOfBirth);
//		model.addAttribute(member);

		member.setUserId("parkId");
		model.addAttribute(member);

		return "home0101";

	}

	@GetMapping("/home0102")
	public String home0102(Model model) {
		Member member = new Member();
		String[] hobbyArray = { "Music", "Movie" };
		member.setHobbyArray(hobbyArray);
		List<String> hobbyList = new ArrayList<String>();
		hobbyList.add("Music");
		hobbyList.add("Movie");
		member.setHobbyList(hobbyList);
		model.addAttribute(member);
		return "home0102";
	}

	@GetMapping("/home0103")
	public String home0103(Model model) {
		Member member = new Member();

		Address address = new Address();
		address.setPostCode("080908");
		address.setLocation("seoul");

		member.setAddress(address);
		model.addAttribute(member);

		return "home0103";
	}

	@GetMapping("/home0104")
	public String home0104(Model model) {
		Member member = new Member();

//		List<Card> cardList = new ArrayList<Card>();
//
//		Card card1 = new Card();
//		card1.setNo("123456");
//		YearMonth validMonth = YearMonth.of(2020, 9);
//		card1.setValidMonth(validMonth);
//		cardList.add(card1);
//
//		Card card2 = new Card();
//		card2.setNo("456786");
//		YearMonth validMonth2 = YearMonth.of(2022, 11);
//		card2.setValidMonth(validMonth2);
//		cardList.add(card2);
//
//		member.setCardList(cardList);
//		model.addAttribute(member);

		member.setUserId("hongkd<>&'\"");
		model.addAttribute(member);

		return "home0104";
	}

	@GetMapping("/home0105")
	public String home0105(Model model) {
		/*
		 * Map memberMap = new HashMap();
		 * 
		 * memberMap.put("userId", "hongkd"); memberMap.put("password", "1234");
		 * memberMap.put("email", "bbb@ccc.com"); memberMap.put("userName", "홍길동");
		 * LocalDate dateOfBirth = LocalDate.of(1988, 10, 7);
		 * memberMap.put("dateOfBirth", dateOfBirth);
		 * 
		 * model.addAttribute("memberMap", memberMap);
		 */

		Member member = new Member();
		model.addAttribute(member);
		return "home0105";
	}

	@GetMapping("/home0201")
	public String home0201(Model model) {
//		int coin = 1000;
//		model.addAttribute("coin", coin);
//		return "home0201";
		Member member = new Member();
		member.setUserId("parkId");
		model.addAttribute(member);

		return "home0201";

	}

	@GetMapping("/home0202")
	public String home0202(Model model) {
//		int coin = 1000;
//
//		model.addAttribute("coin", coin);

		Member member = new Member();

		member.setUserId("parkId0202");
		model.addAttribute(member);

		return "home0202";
	}

	@GetMapping("/home0203")
	public String home0203(Model model) {
		/*
		 * String userId = "parkId";
		 * 
		 * model.addAttribute("userId", userId);
		 * 
		 * return "home0203";
		 */

		Member member = new Member();

		member.setUserId("parkId0203");

		model.addAttribute(member);

		return "home0203";
	}

	@GetMapping("/home0204")
	public String home0204(Model model) {

		Member member = new Member();
		model.addAttribute(member);
		return "home0204";
	}

	@GetMapping("/home0301")
	public String home0301(Model model) {

		Member member = new Member();
		member.setUserId("parkId0301");
		model.addAttribute(member);

		return "home0301";

	}

	@GetMapping("/home0302")
	public String home0302(Model model) {
		Member member = new Member();
		model.addAttribute(member);
		return "home0302";
	}

	@GetMapping("/home0303")
	public String home0303(Model model) {
		Member member = new Member();
		member.setUserId("");
		model.addAttribute(member);
		return "home0303";
	}

	@GetMapping("/home0304")
	public String home0304(Model model) {
		Member member = new Member();
		member.setUserId("hongkd");
		model.addAttribute(member);
		return "home0304";
	}

	@GetMapping("/home0305")
	public String home0305(Model model) {
		Member member = new Member();
		String[] hobbyArray = null;
		member.setHobbyArray(hobbyArray);
		model.addAttribute(member);
		return "home0305";
	}

	@GetMapping("/home0306")
	public String home0306(Model model) {
		Member member = new Member();
		String[] hobbyArray = {};
		member.setHobbyArray(hobbyArray);
		model.addAttribute(member);
		return "home0306";
	}

	@GetMapping("/home0307")
	public String home0307(Model model) {
		Member member = new Member();
		String[] hobbyArray = { "Music", "Movie" };
		member.setHobbyArray(hobbyArray);
		model.addAttribute(member);
		return "home0307";
	}

	@GetMapping("/home0308")
	public String home0308(Model model) {
		Member member = new Member();
		model.addAttribute(member);
		return "home0308";
	}

	@GetMapping("/home0309")
	public String home0309(Model model) {
		Member member = new Member();
		List<String> hobbyList = new ArrayList<String>();
		member.setHobbyList(hobbyList);
		model.addAttribute(member);
		return "home0309";
	}

	@GetMapping("/home0310")
	public String home0310(Model model) {
		Member member = new Member();
		List<String> hobbyList = new ArrayList<String>();
		hobbyList.add("Music");
		hobbyList.add("Movie");

		member.setHobbyList(hobbyList);

		return "home0310";
	}

	@GetMapping("/home0311")
	public String home0311(Model model) {
		Map memberMap = new HashMap();
		model.addAttribute("memberMap", memberMap);
		return "home0311";
	}

	@GetMapping("/home0312")
	public String home0312(Model model) {
		Map memberMap = new HashMap();
		memberMap.put("userId", "parkId");
		memberMap.put("password", "1234");
		memberMap.put("email", "bbb@ccc.com");
		memberMap.put("userName", "홍길동");
		LocalDate dateOfBirth = LocalDate.of(1988, 10, 7);
		memberMap.put("dateOfBirth", dateOfBirth);
		model.addAttribute("memberMap", memberMap);
		return "home0312";
	}

	@GetMapping("/home0401")
	public String home0401(Model model) {
//		int coin = 1000;
//		String userId = "parkId";
//		Member member = new Member();
//		model.addAttribute("coin", coin);
//		model.addAttribute("userId", userId);
//		model.addAttribute("member", member);

		Member member = new Member();
		String[] hobbyArray = { "Music", "Movie" };
		member.setHobbyArray(hobbyArray);

		model.addAttribute(member);

		return "home0401";
	}

	@GetMapping("/home0402")
	public String home0402(Model model) {

		return "home0402";
	}

	@GetMapping("/home0501")
	public String home0501(Model model) {
		Member member = new Member();

		model.addAttribute(member);
		return "home0501";
	}

	@GetMapping("/home0502")
	public String home0502(Model model) {
		Member member = new Member();
		member.setForeigner(true);

		model.addAttribute(member);
		return "home0502";
	}

	@GetMapping("/home0601")
	public String home0601(Model model) {
		Member member = new Member();

		model.addAttribute(member);
		return "home0601";
	}

	@GetMapping("/home0602")
	public String home0602(Model model) {
		Member member = new Member();
		member.setGender("F");
		model.addAttribute(member);
		return "home0601";
	}

	@GetMapping("/home0603")
	public String home0603(Model model) {
		Member member = new Member();
		member.setGender("M");
		model.addAttribute(member);
		return "home0601";
	}

	@GetMapping("/home0701")
	public String home0701(Model model) {
		Member member = new Member();

		String[] hobbyArray = { "Music", "Movie" };
		member.setHobbyArray(hobbyArray);

		model.addAttribute(member);
		return "home0701";
	}

	@GetMapping("/home0702")
	public String home0702(Model model) {
		Member member = new Member();

		List<String> hobbyList = new ArrayList<String>();
		hobbyList.add("Music0702");
		hobbyList.add("Movie0702");
		member.setHobbyList(hobbyList);

		model.addAttribute(member);
		return "home0702";
	}

	@GetMapping("/home0703")
	public String home0703(Model model) {
		Member member = new Member();

		List<Card> cardList = new ArrayList<Card>();

		Card card1 = new Card();
		card1.setNo("123456");
		YearMonth validMonth = YearMonth.of(2022, 12);
		card1.setValidMonth(validMonth);
		cardList.add(card1);

		Card card2 = new Card();
		card2.setNo("456786");
		YearMonth validMonth2 = YearMonth.of(2023, 4);
		card2.setValidMonth(validMonth2);
		cardList.add(card2);

		member.setCardList(cardList);
		model.addAttribute(member);

		return "home0703";
	}

	@GetMapping("/home0801")
	public String home0801(Model model) {
		Member member = new Member();
		String hobby = "Music0801,Movie0801";
		member.setHobby(hobby);
		model.addAttribute(member);
		return "home0801";
	}

	@GetMapping("/home0901")
	public String home0901(Model model) {
		return "home0901";
	}

	@GetMapping("/home1001")
	public String home1001(Model model) {
		return "home1001";
	}

	@GetMapping("/home1101")
	public String home1101(Model model) {
		return "home1101";
	}

	@GetMapping("/home1102")
	public String home1102(Model model) {
		return "home1102";
	}

	@GetMapping("/home2101")
	public String home2101(Model model) {

		int coin = 1000;

		model.addAttribute("coin", coin);

		return "home2101";
	}

	@GetMapping("/home2201")
	public String home2201(Model model) {

		String coin = "2,000";

		model.addAttribute("coin", coin);

		return "home2201";
	}

	@GetMapping("/home2202")
	public String home2202(Model model) {

		String coin = "1,000.25";

		model.addAttribute("coin", coin);

		return "home2202";
	}

	@GetMapping("/home3301")
	public String home3301(Model model) {

		Date date = new Date();
		model.addAttribute("now", date);
		return "home3301";
	}

	@GetMapping("/home3302")
	public String home3302(Model model) {

		Date date = new Date();
		model.addAttribute("now", date);
		return "home3302";
	}

	@GetMapping("/home3303")
	public String home3303(Model model) {

		Date date = new Date();
		model.addAttribute("now", date);
		return "home3303";
	}

	@GetMapping("/home3304")
	public String home3304(Model model) {

		Date date = new Date();
		model.addAttribute("now", date);
		return "home3304";
	}

	@GetMapping("/home5101")
	public String home5101(Model model) {

		String str = "Hello, World!";
		model.addAttribute("str", str);
		return "home5101";
	}

}
