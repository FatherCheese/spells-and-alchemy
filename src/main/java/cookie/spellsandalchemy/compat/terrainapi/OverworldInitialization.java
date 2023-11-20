package cookie.spellsandalchemy.compat.terrainapi;

import cookie.spellsandalchemy.block.SAABlocks;
import useless.terrainapi.generation.overworld.api.ChunkDecoratorOverworldAPI;
import useless.terrainapi.initialization.BaseInitialization;

import static cookie.spellsandalchemy.SpellsAndAlchemy.MOD_ID;

public class OverworldInitialization extends BaseInitialization {

	@Override
	protected void initValues() {

	}

	@Override
	protected void initStructure() {

	}

	@Override
	protected void initOre() {
		ChunkDecoratorOverworldAPI.oreFeatures.addManagedOreFeature(MOD_ID, SAABlocks.oreCinnabarStone, 4, 10, 1/3f, true);
	}

	@Override
	protected void initRandom() {

	}

	@Override
	protected void initBiome() {

	}
}
