package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.util.List;

public class CraftingInventoryFurnaceCB extends CraftingInventoryCB
{

    public CraftingInventoryFurnaceCB(IInventory iinventory, TileEntityFurnace tileentityfurnace)
    {
        field_20126_b = 0;
        field_20129_c = 0;
        field_20128_h = 0;
        field_20127_a = tileentityfurnace;
        addSlot(new Slot(tileentityfurnace, 0, 56, 17));
        addSlot(new Slot(tileentityfurnace, 1, 56, 53));
        addSlot(new SlotFurnace(tileentityfurnace, 2, 116, 35));
        addSlot(new SlotFurnace(tileentityfurnace, 3, 145, 35));
        for(int i = 0; i < 3; i++)
        {
            for(int k = 0; k < 9; k++)
            {
                addSlot(new Slot(iinventory, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
            }

        }

        for(int j = 0; j < 9; j++)
        {
            addSlot(new Slot(iinventory, j, 8 + j * 18, 142));
        }

    }

    public void updateCraftingResults()
    {
        super.updateCraftingResults();
        for(int i = 0; i < field_20121_g.size(); i++)
        {
            ICrafting icrafting = (ICrafting)field_20121_g.get(i);
            if(field_20126_b != field_20127_a.furnaceCookTime)
            {
                icrafting.func_20158_a(this, 0, field_20127_a.furnaceCookTime);
            }
            if(field_20129_c != field_20127_a.furnaceBurnTime)
            {
                icrafting.func_20158_a(this, 1, field_20127_a.furnaceBurnTime);
            }
            if(field_20128_h != field_20127_a.currentItemBurnTime)
            {
                icrafting.func_20158_a(this, 2, field_20127_a.currentItemBurnTime);
            }
        }

        field_20126_b = field_20127_a.furnaceCookTime;
        field_20129_c = field_20127_a.furnaceBurnTime;
        field_20128_h = field_20127_a.currentItemBurnTime;
    }

    public void func_20112_a(int i, int j)
    {
        if(i == 0)
        {
            field_20127_a.furnaceCookTime = j;
        }
        if(i == 1)
        {
            field_20127_a.furnaceBurnTime = j;
        }
        if(i == 2)
        {
            field_20127_a.currentItemBurnTime = j;
        }
    }

    public boolean isUsableByPlayer(EntityPlayer entityplayer)
    {
        return field_20127_a.canInteractWith(entityplayer);
    }

    private TileEntityFurnace field_20127_a;
    private int field_20126_b;
    private int field_20129_c;
    private int field_20128_h;
}
