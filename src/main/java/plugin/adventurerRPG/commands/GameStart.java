package plugin.adventurerRPG.commands;

import java.util.ArrayList;
import java.util.List;
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
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import plugin.adventurerRPG.Main;
import plugin.adventurerRPG.quest.Quest;

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

    return true;
  }

  @Override
  public boolean onExecuteNPCCommand(CommandSender sender, Command cmd, String label, String[] args) {
    return false;
  }

  // クエスト受注NPCとのインタラクションを処理
  @EventHandler
  public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
    if (!(event.getRightClicked() instanceof Villager)) {
      return; // 対話したのが村人でなければ処理を終了
    }

    Villager villager = (Villager) event.getRightClicked();
    Player player = event.getPlayer();

    if (villager.getCustomName() != null && villager.getCustomName().equals("クエスト受付")) {
      // クエスト受注NPCとの対話の場合

      // プレイヤーのインベントリにGUIを表示
      openQuestListGUI(player);
    }
  }

  // クエストリストGUIを開く
  private void openQuestListGUI(Player player) {
    // インベントリGUIを作成
    Inventory gui = Bukkit.createInventory(null, 54, "クエスト一覧"); // サイズは54スロット

    // クエストデータのリストを取得 (仮のデータ)
    List<Quest> quests = getAvailableQuests(player);

    // クエストデータをもとに、GUIにアイテムを追加
    for (int i = 0; i < quests.size(); i++) {
      Quest quest = quests.get(i);
      ItemStack questItem = createQuestItem(quest);
      gui.setItem(i, questItem);
    }

    // プレイヤーにGUIを開示
    player.openInventory(gui);
  }

  // クエストアイテムを作成するメソッド
  private ItemStack createQuestItem(Quest quest) {
    ItemStack item = new ItemStack(Material.PAPER); // 例: 紙を使用
    ItemMeta meta = item.getItemMeta();

    // クエスト名などを設定
    meta.setDisplayName(quest.getName());
    List<String> lore = new ArrayList<>();
    lore.add("報酬: " + quest.getReward());
    // ... その他の情報を追加
    meta.setLore(lore);

    item.setItemMeta(meta);
    return item;
  }

  // プレイヤーが受注可能なクエストのリストを返す (仮のデータ)
  private List<Quest> getAvailableQuests(Player player) {
    List<Quest> quests = new ArrayList<>();
    quests.add(new Quest("スライム討伐", "スライムを10匹倒す", "ダイヤモンド5個"));
    quests.add(new Quest("木材集め", "オークの木材を64個集める", "鉄インゴット16個"));
    // ... データベースなどから適切なクエストデータを取得する処理を実装
    return quests;
  }

  /**
   * NPCの中身の設定
   *
   * @param world      プレイヤーのワールド
   * @param x          プレイヤーのx軸
   * @param y          プレイヤーのy軸
   * @param z          プレイヤーのz軸
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
}



