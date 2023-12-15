package naturalistic.lang

/**
@author Oscar Pulido Prieto.
*/

@naturalistic.lang.annotations.Noun(name = "Thing", plural = "Things")
class Thing extends Concept {
  
  private var pos = 0;
  
  def setPos(pos : Int) {
    this.pos = pos
  }
  def getPos = pos
}

abstract class Things extends Thing {
  
  def value_$eq(t : Things) {
    this.pluralAux = t.element_of_itself.asInstanceOf[List[_ <: Concept]];
  }
  
 
  
  var interfaces : Array[java.lang.Class[_]] = _;
  var parentClass : java.lang.Class[_ <: Concept] = _;
  
  protected var pluralAux : scala.List[_ <: Concept ] = List()
  
  

  def seekOneInstance(cls : java.lang.Class[_ <: Concept], adjectives : scala.Array[java.lang.Class[_]], pos : Int) : naturalistic.lang.Concept = {
    var it = new ItMethodCompanion
    it.setVarList(pluralAux)
    
    return it.getOneThing(cls, adjectives, pos)
    

  }
  

  def seekOneInstance(cls : java.lang.Class[_ <: Concept], adjectives : scala.Array[java.lang.Class[_]], filters: scala.List[Concept => scala.Boolean], pos : Int) : naturalistic.lang.Concept = {
    var it = new ItMethodCompanion
    it.setVarList(pluralAux)
    
    return it.getOneThing(cls, adjectives, filters, pos)
    

  }
  

  def seekManyInstances(cls : java.lang.Class[_ <: Concept], adjectives : scala.Array[java.lang.Class[_]], pos : Int, reverse : scala.Boolean) : Concept = {
    var it = new ItMethodCompanion
    it.setVarList(pluralAux)
    
    return it.getManyThings(cls, adjectives, pos, reverse)
    

  }
  

  def seekManyInstances(cls : java.lang.Class[_ <: Concept], adjectives : scala.Array[java.lang.Class[_]], filters: scala.List[_ <: Concept => scala.Boolean], pos : Int, reverse : scala.Boolean) : Concept = {
    var it = new ItMethodCompanion
    it.setVarList(pluralAux)
    
    return it.getManyThings(cls, adjectives, filters, pos, reverse)
    

  }
  
  @naturalistic.lang.annotations.Verb(name = "element", signature = "element of itself", returnType = "scala.List", container = "Things")
  def element_of_itself : scala.List[_] = pluralAux;
  
  private[lang] def getContained : scala.List[_ <: Concept] = pluralAux;
  private[lang] def setContained(things : scala.List[_ <: Concept]) {
    pluralAux = things;
  }
  
  
  protected var isEmpty = true
  
  final def ___plural_size = pluralAux.size
  
  def size_of_itself : naturalistic.lang.Number with naturalistic.lang.Integer = naturalistic.lang.Number.instance(pluralAux.size);
  
  
  private def seekInterfaces(cls : java.lang.Class[_]) : scala.Boolean = {
    
    if(interfaces.size == 0) {
      return true;
    }
    
    var bnd = false;
    var clsAux = cls;
    while(clsAux != classOf[naturalistic.lang.Thing]) {
      bnd = iterateInterfaces(clsAux.getInterfaces)
      
      if(bnd == true) {
      
        return true;
      } else {
        clsAux = clsAux.getSuperclass
      }
    }
    
    if(bnd == false) {
      throw new RuntimeException("Illegal type");
    }
    
    return bnd;
    
  }
  
  private def iterateInterfaces(itf : Array[java.lang.Class[_]]) : scala.Boolean = {
    
    if(itf == null) {
      return false
    }
    
    var bnd = false;
    
    for(interface <- itf) {
      if(!interfaces.contains(interface)) {
        if(iterateInterfaces(interface.getInterfaces) == true) {
          return true;
        }
      } else {
    
        return true;
      }
    }
    return bnd
    
  }
  
  
  
  
  @naturalistic.lang.annotations.Verb(name = "add", preposition = "to", signature = "add Thing to itself", returnType = "Things", container = "Things")
  def add_arg_to_itself(thing : Concept) : Things = {

    seekInterfaces(thing.getClass)
    pluralAux = pluralAux ::: List(thing)
    isEmpty = false
    this;
  }
  
