# Project:   Frontend


# Toolflags:
#CCflags = -c -depend !Depend -throwback -IC: -DARC_RISCOS2 -DCOLOUR_GFX
CCflags = -c -depend !Depend -IC: -DARC_RISCOS2 -DCOLOUR_GFX
Linkflags = -o $@
ObjAsmflags = -depend !Depend -ThrowBack -Stamp -quit -CloseExec
CMHGflags = 
LibFileflags = -c -o $@
Squeezeflags = -o $@
AAsmflags = -depend !Depend -quit -CloseExec -To $@ -From

ArcObjs = o.frontend o.wimpfuncs o.gfx o.extrawind o.colourtran o.screeninfo
WimpObjs = o.screen o.io o.restart
ColourObjs = o.colour o.monsters o.tables o.treasure
UmoriaObjs = o.create o.creature o.death o.desc o.dungeon o.eat o.files o.generate o.help o.magic o.main o.misc1 o.misc2 o.misc3 o.misc4 o.moria1 o.moria2 o.moria3 o.moria4 o.player o.potions o.prayer o.recall o.rnd o.save o.scrolls o.sets o.signals o.spells o.staffs o.store1 o.store2 o.variable o.wands o.wizard


# Final targets:
@.!UMoria.!RunImage:   $(ArcObjs) $(UmoriaObjs) $(ColourObjs) $(WimpObjs)
        link $(linkflags) $(ArcObjs) $(UmoriaObjs) $(ColourObjs) $(WimpObjs) c:o.stubs
        squeeze @.!UMoria.!RunImage

# User-editable dependencies:
@.o.frontend:   @.c.Frontend 
        cc $(ccflags) @.c.Frontend 
@.o.wimpfuncs:   @.c.WimpFuncs 
        cc $(ccflags) @.c.WimpFuncs 
@.o.gfx: @.c.gfx
        cc $(ccflags) @.c.gfx
@.o.colourtran:   @.c.colourtran
        cc $(ccflags) @.c.colourtran
@.o.screeninfo: @.c.screeninfo
        cc $(ccflags) @.c.screeninfo
@.o.extrawind:   @.c.extrawind
        cc $(ccflags) @.c.extrawind

@.o.screen:   @.^.wimp.c.screen
        cc $(ccflags) @.^.wimp.c.screen
@.o.io:   @.^.wimp.c.io
        cc $(ccflags) @.^.wimp.c.io
@.o.restart:   @.^.wimp.c.restart
        cc $(ccflags) @.^.wimp.c.restart

@.o.treasure:   @.^.colour.c.treasure
        cc $(ccflags) @.^.colour.c.treasure
@.o.monsters:   @.^.colour.c.monsters
        cc $(ccflags) @.^.colour.c.monsters
@.o.tables:   @.^.colour.c.tables
        cc $(ccflags) @.^.colour.c.tables
@.o.colour:   @.^.colour.c.colour
        cc $(ccflags) @.^.colour.c.colour

@.o.create:   @.^.source.c.create
        cc $(ccflags) @.^.source.c.create
@.o.creature:   @.^.source.c.creature
        cc $(ccflags) @.^.source.c.creature
@.o.death:   @.^.source.c.death
        cc $(ccflags) @.^.source.c.death
@.o.desc:   @.^.source.c.desc
        cc $(ccflags) @.^.source.c.desc
@.o.dungeon:   @.^.source.c.dungeon
        cc $(ccflags) @.^.source.c.dungeon
@.o.eat:   @.^.source.c.eat
        cc $(ccflags) @.^.source.c.eat
@.o.files:   @.^.source.c.files
        cc $(ccflags) @.^.source.c.files
@.o.generate:   @.^.source.c.generate
        cc $(ccflags) @.^.source.c.generate
@.o.help:   @.^.source.c.help
        cc $(ccflags) @.^.source.c.help
@.o.magic:   @.^.source.c.magic
        cc $(ccflags) @.^.source.c.magic
@.o.main:   @.^.source.c.main
        cc $(ccflags) @.^.source.c.main
@.o.misc1:   @.^.source.c.misc1
        cc $(ccflags) @.^.source.c.misc1
@.o.misc2:   @.^.source.c.misc2
        cc $(ccflags) @.^.source.c.misc2
