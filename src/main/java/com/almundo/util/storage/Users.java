package com.almundo.util.storage;

import com.almundo.exceptions.CallCenterException;
import com.almundo.exceptions.InvalidSizeException;
import com.almundo.models.Constants;
import com.almundo.models.User;
import com.almundo.models.UserType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Administrador
 */
public class Users {

  private static List<String> randomNames = Arrays.asList("EDGARDO", "EDITH", "EDMUNDO", "EDUARDO", "NAPOLEÓN", "NARCISO", "NATALIA", "NATÁN", "ITERICO", "WANG", "WENDY", "WALID");
  private List<User> all;

  public User getFirstAvaliableInHierarchyOrder() {
    List<User> receiver = getAvailableUsers().stream().filter(u -> u.getType() == UserType.OPERADOR).collect(Collectors.toList());

    if (receiver != null && receiver.size() > 0) {
      return receiver.get(0);
    } else {
      receiver = getAvailableUsers().stream().filter(u -> u.getType() == UserType.SUPERVISOR).collect(Collectors.toList());
      if (receiver != null && receiver.size() > 0) {
        return receiver.get(0);
      } else {
        receiver = getAvailableUsers().stream().filter(u -> u.getType() == UserType.DIRECTOR).collect(Collectors.toList());
        if (receiver != null && receiver.size() > 0) {
          return receiver.get(0);
        }
      }
    }

    return null;
  }

  public void printLog() {
    all.stream().forEach(c -> System.out.println(c.toString()));
  }

  public void randomPopulate(int peopleAmount) {
    try {
      validateSizeOfRandomInitialization(peopleAmount);
      Collections.shuffle(randomNames);
      this.all = new ArrayList<>();
      for (int i = 0; i <= peopleAmount; i++) {
        all.add(new User(randomNames.get(i), true, UserType.getRandom()));
      }
    } catch (InvalidSizeException ex) {
      Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

  public int count() {
    validateStorageStatus();
    return all.size();
  }

  public List<User> getAvailableUsers() {
    validateStorageStatus();
    return all.stream().filter(u -> u.isAvaliable()).collect(Collectors.toList());
  }

  public void validateStorageStatus() {
    if (all == null) {
      throw new CallCenterException("EL callcenter no se encuentra disponible");
    }
  }

  public List<User> getUsers() {
    return all;
  }

  public void setUsers(List<User> users) {
    this.all = users;
  }

  public void validateSizeOfRandomInitialization(int size) throws InvalidSizeException {
    if (size > Constants.CALL_CENTER_SIZE || size <= 0) {
      throw new InvalidSizeException("El numero de personas con la que quiere inicializar el call center es incorrecto max:" + Constants.CALL_CENTER_SIZE + " min: 1");
    }
  }
} // Fin clase $(name)
