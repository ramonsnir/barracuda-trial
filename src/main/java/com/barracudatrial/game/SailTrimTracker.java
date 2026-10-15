package com.barracudatrial.game;

import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.Player;
import net.runelite.api.WorldView;
import net.runelite.api.gameval.ObjectID;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Tracks the sail object of the boat the player is on, and whether it can currently be trimmed
 * (the sail shows its first menu option only while trimming is available)
 */
public class SailTrimTracker
{
	private static final Set<Integer> SAIL_IDS = Set.of(
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_1X3_LINEN,
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_1X3_CANVAS,
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_1X3_COTTON,
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_1X3_BLACK,
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_1X3_YELLOW,
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_1X3_PURPLE,
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_1X3_GREEN,
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_1X3_BLUE,
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_1X3_PINK,
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_1X3_RED,
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_2X5_LINEN,
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_2X5_CANVAS,
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_2X5_COTTON,
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_2X5_BLACK,
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_2X5_YELLOW,
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_2X5_PURPLE,
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_2X5_GREEN,
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_2X5_BLUE,
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_2X5_PINK,
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_2X5_RED,
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_3X8_LINEN,
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_3X8_CANVAS,
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_3X8_COTTON,
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_3X8_BLACK,
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_3X8_YELLOW,
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_3X8_PURPLE,
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_3X8_GREEN,
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_3X8_BLUE,
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_3X8_PINK,
		ObjectID.SAILING_BOAT_SAIL_KANDARIN_3X8_RED
	);

	private final Client client;
	private final Map<Integer, GameObject> sailsByWorldView = new HashMap<>();

	public SailTrimTracker(Client client)
	{
		this.client = client;
	}

	public void onGameObjectSpawned(GameObject gameObject)
	{
		WorldView worldView = gameObject.getWorldView();
		if (worldView != null && !worldView.isTopLevel() && SAIL_IDS.contains(gameObject.getId()))
		{
			sailsByWorldView.put(worldView.getId(), gameObject);
		}
	}

	public void onGameObjectDespawned(GameObject gameObject)
	{
		WorldView worldView = gameObject.getWorldView();
		if (worldView != null)
		{
			sailsByWorldView.remove(worldView.getId(), gameObject);
		}
	}

	public void clear()
	{
		sailsByWorldView.clear();
	}

	public boolean isTrimAvailable()
	{
		Player localPlayer = client.getLocalPlayer();
		if (localPlayer == null)
		{
			return false;
		}

		WorldView worldView = localPlayer.getWorldView();
		if (worldView == null || worldView.isTopLevel())
		{
			return false;
		}

		GameObject sail = sailsByWorldView.get(worldView.getId());
		return sail != null && sail.isOpShown(0);
	}
}
