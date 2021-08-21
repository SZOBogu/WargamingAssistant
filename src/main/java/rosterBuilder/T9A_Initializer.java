package rosterBuilder;

import rosterBuilder.rules.CannotBeTakenWithMoreThanModels;
import rosterBuilder.rules.MustBeTakenTogether;
import rosterBuilder.rules.MustHaveExactly;
import scenarioGenerator.pojos.Deployment;
import scenarioGenerator.pojos.Mission;
import scenarioGenerator.pojos.MissionList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class T9A_Initializer implements IWargameInitializer {

    @Override
    public WargamingSystem initWargame() {
        WargamingSystem T9A = new WargamingSystem("The 9th Age");

        Detachment looseDetachment = new Detachment.DetachmentBuilder("Loose Detachment", 6).build();
        Detachment rigidDetachment = new Detachment.DetachmentBuilder("Rigid Detachment")
                .arrayOfMandatoryChoicesInCategories(new ArrayList<>(Arrays.asList(1,1,0,0,0)))
                .arrayOfMaxChoicesPerCategory(new ArrayList<>(Arrays.asList(2,3,3,3,3)))
                .build();

        Detachment bigRigidDetachment = new Detachment.DetachmentBuilder("Rigid with too many slots available Detachment")
                .arrayOfMandatoryChoicesInCategories(new ArrayList<>(Arrays.asList(1,1,0,0,0)))
                .arrayOfMaxChoicesPerCategory(new ArrayList<>(Arrays.asList(20,30,30,30,30)))
                .build();

        T9A.setDetachments(new ArrayList<>(Arrays.asList(looseDetachment, rigidDetachment, bigRigidDetachment)));

        ArrayList<Deployment> deployments = new ArrayList<>();
        ArrayList<MissionList> missionPack = new ArrayList<>();
        MissionList missions0 = new MissionList("Mission Pack 0");
        MissionList missions1 = new MissionList("Mission Pack 1");

        String[] depNames = {"Deployment 0", "Deployment 1", "Deployment 2", "Deployment 3", "Deployment 4", "Deployment 5"};
        String[] missionNames0 = {"Mission 00", "Mission 01", "Mission 02", "Mission 03",
                "Mission 04", "Mission 05"};
        String[] missionNames1 = {"Mission 10", "Mission 11", "Mission 12", "Mission 13",
                "Mission 14", "Mission 15"};

        for(int i=0; i<6; i++) {
            deployments.add(new Deployment(depNames[i], "/home/bogu/IdeaProjects/GUI//src/main/img/T9A/deployments/"));
            missions0.add(new Mission(missionNames0[i], new ArrayList<>()));
            missions1.add(new Mission(missionNames1[i], new ArrayList<>()));
        }

        missionPack.add(missions0);
        missionPack.add(missions1);
        T9A.setDeployments(deployments);
        T9A.setMissions(missionPack);

        SpecialRule strider = new SpecialRule("Strider", "");
        SpecialRule wizardApprentice = new SpecialRule("Wizard Apprentice", "");
        SpecialRule wizardAdept = new SpecialRule("Wizard Adept", "");
        SpecialRule wizardMaster = new SpecialRule("Wizard Master", "");
        SpecialRule wizardConclave = new SpecialRule("Wizard Conclave", "");
        SpecialRule frenzy = new SpecialRule("Frenzy", "");
        SpecialRule scoring = new SpecialRule("Scoring", "");
        SpecialRule battleFocus = new SpecialRule("Battle Focus", "");
        SpecialRule impactHits = new SpecialRule("Impact Hits", "");
        SpecialRule fearless = new SpecialRule("Fearless", "");
        SpecialRule magicResistance = new SpecialRule("Magic Resistance", "");
        SpecialRule aegis = new SpecialRule("Aegis", "");
        SpecialRule divineAttacks = new SpecialRule("Divine Attacks", "");
        SpecialRule supernal = new SpecialRule("Supernal", "");
        SpecialRule fly = new SpecialRule("Fly", "");
        SpecialRule lightTroops = new SpecialRule("Light Troops", "");
        SpecialRule tall = new SpecialRule("Tall", "");
        SpecialRule toweringPresence = new SpecialRule("Towering Presence", "");
        SpecialRule devastatingCharge = new SpecialRule("Devastating Charge", "");
        SpecialRule lethalStrike = new SpecialRule("Lethal Strike", "");
        SpecialRule hardTarget = new SpecialRule("Hard Target", "");
        SpecialRule skirmisher = new SpecialRule("Skirmisher", "");
        SpecialRule harnessed = new SpecialRule("Harnessed", "");
        SpecialRule bodyguard = new SpecialRule("Bodyguard", "");
        SpecialRule feignedFlight = new SpecialRule("Feigned Flight", "");
        SpecialRule vanguard = new SpecialRule("Vanguard", "");
        SpecialRule warMachine = new SpecialRule("War Machine", "");
        SpecialRule unbreakable = new SpecialRule("Unbreakable", "");
        SpecialRule engineer = new SpecialRule("Engineer", "");
        SpecialRule insignificant = new SpecialRule("Insignificant", "");
        SpecialRule chanel = new SpecialRule("Chanel", "");
        SpecialRule commandingPresence = new SpecialRule("Commanding Presence", "");
        SpecialRule general = new SpecialRule("General", "");
        SpecialRule fear = new SpecialRule("Fear", "");
        SpecialRule stubborn = new SpecialRule("Stubborn", "");
        SpecialRule swiftStride = new SpecialRule("Swiftstride", "");
        SpecialRule packTactics = new SpecialRule("Pack Tactics", "");
        SpecialRule drunkard = new SpecialRule("Drunkard", "");
        SpecialRule primalInstinct = new SpecialRule("Primal Instinct", "");
        SpecialRule bloodOffering = new SpecialRule("Blood Offering", "");
        SpecialRule rage = new SpecialRule("Rage", "");
        SpecialRule giantSeeGiantDo = new SpecialRule("Giant See, Giant Do", "");
        SpecialRule divineRight = new SpecialRule("Divine Right", "");
        SpecialRule risingStar = new SpecialRule("Rising Star", "");
        SpecialRule hellishGrowl = new SpecialRule("Hellish Growl", "");
        SpecialRule smother = new SpecialRule("Smother", "");
        SpecialRule tighteningGrasp = new SpecialRule("Tightening Grasp", "");
        SpecialRule morphlings = new SpecialRule("Morphlings", "");
        SpecialRule orders = new SpecialRule("Orders", "");
        SpecialRule parentUnit = new SpecialRule("Parent Unit", "");
        SpecialRule supportUnit = new SpecialRule("Support Unit", "");
        SpecialRule greatTactician = new SpecialRule("Great Tactician", "");
        SpecialRule fanatical = new SpecialRule("Fanatical", "");
        SpecialRule zealots = new SpecialRule("Zealots", "");
        SpecialRule fanTheFlames = new SpecialRule("Fan the Flames", "");
        SpecialRule volcanicEmbrace = new SpecialRule("Volcanic Embrace", "");
        SpecialRule chosenOfAshuruk = new SpecialRule("Chosen of Ashuruk", "");
        SpecialRule blessingOfNezibkesh = new SpecialRule("Blessing of Nezibkesh", "");
        SpecialRule ogreSlave = new SpecialRule("Ogre Slave", "");
        SpecialRule searingRage = new SpecialRule("Searing Rage", "");
        SpecialRule grailOath = new SpecialRule("Grail Oath", "");
        SpecialRule oathOfFealty = new SpecialRule("Oath of Fealty", "");
        SpecialRule questingOath = new SpecialRule("Questing Oath", "");
        SpecialRule lanceFormation = new SpecialRule("Lance Formation", "");
        SpecialRule theBlessing = new SpecialRule("The Blessing", "");
        SpecialRule serf = new SpecialRule("Serf", "");
        SpecialRule beloved = new SpecialRule("Beloved", "");
        SpecialRule bowmensStakes = new SpecialRule("Bowmen’s Stakes", "");
        SpecialRule braziers = new SpecialRule("Braziers", "");
        SpecialRule holyMight = new SpecialRule("Holy Might", "");
        SpecialRule pureOfHeart = new SpecialRule("Pure of Heart", "");
        SpecialRule looseFormation = new SpecialRule("Loose Formation", "");
        SpecialRule huntingCall = new SpecialRule("Hunting Call", "");
        SpecialRule ambush = new SpecialRule("Ambush", "");
        SpecialRule bsb = new SpecialRule("Battle Standard Bearer", "");

        SpecialRule darkHide = new SpecialRule("Dark Hide", "-");
        SpecialRule centipedeLegs = new SpecialRule("Centipede Legs", "-");
        SpecialRule sorcerousAntennae = new SpecialRule("Sorcerous Antennae", "-");
        SpecialRule unnaturalRoots = new SpecialRule("Unnatural Roots", "-");
        SpecialRule dextrousTentacles = new SpecialRule("Dextrous Tentacles", "-");
        SpecialRule venomSacs = new SpecialRule("Venom Sacs", "-");
        SpecialRule broodmother = new SpecialRule("Broodmother", "-");
        SpecialRule graspingProboscis = new SpecialRule("Grasping Proboscis", "-");
        SpecialRule hotBlood = new SpecialRule("Hot Blood", "-");
        SpecialRule bronzeBackbone = new SpecialRule("Bronze Backbone", "-");
        SpecialRule incendiaryIchor = new SpecialRule("Incendiary Ichor", "-");


        ArrayList<Entity> specialRules = (new ArrayList<>(Arrays.asList(strider, wizardApprentice,
                wizardAdept, wizardMaster,wizardConclave,frenzy,scoring,battleFocus,impactHits,fearless,magicResistance
                ,aegis ,divineAttacks,fear,supernal,fly,lightTroops,tall,toweringPresence,devastatingCharge,
                lethalStrike,hardTarget,skirmisher,harnessed,bodyguard,feignedFlight,bodyguard,warMachine,
                unbreakable, engineer, insignificant,chanel,commandingPresence,general,fear,stubborn,
                swiftStride,packTactics,drunkard,primalInstinct,bloodOffering,rage,giantSeeGiantDo,
                divineRight,risingStar,hellishGrowl,smother,tighteningGrasp,morphlings,orders,
                parentUnit,supportUnit,greatTactician,fanatical,zealots,fanTheFlames,volcanicEmbrace,
                chosenOfAshuruk,blessingOfNezibkesh,ogreSlave,searingRage,grailOath,oathOfFealty,
                questingOath,lanceFormation,theBlessing,serf,beloved,bowmensStakes,braziers,
                holyMight,pureOfHeart,looseFormation,vanguard, huntingCall, ambush, bsb)));


        T9A.getAllInGameEntities().addAll(specialRules);

        Item lightArmour = new Item("Light Armour", "+1 Armour.");
        Item heavyArmour = new Item("Heavy Armour", "+2 Armour.");
        Item plateArmour = new Item("Plate Armour", "+3 Armour.");
        Item shield = new Item("Shield", "");

        Weapon greatWeapon = new Weapon("Great Weapon", "");
        Weapon handWeapon = new Weapon("Hand Weapon", "");
        Weapon halberd = new Weapon("Halberd", "");
        Weapon lightLance = new Weapon("Light Lance", "");
        Weapon lance = new Weapon("Lance", "");
        Weapon pairedWeapons = new Weapon("Paired Weapon", "");
        Weapon spear = new Weapon("Spear", "");
        Weapon beastAxe = new Weapon("Beast Axe", "");
        Weapon hurlAttack = new Weapon("Hurl Attack", "");
        Weapon beerBarrel = new Weapon("Beer Barrel", "");
        Weapon giantClub = new Weapon("Giant Club", "");

        Statline bowStatline = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Range", "24\""),
                new Statistic("Shots", "1"),
                new Statistic("Strength", "3"),
                new Statistic("Armour Penetration", "0"),
                new Statistic("Attack Attributes", "Volley Fire"))));

        Statline longbowStatline = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Range", "30\""),
                new Statistic("Shots", "1"),
                new Statistic("Strength", "3"),
                new Statistic("Armour Penetration", "0"),
                new Statistic("Attack Attributes", "Volley Fire"))));

        Statline crossbowStatline = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Range", "30\""),
                new Statistic("Shots", "1"),
                new Statistic("Strength", "4"),
                new Statistic("Armour Penetration", "1"),
                new Statistic("Attack Attributes", "Unwieldy"))));

        Statline handgunStatline = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Range", "24\""),
                new Statistic("Shots", "1"),
                new Statistic("Strength", "4"),
                new Statistic("Armour Penetration", "2"),
                new Statistic("Attack Attributes", "Unwieldy"))));

        Statline pistolStatline = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Range", "12\""),
                new Statistic("Shots", "1"),
                new Statistic("Strength", "4"),
                new Statistic("Armour Penetration", "2"),
                new Statistic("Attack Attributes", "Quick to Fire"))));

        Statline throwingWeaponsStatline = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Range", "8\""),
                new Statistic("Shots", "2"),
                new Statistic("Strength", "User"),
                new Statistic("Armour Penetration", "User"),
                new Statistic("Attack Attributes", "Accurate, Quick to Fire"))));

        Weapon bow = new Weapon("Bow", "", bowStatline);
        Weapon longbow = new Weapon("Longbow", "", longbowStatline);
        Weapon crossbow = new Weapon("Crossbow", "", crossbowStatline);
        Weapon handgun = new Weapon("Handgun", "", handgunStatline);
        Weapon pistol = new Weapon("Pistol", "", pistolStatline);
        Weapon throwingWeapons = new Weapon("Throwing Weapons", "", throwingWeaponsStatline);

        Weapon cannon = new Weapon("Cannon", "");
        Weapon catapult = new Weapon("Catapult", "");
        Weapon flamethrower = new Weapon("Flamethrower", "");
        Weapon volleyGun = new Weapon("Volley Gun", "");

        ArrayList<Entity> equipment = (new ArrayList<>(Arrays.asList(lightArmour, heavyArmour, plateArmour, shield,
                greatWeapon, handWeapon, halberd, lance, lightLance, pairedWeapons, spear, bow, longbow, crossbow,
                handgun, pistol, throwingWeapons, beastAxe, beerBarrel, hurlAttack, giantClub,
                cannon, catapult, flamethrower, volleyGun)));
        T9A.getAllInGameEntities().addAll(equipment);

        Option championOption = new Option(new Entity("Champion", ""), 20);
        Option musicianOption = new Option(new Entity("Musician", ""), 20);
        Option standardBearerOption = new Option(new Entity("Standard Bearer", ""), 20);
        MultipleChoiceOptionSet fcgOptionSet = new MultipleChoiceOptionSet(new ArrayList<>(Arrays.asList(
                championOption, musicianOption, standardBearerOption)));

        Weapon uniqueSword = new Weapon("Unique Weapon", "");
        Weapon uniqueArmour = new Weapon("Unique Armour", "");
        Weapon uniqueShield = new Weapon("Unique Shield", "");
        Entity uniqueSomething = new Entity("Unique Something", "");

        Weapon uniqueDeamonSword = new Weapon("Unique Daemon Weapon", "");
        Weapon uniqueBeastSword = new Weapon("Unique Beast Weapon", "");

        UniqueEntitiesPool pool = new UniqueEntitiesPool(new ArrayList<>(Arrays.asList(
                uniqueSword, uniqueArmour, uniqueShield, uniqueSomething, uniqueDeamonSword, uniqueBeastSword)));

