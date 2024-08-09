package plugin.adventurerRPG.commands;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.Listener;
import plugin.adventurerRPG.Main;

public class GameStart extends BaseCommand implements Listener {

  public Main main;

  public GameStart(Main main) {
    this.main = main;
  }

  @Override
  public boolean onExecutePlayerCommand(Player player, Command cmd, String label, String[] args) {
    World world = player.getWorld();
    player.sendMessage("ようこそ冒険者ギルドへ");

    Location playerLocation = player.getLocation();
    double x = playerLocation.getX();
    double y = playerLocation.getY();
    double z = playerLocation.getZ();

    EntityType villager = EntityType.VILLAGER;

    // 1体目の村人をプレイヤーの近くに召喚
    Location villagerSpawnLocation1 = new Location(world, x + 2, y, z);
    Villager questAcceptor = (Villager) world.spawnEntity(villagerSpawnLocation1, villager);

    questAcceptor.setCustomName("クエスト受付");
    questAcceptor.setCustomNameVisible(true);
    questAcceptor.setAI(false);

    // 2体目の村人を少し離れた位置に召喚
    Location villagerSpawnLocation2 = new Location(world, x + 4, y, z);
    Villager questConfirmation = (Villager) world.spawnEntity(villagerSpawnLocation2, villager);

    questConfirmation.setCustomName("クエスト提出");
    questConfirmation.setCustomNameVisible(true);
    questConfirmation.setAI(false);

    // 3体目の村人をさらに離れた位置に召喚
    Location villagerSpawnLocation3 = new Location(world, x + 6, y, z);
    Villager trader = (Villager) world.spawnEntity(villagerSpawnLocation3, villager);

    trader.setCustomName("アイテム販売");
    trader.setCustomNameVisible(true);
    trader.setAI(false);

    return true;
  }

  @Override
  public boolean onExecuteNPCCommand(CommandSender sender, Command cmd, String label, String[] args) {
    return false;
  }

}


