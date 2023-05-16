package egovframework.ripple.web;

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

import egovframework.ripple.service.RippleService;
import egovframework.ripple.service.RippleDefaultVO;
import egovframework.ripple.service.RippleVO;

/**
 * @Class Name : RippleController.java
 * @Description : Ripple Controller class
 * @Modification Information
 *
 * @author seungho
 * @since 2023-05-12
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=RippleVO.class)
public class RippleController {

    @Resource(name = "rippleService")
    private RippleService rippleService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * ripple 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 RippleDefaultVO
	 * @return "/ripple/RippleList"
	 * @exception Exception
	 */
    @RequestMapping(value="/ripple/RefreshRippleList.do")
    @ResponseBody
    public String RefreshselectRippleList(@ModelAttribute("searchVO") RippleDefaultVO searchVO, 
    		ModelMap model, HttpServletRequest request)
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
		
        List<?> rippleList = rippleService.selectRippleList(searchVO);
        model.addAttribute("rippleList", rippleList);
        
        int totCnt = rippleService.selectRippleListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        request.getSession().setAttribute("rippleList", rippleList);
        System.out.println("여기 왓는데../");
        return "";
    } 
    
    
    @RequestMapping(value="/ripple/RippleList.do")
    public String selectRippleList(@ModelAttribute("searchVO") RippleDefaultVO searchVO, 
    		ModelMap model, HttpServletRequest request)
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
		System.out.println("몇번재 게시판..? "  + searchVO.getBoardId());
		
        List<RippleVO> rippleList = rippleService.selectRippleList(searchVO);
        model.addAttribute("rippleList", rippleList);
        
        int totCnt = rippleService.selectRippleListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        return "boardcontent";
    } 
    
    
    
    @RequestMapping("/ripple/addRippleView.do")
    public String addRippleView(
            @ModelAttribute("searchVO") RippleDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("rippleVO", new RippleVO());
        return "/ripple/RippleList.do";
    }
    
    @RequestMapping("/ripple/addRipple.do")
    public String addRipple(
            RippleVO rippleVO,
            @ModelAttribute("searchVO") RippleDefaultVO searchVO, SessionStatus status)
            throws Exception {
    	
        rippleService.insertRipple(rippleVO);
        
        return "forward:/ripple/RefreshRippleList.do";
    }
    
    @RequestMapping("/ripple/updateRippleView.do")
    public String updateRippleView(
            @RequestParam("id") int id ,
            @ModelAttribute("searchVO") RippleDefaultVO searchVO, Model model)
            throws Exception {
        RippleVO rippleVO = new RippleVO();
        rippleVO.setId(id);        
        // 변수명은 CoC 에 따라 rippleVO
        model.addAttribute(selectRipple(rippleVO, searchVO));
        return "/ripple/RippleRegister";
    }

    @RequestMapping("/ripple/selectRipple.do")
    public @ModelAttribute("rippleVO")
    RippleVO selectRipple(
            RippleVO rippleVO,
            @ModelAttribute("searchVO") RippleDefaultVO searchVO) throws Exception {
        return rippleService.selectRipple(rippleVO);
    }

    @RequestMapping("/ripple/updateRipple.do")
    public String updateRipple(
            RippleVO rippleVO,
            @ModelAttribute("searchVO") RippleDefaultVO searchVO, SessionStatus status)
            throws Exception {
        rippleService.updateRipple(rippleVO);
        status.setComplete();
        return "forward:/ripple/RippleList.do";
    }
    
    @RequestMapping("/ripple/deleteRipple.do")
    public String deleteRipple(
            RippleVO rippleVO,
            @ModelAttribute("searchVO") RippleDefaultVO searchVO, SessionStatus status)
            throws Exception {
        rippleService.deleteRipple(rippleVO);
        status.setComplete();
        return "forward:/ripple/RippleList.do";
    }

}