//BEAST HERDS
        strider.setParameter("Forest");
//BEAST LORD
        Statline BH_BLstatG = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Adv", "5\""), new Statistic("Mar", "10\""),
                new Statistic("Dis", "8"))));
        ArrayList<SpecialRule> BH_BLsrG = new ArrayList<>(Arrays.asList(strider, packTactics));
        ModelPart BH_BL_Global = new ModelPart("Global", BH_BLstatG, BH_BLsrG, new ArrayList<>());

        Statline BH_BLstatD = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("HP", "3"), new Statistic("Def", "6"),
                new Statistic("Res", "5"), new Statistic("Arm", "0"))));
        ModelPart BH_BL_Defensive = new ModelPart("Defensive", BH_BLstatD,
                new ArrayList<>(), new ArrayList<>(Collections.singletonList(lightArmour)));

        Statline BH_BLstatO = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Att", "6"), new Statistic("Off", "6"),
                new Statistic("Str", "5"), new Statistic("AP", "2"),
                new Statistic("Agi", "5"))));
        ArrayList<SpecialRule> BH_BLsrO = new ArrayList<>(Collections.singletonList(primalInstinct));
        ModelPart BH_BL_Offensive = new ModelPart("Offensive", BH_BLstatO, BH_BLsrO, new ArrayList<>());

        Statline BH_BLstatOther = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Size", "Standard"), new Statistic("Type", "Infantry"),
                new Statistic("Base", "25x25mm"))));
        ModelPart BH_BL_Other = new ModelPart("Other", BH_BLstatOther, new ArrayList<>(), new ArrayList<>());

        ArrayList<ModelPart> BH_BL_modelParts = new ArrayList<>(Arrays.asList(
                BH_BL_Global, BH_BL_Defensive, BH_BL_Offensive, BH_BL_Other));
        throwingWeapons.setParameter("4+");

        Option BHBL00 = new Option(general, 0);
        Option BHBL01 = new Option(huntingCall, 25);
        Option BHBL02 = new Option(heavyArmour, 15);
        Option BHBL03 = new Option(throwingWeapons, 5);
        Option BHBL04 = new Option(shield, 5);

        Option BHBL10 = new Option(pairedWeapons, 10);
        Option BHBL11 = new Option(greatWeapon, 20);
        Option BHBL12 = new Option(lance, 20);
        Option BHBL13 = new Option(beastAxe, 25);

        Option BHBL20 = new Option(new Entity("Raiding Chariot", "See Army Book"), 90);
        Option BHBL21 = new Option(new Entity("Razortusk Chariot", "See Army Book"), 125);



        ArrayList<Entity> uniquesForBL = new ArrayList<>(Arrays.asList(
                uniqueSword, uniqueArmour, uniqueShield, uniqueSomething, uniqueBeastSword));
