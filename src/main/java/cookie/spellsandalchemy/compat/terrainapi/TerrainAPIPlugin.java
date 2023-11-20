package cookie.spellsandalchemy.compat.terrainapi;

import cookie.spellsandalchemy.SpellsAndAlchemy;
import useless.terrainapi.api.TerrainAPI;

public class TerrainAPIPlugin implements TerrainAPI {

	@Override
	public String getModID() {
		return SpellsAndAlchemy.MOD_ID;
	}

	@Override
	public void onInitialize() {
		new OverworldInitialization().init();
	}
}
