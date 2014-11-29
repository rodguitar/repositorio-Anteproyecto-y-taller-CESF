package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_l1{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[l1/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 3;BA.debugLine="Label1.Text = \"Escribe tu nombre\""[l1/General script]
((TextViewWrapper)views.get("label1").vw).setText("Escribe tu nombre");
//BA.debugLineNum = 4;BA.debugLine="Label2.Text = \"Bienvenido\""[l1/General script]
((TextViewWrapper)views.get("label2").vw).setText("Bienvenido");

}
}