//        for(int i = 0; i < uniquesForBL.size(); i++){
//            if(pool.get(uniquesForBL.get(i).getName()) != null)
//
//        }

        Option BHBL30 = new Option(uniqueSword, 110);
        Option BHBL31 = new Option(uniqueArmour, 80);
        Option BHBL32 = new Option(uniqueShield, 50);
        Option BHBL33 = new Option(uniqueSomething, 25);
        Option BHBL34 = new Option(uniqueBeastSword, 35);
        
        MultipleChoiceOptionSet BH_BL_OptionSet0 = new MultipleChoiceOptionSet(
                new ArrayList<>(Arrays.asList(BHBL00, BHBL01, BHBL02, BHBL03, BHBL04)));
        SingleChoiceOptionSet BH_BL_OptionSet1 = new SingleChoiceOptionSet(
                new ArrayList<>(Arrays.asList(BHBL10, BHBL11, BHBL12, BHBL13)));
        SingleChoiceOptionSet BH_BL_OptionSet2 = new SingleChoiceOptionSet(
                new ArrayList<>(Arrays.asList(BHBL20, BHBL21)));
        PointCapOptionSet BH_BL_OptionSet3 = new PointCapOptionSet(
                new ArrayList<>(Arrays.asList(BHBL30, BHBL31, BHBL32, BHBL33, BHBL34)), 200);
        ArrayList<OptionSet> optionsetBHBL = new ArrayList<>(Arrays.asList(
                BH_BL_OptionSet0, BH_BL_OptionSet1, BH_BL_OptionSet2, BH_BL_OptionSet3));

        UnitProfile beastLord = new UnitProfile("Beast Lord", BH_BL_modelParts, optionsetBHBL, 215);
        beastLord.setRules(new ArrayList<>(Collections.singletonList(new MustBeTakenTogether(huntingCall, general))));
        beastLord.setPool(pool);
//SOOOTHSAYER
        Statline BH_BSoothStatG = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Adv", "5\""), new Statistic("Mar", "10\""),
                new Statistic("Dis", "8"))));
        ArrayList<SpecialRule> BH_BSoothSrG = new ArrayList<>(Arrays.asList(
                bloodOffering, strider, packTactics, wizardApprentice));
        ModelPart BH_BSooth_Global = new ModelPart(
                "Global", BH_BSoothStatG, BH_BSoothSrG, new ArrayList<>());

        Statline BH_BSoothStatD = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("HP", "3"), new Statistic("Def", "4"),
                new Statistic("Res", "5"), new Statistic("Arm", "0"))));
        ModelPart BH_BSooth_Defensive = new ModelPart(
                "Defensive", BH_BSoothStatD, new ArrayList<>(), new ArrayList<>());

        Statline BH_BSoothStatO = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Att", "1"), new Statistic("Off", "4"),
                new Statistic("Str", "3"), new Statistic("AP", "0"),
                new Statistic("Agi", "3"))));
        ArrayList<SpecialRule> BH_BSoothSrO = new ArrayList<>(Collections.singletonList(primalInstinct));
        ModelPart BH_BSooth_Offensive = new ModelPart(
                "Offensive", BH_BSoothStatO, BH_BSoothSrO, new ArrayList<>());

        Statline BH_BSoothStatOther = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Size", "Standard"), new Statistic("Type", "Infantry"),
                new Statistic("Base", "25x25mm"))));
        ModelPart BH_BSooth_Other = new ModelPart(
                "Other", BH_BSoothStatOther, new ArrayList<>(), new ArrayList<>());

        ArrayList<ModelPart> BH_BSooth_modelParts = new ArrayList<>(Arrays.asList(
                BH_BSooth_Global, BH_BSooth_Defensive, BH_BSooth_Offensive, BH_BSooth_Other));

        ambush.setParameter("on foot only");
        Option BHBSooth00 = new Option(general, 0);
        Option BHBSooth01 = new Option(ambush, 10);
        Option BHBSooth02 = new Option(lightArmour, 5);
        Option BHBSooth03 = new Option(pairedWeapons, 5);

        Option BHBSooth10 = new Option(wizardAdept, 75);
        Option BHBSooth11 = new Option(wizardMaster, 225);

        Option BHSooth30 = new Option(uniqueSword, 110);
        Option BHSooth31 = new Option(uniqueArmour, 80);
        Option BHSooth32 = new Option(uniqueShield, 50);
        Option BHSooth33 = new Option(uniqueSomething, 25);
        Option BHSooth34 = new Option(uniqueBeastSword, 35);
        
        Option BHBSooth20 = new Option(new Entity("Raiding Chariot", "See Army Book"), 20);

        MultipleChoiceOptionSet BH_BSooth_OptionSet0 = new MultipleChoiceOptionSet(new ArrayList<>(Arrays.asList(
                BHBSooth00, BHBSooth01, BHBSooth02, BHBSooth03)));
        SingleChoiceOptionSet BH_BSooth_OptionSet1 = new SingleChoiceOptionSet(new ArrayList<>(Arrays.asList(
                BHBSooth10, BHBSooth11)));
        SingleChoiceOptionSet BH_BSooth_OptionSet2 = new SingleChoiceOptionSet(new ArrayList<>(
                Arrays.asList(BHBSooth20)));
        PointCapOptionSet BH_Sooth_OptionSet3 = new PointCapOptionSet(new ArrayList<>(
                Arrays.asList(BHSooth30, BHSooth31, BHSooth32, BHSooth33, BHSooth34)), 200);
        ArrayList<OptionSet> optionsetBHBSooth = new ArrayList<>(
                Arrays.asList(
                        BH_BSooth_OptionSet0, BH_BSooth_OptionSet1, BH_BSooth_OptionSet2, BH_Sooth_OptionSet3));

        UnitProfile soothsayer = new UnitProfile(
                "Soothsayer", BH_BSooth_modelParts, optionsetBHBSooth, 155);
        ambush.setParameter("");
        soothsayer.setPool(pool);
//WILDHORN HELD
        Statline BH_WHStatG = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Adv", "5\""), new Statistic("Mar", "10\""),
                new Statistic("Dis", "7"))));
        ArrayList<SpecialRule> BH_WHStatSrG = new ArrayList<>(Arrays.asList(
                strider, packTactics, scoring));
        ModelPart BH_WHStatGlobal = new ModelPart(
                "Global", BH_WHStatG, BH_WHStatSrG, new ArrayList<>());

        Statline BH_WHStatStatD = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("HP", "1"), new Statistic("Def", "4"),
                new Statistic("Res", "4"), new Statistic("Arm", "0"))));
        ArrayList<SpecialRule>BH_WHSrD = new ArrayList<>();
        ModelPart BH_WHStatDefensive = new ModelPart(
                "Defensive", BH_WHStatStatD, BH_WHSrD, new ArrayList<>());

        Statline BH_WHStatStatO = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Att", "1"), new Statistic("Off", "4"),
                new Statistic("Str", "3"), new Statistic("AP", "0"),
                new Statistic("Agi", "3"))));
        ArrayList<SpecialRule> BH_WHStatSrO = new ArrayList<>(Collections.singletonList(primalInstinct));
        ModelPart BH_WHStatOffensive = new ModelPart(
                "Offensive", BH_WHStatStatO, BH_WHStatSrO, new ArrayList<>());

        Statline BH_WHStatStatOther = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Size", "Standard"), new Statistic("Type", "Infantry"),
                new Statistic("Base", "25x25mm"))));
        ModelPart BH_WHStat_Other = new ModelPart(
                "Other", BH_WHStatStatOther, new ArrayList<>(), new ArrayList<>());

        ArrayList<ModelPart> BH_WHStat_modelParts = new ArrayList<>(Arrays.asList(
                BH_WHStatGlobal, BH_WHStatDefensive, BH_WHStatOffensive, BH_WHStat_Other));

        throwingWeapons.setParameter("5+");
        Option BH_WH_Op00 = new Option(ambush, 20);
        QuantityDependentOption BH_WH_Op01 = new QuantityDependentOption(throwingWeapons, 1, 15);

        QuantityDependentOption BH_WH_Op10 = new QuantityDependentOption(pairedWeapons, 2, 15);
        QuantityDependentOption BH_WH_Op11 = new QuantityDependentOption(shield, 2, 15);

        MultipleChoiceOptionSet BH_WH_OptionSet0 = new MultipleChoiceOptionSet(
                new ArrayList<>(Arrays.asList(BH_WH_Op00, BH_WH_Op01)));
        SingleChoiceOptionSet BH_WH_OptionSet1 = new SingleChoiceOptionSet(
                new ArrayList<>(Arrays.asList(BH_WH_Op10, BH_WH_Op11)));

        ArrayList<OptionSet> optionsetBH_WH = new ArrayList<>(Arrays.asList(
                BH_WH_OptionSet0, BH_WH_OptionSet1, fcgOptionSet));

        UnitProfile wildhornHerd = new UnitProfile(
                "Wildhorn Herd", BH_WHStat_modelParts, optionsetBH_WH,
                150, 15, 50, 10);
        wildhornHerd.setRules(new ArrayList<>(Collections.singletonList(
                new CannotBeTakenWithMoreThanModels(ambush, 20))));
        wildhornHerd.setPool(pool);
