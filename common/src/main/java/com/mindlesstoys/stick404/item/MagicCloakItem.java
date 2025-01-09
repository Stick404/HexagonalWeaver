package com.mindlesstoys.stick404.item;

import at.petrak.hexcasting.api.casting.iota.Iota;
import at.petrak.hexcasting.api.casting.iota.IotaType;
import at.petrak.hexcasting.api.casting.iota.ListIota;
import at.petrak.hexcasting.api.casting.iota.NullIota;
import at.petrak.hexcasting.api.item.HexHolderItem;
import at.petrak.hexcasting.api.item.IotaHolderItem;
import at.petrak.hexcasting.api.pigment.FrozenPigment;
import at.petrak.hexcasting.api.utils.NBTHelper;
import com.google.common.collect.Lists;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MagicCloakItem extends ArmorItem implements HexHolderItem, IotaHolderItem {
    String IOTA_TAG = "hexagonal_weaver:iota";

    public MagicCloakItem(ArmorMaterial armorMaterial, Type type, Properties properties) {
        super(armorMaterial, type, properties);
    }

    @Override
    public boolean canDrawMediaFromInventory(ItemStack itemStack) {
        return true;
    }

    @Override
    public boolean hasHex(ItemStack itemStack) {
        return itemStack.getTagElement(IOTA_TAG) != null;
    }

    @Override
    public List<Iota> getHex(ItemStack itemStack, ServerLevel serverLevel) {
        Iota iota = readIota(itemStack, serverLevel);
        if (iota == null) return null;
        if (iota instanceof ListIota listIota) return Lists.newArrayList(listIota);
        return List.of(iota);
    }

    @Override
    public void writeHex(ItemStack itemStack, List<Iota> list, @Nullable FrozenPigment frozenPigment, long l) {
        writeDatum(itemStack, new ListIota(list));
    }

    @Override
    public void clearHex(ItemStack itemStack) {
        writeDatum(itemStack,null);
    }

    @Override
    public @Nullable FrozenPigment getPigment(ItemStack itemStack) {
        return null;
    }

    @Override
    public @Nullable CompoundTag readIotaTag(ItemStack itemStack) {
        return itemStack.getTagElement(IOTA_TAG);
    }

    @Override
    public @Nullable Iota emptyIota(ItemStack stack) {
        return new NullIota();
    }

    @Override
    public boolean writeable(ItemStack itemStack) {
        return true;
    }

    @Override
    public boolean canWrite(ItemStack itemStack, @Nullable Iota iota) {
        return true;
    }

    @Override
    public void writeDatum(ItemStack itemStack, @Nullable Iota iota) {
        NBTHelper.putCompound(itemStack,IOTA_TAG, IotaType.serialize(iota));
    }

    @Override
    public long getMedia(ItemStack itemStack) {
        return 0;
    }

    @Override
    public long getMaxMedia(ItemStack itemStack) {
        return 0;
    }

    @Override
    public void setMedia(ItemStack itemStack, long l) {

    }

    @Override
    public boolean canProvideMedia(ItemStack itemStack) {
        return false;
    }

    @Override
    public boolean canRecharge(ItemStack itemStack) {
        return false;
    }

    @Override
    public float getMediaFullness(ItemStack stack) {
        return HexHolderItem.super.getMediaFullness(stack);
    }

    @Override
    public long withdrawMedia(ItemStack stack, long cost, boolean simulate) {
        return HexHolderItem.super.withdrawMedia(stack, cost, simulate);
    }

    @Override
    public long insertMedia(ItemStack stack, long amount, boolean simulate) {
        return HexHolderItem.super.insertMedia(stack, amount, simulate);
    }

    @Override
    public int getConsumptionPriority(ItemStack stack) {
        return HexHolderItem.super.getConsumptionPriority(stack);
    }
    //stupid fucking armor class...

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        IotaHolderItem.appendHoverText(this, itemStack, list, tooltipFlag);
    }
}
