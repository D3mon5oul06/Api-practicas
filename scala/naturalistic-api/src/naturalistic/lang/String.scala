package naturalistic.lang

/**
@author Oscar Pulido Prieto.
*/

@naturalistic.lang.annotations.Noun(name = "String", plural = "Strings")
class String extends naturalistic.lang.Thing {
  
  private var contained : java.lang.String = "";
  def setContained(value : java.lang.String) {
    this.contained = value
  }
  def getContained = contained
  

  def value_$eq(str : naturalistic.lang.String) {
    this.contained = str.contained;
  }

  def value = this;
  
  def setContainerValue(value : naturalistic.lang.String) {
    this.contained = value.asInstanceOf[java.lang.String];
  }
  

  
  @naturalistic.lang.annotations.Verb(name = "equal", preposition = "to", signature = "itself equal to Thing", returnType = "naturalistic.lang.Boolean", container = "String")
  override def itself_equal_to_arg(thing : naturalistic.lang.Concept) : naturalistic.lang.Boolean = {
    if(!thing.isInstanceOf[String]) {
      return False;
    }
    if(thing.asInstanceOf[String].contained.equals(this.contained)) {
      return True;
    }
    return False;
  }
  
  @naturalistic.lang.annotations.Verb(name = "distinct", preposition = "to", signature = "itself distinct to naturalistic.lang.Comparable", returnType = "naturalistic.lang.Boolean", container = "String")
  override def itself_distinct_to_arg( @naturalistic.lang.annotations.Parameter(name = "num", parameterType = "naturalistic.lang.Concept") str : naturalistic.lang.Concept) : naturalistic.lang.Boolean = {
    if(str.isInstanceOf[naturalistic.lang.String]) {
      if(this.equals(str)) {
        return naturalistic.lang.Boolean.instance(false);
      }
      if(str.isInstanceOf[naturalistic.lang.String]) {
        return naturalistic.lang.Boolean.instance(!this.contained.equals(str.asInstanceOf[naturalistic.lang.String].contained));
      }
      return naturalistic.lang.Boolean.instance(true);
    } else {
      return naturalistic.lang.Boolean.instance(true);
    }
  }
  
  
  @naturalistic.lang.annotations.Verb(name = "string", signature = "string of itself", returnType = "String", container = "String")
  override def string_of_itself : naturalistic.lang.String = naturalistic.lang.String.instance(contained);
  
  
  @naturalistic.lang.annotations.Verb(name = "hash", preposition = "hash of itself", signature = "", returnType = "Number", container = "String")
  def hash_of_itself : naturalistic.lang.Number with NumberProperty = naturalistic.lang.Number.instance(this.contained.hashCode);
  

  @naturalistic.lang.annotations.Verb(name = "compare", preposition = "with", signature = "compare String with itself", returnType = "Integer", container = "String")
  def compare_arg_with_itself(arg0 : naturalistic.lang.String) : naturalistic.lang.Number with NumberProperty = {
    naturalistic.lang.Number.instance(this.contained.compareTo(arg0.contained));
  }
  

  @naturalistic.lang.annotations.Verb(name = "position", preposition = "in", signature = "position Integer in itself", returnType = "naturalistic.lang.String", container = "String")
  def position_arg_in_itself(arg0 : naturalistic.lang.Integer) : naturalistic.lang.Number with naturalistic.lang.Character = {
    naturalistic.lang.Number.instance(contained.charAt(arg0.__intValue));
  }
  
 
  @naturalistic.lang.annotations.Verb(name = "integer", signature = "integer of itself", returnType = "Character", container = "String")
  def integer_of_itself : naturalistic.lang.Number with naturalistic.lang.NumberProperty = {
    naturalistic.lang.Number.instance(contained.toInt);
  }
  
  @naturalistic.lang.annotations.Verb(name = "real", signature = "real of itself", returnType = "Character", container = "String")
  def real_of_itself : naturalistic.lang.Number with naturalistic.lang.NumberProperty = {
    naturalistic.lang.Number.instance(contained.toFloat);
  }
  
  @naturalistic.lang.annotations.Verb(name = "concat", preposition = "with", signature = "concat String with itself", returnType = "String", container = "String")
  def concat_arg_with_itself(arg0 : naturalistic.lang.String) : naturalistic.lang.String = {
    naturalistic.lang.String.instance(this.contained.concat(arg0.contained));
  }
  
  @naturalistic.lang.annotations.Verb(name = "contains", preposition = "itself contains String", signature = "", returnType = "Boolean", container = "String")
  def itself_contains_arg(arg0 : naturalistic.lang.String) : naturalistic.lang.Boolean = {
    naturalistic.lang.Boolean.instance(this.contained.contains(arg0.contained));
  }
  
  @naturalistic.lang.annotations.Verb(name = "ends", preposition = "with", signature = "itself ends with String", returnType = "Boolean", container = "String")
  def itself_ends_with_arg(arg0 : naturalistic.lang.String) : naturalistic.lang.Boolean = {
    naturalistic.lang.Boolean.instance(this.contained.endsWith(arg0.contained));
  }
  
