package fidd;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@Mod(modid = fidd.MODID, version = fidd.VERSION, name = fidd.NAME)
public class fidd
{
    public static final String MODID = "fidd";
    public static final String VERSION = "1.0";
    public static final String NAME = "FIDD";
    @SidedProxy(clientSide="fidd.client",serverSide="fidd.server")
    public static proxy proxy;
    public static CreativeTabs tab = new CreativeTabs("tab"){
		@Override
		public Item getTabIconItem() {
			return midgiball;
		}
    };
    public static Item midgiball;
    public static Item emidgiball;
    @EventHandler
    public void pre(FMLPreInitializationEvent event)
    {
    	//EntityRegistry.registerModEntity(midgiman.class, "midgiman", 120, MODID, 50, 50, true, 0, -100);
    	//EntityRegistry.registerModEntity(entitymidgiball.class, "entitymidgiball", 120, MODID, 50, 20, true);
    	//EntityRegistry.registerModEntity(entitymidgiball2.class, "entitymidgiball2", 120, MODID, 50, 50, false);
        
    	//midgiball = new midgiball().setUnlocalizedName("midgiball").setRegistryName("midgiball");
    	//emidgiball = new emidgiball().setUnlocalizedName("emidgiball").setRegistryName("emidgiball");
    	//GameRegistry.register(midgiball);
    	//GameRegistry.register(emidgiball);
    	EntityRegistry.registerModEntity(Sink.class, "Sink", 121, MODID, 5, 1, false, 0, 100);
    }
    public static EntityPlayer player = Minecraft.getMinecraft().thePlayer;
    public static EventsClass events = new EventsClass();
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	MinecraftForge.EVENT_BUS.register(events);
    	RenderingRegistry.registerEntityRenderingHandler(Sink.class, new RenderLiving(Minecraft.getMinecraft().getRenderManager(), new ModelZombie(), 2.25F){

			@Override
			protected ResourceLocation getEntityTexture(Entity entity) {
				return new ResourceLocation("textures/entity/zombie/zombie.png");
			}
    	});
    	//ModelLoader.setCustomModelResourceLocation(midgiball, 0, new ModelResourceLocation("midgimon:midgiball", "inventory"));
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(midgiball, 0, new ModelResourceLocation(MODID + ":" + midgiball.getUnlocalizedName().substring(5), "inventory"));
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(emidgiball, 0, new ModelResourceLocation(MODID + ":" + emidgiball.getUnlocalizedName().substring(5), "inventory"));
    	//RenderingRegistry.registerEntityRenderingHandler(midgiman.class, new rendermidgiman(Minecraft.getMinecraft().getRenderManager(), new ModelZombie(), 5));
    	//RenderingRegistry.registerEntityRenderingHandler(entitymidgiball.class, new rendermidgiball(Minecraft.getMinecraft().getRenderManager()));
    	//RenderingRegistry.registerEntityRenderingHandler(entitymidgiball2.class, new rendermidgiball(Minecraft.getMinecraft().getRenderManager()));
    	System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
    }
}
