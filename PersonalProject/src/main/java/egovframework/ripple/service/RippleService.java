package egovframework.ripple.service;

import java.util.List;
import egovframework.ripple.service.RippleDefaultVO;
import egovframework.ripple.service.RippleVO;

/**
 * @Class Name : RippleService.java
 * @Description : Ripple Business class
 * @Modification Information
 *
 * @author seungho
 * @since 2023-05-12
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface RippleService {
	
	/**
	 * ripple을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RippleVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertRipple(RippleVO vo) throws Exception;
    
    /**
	 * ripple을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RippleVO
	 * @return void형
	 * @exception Exception
	 */
    void updateRipple(RippleVO vo) throws Exception;
    
    /**
	 * ripple을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RippleVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteRipple(RippleVO vo) throws Exception;
    
    /**
	 * ripple을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RippleVO
	 * @return 조회한 ripple
	 * @exception Exception
	 */
    RippleVO selectRipple(RippleVO vo) throws Exception;
    
    /**
	 * ripple 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ripple 목록
	 * @exception Exception
	 */
    List<RippleVO> selectRippleList(RippleDefaultVO searchVO) throws Exception;
    
    /**
	 * ripple 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ripple 총 갯수
	 * @exception
	 */
    int selectRippleListTotCnt(RippleDefaultVO searchVO);
    
}
