import java.util.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, UnsupportedEncodingException {

		FilesCreate fc = new FilesCreate();
		fc.file_create();
		GetIP gp = new GetIP();
		String ip = gp.Ip_Send();
		String url = gp.url_send();
		String url1 = gp.url1_send();
		IP_Morse ms = new IP_Morse();
		String morse = ms.code_encode(ip);
		SHA1_Converter sha = new SHA1_Converter();

		MessageDigest md;
		md = MessageDigest.getInstance("SHA-1");
		byte[] sha1hash = new byte[40];
		md.update(morse.getBytes("iso-8859-1"), 0, morse.length());
		sha1hash = md.digest();
		sha.convert(sha1hash);

		Morse_IP obj = new Morse_IP();
		String decoded_ip = obj.code_decode(morse);
		PingRequest pr = new PingRequest();
		String statistics = pr.ping(url);

		Whois wh = new Whois();
		String whois_results = wh.whois_search(url1);

		HostRequest hr = new HostRequest();
		List<String> hoststatistics = hr.host(url);

		TraceRouteIP trip = new TraceRouteIP();
		String ip_route = trip.trace_ip(ip);

		TraceRouteHost trhs = new TraceRouteHost();
		String host_route = trhs.trace_host(hoststatistics);

	}
}