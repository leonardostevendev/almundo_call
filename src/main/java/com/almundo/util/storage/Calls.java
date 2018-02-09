package com.almundo.util.storage;

import com.almundo.exceptions.CallCenterException;
import com.almundo.models.Call;
import com.almundo.models.User;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Administrador
 */
public class Calls {

  private List<Call> all;

  public Calls() {
    all = new ArrayList<>();
  }

  public List<Call> getInCourseCalls() {
    validateStorageStatus();
    return all.stream().filter(c -> c.getEndHour() != null).collect(Collectors.toList());
  }

  public void validateStorageStatus() {
    if (all == null) {
      throw new CallCenterException("Aun no se encuentran llamadas en el historial");
    }
  }

  public List<Call> getCalls() {
    return all;
  }

  public void setCalls(List<Call> calls) {
    this.all = calls;
  }

  public void printLog() {
      all.stream().forEach(c -> System.out.println(c.toString()));
    
  }

} // Fin clase $(name)