  @naturalistic.lang.annotations.Verb(name = "add", preposition = "before", signature = "add Things before itself", returnType = "Things", container = "Things")
  def add_arg_before_itself(things : Things) : Things = {
    for(interface <- things.interfaces) {
      if(!this.interfaces.contains(interface)) {
        throw new RuntimeException("Illegal type");
      }
    }
    pluralAux = things.getContained ::: pluralAux
    isEmpty = false
    this;
  }
  
  @naturalistic.lang.annotations.Verb(name = "add", preposition = "after", signature = "add Things after itself", returnType = "Things", container = "Things")
  def add_arg_after_itself(things : Things) : Things= {
    for(interface <- things.interfaces) {
      if(!this.interfaces.contains(interface)) {
        throw new RuntimeException("Illegal type");
      }
    }
    pluralAux = pluralAux ::: things.getContained
    isEmpty = false
    this;
  }
  
  @naturalistic.lang.annotations.Verb(name = "contains", signature = "itself contains Thing", returnType = "Boolean", container = "Things")
  def itself_contains_arg(thing : Concept ) : naturalistic.lang.Boolean = {
   
    for(aux <- pluralAux) {
      if(aux.itself_equal_to_arg(thing).isTrue) {
        return naturalistic.lang.True;
      }
    }
 
    return naturalistic.lang.False;
  }
  
  private var selectedIndex : scala.Int = -1
  
  
 
  @naturalistic.lang.annotations.Verb(name = "select", preposition = "from", signature = "select Integer Number from itself", returnType = "Integer", container = "Things")
  def select_arg_from_itself(index : naturalistic.lang.Number with Integer) : Integer = {
    if(index.__intValue >= 0 && index.__intValue < pluralAux.size) {
      selectedIndex = index.__intValue
      naturalistic.lang.Number.instance(selectedIndex)
    } else {
      throw new RuntimeException("The index does not exists");
    }
  }
  
  @naturalistic.lang.annotations.Verb(name = "select", preposition = "from", signature = "select Integer Number from itself", returnType = "Integer", container = "Things")
  def select_arg_from_itself(ordinal : Ordinal) : Integer = {
    if(ordinal.__intValue == -1) {
      selectedIndex = this.___plural_size
    } else {
      selectedIndex = ordinal.__intValue
    }
    naturalistic.lang.Number.instance(selectedIndex)
  }
  
  
  @naturalistic.lang.annotations.Verb(name = "set", preposition = "into", signature = "set Thing into itself", returnType = "Boolean", container = "Things")
  def set_arg_into_itself(thing : naturalistic.lang.Number with Integer) : Boolean = {
    if(selectedIndex >= 0 && selectedIndex < pluralAux.size) {
      var auxL : scala.List[_ <: Concept] = scala.List()
      var auxR : scala.List[_ <: Concept] = scala.List()
      var aux = pluralAux
      for(i <- 0 to selectedIndex) {
        auxL = auxL ::: List(aux.head)
        auxR = aux.tail
        aux = aux.tail
        
      }
      if(selectedIndex < 0) {
        pluralAux = List(thing) ::: aux
      } else if(auxR.size > 0) {
        pluralAux = auxL ::: List(thing, auxR.head) ::: auxR.tail
      } else {
        pluralAux = auxL ::: List(thing) ::: auxR
      }
      
      selectedIndex = -1
      naturalistic.lang.Boolean.instance(true)
    } else {
      throw new RuntimeException("The index does not exists");
    }
    naturalistic.lang.Boolean.instance(false)
  }
  
  @naturalistic.lang.annotations.Verb(name = "replace", preposition = "into", signature = "replace Thing into itself", returnType = "Boolean", container = "Things")
  def replace_arg_into_itself(thing : naturalistic.lang.Number with Integer) : Boolean = {
    if(selectedIndex >= 0 && selectedIndex < pluralAux.size) {
      var auxL : scala.List[_ <: Concept] = scala.List()
      var auxR : scala.List[_ <: Concept] = scala.List()
      var aux = pluralAux
      for(i <- 0 to selectedIndex) {
        auxL = auxL ::: List(aux.head)
        auxR = aux.tail
        aux = aux.tail
      }
      if(selectedIndex < 0) {
        pluralAux = List(thing) ::: aux.tail
      } else if(auxR.size > 0) {
        pluralAux = auxL ::: List(thing) ::: auxR.tail
      } else {
        pluralAux = auxL ::: List(thing)
      }
      selectedIndex = -1
      naturalistic.lang.Boolean.instance(true)
    } else {
      throw new RuntimeException("The index does not exists");
    }
    naturalistic.lang.Boolean.instance(false)
  }
  
