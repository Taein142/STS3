package com.icia.jsp01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.jsp01.dto.DataDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
		log.info("home()");
		// front-end로 데이터를 보낸 때 사용하는 객체 - Model
		// DispatcherServlet이 생성하여 보내는 객체
		model.addAttribute("data", "서버에서 보내는 문자열");
		model.addAttribute("num", 100);

		DataDTO dataDTO = new DataDTO();
		dataDTO.setCode(1);
		dataDTO.setStrData("홍길동");
		dataDTO.setNumData(23);
		dataDTO.setDataData("2000-01-05");
		model.addAttribute("person1", dataDTO);

		return "home";
	}

	@GetMapping("/mavCase")
	public ModelAndView mavCase() {
		log.info("mavCase()");

		ModelAndView mv = new ModelAndView();

		// 데이터를 담아준다.
		mv.addObject("sec_data", "두 번째 페이지");

		// 뷰를 지정한다. // 파일이름으로 지정
		mv.setViewName("modelAndView");

		DataDTO dataDTO = new DataDTO();
		dataDTO.setCode(2);
		dataDTO.setStrData("아무개");
		dataDTO.setNumData(30);
		dataDTO.setDataData("1995-02-05");

		mv.addObject("person2", dataDTO);

		return mv;
	}

	@GetMapping("/send")
	public String sendData(@RequestParam("id") String id, @RequestParam("num1") int num1,
			@RequestParam("num2") int num2) {
		log.info("sendData()");

		log.info("id : " + id);
		log.info("num1 : " + num1);
		log.info("num2 : " + num2);
		// 정보가 담겨서 가지 않기에 화면에는 정보가 출력되지 않음
		// redirect를 사용하자

		return "redirect:/";
	}

	@PostMapping("/login")
	public String loginProc(String id, String pw) {
		log.info("loginProc()");
		log.info("id: " + id);
		log.info("pw: " + pw);

		return "redirect:/";
	}

}
