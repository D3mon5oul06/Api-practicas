package naturalistic.lang

/**
@author Oscar Pulido Prieto.
*/

@naturalistic.lang.annotations.Noun(name = "Random")
class Random extends naturalistic.lang.Thing {
  
  
  @naturalistic.lang.annotations.Attribute(name = "min", container = "Random")
	var min : naturalistic.lang.NumberProperty = _;
	@naturalistic.lang.annotations.Verb(name = "min", signature = "min of itself", returnType = " : naturalistic.lang.NumberProperty", container = "Random")
	def min_of_itself : naturalistic.lang.NumberProperty = min;
	
	
	@naturalistic.lang.annotations.Attribute(name = "max", container = "Random")
	var max : naturalistic.lang.NumberProperty = _;
	@naturalistic.lang.annotations.Verb(name = "min", signature = "max of itself", returnType = " : naturalistic.lang.NumberProperty", container = "Random")
	def max_of_itself : naturalistic.lang.NumberProperty = max;
	
	@naturalistic.lang.annotations.Verb(name = "integer", signature = "integer of itself", returnType = "Number with Integer", container = "Random")
	def integer_of_itself : naturalistic.lang.Integer = {
	  
	  if(min == null && max == null) {
	    return Number.instance(scala.util.Random.nextInt(scala.Int.MaxValue))
	  }
	  
	  var localMin : scala.Int = 0;
	  var localMax : scala.Int = 0;
	  
	  if(min == null) {
	    localMin = 0
	  } else {
	    localMin = min.getValue.asInstanceOf[scala.Int]
	  }
	  
	  if(max == null) {
	    localMax = scala.Int.MaxValue
	  } else {
	    localMax = max.getValue.asInstanceOf[scala.Int]
	  }
	  
	  if(localMin > localMax) {
	    throw new RuntimeException("min greater than max");
	  } else if(localMin == localMax) {
	    throw new RuntimeException("min equal to max");
	  }
	  
	  Number.instance(localMin + scala.util.Random.nextInt(localMax-localMin+1))
	  
	}
	
	@naturalistic.lang.annotations.Verb(name = "real", signature = "real of itself", returnType = "Number with Real", container = "Random")
	def real_of_itself : naturalistic.lang.Real = {
	  Number.instance(scala.util.Random.nextFloat)
	}
}