package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class dbapp {
private static dbapp mostCurrent = new dbapp();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.sql.SQL _dbapp = null;
public b4a.example.main _main = null;
public static anywheresoftware.b4a.objects.collections.List  _buscatodosusuarios(anywheresoftware.b4a.BA _ba,int _ilimite) throws Exception{
anywheresoftware.b4a.sql.SQL.CursorWrapper _cur1 = null;
anywheresoftware.b4a.objects.collections.List _table = null;
int _row = 0;
String[] _values = null;
int _col = 0;
 //BA.debugLineNum = 92;BA.debugLine="Public Sub buscaTodosUsuarios(iLimite As Int) As List 'iLimite sirve para limitar la cantidad de registros que quiera retornar, se puede eliminar si los quiere todos";
 //BA.debugLineNum = 93;BA.debugLine="Dim cur1 As Cursor";
_cur1 = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 94;BA.debugLine="Dim Table As List";
_table = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 95;BA.debugLine="Try";
try { //BA.debugLineNum = 96;BA.debugLine="cur1 = DBApp.ExecQuery(\"select * from usuarios\")";
_cur1.setObject((android.database.Cursor)(_dbapp.ExecQuery("select * from usuarios")));
 //BA.debugLineNum = 97;BA.debugLine="Table.Initialize";
_table.Initialize();
 //BA.debugLineNum = 98;BA.debugLine="If iLimite > 0 Then iLimite = Min(iLimite, cur1.RowCount) Else iLimite = cur1.RowCount";
if (_ilimite>0) { 
_ilimite = (int) (anywheresoftware.b4a.keywords.Common.Min(_ilimite,_cur1.getRowCount()));}
else {
_ilimite = _cur1.getRowCount();};
 //BA.debugLineNum = 99;BA.debugLine="For row = 0 To iLimite - 1";
{
final int step80 = 1;
final int limit80 = (int) (_ilimite-1);
for (_row = (int) (0); (step80 > 0 && _row <= limit80) || (step80 < 0 && _row >= limit80); _row = ((int)(0 + _row + step80))) {
 //BA.debugLineNum = 100;BA.debugLine="cur1.Position = row";
_cur1.setPosition(_row);
 //BA.debugLineNum = 101;BA.debugLine="Dim values(cur1.ColumnCount) As String";
_values = new String[_cur1.getColumnCount()];
java.util.Arrays.fill(_values,"");
 //BA.debugLineNum = 102;BA.debugLine="For col = 0 To cur1.ColumnCount - 1";
{
final int step83 = 1;
final int limit83 = (int) (_cur1.getColumnCount()-1);
for (_col = (int) (0); (step83 > 0 && _col <= limit83) || (step83 < 0 && _col >= limit83); _col = ((int)(0 + _col + step83))) {
 //BA.debugLineNum = 103;BA.debugLine="values(col) = cur1.GetString2(col)";
_values[_col] = _cur1.GetString2(_col);
 }
};
 //BA.debugLineNum = 105;BA.debugLine="Table.Add(values)";
_table.Add((Object)(_values));
 }
};
 //BA.debugLineNum = 107;BA.debugLine="cur1.Close";
_cur1.Close();
 //BA.debugLineNum = 108;BA.debugLine="Return Table";
if (true) return _table;
 } 
       catch (Exception e91) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e91); //BA.debugLineNum = 110;BA.debugLine="Log(\"catch \" & LastException)";
anywheresoftware.b4a.keywords.Common.Log("catch "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)));
 //BA.debugLineNum = 111;BA.debugLine="If cur1.IsInitialized Then cur1.Close";
if (_cur1.IsInitialized()) { 
_cur1.Close();};
 //BA.debugLineNum = 112;BA.debugLine="Return Table";
if (true) return _table;
 };
 //BA.debugLineNum = 114;BA.debugLine="End Sub";
