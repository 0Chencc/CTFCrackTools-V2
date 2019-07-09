package org.mstsec.CTFCrackToolsV2

/* MSEC Team Www.Hi-OurLife.Com
 * Author:0chen,z13
 * Mail:mrsafea@gmail.com
 * FaceBook:0chencc
 */
import java.math.BigInteger
import java.awt.event.*
import java.util.*
import java.io.*
import java.awt.*
import javax.swing.*
import javax.swing.event.*
import javax.swing.filechooser.FileNameExtensionFilter
import javax.swing.plaf.FontUIResource
import org.python.core.*
import org.python.util.PythonInterpreter
import com.google.gson.*

class Core {
    internal var json=Json()
    //val json=Json()
    var input=JTextArea()
    var output=JTextArea()
    internal var f=Func()
    fun CryptoWindow() {//主窗口
        val language=Locale.getDefault()
        val rb=ResourceBundle.getBundle("info",language)
        val jFrame=JFrame(rb.getString("AppTitle")+v1)
        val frameContainer=jFrame.contentPane
        val springLayout=SpringLayout()
        frameContainer.layout=springLayout
        //
        val mainMenuBar=JMenuBar()
        val Ascii=JMenu(rb.getString("MenuCode"))
        val caesar=JMenuItem(rb.getString("MenuCodeCaesar"))
        val rot13=JMenuItem(rb.getString("MenuCodeRot13"))
        val fence=JMenuItem(rb.getString("MenuCodeFence"))
        val peig=JMenuItem(rb.getString("MenuCodeBaconab"))
        val peigd=JMenuItem(rb.getString("MenuCodeBaconDecode"))
        val zj=JMenuItem(rb.getString("MenuCodePig"))
        val base64j=JMenuItem(rb.getString("MenuCodeBase64utf8En"))
        val base64c=JMenuItem(rb.getString("MenuCodeBase64utf8De"))
        val morsee=JMenuItem(rb.getString("MenuCodeMorseEn"))
        val morsed=JMenuItem(rb.getString("MenuCodeMorseDe"))
        val reverse=JMenuItem(rb.getString("MenuCodeReverse"))
        val UrlCodee=JMenuItem(rb.getString("MenuCodeURLEn"))
        val UrlCoded=JMenuItem(rb.getString("MenuCodeURLDe"))
        val UnicoderStre=JMenuItem(rb.getString("MenuCodeUnicodeEn"))
        val UnicoderStrd=JMenuItem(rb.getString("MenuCodeUnicodeDe"))
        val asciiZUnicode=JMenuItem(rb.getString("MenuCodeAsciitoUnicode"))
        val UnicodeZascii=JMenuItem(rb.getString("MenuCodeUnicodetoAscii"))
        //
        val radixchange=JMenu(rb.getString("MenuRadix"))
        //JMenuItem radix = new JMenuItem(" 任意进制转换");
        val j2z8=JMenuItem(rb.getString("MenuRadix2to8"))
        val j2z10=JMenuItem(rb.getString("MenuRadix2to10"))
        val j2z16=JMenuItem(rb.getString("MenuRadix2to16"))
        val j8z2=JMenuItem(rb.getString("MenuRadix8to2"))
        val j8z10=JMenuItem(rb.getString("MenuRadix8to10"))
        val j8z16=JMenuItem(rb.getString("MenuRadix8to16"))
        val j10z2=JMenuItem(rb.getString("MenuRadix10to2"))
        val j10z8=JMenuItem(rb.getString("MenuRadix10to8"))
        val j10z16=JMenuItem(rb.getString("MenuRadix10to16"))
        val j16z2=JMenuItem(rb.getString("MenuRadix16to2"))
        val j16z8=JMenuItem(rb.getString("MenuRadix16to8"))
        val j16z10=JMenuItem(rb.getString("MenuRadix16to10"))
        //
        val Plugin=JMenu(rb.getString("MenuPlugins"))
        val addplugin=JMenuItem(rb.getString("MenuPluginsAdd"))
        val rsa=JMenuItem(rb.getString("MenuPluginRSA"))
        val rc4=JMenuItem(rb.getString("MenuPluginRC4"))
        val b32e=JMenuItem(rb.getString("MenuPluginBase32En"))
        val b32d=JMenuItem(rb.getString("MenuPluginBase32De"))
        val b16e=JMenuItem(rb.getString("MenuPluginBase16En"))
        val b16d=JMenuItem(rb.getString("MenuPluginBase16De"))
        val r162ascii=JMenuItem(rb.getString("MenuPlugin16toAscii"))
        val ascii216=JMenuItem(rb.getString("MenuPluginAsciito16"))
        //
        val girlgif=JMenu(rb.getString("MenuGirl"))
        val girlgifw=JMenuItem(rb.getString("MenuGirlShow"))
        val Help=JMenu(rb.getString("MenuHelp"))
        val aboutme=JMenuItem(rb.getString("MenuHelpAbout"))
        mainMenuBar.add(Ascii)
        Ascii.add(caesar)
        Ascii.add(rot13)
        Ascii.add(fence)
        Ascii.add(peig)
        Ascii.add(peigd)
        Ascii.add(zj)
        Ascii.add(base64j)
        Ascii.add(base64c)
        Ascii.add(morsee)
        Ascii.add(morsed)
        Ascii.add(reverse)
        Ascii.add(UrlCoded)
        Ascii.add(UrlCodee)
        Ascii.add(UnicoderStre)
        Ascii.add(UnicoderStrd)
        Ascii.add(asciiZUnicode)
        Ascii.add(UnicodeZascii)
        mainMenuBar.add(radixchange)
        //radixchange.add(radix);   //BUG功能....等有空修复
        radixchange.add(j2z8)
        radixchange.add(j2z10)
        radixchange.add(j2z16)
        radixchange.add(j8z2)
        radixchange.add(j8z10)
        radixchange.add(j8z16)
        radixchange.add(j10z2)
        radixchange.add(j10z8)
        radixchange.add(j10z16)
        radixchange.add(j16z2)
        radixchange.add(j16z8)
        radixchange.add(j16z10)
        mainMenuBar.add(Plugin)
        Plugin.add(addplugin)
        Plugin.add(rsa)
        Plugin.add(rc4)
        Plugin.add(b32e)
        Plugin.add(b32d)
        Plugin.add(b16e)
        Plugin.add(b16d)
        Plugin.add(r162ascii)
        Plugin.add(ascii216)
        try {
            buildPluginMenu(Plugin)
        } catch (e2: Exception) {
            // TODO 自动生成的 catch 块
            e2.printStackTrace()
        }
        //传入要添加菜单的目录
        mainMenuBar.add(girlgif)
        girlgif.add(girlgifw)
        mainMenuBar.add(Help)
        Help.add(aboutme)
        frameContainer.add(mainMenuBar)
        springLayout.putConstraint(SpringLayout.NORTH, mainMenuBar, 0, SpringLayout.NORTH, frameContainer)
        springLayout.putConstraint(SpringLayout.WEST, mainMenuBar, 0, SpringLayout.WEST, frameContainer)
        springLayout.putConstraint(SpringLayout.EAST, mainMenuBar, 0, SpringLayout.EAST, frameContainer)
        //
        val mainTabbedPane=JTabbedPane()
        //
        val crypto=JSplitPane(JSplitPane.VERTICAL_SPLIT)
        crypto.dividerLocation=250
        val crypto_top=JPanel()
        crypto_top.layout=springLayout
        val inputL=JLabel(rb.getString("AppInputLabel")+"0")
        crypto_top.add(inputL)
        springLayout.putConstraint(SpringLayout.NORTH, inputL, 0, SpringLayout.NORTH, crypto_top)
        val inputP=JScrollPane(input)
        crypto_top.add(inputP)
        springLayout.putConstraint(SpringLayout.NORTH, inputP, 25, SpringLayout.NORTH, crypto_top)
        springLayout.putConstraint(SpringLayout.SOUTH, inputP, 0, SpringLayout.SOUTH, crypto_top)
        springLayout.putConstraint(SpringLayout.WEST, inputP, 0, SpringLayout.WEST, crypto_top)
        springLayout.putConstraint(SpringLayout.EAST, inputP, 0, SpringLayout.EAST, crypto_top)
        crypto.topComponent=crypto_top
        //
        val crypto_bottom=JPanel()
        crypto_bottom.layout=springLayout
        val outpuL=JLabel(rb.getString("AppOutputLabel")+"0")
        crypto_bottom.add(outpuL)
        springLayout.putConstraint(SpringLayout.NORTH, outpuL, 0, SpringLayout.NORTH, crypto_bottom)
        val outputP=JScrollPane(output)
        crypto_bottom.add(outputP)
        output.text=rb.getString("AppRemarks")
        springLayout.putConstraint(SpringLayout.NORTH, outputP, 25, SpringLayout.NORTH, crypto_bottom)
        springLayout.putConstraint(SpringLayout.SOUTH, outputP, 0, SpringLayout.SOUTH, crypto_bottom)
        springLayout.putConstraint(SpringLayout.WEST, outputP, 0, SpringLayout.WEST, crypto_bottom)
        springLayout.putConstraint(SpringLayout.EAST, outputP, 0, SpringLayout.EAST, crypto_bottom)
        crypto.bottomComponent=crypto_bottom
        mainTabbedPane.addTab("Crypto", crypto)
        //
        frameContainer.add(mainTabbedPane)
        springLayout.putConstraint(SpringLayout.NORTH, mainTabbedPane, 25, SpringLayout.NORTH, frameContainer)
        springLayout.putConstraint(SpringLayout.SOUTH, mainTabbedPane, -30, SpringLayout.SOUTH, frameContainer)
        springLayout.putConstraint(SpringLayout.EAST, mainTabbedPane, 0, SpringLayout.EAST, frameContainer)
        springLayout.putConstraint(SpringLayout.WEST, mainTabbedPane, 0, SpringLayout.WEST, frameContainer)
        //
        val mainBottomBar=JPanel()
        val ad=JLabel(rb.getString("AppCopyright"))
        mainBottomBar.add(ad)
        frameContainer.add(mainBottomBar)
        springLayout.putConstraint(SpringLayout.SOUTH, mainBottomBar, 0, SpringLayout.SOUTH, frameContainer)
        //
        jFrame.defaultCloseOperation=3
        jFrame.setSize(1000, 800)
        jFrame.isVisible=true
        //
        input.document.addDocumentListener(object : DocumentListener {
            internal var inputlength: Int=0
            override fun changedUpdate(evt: DocumentEvent) {
                inputlength=input.text.replace("\r|\n".toRegex(), "").length
                inputL.text=rb.getString("AppInputLabel")+inputlength
            }

            override fun insertUpdate(e: DocumentEvent) {
                inputlength=input.text.replace("\r|\n".toRegex(), "").length
                inputL.text=rb.getString("AppInputLabel")+inputlength
            }

            override fun removeUpdate(e: DocumentEvent) {
                inputlength=input.text.replace("\r|\n".toRegex(), "").length
                inputL.text=rb.getString("AppInputLabel")+inputlength
            }
        })
        output.document.addDocumentListener(object : DocumentListener {
            internal var outputlength: Int=0
            override fun changedUpdate(evt: DocumentEvent) {
                outputlength=output.text.replace("\r|\n".toRegex(), "").length
                outpuL.text=rb.getString("AppOutputLabel")+outputlength
            }

            override fun insertUpdate(e: DocumentEvent) {
                outputlength=output.text.replace("\r|\n".toRegex(), "").length
                outpuL.text=rb.getString("AppOutputLabel")+outputlength
            }

            override fun removeUpdate(e: DocumentEvent) {
                outputlength=output.text.replace("\r|\n".toRegex(), "").length
                outpuL.text=rb.getString("AppOutputLabel")+outputlength
            }
        })
        //监听按钮
        caesar.addActionListener{ output.text=f.Caesar(input.text) }
        peig.addActionListener{ output.text=f.BaconCodeDecode(input.text) }
        zj.addActionListener{
            output.text=f.PigCode(input.text)
        }
        rot13.addActionListener{
            output.text=f.Rot13(input.text)
        }
        fence.addActionListener{
            output.text=f.Fence(input.text)
        }
        base64j.addActionListener{ output.text=f.Base64en(input.text) }
        base64c.addActionListener{ output.text=f.Base64de(input.text) }
        morsee.addActionListener{ output.text=f.MorseEncode(input.text) }
        morsed.addActionListener{
            output.text=f.MorseDecode(input.text)
        }
        reverse.addActionListener{
            output.text=f.reverse(input.text)
        }
        UrlCodee.addActionListener{
            output.text=f.UrlEncoder(input.text)
        }
        UrlCoded.addActionListener{
            output.text=f.URLDecoder(input.text)
        }
        UnicoderStre.addActionListener { output.text=f.UnicodeEncode(input.text) }
        UnicoderStrd.addActionListener { output.text=f.UnicodeDecode(input.text) }
        j2z8.addActionListener {
            try {
                output.text=java.math.BigInteger(input.text, 2).toString(8)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        j2z10.addActionListener {
            try {
                output.text=java.math.BigInteger(input.text, 2).toString(10)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        j2z16.addActionListener {
            try {
                output.text=java.math.BigInteger(input.text, 2).toString(16)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        j8z2.addActionListener {
            try {
                output.text=java.math.BigInteger(input.text, 8).toString(2)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        j8z10.addActionListener {
            try {
                output.text=java.math.BigInteger(input.text, 8).toString(10)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        j8z16.addActionListener {
            try {
                output.text=java.math.BigInteger(input.text, 8).toString(16)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        j10z2.addActionListener {
            try {
                output.text=java.math.BigInteger(input.text, 10).toString(2)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        j10z8.addActionListener {
            try {
                output.text=java.math.BigInteger(input.text, 10).toString(8)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        j10z16.addActionListener {
            try {
                output.text=java.math.BigInteger(input.text, 10).toString(16)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        j16z2.addActionListener {
            try {
                output.text=java.math.BigInteger(input.text, 16).toString(2)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        j16z8.addActionListener {
            try {
                output.text=java.math.BigInteger(input.text, 16).toString(8)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        j16z10.addActionListener {
            try {
                output.text=java.math.BigInteger(input.text, 16).toString(10)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        UnicodeZascii.addActionListener { output.text=f.UnicodeToAscii(input.text) }
        asciiZUnicode.addActionListener { output.text=f.AsciiToUnicode(input.text) }
        rsa.addActionListener { Core().rsatools() }
        rc4.addActionListener { Core().rc4tools() }
        b32e.addActionListener { output.text=f.Base32en(input.text) }
        b32d.addActionListener { output.text=f.Base32de(input.text) }
        //		b16e.addActionListener(new ActionListener(){
        //			@Override
        //			public void actionPerformed(ActionEvent evt){
        //				output.setText(f.Base16en(input.getText()));
        //			}
        //		});
        //		b16d.addActionListener(new ActionListener(){
        //			@Override
        //			public void actionPerformed(ActionEvent evt){
        //				output.setText(f.Base16c(input.getText()));
        //			}
        //		});
        peigd.addActionListener { output.text=f.PigCode(input.text) }
        r162ascii.addActionListener { output.text=f.HextoString(input.text) }
        ascii216.addActionListener { output.text=f.StringtoHex(input.text) }
        girlgifw.addActionListener { Core().girl() }
        /*		radix.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			//debug
			System.out.println(input.getText());
			new CTFcrack().radix(input.getText());
			}
	});	*/
        aboutme.addActionListener { aboutMe() }
        //
        val py_suf=arrayOf("py")
        val py_filter: FileNameExtensionFilter
        val py_openfile=JFileChooser()
        py_openfile.fileSelectionMode=JFileChooser.FILES_ONLY
        py_filter=FileNameExtensionFilter("Python(.py)", *py_suf)
        py_openfile.fileFilter=py_filter
        addplugin.addActionListener {
            val py_openframe=py_openfile.showDialog(JLabel(), "选择/Choose")
            if(py_openframe==JFileChooser.APPROVE_OPTION) {
                val py_file=py_openfile.selectedFile//得到选择的文件名
                try {
                    val title=json.createJSON(py_file.toString())
                    when (json.getType(title)) {
                        "crypto" -> Plugin.add(buildPluginMenuItem(" $title"))
                    }
                } catch (e1: IOException) {
                    e1.printStackTrace()
                } catch (e1: Exception) {
                    // TODO 自动生成的 catch 块
                    e1.printStackTrace()
                }

            }
        }
        //
    }

    fun radix(input: String) {
        val Radixgui=JFrame("任意进制转换")
        Radixgui.defaultCloseOperation=WindowConstants.DISPOSE_ON_CLOSE
        Radixgui.layout=null
        Radixgui.setBounds(0, 0, 200, 200)
        val waitradix=JTextArea()
        waitradix.setBounds(10, 10, 150, 20)
        val waitTips=JLabel("初始进制")
        waitTips.setBounds(10, 30, 150, 20)
        val resradix=JTextArea()
        resradix.setBounds(10, 50, 150, 20)
        val resTips=JLabel("待转换的进制")
        resTips.setBounds(10, 70, 150, 20)
        val change=JButton("Change")
        change.setBounds(10, 90, 150, 20)
        Radixgui.add(waitradix)
        Radixgui.add(waitTips)
        Radixgui.add(resradix)
        Radixgui.add(resTips)
        Radixgui.add(change)
        Radixgui.isVisible=true
        Radixgui.isResizable=false
        change.addActionListener {
            try {
                //int waitradixint = Integer.parseInt(waitradix.getText());
                //int resradixint = Integer.parseInt(waitradix.getText());
                //output.setText(new java.math.BigInteger(input,2).toString(10)); //debug
            } catch (e: Exception) {
                //debug
                e.printStackTrace()
            }

            println(output.text)
        }
    }

    private fun rsatools() {//rsatools窗口
        val Rsatools=JFrame("RsaTools--PythonPlugin")
        val rsap=JTextArea()
        val rsaq=JTextArea()
        val rsae=JTextArea()
        val rsad=JTextArea()
        val Rlabelp=JLabel("p:")
        val Rlabelq=JLabel("q:")
        val Rlabele=JLabel("e:")
        val Rlabeld=JLabel("d:")
        val rsady=JButton("Calc.D")
        val container=Rsatools.contentPane
        container.layout=null
        Rsatools.isVisible=true
        Rsatools.isResizable=false
        Rsatools.setSize(300, 200)//窗口
        Rsatools.defaultCloseOperation=WindowConstants.DISPOSE_ON_CLOSE
        rsap.setBounds(30, 10, 200, 20)
        rsaq.setBounds(30, 40, 200, 20)
        rsae.setBounds(30, 70, 200, 20)
        rsad.setBounds(30, 100, 200, 20)
        container.add(rsap)
        container.add(rsaq)
        container.add(rsae)
        container.add(rsad)
        Rlabelp.setBounds(5, 10, 30, 20)
        Rlabelq.setBounds(5, 40, 30, 20)
        Rlabele.setBounds(5, 70, 30, 20)
        Rlabeld.setBounds(5, 100, 30, 20)
        container.add(Rlabelp)
        container.add(Rlabelq)
        container.add(Rlabele)
        container.add(Rlabeld)
        rsady.setBounds(80, 130, 100, 20)
        container.add(rsady)
        rsady.addActionListener{
            val interpreter=PythonInterpreter()
            interpreter.execfile(System.getProperty("user.dir")+"\\Plugin\\OS\\rsa.py")
            val rsapstr=BigInteger(rsap.text)
            val rsaqstr=BigInteger(rsaq.text)
            val rsaestr=BigInteger(rsae.text)
            val func=interpreter.get("rsa", PyFunction::class.java) as PyFunction
            val rsadstr=func.__call__(PyLong(rsapstr), PyLong(rsaqstr), PyLong(rsaestr))
            rsad.text=rsadstr.toString()
        }
    }

    private fun rc4tools() {//rsatools窗口
        val Rc4tools=JFrame("rc4--PythonPlugin")
        val datat=JTextArea()
        val keyt=JTextArea()
        val rest=JTextArea()
        val Rdata=JLabel("data")
        val Rkey=JLabel("key")
        val Rres=JLabel("Res")
        val RC4crack=JButton("Crack!")
        val container=Rc4tools.contentPane
        container.layout=null
        Rc4tools.isVisible=true
        Rc4tools.isResizable=false
        Rc4tools.setSize(300, 170)//窗口
        Rc4tools.defaultCloseOperation=WindowConstants.DISPOSE_ON_CLOSE
        datat.setBounds(50, 10, 200, 20)
        keyt.setBounds(50, 40, 200, 20)
        rest.setBounds(50, 70, 200, 20)
        container.add(datat)
        container.add(keyt)
        container.add(rest)
        Rdata.setBounds(5, 10, 50, 20)
        Rkey.setBounds(5, 40, 50, 20)
        Rres.setBounds(5, 70, 50, 20)
        container.add(Rdata)
        container.add(Rkey)
        container.add(Rres)
        RC4crack.setBounds(80, 100, 100, 20)
        container.add(RC4crack)
        RC4crack.addActionListener{
            val interpreter=PythonInterpreter()
            interpreter.execfile(System.getProperty("user.dir")+"\\Plugin\\OS\\RC4.py")
            val data=datat.text
            val key=keyt.text
            val func=interpreter.get("main", PyFunction::class.java) as PyFunction
            val rsadstr=func.__call__(PyString(data), PyString(key))
            rest.text=rsadstr.toString()
        }
    }

    private fun girl() {//Girl
        val language=Locale.getDefault()
        val rb=ResourceBundle.getBundle("info", language)
        val frame=JFrame(rb.getString("MenuGirlTitle"))
        frame.defaultCloseOperation=WindowConstants.DISPOSE_ON_CLOSE
        val imgadd=File(System.getProperty("user.dir")+"\\girl\\girl1.gif")
        val imageIcon=ImageIcon(imgadd.toString())
        val label=JLabel("", imageIcon, SwingConstants.CENTER)
        frame.add(label)
        frame.pack()
        frame.isVisible=true
    }

    private fun aboutMe() {
        val language=Locale.getDefault()
        val rb=ResourceBundle.getBundle("info", language)
        val jframe=JFrame("Help")
        val frame=jframe.contentPane
        jframe.defaultCloseOperation=WindowConstants.DISPOSE_ON_CLOSE
        val sp=SpringLayout()
        val help=JTextArea()
        help.text=rb.getString("MenuHelpAboutText")
        frame.layout=sp
        frame.add(help)
        sp.putConstraint(SpringLayout.NORTH, help, 0, SpringLayout.NORTH, frame)
        sp.putConstraint(SpringLayout.SOUTH, help, 0, SpringLayout.SOUTH, frame)
        sp.putConstraint(SpringLayout.EAST, help, 0, SpringLayout.EAST, frame)
        sp.putConstraint(SpringLayout.WEST, help, 0, SpringLayout.WEST, frame)
        jframe.setSize(940, 500)
        jframe.isVisible=true
    }

    //菜单
    @Throws(Exception::class)
    private fun buildPluginMenu(menu: JMenu) {
        //
        if(File(JsonPath).isFile() && File(JsonPath).exists() && json.isJSON()) {
            val jsonfile=FileInputStream(JsonPath)
            val jsonreadcoding=InputStreamReader(jsonfile, "UTF-8")
            val parser=JsonParser()
            val `object`=parser.parse(BufferedReader(jsonreadcoding)) as JsonObject
            val Plugins=`object`.getAsJsonArray("Plugins")
            for (jsonElement in Plugins) {
                val Plugin=jsonElement.asJsonObject
                if(Plugin.get("type").asString.equals("crypto", ignoreCase=true)) {
                    menu.add(buildPluginMenuItem(" "+Plugin.get("title").asString))
                }
            }
        }
    }
//
//    @Throws(Exception::class)
//    private fun buildZipPluginSelectItem(Item: JComboBox<*>) {
//        //
//        if(File(JsonPath).isFile() && File(JsonPath).exists() && json.isJSON()) {
//            val jsonfile=FileInputStream(JsonPath)
//            val jsonreadcoding=InputStreamReader(jsonfile, "UTF-8")
//            val parser=JsonParser()
//            val `object`=parser.parse(BufferedReader(jsonreadcoding)) as JsonObject
//            val Plugins=`object`.getAsJsonArray("Plugins")
//            for (jsonElement in Plugins) {
//                val Plugin=jsonElement.asJsonObject
//                if(Plugin.get("type").asString.equals("zip", ignoreCase=true)) {
//                    Item.addItem(Plugin.get("title").asString)
//                }
//            }
//        }
//    }
//
//    @Throws(Exception::class)
//    fun buildImagePluginSelectItem(Item: JComboBox<*>) {
//        //
//        if(File(JsonPath).isFile() && File(JsonPath).exists() && json.isJSON()) {
//            val jsonfile=FileInputStream(JsonPath)
//            val jsonreadcoding=InputStreamReader(jsonfile, "UTF-8")
//            val parser=JsonParser()
//            val `object`=parser.parse(BufferedReader(jsonreadcoding)) as JsonObject
//            val Plugins=`object`.getAsJsonArray("Plugins")
//            for (jsonElement in Plugins) {
//                val Plugin=jsonElement.asJsonObject
//                if(Plugin.get("type").asString.equals("image", ignoreCase=true)) {
//                    Item.addItem(Plugin.get("title").asString)
//                }
//            }
//        }
//    }

    @Throws(Exception::class)
    fun buildPluginMenuItem(filename: String): JMenuItem {
        //
        val jsonfile=FileInputStream(JsonPath)
        val jsonreadcoding=InputStreamReader(jsonfile, "UTF-8")
        val parser=JsonParser()
        val `object`=parser.parse(BufferedReader(jsonreadcoding)) as JsonObject
        val Plugins=`object`.getAsJsonArray("Plugins")
        //
        val item=JMenuItem(filename)
        item.actionCommand=filename
        item.addActionListener { arg0 ->
            val props=Properties()
            props["python.home"]=System.getProperty("user.dir")+"/Lib"
            props["python.console.encoding"]="UTF-8"
            props["python.security.respectJavaAccessibility"]="false"
            props["python.import.site"]="false"
            val preprops=System.getProperties()
            PythonInterpreter.initialize(preprops, props, arrayOfNulls(0))
            val interpreter=PythonInterpreter()
            val sys=Py.getSystemState()
            sys.path.add(System.getProperty("user.dir")+"/Lib/site-packages")
            val input=this@Core.input.text
            for (jsonElement in Plugins) {
                val Plugin=jsonElement.asJsonObject
                if(Plugin.get("title").asString.equals(arg0.actionCommand.substring(1, arg0.actionCommand.length), ignoreCase=true)) {
                    interpreter.execfile(Plugin.get("path").asString)
                }
            }
            val func=interpreter.get("main", PyFunction::class.java) as PyFunction
            val res=func.__call__(PyString(input))
            this@Core.output.text=res.toString()
        }
        return item
    }

    companion object {
        private val v1="v2.2 Beta"//版本号
        private val Zt=Font("楷体", Font.PLAIN, 15)//字体
        private val JsonPath=String(StringBuilder(System.getProperty("user.dir")+"\\Setting.json"))//程序配置文件
        private fun InitGlobalFont(font: Font) {//设置全局统一字体
            val fontRes=FontUIResource(font)
            val keys=UIManager.getDefaults().keys()
            while (keys.hasMoreElements()) {
                val key=keys.nextElement()
                val value=UIManager.get(key)
                if(value is FontUIResource) {
                    UIManager.put(key, fontRes)
                }
            }
        }

        @JvmStatic
        fun main(args: Array<String>) {//主方法
            InitGlobalFont(Zt)//赋值字体
            Core().CryptoWindow()//创建主窗口CryptoWindow
        }
    }
}