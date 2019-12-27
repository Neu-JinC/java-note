package book.concurrent.beautiful.chapter.two;

/**
 * cache 缓存内容测试
 * cache 缓存数据块，
 */
public class TestForContent {
    private static final Integer LINE_NUM = 1024;
    private static final Integer COLUM_NUM = 1024;

    public static void main(String[] args) {
        Integer[][] array = new Integer[LINE_NUM][COLUM_NUM];

        Long startTime = System.currentTimeMillis();
        for(int i = 0 ; i < LINE_NUM; i++) {
            for (int j = 0; j < COLUM_NUM; j++) {
                array[i][j] = i * 2 + j;
//                array[j][i] = i * 2 + j;
            }
        }

        Long endTime = System.currentTimeMillis();

        System.out.println("cache time: " + (endTime - startTime));
    }
}