@.o.misc3:   @.^.source.c.misc3
        cc $(ccflags) @.^.source.c.misc3
@.o.misc4:   @.^.source.c.misc4
        cc $(ccflags) @.^.source.c.misc4
# @.o.monsters:   @.^.source.c.monsters
#         cc $(ccflags) @.^.source.c.monsters
@.o.moria1:   @.^.source.c.moria1
        cc $(ccflags) @.^.source.c.moria1
@.o.moria2:   @.^.source.c.moria2
        cc $(ccflags) @.^.source.c.moria2
@.o.moria3:   @.^.source.c.moria3
        cc $(ccflags) @.^.source.c.moria3
@.o.moria4:   @.^.source.c.moria4
        cc $(ccflags) @.^.source.c.moria4
@.o.player:   @.^.source.c.player
        cc $(ccflags) @.^.source.c.player
@.o.potions:   @.^.source.c.potions
        cc $(ccflags) @.^.source.c.potions
@.o.prayer:   @.^.source.c.prayer
        cc $(ccflags) @.^.source.c.prayer
@.o.recall:   @.^.source.c.recall
        cc $(ccflags) @.^.source.c.recall
@.o.rnd:   @.^.source.c.rnd
        cc $(ccflags) @.^.source.c.rnd
@.o.save:   @.^.source.c.save
        cc $(ccflags) @.^.source.c.save
@.o.scrolls:   @.^.source.c.scrolls
        cc $(ccflags) @.^.source.c.scrolls
@.o.sets:   @.^.source.c.sets
        cc $(ccflags) @.^.source.c.sets
@.o.signals:   @.^.source.c.signals
        cc $(ccflags) @.^.source.c.signals
@.o.spells:   @.^.source.c.spells
        cc $(ccflags) @.^.source.c.spells
@.o.staffs:   @.^.source.c.staffs
        cc $(ccflags) @.^.source.c.staffs
@.o.store1:   @.^.source.c.store1
        cc $(ccflags) @.^.source.c.store1
@.o.store2:   @.^.source.c.store2
        cc $(ccflags) @.^.source.c.store2
# @.o.tables:   @.^.source.c.tables
#         cc $(ccflags) @.^.source.c.tables
# @.o.treasure:   @.^.source.c.treasure
#         cc $(ccflags) @.^.source.c.treasure
@.o.variable:   @.^.source.c.variable
        cc $(ccflags) @.^.source.c.variable
@.o.wands:   @.^.source.c.wands
        cc $(ccflags) @.^.source.c.wands
@.o.wizard:   @.^.source.c.wizard
        cc $(ccflags) @.^.source.c.wizard

