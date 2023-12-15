package naturalistic.sql

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Vector;

/**
@author Oscar Pulido Prieto.
*/

@naturalistic.lang.annotations.Adjective(name = "DBEntity")
trait DBEntity extends naturalistic.lang.Adjective {
  

  private var join : java.lang.String = this.getClass.getSuperclass.getSimpleName;
  private var orderBy : java.lang.String = null;
  
  @naturalistic.lang.annotations.Verb(name = "joins", preposition = "with", signature = "itself joins with naturalistic.lang.Strings", returnType = "naturalistic.lang.Thing", container = "DBEntity")
  def itself_joins_with_arg(arg0 : naturalistic.lang.Strings) : naturalistic.lang.Adjective = {
    
    join = this.getClass.getSuperclass.getSimpleName
    for(i <- 0.to(arg0.size_of_itself.__intValue-1)) {
       join += " JOIN " + arg0.get_arg_from_itself(naturalistic.lang.Number.instance(i));
    }
    

    return this;
  }
  
  @naturalistic.lang.annotations.Verb(name = "order", preposition = "by", signature = "itself order by naturalistic.lang.Strings", returnType = "naturalistic.lang.Thing", container = "DBEntity")
  def itself_order_by_arg(arg0 : naturalistic.lang.Strings) : naturalistic.lang.Adjective = {
    
    if(arg0.___plural_size == 0) {
      return this
    }
    
    orderBy = " ORDER BY "
    for(i <- 0.to(arg0.size_of_itself.__intValue-1)) {
       orderBy += arg0.get_arg_from_itself(naturalistic.lang.Number.instance(i)) + ", ";
    }
    
    if(orderBy.endsWith(", ")) {
	    orderBy = orderBy.substring(0, orderBy.length-2)
	  }
    
    return this;
  }
  
  @naturalistic.lang.annotations.Verb(name = "select", preposition = "from", signature = "select naturalistic.lang.Strings from itself", returnType = "naturalistic.lang.Things", container = "DBEntity")
  def select_arg_from_itself(arg0 : naturalistic.lang.Strings) : naturalistic.lang.Things = {
    
    var bool = !join.equals(this.getClass.getSuperclass.getSimpleName);
    
    var query = "SELECT " + seekAttributes(arg0, bool) + " FROM ";
    
    
    query += join;
    
    join = this.getClass.getSuperclass.getSimpleName;
    
    val where = this.assignValues(arg0, " and ", bool);
    if(where.length() > 0) {
      query += " WHERE " + where + ";";
    }
    
   
    if(orderBy == null) {
    } else {
      query += orderBy;
      orderBy = null;
    }
    
    java.lang.System.out.println(query);
    
    this.itself_connects;
    val rows = this.executeQuery(query, arg0);
    this.itself_disconnects;
    
    return rows;
  }
  
  @naturalistic.lang.annotations.Verb(name = "delete", preposition = "from", signature = "delete naturalistic.lang.Strings from itself", returnType = "naturalistic.lang.Integer", container = "DBEntity")
	def delete_arg_from_itself(arg0 : naturalistic.lang.Strings) : naturalistic.lang.Number with naturalistic.lang.Integer = {
	  return delete(arg0, this.getClass.getSuperclass)
  }
  
  private def delete(arg0 : naturalistic.lang.Strings, cls : java.lang.Class[_]) : naturalistic.lang.Number with naturalistic.lang.Integer = {
    if(cls == null || cls.equals(classOf[naturalistic.lang.Thing]) || cls.equals(classOf[naturalistic.lang.Adjective]) || cls.equals(classOf[naturalistic.sql.DBPersistent]) || cls.equals(classOf[naturalistic.sql.DBEntity])) {
	    return naturalistic.lang.Number.instance(0);
	  }
    
    var query : java.lang.String = "DELETE FROM " + cls.getSimpleName;
    val where = this.buildAssignValues(arg0, " and ", cls, false);
    if(where.length() > 0) {
      query += " WHERE " + where + ";";    }
    java.lang.System.out.println(query);
    
    this.itself_connects;
    val result = this.executeCommand(query);
    this.itself_disconnects;
    
    result.add_arg_to_itself(this.delete(arg0, cls.getSuperclass))
    for(itf <- cls.getInterfaces) {
      result.add_arg_to_itself(this.delete(arg0, itf))
    }
    
    return result;
  }
	
