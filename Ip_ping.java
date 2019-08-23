package java_application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Ip_ping {
	public ArrayList<Float> list=new ArrayList<Float>();
	public void ping(String hostname) {
		try {
			String data;
			//executing the ping command
			Process ping_request=Runtime.getRuntime().exec("ping "+hostname);
			//reading the response data from ping command
			BufferedReader br=new BufferedReader(new InputStreamReader(ping_request.getInputStream()));
			while(br.readLine()!=null) {
				data=br.readLine();
				//getting values of time based on string pattern
				if(data.contains("time")) {
					float time=Float.parseFloat((data.substring(data.indexOf("time")+5, (data.indexOf("ms")-1))));
					list.add(time);
					Collections.sort(list);
					//getting median of all times in the list
					if(list.size()%2==0) {
						System.out.println("median:"+list.get(((list.size()/2)+(list.size()/2+1))/2));
					}
					else {
						System.out.println("median:"+list.get((list.size()-1)/2));
					}
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		Ip_ping p=new Ip_ping();
		p.ping("127.0.0.1");
	}

}
