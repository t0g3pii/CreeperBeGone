package de.t0g3pii.creeperbegone;

import org.bukkit.entity.Creeper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public class CreeperListener implements Listener {

	@EventHandler
	public void onCreeperPrime(ExplosionPrimeEvent event) {
		if (event.getEntity() instanceof Creeper) {
			// Prevent the actual explosion from occurring.
			event.setCancelled(true);
			// Keep the creeper visually in a fused state afterwards.
			Creeper creeper = (Creeper) event.getEntity();
			int veryLong = 20 * 60 * 60; // 1 hour in ticks
			try {
				creeper.setMaxFuseTicks(veryLong);
			} catch (Throwable ignored) {
			}
			try {
				creeper.setFuseTicks(1);
			} catch (Throwable ignored) {
			}
			try {
				creeper.setExplosionRadius(0);
			} catch (Throwable ignored) {
			}
		}
	}
}

