package com.icia.movieinfo;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.swing.text.View;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.icia.movieinfo.dto.MovieDto;
import com.icia.movieinfo.service.MovieService;
import com.mysql.cj.util.PerVmServerConfigCacheFactory;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	@Autowired
	private MovieService mServ;
	
	@GetMapping("/")
	public String home(Integer pageNum, Model model, HttpSession session) {
		log.info("home()");
		
		String view = mServ.getMovieList(pageNum, model, session);
		
		return view;
	}
	
	@GetMapping("writeFrm")
	public String writeFrm() {
		log.info("writeFrm()");
		return "writeFrm";
	}
	
	@PostMapping("writeProc")
	public String writeProc(@RequestPart List<MultipartFile> files,
								MovieDto movie,
								HttpSession session,
								RedirectAttributes rttr) {
		log.info("writeProc()");
		String view = mServ.insertMovie(files, movie, session, rttr);
		
		return view;
	}
	
	@GetMapping("detail")
	public String detail(Integer m_code, Model model) {
		log.info("detail");
		mServ.getMovie(m_code, model);
		
		return "detail"; // jsp 파일명
	}
	
	// 수정 페이지로 전환
	@GetMapping("updateFrm")
	public String updateFrm(Integer m_code, Model model) {
		log.info("updateFrm()");
		mServ.getMovie(m_code, model);
		return "updateFrm";
	}
	
	@PostMapping("updateProc")
	public String updateProc (@RequestPart List<MultipartFile> files,
			MovieDto movie,
			HttpSession session,
			RedirectAttributes rttr) {
		log.info("updateProc()");
		
		String view = mServ.movieUpdate(files, movie, session, rttr);
		return view;
	}
	
	// 삭제 데이터 처리
	@GetMapping("delete")
	public String delete (Integer m_code,
			HttpSession session,
			RedirectAttributes rttr) {
		log.info("delete()");
		String view = mServ.moviewDelete(m_code, session, rttr);
		
		return view;
	}							
	
}//class end



