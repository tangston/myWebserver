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
	        Socket socket = ss.accept();//阻塞的得到请求
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

	        //写响应信息Response
	        BufferedWriter bw = new BufferedWriter(
	                new OutputStreamWriter(socket.getOutputStream()));
	        bw.write("HTTP/1.1 200 OK\n");// HTTP协议版本号， 状态码， 状态消息 
	        bw.write("Content-Type: text/html; charset=UTF-8\n\n");//Date:生成响应的日期和时间；Content-Type:指定了MIME类型的HTML(text/html),编码类型是UTF-8
	        //		上面多空了一行，是必须的
	        bw.write("<html>\n" + "<head>\n" + "    <title>first page</title>\n"//空行后面的html部分为响应正文
	                + "</head>\n" + "<body>\n" + "    <h1>Hello Web Server!</h1>\n"
	                + "</body>\n" + "</html>\n");
	        bw.flush();
	        bw.close();

	        br.close();
	        socket.close();
	        ss.close();
	    }

}