//MONGREL HERD
        Statline BH_MHStatG = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Adv", "5\""), new Statistic("Mar", "10\""),
                new Statistic("Dis", "6"))));
        ArrayList<SpecialRule> BH_MHStatSrG = new ArrayList<>(Arrays.asList(
                strider, packTactics, scoring));
        ModelPart BH_MHStatGlobal = new ModelPart(
                "Global", BH_MHStatG, BH_MHStatSrG, new ArrayList<>());

        Statline BH_MHStatStatD = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("HP", "1"), new Statistic("Def", "3"),
                new Statistic("Res", "3"), new Statistic("Arm", "0"))));
        ArrayList<SpecialRule>BH_MHSrD = new ArrayList<>();
        ModelPart BH_MHStatDefensive = new ModelPart(
                "Defensive", BH_MHStatStatD, BH_MHSrD, new ArrayList<>(Collections.singletonList(shield)));

        Statline BH_MHStatStatO = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Att", "1"), new Statistic("Off", "3"),
                new Statistic("Str", "3"), new Statistic("AP", "0"),
                new Statistic("Agi", "3"))));
        ArrayList<SpecialRule> BH_MHStatSrO = new ArrayList<>(Collections.singletonList(primalInstinct));
        ModelPart BH_MHStatOffensive = new ModelPart(
                "Offensive", BH_MHStatStatO, BH_MHStatSrO, new ArrayList<>());

        Statline BH_MHStatStatOther = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Size", "Standard"), new Statistic("Type", "Infantry"),
                new Statistic("Base", "25x25mm"))));
        ModelPart BH_MHStat_Other = new ModelPart(
                "Other", BH_MHStatStatOther, new ArrayList<>(), new ArrayList<>());

        ArrayList<ModelPart> BH_MHStat_modelParts = new ArrayList<>(Arrays.asList(
                BH_MHStatGlobal, BH_MHStatDefensive, BH_MHStatOffensive, BH_MHStat_Other));

        Option BH_MH_Op00 = new Option(ambush, 20);
        Option BH_MH_Op01 = new Option(spear, 0);

        MultipleChoiceOptionSet BH_MH_OptionSet0 = new MultipleChoiceOptionSet(new ArrayList<>(
                Arrays.asList(BH_MH_Op00, BH_MH_Op01)));

        ArrayList<OptionSet> optionsetBH_MH = new ArrayList<>(Arrays.asList(BH_MH_OptionSet0, fcgOptionSet));

        UnitProfile mongrelHerd = new UnitProfile(
                "Mongrel Herd", BH_MHStat_modelParts, optionsetBH_MH, 150, 15, 50, 10);
        mongrelHerd.setRules(new ArrayList<>(Collections.singletonList(
                new CannotBeTakenWithMoreThanModels(ambush, 30))));
        mongrelHerd.setPool(pool);
//MINOSY
        Statline BH_MinoStatG = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Adv", "6\""), new Statistic("Mar", "12\""),
                new Statistic("Dis", "7"))));
        ArrayList<SpecialRule> BH_MinoStatSrG = new ArrayList<>(Arrays.asList(frenzy,strider, scoring));
        ModelPart BH_MinoStatGlobal = new ModelPart(
                "Global", BH_MinoStatG, BH_MinoStatSrG, new ArrayList<>());

        Statline BH_MinoStatStatD = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("HP", "3"), new Statistic("Def", "3"),
                new Statistic("Res", "4"), new Statistic("Arm", "0"))));
        ArrayList<SpecialRule>BH_MinoSrD = new ArrayList<>();
        ModelPart BH_MinoStatDefensive = new ModelPart(
                "Defensive", BH_MinoStatStatD, BH_MinoSrD, new ArrayList<>(
                        Collections.singletonList(lightArmour)));

        Statline BH_MinoStatStatO = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Att", "3"), new Statistic("Off", "4"),
                new Statistic("Str", "5"), new Statistic("AP", "2"),
                new Statistic("Agi", "3"))));
        ArrayList<SpecialRule> BH_MinoStatSrO = new ArrayList<>(Arrays.asList(
                battleFocus,impactHits ,primalInstinct));
        ModelPart BH_MinoStatOffensive = new ModelPart(
                "Offensive", BH_MinoStatStatO, BH_MinoStatSrO, new ArrayList<>());

        Statline BH_MinoStatStatOther = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Size", "Large"), new Statistic("Type", "Infantry"),
                new Statistic("Base", "40x40mm"))));
        ModelPart BH_MinoStat_Other = new ModelPart(
                "Other", BH_MinoStatStatOther, new ArrayList<>(), new ArrayList<>());

        ArrayList<ModelPart> BH_MinoStat_modelParts = new ArrayList<>(Arrays.asList(
                BH_MinoStatGlobal, BH_MinoStatDefensive, BH_MinoStatOffensive, BH_MinoStat_Other));

        QuantityDependentOption BH_Mino_Op00 = new QuantityDependentOption(shield, 6, 3);
        QuantityDependentOption BH_Mino_Op01 = new QuantityDependentOption(greatWeapon, 10, 3);
        QuantityDependentOption BH_Mino_Op02 = new QuantityDependentOption(pairedWeapons, 10, 3);

        SingleChoiceOptionSet BH_Mino_OptionSet0 = new SingleChoiceOptionSet(new ArrayList<>(
                Arrays.asList(BH_Mino_Op00, BH_Mino_Op01, BH_Mino_Op02)));

        ArrayList<OptionSet> optionsetBH_Mino = new ArrayList<>(Arrays.asList(BH_Mino_OptionSet0, fcgOptionSet));

        UnitProfile minotaurs = new UnitProfile(
                "Minotaurs", BH_MinoStat_modelParts, optionsetBH_Mino,
                235, 3, 10, 78, 5);
        minotaurs.setPool(pool);

//CENTAURY
        Statline BH_CentaursStatG = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Adv", "8\""), new Statistic("Mar", "16\""),
                new Statistic("Dis", "7"))));
        ArrayList<SpecialRule> BH_CentaursStatSrG = new ArrayList<>(Arrays.asList(
                drunkard,strider, scoring));
        ModelPart BH_CentaursStatGlobal = new ModelPart(
                "Global", BH_CentaursStatG, BH_CentaursStatSrG, new ArrayList<>());

        Statline BH_CentaursStatStatD = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("HP", "1"), new Statistic("Def", "4"),
                new Statistic("Res", "4"), new Statistic("Arm", "0"))));
        ArrayList<SpecialRule>BH_CentaursSrD = new ArrayList<>();
        ModelPart BH_CentaursStatDefensive = new ModelPart(
                "Defensive", BH_CentaursStatStatD, BH_CentaursSrD, new ArrayList<>(Arrays.asList(lightArmour, shield)));

        Statline BH_CentaursStatStatO = new Statline(new ArrayList<>(
                Arrays.asList(new Statistic("Att", "2"), new Statistic("Off", "4"),
                        new Statistic("Str", "2"), new Statistic("AP", "1"),
                        new Statistic("Agi", "3"))));
        ArrayList<SpecialRule> BH_CentaursStatSrO = new ArrayList<>(Collections.singletonList(primalInstinct));
        ModelPart BH_CentaursStatOffensive = new ModelPart(
                "Offensive", BH_CentaursStatStatO, BH_CentaursStatSrO, new ArrayList<>());

        Statline BH_CentaursStatStatOther = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Size", "Standard"), new Statistic("Type", "Cavalry"),
                new Statistic("Base", "25x50mm"))));
        ModelPart BH_CentaursStat_Other = new ModelPart(
                "Other", BH_CentaursStatStatOther, new ArrayList<>(), new ArrayList<>());

        ArrayList<ModelPart> BH_CentaursStat_modelParts = new ArrayList<>(
                Arrays.asList(BH_CentaursStatGlobal, BH_CentaursStatDefensive,
                        BH_CentaursStatOffensive, BH_CentaursStat_Other));

        QuantityDependentOption BH_Centaurs_Op00 = new QuantityDependentOption(lance, 8, 5);
        QuantityDependentOption BH_Centaurs_Op01 = new QuantityDependentOption(greatWeapon, 4, 5);
        QuantityDependentOption BH_Centaurs_Op02 = new QuantityDependentOption(pairedWeapons, 3, 5);

        QuantityDependentOption BH_Centaurs_Op10 = new QuantityDependentOption(ambush, 3, 5);
        QuantityDependentOption BH_Centaurs_Op11 = new QuantityDependentOption(throwingWeapons, 40, 4);
        SingleChoiceOptionSet BH_Centaurs_OptionSet0 = new SingleChoiceOptionSet(
                new ArrayList<>(Arrays.asList(BH_Centaurs_Op00, BH_Centaurs_Op01, BH_Centaurs_Op02)));
        MultipleChoiceOptionSet BH_Centaurs_OptionSet1 = new MultipleChoiceOptionSet(
                new ArrayList<>(Arrays.asList(BH_Centaurs_Op10, BH_Centaurs_Op11)));
        ArrayList<OptionSet> optionsetBH_Centaurs = new ArrayList<>(
                Arrays.asList(BH_Centaurs_OptionSet0, BH_Centaurs_OptionSet1, fcgOptionSet));

        UnitProfile centaurs = new UnitProfile("Centaurs",
                BH_CentaursStat_modelParts, optionsetBH_Centaurs,
                165, 5, 15, 25, 4);
        centaurs.setRules(new ArrayList<>(Collections.singletonList(new CannotBeTakenWithMoreThanModels(ambush, 8))));
        centaurs.setPool(pool);
