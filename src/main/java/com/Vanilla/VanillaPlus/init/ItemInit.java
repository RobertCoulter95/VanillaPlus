package com.Vanilla.VanillaPlus.init;

import com.Vanilla.VanillaPlus.VanillaPlus;
import com.Vanilla.VanillaPlus.objects.items.SpecialItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = VanillaPlus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(VanillaPlus.MOD_ID)
public class ItemInit {
    @ObjectHolder(VanillaPlus.MOD_ID + "example_item")

    //Tools
    public static final Item example_item = null;
    public static final Item special_item = null;
    public static final Item example_spear = null;
    public static final Item example_pickaxe = null;
    public static final Item example_shovel = null;
    public static final Item example_axe = null;
    public static final Item example_hoe = null;

    //Armour
    public static final Item test_helmet = null;
    public static final Item test_chestplate = null;
    public static final Item test_leggings = null;
    public static final Item test_boots = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event){
        event.getRegistry().register(new Item(new Item.Properties().group(VanillaPlus.VanillaPlusItemGroup.instance).food(new Food.Builder().hunger(20).saturation(20.0f).meat().fastToEat().setAlwaysEdible()
                .effect(new EffectInstance(Effects.ABSORPTION, 60000,5), 1.0f).build())).setRegistryName("example_item"));
        event.getRegistry().register(new SpecialItem(new Item.Properties().group(VanillaPlus.VanillaPlusItemGroup.instance)).setRegistryName("special_item"));

        //tools
        event.getRegistry().register(new SwordItem(ModItemTier.EXAMPLE, 9, 5.0f, new Item.Properties().group(VanillaPlus.VanillaPlusItemGroup.instance)).setRegistryName("example_spear"));
        event.getRegistry().register(new PickaxeItem(ModItemTier.EXAMPLE,4, 5.0f, new Item.Properties().group(VanillaPlus.VanillaPlusItemGroup.instance)).setRegistryName("example_pickaxe"));
        event.getRegistry().register(new ShovelItem(ModItemTier.EXAMPLE,4, 5.0f, new Item.Properties().group(VanillaPlus.VanillaPlusItemGroup.instance)).setRegistryName("example_shovel"));
        event.getRegistry().register(new AxeItem(ModItemTier.EXAMPLE,4, 5.0f, new Item.Properties().group(VanillaPlus.VanillaPlusItemGroup.instance)).setRegistryName("example_axe"));
        event.getRegistry().register(new HoeItem(ModItemTier.EXAMPLE, 5.0f, new Item.Properties().group(VanillaPlus.VanillaPlusItemGroup.instance)).setRegistryName("example_hoe"));

        //Armor
        event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.HEAD, new Item.Properties().group(VanillaPlus.VanillaPlusItemGroup.instance)).setRegistryName("test_helmet"));
        event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.CHEST, new Item.Properties().group(VanillaPlus.VanillaPlusItemGroup.instance)).setRegistryName("test_chest"));
        event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.LEGS, new Item.Properties().group(VanillaPlus.VanillaPlusItemGroup.instance)).setRegistryName("test_legs"));
        event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.FEET, new Item.Properties().group(VanillaPlus.VanillaPlusItemGroup.instance)).setRegistryName("test_feet"));
    }

    public enum ModItemTier implements IItemTier {
        EXAMPLE(4, 1250, 15.0f, 10.0f, 200, () -> {
           return Ingredient.fromItems(ItemInit.example_item);
        });
        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final LazyValue<Ingredient> repairMaterial;
        private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairMaterial = new LazyValue<>(repairMaterial);
        }

        @Override
        public int getMaxUses() {
            return this.maxUses;
        }

        @Override
        public float getEfficiency() {
            return this.efficiency;
        }

        @Override
        public float getAttackDamage() {
            return this.attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return this.harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }
    }
    public enum ModArmorMaterial implements IArmorMaterial {
        TEST(VanillaPlus.MOD_ID + ":test", 5, new int[]{7, 9, 11, 7}, 420, SoundEvents.field_226124_Y_, 6.9f, () -> {
            return Ingredient.fromItems(ItemInit.example_item);
        });


        private static final int[] MAX_DAMAGE_ARRAY = new int[]{16, 16, 16, 16};
        private final String name;
        private final int maxDamageFactor;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final float toughness;
        private final LazyValue<Ingredient> repairMaterial;

        private ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn, int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn) {
            this.name = nameIn;
            this.maxDamageFactor = maxDamageFactorIn;
            this.damageReductionAmountArray = damageReductionAmountIn;
            this.enchantability = enchantabilityIn;
            this.soundEvent = soundEventIn;
            this.toughness = toughnessIn;
            this.repairMaterial = new LazyValue<>(repairMaterialIn);
        }

        @Override
        public int getDurability(EquipmentSlotType slotIn) {
            return MAX_DAMAGE_ARRAY[slotIn.getIndex()] *this.maxDamageFactor;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn) {
            return this.damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public SoundEvent getSoundEvent() {
            return this.soundEvent;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }

        @OnlyIn(Dist.CLIENT)
        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public float getToughness() {
            return this.toughness;
        }
    }
}
