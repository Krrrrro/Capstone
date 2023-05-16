package egovframework.ripple.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.ripple.service.RippleService;
import egovframework.ripple.service.RippleDefaultVO;
import egovframework.ripple.service.RippleVO;
import egovframework.ripple.service.impl.RippleMapper;
/**
 * @Class Name : RippleServiceImpl.java
 * @Description : Ripple Business Implement class
 * @Modification Information
 *
 * @author seungho
 * @since 2023-05-12
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("rippleService")
public class RippleServiceImpl extends EgovAbstractServiceImpl implements
        RippleService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(RippleServiceImpl.class);

    @Resource(name="rippleMapper")
    private RippleMapper rippleDAO;
    
    //@Resource(name="rippleDAO")
    //private RippleDAO rippleDAO;
    
    /** ID Generation */
    //@Resource(name="{egovRippleIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * ripple을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RippleVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRipple(RippleVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	rippleDAO.insertRipple(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * ripple을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RippleVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRipple(RippleVO vo) throws Exception {
        rippleDAO.updateRipple(vo);
    }

    /**
	 * ripple을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RippleVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRipple(RippleVO vo) throws Exception {
        rippleDAO.deleteRipple(vo);
    }

    /**
	 * ripple을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RippleVO
	 * @return 조회한 ripple
	 * @exception Exception
	 */
    public RippleVO selectRipple(RippleVO vo) throws Exception {
        RippleVO resultVO = rippleDAO.selectRipple(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * ripple 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ripple 목록
	 * @exception Exception
	 */
    @SuppressWarnings("unchecked")
	public List<RippleVO> selectRippleList(RippleDefaultVO searchVO) throws Exception {
        return (List<RippleVO>) rippleDAO.selectRippleList(searchVO);
    }

    /**
	 * ripple 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ripple 총 갯수
	 * @exception
	 */
    public int selectRippleListTotCnt(RippleDefaultVO searchVO) {
		return rippleDAO.selectRippleListTotCnt(searchVO);
	}
    
}
