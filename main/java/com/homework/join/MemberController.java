package com.homework.join;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.homework.join.member.model.vo.Member;

@Controller
@RequestMapping("/logins")
@SessionAttributes("msg")
public class MemberController {
	
	@Autowired
	public MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@GetMapping
	public ModelAndView memberList()  throws Exception {
		List<Member> volist = memberService.memberList();
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberview", volist);
//		mv.setViewName("index");
		mv.setViewName("member");
		logger.info("volist: "+volist.toString());
		return mv;
	}

	@PostMapping
	@ModelAttribute("msg")
	public String signUp(@RequestBody Member member) throws Exception {
		String result = memberService.signUp(member);
		logger.info(result);
		try {
			if(result!=null) {
			} else {
			
			}
		}catch(Exception  e) {
			throw new RuntimeException();
		}
		
		logger.info("일단 여기까지가 끝");
		
		 return "redirect:/";
	}
	
	@ExceptionHandler
	private ModelAndView handleMemberException(Exception e) {
		logger.error(e.getMessage());
		
		//나중에 500error.jsp에서 "errorMessage" 표시해주기 + 뒤로가기, 홈으로 이동 버튼
		ModelAndView mv = new ModelAndView();
		mv.addObject("errorMessage", "회원가입 과정에서 오류 발생");
		mv.setViewName("error");
		return mv ;
	}

}
