package plugin.adventurerRPG.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class VisitNpc extends BaseCommand implements Listener {
  @Override
  public boolean onExecutePlayerCommand(Player player, Command cmd, String label, String[] args) {
    // プレイヤーがコマンドを実行した場合の処理
    player.sendMessage("なにか御用ですか？");
    return true;
  }

  @Override
  public boolean onExecuteNPCCommand(CommandSender sender, Command cmd, String label, String[] args) {
    return false;
  }
}
