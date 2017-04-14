package fidd;

import fidd.capabilities.GladiatorInfoProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.world.World;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class EventsClass {
	public void onPlayerTick(TickEvent.PlayerTickEvent e){
		e.player.getCapability(GladiatorInfoProvider.MANA_CAP, null).fill(1);
		if(e.player instanceof EntityPlayer){
			if(e.player.getDistanceToEntity(new EntitySheep(e.player.worldObj)) <= 10){
				//if(((EntityPlayer)e.getEntity()).getHealth() <= 8){
				//((EntityPlayer)e.getEntity()).heal(10F);
				//}
				if(e.player.getHealth() <= 10F){
					if (!e.player.worldObj.isRemote)
	                {
						e.player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION));
	                }
						//((EntityPlayer)e.getEntity()).attackEntityFrom(DamageSource.causePlayerDamage(player), -2);
				}
			}	
		}
	}
	//@SubscribeEvent
	public void entityVillager(EntityEvent.EntityConstructing e){
		if(e.getEntity() instanceof EntityVillager){
			((EntityVillager)e.getEntity()).setEntityInvulnerable(true);
			((EntityVillager)e.getEntity()).useRecipe(new MerchantRecipe(new ItemStack(Items.CAKE), new ItemStack(Items.BEEF)));
		
		}
	}
	public static final ResourceLocation MANA_CAP = new ResourceLocation(Fidd.MODID, "mana");
	@SubscribeEvent

	public void attachCapability(AttachCapabilitiesEvent.Entity event)

	{

		if (!(event.getObject() instanceof EntityPlayer)) return;
		event.addCapability(MANA_CAP, new GladiatorInfoProvider());

	}
}