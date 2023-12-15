package naturalistic.lang

/**
@author Oscar Pulido Prieto.
*/

trait Concept {
  
    val singular : java.lang.Class[_ <: Concept] = this.getClass;
  
  
  
  var actived_instance : scala.Boolean = false;
  def activate  {
    actived_instance = true;
  }
  def isActive : scala.Boolean = actived_instance;
  
  
  @naturalistic.lang.annotations.Verb(name = "is", preposition = "a", signature = "itself is a type of java.lang.Class", returnType = "naturalistic.lang.Boolean", container = "Concept")
  def itself_is_a_type_of_arg(t : java.lang.Class[_]*) : naturalistic.lang.Boolean = {
    var b = true;
    for(tt <- t) {
      if(tt.isInterface()) {
        b = this.validateInterfaces(tt);
      } else {
        b = this.validateSuperclass(tt);
      }
    }
    naturalistic.lang.Boolean.instance(b);
  }
  
  
  
  @naturalistic.lang.annotations.Verb(name = "as", preposition = "a", signature = "itself as a type of java.lang.Class", returnType = "naturalistic.lang.Thing", container = "Concept")
  def itself_as_a_type_of_arg[T] = this.asInstanceOf[T];
  
  @naturalistic.lang.annotations.Verb(name = "equal", preposition = "to", signature = "itself equal to Thing", returnType = "naturalistic.lang.Thing", container = "Concept")
  def itself_equal_to_arg(thing : naturalistic.lang.Concept) : naturalistic.lang.Boolean = {
    if(this.equals(thing)) {
      return True;
    }
    return False;
  }
  
  @naturalistic.lang.annotations.Verb(name = "distinct", preposition = "to", signature = "itself distinct to Thing", returnType = "naturalistic.lang.Thing", container = "Concept")
  def itself_distinct_to_arg(thing : naturalistic.lang.Concept) : naturalistic.lang.Boolean = {
    if(this.equals(thing)) {
      return False;
    }
    return True;
  }

  
  private def validateSuperclass(cls : Class[_], toSeek : Class[_]) : scala.Boolean = {
    if(toSeek.equals(cls)) {
      return true
    } else if(toSeek.equals(classOf[Thing])) {
      return false
    } else {
      return validateSuperclass(cls, toSeek.getSuperclass)
    }
  }
  
  
  
  private[lang] def validateSuperclass(cls : Class[_]) : scala.Boolean = {
    if(this.getClass.equals(cls)) {
      return true
    } else if(this.getClass.getInterfaces.contains(classOf[Thing]) && !cls.equals(classOf[Thing])) {
      return false
    } else if(this.getClass.equals(classOf[Thing])) {
      return false;
    } else {
      return validateSuperclass(cls, this.getClass.getSuperclass)
    }
  }
  
  private[lang] def validateInterfaces(itf : Class[_], toSeek : Class[_]) : scala.Boolean = {
     if(toSeek.equals(classOf[Thing]) && !toSeek.getInterfaces.contains(itf)) {
      return false
    } else if(toSeek.getInterfaces.contains(itf)) {
      return true
    } else {
      return validateInterfaces(itf, toSeek.getSuperclass)
    }
  }
  
  def validateInterfaces(itf : Class[_]) : scala.Boolean = {
    if(this.getClass.getInterfaces.contains(itf)) {
      return true
    } else if(this.getClass.getInterfaces.contains(classOf[Thing])) {
      return false
    } else {
      return validateInterfaces(itf, this.getClass.getSuperclass)
    }
  }
  
  @naturalistic.lang.annotations.Verb(name = "string", signature = "string of itself", returnType = "naturalistic.lang.String", container = "Concept")
  def string_of_itself : naturalistic.lang.String = naturalistic.lang.String.instance(this.getClass.getName + "@" + this.hashCode);
  override final def toString : java.lang.String = string_of_itself.getContained;
  
}