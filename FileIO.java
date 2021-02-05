//package assignment4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class FileIO {
    public static String[] words;
    Methods methods = new Methods();
    Writer writer = new Writer();

    public FileIO() throws IOException {
    }

//    We read all files in here

        public String[] readFile(String path) {
            try {
                int i = 0;
                int length = Files.readAllLines(Paths.get(path)).size();
                String[] results = new String[length];
                for (String line : Files.readAllLines(Paths.get(path))) {
                    results[i++] = line;
                }
                return results;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

//    We read input files in here

        public Stack1 Stackreader(String file) throws IOException {
            Stack1 stack1 = new Stack1();
            String[] lines = readFile(file);
            for (String line : lines) {
                words = line.split(" ");
                Pattern pattern = Pattern.compile(" ");
                words = pattern.split(line);


                for(String numbers : words){
                    stack1.push(Integer.parseInt(numbers));
                }
            }
            return stack1;
        }

    public Queue1 Queuereader(String file) throws IOException {
        Queue1 queue1 = new Queue1();
        String[] lines = readFile(file);
        for (String line : lines) {
            words = line.split(" ");
            Pattern pattern = Pattern.compile(" ");
            words = pattern.split(line);

            for (String numbers : words){
                queue1.queueEnqueue(Integer.parseInt(numbers));
            }
        }
        return queue1;
    }

        public void CommandReader(String file)  throws IOException {
        try {
            String[] lines = readFile(file);
            Queue1 queue1 = Queuereader("queue.txt");
            Stack1 stack1 = Stackreader("stack.txt");
            for (String line : lines) {
                words = line.split(" ");
                Pattern pattern = Pattern.compile(" ");
                words = pattern.split(line);
                switch (words[0]) {
                    case "S":
                        if (words.length == 3) {
                            writer.StackWriterNumber(words[1], Integer.parseInt(words[2]), stack1);
                        }
                        if (words.length == 2) {
                            writer.StackWriter(words[1], stack1);
                        }
                        break;
                    case "Q":
                        if (words.length == 3) {
                            writer.QueueWriterNumber(words[1], Integer.parseInt(words[2]), queue1);
                        }
                        if (words.length == 2) {
                            writer.QueueWriter(words[1], queue1);
                        }
                }
            }
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Index out of bound...\nInvalid command");
        }

    }

}
