//package plugin.adventurerRPG.npc;
//
//import org.bukkit.Bukkit;
//import org.bukkit.Location;
//import org.bukkit.entity.Player;
//import org.bukkit.entity.Villager;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.inventory.InventoryClickEvent;
//import org.bukkit.inventory.Inventory;
//import org.bukkit.inventory.ItemStack;
//import org.bukkit.plugin.java.JavaPlugin;
//
//public class NpcManager {
//
//  private final JavaPlugin plugin;
//  private final QuestNpc questNpc;
//
//  public NpcManager(JavaPlugin plugin) {
//    this.plugin = plugin;
//    this.questNpc = new QuestNpc(plugin);
//  }
//
//  public void spawnQuestGiver(Location location) {
//    if (location != null) {
//      questNpc.spawnVillager(location, "Quest Giver", Villager.Profession.LIBRARIAN);
//    } else {
//      plugin.getLogger().warning("Invalid location for spawning Quest Giver NPC.");
//    }
//  }
//
//  public void spawnQuestReceiver(Location location) {
//    if (location != null) {
//      questNpc.spawnVillager(location, "Quest Receiver", Villager.Profession.CLERIC);
//    } else {
//      plugin.getLogger().warning("Invalid location for spawning Quest Receiver NPC.");
//    }
//  }
//
//  public void spawnItemTrader(Location location) {
//    if (location != null) {
//      questNpc.spawnVillager(location, "Item Trader", Villager.Profession.ARMORER);
//    } else {
//      plugin.getLogger().warning("Invalid location for spawning Item Trader NPC.");
//    }
//  }
//
//    public void openQuestSelectionGui(Player player) {
//      Inventory questGui = Bukkit.createInventory(null, 27, "Select a Quest");
//
//      // クエストリストをGUIに表示するためのアイテムをセット
//      ItemStack[] questItems = createQuestItems();
//      questGui.setContents(questItems);
//
//      player.openInventory(questGui);
//    }
//
//    private ItemStack[] createQuestItems() {
//      // クエスト選択用のアイテムを作成
//      // 例: 特定のクエストに対応するアイテムを作成
//      return new ItemStack[5]; // クエストが5つの場合
//    }
//
//    public void handleInventoryClick(InventoryClickEvent event) {
//      // プレイヤーがクエストを選択した際の処理を実装
//    }
//
//  public InventoryHandler(JavaPlugin plugin) {
//    this.questGui = new QuestGui(plugin);
//    plugin.getServer().getPluginManager().registerEvents(this, plugin);
//  }
//
//  @EventHandler
//  public void onInventoryClick(InventoryClickEvent event) {
//    if (event.getView().getTitle().equals("Select a Quest")) {
//      questGui.handleInventoryClick(event);
//      event.setCancelled(true); // プレイヤーがアイテムを持ち出さないようにする
//    }
//  }
//}
//


