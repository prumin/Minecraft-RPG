package plugin.adventurerRPG;

import java.util.Objects;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.adventurerRPG.commands.GameStart;
import plugin.adventurerRPG.commands.LetsGoAdventure;
import plugin.adventurerRPG.commands.QuestStatus;
import plugin.adventurerRPG.commands.VisitNpc;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        GameStart gameStart = new GameStart(this);
        Bukkit.getPluginManager().registerEvents(gameStart, this);
        Objects.requireNonNull(getCommand("gameStart")).setExecutor(gameStart);
        Objects.requireNonNull(getCommand("questStatus")).setExecutor(new QuestStatus());
        Objects.requireNonNull(getCommand("visitNpc")).setExecutor(new VisitNpc());
        Objects.requireNonNull(getCommand("let'sGoAdventure")).setExecutor(new LetsGoAdventure());
    }

}


