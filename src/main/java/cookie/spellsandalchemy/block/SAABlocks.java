package cookie.spellsandalchemy.block;

import cookie.spellsandalchemy.SAATags;
import cookie.spellsandalchemy.SpellsAndAlchemy;
import cookie.spellsandalchemy.block.flowers.BlockFlowerBlossomite;
import cookie.spellsandalchemy.block.flowers.BlockFlowerNetherbell;
import cookie.spellsandalchemy.block.planters.BlockPlanterBox;
import cookie.spellsandalchemy.block.planters.BlockPlanterDirt;
import cookie.spellsandalchemy.block.planters.BlockPlanterSand;
import cookie.spellsandalchemy.block.planters.BlockPlanterSoulsand;
import cookie.spellsandalchemy.block.tank.BlockMagicTank;
import cookie.spellsandalchemy.block.tank.entity.TileEntityMagicTank;
import cookie.spellsandalchemy.block.tank.metastate.TankMetaStateInterpreter;
import net.minecraft.client.render.block.model.BlockModelRenderBlocks;
import net.minecraft.client.sound.block.BlockSounds;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.EntityHelper;
import useless.dragonfly.helper.ModelHelper;
import useless.dragonfly.model.block.BlockModelDragonFly;

public class SAABlocks {
	private int blockID = 1450;
	private int nextBlockID() {
		return ++blockID;
	}

	public static Block oreCinnabarStone;
	public static Block oreCinnabarBasalt;
	public static Block oreCinnabarLimestone;
	public static Block oreCinnabarGranite;
	public static Block planterBox;
	public static Block planterBoxDirt;
	public static Block planterBoxSand;
	public static Block planterBoxSoulsand;
	public static Block magicTank;
	public static Block flowerNature;
	public static Block flowerNether;

	private void addTagsToBlock() {
		Block.soulsand.withTags(SAATags.NETHER_GROWTH);
	}

	private void addMappings() {
		EntityHelper.createTileEntity(TileEntityMagicTank.class, "MagicTank");
	}

	public void initializeBlocks() {
		String MOD_ID = SpellsAndAlchemy.MOD_ID;

		BlockBuilder oreBuilder = new BlockBuilder(MOD_ID)
			.setBlockSound(BlockSounds.STONE)
			.setHardness(3.0F)
			.setResistance(5.0F);

		BlockBuilder planterBuilder = new BlockBuilder(MOD_ID)
			.setSideTextures("planterbox_sides.png")
			.setBottomTexture(9, 1)
			.setBlockSound(BlockSounds.WOOD)
			.setHardness(2.0F);

		BlockBuilder flowerBuilder = new BlockBuilder(MOD_ID)
			.setBlockSound(BlockSounds.GRASS)
			.setBlockModel(new BlockModelRenderBlocks(1));

		oreCinnabarStone = oreBuilder
			.setTextures("ore_cinnabar_stone.png")
			.build(new BlockOreCinnabar("ore.cinnabar.stone", nextBlockID(), Material.stone))
			.withTags(BlockTags.MINEABLE_BY_PICKAXE);
		oreCinnabarBasalt = oreBuilder
			.setTextures("ore_cinnabar_basalt.png")
			.build(new BlockOreCinnabar("ore.cinnabar.basalt", nextBlockID(), Material.stone))
			.withTags(BlockTags.MINEABLE_BY_PICKAXE);
		oreCinnabarLimestone = oreBuilder
			.setTextures("ore_cinnabar_limestone.png")
			.build(new BlockOreCinnabar("ore.cinnabar.limestone", nextBlockID(), Material.stone))
			.withTags(BlockTags.MINEABLE_BY_PICKAXE);
		oreCinnabarGranite = oreBuilder
			.setTextures("ore_cinnabar_granite.png")
			.build(new BlockOreCinnabar("ore.cinnabar.granite", nextBlockID(), Material.stone))
			.withTags(BlockTags.MINEABLE_BY_PICKAXE);

		planterBox = planterBuilder
			.setTopTexture("planterbox_top.png")
			.build(new BlockPlanterBox("planterbox", nextBlockID()))
			.withTags(BlockTags.MINEABLE_BY_AXE);
		planterBoxDirt = planterBuilder
			.setTopTexture("planterbox_dirt.png")
			.build(new BlockPlanterDirt("planterbox.dirt", nextBlockID()))
			.withTags(BlockTags.MINEABLE_BY_AXE, BlockTags.GROWS_FLOWERS);
		planterBoxSand = planterBuilder
			.setTopTexture("planterbox_sand.png")
			.build(new BlockPlanterSand("planterbox.sand", nextBlockID()))
			.withTags(BlockTags.MINEABLE_BY_AXE);
		planterBoxSoulsand = planterBuilder
			.setTopTexture("planterbox_soulsand.png")
			.build(new BlockPlanterSoulsand("planterbox.soulsand", nextBlockID()))
			.withTags(BlockTags.MINEABLE_BY_AXE, SAATags.NETHER_GROWTH);

		magicTank = new BlockBuilder(MOD_ID)
			.setBlockSound(BlockSounds.GLASS)
			.setHardness(0.5f)
			.setBlockModel(new BlockModelDragonFly(ModelHelper.getOrCreateBlockModel(MOD_ID,
				"block/magic_tank.json"),
				ModelHelper.getOrCreateBlockState(MOD_ID, "magic_tank.json"),
				new TankMetaStateInterpreter(), true, 0.25F))
			.build(new BlockMagicTank("tank.magic", nextBlockID()))
			.withTags(BlockTags.MINEABLE_BY_PICKAXE);

		flowerNature = flowerBuilder
			.setTextures("flower_magic_blossom.png")
			.build(new BlockFlowerBlossomite("flower.blossomite", nextBlockID()))
			.withTags(BlockTags.BROKEN_BY_FLUIDS)
			.setTickOnLoad(true);
		flowerNether = flowerBuilder
			.setTextures("flower_netherbell.png")
			.build(new BlockFlowerNetherbell("flower.netherbell", nextBlockID()))
			.withTags(BlockTags.BROKEN_BY_FLUIDS)
			.setTickOnLoad(true);

		addMappings();
		addTagsToBlock();
	}
}
