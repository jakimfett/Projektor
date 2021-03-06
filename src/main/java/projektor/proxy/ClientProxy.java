package projektor.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import projektor.projector.ProjectorItemRenderer;
import projektor.projector.ProjectorTileEntity;
import projektor.projector.ProjectorTileEntityRenderer;
import projektor.registry.BlockRegistry;

public class ClientProxy extends CommonProxy
{
    @Override
    public void initRenderers()
    {
        CommonProxy.RENDER_ID = RenderingRegistry.getNextAvailableRenderId();
        ProjectorTileEntityRenderer render = new ProjectorTileEntityRenderer();
        ClientRegistry.bindTileEntitySpecialRenderer(ProjectorTileEntity.class, render);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRegistry.projector), new ProjectorItemRenderer(render, new ProjectorTileEntity()));
    }

}