//BEAST GIANT
        Statline BH_BeastGiantStatG = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Adv", "7\""), new Statistic("Mar", "14\""),
                new Statistic("Dis", "8"))));
        ArrayList<SpecialRule> BH_BeastGiantStatSrG = new ArrayList<>(Collections.singletonList(giantSeeGiantDo));
        ModelPart BH_BeastGiantStatGlobal = new ModelPart(
                "Global", BH_BeastGiantStatG, BH_BeastGiantStatSrG, new ArrayList<>());

        Statline BH_BeastGiantStatStatD = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("HP", "7"), new Statistic("Def", "3"),
                new Statistic("Res", "5"), new Statistic("Arm", "1"))));
        ArrayList<SpecialRule>BH_BeastGiantSrD = new ArrayList<>();
        ModelPart BH_BeastGiantStatDefensive = new ModelPart("Defensive",
                BH_BeastGiantStatStatD, BH_BeastGiantSrD, new ArrayList<>(Arrays.asList(lightArmour, shield)));

        Statline BH_BeastGiantStatStatO = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Att", "5"), new Statistic("Off", "3"),
                new Statistic("Str", "5"), new Statistic("AP", "2"),
                new Statistic("Agi", "3"))));
        ArrayList<SpecialRule> BH_BeastGiantStatSrO = new ArrayList<>(Collections.singletonList(rage));
        ModelPart BH_BeastGiantStatOffensive = new ModelPart(
                "Offensive", BH_BeastGiantStatStatO, BH_BeastGiantStatSrO, new ArrayList<>());

        Statline BH_BeastGiantStatStatOther = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Size", "Gigantic"), new Statistic("Type", "Infantry"),
                new Statistic("Base", "50x75mm"))));
        ModelPart BH_BeastGiantStat_Other = new ModelPart(
                "Other", BH_BeastGiantStatStatOther, new ArrayList<>(), new ArrayList<>());

        ArrayList<ModelPart> BH_BeastGiantStat_modelParts = new ArrayList<>(Arrays.asList(
                BH_BeastGiantStatGlobal, BH_BeastGiantStatDefensive, BH_BeastGiantStatOffensive, BH_BeastGiantStat_Other));

        Option BH_BeastGiant_Op00 = new Option(giantClub, 30);
        Option BH_BeastGiant_Op01 = new Option(beerBarrel, 20);

        SingleChoiceOptionSet BH_BeastGiant_OptionSet0 = new SingleChoiceOptionSet(
                new ArrayList<>(Arrays.asList(BH_BeastGiant_Op00, BH_BeastGiant_Op01)));
        ArrayList<OptionSet> optionsetBH_BeastGiant = new ArrayList<>(
                Collections.singletonList(BH_BeastGiant_OptionSet0));

        UnitProfile beastGiant = new UnitProfile(
                "Beast Giant", BH_BeastGiantStat_modelParts, optionsetBH_BeastGiant, 300, 3);
        beastGiant.setPool(pool);
// CYKLOP BH
        Statline BH_CyclopsStatG = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Adv", "7\""), new Statistic("Mar", "14\""),
                new Statistic("Dis", "8"))));
        ArrayList<SpecialRule> BH_CyclopsStatSrG = new ArrayList<>(Arrays.asList(
                drunkard,strider, scoring));
        ModelPart BH_CyclopsStatGlobal = new ModelPart("Global",
                BH_CyclopsStatG, BH_CyclopsStatSrG, new ArrayList<>());

        Statline BH_CyclopsStatStatD = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("HP", "6"), new Statistic("Def", "2"),
                new Statistic("Res", "5"), new Statistic("Arm", "0"))));
        ArrayList<SpecialRule>BH_CyclopsSrD = new ArrayList<>();
        ModelPart BH_CyclopsStatDefensive = new ModelPart(
                "Defensive", BH_CyclopsStatStatD, BH_CyclopsSrD, new ArrayList<>(Arrays.asList(lightArmour, shield)));

        Statline BH_CyclopsStatStatO = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Att", "5"), new Statistic("Off", "2"),
                new Statistic("Str", "6"), new Statistic("AP", "3"),
                new Statistic("Agi", "3"))));
        ArrayList<SpecialRule> BH_CyclopsStatSrO = new ArrayList<>(Collections.singletonList(primalInstinct));
        ModelPart BH_CyclopsStatOffensive = new ModelPart(
                "Offensive", BH_CyclopsStatStatO, BH_CyclopsStatSrO, new ArrayList<>());

        Statline BH_CyclopsStatStatOther = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Size", "Gigantic"), new Statistic("Type", "Infantry"),
                new Statistic("Base", "50x100mm"))));
        ModelPart BH_CyclopsStat_Other = new ModelPart(
                "Other", BH_CyclopsStatStatOther, new ArrayList<>(), new ArrayList<>());

        ArrayList<ModelPart> BH_CyclopsStat_modelParts = new ArrayList<>(Arrays.asList(
                BH_CyclopsStatGlobal, BH_CyclopsStatDefensive, BH_CyclopsStatOffensive, BH_CyclopsStat_Other));

        UnitProfile cyclops = new UnitProfile(
                "Cyclops", BH_CyclopsStat_modelParts, new ArrayList<>(), 335, 3);
        cyclops.setPool(pool);
        //ARMY CATEGORIES BH
        ArmySubcategory BH_Characters = new ArmySubcategory("Heroes", new ArrayList<>(Arrays.asList(
                beastLord, soothsayer)));
        ArmySubcategory BH_Core = new ArmySubcategory("Common Troops", new ArrayList<>(Arrays.asList(
                wildhornHerd, mongrelHerd)));
        ArmySubcategory BH_Special = new ArmySubcategory("Elite Units", new ArrayList<>(Arrays.asList(
                minotaurs, centaurs)));
        ArmySubcategory BH_TotW = new ArmySubcategory("Monsters", new ArrayList<>(Arrays.asList(
                beastGiant, cyclops)));
        //BH
        Army bh = new Army("Beasts", new ArrayList<>(Arrays.asList(BH_Characters, BH_Core, BH_Special, BH_TotW)));
//DAEMON LEGIONS %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
        Statline darkFireStatLine = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Range", "24\""), new Statistic("Shots", "2"),
                new Statistic("Str", "4"), new Statistic("AP", "0"))));
        Weapon darkFire = new Weapon("Dark Fire", "-", darkFireStatLine);
        darkFire.setParameter("3+, on foot only");

        Statline energyBoltsStatLine = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Range", "24\""), new Statistic("Shots", "1"),
                new Statistic("Str", "5"), new Statistic("AP", "0"))));
        Weapon energyBolts = new Weapon("Energy Bolts", "-", energyBoltsStatLine);
        energyBolts.setParameter("4+");
        
        SpecialRule dominionOfPride = new SpecialRule("Dominion Of Pride", "-");
//HARBINGER OF FATHER CHAOS
        Statline DL_HarbingerOfFatherChaosStatG = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Adv", "5\""), new Statistic("Mar", "10\""),
                new Statistic("Dis", "8"))));
        ArrayList<SpecialRule> DL_HarbingerOfFatherChaosStatSrG = new ArrayList<>(Arrays.asList(
                supernal, fearless));
        ModelPart DL_HarbingerOfFatherChaosStatGlobal = new ModelPart(
                "Global", DL_HarbingerOfFatherChaosStatG, DL_HarbingerOfFatherChaosStatSrG, new ArrayList<>());

        Statline DL_HarbingerOfFatherChaosStatStatD = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("HP", "3"), new Statistic("Def", "5"),
                new Statistic("Res", "4"), new Statistic("Arm", "0"),
                new Statistic("Aeg", "4+"))));
        ArrayList<SpecialRule>DL_HarbingerOfFatherChaosSrD = new ArrayList<>();
        ModelPart DL_HarbingerOfFatherChaosStatDefensive = new ModelPart(
                "Defensive", DL_HarbingerOfFatherChaosStatStatD, DL_HarbingerOfFatherChaosSrD, new ArrayList<>());

        Statline DL_HarbingerOfFatherChaosStatStatO = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Att", "3"), new Statistic("Off", "5"),
                new Statistic("Str", "5"), new Statistic("AP", "2"),
                new Statistic("Agi", "5"))));
        ArrayList<SpecialRule> DL_HarbingerOfFatherChaosStatSrO = new ArrayList<>();
        ModelPart DL_HarbingerOfFatherChaosStatOffensive = new ModelPart(
                "Offensive", DL_HarbingerOfFatherChaosStatStatO, DL_HarbingerOfFatherChaosStatSrO, new ArrayList<>());

        Statline DL_HarbingerOfFatherChaosStatStatOther = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Size", "Standard"), new Statistic("Type", "Beast"),
                new Statistic("Base", "25x25mm"))));
        ModelPart DL_HarbingerOfFatherChaosStat_Other = new ModelPart(
                "Other", DL_HarbingerOfFatherChaosStatStatOther, new ArrayList<>(), new ArrayList<>());

        ArrayList<ModelPart> DL_HarbingerOfFatherChaosStat_modelParts = new ArrayList<>(Arrays.asList(
                DL_HarbingerOfFatherChaosStatGlobal, DL_HarbingerOfFatherChaosStatDefensive,
                DL_HarbingerOfFatherChaosStatOffensive, DL_HarbingerOfFatherChaosStat_Other));

        Option DL_HarbingerOfFatherChaos_Op00 = new Option(general, 0);
        Option DL_HarbingerOfFatherChaos_Op01 = new Option(bsb, 50);
        //chaosowe commony do 150
        Option DL_HarbingerOfFatherChaos_Op10 = new Option(new Item("Dark Pulpit", ""), 50);
        Option DL_HarbingerOfFatherChaos_Op11 = new Option(new Item("Pale Horse", ""), 150);
        
        SingleChoiceOptionSet DL_HarbingerOfFatherChaos_OptionSet0 = new SingleChoiceOptionSet(
                new ArrayList<>(Arrays.asList(DL_HarbingerOfFatherChaos_Op00, DL_HarbingerOfFatherChaos_Op01)));
        MultipleChoiceOptionSet DL_HarbingerOfFatherChaos_OptionSet1 = new MultipleChoiceOptionSet(
                new ArrayList<>(Arrays.asList(DL_HarbingerOfFatherChaos_Op10, DL_HarbingerOfFatherChaos_Op11)));
        ArrayList<OptionSet> optionsetDL_HarbingerOfFatherChaos = new ArrayList<>(Arrays.asList(
                DL_HarbingerOfFatherChaos_OptionSet0, DL_HarbingerOfFatherChaos_OptionSet1));

        UnitProfile harbingerOfFatherChaos = new UnitProfile(
                "Harbinger Of Father Chaos", DL_HarbingerOfFatherChaosStat_modelParts,
                optionsetDL_HarbingerOfFatherChaos, 160, 4);
        harbingerOfFatherChaos.setPool(pool);
