package com.homework.join;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.homework.join.member.model.vo.Member;

@Controller
@SessionAttributes("msg")
//session처럼 동작함 httpSession만큼 scope가 넓지 않음. model 즉 request의 scope 만큼임
//큰 장점: F5 중복실행되지 않음. 1번 전달되고 다시 읽기가 되지 않음
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

	@RequestMapping(value="signUp", method = RequestMethod.POST)
	@ModelAttribute("msg")
//	public String signUp(@RequestBody Member mvo) throws Exception {
public String signUp(Model model,
		Member mvo      //required = false: 이전 페이지에서 들고 들어오는게 없을 수도 있어~
						//required = true가 기본값
						//예1: 검색어를 입력할수도, 없을수도 있을 때 
						//예2: 페이징 처리 시 pageNum 없이 들어올수도 있을 때 사용
		,@RequestParam(name="memberId", required = false) String mId// 이렇게 해도 되지만 번거로움.
		,@RequestParam(name="memberPwd", defaultValue = "1") String mPwd
		,@RequestParam("memberNm") String mName
		) throws Exception {
		logger.info("Controller args: "+mvo);
		int result= 0;
		String msg = "";
		try {
			result = memberService.signUp(mvo);
			logger.info(String.valueOf(result));
			if(result>0) {
				msg= "회원가입 성공";
			} else {
				msg= "회원가입 실패";
			} 
		}catch(Exception  e) {
			e.printStackTrace();
			msg= "회원가입 과정에서 오류 발생";
		}
		model.addAttribute("msg", msg);
		 return "redirect:/";
	}
	
}
