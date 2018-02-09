  package com.almundo;

import com.almundo.exceptions.InvalidStateException;
import com.almundo.models.Call;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class WaitingRoom {

  private List<Call> waitingCalls;

  public void toWaitList(Call call) {
    if (call.getEndHour() != null) {
      new InvalidStateException("Una llamada terminada no puede ser agregada a la lista de espera");
    }
    waitingCalls.add(call);
  }

  public List<Call> getWaitingCalls() {
    return waitingCalls;
  }

  public void setWaitingCalls(List<Call> waitingCalls) {
    this.waitingCalls = waitingCalls;
  }
  
  
  
  

} // Fin clase $(name)
