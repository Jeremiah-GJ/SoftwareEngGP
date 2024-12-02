package final_proj;

import java.util.ArrayList;

public class Temp {

    public static void main(String[] args) {
        // Create the cards for each deck
        ArrayList<Card> deck1Cards = new ArrayList<>();
        ArrayList<Card> deck2Cards = new ArrayList<>();
        ArrayList<Card> deck3Cards = new ArrayList<>();
        ArrayList<Card> deck4Cards = new ArrayList<>();

        // Deck 1: Yugi
        deck1Cards.add(new Card(1, "Exodia the Forbidden One", "Monster", "Exodia Head.jpg"));
        deck1Cards.add(new Card(2, "Right Arm of the Forbidden One", "Monster", "Exodia Right Arm.jpg"));
        deck1Cards.add(new Card(3, "Left Arm of the Forbidden One", "Monster", "Exodia Left Arm.jpg"));
        deck1Cards.add(new Card(4, "Right Leg of the Forbidden One", "Monster", "Exodia Right Leg.jpg"));
        deck1Cards.add(new Card(5, "Left Leg of the Forbidden One", "Monster", "Exodia Left Leg.jpg"));
        deck1Cards.add(new Card(6, "Dark Magician", "Monster", "Dark Magician.jpg"));
        deck1Cards.add(new Card(7, "Dark Magician", "Monster", "Dark Magician.jpg"));
        deck1Cards.add(new Card(8, "Dark Magician Girl", "Monster", "Dark Magician Girl.jpg"));
        deck1Cards.add(new Card(9, "Summoned Skull", "Monster", "Summoned Skull.jpg"));
        deck1Cards.add(new Card(10, "Curse of Dragon", "Monster", "Curse of Dragon.jpg"));
        deck1Cards.add(new Card(11, "Gaia the Fierce Knight", "Monster", "Gaia the Fierce Knight.jpg"));
        deck1Cards.add(new Card(12, "Celtic Guardian", "Monster", "Celtic Guardian.jpg"));
        deck1Cards.add(new Card(13, "Obnoxious Celtic Guardian", "Monster", "Obnoxious Celtic Guardian.jpg"));
        deck1Cards.add(new Card(14, "Alpha the Magnet Warrior", "Monster", "Alpha the Magnet Warrior.jpg"));
        deck1Cards.add(new Card(15, "Beta the Magnet Warrior", "Monster", "Beta the Magnet Warrior.jpg"));
        deck1Cards.add(new Card(16, "Gamma the Magnet Warrior", "Monster", "Gamma the Magnet Warrior"));
        deck1Cards.add(new Card(17, "Valkyrion the Magna Warrior", "Monster", "Valkyrion the Magna Warior"));
        deck1Cards.add(new Card(18, "Buster Blader", "Monster", "Buster Blader.jpg"));
        deck1Cards.add(new Card(19, "Mirror Force", "Trap", "Mirror Force.jpg"));
        deck1Cards.add(new Card(20, "Dark Magic Attack", "Spell", "Dark Magic Attack.jpg"));
        deck1Cards.add(new Card(21, "Magic Cylinder", "Trap", "Magic Cylinder.jpg"));
        deck1Cards.add(new Card(22, "Thousand Knives", "Spell", "Thousand Knives.jpg"));
        deck1Cards.add(new Card(23, "Trap Hole", "Trap", "Trap Hole.jpg"));
        deck1Cards.add(new Card(24, "Swift Gaia the Fierce Knight", "Monster", "Swift Gaia the Fierce Knight.jpg"));
        deck1Cards.add(new Card(25, "Upstart Goblin", "Spell", "Upstart Goblin.jpg"));

        // Deck 2: Joey Wheeler
        deck2Cards.add(new Card(26, "Red Eyes Black Dragon", "Monster", "Red Eyes Black Dragon.jpg"));
        deck2Cards.add(new Card(27, "Swamp Battleguard", "Monster", "Swamp Battleguard.jpg"));
        deck2Cards.add(new Card(28, "Lava Battleguard", "Monster", "Lava Battleguard.jpg"));
        deck2Cards.add(new Card(29, "Armored Lizard", "Monster", "Armored Lizard.jpg"));
        deck2Cards.add(new Card(30, "Armored Lizard", "Monster", "Armored Lizard.jpg"));
        deck2Cards.add(new Card(31, "Garoozis", "Monster", "Garoozis.jpg"));
        deck2Cards.add(new Card(32, "Garoozis", "Monster", "Garoozis.jpg"));
        deck2Cards.add(new Card(33, "Kojikocy", "Monster", "Garoozis.jpg"));
        deck2Cards.add(new Card(34, "Rude Kaiser", "Monster", "Rude Kaiser.jpg"));
        deck2Cards.add(new Card(35, "Tiger Axe", "Monster", "Tiger Axe.jpg"));
        deck2Cards.add(new Card(36, "Tiger Axe", "Monster", "Tiger Axe.jpg"));
        deck2Cards.add(new Card(37, "Masaki the Legendary Swordsman", "Monster", "Masaki the Legendary Swordsman.jpg"));
        deck2Cards.add(new Card(38, "Masaki the Legendary Swordsman", "Monster", "Masaki the Legendary Swordsman.jpg"));
        deck2Cards.add(new Card(39, "Copycat", "Monster", "Copycat.jpg"));
        deck2Cards.add(new Card(40, "Axe Raider", "Monster", "Axe Raider.jpg"));
        deck2Cards.add(new Card(41, "Trap Hole of Spikes", "Trap", "Trap Hole of Spikes.jpg"));
        deck2Cards.add(new Card(42, "Trap Hole of Spikes", "Trap", "Trap Hole of Spikes.jpg"));
        deck2Cards.add(new Card(43, "Shield and Sword", "Spell", "Shield and Sword.jpg"));
        deck2Cards.add(new Card(44, "Shield and Sword", "Spell", "Shield and Sword.jpg"));
        deck2Cards.add(new Card(45, "Salamandra", "Spell", "Salamandra.jpg"));

        // Deck 3: Seto Kaiba
        deck3Cards.add(new Card(46, "Blue Eyes White Dragon", "Monster", "BlueEyesWhiteDragon.jpg"));
        deck3Cards.add(new Card(47, "Blue Eyes White Dragon", "Monster", "BlueEyesWhiteDragon.jpg"));
        deck3Cards.add(new Card(48, "Blue Eyes White Dragon", "Monster", "BlueEyesWhiteDragon.jpg"));
        deck3Cards.add(new Card(49, "La Jinn the Mystical Genie of the Lamp", "Monster", "LaJinnTheMysticalGenieOfTheLamp.jpg"));
        deck3Cards.add(new Card(50, "Battle Ox", "Monster", "BattleOx.jpg"));
        deck3Cards.add(new Card(51, "Saggi the Dark Clown", "Monster", "SaggiTheDarkClown.jpg"));
        deck3Cards.add(new Card(52, "Hitotsu-Me Giant", "Monster", "Hitsotsu-MeGiant.jpg"));
        deck3Cards.add(new Card(53, "Luster Dragon", "Monster", "LusterDragon.jpg"));
        deck3Cards.add(new Card(54, "Luster Dragon", "Monster", "LusterDragon.jpg"));
        deck3Cards.add(new Card(55, "Lord of D", "Monster", "LordOfD.jpg"));
        deck3Cards.add(new Card(56, "Ryu-Kishin", "Monster", "Ryu-Kishin.jpg"));
        deck3Cards.add(new Card(57, "Ryu-Kishin Powered", "Monster", "Ryu-KishinPowered.jpg"));
        deck3Cards.add(new Card(58, "Alexandrite Dragon", "Monster", "AlexandriteDragon.jpg"));
        deck3Cards.add(new Card(59, "Luster Dragon #2", "Monster", "LusterDragon#2.jpg"));
        deck3Cards.add(new Card(60, "Flute of Summoning Dragon", "Spell", "FluteOfSummoningDragon.jpg"));
        deck3Cards.add(new Card(61, "Negate Attack", "Trap", "NegateAttack.jpg"));
        deck3Cards.add(new Card(62, "Shadow Spell", "Trap", "ShadowSpell.jpg"));
        deck3Cards.add(new Card(63, "Remove Trap", "Spell", "RemoveTrap.jpg"));
        deck3Cards.add(new Card(64, "De-Spell", "Spell", "De-Spell.jpg"));
        deck3Cards.add(new Card(65, "Reverse Trap", "Trap", "ReverseTrap.jpg"));

        // Deck 4: Weevil Underwood
        deck4Cards.add(new Card(66, "Perfectly Ultimate Great Moth", "Monster", "PerfectlyUltimateGreatMoth.jpg"));
        deck4Cards.add(new Card(67, "Great Moth", "Monster", "GreatMoth.jpg"));
        deck4Cards.add(new Card(68, "Cocoon of Evolution", "Monster", "CocoonOfEvolution.jpg"));
        deck4Cards.add(new Card(69, "Petit Moth", "Monster", "PetitMoth.jpg"));
        deck4Cards.add(new Card(70, "Basic Insect", "Monster", "BasicInstinct.jpg"));
        deck4Cards.add(new Card(71, "Leghul", "Monster", "Leghul.jpg"));
        deck4Cards.add(new Card(72, "Metal Armored Bug", "Monster", "MetalArmoredBug.jpg"));
        deck4Cards.add(new Card(73, "Empress Mantis", "Monster", "EmpressMantis.jpg"));
        deck4Cards.add(new Card(74, "Flying Kamakiri #2", "Monster", "FlyingKamakiri#2.jpg"));
        deck4Cards.add(new Card(75, "Giant Flea", "Monster", "GiantFlea.jpg"));
        deck4Cards.add(new Card(76, "Neo Bug", "Monster", "NeoBug.jpg"));
        deck4Cards.add(new Card(77, "Insect Soldiers of the Sky", "Monster", "InsectSoldiersOfTheSky.jpg"));
        deck4Cards.add(new Card(78, "Killer Needle", "Monster", "KillerNeedle.jpg"));
        deck4Cards.add(new Card(79, "Insect Armor with Laser Cannon", "Spell", "InsectArmorWithLaserCannon.jpg"));
        deck4Cards.add(new Card(80, "Insect Armor with Laser Cannon", "Spell", "InsectArmorWithLaserCannon.jpg"));
        deck4Cards.add(new Card(81, "Laser Cannon Armor", "Spell", "LaserCannonArmor.jpg"));
        deck4Cards.add(new Card(82, "Laser Cannon Armor", "Spell", "LaserCannonArmor.jpg"));
        deck4Cards.add(new Card(83, "De-Spell", "Spell", "De-Spell.jpg"));
        deck4Cards.add(new Card(84, "Mirror Force", "Trap", "Mirror Force.jpg"));
        deck4Cards.add(new Card(85, "Trap Hole", "Trap", "Trap Hole.jpg"));

        // Create Deck objects
        Deck deck1 = new Deck(deck1Cards);
        Deck deck2 = new Deck(deck2Cards);
        Deck deck3 = new Deck(deck3Cards);
        Deck deck4 = new Deck(deck4Cards);

        // Example: Print size of each deck
        System.out.println("Deck 1 size: " + deck1.getLen());
        System.out.println("Deck 2 size: " + deck2.getLen());
        System.out.println("Deck 3 size: " + deck3.getLen());
        System.out.println("Deck 4 size: " + deck4.getLen());
    }
}
