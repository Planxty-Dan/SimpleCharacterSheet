/**
 * 
 */
package net.mindsoup.charactersoup.pf.races;

import net.mindsoup.charactersoup.pf.PfEffectTypes;
import net.mindsoup.charactersoup.pf.PfRaces;
import net.mindsoup.charactersoup.pf.PfSizes;
import net.mindsoup.charactersoup.pf.skills.PfSkills;


/**
 * @author Valentijn
 *
 */
public class PfHuman extends PfChooseBonusAttributeRace {
	
	// TODO:
	// Bonus feat (core rulebook page 27)
	// Skilled (core rulebook page 27)
	
	@Override
	public String toString() {
		return "Human";
	}

	@Override
	public PfRaces getRace() {
		return PfRaces.HUMAN;
	}

	@Override
	public PfSizes getSize() {
		return PfSizes.MEDIUM;
	}

	@Override
	public int getCMBModifier() {
		return 0;
	}

	@Override
	public int getCMDModifier() {
		return 0;
	}

	@Override
	public int getACModifier() {
		return 0;
	}

	@Override
	public int getSavingThrowModifier(PfEffectTypes effect) {
		return 0;
	}

	@Override
	public int getSkillBonus(PfSkills skill) {
		return 0;
	}

	@Override
	public int getBaseSpeed() {
		return 30;
	}

	@Override
	public int getDarkvisionRange() {
		return 0;
	}

	@Override
	public int getLowlightvisionRange() {
		return 0;
	}

}
