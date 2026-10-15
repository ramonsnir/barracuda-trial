package com.barracudatrial.game.route;
import com.barracudatrial.game.route.RouteWaypoint.WaypointType;
import net.runelite.api.coords.WorldPoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Static route data for Tempor Tantrum trial.
 *
 * Routes are hardcoded sequences of RouteWaypoints representing the optimal order
 * to complete objectives for each difficulty level. These routes were captured
 * during actual trial runs using the route capture system in debug mode.
 *
 * Each route contains:
 * - Lost Shipment locations in optimal collection order
 * - Rum pickup and dropoff waypoints at the correct points in sequence
 * - Coordinates are specific to the Tempor Tantrum trial layout
 * - Difficulty determines the number of laps (1, 2, or 3)
 *
 * The PathPlanner uses these routes to direct the player to the next uncompleted
 * waypoint in the sequence, with A* pathfinding handling tactical navigation
 * around clouds and rocks.
 */
public class TemporTantrumRoutes
{
	private static final WorldPoint RUM_PICKUP_LOCATION = new WorldPoint(3037, 2767, 0);
	private static final WorldPoint RUM_DROPOFF_LOCATION = new WorldPoint(3035, 2926, 0);

	private static final Map<Difficulty, List<RouteWaypoint>> ROUTES = new HashMap<>();

	private static final List<RouteWaypoint> FASTER_MARLIN_ROUTE = buildFasterMarlinRoute();

