package name.ashenphoenix.Item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;

import java.util.stream.Stream;

public class sunfeather extends Item {
    public sunfeather(Settings settings) {
        super(settings);
    }


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(context.getWorld().isClient()) {
            Stream<BlockPos> positions = BlockPos.stream(new Box(context.getBlockPos()).expand(5,0,5));
            positions.forEach(pos -> ((ServerWorld) context.getWorld())
                    .spawnParticles(ParticleTypes.FLAME, pos.getX() + 0.5d, pos.getY(), pos.getZ() + 0.5d, 2, 0, 0, 0, 0 ));
        }

        return super.useOnBlock(context);
    }
}
