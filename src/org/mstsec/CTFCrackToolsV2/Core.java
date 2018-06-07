package org.mstsec.CTFCrackToolsV2;
/* 米斯特安全团队 Www.Hi-OurLife.Com
 * 作者：A先森_林晨,z13
 * Mail:admin@hi-ourlife.com
 * QQ：627437686
 */

/* MSEC Team Www.Hi-OurLife.Com
 * Author:0chen,z13
 * Mail:mrsafea@gmail.com
 * FaceBook:0chencc
 */
import java.math.BigInteger;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FontUIResource;
import org.python.core.*;
import org.python.util.PythonInterpreter;
import com.google.gson.*;
public class Core{
	private static String v1 = "v2.2 Beta";//版本号
	private static Font Zt = new Font("楷体", Font.PLAIN, 15);//字体
	private static String JsonPath = new String(System.getProperty("user.dir")+"\\Setting.json");//程序配置文件
	Json json = new Json();
	public JTextArea input=new JTextArea();
	public JTextArea output=new JTextArea();
    public void CryptoWindow(){//主窗口
        Locale language = Locale.getDefault();
        ResourceBundle RB = ResourceBundle.getBundle("info",language);
		JFrame jFrame = new JFrame(RB.getString("AppTitle")+v1);
		Container frameContainer= jFrame.getContentPane();
		SpringLayout springLayout = new SpringLayout();
		frameContainer.setLayout(springLayout);
		//
		JMenuBar mainMenuBar = new JMenuBar();
		JMenu Ascii = new JMenu(RB.getString("MenuCode"));
		JMenuItem caesar = new JMenuItem(RB.getString("MenuCodeCaesar"));;
		JMenuItem rot13 = new JMenuItem(RB.getString("MenuCodeRot13"));
		JMenuItem fence = new JMenuItem(RB.getString("MenuCodeFence"));
		JMenuItem peig = new JMenuItem(RB.getString("MenuCodeBaconab"));
		JMenuItem peigd = new JMenuItem(RB.getString("MenuCodeBaconDecode"));
		JMenuItem zj = new JMenuItem(RB.getString("MenuCodePig"));
		JMenuItem base64jg = new JMenuItem(RB.getString("MenuCodeBase64gbkEn"));
		JMenuItem base64cg = new JMenuItem(RB.getString("MenuCodeBase64gbkDe"));
		JMenuItem base64j = new JMenuItem(RB.getString("MenuCodeBase64utf8En"));
		JMenuItem base64c = new JMenuItem(RB.getString("MenuCodeBase64utf8De"));
		JMenuItem morsee = new JMenuItem(RB.getString("MenuCodeMorseEn"));
		JMenuItem morsed = new JMenuItem(RB.getString("MenuCodeMorseDe"));
		JMenuItem reverse = new JMenuItem(RB.getString("MenuCodeReverse"));
		JMenuItem UrlCodee = new JMenuItem(RB.getString("MenuCodeURLEn"));
		JMenuItem UrlCoded = new JMenuItem(RB.getString("MenuCodeURLDe"));
		JMenuItem UnicoderStre = new JMenuItem(RB.getString("MenuCodeUnicodeEn"));
		JMenuItem UnicoderStrd = new JMenuItem(RB.getString("MenuCodeUnicodeDe"));
		JMenuItem asciiZUnicode = new JMenuItem(RB.getString("MenuCodeAsciitoUnicode"));
		JMenuItem UnicodeZascii = new JMenuItem(RB.getString("MenuCodeUnicodetoAscii"));
		//
		JMenu radixchange = new JMenu(RB.getString("MenuRadix"));
		//JMenuItem radix = new JMenuItem(" 任意进制转换");
		JMenuItem j2z8 = new JMenuItem(RB.getString("MenuRadix2to8"));
		JMenuItem j2z10 = new JMenuItem(RB.getString("MenuRadix2to10"));
		JMenuItem j2z16 = new JMenuItem(RB.getString("MenuRadix2to16"));
		JMenuItem j8z2 = new JMenuItem(RB.getString("MenuRadix8to2"));
		JMenuItem j8z10 = new JMenuItem(RB.getString("MenuRadix8to10"));
		JMenuItem j8z16 = new JMenuItem(RB.getString("MenuRadix8to16"));
		JMenuItem j10z2 = new JMenuItem(RB.getString("MenuRadix10to2"));
		JMenuItem j10z8 = new JMenuItem(RB.getString("MenuRadix10to8"));
		JMenuItem j10z16 = new JMenuItem(RB.getString("MenuRadix10to16"));
		JMenuItem j16z2 = new JMenuItem(RB.getString("MenuRadix16to2"));
		JMenuItem j16z8 = new JMenuItem(RB.getString("MenuRadix16to8"));
		JMenuItem j16z10 = new JMenuItem(RB.getString("MenuRadix16to10"));
		//
		JMenu Plugin = new JMenu(RB.getString("MenuPlugins"));
		JMenuItem addplugin = new JMenuItem(RB.getString("MenuPluginsAdd"));
		JMenuItem rsa = new JMenuItem(RB.getString("MenuPluginRSA"));
		JMenuItem rc4 = new JMenuItem(RB.getString("MenuPluginRC4"));
		JMenuItem b32e = new JMenuItem(RB.getString("MenuPluginBase32En"));
		JMenuItem b32d = new JMenuItem(RB.getString("MenuPluginBase32De"));
		JMenuItem b16e = new JMenuItem(RB.getString("MenuPluginBase16En"));
		JMenuItem b16d = new JMenuItem(RB.getString("MenuPluginBase16De"));
		JMenuItem r162ascii = new JMenuItem(RB.getString("MenuPlugin16toAscii"));
		JMenuItem ascii216 = new JMenuItem(RB.getString("MenuPluginAsciito16"));
		//
		JMenu girlgif = new JMenu(RB.getString("MenuGirl"));
		JMenuItem girlgifw = new JMenuItem(RB.getString("MenuGirlShow"));
		JMenu Help = new JMenu(RB.getString("MenuHelp"));
		JMenuItem aboutme = new JMenuItem(RB.getString("MenuHelpAbout"));
		mainMenuBar.add(Ascii);
		Ascii.add(caesar);
		Ascii.add(rot13);
		Ascii.add(fence);
		Ascii.add(peig);
		Ascii.add(peigd);
		Ascii.add(zj);
		Ascii.add(base64j);
		Ascii.add(base64c);
		Ascii.add(base64jg);
		Ascii.add(base64cg);
		Ascii.add(morsee);
		Ascii.add(morsed);
		Ascii.add(reverse);
		Ascii.add(UrlCoded);
		Ascii.add(UrlCodee);
		Ascii.add(UnicoderStre);
		Ascii.add(UnicoderStrd);
		Ascii.add(asciiZUnicode);
		Ascii.add(UnicodeZascii);
		mainMenuBar.add(radixchange);
		//radixchange.add(radix);   //BUG功能....等有空修复
		radixchange.add(j2z8);
		radixchange.add(j2z10);
		radixchange.add(j2z16);
		radixchange.add(j8z2);
		radixchange.add(j8z10);
		radixchange.add(j8z16);
		radixchange.add(j10z2);
		radixchange.add(j10z8);
		radixchange.add(j10z16);
		radixchange.add(j16z2);
		radixchange.add(j16z8);
		radixchange.add(j16z10);
		mainMenuBar.add(Plugin);
		Plugin.add(addplugin);
		Plugin.add(rsa);
		Plugin.add(rc4);
		Plugin.add(b32e);
		Plugin.add(b32d);
		Plugin.add(b16e);
		Plugin.add(b16d);
		Plugin.add(r162ascii);
		Plugin.add(ascii216);
		try {
			buildPluginMenu(Plugin);
		} catch (Exception e2) {
			// TODO 自动生成的 catch 块
			e2.printStackTrace();
		}//传入要添加菜单的目录
		mainMenuBar.add(girlgif);
		girlgif.add(girlgifw);
		mainMenuBar.add(Help);
		Help.add(aboutme);
		frameContainer.add(mainMenuBar);
		springLayout.putConstraint(SpringLayout.NORTH, mainMenuBar, 0, SpringLayout.NORTH, frameContainer);
		springLayout.putConstraint(SpringLayout.WEST, mainMenuBar, 0, SpringLayout.WEST, frameContainer);
		springLayout.putConstraint(SpringLayout.EAST, mainMenuBar, 0, SpringLayout.EAST, frameContainer);
		//
		JTabbedPane mainTabbedPane = new JTabbedPane();
		//
		JSplitPane crypto=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		crypto.setDividerLocation(250);
		JPanel crypto_top=new JPanel();
		crypto_top.setLayout(springLayout);
		JLabel inputL=new JLabel(RB.getString("AppInputLabel")+"0");
		crypto_top.add(inputL);
		springLayout.putConstraint(SpringLayout.NORTH, inputL, 0, SpringLayout.NORTH, crypto_top);
		JScrollPane inputP = new JScrollPane(input);
		crypto_top.add(inputP);
		springLayout.putConstraint(SpringLayout.NORTH, inputP, 25, SpringLayout.NORTH, crypto_top);
		springLayout.putConstraint(SpringLayout.SOUTH, inputP, 0, SpringLayout.SOUTH, crypto_top);
		springLayout.putConstraint(SpringLayout.WEST, inputP, 0, SpringLayout.WEST, crypto_top);
		springLayout.putConstraint(SpringLayout.EAST, inputP, 0, SpringLayout.EAST, crypto_top);
		crypto.setTopComponent(crypto_top);
		//
		JPanel crypto_bottom=new JPanel();
		crypto_bottom.setLayout(springLayout);
		JLabel outpuL=new JLabel(RB.getString("AppOutputLabel")+"0");
		crypto_bottom.add(outpuL);
		springLayout.putConstraint(SpringLayout.NORTH, outpuL, 0, SpringLayout.NORTH, crypto_bottom);
		JScrollPane outputP = new JScrollPane(output);
		crypto_bottom.add(outputP);
		output.setText(RB.getString("AppRemarks"));
		springLayout.putConstraint(SpringLayout.NORTH, outputP, 25, SpringLayout.NORTH, crypto_bottom);
		springLayout.putConstraint(SpringLayout.SOUTH, outputP, 0, SpringLayout.SOUTH, crypto_bottom);
		springLayout.putConstraint(SpringLayout.WEST, outputP, 0, SpringLayout.WEST, crypto_bottom);
		springLayout.putConstraint(SpringLayout.EAST, outputP, 0, SpringLayout.EAST, crypto_bottom);
		crypto.setBottomComponent(crypto_bottom);
		mainTabbedPane.addTab("Crypto", crypto);	
		//
		frameContainer.add(mainTabbedPane);
		springLayout.putConstraint(SpringLayout.NORTH, mainTabbedPane, 25, SpringLayout.NORTH, frameContainer);
		springLayout.putConstraint(SpringLayout.SOUTH, mainTabbedPane, -30, SpringLayout.SOUTH, frameContainer);
		springLayout.putConstraint(SpringLayout.EAST, mainTabbedPane, 0, SpringLayout.EAST, frameContainer);
		springLayout.putConstraint(SpringLayout.WEST, mainTabbedPane, 0, SpringLayout.WEST, frameContainer);
		//
		JPanel mainBottomBar =new JPanel();
		JLabel ad=new JLabel(RB.getString("AppCopyright"));
		mainBottomBar.add(ad);
		frameContainer.add(mainBottomBar);
		springLayout.putConstraint(SpringLayout.SOUTH, mainBottomBar, 0, SpringLayout.SOUTH, frameContainer);
		//
		jFrame.setDefaultCloseOperation(3);
		jFrame.setSize(1000, 800);
		jFrame.setVisible(true);
    	//
    	input.getDocument().addDocumentListener(new DocumentListener(){
			int inputlength;
			@Override public void changedUpdate(DocumentEvent evt) {
				inputlength = input.getText().replaceAll("\r|\n", "").length();
		    	inputL.setText(RB.getString("AppInputLabel")+inputlength);
		    }
			@Override
			public void insertUpdate(DocumentEvent e) {
				inputlength = input.getText().replaceAll("\r|\n", "").length();
		    	inputL.setText(RB.getString("AppInputLabel")+inputlength);
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				inputlength = input.getText().replaceAll("\r|\n", "").length();
		    	inputL.setText(RB.getString("AppInputLabel")+inputlength);
			}
		});
		output.getDocument().addDocumentListener(new DocumentListener(){
			int outputlength;
			@Override public void changedUpdate(DocumentEvent evt) {
				outputlength = output.getText().replaceAll("\r|\n", "").length();
		    	outpuL.setText(RB.getString("AppOutputLabel")+outputlength);
		    }
			@Override
			public void insertUpdate(DocumentEvent e) {
				outputlength = output.getText().replaceAll("\r|\n", "").length();
				outpuL.setText(RB.getString("AppOutputLabel")+outputlength);
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				outputlength = output.getText().replaceAll("\r|\n", "").length();
				outpuL.setText(RB.getString("AppOutputLabel")+outputlength);
			}
		});
		//监听按钮
		caesar.addActionListener(new ActionListener() {//当按下凯撒密码
		    public void actionPerformed(ActionEvent evt) {
		    	output.setText(Func.Caesar(input.getText()));
		    } } );
		peig.addActionListener(new ActionListener() {//当按下培根密码
		    public void actionPerformed(ActionEvent evt) {
		    	output.setText(Func.Baconab(input.getText()));
		    } } );
		zj.addActionListener(new ActionListener() {//当按下猪圈密码
		    public void actionPerformed(ActionEvent evt) {
		    	output.setText(Func.zjd(input.getText()));
		    } } );
		rot13.addActionListener(new ActionListener() {//当按下rot13密码
		    public void actionPerformed(ActionEvent evt) {
		    	output.setText(Func.Rot13(input.getText()));
		    } } );
		fence.addActionListener(new ActionListener() {//当按下栅栏密码
		    public void actionPerformed(ActionEvent evt) {
		    output.setText(Func.Fence(input.getText()));
		    } } );
		base64j.addActionListener(new ActionListener() {//当按下Base64加密时
		    public void actionPerformed(ActionEvent evt) {
		    	output.setText(Func.Base64j(input.getText()));
		    } } );
		base64jg.addActionListener(new ActionListener() {//当按下Base64解码时
		    public void actionPerformed(ActionEvent evt) {
		    	output.setText(Func.Base64jg(input.getText()));
		    } } );
		base64cg.addActionListener(new ActionListener() {//当按下Base64解码时
		    public void actionPerformed(ActionEvent evt) {
		    	output.setText(Func.Base64cg(input.getText()));
		    } } );
		base64c.addActionListener(new ActionListener() {//当按下Base64解码时
		    public void actionPerformed(ActionEvent evt) {
		    	output.setText(Func.Base64c(input.getText()));
		    } } );
		morsee.addActionListener(new ActionListener() {//当按下摩斯加密时
			public void actionPerformed(ActionEvent evt){
				output.setText(Func.MorseE(input.getText()));
			}
		});
		morsed.addActionListener(new ActionListener() {//当按下摩斯解密时
			public void actionPerformed(ActionEvent evt){
				output.setText(Func.MorseD(input.getText()));
			}
		});
		reverse.addActionListener(new ActionListener() {//当按下摩斯解密时
			public void actionPerformed(ActionEvent evt){
				output.setText(Func.reverse(input.getText()));
			}
		});
		UrlCodee.addActionListener(new ActionListener(){//当按下Url编码
		public void actionPerformed(ActionEvent evt){
			try {
				output.setText(Func.UrlEncoder(input.getText()));
			} catch (UnsupportedEncodingException e) {
				// 
					e.printStackTrace();
				}
			}
		});
		UrlCoded.addActionListener(new ActionListener(){//当按下Url编码解码
		public void actionPerformed(ActionEvent evt){
			try {
				output.setText(Func.UrlDecoder(input.getText()));
			} catch (UnsupportedEncodingException e) {
				// 
					e.printStackTrace();
				}
			}
		});
		UnicoderStre.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				output.setText(Func.UnicodeStre(input.getText()));
			}
		});
		UnicoderStrd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				output.setText(Func.UnicodeStrd(input.getText()));
			}
		});    
		j2z8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				try{
					output.setText(new java.math.BigInteger(input.getText(),2).toString(8));
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		j2z10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				try{
					output.setText(new java.math.BigInteger(input.getText(),2).toString(10));
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		j2z16.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				try{
					output.setText(new java.math.BigInteger(input.getText(),2).toString(16));
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		j8z2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				try{
					output.setText(new java.math.BigInteger(input.getText(),8).toString(2));
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		j8z10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				try{
					output.setText(new java.math.BigInteger(input.getText(),8).toString(10));;
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		j8z16.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				try{
					output.setText(new java.math.BigInteger(input.getText(),8).toString(16));
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		j10z2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				try{
					output.setText(new java.math.BigInteger(input.getText(),10).toString(2));
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		j10z8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				try{
					output.setText(new java.math.BigInteger(input.getText(),10).toString(8));
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		j10z16.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				try{
					output.setText(new java.math.BigInteger(input.getText(),10).toString(16));
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		j16z2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				try{
					output.setText(new java.math.BigInteger(input.getText(),16).toString(2));
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		j16z8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				try{
					output.setText(new java.math.BigInteger(input.getText(),16).toString(8));
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		j16z10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				try{
					output.setText(new java.math.BigInteger(input.getText(),16).toString(10));
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		UnicodeZascii.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				output.setText(Func.UnicodeZascii(input.getText()));
			}
		});
		asciiZUnicode.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				output.setText(Func.asciiZUnicode(input.getText()));
			}
		});
		rsa.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new Core().rsatools();
			}
		});
		rc4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new Core().rc4tools();
			}
		});
		b32e.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				output.setText(Func.Base32j(input.getText()));
			}
		});
		b32d.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				output.setText(Func.Base32c(input.getText()));
			}
		});
		b16e.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				output.setText(Func.Base16j(input.getText()));
			}
		});
		b16d.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				output.setText(Func.Base16c(input.getText()));
			}
		});
		peigd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				output.setText(Func.Bacon(input.getText()));
			}
		});
		r162ascii.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				output.setText(Func.r162ascii(input.getText()));
			}
		});
		ascii216.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				output.setText(Func.ascii216(input.getText()));
			}
		});
		girlgifw.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new Core().girl();
				
			}
		});	
