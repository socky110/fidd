package fidd.capabilities;

import fidd.characters.Gladiator;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.util.Constants;

public class GladiatorInfoStorage implements IStorage<IGladiatorInfo>

{

	 @Override
	
	 public NBTBase writeNBT(Capability<IGladiatorInfo> capability, IGladiatorInfo instance, EnumFacing side)
	
	 {
		 NBTTagCompound tag = new NBTTagCompound();
		 tag.setFloat("mana", instance.getMana());
		 tag.setInteger("maxMana", instance.getMax());
		 NBTTagList list = new NBTTagList();
		 for (int i = 0; i < instance.getGladiators().length; i++){
			 Gladiator gladiator = instance.getGladiators()[i];
			 NBTTagCompound glads = new NBTTagCompound();
			 gladiator.writeToNBT(glads);
			 list.set(i, glads);
		 }
		 tag.setTag("gladiators", list);
		 tag.setInteger("current", instance.getCurrent());
		 return tag;
	
	 }
	
	
	
	 @Override
	
	 public void readNBT(Capability<IGladiatorInfo> capability, IGladiatorInfo instance, EnumFacing side, NBTBase nbt)
	
	 {
		 NBTTagCompound tag = (NBTTagCompound) nbt;
		 instance.setMax(tag.getInteger("maxMana"));
		 instance.set(tag.getFloat("mana"));
		 NBTTagList glads = tag.getTagList("gladiators", Constants.NBT.TAG_COMPOUND);
		 for (int i = 0; i < glads.tagCount(); i++){
			 NBTTagCompound glad = glads.getCompoundTagAt(i);
			 instance.getGladiators()[i].readFromNBT(glad);
		 }
		 instance.setCurrentGladiator((tag.getInteger("current")));
		 
	 }

}
