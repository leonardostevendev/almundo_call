package com.almundo.models;

/**
 *
 * @author Administrador
 */
public class User {
  private String displayName;
  private boolean avaliable;
  private UserType type;

  public User(String displayName, boolean avaliable, UserType type) {
    this.displayName = displayName;
    this.avaliable = avaliable;
    this.type = type;
  }
  
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public boolean isAvaliable() {
    return avaliable;
  }

  public void setAvaliable(boolean avaliable) {
    this.avaliable = avaliable;
  }

  public UserType getType() {
    return type;
  }

  public void setType(UserType type) {
    this.type = type;
  }
  
  @Override
  public String toString(){
  return this.displayName + "     "+this.type.name()+ "     "+this.avaliable;
  }
  
 
  
  
} // Fin clase $(name)
