package naturalistic.lang

/**
@author Oscar Pulido Prieto.
*/

@naturalistic.lang.annotations.Noun(name = "System")
abstract class System extends naturalistic.lang.Thing {
  @naturalistic.lang.annotations.Verb(name = "prints", signature = "itself prints naturalistic.lang.Thing", returnType = "naturalistic.lang.String", container = "System")
  def itself_prints_arg(thing : Thing) : naturalistic.lang.String
  @naturalistic.lang.annotations.Verb(name = "prints", signature = "itself prints naturalistic.lang.Thing and naturalistic.lang.Thing", returnType = "naturalistic.lang.String", container = "System")
  def itself_prints_arg_arg(thing : Thing, thing2 : Thing) : naturalistic.lang.String
  @naturalistic.lang.annotations.Verb(name = "reads", signature = "itself reads", returnType = "naturalistic.lang.String", container = "System")
  def itself_reads : naturalistic.lang.String
  @naturalistic.lang.annotations.Verb(name = "empties", signature = "itself empties Things", returnType = "naturalistic.lang.Things", container = "System")
  def itself_empties_arg(things : Things) : naturalistic.lang.Things
}

object System extends naturalistic.lang.System {
  
  @naturalistic.lang.annotations.Verb(name = "prints", signature = "itself prints naturalistic.lang.Thing", returnType = "naturalistic.lang.String", container = "System")
  def itself_prints_arg(thing : Thing) : naturalistic.lang.String = {
    print(thing.toString);
    thing.string_of_itself;
  }
  
  @naturalistic.lang.annotations.Verb(name = "prints", signature = "itself prints naturalistic.lang.Thing and naturalistic.lang.Thing", returnType = "naturalistic.lang.String", container = "System")
  def itself_prints_arg_arg(thing : Thing, thing2 : Thing) : naturalistic.lang.String = {
    val aux = naturalistic.lang.String.instance(thing.toString).concat_arg_with_itself(naturalistic.lang.String.instance(thing2.toString));
    print(aux.toString);
    if(thing2.equals(newline)) {
      thing.string_of_itself
    } else {
      aux;
    }
  }
  
  @naturalistic.lang.annotations.Verb(name = "reads", signature = "itself reads", returnType = "naturalistic.lang.String", container = "System")
  def itself_reads : naturalistic.lang.String = {
    var input : java.lang.String = null;
    var scanner : java.util.Scanner = null
    try {
      scanner = new java.util.Scanner(java.lang.System.in)
      input = scanner.nextLine()
    } catch {
      case e : java.io.IOException => {e.printStackTrace(); java.lang.System.exit(0);}
    } finally {
    }
    naturalistic.lang.String.instance(input);
  }
  
  @naturalistic.lang.annotations.Verb(name = "empties", signature = "itself empties Things", returnType = "naturalistic.lang.Things", container = "System")
  def itself_empties_arg(things : Things) : naturalistic.lang.Things = {
    things.setContained(List())
    things
  }
}

