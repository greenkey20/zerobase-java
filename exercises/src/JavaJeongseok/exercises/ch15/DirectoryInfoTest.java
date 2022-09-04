package exercises.src.JavaJeongseok.exercises.ch15;

import java.io.File;

// 2022.9.4(일) 0h40 Ex15_3
public class DirectoryInfoTest {
    static int totalFiles = 0;
    static int totalDirs = 0;
    static int totalSize = 0;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USAGE : java DirectoryInfoTest DIRECTORY");
            System.exit(0);
        }

        // 파일 = 기본적이며 가장 많이 사용되는, 중요한, 입/출력 대상
        File dir = new File(args[0]); // Java File 클래스 = 파일 및 디렉토리 다룸 -> File 인스턴스 = 파일 또는 디렉토리

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("유효하지 않은 디렉토리입니다");
            System.exit(0);
        }

        countFiles(dir);

        System.out.println();
        System.out.println("총 " + totalFiles + "개의 파일");
        System.out.println("총 " + totalDirs + "개의 디렉토리");
        System.out.println("크기 " + totalSize + " bytes");
    } // main() 종료

    private static void countFiles(File dir) {
        // 1. dir의 파일 목록(File[]) 얻어오기
        File[] files = dir.listFiles();

        // 얻어온 파일 목록의 파일 중에서
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) { // 2. 디렉토리이면 totalDirs의 값 증가 + countFiles() 메서드를 재귀호출
                totalDirs++;
                countFiles(files[i]);
            } else { // 3. 파일이면 totalFiles의 값 증가 + 파일의 크기를 totalSize에 더함
                totalFiles++;
                totalSize += files[i].length();
            }
        }
    } // countFiles() 종료

}
