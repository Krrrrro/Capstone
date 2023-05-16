package egovframework.board.web;

import java.io.File;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import egovframework.board.service.BoardService;
import egovframework.board.service.BoardDefaultVO;
import egovframework.board.service.BoardVO;

/**
 * @Class Name : BoardController.java
 * @Description : Board Controller class
 * @Modification Information
 *
 * @author seungho
 * @since 2023-05-06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=BoardVO.class)
public class BoardController {

    @Resource(name = "boardService")
    private BoardService boardService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * board 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 BoardDefaultVO
	 * @return "/board/BoardList"
	 * @exception Exception
	 */
    @RequestMapping(value="/board/BoardList.do")
    public String selectBoardList(@ModelAttribute("searchVO") BoardDefaultVO searchVO, 
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
		
        List<?> boardList = boardService.selectBoardList(searchVO);
        model.addAttribute("resultList", boardList);
        
        int totCnt = boardService.selectBoardListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        return "board";
    } 
    
    
    
    @RequestMapping(value="/board/searchBoardList.do")
    @ResponseBody
    public ModelAndView searchBoardList(@ModelAttribute("searchVO") BoardDefaultVO searchVO, 
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
		searchVO.setSearchCondition("1");
		System.out.println("키워드는 " + searchVO.getSearchKeyword());
		
        List<?> boardList = boardService.selectBoardList(searchVO);
        model.addAttribute("resultList", boardList);
        
        int totCnt = boardService.selectBoardListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        ModelAndView json = new ModelAndView("jsonView");
        HttpSession session = request.getSession();
        session.setAttribute("resultList", boardList);
        session.setAttribute("paginationInfo", paginationInfo);
        json.addObject("resultList", boardList);
        json.addObject("paginationInfo", paginationInfo);
        
        return json;
    } 
    
    
    
    @RequestMapping(value="/index.do")
    public String selectindexList(@ModelAttribute("searchVO") BoardDefaultVO searchVO, 
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
		
        List<?> boardList = boardService.selectBoardList(searchVO);
        model.addAttribute("resultList", boardList);
        
        int totCnt = boardService.selectBoardListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "index";
    } 
    
    @RequestMapping("/board/addBoardView.do")
    @ResponseBody
    public String addBoardView(
            BoardVO vo, Model model, HttpServletRequest request)
            throws Exception {
    	System.out.println("아이피 주소는 " + request.getRemoteAddr());
    	vo.setIp(request.getRemoteAddr());
    	boardService.insertBoard(vo);
        return "forward:/board/BoardList.do";
    }
    
    @RequestMapping("/board/addBoard.do")
    public String addBoard(
            BoardVO boardVO,
            @ModelAttribute("searchVO") BoardDefaultVO searchVO, SessionStatus status, HttpServletRequest request)
            throws Exception {
    	System.out.println("아이피 주소는 " + request.getRemoteAddr());
    	boardVO.setIp(request.getRemoteAddr());
        return "forward:/board/BoardList.do";
    }
    
    @RequestMapping("/board/updateBoardView.do")
    public String updateBoardView(
            @RequestParam("id") int id ,
            @ModelAttribute("searchVO") BoardDefaultVO searchVO, Model model)
            throws Exception {
        BoardVO boardVO = new BoardVO();
        boardVO.setId(id);
        // 변수명은 CoC 에 따라 boardVO
        model.addAttribute("result", boardService.selectBoard(boardVO));
        return "/board/BoardRegister";
    }

    @RequestMapping("/board/selectBoard.do")
    public
    String selectBoard(
            BoardVO boardVO, Model model) throws Exception {
    		boardService.updateViews(boardVO);
        	model.addAttribute("board", boardService.selectBoard(boardVO));
    	return "forward:/ripple/RippleList.do?boardId=" + boardVO.getId();
    }

    @RequestMapping("/board/updateBoard.do")
    @ResponseBody
    public ModelAndView updateBoard(
            BoardVO boardVO,
            @ModelAttribute("searchVO") BoardDefaultVO searchVO, SessionStatus status)
            throws Exception {
        boardService.updateBoard(boardVO);
        return new ModelAndView("jsonView");
    }
    
    
    @RequestMapping("/board/moveUpdatepage.do")
    public String moveUpdatepage(
            BoardVO boardVO, Model model)
            throws Exception {
    	model.addAttribute("board", boardService.selectBoard(boardVO));
        return "boardmodify";
    }
    
    @RequestMapping("/board/deleteBoard.do")
    public String deleteBoard(
            BoardVO boardVO,
            @ModelAttribute("searchVO") BoardDefaultVO searchVO, SessionStatus status)
            throws Exception {
        boardService.deleteBoard(boardVO);
        status.setComplete();
        return "forward:/board/BoardList.do";
    }
    
    @RequestMapping("/board/addImage.do")
    public void addImage(MultipartHttpServletRequest multiRequest, HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
    	
    	PrintWriter printWriter = null;
    	System.out.println("여긴 왓지롱~!");
    	try {
    		List<MultipartFile> list = multiRequest.getFiles("upload");
        	if(list.size() > 0) {
        		System.out.println("여긴 왓지롱~!");
       		String temp[] = list.get(0).getOriginalFilename().split("[.]");
       		String exten = temp[temp.length - 1];
       		String filename = UUID.randomUUID().toString() + "." + exten;
          	list.get(0).transferTo(new File("C:\\eGovFrame-3.10.0\\workspace.edu\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\PersonalProject\\dbimage\\" + filename));
//          	list.get(0).transferTo(new File("C:\\eGovFrame-3.10.0\\workspace.edu\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\WebProject\\dbimage\\" + filename));
//          	json.addObject("uploaded", 1);
//          	json.addObject("fileName", filename);
//          	json.addObject("url", "C:\\eGovFrame-3.10.0\\workspace.edu\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\2101168이승호\\dbimage\\" + filename);
          	JsonObject jsonObject = new JsonObject();
          	printWriter = resp.getWriter();
          	jsonObject.addProperty("uploaded", 1);
          	jsonObject.addProperty("fileName", filename);
          	System.out.println(req.getSession().getServletContext().getRealPath("/dbimage"));
          	jsonObject.addProperty("url", "/dbimage/" + filename);
          	printWriter.print(jsonObject);
        	}
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    }

}
