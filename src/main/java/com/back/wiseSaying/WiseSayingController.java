package com.back.wiseSaying;

import java.util.Scanner;

public class WiseSayingController {
    private final WiseSayingService service = new WiseSayingService();
    private final Scanner scanner;

    public WiseSayingController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void sayHello() {
        service.initLastId();
        System.out.println("== 명언 앱 ==");
    }

    public void executeCommand(String command) {
        Integer id = null;
        String content;
        String author;
        switch (command) {
            case "등록":
                System.out.print("명언 : ");
                content = scanner.nextLine().trim();
                System.out.print("작가 : ");
                author = scanner.nextLine().trim();
                service.registerWiseSaying(content, author);
                break;
            case "목록":
                service.showWiseSayingList();
                break;
            case "삭제":
                System.out.print("?id = ");
                id = Integer.parseInt(scanner.nextLine().trim());
                service.deleteWiseSaying(id);
                break;
            case "수정":
                System.out.print("?id = ");
                id = Integer.parseInt(scanner.nextLine().trim());
                WiseSaying wiseSaying = service.findById(id);

                System.out.println("명언(기존) : " + wiseSaying.getContent());
                System.out.print("명언 : ");
                content = scanner.nextLine().trim();

                System.out.println("작가(기존) : " + wiseSaying.getAuthor());
                System.out.print("작가 : ");
                author = scanner.nextLine().trim();

                service.updateWiseSaying(wiseSaying.getId(), content, author);
                break;
            case "빌드":
                service.buildWiseSaying();
                break;
            case "종료":
                service.exit();
                break;
//            default:
//                System.out.println("잘못된 명령어입니다.");
        }
    }
}
