package fidd.abilities;

import fidd.capabilities.IMana;
import fidd.capabilities.ManaProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public abstract class ItemAbility extends Item{
	int mana_cost;
	int cooldown;
	public ItemAbility(int mana_cost, int cooldown){
		super();
		this.mana_cost = mana_cost;
		this.cooldown = cooldown;
	}
	public abstract void use(ItemStack stack, World world, EntityPlayer player);
	public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected){
		super.onUpdate(stack, world, entity, itemSlot, isSelected);
		NBTTagCompound tag = stack.getTagCompound();
		EntityPlayer player = (EntityPlayer) entity;
		if (isSelected){
			if (tag.getLong("nextUse") < world.getTotalWorldTime()){
				IMana mana = player.getCapability(ManaProvider.MANA_CAP, null);
				if (mana.consume(mana_cost)){
					use(stack, world, player);
					tag.setLong("nextUse", world.getTotalWorldTime() + cooldown);
				}
				else{
					player.addChatComponentMessage(new TextComponentString("Insufficient mana").setStyle(new Style().setColor(TextFormatting.RED)));
				}
			}
			else{
				player.addChatComponentMessage(new TextComponentString("Cooldown: " + (tag.getLong("nextUse") - world.getTotalWorldTime())).setStyle(new Style().setColor(TextFormatting.RED)));
			}
			player.inventory.currentItem = 0;
		}
		stack.setTagCompound(tag);
	}
}
