package name.ashenphoenix.Item.custom;

import net.fabricmc.fabric.api.item.v1.CustomDamageHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;
import java.util.stream.Stream;

public class sunfeather extends Item {
    public sunfeather(Settings settings) {
        super(settings);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {
            Stream<BlockPos> positions = BlockPos.stream(new Box(user.getBlockPos()).expand(2.5, 0, 2.5));
            positions.forEach(pos -> {
                ((ServerWorld) world).spawnParticles(ParticleTypes.SMALL_FLAME, pos.getX() + 0.5d, pos.getY(), pos.getZ() + 0.5d, 2, 0, 0, 0, 0);

                world.getEntitiesByClass(Entity.class, new Box(pos), entity -> true)
                        .forEach(entity -> {
                            if (entity instanceof LivingEntity) {
                                ((LivingEntity) entity).damage(world.getDamageSources().magic(), 6.0f);
                                entity.setFireTicks(300);
                            }
                        });
            });
        }

        return super.use(world, user, hand);
    }

}