return null;
}
public static String  _buscaunusuario1(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.sql.SQL.CursorWrapper _curs = null;
String _nombre = "";
 //BA.debugLineNum = 54;BA.debugLine="Public Sub buscaUnUsuario1 As String 'select a todos los registros y saca solo primero";
 //BA.debugLineNum = 55;BA.debugLine="Dim curs As Cursor";
_curs = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 56;BA.debugLine="Dim nombre As String";
_nombre = "";
 //BA.debugLineNum = 57;BA.debugLine="Try";
try { //BA.debugLineNum = 58;BA.debugLine="curs = DBApp.ExecQuery(\"SELECT id_usuario, nombre, direccion from usuarios ORDER BY id_usuario ASC\")";
_curs.setObject((android.database.Cursor)(_dbapp.ExecQuery("SELECT id_usuario, nombre, direccion from usuarios ORDER BY id_usuario ASC")));
 //BA.debugLineNum = 62;BA.debugLine="If curs.RowCount > 0 Then";
if (_curs.getRowCount()>0) { 
 //BA.debugLineNum = 63;BA.debugLine="curs.Position = 0 'aqui le dice que saca solo el de la posicion 0";
_curs.setPosition((int) (0));
 //BA.debugLineNum = 64;BA.debugLine="nombre = curs.GetString(\"nombre\")";
_nombre = _curs.GetString("nombre");
 };
 //BA.debugLineNum = 67;BA.debugLine="Log(\"nombre del usuario en la posicion 0: \" & nombre)";
anywheresoftware.b4a.keywords.Common.Log("nombre del usuario en la posicion 0: "+_nombre);
 //BA.debugLineNum = 68;BA.debugLine="curs.Close";
_curs.Close();
 //BA.debugLineNum = 69;BA.debugLine="Return nombre";
if (true) return _nombre;
 } 
       catch (Exception e54) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e54); //BA.debugLineNum = 71;BA.debugLine="Log(\"catch\" & LastException)";
anywheresoftware.b4a.keywords.Common.Log("catch"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)));
 //BA.debugLineNum = 72;BA.debugLine="If curs.IsInitialized Then curs.Close";
if (_curs.IsInitialized()) { 
_curs.Close();};
 //BA.debugLineNum = 73;BA.debugLine="Return \"catch\"";
if (true) return "catch";
 };
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return "";
}
public static String  _buscaunusuario2(anywheresoftware.b4a.BA _ba,int _vid) throws Exception{
String _nombre = "";
 //BA.debugLineNum = 77;BA.debugLine="Public Sub buscaUnUsuario2(vId As Int) As String 'busca un usuario por su id";
 //BA.debugLineNum = 78;BA.debugLine="Dim nombre As String";
_nombre = "";
 //BA.debugLineNum = 79;BA.debugLine="Try";
try { //BA.debugLineNum = 80;BA.debugLine="nombre = DBApp.ExecQuerySingleResult(\"SELECT id_usuario, nombre, direccion from usuarios where id_usuario = \" & vId &\" ORDER BY id_usuario ASC\")";
_nombre = _dbapp.ExecQuerySingleResult("SELECT id_usuario, nombre, direccion from usuarios where id_usuario = "+BA.NumberToString(_vid)+" ORDER BY id_usuario ASC");
 //BA.debugLineNum = 81;BA.debugLine="If nombre <> Null Then";
if (_nombre!= null) { 
 //BA.debugLineNum = 82;BA.debugLine="Return nombre";
if (true) return _nombre;
 }else {
 //BA.debugLineNum = 84;BA.debugLine="Return \"nulo\"";
if (true) return "nulo";
 };
 } 
       catch (Exception e69) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e69); //BA.debugLineNum = 87;BA.debugLine="Log(\"catch \" & LastException)";
anywheresoftware.b4a.keywords.Common.Log("catch "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)));
 //BA.debugLineNum = 88;BA.debugLine="Return \"catch\"";
