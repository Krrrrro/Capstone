package egovframework.user.service;

/**
 * @Class Name : UserVO.java
 * @Description : User VO class
 * @Modification Information
 *
 * @author seungho
 * @since 2023-05-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class UserVO extends UserDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** userid */
    private java.lang.String userid;
    
    /** userpwd */
    private java.lang.String userpwd;
    
    /** username */
    private java.lang.String username;
    
    /** useraddress */
    private java.lang.String useraddress;
    
    public java.lang.String getUserid() {
        return this.userid;
    }
    
    public void setUserid(java.lang.String userid) {
        this.userid = userid;
    }
    
    public java.lang.String getUserpwd() {
        return this.userpwd;
    }
    
    public void setUserpwd(java.lang.String userpwd) {
        this.userpwd = userpwd;
    }
    
    public java.lang.String getUsername() {
        return this.username;
    }
    
    public void setUsername(java.lang.String username) {
        this.username = username;
    }
    
    public java.lang.String getUseraddress() {
        return this.useraddress;
    }
    
    public void setUseraddress(java.lang.String useraddress) {
        this.useraddress = useraddress;
    }
    
}
