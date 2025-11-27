# CreeperBeGone

Keep creepers permanently “fused” so they never explode. No commands, no configs — just drop it in.

## Features
- Cancels creeper explosions globally (server-wide), without touching other explosions (TNT, beds, etc.).
- Keeps creepers in a visual fused/ignited state (they hiss and pursue) but never detonate.
- No configuration or commands required.
- Lightweight: a single listener on explosion priming.

## Requirements
- Paper (Minecraft 1.21.10)
- Java 21

## Installation
1. Download the JAR (or build from source, see below).
2. Place it into your server’s `plugins` folder.
3. Start or restart the server.

That’s it — all creepers will stay fused and won’t explode.

## How it works
The plugin listens for `ExplosionPrimeEvent` and, when the entity is a creeper:
- Cancels the explosion.
- Sets a very long fuse (`setMaxFuseTicks(...)`) and keeps the fuse near “ignited” (`setFuseTicks(1)`).
- Optionally sets `setExplosionRadius(0)` as a safety guard.

Result: creepers hiss and chase but never detonate; no block damage, no explosion damage, no drops from explosions.

## Build from source
Prereqs: Java 21, Gradle.

```bash
cd CreeperBeGone
gradle build
```

The JAR will be in `CreeperBeGone/build/libs/`. To copy directly to a sibling test server folder:

```bash
gradle copyToServer
```

This places the JAR into `../server/plugins`.

## Compatibility notes
- Only affects creepers. TNT, bed explosions, respawn anchors, etc. are not modified.
- Designed for modern Paper 1.21.10 — older versions are not supported by this build.

## Troubleshooting
- Creepers still explode:
  - Check for conflicting plugins that force explosions.
  - Verify the plugin is loaded (`/plugins`) and not disabled/renamed.
  - Ensure you’re running a compatible Paper build and Java 21.
- Performance issues:
  - This plugin is minimal and event-driven; performance impact should be negligible.

## License
Add a license file of your choice (e.g., MIT) to this repository (not included by default).




