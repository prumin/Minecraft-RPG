package plugin.adventurerRPG.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LetsGoAdventure extends BaseCommand{
  @Override
  public boolean onExecutePlayerCommand(Player player, Command cmd, String label, String[] args) {
    player.sendMessage("さあ！冒険へ");
    return true;
  }

  @Override
  public boolean onExecuteNPCCommand(CommandSender sender, Command cmd, String label, String[] args) {
    return false;
  }
}
