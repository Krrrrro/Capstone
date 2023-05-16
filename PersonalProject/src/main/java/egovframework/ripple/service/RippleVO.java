package egovframework.ripple.service;

/**
 * @Class Name : RippleVO.java
 * @Description : Ripple VO class
 * @Modification Information
 *
 * @author seungho
 * @since 2023-05-12
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class RippleVO extends RippleDefaultVO implements Comparable<RippleVO>{
    private static final long serialVersionUID = 1L;
    
    /** id */
    private int id;
    
    /** content */
    private java.lang.String content;
    
    /** regdate */
    private java.lang.String regdate;
    
    /** writer */
    private java.lang.String writer;
    
    /** ref */
    private int ref;
    
    /** re_step */
    private int reStep;
    
    /** re_level */
    private int reLevel;
    
    /** board_id */
    private int boardId;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public java.lang.String getContent() {
        return this.content;
    }
    
    public void setContent(java.lang.String content) {
        this.content = content;
    }
    
    public java.lang.String getRegdate() {
        return this.regdate;
    }
    
    public void setRegdate(java.lang.String regdate) {
        this.regdate = regdate;
    }
    
    public java.lang.String getWriter() {
        return this.writer;
    }
    
    public void setWriter(java.lang.String writer) {
        this.writer = writer;
    }
    
    public int getRef() {
        return this.ref;
    }
    
    public void setRef(int ref) {
        this.ref = ref;
    }
    
    public int getReStep() {
        return this.reStep;
    }
    
    public void setReStep(int reStep) {
        this.reStep = reStep;
    }
    
    public int getReLevel() {
        return this.reLevel;
    }
    
    public void setReLevel(int reLevel) {
        this.reLevel = reLevel;
    }
    
    public int getBoardId() {
        return this.boardId;
    }
    
    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }
    
}
