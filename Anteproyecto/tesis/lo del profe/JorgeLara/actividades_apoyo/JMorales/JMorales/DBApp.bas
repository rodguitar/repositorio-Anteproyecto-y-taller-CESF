Type=StaticCode
Version=3.82
B4A=true
@EndOfDesignText@
'Code module
'Subs in this code module will be accessible from all modules.
Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Dim DBApp As SQL
End Sub

Sub InicializaDB
       Dim sSql As String
       Try
               DBApp.Initialize(File.DirInternal,"dbApp2.db",True)
               
               'DBApp.ExecNonQuery("drop table Usuarios")
               ' Creando la tabla de Usuarios
               sSql = "CREATE TABLE IF NOT EXISTS USUARIOS "
               sSql = sSql & "(id_usuario INTEGER PRIMARY KEY AUTOINCREMENT, "
               sSql = sSql & "nombre TEXT not null, "
               sSql = sSql & "rut TEXT not null, "
			   sSql = sSql & "direccion TEXT)"
               DBApp.ExecNonQuery(sSql)
               Log("tabla creada exitosamente")
       Catch
               Log("catch al crear tabla " & LastException)
       End Try
End Sub

Public Sub countUsuarios As Int
	Dim total As Int
	Try
		total = DBApp.ExecQuerySingleResult("select count(*) from Usuarios")
		Return total
	Catch
		Log("catch" & LastException)
		Return 0
	End Try
End Sub

Public Sub insertaUsuario(vNombre As String, vrut As String,vDireccion As String)
	Try
		If vNombre <> "" Then
			DBApp.ExecNonQuery("insert into usuarios(nombre,rut,direccion) values('" & vNombre & "','" & vrut & "','" & vDireccion & "')")
			ToastMessageShow("Insertado correctamente",True)
		Else
			ToastMessageShow("NO Insertado SIN NOMBRE",True)
		End If
	Catch
		ToastMessageShow("NO Insertado",True)
		Log("catch" & LastException)
	End Try
End Sub


Public Sub buscaUnUsuario1 As String 'select a todos los registros y saca solo primero
	Dim curs As Cursor
	Dim nombre As String
	Try
		curs = DBApp.ExecQuery("SELECT id_usuario, nombre, direccion from usuarios ORDER BY id_usuario ASC")

		'For i = 0 To curs.RowCount - 1
		'	curs.Position = i
		If curs.RowCount > 0 Then
			curs.Position = 0 'aqui le dice que saca solo el de la posicion 0
			nombre = curs.GetString("nombre")
		End If
		'Next
		Log("nombre del usuario en la posicion 0: " & nombre)
		curs.Close
		Return nombre
	Catch
		Log("catch" & LastException)
		If curs.IsInitialized Then curs.Close
		Return "catch"
	End Try
End Sub	

Public Sub buscaUnUsuario2(vId As Int) As String 'busca un usuario por su id
	Dim nombre As String
	Try
		nombre = DBApp.ExecQuerySingleResult("SELECT id_usuario, nombre, direccion from usuarios where id_usuario = " & vId &" ORDER BY id_usuario ASC")
		If nombre <> Null Then
			Return nombre
		Else
			Return "nulo"
		End If
	Catch
		Log("catch " & LastException)
		Return "catch"
	End Try
End Sub	

Public Sub buscaTodosUsuarios(iLimite As Int) As List 'iLimite sirve para limitar la cantidad de registros que quiera retornar, se puede eliminar si los quiere todos
      Dim cur1 As Cursor
	  Dim Table As List
      Try
	      cur1 = DBApp.ExecQuery("select * from usuarios") 
	      Table.Initialize
	      If iLimite > 0 Then iLimite = Min(iLimite, cur1.RowCount) Else iLimite = cur1.RowCount
	      For row = 0 To iLimite - 1
	            cur1.Position = row
	            Dim values(cur1.ColumnCount) As String
	            For col = 0 To cur1.ColumnCount - 1
	                  values(col) = cur1.GetString2(col)
	            Next
	            Table.Add(values)
	      Next
	      cur1.Close
	      Return Table
      Catch
		Log("catch " & LastException)
		If cur1.IsInitialized Then cur1.Close
		Return Table
	End Try
End Sub

Public Sub insertaVariosUsuarios(vLista As List) 'esta forma se supone que es mas adecuada cuando la insercion de datos es mucha ya que esto lo hace en segundo plano
	Dim sentencia As String
	Try
		For r=0 To vLista.Size - 1
			sentencia = vLista.Get(r)
			DBApp.AddNonQueryToBatch(sentencia.Trim,Null)
		Next
		DBApp.ExecNonQueryBatch("sql") 'lanza un evento al terminar en linea 117
	Catch
		Log("catch " & LastException)
	End Try
End Sub

Sub SQL_NonQueryComplete(Success As Boolean)
	Log(Success)
	If Success = False Then 
		Log(LastException)
		ToastMessageShow("SQL NO procesado!",True)		
	Else
		ToastMessageShow("SQL procesado!",True)
	End If
End Sub
	