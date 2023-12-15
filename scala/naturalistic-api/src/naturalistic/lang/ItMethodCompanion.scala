package naturalistic.lang

/**
@author Oscar Pulido Prieto.
*/

class ItMethodCompanion {
		

	    private var it : Concept = _
	    

	    private var these : Things = null
	    

	    private var varList : scala.List[Concept] = List[Concept]()
	    
	    def setVarList(varList : scala.List[Concept]) {
	      this.varList = varList;
	    }
	    
	
	    

	    private def contains(element : Concept) : scala.Boolean = {
	      if(varList.size == 0) {
	        return false;
	      } else {
	        for(elem <- varList) {
	          if(elem.hashCode == element.hashCode) {
	            return true;
	          }
	        }
	        return false;
	      }
	    }

	    private var singularInstanceAux : Concept = null
	    private var pluralInstanceAux : Things = null
	    
	    def addInstanceAux(element : Concept) = {
	      if(element.isInstanceOf[Things]) {
	        pluralInstanceAux = element.asInstanceOf[Things]
	      } else {
	        singularInstanceAux = element
	      }
	    }
	    def setReferenceAux {
	      if(singularInstanceAux == null && pluralInstanceAux != null) {
	        addElem(pluralInstanceAux)
	      } else if(singularInstanceAux != null && pluralInstanceAux == null) {
	        addElem(singularInstanceAux)
	      }
	      singularInstanceAux = null;
        pluralInstanceAux = null;
	    }
	    def getSingularReferenceAux = singularInstanceAux;
	    def getPluralReferenceAux = pluralInstanceAux;
	    
	    

	    def addElem(element : Concept) = {
	
	      if(!varList.contains(element)) {
	        varList = varList ::: List(element)
	        }
	      if(element.isInstanceOf[Things/*[T]*/]) {
	        these = element.asInstanceOf[Things/*[T]*/]
	        singularInstanceAux = null;
	        pluralInstanceAux = null;
	      } else {
	        it = element
	        singularInstanceAux = null;
	        pluralInstanceAux = null;
	      }
	    }
	    
	    def getIt = it.asInstanceOf[naturalistic.lang.Thing]
	    def getThese = these.asInstanceOf[naturalistic.lang.Things]
	    
	    def getAll(reverse : scala.Boolean) : Things = {
	      val things : Things = new Things {}
	      if(reverse) {
	        things.setContained(varList.reverse)
	      } else {
	        things.setContained(varList)
	      }
	      things;
	    }
	    
	    private def decomposeName(name : java.lang.String) : java.lang.String = {
	      var ret = ""
	      for(c <- name) {
	        ret = ret + (c match {
	          case '|' => "$bar"
	          case '!' => "$bang"
	          case '%' => "$percent"
	          case '&' => "$amp"
	          case '/' => "$div"
	          case '?' => "$qmark"
	          case '<' => "$less"
	          case '>' => "$greater"
	          case '=' => "$eq"
	          case '*' => "$times"
	          case '-' => "$minus"
	          case '+' => "$plus"
	          case _ => c.toString
	        })
	      }
	 
	      ret
	    }
	    
	    def invokeVar(invoker : Concept, varName : java.lang.String, arguments : Concept*) : java.lang.reflect.Method = {
	      
	      var toInvoke : java.lang.reflect.Method = null
	      var assignable = true
	      
	      var name = varName;
	      
	      for(method <- invoker.getClass.getMethods) {
	        if(method.getName.equals(name)) {
	          var paramTypes = method.getParameterTypes
	          if(arguments == null && paramTypes == null) {
	            toInvoke = method
	          } else if(arguments != null && paramTypes != null && (arguments.length == paramTypes.length)) {
	            for(i <- 0 to arguments.length-1) {
	              if(!paramTypes(i).isAssignableFrom(arguments(i).getClass)) {
	                assignable = false
	              }
	            }
	            if(assignable) {
	              toInvoke = method
	            }
	          }
	        }
	      }
	      
	      if(toInvoke != null) {
	        return toInvoke
	      } else {
	        return null
	      }
	    }
	    
	    def invokeMethod(invoker : Concept, methodName : java.lang.String, arguments : Object*) : java.lang.reflect.Method = {
	      var listAux = List[Concept]()
	      if(arguments != null || arguments.size > 0) {
	        if(arguments.size == 1 && arguments(0) == NullAux) {
	          return callMethod(invoker, methodName, listAux.toArray);
	        } else if(arguments.size > 1 && arguments(0) == NullAux) {
	          return null;
	        }
  	      for(obj <- arguments) {
    	      if(obj == null) {
    	        listAux = listAux ::: List(null)
    	      } else if(obj.isInstanceOf[Concept]) {
    	        listAux = listAux ::: List(obj.asInstanceOf[Concept])
    	      } else {
    	        return null;
    	      }
  	      }
  	      if(arguments != null && listAux.size != arguments.size) {
  	        return null;
  	      } else {
  	        return callMethod(invoker, methodName, listAux.toArray);
  	      }
	      } else {
	        return callMethod(invoker, methodName, listAux.toArray);
	      }
	    }
	    private def callMethod(invoker : Concept, methodName : java.lang.String, arguments : scala.Array[Concept]) : java.lang.reflect.Method = { 
	      if(invoker.isInstanceOf[Things]) {
	        var pi : java.lang.reflect.Method = null; 
	        var aux : java.lang.reflect.Method = null;
	        for(m <- invoker.getClass.getMethods) {
	          if(m.getName.equals(methodName) && m.getParameterCount == arguments.length) {
	            aux = m
	          } else if(m.getName.equals("pluralInvoker") && m.getParameterCount == arguments.length) {
	            pi = m;
	            invoker.asInstanceOf[Things].singularMethod = methodName;
	          }
	        }
	        if(aux == null) {
	          return pi; 
	        }
	      }
	      var assignable = true
	      var methodList = List[java.lang.reflect.Method]();
	      var name = decomposeName(methodName)
	      for(method <- invoker.getClass.getMethods) {
	        assignable = true;
	        if(method.getName.equals(name)) {
	          var paramTypes = method.getParameterTypes
	          if(arguments == null && paramTypes == null) {
	            return method;
	          } else if(arguments != null && paramTypes != null && (arguments.length == paramTypes.length)) {
	            for(i <- 0 to arguments.length-1) {
	              if(arguments(i) != null && !paramTypes(i).isAssignableFrom(arguments(i).getClass)) {
	                assignable = false
	              }
	            }
	            if(assignable) {
	              methodList = methodList ::: List(method)
	            }
	          }
	        }
	      }
	      if(methodList.size == 1) {
	        return methodList.head;
	      } else {
	        return null;
	      }
	      
	      
	    }
	    
	    