	@naturalistic.lang.annotations.Verb(name = "update", preposition = "from", signature = "update naturalistic.lang.Strings from itself", returnType = "naturalistic.lang.Integer", container = "DBEntity")
	def update_arg_from_itself(arg0 : naturalistic.lang.Strings) : naturalistic.lang.Number with naturalistic.lang.Integer = {
    return this.update(arg0, this.getClass.getSuperclass)
  }
	
	private def update(arg0 : naturalistic.lang.Strings, cls : java.lang.Class[_]) : naturalistic.lang.Number with naturalistic.lang.Integer = {
    if(cls == null || cls.equals(classOf[naturalistic.lang.Thing]) || cls.equals(classOf[naturalistic.lang.Adjective]) || cls.equals(classOf[naturalistic.sql.DBPersistent]) || cls.equals(classOf[naturalistic.sql.DBEntity])) {
	    return naturalistic.lang.Number.instance(0);
	  }
    
    var query : java.lang.String = "UPDATE " + cls.getSimpleName;
    query += " SET " + this.buildAssignValues(arg0, ", ", cls, false);
    query += " WHERE " + this.assignUpdateValues(arg0, cls) + ";";
    java.lang.System.out.println(query);
    
    this.itself_connects;
    val result = this.executeCommand(query);
    this.itself_disconnects;
    
    result.add_arg_to_itself(this.update(arg0, cls.getSuperclass))
    for(itf <- cls.getInterfaces) {
      result.add_arg_to_itself(this.update(arg0, itf))
    }
    
    return result;
  }
	
	@naturalistic.lang.annotations.Verb(name = "insert", preposition = "into", signature = "insert naturalistic.lang.Strings into itself", returnType = "naturalistic.lang.Things", container = "DBEntity")
	def insert_arg_into_itself(arg0 : naturalistic.lang.Strings) : naturalistic.lang.Number with naturalistic.lang.Integer = {
	  

	  
	  return this.insert(arg0, this.getClass)
	}
	
