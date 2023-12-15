package naturalistic.lang;

/**
@author Oscar Pulido Prieto.
*/

@naturalistic.lang.annotations.Adjective(name = "Real")
trait Real extends NumberProperty {
  

  private var primitive : scala.Float = 0.0f;
  override def getValue[T >: scala.AnyVal] = primitive;
  def setValue(value : scala.Float) {
    this.primitive = value;
  }
  def setValue(value : scala.Double) {
    this.primitive = value.toFloat
  }
  
 
  def value_$eq(num : Number with Real) {
    this.primitive = num.getValue.toFloat;
  }

  def value = this;
	
	
  
  def __floatValue : scala.Float = primitive.asInstanceOf[scala.Float];
  
  def setContainerValue(value : NumberProperty) {
    this.primitive = value.getValue.asInstanceOf[scala.Float];
  }
  
  @naturalistic.lang.annotations.Verb(name = "equal", preposition = "to", signature = "itself equal to Thing", returnType = "naturalistic.lang.Thing", container = "Real")
  override def itself_equal_to_arg(thing : naturalistic.lang.Concept) : naturalistic.lang.Boolean = {
	
    if(!thing.isInstanceOf[Number]) {
      return False;
    } else if(thing.isInstanceOf[Number with Integer]) {
      if(thing.asInstanceOf[Integer].__intValue == this.primitive) {
        return True;
      }
    } else if(thing.isInstanceOf[Number with Real]) {
      if(thing.asInstanceOf[Real].__floatValue == this.primitive) {
        return True;
      }
    } else if(thing.isInstanceOf[Number with Character]) {
      if(thing.asInstanceOf[Character].__charValue == this.primitive) {
        return True;
      }
    }
    return False;
  }
	
	
  
  @naturalistic.lang.annotations.Verb(name = "negative", signature = "negative of itself", returnType = "NumberProperty", container = "Real")
  def negative_of_itself : naturalistic.lang.Number with naturalistic.lang.Real = {
    naturalistic.lang.Number.instance(-(primitive.asInstanceOf[scala.Float]));
  }
  
  @naturalistic.lang.annotations.Verb(name = "squareroot", signature = "squareroot of itself", returnType = "NumberProperty", container = "Real")
  def squareroot_of_itself : naturalistic.lang.Number = {
    naturalistic.lang.Number.instance(scala.math.sqrt(primitive.asInstanceOf[scala.Float]));
  }
  

