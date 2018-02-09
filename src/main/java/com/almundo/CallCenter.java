package com.almundo;

import com.almundo.models.Call;
import com.almundo.models.Constants;
import com.almundo.models.User;
import com.almundo.util.storage.Calls;
import com.almundo.util.storage.Users;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 *
 * @author Administrador
 */
public class CallCenter implements Runnable {

  private String displayName;
  private String telNumber;
  Users users;
  Calls calls;
  ScheduledExecutorService scheduler;
  Random r = new Random();
  DispatchCall dispatcher = new DispatchCall();

  public CallCenter(String displayName, String telNumber, int callSize) {
    calls = new Calls();
    users = new Users();
    users.randomPopulate(callSize);
    this.displayName = displayName;
    this.telNumber = telNumber;
    init();

  }

  public CallCenter() {
    init();
  }

  public void init() {
    scheduler = Executors.newSingleThreadScheduledExecutor();
    Runnable task = this;
    int initialDelay = 1;
    int periodicDelay = 1;
    scheduler.scheduleAtFixedRate(task, initialDelay, periodicDelay,
            TimeUnit.SECONDS
    );
  }

  public void makeCall(int quantity) {
    List<Call> incomingCalls = new ArrayList<>();
    for (int i = 0; i < quantity; i++) {
      incomingCalls.add(new Call(r.nextInt(Constants.CALL_MAX_DURATION), LocalDateTime.now(), null, null));
    }
    dispatcher.dispatch(users, calls, incomingCalls);

  }

  public void callsKiller() {
    List<Call> unEndedCalls = this.calls.getCalls().stream().filter(c -> c.getEndHour() == null).collect(Collectors.toList());
    for (Call unEndedCall : unEndedCalls) {
      
      List<Call> tmp = calls.getCalls();
      tmp.remove(unEndedCall);

      LocalDateTime fromDateTime = unEndedCall.getInitHour();
      LocalDateTime toDateTime = LocalDateTime.now();
      LocalDateTime tempDateTime = LocalDateTime.from(fromDateTime);
      long seconds = tempDateTime.until(toDateTime, ChronoUnit.SECONDS);
      tmp.add(unEndedCall);

      if (seconds >= Constants.CALL_MAX_DURATION) {
        unEndedCall.setEndHour(LocalDateTime.now());
        calls.setCalls(tmp);
      }
      
      List<User> tmpUsrs = users.getUsers();
        tmpUsrs.remove(unEndedCall.getAdviser());
        unEndedCall.getAdviser().setAvaliable(true);
        users.getUsers().add(unEndedCall.getAdviser());
        users.setUsers(tmpUsrs);

    }
  }
  
  public void waitingAssign(){
  List<Call> inWaiting =  dispatcher.getRoom().getWaitingCalls();
  
  int avaliableSize = users.getAvailableUsers().size();
    for (int i = 0; i < avaliableSize; i++) {
      User u = users.getFirstAvaliableInHierarchyOrder();
    
    }
  
  
  }

  @Override
  public void run() {
    callsKiller();
    //waitingAssign();
  }

} // Fin clase $(name)
