package naturalistic.lang

/**
@author Oscar Pulido Prieto.
*/

@naturalistic.lang.annotations.Adjective(name = "Character")
trait Character extends naturalistic.lang.NumberProperty /*with naturalistic.lang.Comparable*/ {
  
  private var primitive : scala.Char = ' ';
  override def getValue[T >: scala.AnyVal] = primitive;
  def setValue(value : scala.Char) {
    this.primitive = value;
  }
	
  
  def value_$eq(num : Number with Character) {
    this.primitive = num.getValue.toChar;
  }
  
  def value = this;
  
	
  
  def __charValue : scala.Char = primitive.asInstanceOf[scala.Char];
  
  def setContainerValue(value : NumberProperty) {
    this.primitive = value.getValue.asInstanceOf[scala.Char];
  }
  
  @naturalistic.lang.annotations.Verb(name = "equal", preposition = "to", signature = "itself equal to Thing", returnType = "naturalistic.lang.Thing", container = "Character")
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
  
  
  
  @naturalistic.lang.annotations.Verb(name = "negative", signature = "negative of itself", returnType = "NumberProperty", container = "Character")
  def negative_of_itself : naturalistic.lang.Number with naturalistic.lang.Character = {
    naturalistic.lang.Number.instance(primitive.asInstanceOf[scala.Char].toInt.*(-1).toChar);
  }
  
  
  @naturalistic.lang.annotations.Verb(name = "plus", signature = "itself plus NumberProperty", returnType = "NumberProperty", container = "Character")
	def itself_plus_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "NumberProperty") num : NumberProperty) : NumberProperty = {
		return this.itself_$plus_arg(num);
	}

	@naturalistic.lang.annotations.Verb(name = "minus", signature = "itself minus naturalistic.lang.NumberProperty", returnType = "naturalistic.lang.NumberProperty", container = "Character")
	def itself_minus_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.NumberProperty") num : naturalistic.lang.NumberProperty) : naturalistic.lang.NumberProperty = {
		return this.itself_$minus_arg(num);
	}
  
	@naturalistic.lang.annotations.Verb(name = "times", signature = "itself times naturalistic.lang.NumberProperty", returnType = "naturalistic.lang.NumberProperty", container = "Character")
	def itself_times_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.NumberProperty") num : naturalistic.lang.NumberProperty) : naturalistic.lang.NumberProperty = {
		return this.itself_$times_arg(num);
	}
	
	@naturalistic.lang.annotations.Verb(name = "by", signature = "itself by naturalistic.lang.NumberProperty", returnType = "naturalistic.lang.NumberProperty", container = "Character")
	def itself_by_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.NumberProperty") num : naturalistic.lang.NumberProperty) : naturalistic.lang.NumberProperty = {
		return this.itself_$div_arg(num);
	}

	@naturalistic.lang.annotations.Verb(name = "add", signature = "add NumberProperty to itself", preposition = "to", returnType = "NumberProperty", container = "Character")
	def add_arg_to_itself( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.NumberProperty") num : naturalistic.lang.NumberProperty) : naturalistic.lang.NumberProperty = {
	  if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    this.primitive = (this.getValue.asInstanceOf[scala.Char] + num.getValue.asInstanceOf[scala.Int]).toChar;
  		return this;
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    this.primitive = (this.getValue.asInstanceOf[scala.Char] + num.getValue.asInstanceOf[scala.Float]).toChar;
  		return this;
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    this.primitive = (this.getValue.asInstanceOf[scala.Char] + num.getValue.asInstanceOf[scala.Char]).toChar;
  		return this;
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}

	@naturalistic.lang.annotations.Verb(name = "multiply", signature = "multiply NumberProperty by itself", preposition = "by", returnType = "NumberProperty", container = "Character")
	def multiply_arg_by_itself( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "NumberProperty") num : NumberProperty) : NumberProperty = {
		if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    this.primitive = (this.getValue.asInstanceOf[scala.Float] * num.getValue.asInstanceOf[scala.Int]).toChar;
  		return this;
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    this.primitive = (this.getValue.asInstanceOf[scala.Float] * num.getValue.asInstanceOf[scala.Float]).toChar;
  		return this;
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    this.primitive = (this.getValue.asInstanceOf[scala.Float] * num.getValue.asInstanceOf[scala.Char]).toChar;
  		return this;
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}

	@naturalistic.lang.annotations.Verb(name = "divide", signature = "divide NumberProperty by itself", preposition = "by", returnType = "NumberProperty", container = "Character")
	def divide_arg_by_itself( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "NumberProperty") num : NumberProperty) : NumberProperty = {
		if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    this.primitive = (num.getValue.asInstanceOf[scala.Int] / this.getValue.asInstanceOf[scala.Float]).toChar;
  		return this;
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    this.primitive = (num.getValue.asInstanceOf[scala.Float] / this.getValue.asInstanceOf[scala.Float]).toChar;
  		return this;
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    this.primitive = (num.getValue.asInstanceOf[scala.Char] / this.getValue.asInstanceOf[scala.Float]).toChar;
  		return this;
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}
	
	@naturalistic.lang.annotations.Verb(name = "subtract", signature = "subtract NumberProperty from itself", preposition = "from", returnType = "NumberProperty", container = "Character")
	def subtract_arg_from_itself( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "NumberProperty") num : NumberProperty) : NumberProperty = {
		if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    this.primitive = (this.getValue.asInstanceOf[scala.Float] - num.getValue.asInstanceOf[scala.Int]).toChar;
  		return this;
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    this.primitive = (this.getValue.asInstanceOf[scala.Float] - num.getValue.asInstanceOf[scala.Float]).toChar;
  		return this;
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    this.primitive = (this.getValue.asInstanceOf[scala.Float] - num.getValue.asInstanceOf[scala.Char]).toChar;
  		return this;
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}
	
	/** Arithmetic operations with symbol */
	@naturalistic.lang.annotations.Verb(name = "+", signature = "itself + NumberProperty", returnType = "NumberProperty", container = "Character")
	def itself_$plus_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "NumberProperty") num : NumberProperty) : NumberProperty = {
		if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    val ret = new Number with Real;
  		ret.setValue((this.getValue.asInstanceOf[scala.Float] + num.getValue.asInstanceOf[scala.Int]).toChar);
  		return ret;
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    val ret = new Number with Real;
  		ret.setValue((this.getValue.asInstanceOf[scala.Float] + num.getValue.asInstanceOf[scala.Float]).toChar);
  		return ret;
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    val ret = new Number with Real;
  		ret.setValue((this.getValue.asInstanceOf[scala.Float] + num.getValue.asInstanceOf[scala.Char]).toChar);
  		return ret;
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}

	@naturalistic.lang.annotations.Verb(name = "-", signature = "itself - NumberProperty", returnType = "NumberProperty", container = "Character")
	def itself_$minus_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "NumberProperty") num : NumberProperty) : NumberProperty = {
		if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    val ret = new Number with Real;
  		ret.setValue((this.getValue.asInstanceOf[scala.Float] - num.getValue.asInstanceOf[scala.Int]).toChar);
  		return ret;
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    val ret = new Number with Real;
  		ret.setValue((this.getValue.asInstanceOf[scala.Float] - num.getValue.asInstanceOf[scala.Float]).toChar);
  		return ret;
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    val ret = new Number with Real;
  		ret.setValue((this.getValue.asInstanceOf[scala.Float] - num.getValue.asInstanceOf[scala.Char]).toChar);
  		return ret;
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}

	@naturalistic.lang.annotations.Verb(name = "*", signature = "itself * NumberProperty", returnType = "NumberProperty", container = "Character")
	def itself_$times_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "NumberProperty") num : NumberProperty) : NumberProperty = {
		if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    val ret = new Number with Real;
  		ret.setValue((this.getValue.asInstanceOf[scala.Float] * num.getValue.asInstanceOf[scala.Int]).toChar);
  		return ret;
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    val ret = new Number with Real;
  		ret.setValue((this.getValue.asInstanceOf[scala.Float] * num.getValue.asInstanceOf[scala.Float]).toChar);
  		return ret;
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    val ret = new Number with Real;
  		ret.setValue((this.getValue.asInstanceOf[scala.Float] * num.getValue.asInstanceOf[scala.Char]).toChar);
  		return ret;
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}

	@naturalistic.lang.annotations.Verb(name = "/", signature = "itself / NumberProperty", returnType = "NumberProperty", container = "Character")
	def itself_$div_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "NumberProperty") num : NumberProperty) : NumberProperty = {
		if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    val ret = new Number with Real;
		  ret.setValue((this.getValue.asInstanceOf[scala.Float] / num.getValue.asInstanceOf[scala.Int]).toChar);
		  return ret;
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    val ret = new Number with Real;
		  ret.setValue((this.getValue.asInstanceOf[scala.Float] / num.getValue.asInstanceOf[scala.Float]).toChar);
		  return ret;
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    val ret = new Number with Real;
		  ret.setValue((this.getValue.asInstanceOf[scala.Float] / num.getValue.asInstanceOf[scala.Char]).toChar);
		  return ret;
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}

	@naturalistic.lang.annotations.Verb(name = "%", signature = "itself % NumberProperty", returnType = "NumberProperty", container = "Character")
	def itself_$percent_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "NumberProperty") num : NumberProperty) : NumberProperty = {
		if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    val ret = new Number with Real;
		  ret.setValue((this.getValue.asInstanceOf[scala.Float] % num.getValue.asInstanceOf[scala.Int]).toChar);
		return ret;
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    val ret = new Number with Real;
		  ret.setValue((this.getValue.asInstanceOf[scala.Float] % num.getValue.asInstanceOf[scala.Float]).toChar);
		return ret;
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    val ret = new Number with Real;
		  ret.setValue((this.getValue.asInstanceOf[scala.Float] % num.getValue.asInstanceOf[scala.Char]).toChar);
		return ret;
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}

	@naturalistic.lang.annotations.Verb(name = "integer", signature = "integer of itself", returnType = "Number with Character", container = "Character")
	def integer_of_itself : NumberProperty = {
		return naturalistic.lang.Number.instance(this.getValue.asInstanceOf[scala.Int]);
	}
	
	/**@naturalistic.lang.annotations.Verb(name = "receives", signature = "itself receives naturalistic.lang.String", returnType = "naturalistic.lang.NumberProperty")
  def itself_receives_arg(arg0 : naturalistic.lang.String) : naturalistic.lang.NumberProperty = {
	  this.primitive = arg0.getValue.toCharArray()(0);
	  this;
	}*/
	
	/** Relational operations with symbol */
  @naturalistic.lang.annotations.Verb(name = ">", signature = "itself > naturalistic.lang.Comparable", returnType = "naturalistic.lang.Comparable", container = "Character")
	def itself_$greater_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.Comparable") num : naturalistic.lang.Comparable) : naturalistic.lang.Boolean = {
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    throw new RuntimeException("Error: Illegal value to compare");
	  }
	  if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] > num.asInstanceOf[naturalistic.lang.Integer].getValue.asInstanceOf[scala.Int]);
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] > num.asInstanceOf[naturalistic.lang.Real].getValue.asInstanceOf[scala.Float]);
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] > num.asInstanceOf[naturalistic.lang.Character].getValue.asInstanceOf[scala.Char]);
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}
	@naturalistic.lang.annotations.Verb(name = ">=", signature = "itself >= naturalistic.lang.Comparable", returnType = "naturalistic.lang.Comparable", container = "Character")
	def itself_$greater$eq_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.Comparable") num : naturalistic.lang.Comparable) : naturalistic.lang.Boolean = {
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    throw new RuntimeException("Error: Illegal value to compare");
	  }
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    throw new RuntimeException("Error: Illegal value to compare");
	  }
	  if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] >= num.asInstanceOf[naturalistic.lang.Integer].getValue.asInstanceOf[scala.Int]);
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] >= num.asInstanceOf[naturalistic.lang.Real].getValue.asInstanceOf[scala.Float]);
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] >= num.asInstanceOf[naturalistic.lang.Character].getValue.asInstanceOf[scala.Char]);
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}
  @naturalistic.lang.annotations.Verb(name = "<", signature = "itself < naturalistic.lang.Comparable", returnType = "naturalistic.lang.Comparable", container = "Character")
  def itself_$less_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.Comparable") num : naturalistic.lang.Comparable) : naturalistic.lang.Boolean = {
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    throw new RuntimeException("Error: Illegal value to compare");
	  }
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    throw new RuntimeException("Error: Illegal value to compare");
	  }
	  if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] < num.asInstanceOf[naturalistic.lang.Integer].getValue.asInstanceOf[scala.Int]);
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] < num.asInstanceOf[naturalistic.lang.Real].getValue.asInstanceOf[scala.Float]);
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] < num.asInstanceOf[naturalistic.lang.Character].getValue.asInstanceOf[scala.Char]);
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}
  @naturalistic.lang.annotations.Verb(name = "<=", signature = "itself <= naturalistic.lang.Comparable", returnType = "naturalistic.lang.Comparable", container = "Character")
  def itself_$less$eq_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.Comparable") num : naturalistic.lang.Comparable) : naturalistic.lang.Boolean = {
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    throw new RuntimeException("Error: Illegal value to compare");
	  }
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    throw new RuntimeException("Error: Illegal value to compare");
	  }
	  if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] <= num.asInstanceOf[naturalistic.lang.Integer].getValue.asInstanceOf[scala.Int]);
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] <= num.asInstanceOf[naturalistic.lang.Real].getValue.asInstanceOf[scala.Float]);
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] <= num.asInstanceOf[naturalistic.lang.Character].getValue.asInstanceOf[scala.Char]);
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}
  @naturalistic.lang.annotations.Verb(name = "!=", signature = "itself != naturalistic.lang.Comparable", returnType = "naturalistic.lang.Comparable", container = "Character")
  def itself_$bang$eq_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.Comparable") num : naturalistic.lang.Comparable) : naturalistic.lang.Boolean = {
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    throw new RuntimeException("Error: Illegal value to compare");
	  }
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    throw new RuntimeException("Error: Illegal value to compare");
	  }
	  if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] != num.asInstanceOf[naturalistic.lang.Integer].getValue.asInstanceOf[scala.Int]);
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] != num.asInstanceOf[naturalistic.lang.Real].getValue.asInstanceOf[scala.Float]);
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] != num.asInstanceOf[naturalistic.lang.Character].getValue.asInstanceOf[scala.Char]);
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}
  @naturalistic.lang.annotations.Verb(name = "==", signature = "itself == naturalistic.lang.Comparable", returnType = "naturalistic.lang.Comparable", container = "Character")
  def itself_$eq$eq_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.Comparable") num : naturalistic.lang.Comparable) : naturalistic.lang.Boolean = {
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    throw new RuntimeException("Error: Illegal value to compare");
	  }
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
  
  /** Relational operations with letter */
  @naturalistic.lang.annotations.Verb(name = "greaterThan", signature = "itself greaterThan naturalistic.lang.Comparable", returnType = "naturalistic.lang.Comparable", container = "Character")
  def itself_greater_than_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.Comparable") num : naturalistic.lang.Comparable) : naturalistic.lang.Boolean = {
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    throw new RuntimeException("Error: Illegal value to compare");
	  }
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    throw new RuntimeException("Error: Illegal value to compare");
	  }
	  if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] > num.asInstanceOf[naturalistic.lang.Integer].getValue.asInstanceOf[scala.Int]);
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] > num.asInstanceOf[naturalistic.lang.Real].getValue.asInstanceOf[scala.Float]);
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] > num.asInstanceOf[naturalistic.lang.Character].getValue.asInstanceOf[scala.Char]);
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}
	@naturalistic.lang.annotations.Verb(name = "greaterOrEqualThan", signature = "itself greaterOrEqualThan naturalistic.lang.Comparable", returnType = "naturalistic.lang.Comparable", container = "Character")
	def itself_greater_or_equal_than_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.Comparable") num : naturalistic.lang.Comparable) : naturalistic.lang.Boolean = {
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    throw new RuntimeException("Error: Illegal value to compare");
	  }
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    throw new RuntimeException("Error: Illegal value to compare");
	  }
	  if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] >= num.asInstanceOf[naturalistic.lang.Integer].getValue.asInstanceOf[scala.Int]);
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] >= num.asInstanceOf[naturalistic.lang.Real].getValue.asInstanceOf[scala.Float]);
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] >= num.asInstanceOf[naturalistic.lang.Character].getValue.asInstanceOf[scala.Char]);
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}
  @naturalistic.lang.annotations.Verb(name = "lesserThan", signature = "itself lesserThan naturalistic.lang.Comparable", returnType = "naturalistic.lang.Comparable", container = "Character")
  def itself_lesser_than_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.Comparable") num : naturalistic.lang.Comparable) : naturalistic.lang.Boolean = {
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    throw new RuntimeException("Error: Illegal value to compare");
	  }
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    throw new RuntimeException("Error: Illegal value to compare");
	  }
	  if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] < num.asInstanceOf[naturalistic.lang.Integer].getValue.asInstanceOf[scala.Int]);
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] < num.asInstanceOf[naturalistic.lang.Real].getValue.asInstanceOf[scala.Float]);
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] < num.asInstanceOf[naturalistic.lang.Character].getValue.asInstanceOf[scala.Char]);
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}
  @naturalistic.lang.annotations.Verb(name = "lesserOrEqualThan", signature = "itself lesserOrEqualThan naturalistic.lang.Comparable", returnType = "naturalistic.lang.Comparable", container = "Character")
  def itself_lesser_or_equal_than_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.Comparable") num : naturalistic.lang.Comparable) : naturalistic.lang.Boolean = {
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    throw new RuntimeException("Error: Illegal value to compare");
	  }
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    throw new RuntimeException("Error: Illegal value to compare");
	  }
	  if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] <= num.asInstanceOf[naturalistic.lang.Integer].getValue.asInstanceOf[scala.Int]);
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] <= num.asInstanceOf[naturalistic.lang.Real].getValue.asInstanceOf[scala.Float]);
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] <= num.asInstanceOf[naturalistic.lang.Character].getValue.asInstanceOf[scala.Char]);
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}
  @naturalistic.lang.annotations.Verb(name = "distinct", signature = "itself distinct naturalistic.lang.Comparable", returnType = "naturalistic.lang.Comparable", container = "Character")
  override def itself_distinct_to_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.Comparable") num : naturalistic.lang.Concept) : naturalistic.lang.Boolean = {
	  if(!num.isInstanceOf[naturalistic.lang.Number]) {
	    return False;
	  }
	  if(num.isInstanceOf[naturalistic.lang.Integer]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] != num.asInstanceOf[naturalistic.lang.Integer].getValue.asInstanceOf[scala.Int]);
	  } else if(num.isInstanceOf[naturalistic.lang.Real]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] != num.asInstanceOf[naturalistic.lang.Real].getValue.asInstanceOf[scala.Float]);
	  } else if(num.isInstanceOf[naturalistic.lang.Character]) {
	    naturalistic.lang.Boolean.instance(this.getValue.asInstanceOf[scala.Char] != num.asInstanceOf[naturalistic.lang.Character].getValue.asInstanceOf[scala.Char]);
	  } else {
	    throw new RuntimeException("Illegal argument type: " + num.getClass.getName);
	  }
	}
  
}

object Character {
  def instance(char : Char) : Number with Character = {
    Number.instance(char);
  }
}

class Characters extends naturalistic.lang.Numbers {
  
  @naturalistic.lang.annotations.Verb(name = "string", signature = "string of itself", returnType = "naturalistic.lang.String", container = "Characters")
  override def string_of_itself : naturalistic.lang.String = {
    var ret = new naturalistic.lang.String;
    for(aux <- this.pluralAux) {
      ret.add_arg_to_itself(aux);
    }
    ret;
  }
}

object Characters  {
  
  val singular : java.lang.Class[_ <: Concept] = classOf[naturalistic.lang.Thing];
  
  def instance(itfs : Array[java.lang.Class[_]]) : naturalistic.lang.Characters = {
    val t = new Characters{};
    t.parentClass = singular
    t.interfaces = itfs;
    t;
  }
}