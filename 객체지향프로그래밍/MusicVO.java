package 객체지향프로그래밍;

public class MusicVO {
	
	private String name;
	private String singer;
	private int playTime;
	private String path;
	
	public MusicVO(String name, String singer, int playTime, String path) {
		super();
		this.name = name;
		this.singer = singer;
		this.playTime = playTime;
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public String getSinger() {
		return singer;
	}

	public int getPlayTime() {
		return playTime;
	}

	public String getPath() {
		return path;
	}
	
	public void show() {
		System.out.printf("%s - %s(%s%s)%n", name, singer, playTime, path);
	}
	
	//MVC 패턴
	
	
	
	
	
	
	
	
	
}
