package com.Vanilla.VanillaPlus.objects.items;

import com.Vanilla.VanillaPlus.util.helpers.KeyboardHelper;
import com.sun.org.apache.xpath.internal.operations.String;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class SpecialItem extends Item {
    public SpecialItem(Properties properties){
        super(properties);
    }
    @Override
    public boolean hasEffect(ItemStack stack){
        return true;
    }
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (KeyboardHelper.isHoldingShift()){
            tooltip.add(new StringTextComponent("Test Information"));
        } else {
            tooltip.add(new StringTextComponent("Hold SHIFT for more information!"));
        }
        super.addInformation(stack,worldIn,tooltip,flagIn);
    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn){
        playerIn.addPotionEffect(new EffectInstance(Effects.NAUSEA, 40, 3));
        worldIn.setRainStrength(1.0f);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