	def insert(arg0 : naturalistic.lang.Strings, cls : java.lang.Class[_]) : naturalistic.lang.Number with naturalistic.lang.Integer = {
	  if(cls == null || cls.equals(classOf[naturalistic.lang.Thing]) || cls.equals(classOf[naturalistic.lang.Adjective]) || cls.equals(classOf[naturalistic.sql.DBPersistent]) || cls.equals(classOf[naturalistic.sql.DBEntity])) {
	    return naturalistic.lang.Number.instance(0);
	  }
	  
	  if(cls.getSimpleName.contains("anon$")) {
	    return this.insert(arg0, cls.getSuperclass)
	  }
	  
	  val str : java.lang.String = buildSeekAttributes(arg0, cls, false);
	  var query : java.lang.String = "INSERT INTO " + cls.getSimpleName;
	
	  
	  if(!str.isEmpty) {
      query += "(" + str + ")";
	  }
	  query += this.addInsertValues(arg0, cls);
    java.lang.System.out.println(query);
    
    this.itself_connects;
    val result = this.executeCommand(query);
    this.itself_disconnects;
    

    for(itf <- cls.getInterfaces) {
      result.add_arg_to_itself(this.insert(arg0, itf))
    }
    
    return result;
	}
	
	
	@naturalistic.lang.annotations.Verb(name = "string", signature = "string of itself", returnType = "String", container = "DBEntity")
	override def string_of_itself : naturalistic.lang.String = {
	  var string : naturalistic.lang.String = naturalistic.lang.String.instance("");
	  
	  string.add_arg_to_itself(naturalistic.lang.String.instance("|"));
	  
	  for(field <- this.getClass.getSuperclass.getDeclaredFields) {
	    field.setAccessible(true);
	    if(field.get(this) != null) {
  	    if(field.getType.isAssignableFrom(classOf[naturalistic.lang.Number]) && field.getType.isAssignableFrom(classOf[naturalistic.lang.Integer])) {
  	      string.add_arg_to_itself(naturalistic.lang.String.instance(field.get(this).toString()));
  	    } else if(field.getType.isAssignableFrom(classOf[naturalistic.lang.Number]) && field.getType.isAssignableFrom(classOf[naturalistic.lang.Real])) {
  	      string.add_arg_to_itself(naturalistic.lang.String.instance(field.get(this).toString()));
  	    } else {
  	      string.add_arg_to_itself(naturalistic.lang.String.instance(field.get(this).toString()));
  	    }
  	    string.add_arg_to_itself(naturalistic.lang.String.instance("|"));
	    }
	    field.setAccessible(false);
	    
	  }
	  return string;	  
	}
	
	
	private def addInsertValues(fieldNames : naturalistic.lang.Strings, cls : java.lang.Class[_]) : java.lang.String = {
	  if(fieldNames == null || fieldNames.size_of_itself.__intValue == 0) {
	    return "";
	  }
	  if(cls == null || cls.equals(classOf[naturalistic.lang.Thing]) || cls.equals(classOf[naturalistic.lang.Adjective]) || cls.equals(classOf[naturalistic.sql.DBPersistent]) || cls.equals(classOf[naturalistic.sql.DBEntity])) {
	    return "";
	  }
	  
	  var names = List[java.lang.String]();
	  for(name <- fieldNames.element_of_itself) {
	    names = names ::: List(name.toString());
	  }
	  
	  var values : java.lang.String = " VALUES(";
	  
    for(field <- cls.getDeclaredFields) {
	    field.setAccessible(true);
	    if(field.get(this) != null && !classOf[naturalistic.sql.DBEntity].isAssignableFrom(field.getType)) {
	      if(names.contains(field.getName)) {
    	    if(field.get(this).isInstanceOf[naturalistic.lang.Integer]) {
    	      values += field.get(this).toString() + ", ";
    	    } else if(field.get(this).isInstanceOf[naturalistic.lang.Real]) {
    	      values += field.get(this).toString() + ", ";
    	    } else  {
    	      values += "'" +  field.get(this).toString() + "'" + ", ";
    	    }
	      }
	    }
	    field.setAccessible(false);
	  }
	  if(values.endsWith(", ")) {
	    values = values.substring(0, values.length-2)
	  }
	  
	  values += ")";
	  
	  
	  return values;
	}
	
	
	private def assignValues(fieldNames : naturalistic.lang.Strings, bln : java.lang.String, joined : scala.Boolean) : java.lang.String = {
	  if(fieldNames == null || fieldNames.size_of_itself.__intValue == 0) {
	    return "";
	  }
	  if(joined) {
	    return buildAssignValues(fieldNames, bln, this.getClass, true)
	  } else {
	    return buildAssignValues(fieldNames, bln, this.getClass.getSuperclass, false)
	  }
	}
	
	private def buildAssignValues(fieldNames : naturalistic.lang.Strings, bln : java.lang.String, cls : java.lang.Class[_], joined : scala.Boolean) : java.lang.String = {
	
	  if(cls == null || cls.equals(classOf[naturalistic.lang.Thing]) || cls.equals(classOf[naturalistic.lang.Adjective]) || cls.equals(classOf[naturalistic.sql.DBPersistent]) || cls.equals(classOf[naturalistic.sql.DBEntity])) {
	    return "";
	  }
	  
	  var names = List[java.lang.String]();
	  for(name <- fieldNames.element_of_itself) {
	    names = names ::: List(name.toString());
	  }
	  
	  var where : java.lang.String = "";
	  
	  for(field <- cls.getDeclaredFields) {
	    field.setAccessible(true);
	    if(field.get(this) != null && !classOf[naturalistic.sql.DBEntity].isAssignableFrom(field.getType) && names.contains(field.getName) && classOf[naturalistic.sql.DBPersistent].isAssignableFrom(field.get(this).getClass)) {
  	    if(field.getType.isAssignableFrom(classOf[naturalistic.lang.Number]) && field.getType.isAssignableFrom(classOf[naturalistic.lang.Integer])) {
  	      where += field.getName + " = " + field.get(this).toString() + bln;
  	    } else if(field.getType.isAssignableFrom(classOf[naturalistic.lang.Number]) && field.getType.isAssignableFrom(classOf[naturalistic.lang.Real])) {
  	      where += field.getName + " = " + field.get(this).toString() + bln;
  	    } else {
  	      where += field.getName + " = '" + field.get(this).toString() + "'" + bln;
  	    }
	    }
	    field.setAccessible(false);
	  }
	  if(joined) {
  	  var auxC =  buildAssignValues(fieldNames, bln, cls.getSuperclass, joined : scala.Boolean)
  	  if(!auxC.isEmpty()) {
  	    where += auxC
  	  }
  	  
  	  for(itf <- cls.getInterfaces) {
  	    var auxI = buildAssignValues(fieldNames, bln, itf, joined : scala.Boolean)
  	    if(!auxI.isEmpty()) {
    	    where += auxI
    	  }
  	  }
	  }
	  
	  if(where.endsWith(bln)) {
	    where = where.substring(0, where.length-(bln.length))
	  }
	  
	  
	  return where;
	}
	
