package plugin.adventurerRPG.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import plugin.adventurerRPG.Main;

public class GameStart extends BaseCommand implements Listener {

  private final Main main;

  public GameStart(Main main) {
    this.main = main;
  }

  @Override
  public boolean onExecutePlayerCommand(Player player, Command cmd, String label, String[] args) {
    player.sendMessage("ようこそ冒険者ギルドへ");

    World world = player.getWorld();

    Location playerLocation = player.getLocation();
    double x = playerLocation.getX();
    double y = playerLocation.getY();
    double z = playerLocation.getZ();

    // メソッドを呼び出して村人を召喚
    Villager questAcceptor = spawnVillager(world, x + 2, y, z, "クエスト受付");
    Villager questConfirmation = spawnVillager(world, x + 4, y, z, "クエスト提出");
    Villager trader = spawnVillager(world, x + 6, y, z, "アイテム販売");

    // プレイヤーがNPCを右クリックしたときに開くGUI
    openQuestSelectionGUI(player);

    return true;
  }

  @Override
  public boolean onExecuteNPCCommand(CommandSender sender, Command cmd, String label, String[] args) {
    return false;
  }

  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {
    if (event.getView().getTitle().equals("クエストを選択")) {
      event.setCancelled(true); // イベントのキャンセル

      Player player = (Player) event.getWhoClicked();
      ItemStack clickedItem = event.getCurrentItem();

      if (clickedItem != null && clickedItem.hasItemMeta()) {
        String questName = clickedItem.getItemMeta().getDisplayName();
        player.sendMessage(questName + " が選択されました！");

        // 選択されたクエストに応じた処理を追加
        // 例: クエスト受注処理、アイテムの付与、進行状況の更新など
      }

      player.closeInventory(); // インベントリを閉じる
    }
  }

  /**
   * NPCの中身の設定
   * @param world プレイヤーのワールド
   * @param x プレイヤーのx軸
   * @param y プレイヤーのy軸
   * @param z プレイヤーのz軸
   * @param customName 村人の名前
   * @return 生成された村人
   */
  private Villager spawnVillager(World world, double x, double y, double z, String customName) {
    Location spawnLocation = new Location(world, x, y, z);
    Villager villager = (Villager) world.spawnEntity(spawnLocation, EntityType.VILLAGER);

    villager.setCustomName(customName);
    villager.setCustomNameVisible(true);
    villager.setAI(false);

    return villager;
  }

  /**
   * クエスト選択用のGUIを開く
   * @param player プレイヤー
   */
  private void openQuestSelectionGUI(Player player) {
    int inventorySize = 9; // 希望するインベントリのサイズを設定
    Inventory questInventory = Bukkit.createInventory(null, inventorySize, "クエストを選択");

    ItemStack[] quests = { // クエストアイテムの配列
        createQuestItem("クエスト 1", Material.PAPER),
        createQuestItem("クエスト 2", Material.PAPER),
        createQuestItem("クエスト 3", Material.PAPER),
        createQuestItem("クエスト 4", Material.PAPER),
        createQuestItem("クエスト 5", Material.PAPER),
        createQuestItem("クエスト 6", Material.PAPER),
        createQuestItem("クエスト 7", Material.PAPER),
        createQuestItem("クエスト 8", Material.PAPER),
        createQuestItem("クエスト 9", Material.PAPER)
    };

    // インベントリにアイテムを配置
    for (int i = 0; i < quests.length && i < inventorySize; i++) {
      questInventory.setItem(i, quests[i]);
    }

    player.openInventory(questInventory);
  }

  /**
   * クエストアイテムを作成するヘルパーメソッド
   * @param questName クエストの名前
   * @param material アイテムの素材
   * @return クエストアイテム
   */
  private ItemStack createQuestItem(String questName, Material material) {
    ItemStack item = new ItemStack(material);
    ItemMeta meta = item.getItemMeta();
    if (meta != null) {
      meta.setDisplayName(questName);
      item.setItemMeta(meta);
    }
    return item;
  }

}



