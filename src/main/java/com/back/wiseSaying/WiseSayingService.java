package com.back.wiseSaying;

public class WiseSayingService {
    private final String appRoot = "/Users/jiseopshin/DEV/dev_course_WiseSaying/src/main/resources";
    private final WiseSayingRepository repository = new WiseSayingRepository(appRoot);
    private Integer lastId;


    public WiseSaying registerWiseSaying(String wiseSayingContent, String author) {
        WiseSaying wiseSaying = createWiseSaying(wiseSayingContent, author);
        System.out.println(wiseSaying.getId() + "번명언이 등록되었습니다.");
        return wiseSaying;
    }

    public void showWiseSayingList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-----------------------------");
        repository.findAll().forEach(System.out::println);
    }

    public void deleteWiseSaying(Integer id) {
        System.out.println(repository.deleteById(id));
    }

    public WiseSaying updateWiseSaying(int id, String newContent, String newAuthor) {
        WiseSaying wiseSaying = repository.findById(id);
        WiseSaying updated = wiseSaying.update(newContent, newAuthor);
        return repository.update(updated);
    }

    public void buildWiseSaying() {
        repository.buildData();
    }

    public void exit() {
        System.exit(0);
    }

    private WiseSaying createWiseSaying(String wiseSayingContent, String author) {
        return repository.save(new WiseSaying(++lastId, wiseSayingContent, author));
    }

    public void initLastId() {
        lastId = repository.saveLastId(lastId);
    }
    public WiseSaying findById(int id) {
        return repository.findById(id);
    }
}