	private def assignUpdateValues(fieldNames : naturalistic.lang.Strings, cls : java.lang.Class[_]) : java.lang.String = {
	  if(fieldNames == null || fieldNames.size_of_itself.__intValue == 0) {
	    return "";
	  }
	  if(cls == null || cls.equals(classOf[naturalistic.lang.Thing]) || cls.equals(classOf[naturalistic.lang.Adjective]) || cls.equals(classOf[naturalistic.sql.DBPersistent]) || cls.equals(classOf[naturalistic.sql.DBEntity])) {
	    return "";
	  }
	  
	  var names = List[java.lang.String]();
	  for(name <- fieldNames.element_of_itself) {
	    names = names ::: List(name.toString());
	  }
	  
	  var set : java.lang.String = "";
	  
    for(field <- cls.getDeclaredFields) {
	    field.setAccessible(true);
	    /**if(classOf[naturalistic.sql.DBPersistent].isAssignableFrom(field.getType)) {*/
  	    if(field.get(this) != null && !classOf[naturalistic.sql.DBEntity].isAssignableFrom(field.getType) && !names.contains(field.getName) && classOf[naturalistic.sql.DBPersistent].isAssignableFrom(field.get(this).getClass)) {
    	    if(field.getType.isAssignableFrom(classOf[naturalistic.lang.Number]) && field.getType.isAssignableFrom(classOf[naturalistic.lang.Integer])) {
    	      set += field.getName + " = " + field.get(this).toString() + " and ";
    	    } else if(field.getType.isAssignableFrom(classOf[naturalistic.lang.Number]) && field.getType.isAssignableFrom(classOf[naturalistic.lang.Real])) {
    	      set += field.getName + " = " + field.get(this).toString() + " and ";
    	    } else  {
    	      set += field.getName + " = '" + field.get(this).toString() + "'" + " and ";
    	    }
  	    }
	    /**}*/
	    field.setAccessible(false);
	  }
    
	  if(set.endsWith( " and ")) {
	    set = set.substring(0, set.length-5)
	  }
	  
	  
	  return set;
	}
	
	
	private def seekAttributes(fieldNames : naturalistic.lang.Strings, joined : scala.Boolean) : java.lang.String = {
	  if(fieldNames == null || fieldNames.size_of_itself.__intValue == 0) {
	    return "*";
	  }
	  if(joined) {
	    return buildSeekAttributes(fieldNames, this.getClass, true)
	  } else {
	    return buildSeekAttributes(fieldNames, this.getClass.getSuperclass, false)
	  }
	}
	