  @naturalistic.lang.annotations.Verb(name = "empty", signature = "empty of itself", returnType = "Boolean", container = "String")
  def empty_of_itself : naturalistic.lang.Boolean = {
    naturalistic.lang.Boolean.instance(this.contained.isEmpty);
  }
  
  @naturalistic.lang.annotations.Verb(name = "length", signature = "length of itself", returnType = "Integer", container = "String")
  def length_of_itself : naturalistic.lang.Number with NumberProperty = {
    naturalistic.lang.Number.instance(this.contained.length);
  }
  
  @naturalistic.lang.annotations.Verb(name = "splits", preposition = "with", signature = "itself splits with String", returnType = "Strings", container = "String")
  def itself_splits_with_arg(arg0 : naturalistic.lang.String) : naturalistic.lang.Strings = {
    val strings = Strings.instance(null);
    val aux = this.contained.split(arg0.contained)
    for(str <- aux) {
      strings.add_arg_to_itself(naturalistic.lang.String.instance(str))
    }
    strings;
  }
  
  @naturalistic.lang.annotations.Verb(name = "starts", preposition = "with", signature = "itself starts with String", returnType = "Boolean", container = "String")
  def itself_starts_with_arg(arg0 : naturalistic.lang.String) : naturalistic.lang.Boolean = {
    naturalistic.lang.Boolean.instance(this.contained.startsWith(arg0.contained));
  }
  
  @naturalistic.lang.annotations.Verb(name = "array", signature = "array of itself", returnType = "Numbers", container = "String")
  def array_of_itself : naturalistic.lang.Characters = {
    val aux = naturalistic.lang.Characters.instance(Array(classOf[naturalistic.lang.Character]));
      for(char <- this.contained.toCharArray) {
        aux.add_arg_to_itself(naturalistic.lang.Character.instance(char));
      }
    return aux;
  }
  
  @naturalistic.lang.annotations.Verb(name = "characters", signature = "characters of itself", returnType = "Numbers", container = "String")
  def characters_of_itself : naturalistic.lang.Characters = {
    val aux : naturalistic.lang.Characters = naturalistic.lang.Characters.instance(Array(classOf[naturalistic.lang.Character]));
    for(char <- this.contained.toCharArray) {
      aux.add_arg_to_itself(naturalistic.lang.Character.instance(char));
    }
    aux;
  }
  
  
  @naturalistic.lang.annotations.Verb(name = "uppercase", signature = "uppercase of itself", returnType = "String", container = "String")
  def uppercase_of_itself : naturalistic.lang.String = {
    naturalistic.lang.String.instance(this.contained.toUpperCase());
  }
  
 
  @naturalistic.lang.annotations.Verb(name = "lowercase", signature = "lowercase of itself", returnType = "String", container = "String")
  def lowercase_of_itself : naturalistic.lang.String = {
    naturalistic.lang.String.instance(this.contained.toLowerCase());
  }
  
 
  @naturalistic.lang.annotations.Verb(name = "add", preposition = "to", signature = "add String to itself", returnType = "String", container = "String")
  def add_arg_to_itself(arg0 : naturalistic.lang.Concept) : naturalistic.lang.String = {
    if(arg0 != null) this.contained = this.contained + arg0.string_of_itself.contained;
    else this.contained = this.contained + null
    this;
  }
  
  @naturalistic.lang.annotations.Verb(name = "matches", signature = "itself matches String", returnType = "Boolean", container = "String")
  def itself_matches_arg(arg0 : naturalistic.lang.String) : naturalistic.lang.Boolean = {
    naturalistic.lang.Boolean.instance(this.contained.matches(arg0.contained));
  }
  
  private var marked : scala.Char = _;
 
  
  @naturalistic.lang.annotations.Verb(name = "mark", preposition = "in",  signature = "mark Character in itself", returnType = "String", container = "String")
  def mark_arg_in_itself(arg0 : naturalistic.lang.Character) : naturalistic.lang.String = {
    if(this.contained.contains(arg0.__charValue)) {
      marked = arg0.__charValue;
    }
    this;
  }
  
  @naturalistic.lang.annotations.Verb(name = "replace", preposition = "into",  signature = "replace Character into itself", returnType = "String", container = "String")
  def replace_arg_into_itself(arg0 : naturalistic.lang.Character) : naturalistic.lang.String = {
    this.contained = this.contained.replace(marked, arg0.__charValue);
    marked = 0.toChar;
    this;
  }
}

object String {
  
  def instance(string : java.lang.String) : naturalistic.lang.String = {
    
    val inst = new naturalistic.lang.String;
    inst.contained = string;
    inst;
  }
}


object newline extends naturalistic.lang.String {
  {
    this.setContained("\n");
  }
}

class Strings extends naturalistic.lang.Things {}

object Strings  {
  
  val singular : java.lang.Class[_ <: Concept] = classOf[naturalistic.lang.String];
  
	def instance(itfs : Array[java.lang.Class[_]]) = {
		val t = new Strings;
		t.parentClass = singular
		t.interfaces = itfs;
		t;
	}
}

