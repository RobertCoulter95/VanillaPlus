package com.Vanilla.VanillaPlus.events;

import com.Vanilla.VanillaPlus.VanillaPlus;
import com.Vanilla.VanillaPlus.init.BlockInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = VanillaPlus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TestJumpEvent {

    @SubscribeEvent
    public static void testJumpEvent(LivingEvent.LivingJumpEvent event) {
        VanillaPlus.LOGGER.info("AHHHHH jump");
        LivingEntity livingEntity = event.getEntityLiving();
        World world = livingEntity.getEntityWorld();
        //world.setBlockState(livingEntity.getPosition().add(0, 5, 0), BlockInit.example_block.getDefaultState());
        livingEntity.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST,600,10));
        livingEntity.addPotionEffect(new EffectInstance(Effects.ABSORPTION,300,10));
        livingEntity.setGlowing(true);
    }
}
