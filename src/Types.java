import com.digidemic.unitof.UnitOf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Types {
     Object converters[];
     List<String> namesList;
     List<List<String>> typesList;
     List<List<String>> symbolsList;
     static String names[] = {
               "Acceleration", "Angle", "Area", "Data Storage", "Data Transfer Rate", "Electric Charge", "Force", "Frequency", "Fuel Economy", "Length", "Mass", "Metric Prefix", "Numeric Base", "Pressure", "Speed", "Temperature",
               "Time", "Torque", "Volume"
     };
     // Default Sorting based on the output value from low to high.
     static String types[][] = {
               // Acceleration
               {
                         "Microgalileos", "Milligalileos", "Galileos", "Gravity", "InchesPerMinutePerSecond", "FeetPerHourPerSecond", "FeetPerMinutePerSecond", "KilometersPerHourPerSecond", "KnotsPerSecond",
                         "InchesPerSecondSquared", "FeetPerSecondSquared", "YardsPerSecondSquared", "MilesPerSecondSquared", "MicrometersPerSecondSquared", "MillimetersPerSecondSquared", "NanometersPerSecondSquared",
                         "PicometersPerSecondSquared", "FemtometersPerSecondSquared", "AttometersPerSecondSquared", "MilesPerHourPerSecond", "KilometersPerHourSquared", "KilometersPerSecondSquared", "MetersPerSecondSquared",
                         "DekametersPerSecondSquared", "HectometersPerSecondSquared", "GigametersPerSecondSquared", "MegametersPerSecondSquared", "ExametersPerSecondSquared", "PetametersPerSecondSquared"
               },
               // Angle
               {
                         "Circles", "Degrees", "Gradians", "Mils", "Minutes", "Quadrants", "Radians", "Revolutions", "RightAngles", "Seconds", "Sextants", "Signs", "Turns"
               },
               // Area - Unsort
               {
                         "Acres", "Ares", "Arpents", "Barns", "CircularInches", "CircularMils", "Hectares", "Homesteads", "Roods", "Sabins", "SquareCentimeters", "SquareChains", "SquareDecimeters", "SquareDekameters",
                         "SquareFeet", "SquareHectometers", "SquareInches", "SquareKilometers", "SquareMeters", "SquareMicrometers", "SquareMiles", "SquareMillimeters", "SquareNanometers", "SquarePerches", "SquarePoles",
                         "SquareRods", "SquareYards"
               },
               // Data Storage
               {
                         "Bits", "Nibbles", "Bytes", "Words", "Blocks", "CDs_74Minutes", "CDs_80Minutes", "BluRay_SingleLayer", "BluRay_DoubleLayer", "DVDs_SingleSidedSingleLayer", "DVDs_SingleSidedDoubleLayer",
                         "DVDs_DoubleSidedSingleLayer", "DVDs_DoubleSidedDoubleLayer", "FloppyDisks_35HD", "FloppyDisks_35DD", "FloppyDisks_525DD", "FloppyDisks_525HD", "SIUnitKilobits", "SIUnitKilobytes", "SIUnitMegabits",
                         "SIUnitMegabytes", "SIUnitGigabits", "SIUnitGigabytes", "SIUnitTerabits", "SIUnitTerabytes", "SIUnitPetabits", "SIUnitPetabytes", "SIUnitExabits", "SIUnitExabytes", "SIUnitZettabits", "SIUnitZettabytes",
                         "SIUnitYottabits", "SIUnitYottabytes"
               },
               // Data Transfer Rate
               {
                         "BitsPerSecond", "BytesPerSecond", "EthernetsBase10", "EthernetsBase100", "EthernetsBase1000", "FireWires400", "FireWires800", "FireWiresS1600_S3200", "GigabitsPerSecond", "GigabytesPerSecond",
                         "ISDNsDual", "ISDNsSingle", "KilobitsPerSecond", "KilobytesPerSecond", "MegabitsPerSecond", "MegabytesPerSecond", "Modems110b", "Modems1200b", "Modems14_4k", "Modems2400b", "Modems28_8k", "Modems300b",
                         "Modems33_6k", "Modems56k", "Modems9600b", "OCs1", "OCs12", "OCs192", "OCs24", "OCs3", "OCs48", "OCs768", "PetabitsPerSecond", "PetabytesPerSecond", "SIUnitGigabitsPerSecond", "SIUnitGigabytesPerSecond",
                         "SIUnitKilobitsPerSecond", "SIUnitKilobytesPerSecond", "SIUnitMegabitsPerSecond", "SIUnitMegabytesPerSecond", "SIUnitPetabitsPerSecond", "SIUnitPetabytesPerSecond", "SIUnitTerabitsPerSecond",
                         "SIUnitTerabytesPerSecond", "TerabitsPerSecond", "TerabytesPerSecond", "USBs1_0", "USBs2_0", "USBs3_0", "USBs3_1"
               },
               // Electric Charge
               {
                         "Abcoulombs", "AmpereHours", "AmpereMinutes", "AmpereSeconds", "Coulombs", "EMUsOfCharge", "ESUsOfCharge", "ElectronCharge", "FaradVolts", "FaradayCarbon12", "FaradayChemistry", "FaradayPhysics",
                         "Franklins", "Kilocoulombs", "Megacoulombs", "Microcoulombs", "Millicoulombs", "Nanocoulombs", "Picocoulombs", "Statcoulombs"
               },
               // Force - Unsort
               {
                         "AtomicUnitsOfForce", "Attonewtons", "Centinewtons", "Decinewtons", "Dekanewtons", "Dynes", "Exanewtons", "Femtonewtons", "Giganewtons", "GramForces", "GraveForces", "Hectonewtons", "JouleCentimeters",
                         "JouleMeters", "KilogramForces", "Kilonewtons", "Kiloponds", "KilopoundForces", "LongTonForces", "Meganewtons", "MetricTonForces", "Micronewtons", "MilligraveForces", "Millinewtons", "Nanonewtons",
                         "Newtons", "OunceForces", "Petanewtons", "Piconewtons", "Ponds", "PoundFeetPerSecondSquared", "PoundForces", "Poundals", "ShortTonForces", "Sthenes", "Teranewtons"
               },
               // Frequency - Sorted
               {
                         "Attohertz", "Centihertz", "Decihertz", "Dekahertz", "Exahertz", "Femtohertz", "Gigahertz", "Hectohertz", "Hertz", "Kilohertz", "Megahertz", "Microhertz", "Millihertz", "Nanohertz", "Petahertz",
                         "Picohertz", "RevolutionsPerDay", "RevolutionsPerHour", "RevolutionsPerMinute", "RevolutionsPerSecond", "Terahertz"
               },
               // Fuel Economy - Sorted
               {
                         "CentimetersPerLiter", "DekametersPerLiter", "ExametersPerLiter", "GigametersPerLiter", "HectometersPerLiter", "KilometersPerGallonUK", "KilometersPerGallonUS", "KilometersPerLiter", "MegametersPerLiter",
                         "MetersPerCubicCentimeter", "MetersPerCubicFoot", "MetersPerCubicInch", "MetersPerCubicMeter", "MetersPerCubicYard", "MetersPerCupUK", "MetersPerCupUS", "MetersPerFluidOunceUK", "MetersPerFluidOunceUS",
                         "MetersPerGallonUK", "MetersPerGallonUS", "MetersPerLiter", "MetersPerPintUK", "MetersPerPintUS", "MetersPerQuartUK", "MetersPerQuartUS", "MilesPerGallonUK", "MilesPerGallonUS", "MilesPerLiterUS",
                         "NauticalMilesPerGallonUS", "NauticalMilesPerLiter", "PetametersPerLiter", "TerametersPerLiter"
               },
               // Length - Sorted
               {
                         "Angstroms", "Attometers", "Barleycorns", "Caliber", "Centiinches", "Centimeters", "Chains", "Cubits", "Decimeters", "Dekameters", "Ells", "Femtometers", "Fingers", "Hands", "Inches", "Links",
                         "Microinches", "Micrometers", "Microns", "Millimeters", "Nails", "Nanometers", "Perches", "Picometers", "Poles", "ThousandthInches", "Spans", "Fathoms", "Feet", "Yardss", "Rods", "Ropes", "Gigameters",
                         "Hectometers", "Kilometers", "Kiloyards", "Leagues", "Megameters", "Meters", "Miles", "NauticalMilesInternational", "NauticalMilesUK", "NauticalMilesUSCustomary", "Furlongs", "LightYears", "Exameters",
                         "Petameters", "Terameters"
               },
               // Mass - Sorted
               {
                         "Attograms", "Femtograms", "Picograms", "Nanograms", "Micrograms", "Milligrams", "Centigrams", "Decigrams", "Grams", "Decagrams", "Hectograms", "Kilograms", "Carats", "OuncesUS", "OuncesMetric", "Pounds",
                         "KilotonsMetric", "Slugs", "StonesUS", "StonesUK", "Quintals", "Centners", "TonsUS", "TonsImperial", "TonsMetric", "Megagrams", "Gigagrams", "Teragrams", "Petagrams", "Exagrams", "Gamma", "Kilopounds"
               },
               // Metric Prefix - Sorted
               {
                         "Yocto", "Zepto", "Atto", "Femto", "Pico", "Nano", "Micro", "Milli", "Centi", "Deci", "NoPrefix", "Deka", "Hecto", "Kilo", "Mega", "Giga", "Tera", "Peta", "Exa", "Zetta", "Yotta"
               },
               // Numeric Base - Sorted
               {
                         "Binary", "Base3", "Base4", "Base5", "Base6", "Base7", "Base9", "Base11", "Base12", "Base13", "Base14", "Base15", "Base17", "Base18", "Base19", "Base20", "Base21", "Base22", "Base23", "Base24", "Base25",
                         "Base26", "Base27", "Base28", "Base29", "Base30", "Base31", "Base32", "Base33", "Base34", "Base35", "Base36", "Decimal", "Octal", "Hexadecimal"
               },
               // Pressure - Sorted
               {
                         "Attopascals", "Bars", "Baryes", "CentimetersOfMercury0C", "CentimetersOfWater4C", "Centipascals", "Decibars", "Decipascals", "Dekapascals", "DynesPerSquareCentimeter", "Exapascals", "FeetOfSeaWater",
                         "FeetOfWater4C", "FeetOfWater60F", "Femtopascals", "Gigapascals", "GramsPerSquareCentimeter", "Hectopascals", "InchesOfMercury32F", "InchesOfMercury60F", "InchesOfWater4C", "InchesOfWater60F", "KSI",
                         "KilogramsPerSquareCentimeter", "KilogramsPerSquareMeter", "KilogramsPerSquareMillimeter", "KilonewtonsPerSquareMeter", "Kilopascals", "KipsPerSquareInch", "LongTonsPerSquareFoot", "LongTonsPerSquareInch",
                         "Megapascals", "MetersOfSeaWater", "MetersOfWater4C", "Microbars", "Micropascals", "Millibars", "MillimetersOfMercury0C", "MillimetersOfWater4C", "Millipascals", "Nanopascals",
                         "NewtonsPerSquareCentimeter", "NewtonsPerSquareMeter", "NewtonsPerSquareMillimeter", "PSI", "Pascals", "Petapascals", "Picopascals", "Pieze", "PoundalsPerSquareFoot", "PoundsPerSquareFoot",
                         "PoundsPerSquareInch", "ShortTonsPerSquareFoot", "ShortTonsPerSquareInch", "StandardAtmospheres", "SthenesPerSquareMeter", "TechnicalAtmospheres", "Terapascals", "Torrs"
               },
               // Speed - Sorted
               {
                         "CentimetersPerHour", "CentimetersPerMinute", "CentimetersPerSecond", "EarthsVelocity", "FeetPerHour", "FeetPerMinute", "FeetPerSecond", "FirstCosmicVelocity", "InchesPerHour", "InchesPerMinute",
                         "InchesPerSecond", "KilometersPerHour", "KilometersPerMinute", "KilometersPerSecond", "Knots", "Light", "Mach", "MetersPerHour", "MetersPerMinute", "MetersPerSecond", "MilesPerHour", "MilesPerMinute",
                         "MilesPerSecond", "MillimetersPerHour", "MillimetersPerMinute", "MillimetersPerSecond", "SecondCosmicVelocity", "SoundsInAir", "SoundsInWater", "ThirdCosmicVelocity", "YardsPerHour", "YardsPerMinute",
                         "YardsPerSecond"
               },
               // Temperature - Sorted
               {
                         "Celsius", "Reaumur", "Fahrenheit", "Rankine", "Kelvin"
               },
               // Time - Sorted
               {
                         "Attoseconds", "Femtoseconds", "Picoseconds", "Nanoseconds", "Microseconds", "Milliseconds", "Seconds", "Minutes", "Hours", "Days", "Weeks", "Fortnights", "Months", "Years", "Decades", "Centuries",
                         "Millenniums", "JulianYears", "LeapYears", "GregorianYears"
               },
               // Torque - Sorted
               {
                         "DyneCentimeters", "DyneMeters", "DyneMillimeters", "GramCentimeters", "GramMeters", "GramMillimeters", "KilogramCentimeters", "KilogramMeters", "KilogramMillimeters", "KilonewtonMeters",
                         "NewtonCentimeters", "NewtonMeters", "NewtonMillimeters", "OunceFeet", "OunceInches", "PoundFeet", "PoundInches"
               },
               // Volume - Sorted
               {
                         "Attoliters", "Femtoliters", "Picoliters", "Nanoliters", "Microliters", "Milliliters", "Centiliters", "Deciliters", "Liters", "Decaliters", "Hectoliters", "Kiloliters", "Megaliters", "Gigaliters",
                         "Teraliters", "Petaliters", "Exaliters", "AcreInches", "AcreFeetUSSurvey", "ArceFeet", "CubicMillimeters", "CubicCentimeters", "CubicDecimeters", "CubicMeters", "CubicKilometers", "CubicInches",
                         "CubicFeet", "CubicYards", "CubicMiles", "BoardFeet", "HundredCubicFeet", "Cords", "RegisterTons", "BarrelsUK", "BarrelsUS", "GallonsUK", "GallonsUS", "QuartsUK", "QuartsUS", "PintsUK", "PintsUS",
                         "CupsUK", "CupsUS", "FluidOuncesUK", "FluidOuncesUS", "GillsUK", "GillsUS", "MinimsUK", "MinimsUS", "Drops", "TeaspoonsUK", "TeaspoonsUS", "TablespoonsUK", "TablespoonsUS", "DessertspoonsUK",
                         "DessertspoonsUS", "BarrelsOfOil", "Tuns", "Hogsheads", "Steres", "Decisteres"
               }
     };
     static String symbols[][] = {
               // Acceleration
               {
                         "µGal", "mGal", "Gal", "G", "in/min/s", "ft/hr/s", "ft/min/s", "km/hr/s", "kt/s", "in/s²", "ft/s²", "yd/s²", "mi/s²", "µm/s²", "mm/s²", "nm/s²", "pm/s²", "fm/s²", "am/s²", "mi/hr/s", "km/hr²", "km/s²",
                         "m/s²", "dam/s²", "hm/s²", "Gm/s²", "Mm/s²", "Em/s²", "Pm/s²"
               },
               // Angle
               {
                         "O", "°", "grad", "mil", "'", null, "rad", "rev", null, null, null, null, "tr"
               },
               // Area - Unsort
               {
                         "ac", "a", "arp", "b", "in²", "cmil", "ha", "hst", "ro", "sb", "cm²", "ch²", "dm²", "dam²", "ft²", "hm²", "in²", "km2", "m²", "µm²", "mi²", "mm²", "nm²", "perch²", "pole²", "rd²", "yd²"
               },
               // Data Storage
               {
                         "b", null, "B", null, null, null, null, null, null, null, null, null, null, null, null, null, null, "kbit", "kB", "Mbit", "MB", "Gbit", "GB", "Tbit", "TB", "Pbit", "PB", "Ebit", "EB", "Zbit", "ZB", "Ybit",
                         "YB"
               },
               // Data Transfer Rate
               {
                         "bps", "B/s", null, null, null, null, null, null, "gbps", "GB/s", null, null, "kbps", "KB/s", "mbps", "MB/s", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                         null, "PB/s", "Gbit/s", "GB/s", "Kbit/s", "KB/s", "Mbit/s", "MB/s", "Pbit/s", "PB/s", "Tbit/s", "TB/s", "Tbps", "TB/s", null, null, null, null
               },
               // Electric Charge
               {
                         "abC", "a-h", "a-min", "a-s", "C", "e", "e", "e", "F-V", "F", "F", "F", "Fr", "kC", "MC", "µC", "mC", "nC", "pC", "statC"
               },
               // Force - Unsort
               {
                         "AU", "aN", "cN", "dN", "daN", "dyn", "EN", "fN", "GN", "gf", "gf", "hN", "J cm", "J m", "kgf", "kN", "kp", "klbf", "ltnf", "MN", "tf", "μN", "mgf", "mN", "nN", "N", "ozf", "PN", "pN", "p", "lb·ft/s²",
                         "lbf", "pdl", "stnf", "sn", "TN"
               },
               // Frequency - Sorted
               {
                         "aHz", "cHz", "dHz", "daHz", "EHz", "fHz", "GHz", "hHz", "Hz", "kHz", "MHz", "μHz", "mHz", "nHz", "PHz", "pHz", "r/d", "r/h", "r/min", "r/s", "Tz"
               },
               // Fuel Economy - Sorted
               {
                         "cm/L", "dam/L", "Em/L", "Gm/L", "hm/L", "km/gal UK", "km/gal US", "km/L", "Mm/L", "m/cm³", "m/ft³", "m/in³", "m/m³", "m/yd³", "m/cup UK", "m/cup US", "m/fl oz UK", "m/fl oz US", "m/gal UK", "m/gal US",
                         "m/L", "m/pint UK", "m/pint US", "m/qt UK", "m/qt US", "mi/gal UK", "mi/gal US", "mi/L US", "nmi/gal US", "nmi/L", "Pm/L", "Tm/L"
               },
               // Length - Sorted
               {
                         "Å", "am", "bc", "cal", "cin", "cm", "ch", "cbt", "dm", "dam", "ell", "fm", "finger", "h", "in", "li", "μin", "μm", "μ", "mm", "nail", "nm", "perch", "pm", "pols", "thou", "span", "fath", "ft", "yd", "rd",
                         "rope", "Gm", "hm", "km", "kyd", "lea", "Mm", "m", "mi", "nmi", "nmi UK", "nminUS", "fur", "ly", "Em", "Pm", "Tm"
               },
               // Mass - Sorted
               {
                         "ag", "fg", "pg", "ng", "μg", "mg", "cg", "dg", "g", "dag", "hg", "kg", "ct", "oz US", "oz metric", "lb", "kt", "slug", "stone US", "stone UK", "q", "centner", "ton US", "ton UK", "ton metric", "Mg", "Gg",
                         "Tg", "Pg", "Eg", "γ", "klb"
               },
               // Metric Prefix - Sorted
               {
                         "y", "z", "a", "f", "p", "n", "μ", "m", "c", "d", "NoPrefix", "da", "h", "k", "M", "G", "T", "P", "E", "Z", "Y"
               },
               // Numeric Base - Sorted
               {
                         null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                         null
               },
               // Pressure - Sorted
               {
                         "aPa", "bar", "Ba", "cmHg", "cmH20", "cPa", "dbar", "dPa", "daPa", "dyn/cm²", "EPa", "fsw", "ftH20", "ftH20", "fPa", "GPa", "g/cm²", "hPa", "inHg", "inHg", "inH20", "inH20", "ksi", "kg/cm²", "kg/m²",
                         "kg/mm²", "kN/m²", "kPa", "ksi", "tonf/ft²", "tonf/in²", "MPa", "msw", "mH20", "µbar", "µPa", "mbar", "mmHg", "mmH20", "mPa", "nPa", "N/cm²", "N/m²", "N/mm²", "psi", "Pa", "PPa", "pPa", "pz", "pdl/ft²",
                         "psf", "psi", "tonsf/ft²", "tonsf/in²", "atm", "sn/m²", "at", "TPa", "Torr"
               },
               // Speed - Sorted
               {
                         "cm/h", "cm/min", "cm/s", null, "ft/h", "ft/min", "ft/s", null, "in/h", "in/min", "in/s", "km/h", "km/min", "km/s", "kts", "c", "Ma", "m/h", "m/min", "m/h", "mph", "mpm", "mps", "mm/h", "mm/min", "mm/s",
                         "Second cosmic velocity", "speed of sound in air", "speed of sound in water", "Third cosmic velocity", "yd/h", "yd/min", "yd/s"
               },
               // Temperature - Sorted
               {
                         "°C", "°Ré", "°F", "°R", "K"
               },
               // Time - Sorted
               {
                         "as", "fs", "ps", "ns", "μs", "ms", "s", "min", "h", "d", "wk", "fortnight", "mo", "yr", "dec", "cent", "millennium", "Julian year", "leap year", "Gregorian year"
               },
               // Torque - Sorted
               {
                         "dyn·cm", "dyn·m", "dyn·mm", "g·cm", "g·m", "g·mm", "kg·cm", "kg·m", "kg·mm", "kN·m", "N·cm", "N·m", "N·mm", "oz·ft", "oz·in", "lb·ft", "lb·in"
               },
               // Volume - Sorted
               {
                         "al", "fl", "pl", "nl", "μl", "ml", "cl", "dl", "l", "dal", "hl", "kl", "Ml", "Gl", "Tl", "Pl", "El", "ac in", "ac ft", "ac ft", "mm³", "cm³", "dm³", "m³", "km³", "in³", "ft³", "yd³", "mi³", "fbm", "CCF",
                         "cord", "RT", "bbl UK", "bbl US", "gal UK", "gal US", "qt UK", "qt US", "pt UK", "pt US", "cup UK", "cup US", "fl oz UK", "fl oz UK", "gi UK", "gi US", "minim UK", "minim US", "drop", "tsp UK", "tsp US",
                         "tbsp UK", "tbsp US", "dstspn UK", "dstspn US", "bbl", "tun", "hhd", "st", "dL"
               }
     };

     Types() {
          converters = new Object[] {
                    new UnitOf.Acceleration(), new UnitOf.Angle(), new UnitOf.Area(), new UnitOf.DataStorage(), new UnitOf.DataTransferRate(), new UnitOf.ElectricCharge(), new UnitOf.Force(), new UnitOf.Frequency(),
                    new UnitOf.FuelEconomy(), new UnitOf.Length(), new UnitOf.Mass(), new UnitOf.MetricPrefix(), new UnitOf.NumericBase(), new UnitOf.Pressure(), new UnitOf.Speed(), new UnitOf.Temperature(), new UnitOf.Time(),
                    new UnitOf.Torque(), new UnitOf.Volume()
          };
          namesList = Arrays.asList(names);
          typesList = new ArrayList<>();
          symbolsList = new ArrayList<>();
          for (int i = 0; i < types.length; i++) {
               List<String> _aTemp = Arrays.asList(types[i]);
               typesList.add(_aTemp);
          }
          for (int i = 0; i < symbols.length; i++) {
               List<String> _bTemp = Arrays.asList(symbols[i]);
               symbolsList.add(_bTemp);
          }
     }
}
