/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo;

import com.almundo.models.Call;
import com.almundo.models.User;
import com.almundo.util.storage.Calls;
import com.almundo.util.storage.Users;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class DispatchCall {

  WaitingRoom room = new WaitingRoom();

  /**
   * @param usrStorage
   * @param callsStorage
   * @param incomingCalls
   * @param args the command line arguments
   */
  public void dispatch(Users usrStorage, Calls callsStorage, List<Call> incomingCalls) {
    
    for (Call incomingCall : incomingCalls) {
      User u = usrStorage.getFirstAvaliableInHierarchyOrder();
      if (u != null) {
        incomingCall.setAdviser(u);
        incomingCall.setInitHour(LocalDateTime.now());
        List<Call> tmp = callsStorage.getCalls();
        tmp.add(incomingCall);
        callsStorage.setCalls(tmp);
        
        List<User> tmpUsrs = usrStorage.getUsers();
        tmpUsrs.remove(u);
        u.setAvaliable(false);
        tmpUsrs.add(u);
        usrStorage.setUsers(tmpUsrs);
        
        
      } else {
        room.toWaitList(incomingCall);
      }
    }
  }

  public WaitingRoom getRoom() {
    return room;
  }

  public void setRoom(WaitingRoom room) {
    this.room = room;
  }
  

}
