
import java.net.URL;
import java.net.URLClassLoader;

public class UI {

	public static void main(String[] args) {
		try {
			String folderPath = "C:/Users/jadave.ORADEV/eclipse-workspace_oxygen/RuntimeLoadingConcreteClassTest/src/folder/";
			URL folderURL = new URL("file:///" + folderPath);
			URL jarV1 = new URL("file:///" + folderPath + "V1.jar");
			URL jarV2 = new URL("file:///" + folderPath + "V2.jar");
			
			URL jarURLsV1[] = new URL[] {folderURL, jarV1 };
			URL jarURLsV2[] = new URL[] {folderURL, jarV2 };
			
//			CustomClassLoader classLoaderForV1 = new CustomClassLoader(jarURLsV1);
//			CustomClassLoader classLoaderForV2 = new CustomClassLoader(jarURLsV2);

			URLClassLoader classLoaderForV1 = new URLClassLoader(jarURLsV1);
			URLClassLoader classLoaderForV2 = new URLClassLoader(jarURLsV2);

			IFace dataLayerV1 = (IFace) classLoaderForV1.loadClass("DataAccessLayer").newInstance();
			IFace dataLayerV2 = (IFace) classLoaderForV2.loadClass("DataAccessLayer").newInstance();

			dataLayerV1.gatData();
			dataLayerV2.gatData();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
