
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object Page1 extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(Seq[Any](/*3.2*/Main("Page1")/*3.15*/ {_display_(Seq[Any](format.raw/*3.17*/("""
   <div class="container">
     <p>"""),_display_(Seq[Any](/*5.10*/message)),format.raw/*5.17*/("""</p> 
   </div>
""")))})),format.raw/*7.2*/("""
"""))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Oct 14 20:53:39 HST 2013
                    SOURCE: /home/eva/digits/app/views/Page1.scala.html
                    HASH: d218ebd54ba6c68397387cf6701b012b6482d282
                    MATRIX: 774->1|885->18|922->21|943->34|982->36|1054->73|1082->80|1129->97
                    LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5|35->7
                    -- GENERATED --
                */
            