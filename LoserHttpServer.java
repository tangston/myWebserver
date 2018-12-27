package webServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class LoserHttpServer {
	private final static int TCP_PORT = 23333;
	 public static void main(String[] args) throws IOException {
	        ServerSocket ss = new ServerSocket(TCP_PORT);
	        Socket socket = ss.accept();//�����ĵõ�����
	        BufferedReader br = new BufferedReader(
	                new InputStreamReader(socket.getInputStream()));
	        String buffer = null;
	        while ((buffer = br.readLine()) != null && !ss.equals("")) {
	            System.out.println(buffer);
	        }

//GET / HTTP/1.1
//Host: localhost:23333
//Connection: keep-alive
//Upgrade-Insecure-Requests: 1
//User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36
//Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
//Accept-Encoding: gzip, deflate, br
//Accept-Language: zh-CN,zh;q=0.9

	        //д��Ӧ��ϢResponse
	        BufferedWriter bw = new BufferedWriter(
	                new OutputStreamWriter(socket.getOutputStream()));
	        bw.write("HTTP/1.1 200 OK\n");// HTTPЭ��汾�ţ� ״̬�룬 ״̬��Ϣ 
	        bw.write("Content-Type: text/html; charset=UTF-8\n\n");//Date:������Ӧ�����ں�ʱ�䣻Content-Type:ָ����MIME���͵�HTML(text/html),����������UTF-8
	        //		��������һ�У��Ǳ����
	        bw.write("<html>\n" + "<head>\n" + "    <title>first page</title>\n"//���к����html����Ϊ��Ӧ����
	                + "</head>\n" + "<body>\n" + "    <h1>Hello Web Server!</h1>\n"
	                + "</body>\n" + "</html>\n");
	        bw.flush();
	        bw.close();

	        br.close();
	        socket.close();
	        ss.close();
	    }

}
