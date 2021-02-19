import java.io.*;

public class test {
    public static void main(String[] args) throws IOException {
        //fileOutputStream();

        //fileWriter();

        //file();

        StringBuilder sb = new StringBuilder();
        File file = new File("D:\\test\\xiaoshuo.txt");
        InputStreamReader input = new InputStreamReader(new FileInputStream(file));
        BufferedReader bf = new BufferedReader(input);
        // 按行读取字符串
        String str;
        while ((str = bf.readLine()) != null) {
            sb.append(str);
        }
        bf.close();
        input.close();

        String text = sb.toString();
        text.indexOf(0,1024);
        byte[] byte2 = text.getBytes();
        File file2 = new File("D:\\test\\xiaoshuo2.txt");
        FileOutputStream fos = new FileOutputStream(file2);
        int byteWrite = -1;
        String tt = "";
        System.out.println(text.indexOf(0,1024));
        while(text.indexOf(0,1024) != -1) {
            //tt = text.substring(0,1024);
            tt = "aaa";
            System.out.println("!111111");
            fos.write(tt.getBytes());
        }
        fos.close();

    }

    private static void file() throws IOException {
        String str="hello world!";
        File txt = new File("D:\\test\\c.txt");
        if(!txt.exists()){
            txt.createNewFile();
        }
        byte[] bytes = new byte[2];
        bytes = str.getBytes();
        FileOutputStream fos = new FileOutputStream(txt);
        fos.write(bytes,0,bytes.length);//是字节的长度，不是字符串的长度
        //fos.write(bytes);
        fos.close();
    }

    private static void fileWriter() throws IOException {
        String str="hello world!";
        FileWriter writer = new FileWriter("D:\\test\\b.txt");
        writer.write(str);
        writer.flush();
    }

    private static void fileOutputStream() throws IOException {
        String text = "this is a text for test!";
        String director = "D:\\test\\a.txt";
        FileOutputStream fos = new FileOutputStream(director,true);
        fos.write(text.getBytes());
        fos.flush();
    }
}
