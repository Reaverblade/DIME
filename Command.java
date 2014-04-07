package dime;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

import java.util.List;

/**
 * Created by OkuBlade on 3/26/2014.
 */
public class Command implements ICommand{

    public String commandName, commandUsage;

    public ICommandLol command;

    public Command(String name, String usage, ICommandLol cmd){
        commandName = name;
        commandUsage = usage;
        command = cmd;
    }
    @Override
    public String getCommandName() {
        return commandName;
    }

    @Override
    public String getCommandUsage(ICommandSender var1) {
        return commandUsage;
    }

    @Override
    public List getCommandAliases() {
        return null;
    }

    @Override
    public void processCommand(ICommandSender var1, String[] var2) {
       command.onCommand(this, var1, var2 );
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender var1) {
        return true;
    }

    @Override
    public List addTabCompletionOptions(ICommandSender var1, String[] var2) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] var1, int var2) {
        return false;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
