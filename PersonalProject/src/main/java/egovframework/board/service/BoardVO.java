package egovframework.board.service;

/**
 * @Class Name : BoardVO.java
 * @Description : Board VO class
 * @Modification Information
 *
 * @author seungho
 * @since 2023-05-06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class BoardVO extends BoardDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** id */
    private int id;
    
    /** subject */
    private java.lang.String subject;
    
    /** content */
    private java.lang.String content;
    
    /** content */
    private java.lang.String onlytext;
    
    /** regdate */
    private java.lang.String regdate;
    
    /** writer */
    private java.lang.String writer;
    
    /** userid */
    private java.lang.String userid;
    
    /** views */
    private int views;
    
    /** ip */
    private java.lang.String ip;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public java.lang.String getSubject() {
        return this.subject;
    }
    
    public void setSubject(java.lang.String subject) {
        this.subject = subject;
    }
    
    public java.lang.String getUserid() {
        return this.userid;
    }
    
    public void setUserid(java.lang.String userid) {
        this.userid = userid;
    }
    
    public java.lang.String getContent() {
        return this.content;
    }
    
    public void setContent(java.lang.String content) {
        this.content = content;
    }
    
    public java.lang.String getOnlytext() {
        return this.onlytext;
    }
    
    public void setOnlytext(java.lang.String onlytext) {
        this.onlytext = onlytext;
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
    
    public int getViews() {
        return this.views;
    }
    
    public void setViews(int views) {
        this.views = views;
    }
    
    public java.lang.String getIp() {
        return this.ip;
    }
    
    public void setIp(java.lang.String ip) {
        this.ip = ip;
    }
    
}
