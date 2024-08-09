//package plugin.adventurerRPG.npc;
//
//import org.bukkit.Location;
//import org.bukkit.entity.EntityType;
//import org.bukkit.entity.Villager;
//import org.bukkit.plugin.java.JavaPlugin;
//
//public class QuestNpc {
//
//  private JavaPlugin plugin;
//
//  public QuestNpc(JavaPlugin plugin) {
//    this.plugin = plugin;
//  }
//
//  public Villager spawnVillager(Location location, String name, Villager.Profession profession) {
//    Villager villager = (Villager) location.getWorld().spawnEntity(location, EntityType.VILLAGER);
//    villager.setCustomName(name);
//    villager.setProfession(profession);
//    villager.setCustomNameVisible(true);
//    villager.setAI(false); // NPCとしての動作を制限
//    return villager;
//  }
//}

