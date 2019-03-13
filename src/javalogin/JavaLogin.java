package javalogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import dao.Dao;
import op.Op;

public class JavaLogin extends JFrame{
    public JavaLogin(){        
   /*框架*/
   JFrame jf=new JFrame();
   jf.setSize(500, 300);
   jf.setTitle("登录");

           /*面板*/
	JPanel jp=new JPanel();
             jp.setLayout(null);
           /*用户名标签*/
           JLabel jlname=new JLabel();
           jlname.setText("用户名");
           jlname.setBounds(100,20,50,20);
         jp.add(jlname);  
       	 /*用户名文本框*/
         JTextArea jlog=new JTextArea();
          jlog.setBounds(140,20,200,20);
         jp.add(jlog);
            /*密码标签*/
           JLabel jlpass=new JLabel();
           jlpass.setText("密码");
           jlpass.setBounds(100,60,50,20);
         jp.add(jlpass);      
                	 /*密码文本框*/
         JTextArea jpass=new JTextArea();
          jpass.setBounds(140,60,200,20);
         jp.add(jpass);
          /*按钮*/
          JButton jblog=new JButton();
          jblog.setBounds(180,90,80,20);
          jblog.setText("登录");
          jp.add(jblog);
          /*点击登录按钮事件*/
jblog.addActionListener(new ActionListener()
{
 public void actionPerformed(ActionEvent event){
user=Dao.check(jlog.getText(),jpass.getText());
if(user.getName()==null){
    JOptionPane.showMessageDialog(null, "登录失败");
}
else{
    JOptionPane.showMessageDialog(null, "登录成功");
}
     }
    });       	
                  /*框架可见*/
          jf.add(jp);
                jf.setVisible(true);
    }
    public static void main(String[] args) {
new JavaLogin();

 }
    	private static Op user;
        public static Op getUser() {
		return user;
	}
	public static void setUser(Op user) {
	JavaLogin.user = user;
	}
}