# Dynamic dependencies:
o.io:	^.wimp.c.io
o.io:	^.wimp.^.source.h.config
o.io:	^.wimp.^.source.h.constant
o.io:	^.wimp.^.source.h.types
o.io:	^.wimp.^.source.h.externs
o.io:	^.wimp.^.colour.h.colour
o.io:	^.wimp.h.screen
o.io:	^.wimp.^.arc.h.wimpdata
o.restart:	^.wimp.c.restart
o.restart:	^.wimp.^.source.h.config
o.restart:	^.wimp.^.source.h.constant
o.restart:	^.wimp.^.source.h.types
o.restart:	^.wimp.^.source.h.externs
o.monsters:	^.colour.c.monsters
o.monsters:	^.colour.^.source.h.config
o.monsters:	^.colour.^.source.h.constant
o.monsters:	^.colour.^.source.h.types
o.monsters:	^.colour.h.colour
o.tables:	^.colour.c.tables
o.tables:	^.colour.^.source.h.config
o.tables:	^.colour.^.source.h.constant
o.tables:	^.colour.^.source.h.types
o.tables:	^.colour.h.colour
o.treasure:	^.colour.c.treasure
o.treasure:	^.colour.^.source.h.config
o.treasure:	^.colour.^.source.h.constant
o.treasure:	^.colour.^.source.h.types
o.treasure:	^.colour.h.colour
o.creature:	^.source.c.creature
o.creature:	^.source.h.config
o.creature:	^.source.h.constant
o.creature:	^.source.h.types
o.creature:	^.source.h.externs
o.death:	^.source.c.death
o.death:	^.source.h.config
o.death:	^.source.h.constant
o.death:	^.source.h.types
o.death:	^.source.^.colour.h.colour
o.death:	^.source.h.externs
o.desc:	^.source.c.desc
o.desc:	^.source.h.config
o.desc:	^.source.h.constant
o.desc:	^.source.h.types
o.desc:	^.source.h.externs
o.dungeon:	^.source.c.dungeon
o.dungeon:	^.source.h.config
o.dungeon:	^.source.h.constant
o.dungeon:	^.source.h.types
o.dungeon:	^.source.h.externs
o.eat:	^.source.c.eat
o.eat:	^.source.h.config
o.eat:	^.source.h.constant
o.eat:	^.source.h.types
o.eat:	^.source.h.externs
o.files:	^.source.c.files
o.files:	^.source.h.config
o.files:	^.source.h.constant
o.files:	^.source.h.types
o.files:	^.source.^.colour.h.colour
o.files:	^.source.h.externs
o.generate:	^.source.c.generate
o.generate:	^.source.h.config
o.generate:	^.source.h.constant
o.generate:	^.source.h.types
o.generate:	^.source.h.externs
o.help:	^.source.c.help
o.help:	^.source.h.config
o.help:	^.source.h.constant
o.help:	^.source.h.types
o.help:	^.source.h.externs
o.magic:	^.source.c.magic
o.magic:	^.source.h.config
o.magic:	^.source.h.constant
o.magic:	^.source.h.types
o.magic:	^.source.h.externs
o.main:	^.source.c.main
o.main:	^.source.h.config
o.main:	^.source.h.constant
o.main:	^.source.h.types
o.main:	^.source.h.externs
o.misc1:	^.source.c.misc1
o.misc1:	^.source.h.config
o.misc1:	^.source.h.constant
o.misc1:	^.source.h.types
o.misc1:	^.source.h.externs
o.misc1:	^.source.^.colour.h.colour
o.misc2:	^.source.c.misc2
o.misc2:	^.source.h.config
o.misc2:	^.source.h.constant
o.misc2:	^.source.h.types
o.misc2:	^.source.h.externs
o.misc2:	^.source.^.colour.h.colour
o.misc3:	^.source.c.misc3
o.misc3:	^.source.h.config
o.misc3:	^.source.h.constant
o.misc3:	^.source.h.types
o.misc3:	^.source.h.externs
o.misc3:	^.source.^.colour.h.colour
o.misc4:	^.source.c.misc4
o.misc4:	^.source.h.config
o.misc4:	^.source.h.constant
o.misc4:	^.source.h.types
o.misc4:	^.source.h.externs
o.moria1:	^.source.c.moria1
o.moria1:	^.source.h.config
o.moria1:	^.source.h.constant
o.moria1:	^.source.h.types
o.moria1:	^.source.h.externs
o.moria1:	^.source.^.colour.h.colour
o.moria2:	^.source.c.moria2
o.moria2:	^.source.h.config
o.moria2:	^.source.h.constant
o.moria2:	^.source.h.types
o.moria2:	^.source.h.externs
o.moria2:	^.source.^.colour.h.colour
o.moria3:	^.source.c.moria3
o.moria3:	^.source.h.config
o.moria3:	^.source.h.constant
o.moria3:	^.source.h.types
o.moria3:	^.source.h.externs
o.moria4:	^.source.c.moria4
o.moria4:	^.source.h.config
o.moria4:	^.source.h.constant
o.moria4:	^.source.h.types
o.moria4:	^.source.h.externs
o.moria4:	^.source.^.colour.h.colour
o.player:	^.source.c.player
o.player:	^.source.h.config
o.player:	^.source.h.constant
o.player:	^.source.h.types
o.potions:	^.source.c.potions
o.potions:	^.source.h.config
o.potions:	^.source.h.constant
o.potions:	^.source.h.types
o.potions:	^.source.h.externs
o.prayer:	^.source.c.prayer
o.prayer:	^.source.h.config
o.prayer:	^.source.h.constant
o.prayer:	^.source.h.types
o.prayer:	^.source.h.externs
o.recall:	^.source.c.recall
o.recall:	^.source.h.config
o.recall:	^.source.h.constant
o.recall:	^.source.h.types
o.recall:	^.source.h.externs
o.recall:	^.source.^.colour.h.colour
o.rnd:	^.source.c.rnd
o.rnd:	^.source.h.config
o.rnd:	^.source.h.constant
o.rnd:	^.source.h.types
o.save:	^.source.c.save
o.save:	^.source.h.config
o.save:	^.source.h.constant
o.save:	^.source.h.types
o.save:	^.source.h.externs
o.scrolls:	^.source.c.scrolls
o.scrolls:	^.source.h.config
o.scrolls:	^.source.h.constant
o.scrolls:	^.source.h.types
o.scrolls:	^.source.h.externs
o.sets:	^.source.c.sets
o.sets:	^.source.h.config
o.sets:	^.source.h.constant
o.sets:	^.source.h.types
o.signals:	^.source.c.signals
o.signals:	^.source.h.config
o.signals:	^.source.h.constant
o.spells:	^.source.c.spells
o.spells:	^.source.h.config
o.spells:	^.source.h.constant
o.spells:	^.source.h.types
o.spells:	^.source.h.externs
o.spells:	^.source.^.colour.h.colour
o.staffs:	^.source.c.staffs
o.staffs:	^.source.h.config
o.staffs:	^.source.h.constant
o.staffs:	^.source.h.types
o.staffs:	^.source.h.externs
o.store1:	^.source.c.store1
o.store1:	^.source.h.config
o.store1:	^.source.h.constant
o.store1:	^.source.h.types
o.store1:	^.source.h.externs
o.store2:	^.source.c.store2
o.store2:	^.source.h.config
o.store2:	^.source.h.constant
o.store2:	^.source.h.types
o.store2:	^.source.h.externs
o.store2:	^.source.^.colour.h.colour
o.variable:	^.source.c.variable
o.variable:	^.source.h.config
o.variable:	^.source.h.constant
o.variable:	^.source.h.types
o.wands:	^.source.c.wands
o.wands:	^.source.h.config
o.wands:	^.source.h.constant
o.wands:	^.source.h.types
o.wands:	^.source.h.externs
o.wizard:	^.source.c.wizard
o.wizard:	^.source.h.config
o.wizard:	^.source.h.constant
o.wizard:	^.source.h.types
o.wizard:	^.source.h.externs
o.colour:	^.colour.c.colour
o.colour:	^.colour.h.colour
o.colour:	^.colour.^.source.h.config
o.colourtran:	c.colourtran
o.colourtran:	C:h.kernel
o.colourtran:	h.swicodes
o.screeninfo:	c.screeninfo
o.screeninfo:	C:h.kernel
o.screeninfo:	h.swicodes
o.create:	^.source.c.create
o.create:	^.source.h.config
o.create:	^.source.h.constant
o.create:	^.source.h.types
o.create:	^.source.h.externs
o.create:	^.source.^.colour.h.colour
o.WimpFuncs:	c.WimpFuncs
o.WimpFuncs:	C:h.kernel
o.WimpFuncs:	h.swicodes
o.WimpFuncs:	h.wimpdata
o.gfx:	c.gfx
o.gfx:	C:h.kernel
o.gfx:	h.swicodes
o.extrawind:	c.extrawind
o.extrawind:	h.WimpData
o.extrawind:	h.WimpFuncs
o.extrawind:	C:h.kernel
o.screen:	^.wimp.c.screen
o.screen:	^.wimp.^.source.h.config
o.screen:	^.wimp.^.source.h.constant
o.screen:	^.wimp.^.source.h.types
o.screen:	^.wimp.^.source.h.externs
o.screen:	^.wimp.^.colour.h.colour
o.screen:	^.wimp.^.wimp.h.screen
o.screen:	^.wimp.^.wimp.^.arc.h.wimpdata
o.screen:	^.wimp.^.arc.h.gfx
o.screen:	C:h.kernel
o.screen:	^.wimp.^.arc.h.wimpdata
o.screen:	^.wimp.^.arc.h.wimpfuncs
o.screen:	C:h.kernel
o.screen:	^.wimp.^.arc.h.colourtran
o.screen:	C:h.kernel