if (true) return "catch";
 };
 //BA.debugLineNum = 90;BA.debugLine="End Sub";
return "";
}
public static int  _countusuarios(anywheresoftware.b4a.BA _ba) throws Exception{
int _total = 0;
 //BA.debugLineNum = 28;BA.debugLine="Public Sub countUsuarios As Int";
 //BA.debugLineNum = 29;BA.debugLine="Dim total As Int";
_total = 0;
 //BA.debugLineNum = 30;BA.debugLine="Try";
try { //BA.debugLineNum = 31;BA.debugLine="total = DBApp.ExecQuerySingleResult(\"select count(*) from Usuarios\")";
_total = (int)(Double.parseDouble(_dbapp.ExecQuerySingleResult("select count(*) from Usuarios")));
 //BA.debugLineNum = 32;BA.debugLine="Return total";
if (true) return _total;
 } 
       catch (Exception e24) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e24); //BA.debugLineNum = 34;BA.debugLine="Log(\"catch\" & LastException)";
anywheresoftware.b4a.keywords.Common.Log("catch"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)));
 //BA.debugLineNum = 35;BA.debugLine="Return 0";
if (true) return (int) (0);
 };
 //BA.debugLineNum = 37;BA.debugLine="End Sub";
return 0;
}
public static String  _inicializadb(anywheresoftware.b4a.BA _ba) throws Exception{
String _ssql = "";
 //BA.debugLineNum = 9;BA.debugLine="Sub InicializaDB";
 //BA.debugLineNum = 10;BA.debugLine="Dim sSql As String";
_ssql = "";
 //BA.debugLineNum = 11;BA.debugLine="Try";
try { //BA.debugLineNum = 12;BA.debugLine="DBApp.Initialize(File.DirInternal,\"dbApp2.db\",True)";
_dbapp.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"dbApp2.db",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 16;BA.debugLine="sSql = \"CREATE TABLE IF NOT EXISTS USUARIOS \"";
_ssql = "CREATE TABLE IF NOT EXISTS USUARIOS ";
 //BA.debugLineNum = 17;BA.debugLine="sSql = sSql & \"(id_usuario INTEGER PRIMARY KEY AUTOINCREMENT, \"";
_ssql = _ssql+"(id_usuario INTEGER PRIMARY KEY AUTOINCREMENT, ";
 //BA.debugLineNum = 18;BA.debugLine="sSql = sSql & \"nombre TEXT not null, \"";
_ssql = _ssql+"nombre TEXT not null, ";
 //BA.debugLineNum = 19;BA.debugLine="sSql = sSql & \"rut TEXT not null, \"";
_ssql = _ssql+"rut TEXT not null, ";
 //BA.debugLineNum = 20;BA.debugLine="sSql = sSql & \"direccion TEXT)\"";
_ssql = _ssql+"direccion TEXT)";
 //BA.debugLineNum = 21;BA.debugLine="DBApp.ExecNonQuery(sSql)";
_dbapp.ExecNonQuery(_ssql);
 //BA.debugLineNum = 22;BA.debugLine="Log(\"tabla creada exitosamente\")";
anywheresoftware.b4a.keywords.Common.Log("tabla creada exitosamente");
 } 
       catch (Exception e15) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e15); //BA.debugLineNum = 24;BA.debugLine="Log(\"catch al crear tabla \" & LastException)";
