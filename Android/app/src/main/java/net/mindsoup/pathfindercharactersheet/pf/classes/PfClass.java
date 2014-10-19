package net.mindsoup.pathfindercharactersheet.pf.classes;

import java.util.Map;

import net.mindsoup.pathfindercharactersheet.pf.PfCharacter;
import net.mindsoup.pathfindercharactersheet.pf.PfClasses;
import net.mindsoup.pathfindercharactersheet.pf.feats.PfFeats;
import net.mindsoup.pathfindercharactersheet.pf.skills.PfSkills;
import net.mindsoup.pathfindercharactersheet.pf.util.Calculation;
import net.mindsoup.pathfindercharactersheet.pf.util.Dice;

public interface PfClass {
	public PfClasses getPfClass();
	
	public int getBaseSkillRanksPerLevel();
	public Dice getHitDie();
	
	public int getFortSaveModifier(int level);
	public int getWillSaveModifier(int level);
	public int getReflexSaveModifier(int level);
	public int getExtraAttackPerNumLevels();
	public PfSkills[] getClassSkills();
	public PfFeats[] getClassFeats();
	public int getAttackBonus(int level);
	public Map<String, String> getFragments();
	
	public Calculation modifyAttribute(PfCharacter.Attributes attribute, Calculation current, PfCharacter character);
}