  @naturalistic.lang.annotations.Verb(name = "plus", signature = "itself plus NumberProperty", returnType = "NumberProperty", container = "Real")
	def itself_plus_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "NumberProperty") num : NumberProperty) : NumberProperty = {
		return this.itself_$plus_arg(num);
	}

	@naturalistic.lang.annotations.Verb(name = "minus", signature = "itself minus naturalistic.lang.NumberProperty", returnType = "naturalistic.lang.NumberProperty", container = "Real")
	def itself_minus_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.NumberProperty") num : naturalistic.lang.NumberProperty) : naturalistic.lang.NumberProperty = {
		return this.itself_$minus_arg(num);
	}
  
	@naturalistic.lang.annotations.Verb(name = "times", signature = "itself times naturalistic.lang.NumberProperty", returnType = "naturalistic.lang.NumberProperty", container = "Real")
	def itself_times_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.NumberProperty") num : naturalistic.lang.NumberProperty) : naturalistic.lang.NumberProperty = {
		return this.itself_$times_arg(num);
	}
	
	@naturalistic.lang.annotations.Verb(name = "by", signature = "itself by naturalistic.lang.NumberProperty", returnType = "naturalistic.lang.NumberProperty", container = "Real")
	def itself_by_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.NumberProperty") num : naturalistic.lang.NumberProperty) : naturalistic.lang.NumberProperty = {
		return this.itself_$div_arg(num);
	}
	
	@naturalistic.lang.annotations.Verb(name = "mod", signature = "itself mod NumberProperty", returnType = "NumberProperty", container = "Real")
	def itself_mod_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "NumberProperty") num : NumberProperty) : naturalistic.lang.NumberProperty = {
		return this.itself_$percent_arg(num);
	}
	

	@naturalistic.lang.annotations.Verb(name = "add", signature = "add NumberProperty to itself", preposition = "to", returnType = "NumberProperty", container = "Real")
	def add_arg_to_itself( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.NumberProperty") num : naturalistic.lang.NumberProperty) : naturalistic.lang.NumberProperty = {
	  if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    this.primitive = this.getValue.asInstanceOf[scala.Float] + num.getValue.asInstanceOf[scala.Int];
  		return this;
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    this.primitive = this.getValue.asInstanceOf[scala.Float] + num.getValue.asInstanceOf[scala.Float];
  		return this;
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    this.primitive = this.getValue.asInstanceOf[scala.Float] + num.getValue.asInstanceOf[scala.Char];
  		return this;
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}

	@naturalistic.lang.annotations.Verb(name = "multiply", signature = "multiply NumberProperty by itself", preposition = "by", returnType = "NumberProperty", container = "Real")
	def multiply_arg_by_itself( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "NumberProperty") num : NumberProperty) : NumberProperty = {
		if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    this.primitive = this.getValue.asInstanceOf[scala.Float] * num.getValue.asInstanceOf[scala.Int];
  		return this;
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    this.primitive = this.getValue.asInstanceOf[scala.Float] * num.getValue.asInstanceOf[scala.Float];
  		return this;
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    this.primitive = this.getValue.asInstanceOf[scala.Float] * num.getValue.asInstanceOf[scala.Char];
  		return this;
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}

	@naturalistic.lang.annotations.Verb(name = "divide", signature = "divide NumberProperty by itself", preposition = "by", returnType = "NumberProperty", container = "Real")
	def divide_arg_by_itself( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "NumberProperty") num : NumberProperty) : NumberProperty = {
		if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    this.primitive = num.getValue.asInstanceOf[scala.Int] / this.getValue.asInstanceOf[scala.Float];
  		return this;
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    this.primitive = num.getValue.asInstanceOf[scala.Float] / this.getValue.asInstanceOf[scala.Float];
  		return this;
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    this.primitive = num.getValue.asInstanceOf[scala.Char] / this.getValue.asInstanceOf[scala.Float];
  		return this;
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}
	
	@naturalistic.lang.annotations.Verb(name = "leftover", signature = "leftover NumberProperty by itself", preposition = "by", returnType = "NumberProperty", container = "Real")
	def leftover_arg_by_itself( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "NumberProperty") num : NumberProperty) : NumberProperty = {
		if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    this.primitive = num.getValue.asInstanceOf[scala.Int] % this.getValue.asInstanceOf[scala.Float];
  		return this;
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    this.primitive = num.getValue.asInstanceOf[scala.Float] % this.getValue.asInstanceOf[scala.Float];
  		return this;
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    this.primitive = num.getValue.asInstanceOf[scala.Char] % this.getValue.asInstanceOf[scala.Float];
  		return this;
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}
	
	@naturalistic.lang.annotations.Verb(name = "subtract", signature = "subtract NumberProperty from itself", preposition = "from", returnType = "NumberProperty", container = "Real")
	def subtract_arg_from_itself( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "NumberProperty") num : NumberProperty) : NumberProperty = {
		if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    this.primitive = this.getValue.asInstanceOf[scala.Float] - num.getValue.asInstanceOf[scala.Int];
  		return this;
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    this.primitive = this.getValue.asInstanceOf[scala.Float] - num.getValue.asInstanceOf[scala.Float];
  		return this;
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    this.primitive = this.getValue.asInstanceOf[scala.Float] - num.getValue.asInstanceOf[scala.Char];
  		return this;
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}
	
	@naturalistic.lang.annotations.Verb(name = "+", signature = "itself + NumberProperty", returnType = "NumberProperty", container = "Real")
	def itself_$plus_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "NumberProperty") num : NumberProperty) : NumberProperty = {
		if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    val ret = new Number with Real;
  		ret.setValue(this.getValue.asInstanceOf[scala.Float] + num.getValue.asInstanceOf[scala.Int]);
  		return ret;
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    val ret = new Number with Real;
  		ret.setValue(this.getValue.asInstanceOf[scala.Float] + num.getValue.asInstanceOf[scala.Float]);
  		return ret;
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    val ret = new Number with Real;
  		ret.setValue(this.getValue.asInstanceOf[scala.Float] + num.getValue.asInstanceOf[scala.Char]);
  		return ret;
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}

	@naturalistic.lang.annotations.Verb(name = "-", signature = "itself - NumberProperty", returnType = "NumberProperty", container = "Real")
	def itself_$minus_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "NumberProperty") num : NumberProperty) : NumberProperty = {
		if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    val ret = new Number with Real;
  		ret.setValue(this.getValue.asInstanceOf[scala.Float] - num.getValue.asInstanceOf[scala.Int]);
  		return ret;
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    val ret = new Number with Real;
  		ret.setValue(this.getValue.asInstanceOf[scala.Float] - num.getValue.asInstanceOf[scala.Float]);
  		return ret;
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    val ret = new Number with Real;
  		ret.setValue(this.getValue.asInstanceOf[scala.Float] - num.getValue.asInstanceOf[scala.Char]);
  		return ret;
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}

	@naturalistic.lang.annotations.Verb(name = "*", signature = "itself * NumberProperty", returnType = "NumberProperty", container = "Real")
	def itself_$times_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "NumberProperty") num : NumberProperty) : NumberProperty = {
		if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    val ret = new Number with Real;
  		ret.setValue(this.getValue.asInstanceOf[scala.Float] * num.getValue.asInstanceOf[scala.Int]);
  		return ret;
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    val ret = new Number with Real;
  		ret.setValue(this.getValue.asInstanceOf[scala.Float] * num.getValue.asInstanceOf[scala.Float]);
  		return ret;
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    val ret = new Number with Real;
  		ret.setValue(this.getValue.asInstanceOf[scala.Float] * num.getValue.asInstanceOf[scala.Char]);
  		return ret;
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}

	@naturalistic.lang.annotations.Verb(name = "/", signature = "itself / NumberProperty", returnType = "NumberProperty", container = "Real")
	def itself_$div_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "NumberProperty") num : NumberProperty) : NumberProperty = {
		if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    val ret = new Number with Real;
		  ret.setValue(this.getValue.asInstanceOf[scala.Float] / num.getValue.asInstanceOf[scala.Int]);
		  return ret;
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    val ret = new Number with Real;
		  ret.setValue(this.getValue.asInstanceOf[scala.Float] / num.getValue.asInstanceOf[scala.Float]);
		  return ret;
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    val ret = new Number with Real;
		  ret.setValue(this.getValue.asInstanceOf[scala.Float] / num.getValue.asInstanceOf[scala.Char]);
		  return ret;
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}

	@naturalistic.lang.annotations.Verb(name = "%", signature = "itself % NumberProperty", returnType = "NumberProperty", container = "Real")
	def itself_$percent_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "NumberProperty") num : NumberProperty) : NumberProperty = {
		if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    val ret = new Number with Real;
		  ret.setValue(this.getValue.asInstanceOf[scala.Float] % num.getValue.asInstanceOf[scala.Int]);
		return ret;
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    val ret = new Number with Real;
		  ret.setValue(this.getValue.asInstanceOf[scala.Float] % num.getValue.asInstanceOf[scala.Float]);
		return ret;
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    val ret = new Number with Real;
		  ret.setValue(this.getValue.asInstanceOf[scala.Float] % num.getValue.asInstanceOf[scala.Char]);
		return ret;
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}
	
	@naturalistic.lang.annotations.Verb(name = "integer", signature = "integer of itself", returnType = "Number with Integer", container = "Real")
	def integer_of_itself : NumberProperty = {
		return naturalistic.lang.Number.instance(this.getValue.asInstanceOf[scala.Float].toInt);
	}
	

  @naturalistic.lang.annotations.Verb(name = ">", signature = "itself > naturalistic.lang.Comparable", returnType = "naturalistic.lang.Comparable", container = "Real")
	def itself_$greater_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.Comparable") num : naturalistic.lang.Comparable) : naturalistic.lang.Boolean = {
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    throw new RuntimeException("Error: Illegal value to compare");
	  }
	  if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] > num.asInstanceOf[naturalistic.lang.Integer].getValue.asInstanceOf[scala.Int]);
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] > num.asInstanceOf[naturalistic.lang.Real].getValue.asInstanceOf[scala.Float]);
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] > num.asInstanceOf[naturalistic.lang.Character].getValue.asInstanceOf[scala.Char]);
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}
	@naturalistic.lang.annotations.Verb(name = ">=", signature = "itself >= naturalistic.lang.Comparable", returnType = "naturalistic.lang.Comparable", container = "Real")
	def itself_$greater$eq_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.Comparable") num : naturalistic.lang.Comparable) : naturalistic.lang.Boolean = {
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    throw new RuntimeException("Error: Illegal value to compare");
	  }
	  if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] >= num.asInstanceOf[naturalistic.lang.Integer].getValue.asInstanceOf[scala.Int]);
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] >= num.asInstanceOf[naturalistic.lang.Real].getValue.asInstanceOf[scala.Float]);
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] >= num.asInstanceOf[naturalistic.lang.Character].getValue.asInstanceOf[scala.Char]);
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}
  @naturalistic.lang.annotations.Verb(name = "<", signature = "itself < naturalistic.lang.Comparable", returnType = "naturalistic.lang.Comparable", container = "Real")
  def itself_$less_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.Comparable") num : naturalistic.lang.Comparable) : naturalistic.lang.Boolean = {
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    throw new RuntimeException("Error: Illegal value to compare");
	  }
	  if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] < num.asInstanceOf[naturalistic.lang.Integer].getValue.asInstanceOf[scala.Int]);
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] < num.asInstanceOf[naturalistic.lang.Real].getValue.asInstanceOf[scala.Float]);
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] < num.asInstanceOf[naturalistic.lang.Character].getValue.asInstanceOf[scala.Char]);
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}
  @naturalistic.lang.annotations.Verb(name = "<=", signature = "itself <= naturalistic.lang.Comparable", returnType = "naturalistic.lang.Comparable", container = "Real")
  def itself_$less$eq_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.Comparable") num : naturalistic.lang.Comparable) : naturalistic.lang.Boolean = {
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    throw new RuntimeException("Error: Illegal value to compare");
	  }
	  if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] <= num.asInstanceOf[naturalistic.lang.Integer].getValue.asInstanceOf[scala.Int]);
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] <= num.asInstanceOf[naturalistic.lang.Real].getValue.asInstanceOf[scala.Float]);
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] <= num.asInstanceOf[naturalistic.lang.Character].getValue.asInstanceOf[scala.Char]);
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}
  @naturalistic.lang.annotations.Verb(name = "!=", signature = "itself != naturalistic.lang.Comparable", returnType = "naturalistic.lang.Comparable", container = "Real")
  def itself_$bang$eq_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.Comparable") num : naturalistic.lang.Comparable) : naturalistic.lang.Boolean = {
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    throw new RuntimeException("Error: Illegal value to compare");
	  }
	  if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] != num.asInstanceOf[naturalistic.lang.Integer].getValue.asInstanceOf[scala.Int]);
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] != num.asInstanceOf[naturalistic.lang.Real].getValue.asInstanceOf[scala.Float]);
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] != num.asInstanceOf[naturalistic.lang.Character].getValue.asInstanceOf[scala.Char]);
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}
  @naturalistic.lang.annotations.Verb(name = "==", signature = "itself == naturalistic.lang.Comparable", returnType = "naturalistic.lang.Comparable", container = "Real")
  def itself_$eq$eq_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.Comparable") num : naturalistic.lang.Comparable) : naturalistic.lang.Boolean = {
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    throw new RuntimeException("Error: Illegal value to compare");
	  }
	  if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    naturalistic.lang.Boolean.instance(this.primitive == num.asInstanceOf[naturalistic.lang.Integer].getValue);
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    naturalistic.lang.Boolean.instance(this.primitive == num.asInstanceOf[naturalistic.lang.Real].getValue);
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    naturalistic.lang.Boolean.instance(this.primitive == num.asInstanceOf[naturalistic.lang.Character].getValue);
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}
  
  @naturalistic.lang.annotations.Verb(name = "greaterThan", signature = "itself greaterThan naturalistic.lang.Comparable", returnType = "naturalistic.lang.Comparable", container = "Real")
  def itself_greater_than_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.Comparable") num : naturalistic.lang.Comparable) : naturalistic.lang.Boolean = {
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    throw new RuntimeException("Error: Illegal value to compare");
	  }
	  if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] > num.asInstanceOf[naturalistic.lang.Integer].getValue.asInstanceOf[scala.Int]);
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] > num.asInstanceOf[naturalistic.lang.Real].getValue.asInstanceOf[scala.Float]);
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] > num.asInstanceOf[naturalistic.lang.Character].getValue.asInstanceOf[scala.Char]);
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}
	@naturalistic.lang.annotations.Verb(name = "greaterOrEqualThan", signature = "itself greaterOrEqualThan naturalistic.lang.Comparable", returnType = "naturalistic.lang.Comparable", container = "Real")
	def itself_greater_or_equal_than_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.Comparable") num : naturalistic.lang.Comparable) : naturalistic.lang.Boolean = {
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    throw new RuntimeException("Error: Illegal value to compare");
	  }
	  if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] >= num.asInstanceOf[naturalistic.lang.Integer].getValue.asInstanceOf[scala.Int]);
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] >= num.asInstanceOf[naturalistic.lang.Real].getValue.asInstanceOf[scala.Float]);
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] >= num.asInstanceOf[naturalistic.lang.Character].getValue.asInstanceOf[scala.Char]);
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}
  @naturalistic.lang.annotations.Verb(name = "lesserThan", signature = "itself lesserThan naturalistic.lang.Comparable", returnType = "naturalistic.lang.Comparable", container = "Real")
  def itself_lesser_than_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.Comparable") num : naturalistic.lang.Comparable) : naturalistic.lang.Boolean = {
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    throw new RuntimeException("Error: Illegal value to compare");
	  }
	  if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] < num.asInstanceOf[naturalistic.lang.Integer].getValue.asInstanceOf[scala.Int]);
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] < num.asInstanceOf[naturalistic.lang.Real].getValue.asInstanceOf[scala.Float]);
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] < num.asInstanceOf[naturalistic.lang.Character].getValue.asInstanceOf[scala.Char]);
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}
  @naturalistic.lang.annotations.Verb(name = "lesserOrEqualThan", signature = "itself lesserOrEqualThan naturalistic.lang.Comparable", returnType = "naturalistic.lang.Comparable", container = "Real")
  def itself_lesser_or_equal_than_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.Comparable") num : naturalistic.lang.Comparable) : naturalistic.lang.Boolean = {
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    throw new RuntimeException("Error: Illegal value to compare");
	  }
	  if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] <= num.asInstanceOf[naturalistic.lang.Integer].getValue.asInstanceOf[scala.Int]);
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] <= num.asInstanceOf[naturalistic.lang.Real].getValue.asInstanceOf[scala.Float]);
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] <= num.asInstanceOf[naturalistic.lang.Character].getValue.asInstanceOf[scala.Char]);
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}
  @naturalistic.lang.annotations.Verb(name = "distinct", signature = "itself distinct naturalistic.lang.Comparable", returnType = "naturalistic.lang.Comparable", container = "Real")
  override def itself_distinct_to_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.Comparable") num : naturalistic.lang.Concept) : naturalistic.lang.Boolean = {
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    return False;
	  }
	  if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] != num.asInstanceOf[naturalistic.lang.Integer].getValue.asInstanceOf[scala.Int]);
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] != num.asInstanceOf[naturalistic.lang.Real].getValue.asInstanceOf[scala.Float]);
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Float] != num.asInstanceOf[naturalistic.lang.Character].getValue.asInstanceOf[scala.Char]);
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}
  
}