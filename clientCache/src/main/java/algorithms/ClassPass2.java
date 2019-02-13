package algorithms;

import java.util.HashMap;
import java.util.Map;

public class ClassPass2 {
    public static void main(String[] a){

        String S = "my.song.mp3 11b\n" + "greatSong.flac 1000b\n"
                + "not3.txt 5b\n" + "video.mp4 200b\n" + "game.exe 100b\n"
                + "mov!e.mkv 10000b";

        System.out.println(solution(S));
    }

     static String solution(String S){
         if (S == null || S.trim().length() < 1) {
            return "";
         }

         Map<String, Integer> musicMap = new HashMap<>();

         musicMap.put("music", 0);
         musicMap.put("movies", 0);
         musicMap.put("others", 0);
         musicMap.put("images", 0);

         String[] files = S.split("[\\n]");

         for(int i=0; i<files.length; i++){
             String music = files[i];

             int size = Integer.parseInt(music.split(" ")[1].substring(0, music.split(" ")[1].length()-1));

             if (music.contains("mp3") || music.contains("flac"))  {
                     musicMap.put("music", musicMap.get("music") + size);
             }else if (music.contains("mp4") || music.contains("mkv"))  {
                     musicMap.put("movies", musicMap.get("movies") + size);
             }else if (music.contains("txt") || music.contains("exe"))  {
                     musicMap.put("others", musicMap.get("others") + size);
             }
         }

         StringBuffer buffer = new StringBuffer();
         for (Map.Entry<String, Integer> entry : musicMap.entrySet()) {
             buffer.append(entry.getKey()).append(" ").append(entry.getValue()).append("b");
             buffer.append(" ");
         }

         return buffer.toString();
    }
}