	private def buildSeekAttributes(fieldNames : naturalistic.lang.Strings, cls : java.lang.Class[_], joined : scala.Boolean) : java.lang.String = {
	 
	  if(cls == null || cls.equals(classOf[naturalistic.lang.Thing]) || cls.equals(classOf[naturalistic.lang.Adjective]) || cls.equals(classOf[naturalistic.sql.DBPersistent]) || cls.equals(classOf[naturalistic.sql.DBEntity])) {
	    return "";
	  }
	  var names = List[java.lang.String]();
	  for(name <- fieldNames.element_of_itself) {
	    names = names ::: List(name.toString());
	  }
	  
	  var row = "";
	  for(field <- cls.getDeclaredFields) {
	    val attributeAnnotation = field.getAnnotation(classOf[naturalistic.lang.annotations.Attribute])
	    if(attributeAnnotation != null && attributeAnnotation.container.equals(cls.getSimpleName)) {
	      
	      if(names.contains(field.getName) && !classOf[naturalistic.sql.DBEntity].isAssignableFrom(field.getType)) {
  	      row += field.getName + ", ";
  	    } else if(names.contains(field.getName) && classOf[naturalistic.sql.DBEntity].isAssignableFrom(field.getType)) {
  	      throw new RuntimeException("Illegal type for " + field.getName);
  	    }
	    }
	  }
	  
	  if(joined) {
  	  var auxC =  buildSeekAttributes(fieldNames, cls.getSuperclass, joined)
  	  if(!auxC.isEmpty()) {
  	    row += auxC
  	  }
  	  
  	  for(itf <- cls.getInterfaces) {
  	    var auxI = buildSeekAttributes(fieldNames, itf, joined)
  	    if(!auxI.isEmpty()) {
    	    row += auxI
    	  }
  	  }
	  }
	  
	  if(row.endsWith(", ")) {
	    row = row.substring(0, row.length-2)
	  }
	  return row;
	}
	
	private val serialVersionUID : scala.Long = 1L;
	private var oConexion : java.sql.Connection = null;  
	
  @naturalistic.lang.annotations.Attribute(name = "URL", container = "DBEntity")
  var URL : naturalistic.lang.String = _;
  @naturalistic.lang.annotations.Verb(name = "URL", signature = "URL of itself", returnType = " : naturalistic.lang.String", container = "DBEntity")
  def URL_of_itself : naturalistic.lang.String = URL;
  
  @naturalistic.lang.annotations.Attribute(name = "user", container = "DBEntity")
  var user : naturalistic.lang.String = _;
  @naturalistic.lang.annotations.Verb(name = "user", signature = "user of itself", returnType = " : naturalistic.lang.String", container = "DBEntity")
  def user_of_itself : naturalistic.lang.String = user;
  
  @naturalistic.lang.annotations.Attribute(name = "password", container = "DBEntity")
  var password : naturalistic.lang.String = _;
  @naturalistic.lang.annotations.Verb(name = "password", signature = "password of itself", returnType = " : naturalistic.lang.String", container = "DBEntity")
  def password_of_itself : naturalistic.lang.String = password;
  
  @naturalistic.lang.annotations.Attribute(name = "driver", container = "DBEntity")
  var driver : naturalistic.lang.String = _;
  @naturalistic.lang.annotations.Verb(name = "driver", signature = "driver of itself", returnType = " : naturalistic.lang.String", container = "DBEntity")
  def driver_of_itself : naturalistic.lang.String = driver;
  
  @naturalistic.lang.annotations.Attribute(name = "jar", container = "DBEntity")
	var jar : naturalistic.lang.String = _;
	@naturalistic.lang.annotations.Verb(name = "jar", signature = "jar of itself", returnType = " : naturalistic.lang.String", container = "DBEntity")
	def jar_of_itself : naturalistic.lang.String = jar;
	
	
	@naturalistic.lang.annotations.Verb(name = "connects", signature = "itself conects", returnType = "naturalistic.sql.DBEntity", container = "DBEntity")
  def itself_connects : naturalistic.sql.DBEntity = {
    
    try {
      
   
      val file : Array[java.net.URL] = new Array[java.net.URL](1);
      file(0) = new java.io.File(this.jar.toString).toURI.toURL;
      
      
      
      val child : java.net.URLClassLoader = new java.net.URLClassLoader(file, this.getClass.getClassLoader());
      
      try {
        
        val classToLoad : java.lang.Class[_] = child.loadClass(driver.toString());
        java.sql.DriverManager.registerDriver(new NaturalisticDriver(classToLoad.newInstance.asInstanceOf[java.sql.Driver]))
        oConexion = java.sql.DriverManager.getConnection(URL.toString(), user.toString(), password.toString());
        
			} catch {
			  case ex : java.sql.SQLException => {throw ex}
			  case ex : Exception => {throw ex}
	
			}
	    
    } catch {
      case ex : java.sql.SQLException => {throw ex}
    }
    return this;
  }
	

