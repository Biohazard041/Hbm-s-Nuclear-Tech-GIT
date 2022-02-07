package com.hbm.inventory.recipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.hbm.blocks.ModBlocks;
import com.hbm.config.GeneralConfig;
import com.hbm.interfaces.Spaghetti;
import com.hbm.inventory.FluidContainer;
import com.hbm.inventory.FluidContainerRegistry;
import com.hbm.inventory.FluidStack;
import com.hbm.inventory.OreDictManager.DictFrame;
import com.hbm.inventory.fluid.FluidType;
import com.hbm.inventory.fluid.Fluids;
import com.hbm.items.ItemEnums.EnumTarType;
import com.hbm.items.ModItems;
import com.hbm.items.machine.ItemChemistryTemplate;
import com.hbm.items.machine.ItemFluidIcon;
import com.hbm.items.weapon.ItemGunBase;
import com.hbm.main.MainRegistry;
import com.hbm.util.EnchantmentUtil;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;

//TODO: clean this shit up
@Spaghetti("everything")
public class MachineRecipes {

	public MachineRecipes() {

	}

	public static MachineRecipes instance() {
		return new MachineRecipes();
	}

	public static ItemStack getFurnaceProcessingResult(ItemStack item, ItemStack item2) {
		return getFurnaceOutput(item, item2);
	}

	@Spaghetti("i am an affront to god and i desire to be cremated")
	public static ItemStack getFurnaceOutput(ItemStack item, ItemStack item2) {
		
		if(item == null || item2 == null)
			return null;
		
		if (GeneralConfig.enableDebugMode) {
			if (item.getItem() == Items.iron_ingot && item2.getItem() == Items.quartz
					|| item.getItem() == Items.quartz && item2.getItem() == Items.iron_ingot) {
				return new ItemStack(ModBlocks.test_render, 1);
			}
		}

		if (mODE(item, new String[] {"ingotTungsten", "dustTungsten"}) && mODE(item2, "gemCoal")
				|| mODE(item, "gemCoal") && mODE(item2, new String[] {"ingotTungsten", "dustTungsten"})) {
			return new ItemStack(ModItems.neutron_reflector, 2);
		}

		if (mODE(item, new String[] {"ingotIron", "dustIron"}) && mODE(item2, new String[] {"gemCoal", "dustCoal"})
				|| mODE(item, new String[] {"gemCoal", "dustCoal"}) && mODE(item2, new String[] {"ingotIron", "dustIron"})) {
			return new ItemStack(ModItems.ingot_steel, 2);
		}

		if (mODE(item, new String[] {"ingotCopper", "dustCopper"}) && item2.getItem() == Items.redstone
				|| item.getItem() == Items.redstone && mODE(item2, new String[] {"ingotCopper", "dustCopper"})) {
			return new ItemStack(ModItems.ingot_red_copper, 2);
		}

		if (item.getItem() == ModItems.canister_fuel && item2.getItem() == Items.slime_ball
				|| item.getItem() == Items.slime_ball && item2.getItem() == ModItems.canister_fuel) {
			return new ItemStack(ModItems.canister_napalm, 1);
		}

		if (mODE(item, new String[] {"ingotMingrade", "dustMingrade"}) && mODE(item2, new String[] {"ingotSteel", "dustSteel"})
				|| mODE(item, new String[] {"ingotSteel", "dustSteel"}) && mODE(item2, new String[] {"ingotMingrade", "dustMingrade"})) {
			return new ItemStack(ModItems.ingot_advanced_alloy, 2);
		}

		if (mODE(item, new String[] {"ingotTungsten", "dustTungsten"}) && mODE(item2, "nuggetSchrabidium")
				|| mODE(item, "nuggetSchrabidium") && mODE(item2, new String[] {"ingotTungsten", "dustTungsten"})) {
			return new ItemStack(ModItems.ingot_magnetized_tungsten, 1);
		}

		if (mODE(item, new String[] {"ingotSteel", "dustSteel"}) && mODE(item2, new String[] {"nuggetTechnetium99", "tinyTc99"})
				|| mODE(item, new String[] {"nuggetTechnetium99", "tinyTc99"}) && mODE(item2, new String[] {"ingotSteel", "dustSteel"})) {
			return new ItemStack(ModItems.ingot_tcalloy, 1);
		}

		if (item.getItem() == ModItems.plate_mixed && mODE(item2, "plateGold")
				|| mODE(item, "plateGold") && item2.getItem() == ModItems.plate_mixed) {
			return new ItemStack(ModItems.plate_paa, 2);
		}

		if (mODE(item, new String[] {"ingotSteel", "dustSteel"}) && mODE(item2, new String[] {"ingotTungsten", "dustTungsten"})
				|| mODE(item, new String[] {"ingotTungsten", "dustTungsten"}) && mODE(item2, new String[] {"ingotSteel", "dustSteel"})) {
			return new ItemStack(ModItems.ingot_dura_steel, 2);
		}

		if (mODE(item, new String[] {"ingotSteel", "dustSteel"}) && mODE(item2, new String[] {"ingotCobalt", "dustCobalt"})
				|| mODE(item, new String[] {"ingotCobalt", "dustCobalt"}) && mODE(item2, new String[] {"ingotSteel", "dustSteel"})) {
			return new ItemStack(ModItems.ingot_dura_steel, 2);
		}

		if (mODE(item, new String[] {"ingotSaturnite", "dustSaturnite"}) && item2.getItem() == ModItems.powder_meteorite
				|| item.getItem() == ModItems.powder_meteorite && mODE(item2, new String[] {"ingotSaturnite", "dustSaturnite"})) {
			return new ItemStack(ModItems.ingot_starmetal, 2);
		}

		if(GeneralConfig.enableBabyMode) {
			if(mODE(item, new String[] { "gemCoal", "dustCoal" }) && item2.getItem() == ModItems.canister_empty
					|| item.getItem() == ModItems.canister_empty && mODE(item2, new String[] { "gemCoal", "dustCoal" })) {
				return new ItemStack(ModItems.canister_oil );
			}
		}

		if (item.getItem() == Item.getItemFromBlock(ModBlocks.block_meteor) && mODE(item2, new String[] {"ingotCobalt", "dustCobalt"})
				|| mODE(item, new String[] {"ingotCobalt", "dustCobalt"}) && item2.getItem() == Item.getItemFromBlock(ModBlocks.block_meteor)) {
			return new ItemStack(ModItems.ingot_meteorite);
		}

		if (item.getItem() == ModItems.meteorite_sword_hardened && mODE(item2, new String[] {"ingotCobalt", "dustCobalt"})
				|| mODE(item, new String[] {"ingotCobalt", "dustCobalt"}) && item2.getItem() == ModItems.meteorite_sword_hardened) {
			return new ItemStack(ModItems.meteorite_sword_alloyed, 1);
		}
		
		if(item.getItem() instanceof ItemGunBase && item2.getItem() == Items.enchanted_book) {
			
			ItemStack result = item.copy();

            Map mapright = EnchantmentHelper.getEnchantments(item2);
            Iterator itr = mapright.keySet().iterator();

            while (itr.hasNext()) {
            	
            	int i = ((Integer)itr.next()).intValue();
            	int j = ((Integer)mapright.get(Integer.valueOf(i))).intValue();
            	Enchantment e = Enchantment.enchantmentsList[i];
            	
            	EnchantmentUtil.removeEnchantment(result, e);
            	EnchantmentUtil.addEnchantment(result, e, j);
            }
            
            return result;
		}

		return null;
	}
	
	//return: FluidType, amount produced, amount required, heat required (°C * 100)
	public static Object[] getBoilerOutput(FluidType type) {
		
		if(type == Fluids.WATER) return new Object[] { Fluids.STEAM, 500, 5, 10000 };
		if(type == Fluids.STEAM) return new Object[] { Fluids.HOTSTEAM, 5, 50, 30000 };
		if(type == Fluids.HOTSTEAM) return new Object[] { Fluids.SUPERHOTSTEAM, 5, 50, 45000 };
		if(type == Fluids.OIL) return new Object[] { Fluids.HOTOIL, 5, 5, 35000 };
		if(type == Fluids.CRACKOIL) return new Object[] { Fluids.HOTCRACKOIL, 5, 5, 35000 };
		
		return null;
	}
	
	//return: FluidType, amount produced, amount required, HE produced
	public static Object[] getTurbineOutput(FluidType type) {
		
		if(type == Fluids.STEAM) return new Object[] { Fluids.SPENTSTEAM, 5, 500, 50 };
		if(type == Fluids.HOTSTEAM) return new Object[] { Fluids.STEAM, 50, 5, 100 };
		if(type == Fluids.SUPERHOTSTEAM) return new Object[] { Fluids.HOTSTEAM, 50, 5, 150 };
		if(type == Fluids.ULTRAHOTSTEAM) return new Object[] { Fluids.SUPERHOTSTEAM, 50, 5, 250 };
		
		return null;
	}

