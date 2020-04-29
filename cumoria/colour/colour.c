/* colour.c -- written by Edouard Poor for umoria 5.4 */

#ifdef ARC_RISCOS2
#include "colour.h"
#include "^.source.config.h"
#else
#include "colour.h"
#include "config.h"
#endif

colour_entry colours[255] = {
{0, 255, 255, 255}, /* Colour_White            */
{0, 232, 232, 232}, /* Colour_Light_Grey_High  */
{0, 212, 212, 212}, /* Colour_Light_Grey_Low   */
{0, 188, 188, 188}, /* Colour_Medium_Grey_High */
{0, 168, 168, 168}, /* Colour_Medium_Grey_Low  */
{0, 144, 144, 144}, /* Colour_Dark_Grey_High   */
{0, 120, 120, 120}, /* Colour_Dark_Grey_Low    */
{0,  96,  96,  96}, /* Colour_Black            */
{0, 255,  80,  80}, /* Colour_Light_Red        */
{0,  96, 255,  96}, /* Colour_Light_Green      */
{0, 255, 255,  96}, /* Colour_Light_Yellow     */
{0,  96, 160, 255}, /* Colour_Light_Blue       */
{0, 255, 192,  64}, /* Colour_Light_Orange     */
{0, 255,  96, 255}, /* Colour_Light_Purple     */
{0, 224,   0,   0}, /* Colour_Red              */
{0,   0, 224,   0}, /* Colour_Green            */
{0, 224, 224,   0}, /* Colour_Yellow           */
{0,   0,   0, 255}, /* Colour_Blue             */
{0, 255, 160,   0}, /* Colour_Orange           */
{0, 224,   0, 240}, /* Colour_Purple           */
{0, 144,   0,   0}, /* Colour_Dark_Red         */
{0,   0, 128,   0}, /* Colour_Dark_Green       */
{0, 144, 128,   0}, /* Colour_Dark_Yellow      */
{0,   0,   0, 144}, /* Colour_Dark_Blue        */
{0, 160,  96,   0}, /* Colour_Dark_Orange      */
{0, 128,   0, 144}, /* Colour_Dark_Purple      */
{0, 240, 240, 176}, /* Colour_Cream            */
{0, 240, 192,  64}, /* Colour_Amber            */
{0, 224, 208, 176}, /* Colour_Driftwood        */
{0, 224,  64,  96}, /* Colour_Coral            */
{0, 224, 192,  96}, /* Colour_Agate            */
{0, 255, 255, 240}, /* Colour_Ivory            */
{0,  64,  64, 128}, /* Colour_Obsidian         */
{0, 224, 224, 208}, /* Colour_Bone             */
{0, 224, 192,   0}, /* Colour_Brass            */
{0, 208, 176,   0}, /* Colour_Bronze           */
{0, 224, 224, 224}, /* Colour_Pewter           */
{0, 208, 192,  96}, /* Colour_Tortoise_Shell   */
{0, 240, 240, 240}, /* Colour_Aluminum         */
{0, 160, 160, 176}, /* Colour_Cast_Iron        */
{0, 240, 240, 240}, /* Colour_Chromium         */
{0, 255, 224, 128}, /* Colour_Copper           */
{0, 240, 224,  96}, /* Colour_Gold             */
{0, 176, 176, 192}, /* Colour_Iron             */
{0, 240, 240, 240}, /* Colour_Magnesium        */
{0, 240, 240, 240}, /* Colour_Molybdenum       */
{0, 240, 240, 240}, /* Colour_Nickel           */
{0, 208,  96,  32}, /* Colour_Rusty            */
{0, 255, 255, 255}, /* Colour_Silver           */
{0, 224, 224, 240}, /* Colour_Steel            */
{0, 224, 224, 224}, /* Colour_Tin              */
{0, 160, 160, 176}, /* Colour_Titanium         */
{0, 192, 192, 192}, /* Colour_Tungsten         */
{0,  96,  96,  96}, /* Colour_Zirconium        */
{0, 208, 224, 255}, /* Colour_Zinc             */
{0, 160, 112,  96}, /* Colour_Dirt             */
{0, 144, 144,  64}, /* Colour_Leperous         */
{0, 240, 224, 208}, /* Colour_Flesh            */
{0, 224, 255, 176}, /* Colour_Disenchanting    */
{0, 176, 128,  96}, /* Colour_Rotting          */
{0, 224, 224, 208}, /* Colour_Clay             */
{0, 192, 192, 192}, /* Colour_Stone            */
{0, 255,  80,  64}, /* Colour_Fire             */
{0,  64, 192, 240}, /* Colour_Water            */
{0, 176, 112,  64}, /* Colour_Earth            */
{0, 255, 255, 255}, /* Colour_Air              */
{0,  64, 224, 255}, /* Colour_Frost            */
{0, 255, 255, 255}, /* Colour_Lightning        */
{0, 160, 224, 160}, /* Colour_Gelatinous       */
{0, 208, 176,  64}, /* Colour_Umber            */
{0, 224, 240, 255}, /* Colour_Crystal          */
{0, 224, 176,  96}, /* Colour_Brown            */
{0, 240, 224, 160}, /* Colour_Ecru             */
{0, 224, 160,   0}, /* Colour_Furry            */
{0, 208, 208, 208}, /* Colour_Plaid            */
{0,  96, 176,   0}, /* Colour_Slimy            */
{0, 240, 176,   0}, /* Colour_Tan              */
{0, 208, 144,  80}, /* Colour_Wooden           */
{0, 208, 208, 176}, /* Colour_Wrinkled         */
{0, 160, 255,   0}, /* Colour_Icky_Green       */
{0, 240, 192,   0}, /* Colour_Light_Brown      */
{0, 255, 255, 255}, /* Colour_Clear            */
{0, 128, 192, 255}, /* Colour_Azure            */
{0, 240, 240, 240}, /* Colour_Bubbling         */
{0, 176, 208, 112}, /* Colour_Chartreuse       */
{0, 112, 112, 128}, /* Colour_Cloudy           */
{0, 176,  64,  64}, /* Colour_Crimson          */
{0,   0, 255, 255}, /* Colour_Cyan             */
{0, 176, 176, 176}, /* Colour_Hazy             */
{0, 112,   0, 192}, /* Colour_Indigo           */
{0, 224,   0, 224}, /* Colour_Magenta          */
{0,  64, 144, 255}, /* Colour_Metallic_Blue    */
{0, 255,  32,  64}, /* Colour_Metallic_Red     */
{0,  32, 255,  96}, /* Colour_Metallic_Green   */
{0, 144,  96, 208}, /* Colour_Metallic_Purple  */
{0, 240, 240, 240}, /* Colour_Misty            */
{0, 255, 144, 224}, /* Colour_Pink             */
{0, 176,  96, 128}, /* Colour_Puce             */
{0, 112,  96,  96}, /* Colour_Smoky            */
{0, 208,  96,   0}, /* Colour_Tangerine        */
{0, 128,   0, 176}, /* Colour_Violet           */
{0, 255, 112,   0}, /* Colour_Vermilion        */
{0, 112, 208,   0}, /* Colour_Alexandrite      */
{0, 176,   0, 255}, /* Colour_Amethyst         */
{0,   0, 208, 196}, /* Colour_Aquamarine       */
{0,   0, 176, 255}, /* Colour_Azurite          */
{0, 112, 176,  96}, /* Colour_Beryl            */
{0, 224,  80,  32}, /* Colour_Bloodstone       */
{0, 224, 224, 224}, /* Colour_Calcite          */
{0, 176,  48,   0}, /* Colour_Carnelian        */
{0,  48, 112, 255}, /* Colour_Corundum         */
{0, 255, 255, 255}, /* Colour_Diamond          */
{0,  64, 208,  64}, /* Colour_Emerald          */
{0, 240, 255, 224}, /* Colour_Fluorite         */
{0, 224,   0,   0}, /* Colour_Garnet           */
{0, 112, 112, 128}, /* Colour_Granite          */
{0, 112, 176,  48}, /* Colour_Jade             */
{0, 208,  80,  48}, /* Colour_Jasper           */
{0, 112, 144, 224}, /* Colour_Lapis_Lazuli     */
{0, 176,  80,  32}, /* Colour_Magma            */
{0, 112, 176,  64}, /* Colour_Malachite        */
{0, 128, 144, 144}, /* Colour_Marble           */
{0, 240, 240, 240}, /* Colour_Moonstone        */
{0, 224, 208, 208}, /* Colour_Onyx             */
{0, 240, 240, 240}, /* Colour_Pearl            */
{0, 224, 224, 224}, /* Colour_Quartz           */
{0, 208, 208, 208}, /* Colour_Quartzite        */
{0, 224,   0,  64}, /* Colour_Rhodonite        */
{0, 240,  64,  64}, /* Colour_Ruby             */
{0,  96,  64, 208}, /* Colour_Sapphire         */
{0, 224, 128,  64}, /* Colour_Tiger_Eye        */
{0, 224, 208,  32}, /* Colour_Topaz            */
{0,   0, 192, 192}, /* Colour_Turquoise        */
{0, 240, 224,  64}, /* Colour_Zircon           */
{0, 176, 112,  96}, /* Colour_Food             */
{0, 144, 208,   0}, /* Colour_Slime            */
{0, 144, 112,  32}, /* Colour_Leather          */
{0, 208, 224, 224}, /* Colour_Cord             */
{0, 240, 240, 224}, /* Colour_Paper            */
{0, 208, 192, 160}, /* Colour_Old_Parchment    */
{0, 208,  80,   0}, /* Colour_Apple            */
{0,  80,  96, 112}, /* Colour_Oil              */
{0,  80, 176, 255}, /* Colour_Magic_Light      */
{0, 144, 128, 112}, /* Colour_Mud              */
{0,  96, 112,  96}, /* Colour_Acid             */
{0, 208, 224, 224}, /* Colour_Pottery          */
{0, 176,  64,  96}, /* Colour_Wine             */
{0, 255, 255, 208}, /* Colour_Mithril          */
{0, 224, 176,  96}, /* Colour_Aspen            */
{0, 240, 224, 208}, /* Colour_Balsa            */
{0, 224, 192, 128}, /* Colour_Banyan           */
{0, 144, 128, 108}, /* Colour_Birch            */
{0, 176,  96,  64}, /* Colour_Cedar            */
{0, 208, 192, 176}, /* Colour_Cottonwood       */
{0, 208, 192, 160}, /* Colour_Cypress          */
{0, 160, 128, 112}, /* Colour_Dogwood          */
{0, 224, 176, 112}, /* Colour_Elm              */
{0, 208, 192, 144}, /* Colour_Eucalyptus       */
{0, 208, 176, 144}, /* Colour_Hemlock          */
{0, 176, 128, 112}, /* Colour_Hickory          */
{0, 112, 112, 128}, /* Colour_Ironwood         */
{0, 240, 208,  64}, /* Colour_Locust           */
{0, 176, 112,  64}, /* Colour_Mahogany         */
{0, 224, 208, 144}, /* Colour_Maple            */
{0, 176, 128, 128}, /* Colour_Mulberry         */
{0, 224, 160, 112}, /* Colour_Oak              */
{0, 176, 160, 144}, /* Colour_Pine             */
{0, 208,  96,  64}, /* Colour_Redwood          */
{0, 160,  80,  64}, /* Colour_Rosewood         */
{0, 176, 176,  80}, /* Colour_Spruce           */
{0, 208, 160, 128}, /* Colour_Sycamore         */
{0, 240, 208, 128}, /* Colour_Teak             */
{0, 208, 176, 144}, /* Colour_Walnut           */
{0,  96, 192, 255}, /* Colour_Magic_Missile    */
{0, 112, 192,   0}, /* Colour_Poison_Gas       */
{0,  96,  96,  96}, /* Colour_Holy_Orb         */
/* All new colours to be put after this point. */
};


