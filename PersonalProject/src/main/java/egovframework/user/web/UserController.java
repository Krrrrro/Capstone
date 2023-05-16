package egovframework.user.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import egovframework.user.service.UserService;
import egovframework.user.service.UserDefaultVO;
import egovframework.user.service.UserVO;

/**
 * @Class Name : UserController.java
 * @Description : User Controller class
 * @Modification Information
 *
 * @author seungho
 * @since 2023-05-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=UserVO.class)
public class UserController {

    @Resource(name = "userService")
    private UserService userService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * user 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 UserDefaultVO
	 * @return "/user/UserList"
	 * @exception Exception
	 */
    @RequestMapping(value="/user/UserList.do")
    public String selectUserList(@ModelAttribute("searchVO") UserDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	
    	/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	/** pageing */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        List<?> userList = userService.selectUserList(searchVO);
        model.addAttribute("resultList", userList);
        
        int totCnt = userService.selectUserListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/user/UserList";
    } 
    
    @RequestMapping("/user/addUserView.do")
    public String addUserView(
            @ModelAttribute("searchVO") UserDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("userVO", new UserVO());
        return "/user/UserRegister";
    }
    
    @RequestMapping("/user/addUser.do")
    public String addUser(
            UserVO userVO)
            throws Exception {
        userService.insertUser(userVO);
        return "successSignup";
    }
    
    @RequestMapping("/user/updateUserView.do")
    public String updateUserView(
            @RequestParam("userid") java.lang.String userid ,
            @ModelAttribute("searchVO") UserDefaultVO searchVO, Model model)
            throws Exception {
        UserVO userVO = new UserVO();
        userVO.setUserid(userid);
        // 변수명은 CoC 에 따라 userVO
        model.addAttribute(selectUser(userVO, searchVO));
        return "/user/UserRegister";
    }
    
    @RequestMapping("/user/checkUser.do")
    public
    String checkUser(
    		UserVO vo, Model model) throws Exception {
    	try {
    		model.addAttribute("user", userService.selectUser(vo));
    	}catch(Exception e) {
    		System.out.print(e.getMessage());
    	}
    	System.out.println("왓다!1");
        return "checkUser";
    }
    
    @RequestMapping("/user/checkId.do")
    public
    ModelAndView checkId(
    		UserVO vo, Model model) throws Exception {
    	ModelAndView json = new ModelAndView("jsonView");
    	UserVO user = null;
    	try {
    		user = userService.checkId(vo);
    		
    	}catch(Exception e) {
    		System.out.print(e.getMessage());
    	}
    	json.addObject("isthere", user != null);
    	System.out.println(user != null);
        return json;
    }
    

    @RequestMapping("/user/selectUser.do")
    public @ModelAttribute("userVO")
    UserVO selectUser(
            UserVO userVO,
            @ModelAttribute("searchVO") UserDefaultVO searchVO) throws Exception {
        return userService.selectUser(userVO);
    }

    @RequestMapping("/user/updateUser.do")
    public String updateUser(
            UserVO userVO,
            @ModelAttribute("searchVO") UserDefaultVO searchVO, HttpServletRequest req)
            throws Exception {
    	
        userService.updateUser(userVO);
        req.getSession().setAttribute("user", userService.selectUser(userVO));
        return "forward:/index.do";
    }
    
    @RequestMapping("/user/deleteUser.do")
    public String deleteUser(
            UserVO userVO,
            @ModelAttribute("searchVO") UserDefaultVO searchVO, SessionStatus status)
            throws Exception {
        userService.deleteUser(userVO);
        status.setComplete();
        return "forward:/user/UserList.do";
    }

    
    @RequestMapping("/tiles.do")
    public String tiles()
            throws Exception {
        return "tiles/test.tiles";
    }
}