	public static ItemStack getCyclotronOutput(ItemStack part, ItemStack item) {

		if(part == null || item == null)
			return null;
		
		//LITHIUM
		if (part.getItem() == ModItems.part_lithium) {
			if(item.getItem() == ModItems.niter)
				return new ItemStack(ModItems.fluorite, 1);
			if(item.getItem() == ModItems.powder_coal)
				return new ItemStack(ModItems.fluorite, 1);
			if(mODE(item, "dustIron"))
				return new ItemStack(ModItems.powder_cobalt, 1);
			if(mODE(item, "dustGold"))
				return new ItemStack(ModItems.powder_lead, 1);
			if(mODE(item, "dustNetherQuartz"))
				return new ItemStack(ModItems.sulfur, 1);
			if(mODE(item, "dustUranium"))
				return new ItemStack(ModItems.powder_plutonium, 1);
			if(mODE(item, "dustAluminum"))
				return new ItemStack(ModItems.powder_quartz, 1);
			if(mODE(item, "dustBeryllium"))
				return new ItemStack(ModItems.powder_coal, 1);
			if(item.getItem() == ModItems.powder_schrabidium)
				return new ItemStack(ModItems.powder_reiium, 1);
			if(item.getItem() == ModItems.powder_lithium)
				return new ItemStack(ModItems.powder_coal, 1);
			if(item.getItem() == ModItems.powder_iodine)
				return new ItemStack(ModItems.powder_caesium, 1);
			if(item.getItem() == ModItems.powder_thorium)
				return new ItemStack(ModItems.powder_uranium, 1);
			if(item.getItem() == ModItems.powder_caesium)
				return new ItemStack(ModItems.powder_lanthanium, 1);
			if(item.getItem() == ModItems.powder_reiium)
				return new ItemStack(ModItems.powder_weidanium, 1);
			if(mODE(item, "dustCobalt"))
				return new ItemStack(ModItems.powder_copper, 1);
			if(item.getItem() == ModItems.powder_cerium)
				return new ItemStack(ModItems.powder_neodymium, 1);
			if(item.getItem() == ModItems.powder_actinium)
				return new ItemStack(ModItems.powder_thorium, 1);
			if(item.getItem() == ModItems.powder_lanthanium)
				return new ItemStack(ModItems.powder_cerium, 1);
		}
		
		//BERYLLIUM
		if (part.getItem() == ModItems.part_beryllium) {
			if(mODE(item, "dustSulfur"))
				return new ItemStack(ModItems.powder_titanium, 1);
			if(item.getItem() == ModItems.fluorite)
				return new ItemStack(ModItems.powder_aluminium, 1);
			if(mODE(item, "dustIron"))
				return new ItemStack(ModItems.powder_copper, 1);
			if(mODE(item, "dustNetherQuartz"))
				return new ItemStack(ModItems.powder_titanium, 1);
			if(mODE(item, "dustTitanium"))
				return new ItemStack(ModItems.powder_iron, 1);
			if(mODE(item, "dustCopper"))
				return new ItemStack(ModItems.powder_bromine, 1);
			if(mODE(item, "dustTungsten"))
				return new ItemStack(ModItems.powder_gold, 1);
			if(mODE(item, "dustAluminum"))
				return new ItemStack(ModItems.sulfur, 1);
			if(mODE(item, "dustLead"))
				return new ItemStack(ModItems.powder_astatine, 1);
			if(mODE(item, "dustBeryllium"))
				return new ItemStack(ModItems.niter, 1);
			if(mODE(item, "dustLithium"))
				return new ItemStack(ModItems.niter, 1);
			if(item.getItem() == ModItems.powder_iodine)
				return new ItemStack(ModItems.powder_cerium, 1);
			if(item.getItem() == ModItems.powder_thorium)
				return new ItemStack(ModItems.powder_neptunium, 1);
			if(item.getItem() == ModItems.powder_astatine)
				return new ItemStack(ModItems.powder_actinium, 1);
			if(item.getItem() == ModItems.powder_caesium)
				return new ItemStack(ModItems.powder_neodymium, 1);
			if(item.getItem() == ModItems.powder_weidanium)
				return new ItemStack(ModItems.powder_australium, 1);
			if(item.getItem() == ModItems.powder_strontium)
				return new ItemStack(ModItems.powder_niobium, 1);
			if(item.getItem() == ModItems.powder_bromine)
				return new ItemStack(ModItems.powder_strontium, 1);
			if(item.getItem() == ModItems.powder_actinium)
				return new ItemStack(ModItems.powder_uranium, 1);
			if(item.getItem() == ModItems.powder_lanthanium)
				return new ItemStack(ModItems.powder_neodymium, 1);
		}
		
		//CARBON
		if (part.getItem() == ModItems.part_carbon) {
			if(mODE(item, "dustSulfur"))
				return new ItemStack(ModItems.powder_iron, 1);
			if(item.getItem() == ModItems.niter)
				return new ItemStack(ModItems.powder_aluminium, 1);
			if(item.getItem() == ModItems.fluorite)
				return new ItemStack(ModItems.sulfur, 1);
			if(mODE(item, "dustCoal"))
				return new ItemStack(ModItems.powder_aluminium, 1);
			if(mODE(item, "dustIron"))
				return new ItemStack(ModItems.powder_bromine, 1);
			if(mODE(item, "dustGold"))
				return new ItemStack(ModItems.powder_astatine, 1);
			if(mODE(item, "dustNetherQuartz"))
				return new ItemStack(ModItems.powder_iron, 1);
			if(item.getItem() == ModItems.powder_plutonium)
				return new ItemStack(ModItems.powder_tennessine, 1);
			if(item.getItem() == ModItems.powder_neptunium)
				return new ItemStack(ModItems.powder_tennessine, 1);
			if(mODE(item, "dustTitanium"))
				return new ItemStack(ModItems.powder_bromine, 1);
			if(mODE(item, "dustCopper"))
				return new ItemStack(ModItems.powder_strontium, 1);
			if(mODE(item, "dustTungsten"))
				return new ItemStack(ModItems.powder_lead, 1);
			if(mODE(item, "dustAluminum"))
				return new ItemStack(ModItems.powder_titanium, 1);
			if(mODE(item, "dustLead"))
				return new ItemStack(ModItems.powder_thorium, 1);
			if(mODE(item, "dustBeryllium"))
				return new ItemStack(ModItems.fluorite, 1);
			if(mODE(item, "dustLithium"))
				return new ItemStack(ModItems.fluorite, 1);
			if(item.getItem() == ModItems.powder_iodine)
				return new ItemStack(ModItems.powder_tungsten, 1);
			if(item.getItem() == ModItems.powder_neodymium)
				return new ItemStack(ModItems.powder_tungsten, 1);
			if(item.getItem() == ModItems.powder_australium)
				return new ItemStack(ModItems.powder_verticium, 1);
			if(item.getItem() == ModItems.powder_strontium)
				return new ItemStack(ModItems.powder_iodine, 1);
			if(mODE(item, "dustCobalt"))
				return new ItemStack(ModItems.powder_strontium, 1);
			if(item.getItem() == ModItems.powder_bromine)
				return new ItemStack(ModItems.powder_niobium, 1);
			if(item.getItem() == ModItems.powder_niobium)
				return new ItemStack(ModItems.powder_iodine, 1);
			if(item.getItem() == ModItems.powder_tennessine)
				return new ItemStack(ModItems.powder_schrabidium, 1);
			if(item.getItem() == ModItems.powder_cerium)
				return new ItemStack(ModItems.powder_tungsten, 1);
		}
		
		//COPPER
		if (part.getItem() == ModItems.part_copper) {
			if(mODE(item, "dustSulfur"))
				return new ItemStack(ModItems.powder_bromine, 1);
			if(item.getItem() == ModItems.niter)
				return new ItemStack(ModItems.powder_cobalt, 1);
			if(item.getItem() == ModItems.fluorite)
				return new ItemStack(ModItems.powder_iron, 1);
			if(mODE(item, "dustCoal"))
				return new ItemStack(ModItems.powder_iron, 1);
			if(mODE(item, "dustIron"))
				return new ItemStack(ModItems.powder_niobium, 1);
			if(mODE(item, "dustGold"))
				return new ItemStack(ModItems.powder_lanthanium, 1);
			if(mODE(item, "dustNetherQuartz"))
				return new ItemStack(ModItems.powder_bromine, 1);
			if(mODE(item, "dustUranium"))
				return new ItemStack(ModItems.powder_tennessine, 1);
			if(mODE(item, "dustTitanium"))
				return new ItemStack(ModItems.powder_strontium, 1);
			if(mODE(item, "dustCopper"))
				return new ItemStack(ModItems.powder_niobium, 1);
			if(mODE(item, "dustTungsten"))
				return new ItemStack(ModItems.powder_actinium, 1);
			if(mODE(item, "dustAluminum"))
				return new ItemStack(ModItems.powder_bromine, 1);
			if(mODE(item, "dustLead"))
				return new ItemStack(ModItems.powder_tennessine, 1);
			if(mODE(item, "dustBeryllium"))
				return new ItemStack(ModItems.powder_bromine, 1);
			if(mODE(item, "dustLithium"))
				return new ItemStack(ModItems.powder_bromine, 1);
			if(item.getItem() == ModItems.powder_iodine)
				return new ItemStack(ModItems.powder_astatine, 1);
			if(item.getItem() == ModItems.powder_thorium)
				return new ItemStack(ModItems.powder_tennessine, 1);
			if(item.getItem() == ModItems.powder_neodymium)
				return new ItemStack(ModItems.powder_lead, 1);
			if(item.getItem() == ModItems.powder_astatine)
				return new ItemStack(ModItems.powder_plutonium, 1);
			if(item.getItem() == ModItems.powder_caesium)
				return new ItemStack(ModItems.powder_tungsten, 1);
			if(item.getItem() == ModItems.powder_verticium)
				return new ItemStack(ModItems.powder_unobtainium, 1);
			if(mODE(item, "dustCobalt"))
				return new ItemStack(ModItems.powder_iodine, 1);
			if(item.getItem() == ModItems.powder_bromine)
				return new ItemStack(ModItems.powder_caesium, 1);
			if(item.getItem() == ModItems.powder_niobium)
				return new ItemStack(ModItems.powder_cerium, 1);
			if(item.getItem() == ModItems.powder_tennessine)
				return new ItemStack(ModItems.powder_reiium, 1);
			if(item.getItem() == ModItems.powder_cerium)
				return new ItemStack(ModItems.powder_lead, 1);
			if(item.getItem() == ModItems.powder_actinium)
				return new ItemStack(ModItems.powder_tennessine, 1);
			if(item.getItem() == ModItems.powder_lanthanium)
				return new ItemStack(ModItems.powder_astatine, 1);
		}
		
		//PLUTONIUM
		if (part.getItem() == ModItems.part_plutonium) {
			if(mODE(item, "dustUranium"))
				return new ItemStack(ModItems.powder_schrabidium, 1);
			if(item.getItem() == ModItems.powder_plutonium)
				return new ItemStack(ModItems.powder_schrabidium, 1);
			if(item.getItem() == ModItems.powder_neptunium)
				return new ItemStack(ModItems.powder_schrabidium, 1);
			if(item.getItem() == ModItems.powder_unobtainium)
				return new ItemStack(ModItems.powder_daffergon, 1);
			if(item.getItem() == ModItems.cell_antimatter)
				return new ItemStack(ModItems.cell_anti_schrabidium, 1);
		}

		return null;
	}

