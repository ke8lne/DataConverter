import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.digidemic.unitof.UnitOf;

public class Types {
     Object converters[];
     List<String> namesList;
     List<List<String>> typesList;

     static String names[] = {
          "Acceleration",
          "Angle",
          "Area",
          "Data Storage",
          "Data Transfer Rate",
          "Electric Charge",
          "Force",
          "Frequency",
          "Fuel Economy",
          "Length",
          "Mass",
          "Metric Prefix",
          "Numeric Base",
          "Pressure",
          "Speed",
          "Temperature",
          "Time",
          "Torque",
          "Volume"
     };
     static String types[][] = {
          // Acceleration
          { "AttometersPerSecondSquared", "CentimeterPerSecondSquared", "DecimetersPerSecondSquared", "DekametersPerSecondSquared", "ExametersPerSecondSquared", "FeetPerHourPerSecond", "FeetPerMinutePerSecond", "FeetPerSecondSquared", "FemtometersPerSecondSquared", "Galileos", "GigametersPerSecondSquared", "Gravity", "HectometersPerSecondSquared", "InchesPerMinutePerSecond", "InchesPerSecondSquared", "KilometersPerHourPerSecond", "KilometersPerHourSquared", "KilometersPerSecondSquared", "KnotsPerSecond", "MegametersPerSecondSquared", "MetersPerSecondSquared", "Microgalileos", "MicrometersPerSecondSquared", "MilesPerHourPerSecond", "MilesPerMinutePerSecond", "MilesPerSecondSquared", "Milligalileos", "MillimetersPerSecondSquared", "NanometersPerSecondSquared", "PetametersPerSecondSquared", "PicometersPerSecondSquared", "TerametersPerSecondSquared", "YardsPerSecondSquared" },
          // Angle
          { "Circles", "Degrees", "Gradians", "Mils", "Minutes", "Quadrants", "Radians", "Revolutions", "RightAngles", "Seconds", "Sextants", "Signs", "Turns" },
          // Area
          { "Acres", "Ares", "Arpents", "Barns", "CircularInches", "CircularMils", "Hectares", "Homesteads", "Roods", "Sabins", "SquareCentimeters", "SquareChains", "SquareDecimeters", "SquareDekameters", "SquareFeet", "SquareHectometers", "SquareInches", "SquareKilometers", "SquareMeters", "SquareMicrometers", "SquareMiles", "SquareMillimeters", "SquareNanometers", "SquarePerches", "SquarePoles", "SquareRods", "SquareYards" },
          // Data Storage
          { "Bits", "Blocks", "BluRay_DoubleLayer", "BluRay_SingleLayer", "Bytes", "CDs_74Minutes", "CDs_80Minutes", "DVDs_DoubleSidedDoubleLayer", "DVDs_DoubleSidedSingleLayer", "DVDs_SingleSidedDoubleLayer", "DVDs_SingleSidedSingleLayer", "Exabits", "Exabytes", "FloppyDisks_35DD", "FloppyDisks_35ED", "FloppyDisks_35HD", "FloppyDisks_525DD", "FloppyDisks_525HD", "Gigabits", "Gigabytes", "Kilobits", "Kilobytes", "Megabits", "Megabytes", "Nibbles", "Petabits", "Petabytes", "SIUnitExabits", "SIUnitExabytes", "SIUnitGigabits", "SIUnitGigabytes", "SIUnitKilobits", "SIUnitKilobytes", "SIUnitMegabits", "SIUnitMegabytes", "SIUnitPetabits", "SIUnitPetabytes", "SIUnitTerabits", "SIUnitTerabytes", "SIUnitYottabits", "SIUnitYottabytes", "SIUnitZettabits", "SIUnitZettabytes", "Terabits", "Terabytes", "Words", "Yottabits", "Yottabytes", "Zettabits", "Zettabytes" },
          // Data Transfer Rate
          { "BitsPerSecond", "BytesPerSecond", "EthernetsBase10", "EthernetsBase100", "EthernetsBase1000", "FireWires400", "FireWires800", "FireWiresS1600_S3200", "GigabitsPerSecond", "GigabytesPerSecond", "ISDNsDual", "ISDNsSingle", "KilobitsPerSecond", "KilobytesPerSecond", "MegabitsPerSecond", "MegabytesPerSecond", "Modems110b", "Modems1200b", "Modems14_4k", "Modems2400b", "Modems28_8k", "Modems300b", "Modems33_6k", "Modems56k", "Modems9600b", "OCs1", "OCs12", "OCs192", "OCs24", "OCs3", "OCs48", "OCs768", "PetabitsPerSecond", "PetabytesPerSecond", "SIUnitGigabitsPerSecond", "SIUnitGigabytesPerSecond", "SIUnitKilobitsPerSecond", "SIUnitKilobytesPerSecond", "SIUnitMegabitsPerSecond", "SIUnitMegabytesPerSecond", "SIUnitPetabitsPerSecond", "SIUnitPetabytesPerSecond", "SIUnitTerabitsPerSecond", "SIUnitTerabytesPerSecond", "TerabitsPerSecond", "TerabytesPerSecond", "USBs1_0", "USBs2_0", "USBs3_0", "USBs3_1" },
          // Electric Charge
          { "Abcoulombs", "AmpereHours", "AmpereMinutes", "AmpereSeconds", "Coulombs", "EMUsOfCharge", "ESUsOfCharge", "ElectronCharge", "FaradVolts", "FaradayCarbon12", "FaradayChemistry", "FaradayPhysics", "Franklins", "Kilocoulombs", "Megacoulombs", "Microcoulombs", "Millicoulombs", "Nanocoulombs", "Picocoulombs", "Statcoulombs" },
          // Force
          { "AtomicUnitsOfForce", "Attonewtons", "Centinewtons", "Decinewtons", "Dekanewtons", "Dynes", "Exanewtons", "Femtonewtons", "Giganewtons", "GramForces", "GraveForces", "Hectonewtons", "JouleCentimeters", "JouleMeters", "KilogramForces", "Kilonewtons", "Kiloponds", "KilopoundForces", "LongTonForces", "Meganewtons", "MetricTonForces", "Micronewtons", "MilligraveForces", "Millinewtons", "Nanonewtons", "Newtons", "OunceForces", "Petanewtons", "Piconewtons", "Ponds", "PoundFeetPerSecondSquared", "PoundForces", "Poundals", "ShortTonForces", "Sthenes", "Teranewtons" },
          // Frequency
          { "Attohertz", "Centihertz", "CyclesPerSecond", "Decihertz", "Dekahertz", "Exahertz", "Femtohertz", "Gigahertz", "Hectohertz", "Hertz", "Kilohertz", "Megahertz", "Microhertz", "Millihertz", "Nanohertz", "Petahertz", "Picohertz", "RevolutionsPerDay", "RevolutionsPerHour", "RevolutionsPerMinute", "RevolutionsPerSecond", "Terahertz" },
          // Fuel Economy
          { "CentimetersPerLiter", "DekametersPerLiter", "ExametersPerLiter", "GigametersPerLiter", "HectometersPerLiter", "KilometersPerGallonUK", "KilometersPerGallonUS", "KilometersPerLiter", "MegametersPerLiter", "MetersPerCubicCentimeter", "MetersPerCubicFoot", "MetersPerCubicInch", "MetersPerCubicMeter", "MetersPerCubicYard", "MetersPerCupUK", "MetersPerCupUS", "MetersPerFluidOunceUK", "MetersPerFluidOunceUS", "MetersPerGallonUK", "MetersPerGallonUS", "MetersPerLiter", "MetersPerPintUK", "MetersPerPintUS", "MetersPerQuartUK", "MetersPerQuartUS", "MilesPerGallonUK", "MilesPerGallonUS", "MilesPerLiterUS", "NauticalMilesPerGallonUS", "NauticalMilesPerLiter", "PetametersPerLiter", "TerametersPerLiter" },
          // Length
          { "Angstroms", "Attometers", "Barleycorns", "CablesImperial", "CablesInternational", "CablesUSCustomary", "Caliber", "Centiinches", "Centimeters", "Chains", "Cubits", "Decimeters", "Dekameters", "Ells", "Exameters", "Fathoms", "Feet", "Femtometers", "Fingers", "Furlongs", "Gigameters", "Hands", "Hectometers", "Inches", "Kilometers", "Kiloyards", "Leagues", "LightYears", "Links", "Megameters", "Meters", "Microinches", "Micrometers", "Microns", "Miles", "Millimeters", "Nails", "Nanometers", "NauticalLeaguesInternational", "NauticalLeaguesUK", "NauticalMilesInternational", "NauticalMilesUK", "NauticalMilesUSCustomary", "Perches", "Petameters", "Picometers", "Poles", "Rods", "Ropes", "Spans", "Terameters", "ThousandthInches", "Yardss" },
          // Mass
          { "Attograms", "Carats", "Centigrams", "Centners", "Decigrams", "Dekagrams", "Exagrams", "Femtograms", "Gamma", "Gigagrams", "Grams", "Hectograms", "Kilograms", "Kilopounds", "KilotonsMetric", "Megagrams", "Micrograms", "Milligrams", "Nanograms", "OuncesMetric", "OuncesUS", "Petagrams", "Picograms", "Pounds", "Quintals", "Slugs", "StonesUK", "StonesUS", "Teragrams", "TonsImperial", "TonsMetric", "TonsUS" },
          // Metric Prefix
          { "Atto", "Centi", "Deci", "Deka", "Exa", "Femto", "Giga", "Hecto", "Kilo", "Mega", "Micro", "Milli", "Nano", "NoPrefix", "Peta", "Pico", "Tera", "Yocto", "Yotta", "Zepto", "Zetta" },
          // Numeric Base
          { "Base11", "Base12", "Base13", "Base14", "Base15", "Base17", "Base18", "Base19", "Base20", "Base21", "Base22", "Base23", "Base24", "Base25", "Base26", "Base27", "Base28", "Base29", "Base3", "Base30", "Base31", "Base32", "Base33", "Base34", "Base35", "Base36", "Base4", "Base5", "Base6", "Base7", "Base9", "Binary", "Decimal", "Hexadecimal", "Octal" },
          // Pressure
          { "Attopascals", "Bars", "Baryes", "CentimetersOfMercury0C", "CentimetersOfWater4C", "Centipascals", "Decibars", "Decipascals", "Dekapascals", "DynesPerSquareCentimeter", "Exapascals", "FeetOfSeaWater", "FeetOfWater4C", "FeetOfWater60F", "Femtopascals", "Gigapascals", "GramsPerSquareCentimeter", "Hectopascals", "InchesOfMercury32F", "InchesOfMercury60F", "InchesOfWater4C", "InchesOfWater60F", "KSI", "KilogramsPerSquareCentimeter", "KilogramsPerSquareMeter", "KilogramsPerSquareMillimeter", "KilonewtonsPerSquareMeter", "Kilopascals", "KipsPerSquareInch", "LongTonsPerSquareFoot", "LongTonsPerSquareInch", "Megapascals", "MetersOfSeaWater", "MetersOfWater4C", "Microbars", "Micropascals", "Millibars", "MillimetersOfMercury0C", "MillimetersOfWater4C", "Millipascals", "Nanopascals", "NewtonsPerSquareCentimeter", "NewtonsPerSquareMeter", "NewtonsPerSquareMillimeter", "PSI", "Pascals", "Petapascals", "Picopascals", "Pieze", "PoundalsPerSquareFoot", "PoundsPerSquareFoot", "PoundsPerSquareInch", "ShortTonsPerSquareFoot", "ShortTonsPerSquareInch", "StandardAtmospheres", "SthenesPerSquareMeter", "TechnicalAtmospheres", "Terapascals", "Torrs" },
          // Speed
          { "CentimetersPerHour", "CentimetersPerMinute", "CentimetersPerSecond", "EarthsVelocity", "FeetPerHour", "FeetPerMinute", "FeetPerSecond", "FirstCosmicVelocity", "InchesPerHour", "InchesPerMinute", "InchesPerSecond", "KilometersPerHour", "KilometersPerMinute", "KilometersPerSecond", "Knots", "Light", "Mach", "MetersPerHour", "MetersPerMinute", "MetersPerSecond", "MilesPerHour", "MilesPerMinute", "MilesPerSecond", "MillimetersPerHour", "MillimetersPerMinute", "MillimetersPerSecond", "SecondCosmicVelocity", "SoundsInAir", "SoundsInWater", "ThirdCosmicVelocity", "YardsPerHour", "YardsPerMinute", "YardsPerSecond" },
          // Temperature
          { "Celsius", "Fahrenheit", "Kelvin", "Rankine", "Reaumur" },
          // Time
          { "Attoseconds", "Centuries", "Days", "Decades", "Femtoseconds", "Fortnights", "GregorianYears", "Hours", "JulianYears", "LeapYears", "Microseconds", "Millenniums", "Milliseconds", "Minutes", "Months", "Nanoseconds", "Picoseconds", "Seconds", "Weeks", "Years" },
          // Torque
          { "DyneCentimeters", "DyneMeters", "DyneMillimeters", "GramCentimeters", "GramMeters", "GramMillimeters", "KilogramCentimeters", "KilogramMeters", "KilogramMillimeters", "KilonewtonMeters", "NewtonCentimeters", "NewtonMeters", "NewtonMillimeters", "OunceFeet", "OunceInches", "PoundFeet", "PoundInches" },
          // Volume
          { "AcreFeetUSSurvey", "AcreInches", "ArceFeet", "Attoliters", "BarrelsOfOil", "BarrelsUK", "BarrelsUS", "BoardFeet", "Centiliters", "Cords", "CubicCentimeters", "CubicDecimeters", "CubicFeet", "CubicInches", "CubicKilometers", "CubicMeters", "CubicMiles", "CubicMillimeters", "CubicYards", "CupsMetric", "CupsUK", "CupsUS", "Deciliters", "Decisteres", "Dekaliters", "Dekasteres", "DessertspoonsUK", "DessertspoonsUS", "Drops", "Exaliters", "Femtoliters", "FluidOuncesUK", "FluidOuncesUS", "GallonsUK", "GallonsUS", "Gigaliters", "GillsUK", "GillsUS", "Hectoliters", "Hogsheads", "HundredCubicFeet", "Kiloliters", "Liters", "Megaliters", "Microliters", "Milliliters", "MinimsUK", "MinimsUS", "Nanoliters", "Petaliters", "Picoliters", "PintsUK", "PintsUS", "QuartsUK", "QuartsUS", "RegisterTons", "Steres", "TablespoonsMetric", "TablespoonsUK", "TablespoonsUS", "TeaspoonsMetric", "TeaspoonsUK", "TeaspoonsUS", "Teraliters", "Tuns" }
     };

     Types() {
          converters = new Object[] {
               new UnitOf.Acceleration(),
               new UnitOf.Angle(),
               new UnitOf.Area(),
               new UnitOf.DataStorage(),
               new UnitOf.DataTransferRate(),
               new UnitOf.ElectricCharge(),
               new UnitOf.Force(),
               new UnitOf.Frequency(),
               new UnitOf.FuelEconomy(),
               new UnitOf.Length(),
               new UnitOf.Mass(),
               new UnitOf.MetricPrefix(),
               new UnitOf.NumericBase(),
               new UnitOf.Pressure(),
               new UnitOf.Speed(),
               new UnitOf.Temperature(),
               new UnitOf.Time(),
               new UnitOf.Torque(),
               new UnitOf.Volume()
          };
          namesList = Arrays.asList(names);
          typesList = new ArrayList<>();
          for (int i = 0; i < types.length; i++) {
               List<String> _aTemp = Arrays.asList(types[i]);
               typesList.add(_aTemp);
          }
     }
}
