package com.biz.memo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.memo.domain.MemoDTO;
import com.biz.memo.domain.UserDTO;
import com.biz.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/memo")

/*
 * SessionAtt 로 설정된 변수는(객체) response 하기전에 서버의 기억장소 어딘가에 임시로 보관됨 webbrowser와
 * server간에 한번이라도 연결이 이루어 졌으면 session에 등록된 변수는 서버가 중단될때까지 그 값이 그대로 유지된다. web은
 * 특성ㅅ강 클라이언트의 req를 서버가 받아서 res를 수행하고마녀 모든 정보가 사라지는 특성이있다. 이런특성관 달리 spring 기반의
 * web은 일부 데이터들을 메모리에 보관했다가 재사용하는 기법이 있다.
 * 
 * sessionattribute()에 설정하는 문자열(이름)은 클래스 표준 객체생성 패턴에 의해 만들어진 이름(MemoDTO memoDTO)
 */
@SessionAttributes("memoDTO")
@Controller
public class MemoController {
	/*
	 * SessionAttribute를 사용하기 위해서는 반드시 해당변수를 생성하는 metod 가 컨트롤러에 있어야허고 해당 메서드는
	 * ModelAttribute("변수명")가 있어야 한다.
	 */
	@ModelAttribute("memoDTO")
	public MemoDTO makeMemoDTO() {
		MemoDTO memoDTO = new MemoDTO();
		return memoDTO;
	}

	@Autowired
	MemoService mService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(String search, Model model) {
		List<MemoDTO> memoList;
		if (search == null || search.isEmpty()) {
			memoList = mService.getAllList();
		} else {
			memoList = mService.getSearchList(search);
		}

		model.addAttribute("MEMO_LIST", memoList);
		return "home";
	}

	/*
	 * SessionAttribute에서 설정한 변수(객체)에는 @ModelAttribute를 설정해 두어야한다. 표준패턴이
	 * 아닐경우 @modelattribute("objectname"을 필수로 지정해 주어야한다.
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(@ModelAttribute MemoDTO memoDTO, Model model, HttpSession httpSession) {
		UserDTO userDTO = (UserDTO) httpSession.getAttribute("userDTO");
		if (userDTO == null) {
			model.addAttribute("LOGIN_MSG", "TRY");
			return "redirect:/member/login";
		}
		log.debug("!!!" + memoDTO.toString());
		model.addAttribute("memoDTO", memoDTO);
		return "insert";
	}

	/*
	 * post가 memoDTO를 수신할때 입력 form에서 사용자가 입력한 값들이 있으면 그 값들을 memoDTO의 필드 변수에 setting을
	 * 하고 만약 없으면 메모리 어딘가에 보관중인 SessionAttribute으로 설정된 memoDTO변수에서 값을 가져와서 비어있는 필드
	 * 변수를 채워서 매개변수에 주입한다.
	 * 
	 * form에서 보이지 않아도 되는 값들은 별도의 코딩을 하지 않아도 자동으로 insert POST로 전송되는 효과를 낸다. 단, 이기능을
	 * 효율적으로 사용하려면 jsp코드에 Spring-form tag로 input 를 코딩해야한다
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute MemoDTO memoDTO, Model model, String search, SessionStatus sStatus) {
		log.debug("!!!memoDTO: " + memoDTO.toString());
		int ret = mService.insert(memoDTO);

		/*
		 * SessionAttribute을 사용할때 insert, update가 완료되고 view로 보내기전에 setComplete()을 실행하여
		 * session에 담긴 값을 clear 해주어야 한다.
		 */
		sStatus.setComplete();
		return "redirect:/memo/list";
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(@RequestParam("id") String id, @ModelAttribute MemoDTO memoDTO, Model model,
			HttpSession httpSession) {
		UserDTO userDTO = (UserDTO) httpSession.getAttribute("userDTO");
		long m_seq = 0;
		try {
			m_seq = Long.valueOf(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		memoDTO = mService.getMemo(m_seq);
		if (userDTO!=null && userDTO.getU_id().equals(memoDTO.getM_auth())) {
			model.addAttribute("memoDTO", memoDTO);
			return "view";
		}else {
			model.addAttribute("LOGIN_MSG", "NO_AUTH");
			return "redirect:/member/login";
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(String id, @ModelAttribute MemoDTO memoDTO, Model model) {
		long m_seq = 0;
		try {
			m_seq = Long.valueOf(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		memoDTO = mService.getMemo(m_seq);
		model.addAttribute("memoDTO", memoDTO);
		return "insert";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute MemoDTO memoDTO, Model model, SessionStatus sStatus) {
		int ret = mService.update(memoDTO);
		sStatus.setComplete();
		return "redirect:/memo/list";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@ModelAttribute MemoDTO memoDTO) {
		int ret = mService.delete(memoDTO.getM_seq());
		return "redirect:/memo/list";
	}
}
