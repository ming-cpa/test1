package sample.model;

public class EnvConf {

	/*server.port=8080
	server.name=Server 1
	server.session.timeout=1800
	spring.redis.host=127.0.0.1
	spring.redis.password=
	spring.redis.port=6379*/
			
	private int sport;
	private String sname;
	private int stimeout;
	private String rhost;
	private int rport;
	private String rpwd;
	public int getSport() {
		return sport;
	}
	public void setSport(int sport) {
		this.sport = sport;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getStimeout() {
		return stimeout;
	}
	public void setStimeout(int stimeout) {
		this.stimeout = stimeout;
	}
	public String getRhost() {
		return rhost;
	}
	public void setRhost(String rhost) {
		this.rhost = rhost;
	}
	public int getRport() {
		return rport;
	}
	public void setRport(int rport) {
		this.rport = rport;
	}
	public String getRpwd() {
		return rpwd;
	}
	public void setRpwd(String rpwd) {
		this.rpwd = rpwd;
	}
	
	
	
	
	
	
	

	
}
