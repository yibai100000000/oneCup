import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class SerializationUtils {
    //序列化对象
    public static void serializeObject(List<People> p1, String filePath) {
        try(FileOutputStream fileOutputStream=new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(p1);
            System.out.println("对象已序列化到文件");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //反序列化对象
    public static List<People> deserializeObject(String filePath){
        try(FileInputStream fileInputStream=new FileInputStream(filePath);
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream)){
            Object object=objectInputStream.readObject();

            if(object instanceof List){
                @SuppressWarnings("unchecked")
                List<People> userList=(List<People>) object;
                System.out.println("反序列化成功");
                return userList;
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("反序列化失败");
        return null;
    }
}