	static
	{
		// SWORDFISH difficulty - 1 lap, 14 shipments + rum pickup/dropoff
		// Captured 2025-11-21
		ROUTES.put(Difficulty.SWORDFISH, List.of(
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(2994, 2891, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(2978, 2866, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(2981, 2848, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(2978, 2828, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(2990, 2808, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3001, 2788, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3012, 2768, 0)),
			new RouteWaypoint(WaypointType.RUM_PICKUP, RUM_PICKUP_LOCATION),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3057, 2792, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3065, 2811, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3077, 2825, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3078, 2863, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3082, 2875, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3084, 2896, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3053, 2920, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3050, 2922, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3048, 2922, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3046, 2922, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3044, 2922, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3042, 2922, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3040, 2922, 0)),
			new RouteWaypoint(WaypointType.RUM_DROPOFF, RUM_DROPOFF_LOCATION)
		));

		// SHARK difficulty - 2 laps
		// Captured 2025-11-22
		ROUTES.put(Difficulty.SHARK, List.of(
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(2994, 2891, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(2978, 2866, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(2981, 2848, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(2978, 2828, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(2990, 2808, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3001, 2788, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3012, 2768, 0)),
			new RouteWaypoint(WaypointType.RUM_PICKUP, RUM_PICKUP_LOCATION),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3057, 2792, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3065, 2811, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3077, 2825, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3078, 2863, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3082, 2875, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3080, 2883, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3078, 2885, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3078, 2878, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3077, 2881, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3076, 2887, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3073, 2892, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3074, 2889, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3069, 2894, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3059, 2904, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3053, 2920, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3050, 2922, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3048, 2922, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3046, 2922, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3044, 2922, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3042, 2922, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3040, 2922, 0)),
			new RouteWaypoint(WaypointType.RUM_DROPOFF, RUM_DROPOFF_LOCATION),
			new RouteWaypoint(2, WaypointType.SHIPMENT, new WorldPoint(3018, 2889, 0)),
			new RouteWaypoint(2, WaypointType.SHIPMENT, new WorldPoint(3001, 2866, 0)),
			new RouteWaypoint(2, WaypointType.SHIPMENT, new WorldPoint(3004, 2834, 0)),
			new RouteWaypoint(2, WaypointType.SHIPMENT, new WorldPoint(3006, 2819, 0)),
			new RouteWaypoint(2, WaypointType.SHIPMENT, new WorldPoint(3028, 2789, 0)),
			new RouteWaypoint(2, WaypointType.RUM_PICKUP, RUM_PICKUP_LOCATION),
			new RouteWaypoint(2, WaypointType.SHIPMENT, new WorldPoint(3077, 2776, 0)),
			new RouteWaypoint(2, WaypointType.SHIPMENT, new WorldPoint(3082, 2801, 0)),
			new RouteWaypoint(2, WaypointType.SHIPMENT, new WorldPoint(3093, 2835, 0)),
			new RouteWaypoint(2, WaypointType.SHIPMENT, new WorldPoint(3093, 2882, 0)),
			new RouteWaypoint(2, WaypointType.SHIPMENT, new WorldPoint(3084, 2896, 0)),
			new RouteWaypoint(2, WaypointType.SHIPMENT, new WorldPoint(3079, 2906, 0)),
			new RouteWaypoint(2, WaypointType.PATHFINDING_HINT, new WorldPoint(3050, 2922, 0)),
			new RouteWaypoint(2, WaypointType.PATHFINDING_HINT, new WorldPoint(3048, 2922, 0)),
			new RouteWaypoint(2, WaypointType.PATHFINDING_HINT, new WorldPoint(3046, 2922, 0)),
			new RouteWaypoint(2, WaypointType.PATHFINDING_HINT, new WorldPoint(3044, 2922, 0)),
			new RouteWaypoint(2, WaypointType.PATHFINDING_HINT, new WorldPoint(3042, 2922, 0)),
			new RouteWaypoint(2, WaypointType.PATHFINDING_HINT, new WorldPoint(3040, 2922, 0)),
			new RouteWaypoint(2, WaypointType.RUM_DROPOFF, RUM_DROPOFF_LOCATION)
		));

		// MARLIN difficulty - 3 laps
		// Captured 2025-11-22
		ROUTES.put(Difficulty.MARLIN, List.of(
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3018, 2889, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3001, 2866, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3004, 2834, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3006, 2819, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3030, 2815, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3028, 2789, 0)),
			new RouteWaypoint(WaypointType.RUM_PICKUP, RUM_PICKUP_LOCATION),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3077, 2776, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3082, 2801, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3093, 2835, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3078, 2863, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3082, 2875, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3080, 2883, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3078, 2885, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3078, 2878, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3077, 2881, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3076, 2887, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3073, 2892, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3074, 2889, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3069, 2894, 0)),
			new RouteWaypoint(WaypointType.SHIPMENT, new WorldPoint(3059, 2904, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3050, 2922, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3048, 2922, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3046, 2922, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3044, 2922, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3042, 2922, 0)),
			new RouteWaypoint(WaypointType.PATHFINDING_HINT, new WorldPoint(3040, 2922, 0)),
			new RouteWaypoint(WaypointType.RUM_DROPOFF, RUM_DROPOFF_LOCATION),
			new RouteWaypoint(2, WaypointType.SHIPMENT, new WorldPoint(2994, 2891, 0)),
			new RouteWaypoint(2, WaypointType.SHIPMENT, new WorldPoint(2978, 2866, 0)),
			new RouteWaypoint(2, WaypointType.SHIPMENT, new WorldPoint(2981, 2848, 0)),
			new RouteWaypoint(2, WaypointType.SHIPMENT, new WorldPoint(2978, 2828, 0)),
			new RouteWaypoint(2, WaypointType.SHIPMENT, new WorldPoint(2990, 2808, 0)),
			new RouteWaypoint(2, WaypointType.SHIPMENT, new WorldPoint(3001, 2788, 0)),
			new RouteWaypoint(2, WaypointType.SHIPMENT, new WorldPoint(3012, 2768, 0)),
			new RouteWaypoint(2, WaypointType.RUM_PICKUP, RUM_PICKUP_LOCATION),
			new RouteWaypoint(2, WaypointType.SHIPMENT, new WorldPoint(3037, 2762, 0)),
			new RouteWaypoint(2, WaypointType.SHIPMENT, new WorldPoint(3057, 2792, 0)),
			new RouteWaypoint(2, WaypointType.SHIPMENT, new WorldPoint(3065, 2811, 0)),
			new RouteWaypoint(2, WaypointType.SHIPMENT, new WorldPoint(3077, 2825, 0)),
			new RouteWaypoint(2, WaypointType.SHIPMENT, new WorldPoint(3060, 2883, 0)),
			new RouteWaypoint(2, WaypointType.PATHFINDING_HINT, new WorldPoint(3050, 2922, 0)),
			new RouteWaypoint(2, WaypointType.PATHFINDING_HINT, new WorldPoint(3048, 2922, 0)),
			new RouteWaypoint(2, WaypointType.PATHFINDING_HINT, new WorldPoint(3046, 2922, 0)),
			new RouteWaypoint(2, WaypointType.PATHFINDING_HINT, new WorldPoint(3044, 2922, 0)),
			new RouteWaypoint(2, WaypointType.PATHFINDING_HINT, new WorldPoint(3042, 2922, 0)),
			new RouteWaypoint(2, WaypointType.PATHFINDING_HINT, new WorldPoint(3040, 2922, 0)),
			new RouteWaypoint(2, WaypointType.RUM_DROPOFF, RUM_DROPOFF_LOCATION),
			new RouteWaypoint(3, WaypointType.SHIPMENT, new WorldPoint(2963, 2882, 0)),
			new RouteWaypoint(3, WaypointType.SHIPMENT, new WorldPoint(2965, 2865, 0)),
			new RouteWaypoint(3, WaypointType.SHIPMENT, new WorldPoint(2957, 2829, 0)),
			new RouteWaypoint(3, WaypointType.SHIPMENT, new WorldPoint(2953, 2809, 0)),
			new RouteWaypoint(3, WaypointType.SHIPMENT, new WorldPoint(2966, 2795, 0)),
			new RouteWaypoint(3, WaypointType.SHIPMENT, new WorldPoint(2987, 2777, 0)),
			new RouteWaypoint(3, WaypointType.RUM_PICKUP, RUM_PICKUP_LOCATION),
			new RouteWaypoint(3, WaypointType.SHIPMENT, new WorldPoint(3095, 2775, 0)),
			new RouteWaypoint(3, WaypointType.SHIPMENT, new WorldPoint(3119, 2855, 0)),
			new RouteWaypoint(3, WaypointType.SHIPMENT, new WorldPoint(3093, 2882, 0)),
			new RouteWaypoint(3, WaypointType.SHIPMENT, new WorldPoint(3084, 2896, 0)),
			new RouteWaypoint(3, WaypointType.SHIPMENT, new WorldPoint(3079, 2906, 0)),
			new RouteWaypoint(3, WaypointType.SHIPMENT, new WorldPoint(3053, 2920, 0)),
			new RouteWaypoint(3, WaypointType.PATHFINDING_HINT, new WorldPoint(3050, 2922, 0)),
			new RouteWaypoint(3, WaypointType.PATHFINDING_HINT, new WorldPoint(3048, 2922, 0)),
			new RouteWaypoint(3, WaypointType.PATHFINDING_HINT, new WorldPoint(3046, 2922, 0)),
			new RouteWaypoint(3, WaypointType.PATHFINDING_HINT, new WorldPoint(3044, 2922, 0)),
			new RouteWaypoint(3, WaypointType.PATHFINDING_HINT, new WorldPoint(3042, 2922, 0)),
			new RouteWaypoint(3, WaypointType.PATHFINDING_HINT, new WorldPoint(3040, 2922, 0)),
			new RouteWaypoint(3, WaypointType.RUM_DROPOFF, RUM_DROPOFF_LOCATION)
		));
	}

	/**
	 * Get the wiki's "faster Marlin" route. Same 36 crates as the smoother route (the default MARLIN
	 * route above), split differently across the three laps.
	 * Crate tiles come from the wiki's route maps (https://oldschool.runescape.wiki/w/The_Tempor_Tantrum).
	 * Laps 1 and 2 finish from the east, so they get the usual delivery-lane hints; lap 3 finishes from
	 * the west, so it gets none (the lane is east of the delivery boat and would pull the path the wrong way).
	 */
	public static List<RouteWaypoint> getFasterMarlinRoute()
	{
		return FASTER_MARLIN_ROUTE;
	}

	private static List<RouteWaypoint> buildFasterMarlinRoute()
	{
		var route = new ArrayList<RouteWaypoint>();

		// Lap 1: 14 crates, rum pickup after the 5th (passed at a longer throw distance than on the smoother route)
		addShipments(route, 1, new int[][]{{3018, 2889}, {3001, 2866}, {3004, 2834}, {3006, 2819}, {3028, 2789}});
		route.add(new RouteWaypoint(1, WaypointType.RUM_PICKUP, RUM_PICKUP_LOCATION));
		addShipments(route, 1, new int[][]{{3077, 2776}});
		// The wiki line dips south through here between the 6th and 7th crates
		route.add(new RouteWaypoint(1, WaypointType.PATHFINDING_HINT, new WorldPoint(3087, 2769, 0)));
		addShipments(route, 1, new int[][]{{3095, 2775}, {3082, 2801}, {3093, 2835}, {3119, 2855},
			{3093, 2882}, {3084, 2896}, {3079, 2906}, {3053, 2920}});
		addDropoffApproachHints(route, 1);
		route.add(new RouteWaypoint(1, WaypointType.RUM_DROPOFF, RUM_DROPOFF_LOCATION));

		// Lap 2: 15 crates, rum pickup after the 7th
		addShipments(route, 2, new int[][]{{2994, 2891}, {2978, 2866}, {2981, 2848}, {2978, 2828}, {2990, 2808},
			{3001, 2788}, {3012, 2768}});
		route.add(new RouteWaypoint(2, WaypointType.RUM_PICKUP, RUM_PICKUP_LOCATION));
		addShipments(route, 2, new int[][]{{3037, 2762}, {3057, 2792}, {3065, 2811}, {3077, 2825}, {3078, 2863},
			{3082, 2875}, {3060, 2883}, {3059, 2904}});
		addDropoffApproachHints(route, 2);
		route.add(new RouteWaypoint(2, WaypointType.RUM_DROPOFF, RUM_DROPOFF_LOCATION));

		// Lap 3: 7 crates, rum pickup after the 1st, then back up the west side
		addShipments(route, 3, new int[][]{{3030, 2815}});
		route.add(new RouteWaypoint(3, WaypointType.RUM_PICKUP, RUM_PICKUP_LOCATION));
		addShipments(route, 3, new int[][]{{2987, 2777}, {2966, 2795}, {2953, 2809}, {2957, 2829}, {2965, 2865},
			{2963, 2882}});
		route.add(new RouteWaypoint(3, WaypointType.RUM_DROPOFF, RUM_DROPOFF_LOCATION));

		return List.copyOf(route);
	}

	private static void addShipments(List<RouteWaypoint> route, int lap, int[][] tiles)
	{
		for (int[] tile : tiles)
		{
			route.add(new RouteWaypoint(lap, WaypointType.SHIPMENT, new WorldPoint(tile[0], tile[1], 0)));
		}
	}

	// The same east-to-west lane into the delivery boat that the other routes use
	private static void addDropoffApproachHints(List<RouteWaypoint> route, int lap)
	{
		for (int x = 3050; x >= 3040; x -= 2)
		{
			route.add(new RouteWaypoint(lap, WaypointType.PATHFINDING_HINT, new WorldPoint(x, 2922, 0)));
		}
	}

	/**
	 * Get the static route for a given difficulty.
	 * @param difficulty The difficulty level
	 * @return List of RouteWaypoints representing the optimal waypoint sequence,
	 *         or empty list if no route is defined for this difficulty
	 */
	public static List<RouteWaypoint> getRoute(Difficulty difficulty)
	{
		return ROUTES.getOrDefault(difficulty, new ArrayList<>());
	}
}