  @naturalistic.lang.annotations.Verb(name = "remove", preposition = "from", signature = "remove from itself", returnType = "Thing", container = "Things")
  def remove_from_itself : Concept = {
    if(selectedIndex >= 0 && selectedIndex < pluralAux.size) {
      var auxL = pluralAux
      var auxR : scala.List[_ <: Concept] = scala.List()
      for(i <- 0 to selectedIndex) {
        auxL = auxL ::: List(pluralAux.head)
        auxR = pluralAux.tail
        
      }
      pluralAux = auxL ::: auxR.tail
      selectedIndex = -1
      auxR.head
    } else {
      throw new RuntimeException("The index does not exists");
    }
  }
  
  @naturalistic.lang.annotations.Verb(name = "remove", preposition = "from", signature = "remove from itself", returnType = "Thing", container = "Things")
  def remove_arg_from_itself(ordinal : Ordinal) : Concept = {
    if(ordinal.__intValue == 0) {
      var aux = pluralAux.head
      pluralAux = pluralAux.tail
      aux
    } else if(ordinal.__intValue != -1) {
      var auxL = List[Concept]()
      var auxR : scala.List[_ <: Concept] = scala.List()
      for(i <- 0 to ordinal.__intValue -1) {
        auxL = auxL ::: List(pluralAux.head)
        auxR = pluralAux.tail
        
      }
      pluralAux = auxL ::: auxR.tail
      selectedIndex = -1
      auxR.head
    } else {
      pluralAux = pluralAux.reverse
      var aux = pluralAux.head
      pluralAux = pluralAux.tail.reverse
      aux
    }
  }
  
  
 
  @naturalistic.lang.annotations.Verb(name = "get", preposition = "from", signature = "get Thing from itself", returnType = "Thing", container = "Things")
  def get_arg_from_itself(index : naturalistic.lang.Number with Integer) : Concept = pluralAux(index.__intValue)
  
  @naturalistic.lang.annotations.Verb(name = "get", preposition = "from", signature = "get Thing from itself", returnType = "Thing", container = "Things")
  def get_arg_from_itself(ordinal : Ordinal) : Concept = {
    if(ordinal.__intValue != -1) {
      pluralAux(ordinal.__intValue)
    } else {
      pluralAux = pluralAux.reverse
      var aux = pluralAux.head
      pluralAux = pluralAux.reverse
      aux
    }
  }
  
  @naturalistic.lang.annotations.Verb(name = "last", signature = "last of itself", returnType = "Thing", container = "Things")
  def last_of_itself : Concept = pluralAux.reverse.head
  
  @naturalistic.lang.annotations.Verb(name = "first", signature = "first of itself", returnType = "Thing", container = "Things")
  def first_of_itself = pluralAux.head
  
  @naturalistic.lang.annotations.Verb(name = "head", signature = "head of itself", returnType = "Thing", container = "Things")
  def head_of_itself : naturalistic.lang.Concept = {
    return pluralAux.head
  }
  
  def tail_of_itself : naturalistic.lang.Things = {
    val t = new Things{};
    t.pluralAux = pluralAux.tail;
    return t;
  }
  
  @naturalistic.lang.annotations.Verb(name = "remove", preposition = "from", signature = "remove Thing from itself", returnType = "Thing", container = "Things")
  def remove_arg_from_itself(index : naturalistic.lang.Integer) : Concept = {

    var aux = pluralAux(index.__intValue)
    var auxList : scala.List[_ <: Concept/*T*/] = scala.List();
    var i = 0;
    for(elem <- pluralAux) {
      if(i != index.__intValue) {
        auxList = auxList ::: List(elem)
      } else {
      }
      i = i + 1;
    }
    pluralAux = auxList;
    return aux
  }
  
  
  
  @naturalistic.lang.annotations.Verb(name = "string", signature = "string of itself", returnType = "String", container = "Things")
  override def string_of_itself = {
    var cad = "[";
    if(pluralAux.size > 0) {
      for(thing <- pluralAux) {
        cad = cad + thing + ", "
      }
      cad = cad.substring(0,cad.length()-2) + "]";
    } else {
      cad = cad + "]";
    }
    naturalistic.lang.String.instance(cad);
  }
  
  
  
  @naturalistic.lang.annotations.Verb(name = "reverse", signature = "reverse of itself", returnType = "Things", container = "Things")
  def reverse_of_itself : Things = {
    val reverseThings = new Things {}
    reverseThings.setContained(this.pluralAux.reverse)
    reverseThings
  }
  
 
  private[lang] var singularMethod : java.lang.String = _;
  