	@naturalistic.lang.annotations.Verb(name = "disconnects", signature = "itself disconects", returnType = "naturalistic.sql.DBEntity", container = "DBEntity")
  def itself_disconnects : naturalistic.sql.DBEntity = {
	  oConexion.close();
	  return this;
  }
	
  override def finalize(){
	  oConexion.close();
	  oConexion = null;
  }
  
  private def executeQuery(psQuery : java.lang.String, arg0 : naturalistic.lang.Strings) : naturalistic.lang.Things = {
    
    var rows : naturalistic.lang.Things = null;
    
    var stmt : Statement = null;
	  var rset : ResultSet = null;
	  var rsmd : ResultSetMetaData = null;
	  var nNumCols : scala.Int = 0;
	  try {
	    stmt = oConexion.createStatement();
	    rset = stmt.executeQuery(psQuery);
	    rsmd = rset.getMetaData();
	    nNumCols = rsmd.getColumnCount();
	    rows = this.turnToThings(rset, rsmd, nNumCols, arg0)
    } finally {
      if(rset != null){
        rset.close();
        stmt.close();
      }
      rset = null;
      stmt = null;
    }
    
    return rows;
  }
	
  private def executeCommand(psStatement : java.lang.String) : naturalistic.lang.Number with naturalistic.lang.Integer = {
	  var ret : scala.Int = 0;
	  val vTransaction : Vector[Object] = new Vector();
	  vTransaction.addElement(psStatement);
	  return executeCommand(vTransaction);
  }
  
  private def executeCommand(pvStatement : Vector[_]) : naturalistic.lang.Number with naturalistic.lang.Integer = {
    var ret : Int = 0
    var i : Int = 0;
    var stmt : Statement = null;
    var temp : java.lang.String = "";
    try {
      oConexion.setAutoCommit(false);
      stmt = oConexion.createStatement();
      i = 0;
      while(i < pvStatement.size()) {
        temp = pvStatement.elementAt(i).asInstanceOf[java.lang.String];
        ret += stmt.executeUpdate(temp);
        i = i + 1;
      }
      oConexion.commit();
    } catch {
      case ex : SQLException => {
        oConexion.rollback();
        throw ex;
      }
    } finally {
      stmt.close();
      stmt = null;
    }
    return naturalistic.lang.Number.instance(ret);
  }
	
	
  private def turnToThings(rset : ResultSet, rsmd : ResultSetMetaData, nNumCols : scala.Int, arg0 : naturalistic.lang.Strings) : naturalistic.lang.Things = {
	  val rows = naturalistic.lang.Things.instance(Array(classOf[naturalistic.sql.DBEntity]));
	  var thing : naturalistic.sql.DBEntity = null;
	  
	  var i : scala.Int = 0;
	  
	  while(rset.next()) {
	    var fieldNames : scala.List[_] = arg0.element_of_itself
	    thing = this.getClass.newInstance().asInstanceOf[naturalistic.sql.DBEntity];
	    i = 1;
	    var aux : naturalistic.lang.Thing = null;
	    while(i <= nNumCols) {
	      rsmd.getColumnType(i) match {
  	      case Types.CHAR  => {
  	        aux = new naturalistic.lang.String with DBPersistent
  	        aux.asInstanceOf[naturalistic.lang.String].setContained(rset.getString(i))
  	      }
  	      case Types.VARCHAR => {
  	        aux = new naturalistic.lang.String with DBPersistent
  	        aux.asInstanceOf[naturalistic.lang.String].setContained(rset.getString(i))
  	      }
  	      case Types.INTEGER => {
  	        aux = new naturalistic.lang.Number with naturalistic.lang.Integer with DBPersistent
  	        aux.asInstanceOf[naturalistic.lang.Integer].setValue(rset.getLong(i))
  	      }
  	      case Types.SMALLINT => {
  	        aux = new naturalistic.lang.Number with naturalistic.lang.Integer with DBPersistent
  	        aux.asInstanceOf[naturalistic.lang.Integer].setValue(rset.getInt(i))
  	      }
  	      case Types.NUMERIC => {
  	        aux = new naturalistic.lang.Number with naturalistic.lang.Real with DBPersistent
  	        aux.asInstanceOf[naturalistic.lang.Real].setValue(rset.getDouble(i))
  	      }
  	      case Types.DECIMAL => {
  	        aux = new naturalistic.lang.Number with naturalistic.lang.Real with DBPersistent
  	        aux.asInstanceOf[naturalistic.lang.Real].setValue(rset.getDouble(i))
  	      }
  	      case Types.DOUBLE => {
  	        aux = new naturalistic.lang.Number with naturalistic.lang.Real with DBPersistent
  	        aux.asInstanceOf[naturalistic.lang.Real].setValue(rset.getDouble(i))
  	      }
  	      case Types.DATE => {
  	        if(rset.getTimestamp(i)==null) {
  	        } else {
  	          aux = new naturalistic.lang.String with DBPersistent
  	          aux.asInstanceOf[naturalistic.lang.String].setContained(rset.getTimestamp(i).getTime().toString())
  	        }
  	      }
  	      case Types.TIME => {
  	        if(rset.getTimestamp(i)==null) {
  	        } else {
  	          aux = new naturalistic.lang.String with DBPersistent
  	          aux.asInstanceOf[naturalistic.lang.String].setContained(rset.getTimestamp(i).getTime().toString())
  	        }
  	      }
  	      case Types.TIMESTAMP => {
  	        if(rset.getTimestamp(i)==null) {
  	        } else {
  	          aux = new naturalistic.lang.String with DBPersistent
  	          aux.asInstanceOf[naturalistic.lang.String].setContained(rset.getTimestamp(i).getTime().toString())
  	        }
  	      }
  	      case _ => {
  	        aux = naturalistic.lang.String.instance(rset.getString(i));
  	      }
        } 
	      i = i + 1;
	      
	      
	      val field : java.lang.reflect.Field = this.getClass.getSuperclass.getDeclaredField(fieldNames.head.toString());
	      field.setAccessible(true)
	      field.set(thing, aux);
	      field.setAccessible(false)
	      fieldNames = fieldNames.tail;
      } 
	    rows.add_arg_to_itself(thing);
    } 
	  return rows;
  }
	