/*		radix.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			//debug
			System.out.println(input.getText());
			new CTFcrack().radix(input.getText());
			}
	});	*/
		aboutme.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				aboutMe();
			}
		});
		//
		String py_suf[] = {"py"};
    	FileNameExtensionFilter py_filter;
    	JFileChooser py_openfile = new JFileChooser();
    	py_openfile.setFileSelectionMode(JFileChooser.FILES_ONLY);
    	py_filter = new FileNameExtensionFilter("Python(.py)",py_suf);
    	py_openfile.setFileFilter(py_filter);
		addplugin.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
	        int py_openframe = py_openfile.showDialog(new JLabel(), "选择/Choose"); 
	        if (py_openframe == JFileChooser.APPROVE_OPTION){
            File py_file = py_openfile.getSelectedFile();//得到选择的文件名
            try {
				String title = json.createJSON(py_file.toString());
				switch (json.getType(title)){
				case "crypto":
					Plugin.add(buildPluginMenuItem(" " + title));
					break;
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
	       }
		}
	});	
		//
    }
    public void radix(String input){
    	JFrame Radixgui = new JFrame("任意进制转换");
    	Radixgui.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    	Radixgui.setLayout(null);
    	Radixgui.setBounds(0, 0, 200, 200);
    	JTextArea waitradix = new JTextArea();
    	waitradix.setBounds(10, 10, 150, 20);
    	JLabel waitTips = new JLabel("初始进制");
    	waitTips.setBounds(10,30,150,20);
    	JTextArea resradix = new JTextArea();
    	resradix.setBounds(10, 50, 150, 20);
    	JLabel resTips = new JLabel("待转换的进制");
    	resTips.setBounds(10, 70, 150, 20);
    	JButton change = new JButton("Change");
    	change.setBounds(10,90,150,20);
    	Radixgui.add(waitradix);
    	Radixgui.add(waitTips);
    	Radixgui.add(resradix);
    	Radixgui.add(resTips);
    	Radixgui.add(change);
    	Radixgui.setVisible(true);
    	Radixgui.setResizable(false);
    	change.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent evt){
				try{
		   			//int waitradixint = Integer.parseInt(waitradix.getText());
					//int resradixint = Integer.parseInt(waitradix.getText());
					//output.setText(new java.math.BigInteger(input,2).toString(10)); //debug
				}catch(Exception e){
					//debug
					e.printStackTrace();
				}
				System.out.println(output.getText());
    		}
    	});
    }
    private void rsatools(){//rsatools窗口
        JFrame Rsatools = new JFrame("RsaTools--PythonPlugin");
        JTextArea rsap = new JTextArea();
        JTextArea rsaq = new JTextArea();
        JTextArea rsae = new JTextArea();
        JTextArea rsad = new JTextArea();
        JLabel Rlabelp = new JLabel("p:");
        JLabel Rlabelq = new JLabel("q:");
        JLabel Rlabele = new JLabel("e:");
        JLabel Rlabeld = new JLabel("d:");
        JButton rsady = new JButton("Calc.D");
        Container container = Rsatools.getContentPane();
        container.setLayout(null);
        Rsatools.setVisible(true);
        Rsatools.setResizable(false);
        Rsatools.setSize(300, 200);//窗口
        Rsatools.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        rsap.setBounds(30, 10, 200,20);
        rsaq.setBounds(30, 40,200, 20);
        rsae.setBounds(30, 70, 200, 20);
        rsad.setBounds(30, 100, 200, 20);
        container.add(rsap);
        container.add(rsaq);
        container.add(rsae);
        container.add(rsad);
        Rlabelp.setBounds(5, 10, 30, 20);
        Rlabelq.setBounds(5, 40,30,20);
        Rlabele.setBounds(5, 70, 30, 20);
        Rlabeld.setBounds(5, 100, 30, 20);
        container.add(Rlabelp);
        container.add(Rlabelq);
        container.add(Rlabele);
        container.add(Rlabeld);
        rsady.setBounds(80, 130, 100, 20);
        container.add(rsady);
    	rsady.addActionListener(new ActionListener(){//调用rsatools
    		public void actionPerformed(ActionEvent evt){
             PythonInterpreter interpreter = new PythonInterpreter();
    		 interpreter.execfile(System.getProperty("user.dir")+"\\Plugin\\OS\\rsa.py");
    		 BigInteger rsapstr=new BigInteger(rsap.getText());
             BigInteger rsaqstr=new BigInteger(rsaq.getText());
             BigInteger rsaestr=new BigInteger(rsae.getText());
             PyFunction func = (PyFunction)interpreter.get("rsa",PyFunction.class);
             PyObject rsadstr = func.__call__(new PyLong(rsapstr), new PyLong(rsaqstr),new PyLong(rsaestr));  
             rsad.setText(rsadstr.toString());
    		}
    	});
    }
    private void rc4tools(){//rsatools窗口
        JFrame Rc4tools = new JFrame("rc4--PythonPlugin");
        JTextArea datat = new JTextArea();
        JTextArea keyt = new JTextArea();
        JTextArea rest = new JTextArea();
        JLabel Rdata = new JLabel("data");
        JLabel Rkey = new JLabel("key");
        JLabel Rres = new JLabel("Res");
        JButton RC4crack = new JButton("Crack!");
        Container container = Rc4tools.getContentPane();
        container.setLayout(null);
        Rc4tools.setVisible(true);
        Rc4tools.setResizable(false);
        Rc4tools.setSize(300, 170);//窗口
        Rc4tools.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        datat.setBounds(50, 10, 200,20);
        keyt.setBounds(50, 40,200, 20);
        rest.setBounds(50, 70, 200, 20);
        container.add(datat);
        container.add(keyt);
        container.add(rest);
        Rdata.setBounds(5, 10, 50, 20);
        Rkey.setBounds(5, 40,50,20);
        Rres.setBounds(5, 70, 50, 20);
        container.add(Rdata);
        container.add(Rkey);
        container.add(Rres);
        RC4crack.setBounds(80, 100, 100, 20);
        container.add(RC4crack);
    	RC4crack.addActionListener(new ActionListener(){//调用rsatools
    		public void actionPerformed(ActionEvent evt){
             PythonInterpreter interpreter = new PythonInterpreter();
    		 interpreter.execfile(System.getProperty("user.dir")+"\\Plugin\\OS\\RC4.py");
    		 String data=datat.getText();
             String key=keyt.getText();
             PyFunction func = (PyFunction)interpreter.get("main",PyFunction.class);
             PyObject rsadstr = func.__call__(new PyString(data), new PyString(key));  
             rest.setText(rsadstr.toString());
    		}
    	});
    }
    private void girl(){//Girl
        Locale language = Locale.getDefault();
        ResourceBundle RB = ResourceBundle.getBundle("info",language);
        JFrame frame = new JFrame(RB.getString("MenuGirlTitle")); 
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
        File imgadd = new File(System.getProperty("user.dir")+"\\girl\\girl1.gif");
        ImageIcon imageIcon = new ImageIcon(imgadd.toString()); 
        JLabel label = new JLabel("", imageIcon, SwingConstants.CENTER); 
        frame.add(label); 
        frame.pack(); 
        frame.setVisible(true); 
    }
    private void aboutMe(){
        Locale language = Locale.getDefault();
        ResourceBundle RB = ResourceBundle.getBundle("info",language);
    	JFrame jframe = new JFrame("Help");
    	Container frame = jframe.getContentPane();
    	jframe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    	SpringLayout sp = new SpringLayout();
    	JTextArea help = new JTextArea();
    	help.setText(RB.getString("MenuHelpAboutText"));
    	frame.setLayout(sp);
    	frame.add(help);
    	sp.putConstraint(SpringLayout.NORTH, help, 0, SpringLayout.NORTH, frame);
    	sp.putConstraint(SpringLayout.SOUTH, help, 0, SpringLayout.SOUTH, frame);
    	sp.putConstraint(SpringLayout.EAST, help, 0, SpringLayout.EAST, frame);
    	sp.putConstraint(SpringLayout.WEST, help, 0, SpringLayout.WEST, frame);
    	jframe.setSize(940, 500);
    	jframe.setVisible(true);
    }
    private static void InitGlobalFont(Font font) {//设置全局统一字体
		  FontUIResource fontRes = new FontUIResource(font);  
		  for (Enumeration<Object> keys = UIManager.getDefaults().keys();  
		  keys.hasMoreElements(); ) {  
		  Object key = keys.nextElement();  
		  Object value = UIManager.get(key);  
		  if (value instanceof FontUIResource) {  
		  UIManager.put(key, fontRes);  
		 }
	  }
	}  
	public static void main(String[] args){//主方法 
	InitGlobalFont(Zt);//赋值字体
	String help = (  "*****************************************************"
			    +   "\n*                                                   *"
			    +   "\n*                                                   *"
			    +   "\n*             Weclome to CTFcrackTools              *"
			    +   "\n*             Autor:0chen                           *"
			    +   "\n*             Team:MSEC Team                        *"
			    +   "\n*             Site:www.hi-ourlife.com               *"
			    +   "\n*                                                   *"
			    +   "\n*                                                   *"
			    +   "\n*****************************************************"
			    +   "\n\nUsage:CTFcrack.jar [-options] [password]\n"
			    +   "\n-caesar  //This is Crack Caesar Code  调用凯撒密码解码"
				+   "\n-rot13   //This is Crack Rot13 Code   调用rot13解码"
				+   "\n-fence   //This is Crack Fence Code   调用栅栏密码解码"
				+   "\n-bcab    //This is Bacon Upper and    培根大小写转换AB"
				+   "\n           Lower case change to AB"
				+   "\n-bcd     //This is Crack Bacon Code   培根密码AB解码"
				+   "\n-pig     //This is Crack Pig Code     猪圈密码对调");
	 if (args.length==0){
	 }else{
	 switch(args[0]){
		case "-h":
			System.out.println(help);
			System.exit(0);
			break;
		case "-caesar":
			System.out.println(Func.Caesar(args[1]));
			System.exit(0);
			break;
		case "-rot13":
			System.out.println(Func.Rot13(args[1]));
			System.exit(0);
			break;
		case "-fence":
			System.out.println(Func.Fence(args[1]));
			System.exit(0);
			break;
		case "-bcab":
			System.out.println(Func.Baconab(args[1]));
			System.exit(0);
			break;
		case "-bcd":
			System.out.println(Func.Bacon(args[1]));
			System.exit(0);
			break;
		case "-pig":
			System.out.println(Func.zjd(args[1]));
			System.exit(0);
			break;
		default:
			System.out.println("\nMaybe you are make a mistake!\n\n"+help);
			System.exit(0);
			break;
	  }
	 }
	 new Core().CryptoWindow();//创建主窗口CryptoWindow
	}
	//菜单
	private void buildPluginMenu(JMenu menu) throws Exception{
		//
	    if(new File(JsonPath).isFile()&&new File(JsonPath).exists()&&json.isJSON()){
	    	FileInputStream jsonfile = new FileInputStream(JsonPath);
			InputStreamReader jsonreadcoding = new InputStreamReader(jsonfile,"UTF-8");
		    JsonParser parser = new JsonParser(); 
		    JsonObject object =  (JsonObject) parser.parse(new BufferedReader(jsonreadcoding));
	    	JsonArray Plugins = object.getAsJsonArray("Plugins");
	    	for (JsonElement jsonElement : Plugins) {
	    		JsonObject Plugin = jsonElement.getAsJsonObject();
	    		if(Plugin.get("type").getAsString().equalsIgnoreCase("crypto")){
	    			menu.add(buildPluginMenuItem(" " + Plugin.get("title").getAsString()));
	    		}
	    	}
	    }
	}
	private void buildZipPluginSelectItem(JComboBox Item) throws Exception{
	    //
	    if(new File(JsonPath).isFile()&&new File(JsonPath).exists()&&json.isJSON()){
	    	FileInputStream jsonfile = new FileInputStream(JsonPath);
			InputStreamReader jsonreadcoding = new InputStreamReader(jsonfile,"UTF-8");
		    JsonParser parser = new JsonParser(); 
		    JsonObject object =  (JsonObject) parser.parse(new BufferedReader(jsonreadcoding));
	    	JsonArray Plugins = object.getAsJsonArray("Plugins");
		    	for (JsonElement jsonElement : Plugins) {
		    		JsonObject Plugin = jsonElement.getAsJsonObject();
		    		if(Plugin.get("type").getAsString().equalsIgnoreCase("zip")){
		    			Item.addItem(Plugin.get("title").getAsString());
		    	}
		    }
	    }
	  }
	public void buildImagePluginSelectItem(JComboBox Item) throws Exception{
	    //
	    if(new File(JsonPath).isFile()&&new File(JsonPath).exists()&&json.isJSON()){
	    	FileInputStream jsonfile = new FileInputStream(JsonPath);
			InputStreamReader jsonreadcoding = new InputStreamReader(jsonfile,"UTF-8");
		    JsonParser parser = new JsonParser(); 
		    JsonObject object =  (JsonObject) parser.parse(new BufferedReader(jsonreadcoding));
	    	JsonArray Plugins = object.getAsJsonArray("Plugins");
		    	for (JsonElement jsonElement : Plugins) {
		    		JsonObject Plugin = jsonElement.getAsJsonObject();
		    		if(Plugin.get("type").getAsString().equalsIgnoreCase("image")){
		    			Item.addItem(Plugin.get("title").getAsString());
		    		}
	    	}
	    }
	  }
	public JMenuItem buildPluginMenuItem(String filename) throws Exception{
		//
		FileInputStream jsonfile = new FileInputStream(JsonPath);
		InputStreamReader jsonreadcoding = new InputStreamReader(jsonfile,"UTF-8");
	    JsonParser parser = new JsonParser(); 
	    JsonObject object =  (JsonObject) parser.parse(new BufferedReader(jsonreadcoding));
	    JsonArray Plugins = object.getAsJsonArray("Plugins");
	    //
	    JMenuItem item = new JMenuItem(filename);
	    item.setActionCommand(filename);
	    item.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent arg0) {
			Properties props = new Properties();
			props.put("python.home",System.getProperty("user.dir")+"/Lib");
			props.put("python.console.encoding", "UTF-8");
			props.put("python.security.respectJavaAccessibility", "false");
			props.put("python.import.site","false");
			Properties preprops = System.getProperties();
			PythonInterpreter.initialize(preprops, props, new String[0]);
			PythonInterpreter interpreter = new PythonInterpreter();
			PySystemState sys = Py.getSystemState();
			sys.path.add(System.getProperty("user.dir")+"/Lib/site-packages");
			String input = Core.this.input.getText();
			for (JsonElement jsonElement : Plugins) {
			    JsonObject Plugin = jsonElement.getAsJsonObject();
			    if(Plugin.get("title").getAsString().equalsIgnoreCase(arg0.getActionCommand().substring(1, arg0.getActionCommand().length()))){
			    	interpreter.execfile(Plugin.get("path").getAsString());
			    }
			}
			PyFunction func = (PyFunction)interpreter.get("main", PyFunction.class);
			PyObject res = func.__call__(new PyString(input));
			Core.this.output.setText(res.toString());
	      }
	    });
	    return item;
	  }
}