	public Map<Object[], Object> getAlloyRecipes() {
		Map<Object[], Object> recipes = new HashMap<Object[], Object>();
		
		if (GeneralConfig.enableDebugMode) {
			recipes.put(new ItemStack[] { new ItemStack(Items.iron_ingot), new ItemStack(Items.quartz) },
					new ItemStack(Item.getItemFromBlock(ModBlocks.test_render)));
		}
		try {
			recipes.put(new ItemStack[] { new ItemStack(Items.iron_ingot), new ItemStack(Items.coal) },
				getFurnaceOutput(new ItemStack(Items.iron_ingot), new ItemStack(Items.coal)).copy());
			recipes.put(new ItemStack[] { new ItemStack(ModItems.ingot_tungsten), new ItemStack(Items.coal) },
					getFurnaceOutput(new ItemStack(ModItems.ingot_tungsten), new ItemStack(Items.coal)).copy());
			recipes.put(new ItemStack[] { new ItemStack(ModItems.ingot_copper), new ItemStack(Items.redstone) },
					getFurnaceOutput(new ItemStack(ModItems.ingot_copper), new ItemStack(Items.redstone)).copy());
			recipes.put(new ItemStack[] { new ItemStack(ModItems.ingot_red_copper), new ItemStack(ModItems.ingot_steel) },
					getFurnaceOutput(new ItemStack(ModItems.ingot_red_copper), new ItemStack(ModItems.ingot_steel)).copy());
			recipes.put(new ItemStack[] { new ItemStack(ModItems.canister_fuel), new ItemStack(Items.slime_ball) },
					getFurnaceOutput(new ItemStack(ModItems.canister_fuel), new ItemStack(Items.slime_ball)).copy());
			recipes.put(new ItemStack[] { new ItemStack(ModItems.ingot_tungsten), new ItemStack(ModItems.nugget_schrabidium) },
					getFurnaceOutput(new ItemStack(ModItems.ingot_tungsten), new ItemStack(ModItems.nugget_schrabidium)).copy());
			recipes.put(new ItemStack[] { new ItemStack(ModItems.plate_mixed), new ItemStack(ModItems.plate_gold) },
					getFurnaceOutput(new ItemStack(ModItems.plate_mixed), new ItemStack(ModItems.plate_gold)).copy());
			recipes.put(new ItemStack[] { new ItemStack(ModItems.ingot_steel), new ItemStack(ModItems.ingot_tungsten) },
					getFurnaceOutput(new ItemStack(ModItems.ingot_steel), new ItemStack(ModItems.ingot_tungsten)).copy());
			recipes.put(new ItemStack[] { new ItemStack(ModItems.ingot_steel), new ItemStack(ModItems.ingot_cobalt) },
					getFurnaceOutput(new ItemStack(ModItems.ingot_steel), new ItemStack(ModItems.ingot_cobalt)).copy());
			recipes.put(new ItemStack[] { new ItemStack(ModItems.ingot_saturnite), new ItemStack(ModItems.powder_meteorite) },
					getFurnaceOutput(new ItemStack(ModItems.ingot_saturnite), new ItemStack(ModItems.powder_meteorite)).copy());
			recipes.put(new ItemStack[] { new ItemStack(ModItems.ingot_steel), new ItemStack(ModItems.nugget_technetium) },
					getFurnaceOutput(new ItemStack(ModItems.ingot_steel), new ItemStack(ModItems.nugget_technetium)).copy());
			
			if(GeneralConfig.enableBabyMode) {
				recipes.put(new ItemStack[] { new ItemStack(ModItems.canister_empty), new ItemStack(Items.coal) },
						getFurnaceOutput(new ItemStack(ModItems.canister_empty), new ItemStack(Items.coal)).copy());
			}
			
		} catch (Exception x) {
			MainRegistry.logger.error("Unable to register alloy recipes for NEI!");
		}
		return recipes;
	}

	public ArrayList<ItemStack> getAlloyFuels() {
		ArrayList<ItemStack> fuels = new ArrayList<ItemStack>();
		fuels.add(new ItemStack(Items.coal));
		fuels.add(new ItemStack(Blocks.coal_block));
		fuels.add(new ItemStack(Items.lava_bucket));
		fuels.add(new ItemStack(Items.blaze_rod));
		fuels.add(new ItemStack(Items.blaze_powder));
		fuels.add(new ItemStack(ModItems.lignite));
		fuels.add(new ItemStack(ModItems.powder_lignite));
		fuels.add(new ItemStack(ModItems.briquette_lignite));
		fuels.add(new ItemStack(ModItems.coke));
		fuels.add(new ItemStack(ModItems.solid_fuel));
		fuels.add(new ItemStack(ModItems.powder_coal));
		return fuels;
	}

	public ArrayList<ItemStack> getCentrifugeFuels() {
		ArrayList<ItemStack> fuels = new ArrayList<ItemStack>();
		fuels.add(new ItemStack(Items.coal));
		fuels.add(new ItemStack(Item.getItemFromBlock(Blocks.coal_block)));
		fuels.add(new ItemStack(Items.lava_bucket));
		fuels.add(new ItemStack(Items.redstone));
		fuels.add(new ItemStack(Item.getItemFromBlock(Blocks.redstone_block)));
		fuels.add(new ItemStack(Item.getItemFromBlock(Blocks.netherrack)));
		fuels.add(new ItemStack(Items.blaze_rod));
		fuels.add(new ItemStack(Items.blaze_powder));
		return fuels;
	}
	
