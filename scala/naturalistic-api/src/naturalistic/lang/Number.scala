package naturalistic.lang;

/**
@author Oscar Pulido Prieto.
*/

@naturalistic.lang.annotations.Noun(name = "Number", plural = "Numbers")
abstract class Number extends Thing with naturalistic.lang.Comparable {
  
  @naturalistic.lang.annotations.Verb(name = "string", signature = "string of itself", returnType = "String", container = "Number")
  override def string_of_itself : naturalistic.lang.String = {
    naturalistic.lang.String.instance(this.getClass.getMethod("getValue").invoke(this).toString);
  }
  
  def value_of_itself = this;
  
}

object Number {
  
  def instance(int : Int) : Number with Integer = {
    
    val inst = new naturalistic.lang.Number with naturalistic.lang.Integer;
    inst.setValue(int);
    inst;
  }
  def instance(float : Float) : Number with Real = {
    val inst = new naturalistic.lang.Number with naturalistic.lang.Real ;
    inst.setValue(float);
    inst;
  }
  
  def instance(double : Double) : Number with Real = {
    return instance(double.floatValue())
  }
  
  def instance(long : Long) : Number with Integer = {
    return instance(long.intValue())
  }
  
  def instance(char : Char) : Number with Character = {
    val inst = new naturalistic.lang.Number with naturalistic.lang.Character ;
    inst.setValue(char);
    inst;
  }
}

class Numbers extends naturalistic.lang.Things {
  
  @naturalistic.lang.annotations.Verb(name = "pivot", signature = "pivot of itself", returnType = "naturalistic.lang.Number", container = "Number")
	def pivot_of_itself : naturalistic.lang.Number = {
		return this.head_of_itself.asInstanceOf[naturalistic.lang.Number];
	}
  
  @naturalistic.lang.annotations.Verb(name = "sorted", signature = "itself sorted", returnType = "naturalistic.lang.Boolean", container = "Number")
	def itself_sorted : naturalistic.lang.Boolean = {
    var aux0 : naturalistic.lang.Number = null;
    var listAux : scala.List[_ <: naturalistic.lang.Number] = pluralAux.asInstanceOf[scala.List[naturalistic.lang.Number]];
    if(listAux.isEmpty) {
      naturalistic.lang.Boolean.instance(false);
    } else {
      aux0 = listAux.head;
      listAux = listAux.tail;
      while(!listAux.isEmpty) {
        if(aux0.itself_greater_than_arg(listAux.head).isTrue) {
          naturalistic.lang.Boolean.instance(false);
        }
        aux0 = listAux.head;
        listAux = listAux.tail;
      }
      naturalistic.lang.Boolean.instance(true);
    }
  }
  
}

object Numbers extends naturalistic.lang.Things{
  
  override val singular : java.lang.Class[_ <: Concept] = classOf[naturalistic.lang.Number];
  
	def instance(itfs : Array[java.lang.Class[_]]) = {
		val t = new Numbers;
		t.parentClass = classOf[naturalistic.lang.Number];
		t.interfaces = itfs;
		t;
	}
}