package grammars.embedded.math;

/**
@author Oscar Pulido Prieto.
*/

import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import grammars.embedded.math.MathLexer;
import grammars.embedded.math.MathParser;

public class Math extends grammars.EmbeddedGrammar {
	
	protected ArrayList<String> vars = new ArrayList<String>();
	
	@Override
	public String analyzeCode(String code) {
		String var = "";
		
		CharStream input = new ANTLRInputStream(code);
		
		MathLexer lexer = new MathLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MathParser parser = new MathParser(tokens);
		
		parser.entry();
		var = parser.getCode();
		
		var = var.replace("[plus]", "$plus");
		var = var.replace("[minus]", "$minus");
		var = var.replace("[times]", "$times");
		var = var.replace("[div]", "$div");
		var = var.replace("[percent]", "$percent");
		
		
		return var;
	}
	
}
