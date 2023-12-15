package naturalistic.lang;

/**
@author Oscar Pulido Prieto.
*/

@naturalistic.lang.annotations.Adjective(name = "Boolean")
abstract class Boolean extends naturalistic.lang.Thing {
  
  private var bool : scala.Boolean = false;
  def setBool(value : scala.Boolean) {
    this.bool = value
  }
  def getBool : scala.Boolean = bool
  
 
  def value_$eq(bl : naturalistic.lang.Boolean) {
    this.bool = bl.getBool;
  }

  def value = this;
  
  
  
  def setContainerValue(value : naturalistic.lang.Boolean) {
    this.bool = value.getBool.asInstanceOf[scala.Boolean];
  }
  
  def isFalse() : scala.Boolean 
  def isTrue() : scala.Boolean 
  
  def not() : naturalistic.lang.Boolean 
  
  def string_of_itself : naturalistic.lang.String;
  
  
  @naturalistic.lang.annotations.Verb(name = "equal", preposition = "to", signature = "itself equal to Thing", returnType = "naturalistic.lang.Thing", container = "Boolean")
  override def itself_equal_to_arg(thing : Concept) : naturalistic.lang.Boolean = {
    if(thing.isInstanceOf[naturalistic.lang.Boolean]) {
      if(thing.asInstanceOf[naturalistic.lang.Boolean].bool == this.bool) {
        True;
      } else {
        False;
      }
    } else {
      False;
    }
  }
}

object Boolean {
  def instance(b : scala.Boolean) : Boolean = {
    if(b) {
      True
    } else {
      False
    }
  }
}

class Booleans extends naturalistic.lang.Things{}

object Booleans {
  
  val singular : java.lang.Class[_ <: Concept] = classOf[naturalistic.lang.Boolean];
  
	def instance(itfs : Array[java.lang.Class[_]]) = {
		val t = new Booleans;
		t.parentClass = singular
		t.interfaces = itfs;
		t;
	}
}

object True extends naturalistic.lang.Boolean {
  
  {
    setBool(true);
  }
  
  def isFalse : scala.Boolean = !this.getBool
  def isTrue : scala.Boolean = this.getBool
  
  def not : naturalistic.lang.Boolean = Boolean.instance(!this.getBool)
  
  override def string_of_itself : naturalistic.lang.String = naturalistic.lang.String.instance("true");
}

object False extends naturalistic.lang.Boolean {

  
  def isFalse : scala.Boolean = !this.getBool
  def isTrue : scala.Boolean = this.getBool
  
  def not : naturalistic.lang.Boolean = Boolean.instance(!this.getBool)
  
  override def string_of_itself : naturalistic.lang.String = naturalistic.lang.String.instance("false");
}