/*
 *  The only function that needs changing by everyone useing this colour
 *  code in their versions of umoria.
 *  In this example I have put in the colour numbers that correspond to
 *  the standard Archimedes desktop colours (16 of them, 0-15) to be
 *  used in 16 colour modes. In 256 colour modes I will call a system
 *  function to get a colour given the full RGB value, and in 4 and 2
 *  colour modes I will draw in just black & white.
 *  This setting each colour 'by hand' is a bit cumbersome, but shows
 *  what I am up to. You may well find it easier to get the colours from
 *  a file (and this would have the advantage of (for example) being able
 *  to have seperate CGA, EGA, and VGA files for a PC...)
 */
 
#ifndef MAC		/* On the mac, the OS handles this for us */

void set_local_colours()
{
  colours[Colour_White].L            =  0;
  colours[Colour_Light_Grey_High].L  =  1;
  colours[Colour_Light_Grey_Low].L   =  1;
  colours[Colour_Medium_Grey_High].L =  2;
  colours[Colour_Medium_Grey_Low].L  =  2;
  colours[Colour_Dark_Grey_High].L   =  3;
  colours[Colour_Dark_Grey_Low].L    =  4;
  colours[Colour_Black].L            =  5;
  colours[Colour_Light_Red].L        = 11;
  colours[Colour_Light_Green].L      = 10;
  colours[Colour_Light_Yellow].L     =  9;
  colours[Colour_Light_Blue].L       = 15;
  colours[Colour_Light_Orange].L     = 14;
  colours[Colour_Light_Purple].L     = 15;
  colours[Colour_Red].L              = 11;
  colours[Colour_Green].L            = 10;
  colours[Colour_Yellow].L           =  9;
  colours[Colour_Blue].L             = 15;
  colours[Colour_Orange].L           = 14;
  colours[Colour_Purple].L           =  8;
  colours[Colour_Dark_Red].L         = 11;
  colours[Colour_Dark_Green].L       = 13;
  colours[Colour_Dark_Yellow].L      = 14;
  colours[Colour_Dark_Blue].L        =  8;
  colours[Colour_Dark_Orange].L      = 14;
  colours[Colour_Dark_Purple].L      =  8;
  colours[Colour_Cream].L            = 12;
  colours[Colour_Amber].L            = 14;
  colours[Colour_Driftwood].L        = 12;
  colours[Colour_Coral].L            = 11;
  colours[Colour_Agate].L            = 11;
  colours[Colour_Ivory].L            = 12;
  colours[Colour_Obsidian].L         =  5;
  colours[Colour_Bone].L             =  1;
  colours[Colour_Brass].L            = 14;
  colours[Colour_Bronze].L           = 14;
  colours[Colour_Pewter].L           =  1;
  colours[Colour_Tortoise_Shell].L   = 14;
  colours[Colour_Aluminum].L         =  0;
  colours[Colour_Cast_Iron].L        =  3;
  colours[Colour_Chromium].L         =  0;
  colours[Colour_Copper].L           = 14;
  colours[Colour_Gold].L             =  9;
  colours[Colour_Iron].L             =  2;
  colours[Colour_Magnesium].L        =  0;
  colours[Colour_Molybdenum].L       =  0;
  colours[Colour_Nickel].L           =  0;
  colours[Colour_Rusty].L            = 14;
  colours[Colour_Silver].L           =  0;
  colours[Colour_Steel].L            =  0;
  colours[Colour_Tin].L              =  1;
  colours[Colour_Titanium].L         =  3;
  colours[Colour_Tungsten].L         =  2;
  colours[Colour_Zirconium].L        =  4;
  colours[Colour_Zinc].L             =  2;
  colours[Colour_Dirt].L             = 14;
  colours[Colour_Leperous].L         = 13;
  colours[Colour_Flesh].L            = 14;
  colours[Colour_Disenchanting].L    = 12;
  colours[Colour_Rotting].L          = 14;
  colours[Colour_Clay].L             = 12;
  colours[Colour_Stone].L            =  1;
  colours[Colour_Fire].L             = 11;
  colours[Colour_Water].L            = 15;
  colours[Colour_Earth].L            = 14;
  colours[Colour_Air].L              =  0;
  colours[Colour_Frost].L            = 15;
  colours[Colour_Lightning].L        =  0;
  colours[Colour_Gelatinous].L       = 10;
  colours[Colour_Umber].L            = 14;
  colours[Colour_Crystal].L          =  1;
  colours[Colour_Brown].L            = 14;
  colours[Colour_Ecru].L             = 12;
  colours[Colour_Furry].L            = 14;
  colours[Colour_Plaid].L            =  1;
  colours[Colour_Slimy].L            = 10;
  colours[Colour_Tan].L              = 14;
  colours[Colour_Wooden].L           = 14;
  colours[Colour_Wrinkled].L         = 12;
  colours[Colour_Icky_Green].L       = 10;
  colours[Colour_Light_Brown].L      = 14;
  colours[Colour_Clear].L            =  0;
  colours[Colour_Azure].L            = 15;
  colours[Colour_Bubbling].L         =  0;
  colours[Colour_Chartreuse].L       = 10;
  colours[Colour_Cloudy].L           =  3;
  colours[Colour_Crimson].L          = 11;
  colours[Colour_Cyan].L             = 15;
  colours[Colour_Hazy].L             =  2;
  colours[Colour_Indigo].L           =  8;
  colours[Colour_Magenta].L          = 11;
  colours[Colour_Metallic_Blue].L    = 15;
  colours[Colour_Metallic_Red].L     = 11;
  colours[Colour_Metallic_Green].L   = 10;
  colours[Colour_Metallic_Purple].L  =  8;
  colours[Colour_Misty].L            =  0;
  colours[Colour_Pink].L             = 11;
  colours[Colour_Puce].L             = 11;
  colours[Colour_Smoky].L            =  3;
  colours[Colour_Tangerine].L        = 14;
  colours[Colour_Violet].L           =  8;
  colours[Colour_Vermilion].L        = 11;
  colours[Colour_Alexandrite].L      = 10;
  colours[Colour_Amethyst].L         =  8;
  colours[Colour_Aquamarine].L       = 15;
  colours[Colour_Azurite].L          = 15;
  colours[Colour_Beryl].L            = 10;
  colours[Colour_Bloodstone].L       = 11;
  colours[Colour_Calcite].L          =  0;
  colours[Colour_Carnelian].L        = 11;
  colours[Colour_Corundum].L         = 15;
  colours[Colour_Diamond].L          =  0;
  colours[Colour_Emerald].L          = 10;
  colours[Colour_Fluorite].L         =  0;
  colours[Colour_Garnet].L           = 11;
  colours[Colour_Granite].L          =  2;
  colours[Colour_Jade].L             = 10;
  colours[Colour_Jasper].L           = 11;
  colours[Colour_Lapis_Lazuli].L     = 15;
  colours[Colour_Magma].L            =  4;
  colours[Colour_Malachite].L        = 10;
  colours[Colour_Marble].L           =  2;
  colours[Colour_Moonstone].L        =  0;
  colours[Colour_Onyx].L             =  1;
  colours[Colour_Pearl].L            =  0;
  colours[Colour_Quartz].L           =  0;
  colours[Colour_Quartzite].L        =  1;
  colours[Colour_Rhodonite].L        = 11;
  colours[Colour_Ruby].L             = 11;
  colours[Colour_Sapphire].L         = 15;
  colours[Colour_Tiger_Eye].L        = 14;
  colours[Colour_Topaz].L            =  9;
  colours[Colour_Turquoise].L        = 15;
  colours[Colour_Zircon].L           =  9;
  colours[Colour_Food].L             = 14;
  colours[Colour_Slime].L            = 10;
  colours[Colour_Leather].L          = 14;
  colours[Colour_Cord].L             = 12;
  colours[Colour_Paper].L            = 12;
  colours[Colour_Old_Parchment].L    = 14;
  colours[Colour_Apple].L            = 14;
  colours[Colour_Oil].L              =  8;
  colours[Colour_Magic_Light].L      = 15;
  colours[Colour_Mud].L              = 14;
  colours[Colour_Acid].L             =  5;
  colours[Colour_Pottery].L          = 12;
  colours[Colour_Wine].L             = 11;
  colours[Colour_Mithril].L          = 12;
  colours[Colour_Aspen].L            = 14;
  colours[Colour_Balsa].L            = 12;
  colours[Colour_Banyan].L           = 12;
  colours[Colour_Birch].L            = 12;
  colours[Colour_Cedar].L            = 14;
  colours[Colour_Cottonwood].L       =  1;
  colours[Colour_Cypress].L          = 12;
  colours[Colour_Dogwood].L          = 12;
  colours[Colour_Elm].L              = 14;
  colours[Colour_Eucalyptus].L       = 12;
  colours[Colour_Hemlock].L          = 12;
  colours[Colour_Hickory].L          = 14;
  colours[Colour_Ironwood].L         =  2;
  colours[Colour_Locust].L           =  9;
  colours[Colour_Mahogany].L         = 14;
  colours[Colour_Maple].L            = 12;
  colours[Colour_Mulberry].L         = 14;
  colours[Colour_Oak].L              = 14;
  colours[Colour_Pine].L             =  1;
  colours[Colour_Redwood].L          = 11;
  colours[Colour_Rosewood].L         = 11;
  colours[Colour_Spruce].L           = 10;
  colours[Colour_Sycamore].L         = 14;
  colours[Colour_Teak].L             = 12;
  colours[Colour_Walnut].L           = 12;
  colours[Colour_Magic_Missile].L    = 15;
  colours[Colour_Poison_Gas].L       = 10;
  colours[Colour_Holy_Orb].L         =  5;
}

#endif
