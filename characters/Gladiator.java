package fidd.characters;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;

public class Gladiator {
	int maxMana;
	float manaRegen;
	int level = 0;
	final float increasePerLevel;
	final String name;
	final String textureName;
	
	public Gladiator(String name, String textureName, int maxMana, float manaRegen, float increasePerLevel){
		this.name = name;
		this.textureName = textureName;
		this.increasePerLevel = increasePerLevel;
		this.maxMana = maxMana;
		this.manaRegen = manaRegen;
	}
	
	public void readFromNBT(NBTTagCompound nbt){
		maxMana = nbt.getInteger("maxMana");
		manaRegen = nbt.getFloat("manaRegen");
		level = nbt.getInteger("level");
	}
	public void writeToNBT(NBTTagCompound nbt){
		nbt.setInteger("maxMana", maxMana);
		nbt.setFloat("manaRegen", manaRegen);
		nbt.setInteger("level", level);
	}
}
