package com.ferriolli.xtragems.util.handlers;

import com.ferriolli.xtragems.blocks.gemrefiner.ContainerGemRefiner;
import com.ferriolli.xtragems.blocks.gemrefiner.GuiGemRefiner;
import com.ferriolli.xtragems.blocks.gemrefiner.TileEntityGemRefiner;
import com.ferriolli.xtragems.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler {
    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == Reference.GUI_GEM_REFINER) return new ContainerGemRefiner(player.inventory, (TileEntityGemRefiner) world.getTileEntity(new BlockPos(x, y, z)));
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == Reference.GUI_GEM_REFINER) return new GuiGemRefiner(player.inventory, (TileEntityGemRefiner) world.getTileEntity(new BlockPos(x, y, z)));
        return null;
    }
}
