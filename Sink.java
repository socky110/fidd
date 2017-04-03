package fidd;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Sink extends EntityCreature{
	public World w = Minecraft.getMinecraft().theWorld;
	public EntityPlayer p = Minecraft.getMinecraft().thePlayer;
	public Sink(World worldIn) {
		super(worldIn);
		//if(p.getDistance(this.lastTickPosX, this.lastTickPosY, this.lastTickPosZ) <= 10){// || this.getDistanceToEntity(p) > 2){
		final int RANGE = 5;
		if(p.getPosition().distanceSq(this.getPosition()) <= 36)
		{
			p.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 2));
		}
		else if(p.getPosition().distanceSq(this.getPosition()) <= RANGE * RANGE)
		{
			p.addPotionEffect(new PotionEffect(MobEffects.SPEED, 2));
		}
		//if(Math.abs(p.posX - this.posX) > 0){
			//new BlockPos().getX()
		//}else if(this.getDistanceToEntity(p2) <= 10){
		//	p2.addPotionEffect(new PotionEffect(MobEffects.REGENERATION));
		//	p2.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS));
		else{
			p.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 2));
		}
		//link to tileentity
		//Entity entity = this.getLeashedToEntity();//tileentity
        //this.setHomePosAndDistance(new BlockPos((int)entity.posX, (int)entity.posY, (int)entity.posZ), 5);
        
	}
	protected void initEntityAI()
    {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityZombie.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, true));
    }
}
