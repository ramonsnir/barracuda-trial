package com.barracudatrial;

/**
 * Which of the wiki's two Marlin routes to use in The Tempor Tantrum
 */
public enum TemporMarlinRoute
{
	SMOOTHER("Smoother"),
	FASTER("Faster");

	private final String displayName;

	TemporMarlinRoute(String displayName)
	{
		this.displayName = displayName;
	}

	@Override
	public String toString()
	{
		return displayName;
	}
}
