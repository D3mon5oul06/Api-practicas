package naturalistic.lang

/**
@author Osc ar Pulido Prieto.
*/

@naturalistic.lang.annotations.Noun(name = "Ordinal", plural = "Ordinals")
abstract class Ordinal extends Thing {
  
  private var primitive : scala.Int = 0;
  def getValue[T >: scala.AnyVal] = primitive;
  def setValue(value : scala.Int) {
    this.primitive = value;
  }
  def setValue(value : scala.Long) {
    this.primitive = value.toInt;
  }
  
  def value_$eq(num : Number with Integer) {
    this.primitive = num.getValue.toInt;
  }
  
  def value = this;
	
  def __intValue : scala.Int = primitive.asInstanceOf[scala.Int];
  
  def setContainerValue(value : NumberProperty) {
    this.primitive = value.getValue.asInstanceOf[scala.Int];
  }
}

object Ordinal {
  def instance(ordinal : Int) : Ordinal = {
    val inst = new Ordinal{};
    inst.setValue(ordinal);
    
    inst;
  }
}