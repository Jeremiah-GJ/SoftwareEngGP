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
        deck1Cards.add(new Card(1, "Exodia the Forbidden One", "Monster"));
        deck1Cards.add(new Card(2, "Right Arm of the Forbidden One", "Monster"));
        deck1Cards.add(new Card(3, "Left Arm of the Forbidden One", "Monster"));
        deck1Cards.add(new Card(4, "Right Leg of the Forbidden One", "Monster"));
        deck1Cards.add(new Card(5, "Left Leg of the Forbidden One", "Monster"));
        deck1Cards.add(new Card(6, "Dark Magician", "Monster"));
        deck1Cards.add(new Card(7, "Dark Magician", "Monster"));
        deck1Cards.add(new Card(8, "Dark Magician Girl", "Monster"));
        deck1Cards.add(new Card(9, "Summoned Skull", "Monster"));
        deck1Cards.add(new Card(10, "Curse of Dragon", "Monster"));
        deck1Cards.add(new Card(11, "Gaia the Fierce Knight", "Monster"));
        deck1Cards.add(new Card(12, "Celtic Guardian", "Monster"));
        deck1Cards.add(new Card(13, "Obnoxious Celtic Guardian", "Monster"));
        deck1Cards.add(new Card(14, "Alpha the Magnet Warrior", "Monster"));
        deck1Cards.add(new Card(15, "Beta the Magnet Warrior", "Monster"));
        deck1Cards.add(new Card(16, "Gamma the Magnet Warrior", "Monster"));
        deck1Cards.add(new Card(17, "Valkyrion the Magnet Warrior", "Monster"));
        deck1Cards.add(new Card(18, "Buster Blader", "Monster"));
        deck1Cards.add(new Card(19, "Mirror Force", "Trap"));
        deck1Cards.add(new Card(20, "Dark Magic Attack", "Spell"));
        deck1Cards.add(new Card(21, "Magic Cylinder", "Trap"));
        deck1Cards.add(new Card(22, "Thousand Knives", "Spell"));
        deck1Cards.add(new Card(23, "Trap Hole", "Trap"));
        deck1Cards.add(new Card(24, "Swift Gaia the Fierce Knight", "Monster"));
        deck1Cards.add(new Card(25, "Upstart Goblin", "Spell"));

        // Deck 2: Joey Wheeler
        deck2Cards.add(new Card(26, "Red Eyes Black Dragon", "Monster"));
        deck2Cards.add(new Card(27, "Swamp Battleguard", "Monster"));
        deck2Cards.add(new Card(28, "Lava Battleguard", "Monster"));
        deck2Cards.add(new Card(29, "Armored Lizard", "Monster"));
        deck2Cards.add(new Card(30, "Armored Lizard", "Monster"));
        deck2Cards.add(new Card(31, "Garoozis", "Monster"));
        deck2Cards.add(new Card(32, "Garoozis", "Monster"));
        deck2Cards.add(new Card(33, "Kojikocy", "Monster"));
        deck2Cards.add(new Card(34, "Rude Kaiser", "Monster"));
        deck2Cards.add(new Card(35, "Tiger Axe", "Monster"));
        deck2Cards.add(new Card(36, "Tiger Axe", "Monster"));
        deck2Cards.add(new Card(37, "Masaki the Legendary Swordsman", "Monster"));
        deck2Cards.add(new Card(38, "Masaki the Legendary Swordsman", "Monster"));
        deck2Cards.add(new Card(39, "Copycat", "Monster"));
        deck2Cards.add(new Card(40, "Axe Raider", "Monster"));
        deck2Cards.add(new Card(41, "Trap Hole of Spikes", "Trap"));
        deck2Cards.add(new Card(42, "Trap Hole of Spikes", "Trap"));
        deck2Cards.add(new Card(43, "Shield and Sword", "Spell"));
        deck2Cards.add(new Card(44, "Shield and Sword", "Spell"));
        deck2Cards.add(new Card(45, "Salamandra", "Spell"));

        // Deck 3: Seto Kaiba
        deck3Cards.add(new Card(46, "Blue Eyes White Dragon", "Monster"));
        deck3Cards.add(new Card(47, "Blue Eyes White Dragon", "Monster"));
        deck3Cards.add(new Card(48, "Blue Eyes White Dragon", "Monster"));
        deck3Cards.add(new Card(49, "La Jinn the Mystical Genie of the Lamp", "Monster"));
        deck3Cards.add(new Card(50, "Battle Ox", "Monster"));
        deck3Cards.add(new Card(51, "Saggi the Dark Clown", "Monster"));
        deck3Cards.add(new Card(52, "Hitotsu-Me Giant", "Monster"));
        deck3Cards.add(new Card(53, "Luster Dragon", "Monster"));
        deck3Cards.add(new Card(54, "Luster Dragon", "Monster"));
        deck3Cards.add(new Card(55, "Lord of D", "Monster"));
        deck3Cards.add(new Card(56, "Ryu-Kishin", "Monster"));
        deck3Cards.add(new Card(57, "Ryu-Kishin Powered", "Monster"));
        deck3Cards.add(new Card(58, "Alexandrite Dragon", "Monster"));
        deck3Cards.add(new Card(59, "Luster Dragon #2", "Monster"));
        deck3Cards.add(new Card(60, "Flute of Summoning Dragon", "Spell"));
        deck3Cards.add(new Card(61, "Negate Attack", "Trap"));
        deck3Cards.add(new Card(62, "Shadow Spell", "Trap"));
        deck3Cards.add(new Card(63, "Remove Trap", "Spell"));
        deck3Cards.add(new Card(64, "De-Spell", "Spell"));
        deck3Cards.add(new Card(65, "Reverse Trap", "Trap"));

        // Deck 4: Weevil Underwood
        deck4Cards.add(new Card(66, "Perfectly Ultimate Great Moth", "Monster"));
        deck4Cards.add(new Card(67, "Great Moth", "Monster"));
        deck4Cards.add(new Card(68, "Cocoon of Evolution", "Monster"));
        deck4Cards.add(new Card(69, "Petit Moth", "Monster"));
        deck4Cards.add(new Card(70, "Basic Insect", "Monster"));
        deck4Cards.add(new Card(71, "Leghul", "Monster"));
        deck4Cards.add(new Card(72, "Metal Armored Bug", "Monster"));
        deck4Cards.add(new Card(73, "Empress Mantis", "Monster"));
        deck4Cards.add(new Card(74, "Flying Kamakiri #2", "Monster"));
        deck4Cards.add(new Card(75, "Giant Flea", "Monster"));
        deck4Cards.add(new Card(76, "Neo Bug", "Monster"));
        deck4Cards.add(new Card(77, "Insect Soldiers of the Sky", "Monster"));
        deck4Cards.add(new Card(78, "Killer Needle", "Monster"));
        deck4Cards.add(new Card(79, "Insect Armor with Laser Cannon", "Spell"));
        deck4Cards.add(new Card(80, "Insect Armor with Laser Cannon", "Spell"));
        deck4Cards.add(new Card(81, "Laser Cannon Armor", "Spell"));
        deck4Cards.add(new Card(82, "Laser Cannon Armor", "Spell"));
        deck4Cards.add(new Card(83, "De-Spell", "Spell"));
        deck4Cards.add(new Card(84, "Mirror Force", "Trap"));
        deck4Cards.add(new Card(85, "Trap Hole", "Trap"));

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