//OMEN OF SAVAR
        Statline DL_OmenOfSavarStatG = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Adv", "6\""), new Statistic("Mar", "18\""),
                new Statistic("Dis", "9"))));
        ArrayList<SpecialRule> DL_OmenOfSavarStatSrG = new ArrayList<>(Arrays.asList(
                divineRight, dominionOfPride, fear, wizardApprentice,supernal, fearless));
        ModelPart DL_OmenOfSavarStatGlobal = new ModelPart(
                "Global", DL_OmenOfSavarStatG, DL_OmenOfSavarStatSrG, new ArrayList<>());

        Statline DL_OmenOfSavarStatStatD = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("HP", "4"), new Statistic("Def", "7"),
                new Statistic("Res", "5"), new Statistic("Arm", "0"),
                new Statistic("Aeg", "6+"))));
        ArrayList<SpecialRule>DL_OmenOfSavarSrD = new ArrayList<>(Collections.singletonList(
                new SpecialRule("Aegis (4+, agianst Magical Attacks)", "")));
        ModelPart DL_OmenOfSavarStatDefensive = new ModelPart(
                "Defensive", DL_OmenOfSavarStatStatD, DL_OmenOfSavarSrD, new ArrayList<>());

        Statline DL_OmenOfSavarStatStatO = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Att", "D6+2"), new Statistic("Off", "D6+5"),
                new Statistic("Str", "6"), new Statistic("AP", "3"),
                new Statistic("Agi", "6"))));
        ArrayList<SpecialRule> DL_OmenOfSavarStatSrO = new ArrayList<>();
        ModelPart DL_OmenOfSavarStatOffensive = new ModelPart(
                "Offensive", DL_OmenOfSavarStatStatO, DL_OmenOfSavarStatSrO, new ArrayList<>());

        Statline DL_OmenOfSavarStatStatOther = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Size", "Standard"), new Statistic("Type", "Beast"),
                new Statistic("Base", "50x50mm"))));
        ModelPart DL_OmenOfSavarStat_Other = new ModelPart(
                "Other", DL_OmenOfSavarStatStatOther, new ArrayList<>(), new ArrayList<>());

        ArrayList<ModelPart> DL_OmenOfSavarStat_modelParts = new ArrayList<>(Arrays.asList(
                DL_OmenOfSavarStatGlobal, DL_OmenOfSavarStatDefensive,
                DL_OmenOfSavarStatOffensive, DL_OmenOfSavarStat_Other));

        Option DL_OmenOfSavar_Op00 = new Option(general, 0);
        Option DL_OmenOfSavar_Op01 = new Option(dominionOfPride, 50);

        Option DL_OmenOfSavar_Op10 = new Option(wizardAdept, 75);
        Option DL_OmenOfSavar_Op11 = new Option(wizardMaster, 225);
        //chaosowe commony do 150
        Option DL_OmenOfSavar_Op20 = new Option(
                new Item("Throne of Overwhelming Splendour", ""), 185);

        MultipleChoiceOptionSet DL_OmenOfSavar_OptionSet0 = new MultipleChoiceOptionSet(new ArrayList<>(Arrays.asList(
                DL_OmenOfSavar_Op00, DL_OmenOfSavar_Op01)));
        SingleChoiceOptionSet DL_OmenOfSavar_OptionSet1 = new SingleChoiceOptionSet(new ArrayList<>(Arrays.asList(
                DL_OmenOfSavar_Op10, DL_OmenOfSavar_Op11)), "", "become");
        MultipleChoiceOptionSet DL_OmenOfSavar_OptionSet2 = new MultipleChoiceOptionSet(new ArrayList<>(
                Collections.singletonList(DL_OmenOfSavar_Op20)));
        ArrayList<OptionSet> optionsetDL_OmenOfSavar = new ArrayList<>(Arrays.asList(
                DL_OmenOfSavar_OptionSet0, DL_OmenOfSavar_OptionSet1, DL_OmenOfSavar_OptionSet2));

        UnitProfile omenOfSavar = new UnitProfile(
                "Omen of Savar", DL_OmenOfSavarStat_modelParts, optionsetDL_OmenOfSavar, 490, 3);
        omenOfSavar.setRules(new ArrayList<>(Collections.singletonList(
                new MustBeTakenTogether(dominionOfPride, general))));
        omenOfSavar.setPool(pool);
//IMPS
        Statline DL_ImpsStatG = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Adv", "5\""), new Statistic("Mar", "10\""),
                new Statistic("Dis", "6"))));
        ArrayList<SpecialRule> DL_ImpsStatSrG = new ArrayList<>(Arrays.asList(supernal, fearless, scoring));
        ModelPart DL_ImpsStatGlobal = new ModelPart(
                "Global", DL_ImpsStatG, DL_ImpsStatSrG, new ArrayList<>());

        Statline DL_ImpsStatStatD = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("HP", "1"), new Statistic("Def", "2"),
                new Statistic("Res", "2"), new Statistic("Arm", "0"),
                new Statistic("Aeg", "5+"))));
        ArrayList<SpecialRule>DL_ImpsSrD = new ArrayList<>(Collections.singletonList(
                new SpecialRule("Aegis (3+, against Shooting Attacks)", "")));
        ModelPart DL_ImpsStatDefensive = new ModelPart(
                "Defensive", DL_ImpsStatStatD, DL_ImpsSrD, new ArrayList<>());

        Statline DL_ImpsStatStatO = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Att", "1"), new Statistic("Off", "2"),
                new Statistic("Str", "2"), new Statistic("AP", "03"),
                new Statistic("Agi", "3"))));
        ArrayList<SpecialRule> DL_ImpsStatSrO = new ArrayList<>();
        ModelPart DL_ImpsStatOffensive = new ModelPart(
                "Offensive", DL_ImpsStatStatO, DL_ImpsStatSrO, new ArrayList<>(
                        Collections.singletonList(energyBolts)));

        Statline DL_ImpsStatStatOther = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Size", "Standard"), new Statistic("Type", "Beast"),
                new Statistic("Base", "25x25mm"))));
        ModelPart DL_ImpsStat_Other = new ModelPart(
                "Other", DL_ImpsStatStatOther, new ArrayList<>(), new ArrayList<>());

        ArrayList<ModelPart> DL_ImpsStat_modelParts = new ArrayList<>(
                Arrays.asList(DL_ImpsStatGlobal, DL_ImpsStatDefensive, DL_ImpsStatOffensive, DL_ImpsStat_Other));

        QuantityDependentOption DL_Imps_Op00 = new QuantityDependentOption(incendiaryIchor, 1, 10);
        Option DL_Imps_Op01 = new Option(sorcerousAntennae, 45);

        MultipleChoiceOptionSet DL_Imps_OptionSet0 = new MultipleChoiceOptionSet(new ArrayList<>(
                Arrays.asList(DL_Imps_Op00, DL_Imps_Op01)));

        ArrayList<OptionSet> optionsetDL_Imps = new ArrayList<>(Arrays.asList(DL_Imps_OptionSet0, fcgOptionSet));

        UnitProfile imps = new UnitProfile(
                "Imps", DL_ImpsStat_modelParts, optionsetDL_Imps,
                215, 10, 25, 15, 4);
        imps.setPool(pool);
