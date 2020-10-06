package cn.itcast.chapter05.session.example02;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/CheckServlet")
public class CheckServlet extends HttpServlet {
	private static int WIDTH=60;//��֤��ͼƬ���
	private static int HEIGHT=20;//��֤��ͼƬ�߶�
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		resp.setCharacterEncoding("image/jpeg");
		resp.setContentType("text/html;charset=gbk");
		ServletOutputStream sos=resp.getOutputStream();
		//�����������Ҫ����ͼƬ
		resp.setHeader("Pragma", "No-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);
		//�����ڴ�ͼ�񲢻����ͼ��������
		BufferedImage image=new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		Graphics g=image.getGraphics();
		//������������֤��
		char[] rands=generateCheckCode1();
		//����ͼ��
		drawBackground(g);
		drawRands(g,rands);
		//����ͼ��Ļ��ƹ��̣����ͼ��
		g.dispose();
		//��ͼ��������ͻ���
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		ImageIO.write(image, "JPEG", bos);
		byte[] buf=bos.toByteArray();
		resp.setContentLength(buf.length);
		//��������Ҳ����д�ɣ�bos.writeTo(sos);
		sos.write(buf);
		bos.close();
		sos.close();
		//����ǰ��֤����뵽Session��
		session.setAttribute("check_code", new String(rands));
		//ֱ��ʹ������Ĵ��뽫�����⣬Session����������ύ��ӦǮ���
		//req.getSession().setAttribute("check_code", new String(rands));
		
	}
	//����һ��4�ַ�����֤��
	private char[] generateCheckCode1() {
		//������֤����ַ���
		String chars="0123456789abcdefghijklmnopqrstuvwxyz";
		char[] rands=new char[4];
		for(int i=0;i<4;i++) {
			int rand=(int) (Math.random()*36);
			rands[i]=chars.charAt(rand);
		}
		return rands;
	}
	
	private void drawRands(Graphics g, char[] rands) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.setFont(new Font(null,Font.ITALIC|Font.BOLD,18));
		//�ڲ�ͬ�ĸ߶��������֤���ÿ���ַ�
		g.drawString(""+rands[0], 1, 17);
		g.drawString(""+rands[1], 1, 17);
		g.drawString(""+rands[2], 1, 17);
		g.drawString(""+rands[3], 1, 17);
		System.out.println(rands);
	}
	private void drawBackground(Graphics g) {
		// TODO Auto-generated method stub
		//������
		g.setColor(new Color(0xDCDCDC));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		//�������120�����ŵ�
		for(int i=0;i<120;i++) {
			int x=(int) (Math.random()*WIDTH);
			int y=(int) (Math.random()*HEIGHT);
			int red=(int) (Math.random()*255);
			int green=(int) (Math.random()*255);
			int blue=(int) (Math.random()*255);
			g.setColor(new Color(red,green,blue));
			g.drawOval(x, y, 1, 0);
		}
	}
	
}
