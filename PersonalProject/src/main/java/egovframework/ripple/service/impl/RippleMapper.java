package egovframework.ripple.service.impl;

import java.util.List;

import egovframework.ripple.service.RippleVO;
import egovframework.ripple.service.RippleDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : RippleMapper.java
 * @Description : Ripple Mapper Class
 * @Modification Information
 *
 * @author seungho
 * @since 2023-05-12
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("rippleMapper")
public interface RippleMapper {

	/**
	 * ripple을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RippleVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertRipple(RippleVO vo) throws Exception;

    /**
	 * ripple을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RippleVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRipple(RippleVO vo) throws Exception;

    /**
	 * ripple을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RippleVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRipple(RippleVO vo) throws Exception;

    /**
	 * ripple을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RippleVO
	 * @return 조회한 ripple
	 * @exception Exception
	 */
    public RippleVO selectRipple(RippleVO vo) throws Exception;

    /**
	 * ripple 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return ripple 목록
	 * @exception Exception
	 */
    public List<?> selectRippleList(RippleDefaultVO searchVO) throws Exception;

    /**
	 * ripple 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return ripple 총 갯수
	 * @exception
	 */
    public int selectRippleListTotCnt(RippleDefaultVO searchVO);

}