//MYRMIDONS
        Statline DL_MyrmidonsStatG = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Adv", "5\""), new Statistic("Mar", "10\""),
                new Statistic("Dis", "8"))));
        ArrayList<SpecialRule> DL_MyrmidonsStatSrG = new ArrayList<>(Arrays.asList(
                supernal, fearless, scoring));
        ModelPart DL_MyrmidonsStatGlobal = new ModelPart(
                "Global", DL_MyrmidonsStatG, DL_MyrmidonsStatSrG, new ArrayList<>());

        Statline DL_MyrmidonsStatStatD = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("HP", "1"), new Statistic("Def", "4"),
                new Statistic("Res", "3"), new Statistic("Arm", "0"),
                new Statistic("Aeg", "5+"))));
        ArrayList<SpecialRule>DL_MyrmidonsSrD = new ArrayList<>();
        ModelPart DL_MyrmidonsStatDefensive = new ModelPart(
                "Defensive", DL_MyrmidonsStatStatD, DL_MyrmidonsSrD, new ArrayList<>());

        Statline DL_MyrmidonsStatStatO = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Att", "1"), new Statistic("Off", "5"),
                new Statistic("Str", "5"), new Statistic("AP", "1"),
                new Statistic("Agi", "4"))));
        ArrayList<SpecialRule> DL_MyrmidonsStatSrO = new ArrayList<>();
        ModelPart DL_MyrmidonsStatOffensive = new ModelPart(
                "Offensive", DL_MyrmidonsStatStatO, DL_MyrmidonsStatSrO, new ArrayList<>(
                        Collections.singletonList(energyBolts)));

        Statline DL_MyrmidonsStatStatOther = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Size", "Standard"), new Statistic("Type", "Beast"),
                new Statistic("Base", "25x25mm"))));
        ModelPart DL_MyrmidonsStat_Other = new ModelPart(
                "Other", DL_MyrmidonsStatStatOther, new ArrayList<>(), new ArrayList<>());

        ArrayList<ModelPart> DL_MyrmidonsStat_modelParts = new ArrayList<>(Arrays.asList(
                DL_MyrmidonsStatGlobal, DL_MyrmidonsStatDefensive, DL_MyrmidonsStatOffensive, DL_MyrmidonsStat_Other));

        QuantityDependentOption DL_Myrmidons_Op00 = new QuantityDependentOption(hotBlood, 1, 10);
        QuantityDependentOption DL_Myrmidons_Op01 = new QuantityDependentOption(bronzeBackbone, 4, 10);

        MultipleChoiceOptionSet DL_Myrmidons_OptionSet0 = new MultipleChoiceOptionSet(new ArrayList<>(Arrays.asList(
                DL_Myrmidons_Op00, DL_Myrmidons_Op01)));

        ArrayList<OptionSet> optionsetDL_Myrmidons = new ArrayList<>(Arrays.asList(
                DL_Myrmidons_OptionSet0, fcgOptionSet));

        UnitProfile myrmidons = new UnitProfile(
                "Myrmidons", DL_MyrmidonsStat_modelParts, optionsetDL_Myrmidons,
                215, 10, 30, 22);
        myrmidons.setPool(pool);
//CLAWED FIENDS
        Statline DL_ClawedFiendsStatG = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Adv", "9\""), new Statistic("Mar", "18\""),
                new Statistic("Dis", "7"))));
        ArrayList<SpecialRule> DL_ClawedFiendsStatSrG = new ArrayList<>(Arrays.asList(
                supernal, fearless, scoring));
        ModelPart DL_ClawedFiendsStatGlobal = new ModelPart(
                "Global", DL_ClawedFiendsStatG, DL_ClawedFiendsStatSrG, new ArrayList<>());

        Statline DL_ClawedFiendsStatStatD = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("HP", "3"), new Statistic("Def", "4"),
                new Statistic("Res", "4"), new Statistic("Arm", "0"),
                new Statistic("Aeg", "5+"))));
        ArrayList<SpecialRule>DL_ClawedFiendsSrD = new ArrayList<>();
        ModelPart DL_ClawedFiendsStatDefensive = new ModelPart(
                "Defensive", DL_ClawedFiendsStatStatD, DL_ClawedFiendsSrD, new ArrayList<>());

        Statline DL_ClawedFiendsStatStatO = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Att", "3"), new Statistic("Off", "4"),
                new Statistic("Str", "4"), new Statistic("AP", "2"),
                new Statistic("Agi", "4"))));
        ArrayList<SpecialRule> DL_ClawedFiendsStatSrO = new ArrayList<>(Collections.singletonList(smother));
        ModelPart DL_ClawedFiendsStatOffensive = new ModelPart(
                "Offensive", DL_ClawedFiendsStatStatO, DL_ClawedFiendsStatSrO, new ArrayList<>(Collections.singletonList(
                energyBolts)));

        Statline DL_ClawedFiendsStatStatOther = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Size", "Large"), new Statistic("Type", "Beast"),
                new Statistic("Base", "40x40mm"))));
        ModelPart DL_ClawedFiendsStat_Other = new ModelPart(
                "Other", DL_ClawedFiendsStatStatOther, new ArrayList<>(), new ArrayList<>());

        ArrayList<ModelPart> DL_ClawedFiendsStat_modelParts = new ArrayList<>(Arrays.asList(
                DL_ClawedFiendsStatGlobal, DL_ClawedFiendsStatDefensive,
                DL_ClawedFiendsStatOffensive, DL_ClawedFiendsStat_Other));

        QuantityDependentOption DL_ClawedFiends_Op00 = new QuantityDependentOption(darkHide, 6, 3);
        QuantityDependentOption DL_ClawedFiends_Op01 = new QuantityDependentOption(broodmother, 15, 3);

        MultipleChoiceOptionSet DL_ClawedFiends_OptionSet0 = new MultipleChoiceOptionSet(new ArrayList<>(Arrays.asList(
                DL_ClawedFiends_Op00, DL_ClawedFiends_Op01)));

        ArrayList<OptionSet> optionsetDL_ClawedFiends = new ArrayList<>(Arrays.asList(
                DL_ClawedFiends_OptionSet0, fcgOptionSet));

        UnitProfile clawedFiends = new UnitProfile(
                "Clawed Fiends", DL_ClawedFiendsStat_modelParts, optionsetDL_ClawedFiends,
                230, 3, 6, 97);
        clawedFiends.setPool(pool);
//HOARDERS
        Statline DL_HoardersStatG = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Adv", "5\""), new Statistic("Mar", "10\""),
                new Statistic("Dis", "8"))));
        ArrayList<SpecialRule> DL_HoardersStatSrG = new ArrayList<>(Arrays.asList(
                supernal, fearless, scoring));
        ModelPart DL_HoardersStatGlobal = new ModelPart(
                "Global", DL_HoardersStatG, DL_HoardersStatSrG, new ArrayList<>());

        Statline DL_HoardersStatStatD = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("HP", "4"), new Statistic("Def", "5"),
                new Statistic("Res", "5"), new Statistic("Arm", "0"),
                new Statistic("Aeg", "5+"))));
        ArrayList<SpecialRule>DL_HoardersSrD = new ArrayList<>();
        ModelPart DL_HoardersStatDefensive = new ModelPart(
                "Defensive", DL_HoardersStatStatD, DL_HoardersSrD, new ArrayList<>());

        Statline DL_HoardersStatStatO = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Att", "3"), new Statistic("Off", "3"),
                new Statistic("Str", "4"), new Statistic("AP", "1"),
                new Statistic("Agi", "2"))));
        ArrayList<SpecialRule> DL_HoardersStatSrO = new ArrayList<>(Collections.singletonList(tighteningGrasp));
        ModelPart DL_HoardersStatOffensive = new ModelPart(
                "Offensive", DL_HoardersStatStatO, DL_HoardersStatSrO, new ArrayList<>(Collections.singletonList(
                        energyBolts)));

        Statline DL_HoardersStatStatOther = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Size", "Large"), new Statistic("Type", "Beast"),
                new Statistic("Base", "40x40mm"))));
        ModelPart DL_HoardersStat_Other = new ModelPart(
                "Other", DL_HoardersStatStatOther, new ArrayList<>(), new ArrayList<>());

        ArrayList<ModelPart> DL_HoardersStat_modelParts = new ArrayList<>(Arrays.asList(
                DL_HoardersStatGlobal, DL_HoardersStatDefensive,
                DL_HoardersStatOffensive, DL_HoardersStat_Other));

        QuantityDependentOption DL_Hoarders_Op00 = new QuantityDependentOption(
                dextrousTentacles, 3, 3);
        QuantityDependentOption DL_Hoarders_Op01 = new QuantityDependentOption(
                unnaturalRoots, 8, 3);

        MultipleChoiceOptionSet DL_Hoarders_OptionSet0 = new MultipleChoiceOptionSet(new ArrayList<>(Arrays.asList(
                DL_Hoarders_Op00, DL_Hoarders_Op01)));

        ArrayList<OptionSet> optionsetDL_Hoarders = new ArrayList<>(Arrays.asList(
                DL_Hoarders_OptionSet0, fcgOptionSet));

        UnitProfile hoarders = new UnitProfile(
                "Hoarders", DL_HoardersStat_modelParts, optionsetDL_Hoarders,
                295, 3, 6, 118);
        hoarders.setPool(pool);