  def setSingularMethod(singularMethod : java.lang.String) {
    this.singularMethod = singularMethod
  }
  
  def pluralInvoker() : naturalistic.lang.Thing = {
    val it = new naturalistic.lang.ItMethodCompanion;
    
    var aux : naturalistic.lang.Thing = null;
    
    if(this.containsMethod(singularMethod)) {
      aux = it.invokeMethod(this, singularMethod).invoke(this).asInstanceOf[naturalistic.lang.Thing]
      aux;
    } else {
      val pluralVar = naturalistic.lang.Things.instance(Array());
      
      for(element <- pluralAux) {
        
        
        pluralVar.add_arg_to_itself(it.invokeMethod(element, singularMethod).invoke(element).asInstanceOf[naturalistic.lang.Thing]);
        
       
      }
      aux = pluralVar.asInstanceOf[Thing];
      singularMethod = null
      aux;
    }
  }
  def pluralInvoker( arguments : naturalistic.lang.Concept*) : naturalistic.lang.Thing = {
  
    
    val it = new naturalistic.lang.ItMethodCompanion;
    
    var aux : naturalistic.lang.Thing = null;
    
    if(this.containsMethod(singularMethod)) {
      aux = it.invokeMethod(this, singularMethod, arguments.toArray).invoke(this, arguments.toArray).asInstanceOf[naturalistic.lang.Thing]
      aux;
    } else {
      val pluralVar = naturalistic.lang.Things.instance(Array());
      for(element <- pluralAux) {
        pluralVar.add_arg_to_itself(it.invokeMethod(element, singularMethod, arguments.toArray).invoke(element, arguments.toArray).asInstanceOf[naturalistic.lang.Thing]);
      }
      aux = pluralVar;
      singularMethod = null
      aux;
    }
    
   
  }
  
  def whereFilter(fieldNames : Array[java.lang.String], comparatorNames : Array[java.lang.String], arguments : Array[naturalistic.lang.Concept]) : naturalistic.lang.Things = {
    val it = new naturalistic.lang.ItMethodCompanion;
    
    var aux : naturalistic.lang.Things = naturalistic.lang.Things.instance(Array());
    
    var auxFieldNames = fieldNames
    var auxComparatorNames = comparatorNames
    var auxArguments = arguments
    
    for(i <- 0.to(auxFieldNames.size-1)) {
      
      var fieldName = auxFieldNames.head
      var comparatorName = auxComparatorNames.head
      var argument = auxArguments.head
    
      if(this.containsMethod(fieldName)) {
        val simpleAux = it.invokeMethod(this, fieldName, argument).invoke(this, argument).asInstanceOf[naturalistic.lang.Thing]
        aux.add_arg_to_itself(simpleAux);
      } else {
        for(element <- pluralAux) {
          val field = it.invokeMethod(element, fieldName).invoke(element).asInstanceOf[naturalistic.lang.Thing]
          if(it.invokeMethod(field, comparatorName, argument).invoke(field, argument).asInstanceOf[naturalistic.lang.Boolean].isTrue()) {
            aux.add_arg_to_itself(element);
          }
        }
      }
      singularMethod = null
      
      auxFieldNames = auxFieldNames.tail
      auxComparatorNames = auxComparatorNames.tail
      auxArguments = auxArguments.tail
      
    }
    aux;
  }
  
  private def findMethod(name : java.lang.String, cls : Class[_]) : java.lang.reflect.Method = {
     
      val aux = this.getClass.getMethods.filter(_.getName.equals(name));
      
      for(m <- aux) {
        if(m.getName == "instance") {
          if(m.getReturnType.equals(this.getClass) || m.getReturnType.equals(this.getClass.getSuperclass)) {
            return m;
          }
        }
      }
      return null;
      
      
  }
  
  private def containsMethod(name : java.lang.String) : scala.Boolean = {
    for(m <- this.getClass.getMethods) {
      if(m.getName.equals(name)) {
        true;
      }
    }
    false;
  }
  
}

//object Null extends naturalistic.lang.Thing{}

object Things {
  
  val singular : java.lang.Class[_ <: Concept] = classOf[naturalistic.lang.Thing];
  
  def instance(itfs : Array[java.lang.Class[_]]) = {
    val t = new Things{};
    t.parentClass = singular
    t.interfaces = itfs;
    t;
  }
}



object NullAux extends Concept {
  def instance = this;
}