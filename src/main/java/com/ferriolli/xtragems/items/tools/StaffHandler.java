package com.ferriolli.xtragems.items.tools;

import com.ferriolli.xtragems.Init.ModItems;
import com.ferriolli.xtragems.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class StaffHandler {
    //VERIFICAR SE (!world.isRemote())
    /*@SubscribeEvent
    public void staffHeal(PlayerInteractEvent.EntityInteract event){
        Minecraft.getMinecraft().player.sendChatMessage("passou no evento do StaffHandler");
        if(event.getEntity() instanceof EntityLivingBase){
            Minecraft.getMinecraft().player.sendChatMessage("entidade é living base");
            EntityLivingBase entityUser = (EntityLivingBase) event.getEntity();
            if (entityUser.getHeldItemMainhand().getItem() == ModItems.HEALING_STAFF){
                Minecraft.getMinecraft().player.sendChatMessage("esta segurando staff");
                if (event.getTarget() instanceof EntityLivingBase){
                    Minecraft.getMinecraft().player.sendChatMessage("Alvo é living base");
                    EntityLivingBase entityTarget = (EntityLivingBase) event.getTarget();
                    entityTarget.heal(4);
                    entityUser.getHeldItemMainhand().damageItem(1, entityUser);
                    entityUser.getEntityWorld().playSound(null, entityUser.getPosition(), SoundEvents.ENTITY_ARROW_HIT, SoundCategory.HOSTILE, 1.0F, 2F);
                }
            }
        }
    }*/
}
