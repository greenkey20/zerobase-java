package exercises.src.zb.example2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

// 2022.8.13(토) 18h50
public class FileUtils {
    /**
     * IntelliJ Javadocs - add a new comment(https://www.jetbrains.com/help/idea/working-with-code-documentation.html)
     * 방법1) 해당 메소드 선언부 앞에 /** 타이핑하고 Enter
     * 방법2) 해당 메소드 선언부에 커서 두고 option/alt + Enter -> 목록에서 'Add Javadoc' 선택
     *
     * 전달된 파일 경로에서 파일 내용을 return
     * 현재 주어진 조건으로는 이 메소드는 static이 아닌 바, 인스턴스 메소드 -> 이 클래스 사용하기 위해서는 객체 생성 필요
     * @param filePath 파일 내용을 읽고자 하는 파일의 경로
     * @return 매개변수로 전달된 파일 경로에 있는 파일 내용을 문자열로 반환함
     */
    public String getLoadText(String filePath) {
        StringBuilder sb = new StringBuilder();

        Path path = Paths.get(filePath); // 내가 따라 칠 때는 이 행이 try 블럭 밖에 있어도 오류는 안 나는 것 같은데, 과제 파일에는 try 블럭 안에 들어가 있음
        try {
            List<String> lines = Files.readAllLines(path);

            for (int i = 0; i < lines.size(); i++) {
                if (i > 0) {
                    sb.append("\n");
                }

                sb.append(lines.get(i));
            }
        } catch (IOException e) {
//            throw new RuntimeException(e); // IntelliJ 자동 완성
            e.printStackTrace();
        }

        return sb.toString();
    }
}
