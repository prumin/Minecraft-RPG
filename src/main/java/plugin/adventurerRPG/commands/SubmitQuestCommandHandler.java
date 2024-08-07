package plugin.adventurerRPG.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SubmitQuestCommandHandler extends BaseCommandHandler {
  @Override
  public boolean onExecutePlayerCommand(Player player, Command cmd, String label, String[] args) {
    // プレイヤーがコマンドを実行した場合の処理
    player.sendMessage("クエストを提出しました。");
    return true;
  }

  @Override
  public boolean onExecuteNPCCommand(CommandSender sender, Command cmd, String label, String[] args) {
    return false;
  }
}