	    def getManyThings(cls : java.lang.Class[_ <: Concept], adjectives : scala.Array[java.lang.Class[_]], pos : Int, reverse : scala.Boolean) : Concept = {
	      var list = List[Concept => scala.Boolean]();
	      if(cls != null) {
	        list = list ::: List[Concept => scala.Boolean](_.validateSuperclass(cls))
	      }
	      if(adjectives != null && adjectives.length > 0) {
	        for(adj <- adjectives) {
	          list = list ::: List[Concept => scala.Boolean](_.validateInterfaces(adj))
	        }
	      }
	      getListMany(list, pos, reverse)
	    }
	    

	    def getManyThings(cls : java.lang.Class[_ <: Concept], adjectives : scala.Array[java.lang.Class[_]], filters: scala.List[_ <: Concept => scala.Boolean], pos : Int, reverse : scala.Boolean) : Concept = {
	      var list = List[Concept => scala.Boolean]();
	      if(cls != null) {
	        list = list ::: List[Concept => scala.Boolean](_.validateSuperclass(cls))
	      }
	      if(adjectives != null && adjectives.length > 0) {
	        for(adj <- adjectives) {
	          list = list ::: List[Concept => scala.Boolean](_.validateInterfaces(adj))
	        }
	      }
	      list = list ::: filters
	      getListMany(list, pos, reverse)
	    }
	    
	    private def getListMany(filters: scala.List[_ <: Concept => scala.Boolean], pos : Int, reverse : scala.Boolean) : Things = {
	      var these : Things = null
	      for(f <- filters) {
	    	  if(these == null) {
	    	    these = new Things{}
	    	    these.setContained(varList.filter(f))
	    	  } else {
	    	    these.setContained(these.getContained.filter(f))
	    	  }
	      }
	      
	      if(pos > these.___plural_size)
	        throw new RuntimeException("Concept list out of bounds.")
	      

	      if(pos > 0) {
	        if(reverse) {
	          these.setContained(these.getContained.takeRight(pos))
	        } else {
	          these.setContained(these.getContained.take(pos))
	        }
	      }
	      these
	    }
	    

	    def getOneThing(cls : java.lang.Class[_ <: Concept], adjectives : scala.Array[java.lang.Class[_]], pos : Int) : Concept = {
	      var list = List[Concept => scala.Boolean]()
	      if(cls != null && !cls.isInterface) {
	        list = list ::: List[Concept => scala.Boolean](_.validateSuperclass(cls))
	      } else if(cls.isInterface) {
	        list = list ::: List[Concept => scala.Boolean](_.validateInterfaces(cls))
	      }
	      if(adjectives != null && adjectives.length > 0) {
	        for(adj <- adjectives) {
	          list = list ::: List[Concept => scala.Boolean](_.validateInterfaces(adj))
	        }
	      }
	      getListOne(list, pos)
	    }
	    

	    def getOneThing(cls : java.lang.Class[_ <: Concept], adjectives : scala.Array[java.lang.Class[_]], filters: scala.List[Concept => scala.Boolean], pos : Int) : Concept = {
	      var list = List[Concept => scala.Boolean]()
	      if(cls != null && !cls.isInterface) {
	        list = list ::: List[Concept => scala.Boolean](_.validateSuperclass(cls))
	      } else if(cls.isInterface) {
	        list = list ::: List[Concept => scala.Boolean](_.validateInterfaces(cls))
	      }
	      if(adjectives != null && adjectives.length > 0) {
	        for(adj <- adjectives) {
	          list = list ::: List[Concept => scala.Boolean](_.validateInterfaces(adj))
	        }
	      }
	      list = list ::: filters
	      getListOne(list, pos)
	    }
	    

	    private def getListOne(filters: scala.List[Concept => scala.Boolean], pos : Int) : Concept = {
	      var aux : scala.List[Concept] = null
	      for(f <- filters) {
	    	  if(aux == null) {
	    	    aux = varList.filter(f)
	    	  } else {
	    	    aux = aux.filter(f)
	    	  }
	      }
	      if(pos > aux.size) {
	        throw new RuntimeException("Thing list out of bounds.")
	      }
	      
	      var i = 0
	      if(pos < 0) {
	        aux = aux.reverse
	        i = (pos * -1)-1
	      } else {
	        i = pos-1
	      }
        if(i == 0) {
          aux.head;
        } else {
	        for(ii <- 0 to i-1) {
            aux = aux.tail;
	        }
	        aux.head;
        }
	    }
	    

}


