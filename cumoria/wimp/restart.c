


#ifdef ARC_RISCOS2
 #include "^.source.config.h"
 #include "^.source.constant.h"
 #include "^.source.types.h"
 #include "^.source.externs.h"
#else
 #include "config.h"
 #include "constant.h"
 #include "types.h"
 #include "externs.h"
#endif

/* treasure.c */
extern int16  inven_ctr;
extern int16  inven_weight;
extern int16  equip_ctr;

/* variable.c */
extern int    weapon_heavy;
extern int    pack_heavy;
extern int16  total_winner;
extern int32  max_score;
extern int    character_generated;
extern int    character_saved;
extern int16  dun_level;
extern int16  missile_ctr;
extern int16  last_msg;
extern int    death;
extern int    default_dir;
extern int32  turn;
extern int    wizard;
extern int    to_be_wizard;
extern int16  panic_save;
extern int16  noscore;
extern int    find_cut;
extern int    find_examine;
extern int    find_bound;
extern int    find_prself;
extern int    prompt_carry_flag;
extern int    show_weight_flag;
extern int    highlight_seams;
extern int    find_ignore_doors;
extern int    sound_beep_flag;
extern int    display_counts;
extern char   doing_inven;
extern int    screen_change;
extern char   last_command;
extern int    eof_flag;
extern int    light_flag;
extern int    wait_for_more;
extern int    closing_flag;

extern player_type py;

/* player.c */
extern int32u spell_learned;
extern int32u spell_worked;
extern int32u spell_forgotten;


struct restart
    {
    /* treasure.c */
    int16  inven_ctr;
    int16  inven_weight;
    int16  equip_ctr;
    
    /* variable.c */
    int    weapon_heavy;
    int    pack_heavy;
    int16  total_winner;
    int32  max_score;
    int    character_generated;
    int    character_saved;
    int16  dun_level;
    int16  missile_ctr;
    int16  last_msg;
    int    death;
    int    default_dir;
    int32  turn;
    int    wizard;
    int    to_be_wizard;
    int16  panic_save;
    int16  noscore;
    int    find_cut;
    int    find_examine;
    int    find_bound;
    int    find_prself;
    int    prompt_carry_flag;
    int    show_weight_flag;
    int    highlight_seams;
    int    find_ignore_doors;
    int    sound_beep_flag;
    int    display_counts;
    char   doing_inven;
    int    screen_change;
    char   last_command;
    int    eof_flag;
    int    light_flag;
    int    wait_for_more;
    int    closing_flag;
    
    /* player.c */
    int32u spell_learned;
    int32u spell_worked;
    int32u spell_forgotten;
    }
restart;


void save_restart_vars()
    {
    restart.inven_ctr           = inven_ctr;
    restart.inven_weight        = inven_weight;
    restart.equip_ctr           = equip_ctr;
    
    restart.weapon_heavy        = weapon_heavy;
    restart.pack_heavy          = pack_heavy;
    restart.total_winner        = total_winner;
    restart.max_score           = max_score;
    restart.character_generated = character_generated;
    restart.character_saved     = character_saved;
    restart.dun_level           = dun_level;
    restart.missile_ctr         = missile_ctr;
    restart.last_msg            = last_msg;
    restart.death               = death;
    restart.default_dir         = default_dir;
    restart.turn                = turn;
    restart.wizard              = wizard;
    restart.to_be_wizard        = to_be_wizard;
    restart.panic_save          = panic_save;
    restart.noscore             = noscore;
    restart.find_cut            = find_cut;
    restart.find_examine        = find_examine;
    restart.find_bound          = find_bound;
    restart.find_prself         = find_prself;
    restart.prompt_carry_flag   = prompt_carry_flag;
    restart.show_weight_flag    = show_weight_flag;
    restart.highlight_seams     = highlight_seams;
    restart.find_ignore_doors   = find_ignore_doors;
    restart.sound_beep_flag     = sound_beep_flag;
    restart.display_counts      = display_counts;
    restart.doing_inven         = doing_inven;
    restart.screen_change       = screen_change;
    restart.last_command        = last_command;
    restart.eof_flag            = eof_flag;
    restart.light_flag          = light_flag;
    restart.wait_for_more       = wait_for_more;
    restart.closing_flag        = closing_flag;
    
    restart.spell_learned       = spell_learned;
    restart.spell_worked        = spell_worked;
    restart.spell_forgotten     = spell_forgotten;
    }


