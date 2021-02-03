package de.maxizink.discordbotapiexample.scheduler;

import de.maxizink.discordbotapi.schedulars.core.models.AsyncTimeScheduler;

import java.util.concurrent.TimeUnit;

public class ExampleAsyncTimeScheduler extends AsyncTimeScheduler {

  public ExampleAsyncTimeScheduler() {
    super(5, TimeUnit.SECONDS);
  }

  @Override
  public void beforeStart() {
    System.out.println("Ich passiere vor dem starten");
  }

  @Override
  public void action() {
    System.out.println("Ich werde alle 5 Sekunden ausgeführt");
  }

  @Override
  public void afterStop() {
    System.out.println("Ich passiere nach dem stopen");
  }

}