anywheresoftware.b4a.keywords.Common.Log("catch al crear tabla "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)));
 };
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return "";
}
public static String  _insertausuario(anywheresoftware.b4a.BA _ba,String _vnombre,String _vrut,String _vdireccion) throws Exception{
 //BA.debugLineNum = 39;BA.debugLine="Public Sub insertaUsuario(vNombre As String, vrut As String,vDireccion As String)";
 //BA.debugLineNum = 40;BA.debugLine="Try";
try { //BA.debugLineNum = 41;BA.debugLine="If vNombre <> \"\" Then";
if ((_vnombre).equals("") == false) { 
 //BA.debugLineNum = 42;BA.debugLine="DBApp.ExecNonQuery(\"insert into usuarios(nombre,rut,direccion) values('\" & vNombre & \"','\" & vrut & \"','\" & vDireccion & \"')\")";
_dbapp.ExecNonQuery("insert into usuarios(nombre,rut,direccion) values('"+_vnombre+"','"+_vrut+"','"+_vdireccion+"')");
 //BA.debugLineNum = 43;BA.debugLine="ToastMessageShow(\"Insertado correctamente\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Insertado correctamente",anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 45;BA.debugLine="ToastMessageShow(\"NO Insertado SIN NOMBRE\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("NO Insertado SIN NOMBRE",anywheresoftware.b4a.keywords.Common.True);
 };
 } 
       catch (Exception e37) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e37); //BA.debugLineNum = 48;BA.debugLine="ToastMessageShow(\"NO Insertado\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("NO Insertado",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 49;BA.debugLine="Log(\"catch\" & LastException)";
anywheresoftware.b4a.keywords.Common.Log("catch"+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)));
 };
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return "";
}
public static String  _insertavariosusuarios(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _vlista) throws Exception{
String _sentencia = "";
int _r = 0;
 //BA.debugLineNum = 116;BA.debugLine="Public Sub insertaVariosUsuarios(vLista As List) 'esta forma se supone que es mas adecuada cuando la insercion de datos es mucha ya que esto lo hace en segundo plano";
 //BA.debugLineNum = 117;BA.debugLine="Dim sentencia As String";
_sentencia = "";
 //BA.debugLineNum = 118;BA.debugLine="Try";
try { //BA.debugLineNum = 119;BA.debugLine="For r=0 To vLista.Size - 1";
{
final int step99 = 1;
final int limit99 = (int) (_vlista.getSize()-1);
for (_r = (int) (0); (step99 > 0 && _r <= limit99) || (step99 < 0 && _r >= limit99); _r = ((int)(0 + _r + step99))) {
 //BA.debugLineNum = 120;BA.debugLine="sentencia = vLista.Get(r)";
_sentencia = BA.ObjectToString(_vlista.Get(_r));
 //BA.debugLineNum = 121;BA.debugLine="DBApp.AddNonQueryToBatch(sentencia.Trim,Null)";
_dbapp.AddNonQueryToBatch(_sentencia.trim(),(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(anywheresoftware.b4a.keywords.Common.Null)));
 }
};
 //BA.debugLineNum = 123;BA.debugLine="DBApp.ExecNonQueryBatch(\"sql\") 'lanza un evento al terminar en linea 117";
_dbapp.ExecNonQueryBatch((_ba.processBA == null ? _ba : _ba.processBA),"sql");
 } 
       catch (Exception e105) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e105); //BA.debugLineNum = 125;BA.debugLine="Log(\"catch \" & LastException)";
anywheresoftware.b4a.keywords.Common.Log("catch "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)));
 };
 //BA.debugLineNum = 127;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Dim DBApp As SQL";
_dbapp = new anywheresoftware.b4a.sql.SQL();
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return "";
}
public static String  _sql_nonquerycomplete(anywheresoftware.b4a.BA _ba,boolean _success) throws Exception{
 //BA.debugLineNum = 129;BA.debugLine="Sub SQL_NonQueryComplete(Success As Boolean)";
 //BA.debugLineNum = 130;BA.debugLine="Log(Success)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(_success));
 //BA.debugLineNum = 131;BA.debugLine="If Success = False Then";
if (_success==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 132;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)));
 //BA.debugLineNum = 133;BA.debugLine="ToastMessageShow(\"SQL NO procesado!\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("SQL NO procesado!",anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 135;BA.debugLine="ToastMessageShow(\"SQL procesado!\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("SQL procesado!",anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 137;BA.debugLine="End Sub";
return "";
}
}
