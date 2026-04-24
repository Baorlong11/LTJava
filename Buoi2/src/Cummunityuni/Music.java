package Cummunityuni;

public class Music {

	public static void main(String[] args) {
		String path = "D:/music/bolero/longme.mp3";
		int lastSlashIndex = path.lastIndexOf("/");
		String tenFileDayDu = path.substring(lastSlashIndex + 1);
		int lastDotIndex = path.lastIndexOf(".");
		String tenFileKhongDuoi = path.substring(lastSlashIndex + 1, lastDotIndex);
		System.out.println("Đường dẫn: " + path);
		System.out.println("Hãy lấy longme.mp3 => " + tenFileDayDu);
		System.out.println("Hãy lấy longme     => " + tenFileKhongDuoi);
	}

}