void load_restart_vars()
    {
    inven_ctr           = restart.inven_ctr;
    inven_weight        = restart.inven_weight;
    equip_ctr           = restart.equip_ctr;
    
    weapon_heavy        = restart.weapon_heavy;
    pack_heavy          = restart.pack_heavy;
    total_winner        = restart.total_winner;
    max_score           = restart.max_score;
    character_generated = restart.character_generated;
    character_saved     = restart.character_saved;
    dun_level           = restart.dun_level;
    missile_ctr         = restart.missile_ctr;
    last_msg            = restart.last_msg;
    death               = restart.death;
    default_dir         = restart.default_dir;
    turn                = restart.turn;
    wizard              = restart.wizard;
    to_be_wizard        = restart.to_be_wizard;
    panic_save          = restart.panic_save;
    noscore             = restart.noscore;
    find_cut            = restart.find_cut;
    find_examine        = restart.find_examine;
    find_bound          = restart.find_bound;
    find_prself         = restart.find_prself;
    prompt_carry_flag   = restart.prompt_carry_flag;
    show_weight_flag    = restart.show_weight_flag;
    highlight_seams     = restart.highlight_seams;
    find_ignore_doors   = restart.find_ignore_doors;
    sound_beep_flag     = restart.sound_beep_flag;
    display_counts      = restart.display_counts;
    doing_inven         = restart.doing_inven;
    screen_change       = restart.screen_change;
    last_command        = restart.last_command;
    eof_flag            = restart.eof_flag;
    light_flag          = restart.light_flag;
    wait_for_more       = restart.wait_for_more;
    closing_flag        = restart.closing_flag;
    
    spell_learned       = restart.spell_learned;
    spell_worked        = restart.spell_worked;
    spell_forgotten     = restart.spell_forgotten;

    py.misc.exp              = 0;
    py.misc.max_exp          = 0;
    py.misc.exp_frac         = 0;
    py.misc.max_dlv          = 0;
    py.flags.status          = 0;
    py.flags.rest            = 0;
    py.flags.blind           = 0;
    py.flags.paralysis       = 0;
    py.flags.confused        = 0;
    py.flags.food            = 0;
    py.flags.food_digested   = 0;
    py.flags.protection      = 0;
    py.flags.speed           = 0;
    py.flags.fast            = 0;
    py.flags.slow            = 0;
    py.flags.afraid          = 0;
    py.flags.poisoned        = 0;
    py.flags.image           = 0;
    py.flags.protevil        = 0;
    py.flags.invuln          = 0;
    py.flags.hero            = 0;
    py.flags.shero           = 0;
    py.flags.blessed         = 0;
    py.flags.resist_heat     = 0;
    py.flags.resist_cold     = 0;
    py.flags.detect_inv      = 0;
    py.flags.word_recall     = 0;
    py.flags.see_infra       = 0;
    py.flags.tim_infra       = 0;
    py.flags.see_inv         = 0;
    py.flags.teleport        = 0;
    py.flags.free_act        = 0;
    py.flags.slow_digest     = 0;
    py.flags.aggravate       = 0;
    py.flags.fire_resist     = 0;
    py.flags.cold_resist     = 0;
    py.flags.acid_resist     = 0;
    py.flags.regenerate      = 0;
    py.flags.lght_resist     = 0;
    py.flags.ffall           = 0;
    py.flags.sustain_str     = 0;
    py.flags.sustain_int     = 0;
    py.flags.sustain_wis     = 0;
    py.flags.sustain_dex     = 0;
    py.flags.sustain_con     = 0;
    py.flags.sustain_chr     = 0;
    py.flags.confuse_monster = 0;
    py.flags.new_spells      = 0;

    }
