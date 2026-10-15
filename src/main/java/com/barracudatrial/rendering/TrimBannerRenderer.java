package com.barracudatrial.rendering;

import com.barracudatrial.BarracudaTrialPlugin;
import lombok.RequiredArgsConstructor;
import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;

import java.awt.*;

/**
 * Draws large pulsing "TRIM" banners when the sails can be trimmed:
 * one at the top of the screen and one under the ship
 */
@RequiredArgsConstructor
public class TrimBannerRenderer
{
	private static final String TEXT = "TRIM";
	private static final double PULSE_PERIOD_MS = 700;
	private static final int TOP_BANNER_FONT_SIZE = 64;
	private static final int TOP_BANNER_MARGIN_Y = 24;
	private static final int SHIP_BANNER_FONT_SIZE = 44;
	private static final int SHIP_BANNER_OFFSET_Y = 90;

	private final Client client;
	private final BarracudaTrialPlugin plugin;

	public void render(Graphics2D graphics)
	{
		Color baseColor = plugin.getCachedConfig().getTrimColor();
		double pulse = 0.5 + 0.5 * Math.sin(System.currentTimeMillis() * 2 * Math.PI / PULSE_PERIOD_MS);

		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		drawBanner(graphics, client.getCanvasWidth() / 2, TOP_BANNER_MARGIN_Y, TOP_BANNER_FONT_SIZE, baseColor, pulse);

		net.runelite.api.Point shipPoint = getShipCanvasPoint();
		if (shipPoint != null)
		{
			drawBanner(graphics, shipPoint.getX(), shipPoint.getY() + SHIP_BANNER_OFFSET_Y, SHIP_BANNER_FONT_SIZE, baseColor, pulse);
		}
	}

	private net.runelite.api.Point getShipCanvasPoint()
	{
		Player localPlayer = client.getLocalPlayer();
		WorldView topLevelWorldView = client.getTopLevelWorldView();
		if (localPlayer == null || topLevelWorldView == null)
		{
			return null;
		}

		int boatWorldViewId = localPlayer.getWorldView().getId();
		for (WorldEntity worldEntity : topLevelWorldView.worldEntities())
		{
			if (worldEntity.getWorldView().getId() != boatWorldViewId)
			{
				continue;
			}

			LocalPoint boatLocation = worldEntity.getLocalLocation();
			if (boatLocation == null)
			{
				return null;
			}

			return Perspective.localToCanvas(client, boatLocation, topLevelWorldView.getPlane(), 0);
		}

		return null;
	}

	/** Draws the banner horizontally centered on centerX, with its top edge at topY */
	private void drawBanner(Graphics2D graphics, int centerX, int topY, int fontSize, Color baseColor, double pulse)
	{
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, fontSize);
		graphics.setFont(font);
		FontMetrics metrics = graphics.getFontMetrics();

		int paddingX = fontSize / 2;
		int paddingY = fontSize / 4;
		int width = metrics.stringWidth(TEXT) + paddingX * 2;
		int height = metrics.getAscent() + metrics.getDescent() + paddingY * 2;
		int x = centerX - width / 2;

		int fillAlpha = (int) (110 + 145 * pulse);
		graphics.setColor(new Color(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue(), fillAlpha));
		graphics.fillRoundRect(x, topY, width, height, height / 3, height / 3);

		graphics.setStroke(new BasicStroke(Math.max(3, fontSize / 12f)));
		graphics.setColor(Color.BLACK);
		graphics.drawRoundRect(x, topY, width, height, height / 3, height / 3);

		graphics.drawString(TEXT, x + paddingX, topY + paddingY + metrics.getAscent());
	}
}