	public Map<Object[], Object> getCyclotronRecipes() {
		Map<Object[], Object> recipes = new HashMap<Object[], Object>();
		Item part = ModItems.part_lithium;
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.niter) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.niter)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_coal) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_coal)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_iron) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_iron)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_gold) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_gold)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_quartz) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_quartz)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_uranium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_uranium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_aluminium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_aluminium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_beryllium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_beryllium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_schrabidium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_schrabidium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_lithium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_lithium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_iodine) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_iodine)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_thorium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_thorium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_caesium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_caesium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_reiium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_reiium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_cobalt) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_cobalt)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_cerium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_cerium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_actinium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_actinium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_lanthanium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_lanthanium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.nothing) },
				new ItemStack(ModItems.cell_antimatter));

		part = ModItems.part_beryllium;
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.sulfur) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.sulfur)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.fluorite) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.fluorite)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_iron) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_iron)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_quartz) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_quartz)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_titanium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_titanium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_copper) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_copper)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_tungsten) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_tungsten)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_aluminium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_aluminium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_lead) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_lead)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_beryllium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_beryllium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_lithium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_lithium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_iodine) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_iodine)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_thorium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_thorium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_astatine) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_astatine)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_caesium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_caesium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_weidanium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_weidanium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_strontium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_strontium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_bromine) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_bromine)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_actinium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_actinium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_lanthanium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_lanthanium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.nothing) },
				new ItemStack(ModItems.cell_antimatter));
		
		part = ModItems.part_carbon;
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.sulfur) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.sulfur)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.niter) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.niter)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.fluorite) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.fluorite)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_coal) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_coal)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_iron) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_iron)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_gold) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_gold)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_quartz) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_quartz)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_plutonium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_plutonium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_neptunium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_neptunium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_titanium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_titanium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_copper) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_copper)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_tungsten) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_tungsten)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_aluminium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_aluminium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_lead) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_lead)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_beryllium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_beryllium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_lithium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_lithium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_iodine) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_iodine)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_neodymium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_neodymium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_australium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_australium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_strontium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_strontium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_cobalt) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_cobalt)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_bromine) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_bromine)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_niobium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_niobium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_tennessine) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_tennessine)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_cerium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_cerium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.nothing) },
				new ItemStack(ModItems.cell_antimatter));
		
		part = ModItems.part_copper;
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.sulfur) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.sulfur)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.niter) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.niter)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.fluorite) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.fluorite)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_coal) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_coal)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_iron) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_iron)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_gold) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_gold)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_quartz) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_quartz)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_uranium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_uranium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_titanium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_titanium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_copper) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_copper)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_tungsten) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_tungsten)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_aluminium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_aluminium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_lead) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_lead)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_beryllium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_beryllium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_lithium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_lithium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_iodine) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_iodine)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_thorium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_thorium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_neodymium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_neodymium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_astatine) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_astatine)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_caesium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_caesium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_verticium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_verticium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_cobalt) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_cobalt)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_bromine) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_bromine)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_niobium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_niobium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_tennessine) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_tennessine)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_cerium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_cerium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_actinium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_actinium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_lanthanium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_lanthanium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.nothing) },
				new ItemStack(ModItems.cell_antimatter));
		
		part = ModItems.part_plutonium;
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_uranium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_uranium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_plutonium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_plutonium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_neptunium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_neptunium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.powder_unobtainium) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.powder_unobtainium)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.cell_antimatter) },
				getCyclotronOutput(new ItemStack(part), new ItemStack(ModItems.cell_antimatter)));
		
		recipes.put(new ItemStack[] { new ItemStack(part), new ItemStack(ModItems.nothing) },
				new ItemStack(ModItems.cell_antimatter));
		
		return recipes;
	}

	//keep this
	//like in a museum or something
	//this is a testament of my incompetence
	//look at it
	//look at how horrifying it is
	//children, never do this
	/*public class ShredderRecipe {

		public ItemStack input;
		public ItemStack output;

		public void registerEverythingImSrs() {
			
			String[] names = OreDictionary.getOreNames();
			List<ItemStack> stacks = new ArrayList<ItemStack>();
			
			for(int i = 0; i < names.length; i++) {
				stacks.addAll(OreDictionary.getOres(names[i]));
			}
			
			for(int i = 0; i < stacks.size(); i++) {
				
				int[] ids = OreDictionary.getOreIDs(stacks.get(i));

				List<String> oreNames = new ArrayList<String>();
				
				for(int j = 0; j < ids.length; j++) {
					oreNames.add(OreDictionary.getOreName(ids[j]));
				}
				
				theWholeThing.add(new DictCouple(stacks.get(i), oreNames));
			}
			
			MainRegistry.logger.info("Added " + theWholeThing.size() + " elements from the Ore Dict!");
		}
		
		public boolean doesExist(ItemStack stack) {
			
			for(DictCouple dic : theWholeThing) {
				if(dic.item.getItem() == stack.getItem() && dic.item.getItemDamage() == stack.getItemDamage())
					return true;
			}
			
			return false;
		}

		public void addRecipes() {

			// Not very efficient, I know, but at least it works AND it's
			// somewhat smart!
			
			for(int i = 0; i < theWholeThing.size(); i++)
			{
				for(int j = 0; j < theWholeThing.get(i).list.size(); j++)
				{
					String s = theWholeThing.get(i).list.get(j);
					
					if (s.length() > 5 && s.substring(0, 5).equals("ingot")) {
						ItemStack stack = canFindDustByName(s.substring(5));
						if (stack != null) {
							setRecipe(theWholeThing.get(i).item, stack);
						} else {
							setRecipe(theWholeThing.get(i).item, new ItemStack(ModItems.scrap));
						}
					} else if (s.length() > 3 && s.substring(0, 3).equals("ore")) {
						ItemStack stack = canFindDustByName(s.substring(3));
						if (stack != null) {
							setRecipe(theWholeThing.get(i).item, new ItemStack(stack.getItem(), 2, stack.getItemDamage()));
						} else {
							setRecipe(theWholeThing.get(i).item, new ItemStack(ModItems.scrap));
						}
					} else if (s.length() > 5 && s.substring(0, 5).equals("block")) {
						ItemStack stack = canFindDustByName(s.substring(5));
						if (stack != null) {
							setRecipe(theWholeThing.get(i).item, new ItemStack(stack.getItem(), 9, stack.getItemDamage()));
						} else {
							setRecipe(theWholeThing.get(i).item, new ItemStack(ModItems.scrap));
						}
					} else if (s.length() > 3 && s.substring(0, 3).equals("gem")) {
						ItemStack stack = canFindDustByName(s.substring(3));
						if (stack != null) {
							setRecipe(theWholeThing.get(i).item, new ItemStack(stack.getItem(), 1, stack.getItemDamage()));
						} else {
							setRecipe(theWholeThing.get(i).item, new ItemStack(ModItems.scrap));
						}
					} else if (s.length() > 4 && s.substring(0, 4).equals("dust")) {
						setRecipe(theWholeThing.get(i).item, new ItemStack(ModItems.dust));
					} else if (s.length() > 6 && s.substring(0, 6).equals("powder")) {
						setRecipe(theWholeThing.get(i).item, new ItemStack(ModItems.dust));
					} else {
						setRecipe(theWholeThing.get(i).item, new ItemStack(ModItems.scrap));
					}
				}

				if(theWholeThing.get(i).list.isEmpty())
					setRecipe(theWholeThing.get(i).item, new ItemStack(ModItems.scrap));
				if(!theWholeThing.get(i).list.isEmpty() && theWholeThing.get(i).list.get(0).equals("Unknown"))
					setRecipe(theWholeThing.get(i).item, new ItemStack(ModItems.scrap));
			}

			MainRegistry.logger.info("Added " + recipesShredder.size() + " in total.");
			MainRegistry.logger.info("Added " + dustCount + " ore dust recipes.");
		}
		
		public ItemStack canFindDustByName(String s) {
			
			for(DictCouple d : theWholeThing)
			{
				for(String s1 : d.list)
				{
					if(s1.length() > 4 && s1.substring(0, 4).equals("dust") && s1.substring(4).equals(s))
					{
						dustCount++;
						return d.item;
					}
				}
			}
			
			return null;
		}
		
		public void setRecipe(ItemStack inp, ItemStack outp) {
			ShredderRecipe recipe = new ShredderRecipe();
			
			recipe.input = inp;
			recipe.output = outp;
			
			recipesShredder.add(recipe);
		}
		
		public void overridePreSetRecipe(ItemStack inp, ItemStack outp) {
			
			boolean flag = false;
			
			for(int i = 0; i < recipesShredder.size(); i++)
			{
				if(recipesShredder.get(i) != null && 
						recipesShredder.get(i).input != null && 
						recipesShredder.get(i).output != null && 
						inp != null && 
						outp != null && 
						recipesShredder.get(i).input.getItem() == inp.getItem() && 
						recipesShredder.get(i).input.getItemDamage() == inp.getItemDamage()) {
					recipesShredder.get(i).output = outp;
					flag = true;
				}
			}
			
			if(!flag) {
				ShredderRecipe rec = new ShredderRecipe();
				rec.input = inp;
				rec.output = outp;
				recipesShredder.add(rec);
			}
		}
		
		public void removeDuplicates() {
			List<ShredderRecipe> newList = new ArrayList<ShredderRecipe>();
			
			for(ShredderRecipe piv : recipesShredder)
			{
				boolean flag = false;
				
				if(newList.size() == 0)
				{
					newList.add(piv);
				} else {
					for(ShredderRecipe rec : newList) {
						if(piv != null && rec != null && piv.input != null && rec.input != null && rec.input.getItem() != null && piv.input.getItem() != null && rec.input.getItemDamage() == piv.input.getItemDamage() && rec.input.getItem() == piv.input.getItem())
							flag = true;
						if(piv == null || rec == null || piv.input == null || rec.input == null)
							flag = true;
					}
				}
				
				if(!flag)
				{
					newList.add(piv);
				}
			}
		}
		
		public void PrintRecipes() {

			MainRegistry.logger.debug("TWT: " + theWholeThing.size() + ", REC: " + recipesShredder.size());
		}
	}

	public static class DictCouple {
		
		public ItemStack item;
		public List<String> list;

		public DictCouple(ItemStack item, List<String> list) {
			this.item = item;
			this.list = list;
		}
		
		public static List<String> findWithStack(ItemStack stack) {
			for(DictCouple couple : theWholeThing) {
				if(couple.item == stack);
					return couple.list;
			}
			
			return null;
		}
	}

	public static List<ShredderRecipe> recipesShredder = new ArrayList<ShredderRecipe>();
	public static List<DictCouple> theWholeThing = new ArrayList<DictCouple>();
	public static int dustCount = 0;
	
	public static ItemStack getShredderResult(ItemStack stack) {
		for(ShredderRecipe rec : recipesShredder)
		{
			if(stack != null && 
					rec.input.getItem() == stack.getItem() && 
					rec.input.getItemDamage() == stack.getItemDamage())
				return rec.output.copy();
		}
		
		return new ItemStack(ModItems.scrap);
	}
	
	public Map<Object, Object> getShredderRecipes() {
		Map<Object, Object> recipes = new HashMap<Object, Object>();
		
		for(int i = 0; i < MachineRecipes.recipesShredder.size(); i++) {
			if(MachineRecipes.recipesShredder.get(i) != null && MachineRecipes.recipesShredder.get(i).output.getItem() != ModItems.scrap)
				recipes.put(MachineRecipes.recipesShredder.get(i).input, getShredderResult(MachineRecipes.recipesShredder.get(i).input));
		}
		
		return recipes;
	}*/

	public Map<Object[], Object> getCMBRecipes() {
		Map<Object[], Object> recipes = new HashMap<Object[], Object>();
		recipes.put(new ItemStack[] { new ItemStack(ModItems.ingot_advanced_alloy), new ItemStack(ModItems.ingot_magnetized_tungsten) },
				new ItemStack(ModItems.ingot_combine_steel, 4));
		recipes.put(new ItemStack[] { new ItemStack(ModItems.powder_advanced_alloy), new ItemStack(ModItems.powder_magnetized_tungsten) },
				new ItemStack(ModItems.ingot_combine_steel, 4));
		return recipes;
	}

	public ArrayList<ItemStack> getBatteries() {
		ArrayList<ItemStack> fuels = new ArrayList<ItemStack>();
		fuels.add(new ItemStack(ModItems.battery_potato));
		fuels.add(new ItemStack(ModItems.battery_potatos));
		fuels.add(new ItemStack(ModItems.battery_su));
		fuels.add(new ItemStack(ModItems.battery_su_l));
		fuels.add(new ItemStack(ModItems.battery_generic));
		fuels.add(new ItemStack(ModItems.battery_red_cell));
		fuels.add(new ItemStack(ModItems.battery_red_cell_6));
		fuels.add(new ItemStack(ModItems.battery_red_cell_24));
		fuels.add(new ItemStack(ModItems.battery_advanced));
		fuels.add(new ItemStack(ModItems.battery_advanced_cell));
		fuels.add(new ItemStack(ModItems.battery_advanced_cell_4));
		fuels.add(new ItemStack(ModItems.battery_advanced_cell_12));
		fuels.add(new ItemStack(ModItems.battery_lithium));
		fuels.add(new ItemStack(ModItems.battery_lithium_cell));
		fuels.add(new ItemStack(ModItems.battery_lithium_cell_3));
		fuels.add(new ItemStack(ModItems.battery_lithium_cell_6));
		fuels.add(new ItemStack(ModItems.battery_schrabidium));
		fuels.add(new ItemStack(ModItems.battery_schrabidium_cell));
		fuels.add(new ItemStack(ModItems.battery_schrabidium_cell_2));
		fuels.add(new ItemStack(ModItems.battery_schrabidium_cell_4));
		fuels.add(new ItemStack(ModItems.battery_trixite));
		fuels.add(new ItemStack(ModItems.battery_spark));
		fuels.add(new ItemStack(ModItems.battery_spark_cell_6));
		fuels.add(new ItemStack(ModItems.battery_spark_cell_25));
		fuels.add(new ItemStack(ModItems.battery_spark_cell_100));
		fuels.add(new ItemStack(ModItems.battery_spark_cell_1000));
		fuels.add(new ItemStack(ModItems.battery_spark_cell_10000));
		fuels.add(new ItemStack(ModItems.battery_spark_cell_power));
		fuels.add(new ItemStack(ModItems.fusion_core));
		fuels.add(new ItemStack(ModItems.energy_core));
		return fuels;
	}

	public ArrayList<ItemStack> getBlades() {
		ArrayList<ItemStack> fuels = new ArrayList<ItemStack>();
		fuels.add(new ItemStack(ModItems.blades_advanced_alloy));
		fuels.add(new ItemStack(ModItems.blades_aluminium));
		fuels.add(new ItemStack(ModItems.blades_combine_steel));
		fuels.add(new ItemStack(ModItems.blades_gold));
		fuels.add(new ItemStack(ModItems.blades_iron));
		fuels.add(new ItemStack(ModItems.blades_steel));
		fuels.add(new ItemStack(ModItems.blades_titanium));
		fuels.add(new ItemStack(ModItems.blades_schrabidium));
		fuels.add(new ItemStack(ModItems.blades_desh));
		return fuels;
	}
	
	public static boolean mODE(Item item, String[] names) {
		return mODE(new ItemStack(item), names);
	}
	
	public static boolean mODE(ItemStack item, String[] names) {
		boolean flag = false;
		if(names.length > 0) {
			for(int i = 0; i < names.length; i++) {
				if(mODE(item, names[i]))
					flag = true;
			}
		}
		
		return flag;
	}
	
	public static boolean mODE(Item item, String name) {
		return mODE(new ItemStack(item), name);
	}
	
	//Matches Ore Dict Entry
	public static boolean mODE(ItemStack stack, String name) {
		
		int[] ids = OreDictionary.getOreIDs(new ItemStack(stack.getItem(), 1, stack.getItemDamage()));
		
		for(int i = 0; i < ids.length; i++) {
			
			String s = OreDictionary.getOreName(ids[i]);
			
			if(s.length() > 0 && s.equals(name))
				return true;
		}
		
		return false;
	}
	
	public Map<Object[], Object[]> getChemistryRecipes() {

		Map<Object[], Object[]> recipes = new HashMap<Object[], Object[]>();
		
        for (int i = 0; i < ItemChemistryTemplate.EnumChemistryTemplate.values().length; ++i)
        {
        	ItemStack[] inputs = new ItemStack[7];
        	ItemStack[] outputs = new ItemStack[6];
        	inputs[6] = new ItemStack(ModItems.chemistry_template, 1, i);
        	
        	List<ItemStack> listIn = MachineRecipes.getChemInputFromTempate(inputs[6]);
        	if(listIn != null)
        		for(int j = 0; j < listIn.size(); j++)
        			if(listIn.get(j) != null)
        				inputs[j + 2] = listIn.get(j).copy();
        	
        	FluidStack[] fluidIn = MachineRecipes.getFluidInputFromTempate(inputs[6]);
        	for(int j = 0; j < fluidIn.length; j++)
        		if(fluidIn[j] != null)
        			inputs[j] = ItemFluidIcon.addQuantity(new ItemStack(ModItems.fluid_icon, 1, fluidIn[j].type.getID()), fluidIn[j].fill);
        	
        	ItemStack[] listOut = MachineRecipes.getChemOutputFromTempate(inputs[6]);
        	for(int j = 0; j < listOut.length; j++)
        		if(listOut[j] != null)
        			outputs[j + 2] = listOut[j].copy();
        	
        	FluidStack[] fluidOut = MachineRecipes.getFluidOutputFromTempate(inputs[6]);
        	for(int j = 0; j < fluidOut.length; j++)
        		if(fluidOut[j] != null)
        			outputs[j] = ItemFluidIcon.addQuantity(new ItemStack(ModItems.fluid_icon, 1, fluidOut[j].type.getID()), fluidOut[j].fill);
        	
        	for(int j = 0; j < inputs.length; j++)
        		if(inputs[j] == null)
        			inputs[j] = new ItemStack(ModItems.nothing);
        	
        	for(int j = 0; j < outputs.length; j++)
        		if(outputs[j] == null)
        			outputs[j] = new ItemStack(ModItems.nothing);
        	
        	recipes.put(inputs, outputs);
        }
		
		return recipes;
	}
	
	public Map<Object, Object> getBoilerRecipes() {

		Map<Object, Object> recipes = new HashMap<Object, Object>();
		
		for(int i = 0; i < Fluids.getAll().length; i++) {
			Object[] outs = getBoilerOutput(Fluids.fromID(i));
			
			if(outs != null) {

				ItemStack in = new ItemStack(ModItems.fluid_icon, 1, i);
				in.stackTagCompound = new NBTTagCompound();
				in.stackTagCompound.setInteger("fill", (Integer) outs[2]);
				
				ItemStack out = new ItemStack(ModItems.fluid_icon, 1, ((FluidType)outs[0]).getID());
				out.stackTagCompound = new NBTTagCompound();
				out.stackTagCompound.setInteger("fill", (Integer) outs[1]);
				
				recipes.put(in, out);
			}
		}
		
		return recipes;
	}
	
	public static List<ItemStack> getChemInputFromTempate(ItemStack stack) {
		
		if(stack == null || !(stack.getItem() instanceof ItemChemistryTemplate))
			return null;
		
		List<ItemStack> list = new ArrayList<ItemStack>();
		ItemChemistryTemplate.EnumChemistryTemplate chem = ItemChemistryTemplate.EnumChemistryTemplate.getEnum(stack.getItemDamage());
		
		if(chem.isDisabled())
			return list;
		
		switch(chem) {
        case CC_OIL:
			list.add(new ItemStack(ModItems.powder_coal, 8));
			list.add(new ItemStack(ModItems.oil_tar, 4));
			break;
        case CC_I:
			list.add(new ItemStack(ModItems.powder_coal, 6));
			list.add(new ItemStack(ModItems.oil_tar, 4));
			break;
        case CC_HEATING:
			list.add(new ItemStack(ModItems.powder_coal, 6));
			list.add(new ItemStack(ModItems.oil_tar, 4));
			break;
        case CC_HEAVY:
			list.add(new ItemStack(ModItems.powder_coal, 8));
			list.add(new ItemStack(ModItems.oil_tar, 4));
			break;
        case CC_NAPHTHA:
			list.add(new ItemStack(ModItems.powder_coal, 8));
			list.add(new ItemStack(ModItems.oil_tar, 4));
			break;
        case ASPHALT:
			list.add(new ItemStack(Blocks.gravel, 2));
			list.add(new ItemStack(Blocks.sand, 6));
			break;
        case CONCRETE:
			list.add(new ItemStack(Blocks.gravel, 8));
			list.add(new ItemStack(Blocks.sand, 8));
			break;
        case CONCRETE_ASBESTOS:
			list.add(new ItemStack(Blocks.gravel, 2));
			list.add(new ItemStack(Blocks.sand, 2));
			list.add(new ItemStack(ModItems.ingot_asbestos, 4));
			break;
        case COOLANT:
			list.add(new ItemStack(ModItems.niter, 1));
			break;
        case CRYOGEL:
			list.add(new ItemStack(ModItems.powder_ice, 1));
			break;
        case DESH:
			list.add(new ItemStack(ModItems.powder_desh_mix, 1));
			break;
        case CIRCUIT_4:
			list.add(new ItemStack(ModItems.circuit_red_copper, 1));
			list.add(new ItemStack(ModItems.wire_gold, 4));
			list.add(new ItemStack(ModItems.powder_lapis, 1));
			list.add(new ItemStack(ModItems.ingot_polymer, 1));
			break;
        case CIRCUIT_5:
			list.add(new ItemStack(ModItems.circuit_gold, 1));
			list.add(new ItemStack(ModItems.wire_schrabidium, 4));
			list.add(new ItemStack(ModItems.powder_diamond, 1));
			list.add(new ItemStack(ModItems.ingot_desh, 1));
			break;
        case POLYMER:
			list.add(new ItemStack(ModItems.powder_coal, 2));
			list.add(new ItemStack(ModItems.fluorite, 1));
			break;
        case DEUTERIUM:
			list.add(new ItemStack(ModItems.sulfur, 1));
			break;
        case BP_BIOGAS:
			list.add(new ItemStack(ModItems.biomass, 16));
			break;
        case YELLOWCAKE:
			list.add(new ItemStack(ModItems.billet_uranium, 2));
			list.add(new ItemStack(ModItems.sulfur, 2));
			break;
        case UF6:
			list.add(new ItemStack(ModItems.powder_yellowcake, 1));
			list.add(new ItemStack(ModItems.fluorite, 4));
			break;
        case PUF6:
			list.add(new ItemStack(ModItems.powder_plutonium, 1));
			list.add(new ItemStack(ModItems.fluorite, 3));
			break;
        case SAS3:
			list.add(new ItemStack(ModItems.powder_schrabidium, 1));
			list.add(new ItemStack(ModItems.sulfur, 2));
			break;
        case NITAN:
			list.add(new ItemStack(ModItems.powder_nitan_mix, 2));
			break;
        case OIL_SAND:
			list.add(new ItemStack(ModBlocks.ore_oil_sand, 16));
			break;
        case DYN_SCHRAB:
			list.add(new ItemStack(ModItems.dynosphere_desh_charged, 3));
			list.add(new ItemStack(ModItems.ingot_uranium, 1));
			list.add(new ItemStack(ModItems.catalyst_clay, 8));
			break;
        case DYN_EUPH:
			list.add(new ItemStack(ModItems.dynosphere_schrabidium_charged, 1));
			list.add(new ItemStack(ModItems.ingot_plutonium, 1));
			list.add(new ItemStack(ModItems.catalyst_clay, 16));
			list.add(new ItemStack(ModItems.ingot_euphemium, 1));
			break;
        case DYN_DNT:
			list.add(new ItemStack(ModItems.dynosphere_euphemium_charged, 2));
			list.add(new ItemStack(ModItems.powder_spark_mix, 1));
			list.add(new ItemStack(ModItems.ingot_starmetal, 1));
			list.add(new ItemStack(ModItems.catalyst_clay, 32));
			break;
        case CORDITE:
			list.add(new ItemStack(ModItems.niter, 2));
			list.add(new ItemStack(Blocks.planks, 1));
			list.add(new ItemStack(Items.sugar, 1));
			break;
        case KEVLAR:
			list.add(new ItemStack(ModItems.niter, 2));
			list.add(new ItemStack(Items.brick, 1));
			list.add(new ItemStack(ModItems.powder_coal, 1));
			break;
        case SOLID_FUEL:
			list.add(new ItemStack(ModItems.solid_fuel, 2));
			list.add(new ItemStack(ModItems.niter, 1));
			list.add(new ItemStack(Items.redstone, 1));
			break;
        case SATURN:
			list.add(new ItemStack(ModItems.powder_dura_steel, 1));
			list.add(new ItemStack(ModItems.powder_fire, 1));
			break;
        case BALEFIRE:
			list.add(new ItemStack(ModItems.egg_balefire_shard, 1));
			break;
        case SCHRABIDIC:
			list.add(new ItemStack(ModItems.pellet_charged, 1));
			break;
        case SCHRABIDATE:
			list.add(new ItemStack(ModItems.powder_iron, 1));
			break;
		case COLTAN_CLEANING:
			list.add(new ItemStack(ModItems.powder_coltan_ore, 2));
			list.add(new ItemStack(ModItems.powder_coal, 1));
			break;
		case COLTAN_PAIN:
			list.add(new ItemStack(ModItems.powder_coltan, 1));
			list.add(new ItemStack(ModItems.fluorite, 1));
			break;
		case VIT_LIQUID:
		case VIT_GAS:
			list.add(new ItemStack(ModBlocks.sand_lead, 1));
			break;
		case TEL:
			list.add(new ItemStack(ModItems.oil_tar, 1));
			list.add(new ItemStack(ModItems.powder_lead, 1));
			break;
		case GASOLINE:
			list.add(new ItemStack(ModItems.antiknock, 1));
			break;
		case FRACKSOL:
			list.add(new ItemStack(ModItems.sulfur, 1));
			break;
		case HELIUM3:
			list.add(new ItemStack(ModBlocks.moon_turf, 8));
			break;
		case OSMIRIDIUM_DEATH:
			list.add(new ItemStack(ModItems.powder_paleogenite, 1));
			list.add(new ItemStack(ModItems.fluorite, 8));
			list.add(new ItemStack(ModItems.nugget_bismuth, 4));
			break;
		case ETHANOL:
			list.add(new ItemStack(Items.sugar, 6));
			break;
		case METH:
			list.add(new ItemStack(Items.wheat, 1));
			list.add(new ItemStack(Items.dye, 2, 3));
			break;
		case DUCRETE:
			list.add(new ItemStack(Blocks.sand, 8));
			list.add(new ItemStack(ModItems.billet_u238, 2));
			list.add(new ItemStack(Items.clay_ball, 4));
		default:
			break;
		}
		
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	
	public static FluidStack[] getFluidInputFromTempate(ItemStack stack) {
		
		if(stack == null || !(stack.getItem() instanceof ItemChemistryTemplate))
			return null;
		
		FluidStack[] input = new FluidStack[2];
		
		ItemChemistryTemplate.EnumChemistryTemplate chem = ItemChemistryTemplate.EnumChemistryTemplate.getEnum(stack.getItemDamage());
		
		if(chem.isDisabled())
			return input;
		
		switch(chem) {
        case FP_HEAVYOIL:
			input[0] = new FluidStack(1000, Fluids.HEAVYOIL);
			break;
        case FP_SMEAR:
			input[0] = new FluidStack(1000, Fluids.SMEAR);
			break;
        case FP_NAPHTHA:
			input[0] = new FluidStack(1000, Fluids.NAPHTHA);
			break;
        case FP_LIGHTOIL:
			input[0] = new FluidStack(1000, Fluids.LIGHTOIL);
			break;
        case FR_REOIL:
			input[0] = new FluidStack(1000, Fluids.SMEAR);
			break;
        case FR_PETROIL:
			input[0] = new FluidStack(800, Fluids.RECLAIMED);
			input[1] = new FluidStack(200, Fluids.LUBRICANT);
			break;
        case FC_BITUMEN:
			input[0] = new FluidStack(1200, Fluids.BITUMEN);
			input[1] = new FluidStack(2400, Fluids.STEAM);
			break;
        case FC_I_NAPHTHA:
			input[0] = new FluidStack(1400, Fluids.SMEAR);
			input[1] = new FluidStack(800, Fluids.WATER);
			break;
        case FC_GAS_PETROLEUM:
			input[0] = new FluidStack(1800, Fluids.GAS);
			input[1] = new FluidStack(1200, Fluids.WATER);
			break;
        case FC_DIESEL_KEROSENE:
			input[0] = new FluidStack(1200, Fluids.DIESEL);
			input[1] = new FluidStack(2000, Fluids.STEAM);
			break;
        case FC_KEROSENE_PETROLEUM:
			input[0] = new FluidStack(1400, Fluids.KEROSENE);
			input[1] = new FluidStack(2000, Fluids.STEAM);
			break;
        case CC_I:
			input[0] = new FluidStack(1800, Fluids.WATER);
			break;
        case CC_OIL:
			input[0] = new FluidStack(1400, Fluids.STEAM);
			break;
        case CC_HEATING:
			input[0] = new FluidStack(2000, Fluids.STEAM);
			break;
        case CC_HEAVY:
			input[0] = new FluidStack(1400, Fluids.WATER);
			break;
        case CC_NAPHTHA:
			input[0] = new FluidStack(2400, Fluids.STEAM);
			break;
        case ASPHALT:
			input[0] = new FluidStack(1000, Fluids.BITUMEN);
			break;
        case CONCRETE:
			input[0] = new FluidStack(2000, Fluids.WATER);
			break;
        case CONCRETE_ASBESTOS:
			input[0] = new FluidStack(2000, Fluids.WATER);
			break;
        case COOLANT:
			input[0] = new FluidStack(1800, Fluids.WATER);
			break;
        case CRYOGEL:
			input[0] = new FluidStack(1800, Fluids.COOLANT);
			break;
        case DESH:
        	if(GeneralConfig.enableBabyMode) {
				input[0] = new FluidStack(200, Fluids.LIGHTOIL);
        	} else {
				input[0] = new FluidStack(200, Fluids.MERCURY);
				input[1] = new FluidStack(200, Fluids.LIGHTOIL);
        	}
			break;
        case PEROXIDE:
			input[0] = new FluidStack(1000, Fluids.WATER);
        	break;
        case CIRCUIT_4:
			input[0] = new FluidStack(400, Fluids.ACID);
			input[1] = new FluidStack(200, Fluids.PETROLEUM);
        	break;
        case CIRCUIT_5:
			input[0] = new FluidStack(800, Fluids.ACID);
			input[1] = new FluidStack(200, Fluids.MERCURY);
        	break;
		case SF_OIL:
			input[0] = new FluidStack(SolidificationRecipes.SF_OIL * 2, Fluids.OIL);
			break;
		case SF_HEAVYOIL:
			input[0] = new FluidStack(SolidificationRecipes.SF_HEAVY * 2, Fluids.HEAVYOIL);
			break;
		case SF_SMEAR:
			input[0] = new FluidStack(SolidificationRecipes.SF_SMEAR * 2, Fluids.SMEAR);
			break;
		case SF_HEATINGOIL:
			input[0] = new FluidStack(SolidificationRecipes.SF_HEATING * 2, Fluids.HEATINGOIL);
			break;
		case SF_RECLAIMED:
			input[0] = new FluidStack(SolidificationRecipes.SF_RECLAIMED * 2, Fluids.RECLAIMED);
			break;
		case SF_PETROIL:
			input[0] = new FluidStack(SolidificationRecipes.SF_PETROIL * 2, Fluids.PETROIL);
			break;
		case SF_LUBRICANT:
			input[0] = new FluidStack(SolidificationRecipes.SF_LUBE * 2, Fluids.LUBRICANT);
			break;
		case SF_NAPHTHA:
			input[0] = new FluidStack(SolidificationRecipes.SF_NAPH * 2, Fluids.NAPHTHA);
			break;
		case SF_DIESEL:
			input[0] = new FluidStack(SolidificationRecipes.SF_DIESEL * 2, Fluids.DIESEL);
			break;
		case SF_LIGHTOIL:
			input[0] = new FluidStack(SolidificationRecipes.SF_LIGHT * 2, Fluids.LIGHTOIL);
			break;
		case SF_KEROSENE:
			input[0] = new FluidStack(SolidificationRecipes.SF_KEROSENE * 2, Fluids.KEROSENE);
			break;
		case SF_GAS:
			input[0] = new FluidStack(SolidificationRecipes.SF_GAS * 2, Fluids.GAS);
			break;
		case SF_PETROLEUM:
			input[0] = new FluidStack(SolidificationRecipes.SF_PETROLEUM * 2, Fluids.PETROLEUM);
			break;
		case SF_BIOGAS:
			input[0] = new FluidStack(SolidificationRecipes.SF_BIOGAS * 2, Fluids.BIOGAS);
			break;
		case SF_BIOFUEL:
			input[0] = new FluidStack(SolidificationRecipes.SF_BIOFUEL * 2, Fluids.BIOFUEL);
			break;
        case POLYMER:
			input[0] = new FluidStack(600, Fluids.PETROLEUM);
        	break;
        case DEUTERIUM:
			input[0] = new FluidStack(4000, Fluids.WATER);
        	break;
        case STEAM:
			input[0] = new FluidStack(1000, Fluids.WATER);
        	break;
        case LPG:
			input[0] = new FluidStack(2000, Fluids.PETROLEUM);
        	break;
        case BP_BIOFUEL:
			input[0] = new FluidStack(2000, Fluids.BIOGAS);
        	break;
        case YELLOWCAKE:
			input[0] = new FluidStack(500, Fluids.ACID);
        	break;
        case UF6:
			input[0] = new FluidStack(1000, Fluids.WATER);
        	break;
        case PUF6:
			input[0] = new FluidStack(1000, Fluids.WATER);
        	break;
        case SAS3:
			input[0] = new FluidStack(2000, Fluids.ACID);
        	break;
        case NITAN:
			input[0] = new FluidStack(600, Fluids.KEROSENE);
			input[1] = new FluidStack(200, Fluids.MERCURY);
        	break;
        case OIL_SAND:
			input[0] = new FluidStack(400, Fluids.BITUMEN);
        	break;
        case CORDITE:
			input[0] = new FluidStack(200, Fluids.HEATINGOIL);
        	break;
        case KEVLAR:
			input[0] = new FluidStack(100, Fluids.PETROLEUM);
        	break;
        case SOLID_FUEL:
			input[0] = new FluidStack(200, Fluids.PETROLEUM);
        	break;
    	case ELECTROLYSIS:
			input[0] = new FluidStack(8000, Fluids.WATER);
        	break;
    	case XENON:
			input[0] = new FluidStack(0, Fluids.NONE);
        	break;
    	case XENON_OXY:
			input[0] = new FluidStack(250, Fluids.OXYGEN);
        	break;
    	case SATURN:
			input[0] = new FluidStack(100, Fluids.ACID);
			input[1] = new FluidStack(50, Fluids.MERCURY);
        	break;
    	case BALEFIRE:
			input[0] = new FluidStack(6000, Fluids.KEROSENE);
        	break;
    	case SCHRABIDIC:
			input[0] = new FluidStack(8000, Fluids.SAS3);
			input[1] = new FluidStack(6000, Fluids.ACID);
        	break;
    	case SCHRABIDATE:
			input[0] = new FluidStack(250, Fluids.SCHRABIDIC);
        	break;
    	case COLTAN_CLEANING:
			input[0] = new FluidStack(250, Fluids.ACID);
			input[1] = new FluidStack(500, Fluids.HYDROGEN);
        	break;
    	case COLTAN_PAIN:
			input[0] = new FluidStack(1000, Fluids.GAS);
			input[1] = new FluidStack(500, Fluids.OXYGEN);
        	break;
    	case COLTAN_CRYSTAL:
			input[0] = new FluidStack(1000, Fluids.PAIN);
			input[1] = new FluidStack(500, Fluids.ACID);
        	break;
		case VIT_LIQUID:
			input[0] = new FluidStack(1000, Fluids.WASTEFLUID);
			break;
		case VIT_GAS:
			input[0] = new FluidStack(1000, Fluids.WASTEGAS);
			break;
		case TEL:
			input[0] = new FluidStack(100, Fluids.PETROLEUM);
			input[1] = new FluidStack(1000, Fluids.STEAM);
			break;
		case GASOLINE:
			input[0] = new FluidStack(10000, Fluids.PETROIL);
			break;
		case FRACKSOL:
			input[0] = new FluidStack(100, Fluids.PETROLEUM);
			input[1] = new FluidStack(1000, Fluids.WATER);
			break;
		case OSMIRIDIUM_DEATH:
			input[0] = new FluidStack(1000, Fluids.ACID);
        	break;
		case METH:
			input[0] = new FluidStack(400, Fluids.LUBRICANT);
			input[1] = new FluidStack(400, Fluids.ACID);
			break;
		case CO2:
			input[0] = new FluidStack(1000, Fluids.GAS);
			break;
		case HEAVY_ELECTROLYSIS:
			input[0] = new FluidStack(8000, Fluids.HEAVYWATER);
			break;
		case DUCRETE:
			input[0] = new FluidStack(2000, Fluids.WATER);
		default:
			break;
		}
		
		return input;
	}
	
	public static ItemStack[] getChemOutputFromTempate(ItemStack stack) {
		
		if(stack == null || !(stack.getItem() instanceof ItemChemistryTemplate))
			return null;
		
		ItemStack[] output = new ItemStack[4];
		
		ItemChemistryTemplate.EnumChemistryTemplate chem = ItemChemistryTemplate.EnumChemistryTemplate.getEnum(stack.getItemDamage());
		
		if(chem.isDisabled())
			return output;
		
		switch(chem) {
		case ASPHALT:
			output[0] = new ItemStack(ModBlocks.asphalt, 4);
			output[1] = new ItemStack(ModBlocks.asphalt, 4);
			output[2] = new ItemStack(ModBlocks.asphalt, 4);
			output[3] = new ItemStack(ModBlocks.asphalt, 4);
			break;
		case CONCRETE:
			output[0] = new ItemStack(ModBlocks.concrete_smooth, 4);
			output[1] = new ItemStack(ModBlocks.concrete_smooth, 4);
			output[2] = new ItemStack(ModBlocks.concrete_smooth, 4);
			output[3] = new ItemStack(ModBlocks.concrete_smooth, 4);
			break;
		case CONCRETE_ASBESTOS:
			output[0] = new ItemStack(ModBlocks.concrete_asbestos, 4);
			output[1] = new ItemStack(ModBlocks.concrete_asbestos, 4);
			output[2] = new ItemStack(ModBlocks.concrete_asbestos, 4);
			output[3] = new ItemStack(ModBlocks.concrete_asbestos, 4);
			break;
		case DESH:
			output[0] = new ItemStack(ModItems.ingot_desh, 1);
			break;
		case CIRCUIT_4:
			output[0] = new ItemStack(ModItems.circuit_gold, 1);
			break;
		case CIRCUIT_5:
			output[0] = new ItemStack(ModItems.circuit_schrabidium, 1);
			break;
		case SF_OIL:
			output[0] = DictFrame.fromOne(ModItems.oil_tar, EnumTarType.CRUDE);
			output[1] = DictFrame.fromOne(ModItems.oil_tar, EnumTarType.CRUDE);
			break;
		case SF_HEAVYOIL:
			output[0] = DictFrame.fromOne(ModItems.oil_tar, EnumTarType.CRUDE);
			output[1] = DictFrame.fromOne(ModItems.oil_tar, EnumTarType.CRUDE);
			break;
		case SF_SMEAR:
			output[0] = new ItemStack(ModItems.solid_fuel, 1);
			output[1] = new ItemStack(ModItems.solid_fuel, 1);
			break;
		case SF_HEATINGOIL:
			output[0] = new ItemStack(ModItems.solid_fuel, 1);
			output[1] = new ItemStack(ModItems.solid_fuel, 1);
			break;
		case SF_RECLAIMED:
			output[0] = new ItemStack(ModItems.solid_fuel, 1);
			output[1] = new ItemStack(ModItems.solid_fuel, 1);
			break;
		case SF_PETROIL:
			output[0] = new ItemStack(ModItems.solid_fuel, 1);
			output[1] = new ItemStack(ModItems.solid_fuel, 1);
			break;
		case SF_LUBRICANT:
			output[0] = new ItemStack(ModItems.solid_fuel, 1);
			output[1] = new ItemStack(ModItems.solid_fuel, 1);
			break;
		case SF_NAPHTHA:
			output[0] = new ItemStack(ModItems.solid_fuel, 1);
			output[1] = new ItemStack(ModItems.solid_fuel, 1);
			break;
		case SF_DIESEL:
			output[0] = new ItemStack(ModItems.solid_fuel, 1);
			output[1] = new ItemStack(ModItems.solid_fuel, 1);
			break;
		case SF_LIGHTOIL:
			output[0] = new ItemStack(ModItems.solid_fuel, 1);
			output[1] = new ItemStack(ModItems.solid_fuel, 1);
			break;
    	case SF_KEROSENE:
			output[0] = new ItemStack(ModItems.solid_fuel, 1);
			output[1] = new ItemStack(ModItems.solid_fuel, 1);
			break;
    	case SF_GAS:
			output[0] = new ItemStack(ModItems.solid_fuel, 1);
			output[1] = new ItemStack(ModItems.solid_fuel, 1);
			break;
    	case SF_PETROLEUM:
			output[0] = new ItemStack(ModItems.solid_fuel, 1);
			output[1] = new ItemStack(ModItems.solid_fuel, 1);
			break;
    	case SF_BIOGAS:
			output[0] = new ItemStack(ModItems.solid_fuel, 1);
			output[1] = new ItemStack(ModItems.solid_fuel, 1);
			break;
		case SF_BIOFUEL:
			output[0] = new ItemStack(ModItems.solid_fuel, 1);
			output[1] = new ItemStack(ModItems.solid_fuel, 1);
			break;
		case POLYMER:
			output[0] = new ItemStack(ModItems.ingot_polymer, 1);
			break;
		case YELLOWCAKE:
			output[0] = new ItemStack(ModItems.powder_yellowcake, 1);
			break;
		case UF6:
			output[0] = new ItemStack(ModItems.sulfur, 2);
			break;
		case DYN_SCHRAB:
			output[0] = new ItemStack(ModItems.ingot_schrabidium, 1);
			output[1] = new ItemStack(ModItems.powder_desh, 12);
			output[2] = new ItemStack(ModItems.powder_desh_mix, 12);
			break;
		case DYN_EUPH:
			output[0] = new ItemStack(ModItems.nugget_euphemium, 12);
			output[1] = new ItemStack(ModItems.powder_schrabidium, 4);
			output[2] = new ItemStack(ModItems.powder_power, 4);
			break;
		case DYN_DNT:
			output[0] = new ItemStack(ModItems.ingot_dineutronium, 1);
			output[1] = new ItemStack(ModItems.powder_euphemium, 8);
			output[2] = new ItemStack(ModItems.powder_nitan_mix, 8);
			break;
		case CORDITE:
			output[0] = new ItemStack(ModItems.cordite, 4);
			break;
		case KEVLAR:
			output[0] = new ItemStack(ModItems.plate_kevlar, 4);
			break;
		case SOLID_FUEL:
			output[0] = new ItemStack(ModItems.rocket_fuel, 4);
			break;
		case SATURN:
			output[0] = new ItemStack(ModItems.ingot_saturnite, 2);
			break;
		case BALEFIRE:
			output[0] = new ItemStack(ModItems.powder_balefire, 1);
			break;
		case SCHRABIDATE:
			output[0] = new ItemStack(ModItems.powder_schrabidate, 1);
			break;
		case COLTAN_CLEANING:
			output[0] = new ItemStack(ModItems.powder_coltan, 1);
			output[1] = new ItemStack(ModItems.powder_niobium, 1);
			output[2] = new ItemStack(ModItems.dust, 1);
			break;
		case COLTAN_CRYSTAL:
			output[0] = new ItemStack(ModItems.gem_tantalium, 1);
			output[1] = new ItemStack(ModItems.dust, 3);
			break;
		case VIT_LIQUID:
		case VIT_GAS:
			output[0] = new ItemStack(ModItems.nuclear_waste_vitrified, 1);
			break;
		case TEL:
			output[0] = new ItemStack(ModItems.antiknock, 1);
			break;
		case METH:
			output[0] = new ItemStack(ModItems.chocolate, 2);
			output[1] = new ItemStack(ModItems.chocolate, 2);
			break;
		case DUCRETE:
			output[0] = new ItemStack(ModBlocks.ducrete_smooth, 2);
			output[1] = new ItemStack(ModBlocks.ducrete_smooth, 2);
			output[2] = new ItemStack(ModBlocks.ducrete_smooth, 2);
			output[3] = new ItemStack(ModBlocks.ducrete_smooth, 2);
		default:
			break;
		}
		
		return output;
	}
	
	public static FluidStack[] getFluidOutputFromTempate(ItemStack stack) {
		
		if(stack == null || !(stack.getItem() instanceof ItemChemistryTemplate))
			return null;
		
		FluidStack[] output = new FluidStack[2];
		
		ItemChemistryTemplate.EnumChemistryTemplate chem = ItemChemistryTemplate.EnumChemistryTemplate.getEnum(stack.getItemDamage());
		
		if(chem.isDisabled())
			return output;
		
		switch(chem) {
        case FP_HEAVYOIL:
			output[0] = new FluidStack(RefineryRecipes.heavy_frac_bitu * 10, Fluids.BITUMEN);
			output[1] = new FluidStack(RefineryRecipes.heavy_frac_smear * 10, Fluids.SMEAR);
			break;
        case FP_SMEAR:
			output[0] = new FluidStack(RefineryRecipes.smear_frac_heat * 10, Fluids.HEATINGOIL);
			output[1] = new FluidStack(RefineryRecipes.smear_frac_lube * 10, Fluids.LUBRICANT);
			break;
        case FP_NAPHTHA:
			output[0] = new FluidStack(RefineryRecipes.napht_frac_heat * 10, Fluids.HEATINGOIL);
			output[1] = new FluidStack(RefineryRecipes.napht_frac_diesel * 10, Fluids.DIESEL);
			break;
        case FP_LIGHTOIL:
			output[0] = new FluidStack(RefineryRecipes.light_frac_diesel * 10, Fluids.DIESEL);
			output[1] = new FluidStack(RefineryRecipes.light_frac_kero * 10, Fluids.KEROSENE);
			break;
        case FR_REOIL:
			output[0] = new FluidStack(800, Fluids.RECLAIMED);
			break;
        case FR_PETROIL:
			output[0] = new FluidStack(1000, Fluids.PETROIL);
			break;
        case FC_BITUMEN:
			output[0] = new FluidStack(1000, Fluids.OIL);
			output[1] = new FluidStack(200, Fluids.PETROLEUM);
			break;
        case FC_I_NAPHTHA:
			output[0] = new FluidStack(800, Fluids.NAPHTHA);
			break;
        case FC_GAS_PETROLEUM:
			output[0] = new FluidStack(800, Fluids.PETROLEUM);
			break;
        case FC_DIESEL_KEROSENE:
			output[0] = new FluidStack(400, Fluids.KEROSENE);
			break;
        case FC_KEROSENE_PETROLEUM:
			output[0] = new FluidStack(800, Fluids.PETROLEUM);
			break;
        case CC_OIL:
			output[0] = new FluidStack(2000, Fluids.OIL);
			break;
        case CC_I:
			output[0] = new FluidStack(1600, Fluids.SMEAR);
			break;
        case CC_HEATING:
			output[0] = new FluidStack(1800, Fluids.HEATINGOIL);
			break;
        case CC_HEAVY:
			output[0] = new FluidStack(1800, Fluids.HEAVYOIL);
			break;
        case CC_NAPHTHA:
			output[0] = new FluidStack(2000, Fluids.NAPHTHA);
			break;
        case COOLANT:
			output[0] = new FluidStack(2000, Fluids.COOLANT);
			break;
        case CRYOGEL:
			output[0] = new FluidStack(2000, Fluids.CRYOGEL);
			break;
        case PEROXIDE:
			output[0] = new FluidStack(800, Fluids.ACID);
			break;
        case DEUTERIUM:
			output[0] = new FluidStack(500, Fluids.DEUTERIUM);
        	break;
        case STEAM:
			output[0] = new FluidStack(1000, Fluids.STEAM);
        	break;
        case BP_BIOGAS:
			output[0] = new FluidStack(4000, Fluids.BIOGAS);
        	break;
        case BP_BIOFUEL:
			output[0] = new FluidStack(1000, Fluids.BIOFUEL);
        	break;
        case LPG:
			output[0] = new FluidStack(1000, Fluids.LPG);
        	break;
        case UF6:
			output[0] = new FluidStack(1200, Fluids.UF6);
        	break;
        case PUF6:
			output[0] = new FluidStack(900, Fluids.PUF6);
        	break;
        case SAS3:
			output[0] = new FluidStack(1000, Fluids.SAS3);
        	break;
        case NITAN:
			output[0] = new FluidStack(1000, Fluids.NITAN);
        	break;
        case OIL_SAND:
			output[0] = new FluidStack(1000, Fluids.BITUMEN);
        	break;
        case DYN_SCHRAB:
			output[0] = new FluidStack(50, Fluids.WATZ);
        	break;
        case DYN_EUPH:
			output[0] = new FluidStack(100, Fluids.WATZ);
        	break;
        case DYN_DNT:
			output[0] = new FluidStack(150, Fluids.WATZ);
        	break;
        case ELECTROLYSIS:
			output[0] = new FluidStack(400, Fluids.HYDROGEN);
			output[1] = new FluidStack(400, Fluids.OXYGEN);
        	break;
        case XENON:
			output[0] = new FluidStack(50, Fluids.XENON);
        	break;
        case XENON_OXY:
			output[0] = new FluidStack(50, Fluids.XENON);
        	break;
        case BALEFIRE:
			output[0] = new FluidStack(8000, Fluids.BALEFIRE);
        	break;
        case SCHRABIDIC:
			output[0] = new FluidStack(16000, Fluids.SCHRABIDIC);
        	break;
        case COLTAN_CLEANING:
			output[0] = new FluidStack(500, Fluids.WATER);
        	break;
        case COLTAN_PAIN:
			output[0] = new FluidStack(1000, Fluids.PAIN);
        	break;
        case COLTAN_CRYSTAL:
			output[0] = new FluidStack(250, Fluids.WATER);
        	break;
        case GASOLINE:
			output[0] = new FluidStack(12000, Fluids.GASOLINE);
        	break;
        case FRACKSOL:
			output[0] = new FluidStack(1000, Fluids.FRACKSOL);
        	break;
        case HELIUM3:
			output[0] = new FluidStack(1000, Fluids.HELIUM3);
        	break;
        case OSMIRIDIUM_DEATH:
			output[0] = new FluidStack(1000, Fluids.DEATH);
        	break;
        case ETHANOL:
			output[0] = new FluidStack(1000, Fluids.ETHANOL);
        	break;
        case CO2:
        	output[0] = new FluidStack(1000, Fluids.CARBONDIOXIDE);
        	break;
        case HEAVY_ELECTROLYSIS:
        	output[0] = new FluidStack(400, Fluids.DEUTERIUM);
			output[1] = new FluidStack(400, Fluids.OXYGEN);
        	break;
		default:
			break;
		}
		
		return output;
	}
	
	public Map<Object, Object> getFluidContainers() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		for(FluidContainer con : FluidContainerRegistry.allContainers) {
			if(con != null) {
				ItemStack fluid = new ItemStack(ModItems.fluid_icon, 1, con.type.getID());
				fluid.stackTagCompound = new NBTTagCompound();
				fluid.stackTagCompound.setInteger("fill", con.content);
				map.put(fluid, con.fullContainer);
			}
		}
		
		return map;
	}
}