	private def doubleQuote(psCadena0 : java.lang.String) : java.lang.String = {
	  var psCadena : java.lang.String = "";
	  if(psCadena0 != null) {
	    psCadena = psCadena0;
    }
	  var cadenaEntrada : java.lang.String = "";
	  if(psCadena.equals("")) {
	    return psCadena;
    } else if(psCadena.equals("\"")){
      return "&quot;";
    } else {
      var indice : scala.Int = -2;
      cadenaEntrada = psCadena;
      while(!(indice = cadenaEntrada.indexOf("\"", indice+2)).equals(-1)) {
        cadenaEntrada = cadenaEntrada.substring(0, cadenaEntrada.indexOf("\"",indice))+"&quot;" + cadenaEntrada.substring(cadenaEntrada.indexOf("\"",indice)+1);
      }
    }
	  return cadenaEntrada;
	}
	private class NaturalisticDriver(driver : java.sql.Driver) extends java.sql.Driver {
	  @throws[SQLException]
	  def acceptsURL(url : java.lang.String) : scala.Boolean = {
	    return this.driver.acceptsURL(url);
    }
	  @throws[SQLException]
    def connect(url : java.lang.String, properties : java.util.Properties) : java.sql.Connection = {
    	return this.driver.connect(url, properties);
    }
    def getMajorVersion() : scala.Int = {
    	return this.driver.getMajorVersion();
    }
    def getMinorVersion() : scala.Int = {
    	return this.driver.getMinorVersion();
    }
    @throws[SQLException]
    def getPropertyInfo(url : java.lang.String, properties : java.util.Properties) : scala.Array[java.sql.DriverPropertyInfo] = {// throws SQLException {
    	return this.driver.getPropertyInfo(url, properties);
    }
    def jdbcCompliant() : scala.Boolean = {
    	return this.driver.jdbcCompliant();
    }
    @throws[java.sql.SQLFeatureNotSupportedException]
    def getParentLogger() : java.util.logging.Logger = {
      return this.driver.getParentLogger();
    }
  }
}