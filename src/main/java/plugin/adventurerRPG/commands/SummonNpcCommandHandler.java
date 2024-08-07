package plugin.adventurerRPG.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SummonNpcCommandHandler extends BaseCommandHandler {
  @Override
  public boolean onExecutePlayerCommand(Player player, Command cmd, String label, String[] args) {
    // プレイヤーがコマンドを実行した場合の処理
    player.sendMessage("ようこそ冒険者ギルドへ");
    return true;
  }

  @Override
  public boolean onExecuteNPCCommand(CommandSender sender, Command cmd, String label, String[] args) {
    return false;
  }
}

