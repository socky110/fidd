package fidd;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventsClass {
	public World w = Minecraft.getMinecraft().theWorld;
	public void entityPlayer(EntityEvent e){
		if(e.getEntity() instanceof EntityPlayer){
			if(((EntityPlayer)e.getEntity()).getDistanceToEntity(new EntitySheep(w)) <= 10){
				//if(((EntityPlayer)e.getEntity()).getHealth() <= 8){
				//((EntityPlayer)e.getEntity()).heal(10F);
				//}
			if(((EntityPlayer) e.getEntity()).getHealth() <= 10F){
				if (!this.w.isRemote)
                {
				((EntityPlayer) e.getEntity()).addPotionEffect(new PotionEffect(MobEffects.REGENERATION));
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
}