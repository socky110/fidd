package fidd.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class ManaStorage implements IStorage<IMana>

{

	 @Override
	
	 public NBTBase writeNBT(Capability<IMana> capability, IMana instance, EnumFacing side)
	
	 {
		 NBTTagCompound tag = new NBTTagCompound();
		 tag.setFloat("mana", instance.getMana());
		 tag.setInteger("maxMana", instance.getMax());
		 return tag;
	
	 }
	
	
	
	 @Override
	
	 public void readNBT(Capability<IMana> capability, IMana instance, EnumFacing side, NBTBase nbt)
	
	 {
		 NBTTagCompound tag = (NBTTagCompound) nbt;
		 instance.setMax(tag.getInteger("maxMana"));
		 instance.set(tag.getFloat("mana"));
	 }

}
