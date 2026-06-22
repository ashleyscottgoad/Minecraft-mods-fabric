# Tutorial Mod — Fabric Minecraft Mod

A starter Fabric mod for Minecraft 1.21.4 built to learn Java modding.
Currently includes one custom item: the **Lucky Stone**.

---

## What's in Here

```
src/main/java/.../TutorialMod.java     ← mod entry point (start here)
src/main/java/.../ModItems.java        ← register new items here

src/main/resources/
  fabric.mod.json                      ← mod name, version, ID
  assets/tutorialmod/
    lang/en_us.json                    ← display names (e.g. "Lucky Stone")
    models/item/lucky_stone.json       ← tells Minecraft what shape the item is
    textures/item/                     ← put your 16x16 PNG textures here
```

---

## Setup

### Requirements
- **Java 21 JDK** — download from https://adoptium.net (Temurin 21 LTS)
- **IntelliJ IDEA Community** — download from https://www.jetbrains.com/idea/download/

### First-time setup

1. Clone this repo
2. Open the folder in IntelliJ IDEA — it detects the Gradle project automatically
3. IntelliJ will import the project (takes a few minutes the first time — it downloads Minecraft assets)
4. Once imported, open the **Gradle panel** (right side of IntelliJ) and run:
   `Tasks → fabric → runClient`

> **Command line users:** you need the Gradle wrapper JAR to use `./gradlew`.
> Run `gradle wrapper --gradle-version 8.11.1` once after cloning (requires Gradle installed globally),
> then use `./gradlew runClient` as normal.

---

## Running the Mod

From the IntelliJ Gradle panel:
- **`runClient`** — launches Minecraft with your mod loaded (main dev loop)
- **`build`** — produces a `.jar` in `build/libs/` you can drop into a mods folder

---

## How to Add a New Item

This is the main thing you'll want to try first.

### 1. Register the item in `ModItems.java`

```java
public static final Item MY_ITEM = register("my_item",
        new Item(new Item.Settings()));
```

### 2. Add a display name in `en_us.json`

```json
"item.tutorialmod.my_item": "My Item"
```

### 3. Create a model file at `models/item/my_item.json`

```json
{
  "parent": "item/generated",
  "textures": {
    "layer0": "tutorialmod:item/my_item"
  }
}
```

### 4. Add a texture

Place a **16x16 PNG** at:
```
src/main/resources/assets/tutorialmod/textures/item/my_item.png
```

You can draw one in Paint, Aseprite, or any pixel editor.
Without a texture the item still works — it just shows a purple/black checkerboard.

### 5. Add it to the creative menu in `TutorialMod.java`

```java
entries.add(ModItems.MY_ITEM);
```

---

## Learning Resources

| Resource | Link |
|---|---|
| Fabric Wiki (the authoritative guide) | https://fabricmc.net/wiki/ |
| Kaupenjoe YouTube tutorials | Search "Kaupenjoe Fabric 1.21" on YouTube |
| Fabric Discord | https://discord.gg/v6v4pMv |

---

## Version info

| Thing | Version |
|---|---|
| Minecraft | 1.21.4 |
| Java | 21 |
| Fabric Loader | 0.16.9 |
| Fabric API | 0.114.0+1.21.4 |

To update versions, edit `gradle.properties`. Check https://fabricmc.net/develop/ for the latest.