//HELLHOUNDS
        Statline DL_HellhoundsStatG = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Adv", "9\""), new Statistic("Mar", "18\""),
                new Statistic("Dis", "7"))));
        ArrayList<SpecialRule> DL_HellhoundsStatSrG = new ArrayList<>(Arrays.asList(supernal, fearless, scoring));
        ModelPart DL_HellhoundsStatGlobal = new ModelPart(
                "Global", DL_HellhoundsStatG, DL_HellhoundsStatSrG, new ArrayList<>());

        Statline DL_HellhoundsStatStatD = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("HP", "1"), new Statistic("Def", "3"),
                new Statistic("Res", "4"), new Statistic("Arm", "0"),
                new Statistic("Aeg", "5+"))));
        ArrayList<SpecialRule>DL_HellhoundsSrD = new ArrayList<>();
        ModelPart DL_HellhoundsStatDefensive = new ModelPart(
                "Defensive", DL_HellhoundsStatStatD, DL_HellhoundsSrD, new ArrayList<>());

        Statline DL_HellhoundsStatStatO = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Att", "3"), new Statistic("Off", "5"),
                new Statistic("Str", "3"), new Statistic("AP", "0"),
                new Statistic("Agi", "4"))));
        ArrayList<SpecialRule> DL_HellhoundsStatSrO = new ArrayList<>(Collections.singletonList(smother));
        ModelPart DL_HellhoundsStatOffensive = new ModelPart(
                "Offensive", DL_HellhoundsStatStatO, DL_HellhoundsStatSrO, new ArrayList<>(
                        Collections.singletonList(energyBolts)));

        Statline DL_HellhoundsStatStatOther = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Size", "Large"), new Statistic("Type", "Beast"),
                new Statistic("Base", "25x50mm"))));
        ModelPart DL_HellhoundsStat_Other = new ModelPart(
                "Other", DL_HellhoundsStatStatOther, new ArrayList<>(), new ArrayList<>());

        ArrayList<ModelPart> DL_HellhoundsStat_modelParts = new ArrayList<>(Arrays.asList(
                DL_HellhoundsStatGlobal, DL_HellhoundsStatDefensive,
                DL_HellhoundsStatOffensive, DL_HellhoundsStat_Other));

        QuantityDependentOption DL_Hellhounds_Op00 = new QuantityDependentOption(
                centipedeLegs, 3, 5);
        QuantityDependentOption DL_Hellhounds_Op01 = new QuantityDependentOption(
                graspingProboscis, 1, 5);

        MultipleChoiceOptionSet DL_Hellhounds_OptionSet0 = new MultipleChoiceOptionSet(new ArrayList<>(Arrays.asList(
                DL_Hellhounds_Op00, DL_Hellhounds_Op01, championOption)));

        ArrayList<OptionSet> optionsetDL_Hellhounds = new ArrayList<>(Collections.singletonList(
                DL_Hellhounds_OptionSet0));

        UnitProfile hellhounds = new UnitProfile(
                "Hellhounds", DL_HellhoundsStat_modelParts, optionsetDL_Hellhounds,
                170, 5, 15, 20);
        hellhounds.setPool(pool);
//FURIES
        Statline DL_FuriesStatG = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Adv", "4\""), new Statistic("Mar", "8\""),
                new Statistic("Dis", "5"))));
        ArrayList<SpecialRule> DL_FuriesStatSrG = new ArrayList<>(Arrays.asList(
                supernal, fearless, new SpecialRule("Fly", "", "10\", 20\""),
                lightTroops, skirmisher));
        ModelPart DL_FuriesStatGlobal = new ModelPart(
                "Global", DL_FuriesStatG, DL_FuriesStatSrG, new ArrayList<>());

        Statline DL_FuriesStatStatD = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("HP", "1"), new Statistic("Def", "3"),
                new Statistic("Res", "3"), new Statistic("Arm", "0"),
                new Statistic("Aeg", "6+"))));
        hardTarget.setParameter("1");
        ArrayList<SpecialRule>DL_FuriesSrD = new ArrayList<>(Collections.singletonList(hardTarget));
        ModelPart DL_FuriesStatDefensive = new ModelPart(
                "Defensive", DL_FuriesStatStatD, DL_FuriesSrD, new ArrayList<>());

        Statline DL_FuriesStatStatO = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Att", "1"), new Statistic("Off", "3"),
                new Statistic("Str", "4"), new Statistic("AP", "1"),
                new Statistic("Agi", "4"))));
        devastatingCharge.setParameter("+1 Str");
        ArrayList<SpecialRule> DL_FuriesStatSrO = new ArrayList<>(Collections.singletonList(devastatingCharge));
        ModelPart DL_FuriesStatOffensive = new ModelPart(
                "Offensive", DL_FuriesStatStatO, DL_FuriesStatSrO, new ArrayList<>(
                        Collections.singletonList(energyBolts)));

        Statline DL_FuriesStatStatOther = new Statline(new ArrayList<>(Arrays.asList(
                new Statistic("Size", "Large"), new Statistic("Type", "Beast"),
                new Statistic("Base", "40x40mm"))));
        ModelPart DL_FuriesStat_Other = new ModelPart(
                "Other", DL_FuriesStatStatOther, new ArrayList<>(), new ArrayList<>());

        ArrayList<ModelPart> DL_FuriesStat_modelParts = new ArrayList<>(Arrays.asList(
                DL_FuriesStatGlobal, DL_FuriesStatDefensive, DL_FuriesStatOffensive, DL_FuriesStat_Other));

        QuantityDependentOption DL_Furies_Op00 = new QuantityDependentOption(venomSacs, 2, 5);

        MultipleChoiceOptionSet DL_Furies_OptionSet0 = new MultipleChoiceOptionSet(new ArrayList<>(
                Collections.singletonList(DL_Furies_Op00)));

        ArrayList<OptionSet> optionsetDL_Furies = new ArrayList<>(Collections.singletonList(DL_Furies_OptionSet0));

        UnitProfile furies = new UnitProfile(
                "Furies", DL_FuriesStat_modelParts, optionsetDL_Furies,
                160, 5, 15, 15);
        furies.setPool(pool);
//VEIL SERPENTS

        //ARMY CATEGORIES DL
        ArmySubcategory DL_Characters = new ArmySubcategory("Heroes", new ArrayList<>(Arrays.asList(
                harbingerOfFatherChaos, omenOfSavar)));
        ArmySubcategory DL_Core = new ArmySubcategory("Common Troops", new ArrayList<>(Arrays.asList(
                imps, myrmidons)));
        ArmySubcategory DL_Special = new ArmySubcategory("Elite Units", new ArrayList<>(Arrays.asList(
                clawedFiends, hoarders, hellhounds)));
        ArmySubcategory DL_Aves= new ArmySubcategory("Flying Daemons", new ArrayList<>(Arrays.asList(
                furies)));

        Army dl = new Army("Daemons", new ArrayList<>(Arrays.asList(
                DL_Characters, DL_Core, DL_Special, DL_Aves)));

        ArmySubcategory EoS_Characters = new ArmySubcategory("Heroes", new ArrayList<>());
        ArmySubcategory EoS_Core = new ArmySubcategory("Common Troops", new ArrayList<>());
        ArmySubcategory EoS_Special = new ArmySubcategory("Elite Units", new ArrayList<>());
        ArmySubcategory EoS_IAux = new ArmySubcategory("Shooting Infantry", new ArrayList<>());
        ArmySubcategory EoS_IArm = new ArmySubcategory("Artillery", new ArrayList<>());
        ArmySubcategory EoS_SF = new ArmySubcategory("Zealots", new ArrayList<>());

        Army eos = new Army("Empire", new ArrayList<>(Arrays.asList(
                EoS_Characters, EoS_Core, EoS_Special, EoS_IAux, EoS_IArm, EoS_SF)));

        ArmySubcategory ID_Characters = new ArmySubcategory("Heroes", new ArrayList<>());
        ArmySubcategory ID_Core = new ArmySubcategory("Common Troops", new ArrayList<>());
        ArmySubcategory ID_Special = new ArmySubcategory("Elite Units", new ArrayList<>());
        ArmySubcategory ID_HotG = new ArmySubcategory("Shooting Troops", new ArrayList<>());
        ArmySubcategory ID_Barr = new ArmySubcategory("Artillery", new ArrayList<>());
        ArmySubcategory ID_BB = new ArmySubcategory("Bound Daemons", new ArrayList<>());

        Army id = new Army("Dark Dwarves", new ArrayList<>(Arrays.asList(
                ID_Characters, ID_Core, ID_Special, ID_HotG, ID_Barr, ID_BB)));


        ArmySubcategory KoE_Characters = new ArmySubcategory("Heroes", new ArrayList<>());
        ArmySubcategory KoE_Core = new ArmySubcategory("Common Troops", new ArrayList<>());
        ArmySubcategory KoE_Special = new ArmySubcategory("Elite Units", new ArrayList<>());
        ArmySubcategory KoE_AG = new ArmySubcategory("Airborne Knights", new ArrayList<>());

        Army koe = new Army("Kingdom", new ArrayList<>(Arrays.asList(
                KoE_Characters, KoE_Core, KoE_Special, KoE_AG)));

        bh.setAlliableArmyIndexes(new ArrayList<>(Arrays.asList(0, 1)));
        T9A.setAllowingAlliances(true);
        T9A.setMaxDetachments(3);
        T9A.setArmies(new ArrayList<>(Arrays.asList(bh, dl, eos, id, koe)));
        T9A.setPool(pool);
        T9A.setRules(new ArrayList<>(Collections.singletonList(new MustHaveExactly(general, 1))));
        T9A.setScenarios(new ArrayList<>());
        return T9A;
    }
}
