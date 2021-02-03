package de.maxizink.discordbotapiexample;

import de.maxizink.discordbotapi.DiscordBot;
import de.maxizink.discordbotapi.utils.Logger;
import de.maxizink.discordbotapiexample.commands.ChatMessageEvent;
import de.maxizink.discordbotapiexample.commands.ExampleChooseEmbedCommand;
import de.maxizink.discordbotapiexample.commands.ExampleEmbedPageCommand;
import de.maxizink.discordbotapiexample.commands.PurgeCommand;
import de.maxizink.discordbotapiexample.scheduler.ExampleAsyncTimeScheduler;
import de.maxizink.discordbotapiexample.scheduler.ExampleSyncTimeScheduler;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Bootstrap {

  public static void main(final String[] args) {
    System.out.println("DiscordBotAPI Example - by @IBims1ckoky | Maxi Zink");

    DiscordBot discordBot = null;
    try {
      discordBot = new DiscordBot("token");
    } catch (LoginException | InterruptedException e) {
      Logger.ERROR("Error while starting the Service!");
      e.printStackTrace();
    } finally {
      discordBot.setActivity(Activity.playing("here"));
      discordBot.setStatus(OnlineStatus.DO_NOT_DISTURB);

      discordBot.registerCommand(new ExampleEmbedPageCommand(discordBot));
      discordBot.registerCommand(new ExampleChooseEmbedCommand(discordBot));
      discordBot.registerCommand(new PurgeCommand());

      discordBot.registerEvent(new ChatMessageEvent());

      discordBot.registerTimeScheduler(new ExampleAsyncTimeScheduler());
      discordBot.registerTimeScheduler(new ExampleSyncTimeScheduler());

      discordBot.startTimeSchedulers();
    }
  }
}
