package com.ibm.eshub.mqbrowser.req.data;

public class UserRequest
{
  private String email;
  private String admin;
  private String viewer;
  private String mail;

  public String toString()
  {
    return "UserRequest{email='" + email + '\'' + ", admin='" + admin + '\'' + ", viewer='" + viewer + '\'' + ", mail='" + mail + '\'' + '}';
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAdmin() {
    return admin;
  }

  public void setAdmin(String admin) {
    this.admin = admin;
  }

  public String getViewer() {
    return viewer;
  }

  public void setViewer(String viewer) {
    this.viewer = viewer;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }
}