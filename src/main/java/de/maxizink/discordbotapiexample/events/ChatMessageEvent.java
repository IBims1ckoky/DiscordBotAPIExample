package de.maxizink.discordbotapiexample.events;

import de.maxizink.discordbotapi.listener.core.EventListener;
import de.maxizink.discordbotapi.utils.Logger;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

public class ChatMessageEvent extends EventListener {

  @Override
  public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
    Logger.INFO("Message sent:" + event.getMessage().getContentRaw());
  }
}