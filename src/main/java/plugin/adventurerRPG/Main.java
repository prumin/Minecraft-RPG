package plugin.adventurerRPG;

import java.util.Objects;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.adventurerRPG.commands.AcceptQuestCommandHandler;
import plugin.adventurerRPG.commands.QuestStatusCommandHandler;
import plugin.adventurerRPG.commands.SubmitQuestCommandHandler;
import plugin.adventurerRPG.commands.SummonNpcCommandHandler;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("quest status")).setExecutor(new QuestStatusCommandHandler());
        Objects.requireNonNull(getCommand("accept quest")).setExecutor(new AcceptQuestCommandHandler());
        Objects.requireNonNull(getCommand("submit quest")).setExecutor(new SubmitQuestCommandHandler());
        Objects.requireNonNull(getCommand("summons")).setExecutor(new SummonNpcCommandHandler());
    }
}

