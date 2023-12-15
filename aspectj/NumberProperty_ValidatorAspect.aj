package naturalistic.lang;

import naturalistic.lang.*;
import java.util.ArrayList;

/**
@author Oscar Pulido Prieto.
*/

public privileged aspect NumberProperty_ValidatorAspect {
	
	after(naturalistic.lang.Number restrictedNumber) :
		execution(naturalistic.lang.Number+.new(..)) &&
		target(restrictedNumber) {
		
		ArrayList<Class> interfaces = new ArrayList<Class>();
		interfaces.add(naturalistic.lang.Character.class);
		interfaces.add(naturalistic.lang.Integer.class);
		interfaces.add(naturalistic.lang.Real.class);
		boolean hasExclusion = false;
		for(Class cls : restrictedNumber.getClass().getInterfaces()) {
			if(interfaces.contains(cls)) {
				if(!hasExclusion) {
					hasExclusion = true;
				} else {
					throw new RuntimeException("Illegal composition for Number: only one adjective between Character, Integer or Real is permitted");
				}
			}
		}
	}
	
	after(naturalistic.lang.Number restrictedNumber) :
		 execution(naturalistic.lang.Number+.new(..)) &&
		 target(restrictedNumber) {
			ArrayList<Class> interfaces = new ArrayList<Class>();
			interfaces.add(naturalistic.lang.Character.class);
			interfaces.add(naturalistic.lang.Integer.class);
			interfaces.add(naturalistic.lang.Real.class);
			int required = 1;
			int cnt = 0;
			for(Class cls : restrictedNumber.getClass().getInterfaces()) {
				if(interfaces.contains(cls)) {
					cnt++;
				}
			}
			if(cnt < required) {
				throw new RuntimeException("Illegal composition for Number: adjectives Character, Integer or Real are required");
			}
		}

}
