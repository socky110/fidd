package fidd.network;

import fidd.capabilities.GladiatorInfoProvider;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ManaMessage implements IMessage {
    
    private float mana;
    private int max;

    public ManaMessage(){}
    public ManaMessage(float mana, int max) {
        this.mana = mana;
        this.max = max;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
    	//team = ByteBufUtils.readVarInt(buf, 5) == 0 ? false : true;
        mana = ByteBufUtils.readVarInt(buf, 4096); // this class is very useful in general for writing more complex objects
        max = ByteBufUtils.readVarInt(buf, 4096);
    }

    @Override
    public void toBytes(ByteBuf buf) {
    	//ByteBufUtils.writeVarInt(buf, team ? 1 : 0, 5);
        ByteBufUtils.writeVarInt(buf, (int) mana, 4096);
        ByteBufUtils.writeVarInt(buf, (int) max, 4096);
    }

    public static class Handler implements IMessageHandler<ManaMessage, IMessage> {
        
        // or in 1.8:
        @Override
        public IMessage onMessage(final ManaMessage message, final MessageContext ctx) {
        	IThreadListener mainThread = Minecraft.getMinecraft();
            //IThreadListener mainThread = (WorldServer) ctx.getServerHandler().playerEntity.worldObj; // or Minecraft.getMinecraft() on the client
            mainThread.addScheduledTask(new Runnable() {
                @Override
                public void run() {
                	Minecraft.getMinecraft().thePlayer.getCapability(GladiatorInfoProvider.MANA_CAP, null).set(message.mana);
                	Minecraft.getMinecraft().thePlayer.getCapability(GladiatorInfoProvider.MANA_CAP, null).setMax(message.max);
                    //System.out.println(String.format("Received %s from %s", message.text, ctx.getServerHandler().playerEntity.getDisplayName()));
                }
            });
            return null; // no response in this case
        }
    }
}
