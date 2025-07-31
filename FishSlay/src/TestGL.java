import com.jogamp.opengl.*;

public class TestGL {
    public static void main(String[] args) {
//        GLProfile.initSingleton(); // cần thiết trong 1 số máy
        System.out.println("Default profile: " + GLProfile.getDefault());
        System.out.println("GL2 profile: " + GLProfile.get(GLProfile.GL2));
    }
}
