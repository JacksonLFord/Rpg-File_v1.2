package DataBase;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileLogger {
    public static String Directory = "";
    public static String File = "";

    ///////////////////////////////////////////////////////////////////////////
    public static boolean isDir(String dir) {//Done
        //this will check to see if a directory exists
        Path path1 = Paths.get(dir);
        if (Files.exists(path1) == false) {

        } else {

        }
        return Files.exists(path1);

    }

    ///////////////////////////////////////////////////////////////////////////
    public static void toDir(String Dir) {//Done
        //this will change the directory
        Path path1 = Paths.get(Dir);
        if (isDir(Dir)) {

            Directory = Dir;
        } else {

        }
    }

    ///////////////////////////////////////////////////////////////////////////
    public static boolean isDir() {//Done
        //this will see if the current directory exists
        Path path2 = Paths.get(Directory);
        if (Files.exists(path2) == false) {

        } else {

        }

        return Files.exists(path2);

    }

    ///////////////////////////////////////////////////////////////////////////
    public static boolean isFile(String file) {//Done
        //checks to see if a file exist at the current directory
        Path Path3 = Paths.get(Directory + "\\" + file);
        return Files.exists(Path3);

    }

    ///////////////////////////////////////////////////////////////////////////
    public static boolean isFile() {//Done
        //checks to see if a file exist at the current directory
        Path Path4 = Paths.get(Directory + "\\" + File);

        return Files.exists(Path4);

    }

    ///////////////////////////////////////////////////////////////////////////
    public static void toFile(String newfile) {//Done
        //this will change the current selected file to the file

        File = newfile;
    }

    ///////////////////////////////////////////////////////////////////////////
    public static boolean makeFile(String FileName) {//Done
        //this will create a new txt file
        PrintWriter writer = null;

        if (isDir()) {
            String path5 = Directory + "\\" + FileName + ".txt";
            try {
                writer = new PrintWriter(path5);
            } catch (Exception e) {
                System.out.println(e);
            }
            writer.close();
            if (isFile(FileName + ".txt") == false) {
                return false;
            }
            return isFile(FileName + ".txt") == true;
        }
        return false;
    }

    ///////////////////////////////////////////////////////////////////////////
    public static void makeFolder(String FolderName) {//Done
        //this will  make a new folder
        Path path6 = Paths.get(Directory + "\\" + FolderName);
        try {
            //java.nio.file.Files;
            Files.createDirectories(path6);
        } catch (Exception e) {

        }
    }

    ///////////////////////////////////////////////////////////////////////////
    public static void write(String item) {
        //this will write a string onto the next line on a specified file
        ArrayList<String> writing = new ArrayList<String>();
        if (isFile(File)) {

            String filePath = Directory + "\\" + File;
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(filePath));
            } catch (Exception e) {
                System.out.println(e);
            }


            String line = "";

            try {
                writing.add(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                while ((line = reader.readLine()) != null) {
                    writing.add(line);
                }
            } catch (IOException e) {
                System.out.println(e);
            }
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println(e);
            }

            if (writing.get(0) == null) {
                writing.remove(0);
            }
            //at this point we have a list of the items in teh file
            writing.add(item);
            FileWriter FileWriter = null;
            try {
                FileWriter = new FileWriter(filePath);
            } catch (Exception e) {
                System.out.println(e);
            }
            int index0 = 0;
            int index1 = writing.size();
            while (index0 < index1) {
                try {
                    FileWriter.append(writing.get(index0));
                    FileWriter.append("\n");
                } catch (IOException e) {
                    System.out.println(e);
                }
                index0 = index0 + 1;

            }
            try {
                FileWriter.close();
            } catch (Exception e) {
                System.out.println(e);
            }


        } else {

        }


    }

    ///////////////////////////////////////////////////////////////////////////
    public static void write(int index0, String rep) {
        //this will insert a new text item at the idex
        //this will write a string onto the next line on a specified file
        ArrayList<String> writing = new ArrayList<String>();
        if (isFile(File)) {

            String filePath = Directory + "\\" + File;
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(filePath));
            } catch (Exception e) {
                System.out.println(e);
            }


            String line = "";

            try {
                writing.add(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                while ((line = reader.readLine()) != null) {
                    writing.add(line);
                }
            } catch (IOException e) {
                System.out.println(e);
            }
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println(e);
            }


            //at this point we have a list of the items in teh file
            try {

                writing.add(index0, rep);
            } catch (Exception e) {

            }


            int index2 = 0;
            int index3 = writing.size();
            FileWriter FileWriter = null;
            try {
                FileWriter = new FileWriter(filePath);
            } catch (Exception e) {
                System.out.println(e);
            }
            while (index2 < index3) {
                try {
                    FileWriter.append(writing.get(index2));

                    FileWriter.append("\n");
                } catch (IOException e) {
                    System.out.println(e);
                }
                index2 = index2 + 1;
            }
            try {
                FileWriter.close();
            } catch (IOException e) {
                System.out.println(e);
            }


        } else {

        }
    }

    ///////////////////////////////////////////////////////////////////////////
    public static ArrayList<String> readAll() {
        //this will read and return  the whole text file to a JFrame
        ArrayList<String> writing = new ArrayList<String>();
        if (isFile(File)) {

            String filePath = Directory + "\\" + File;
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(filePath));
            } catch (Exception e) {
                System.out.println(e);
            }


            String line = "";

            try {
                writing.add(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                while ((line = reader.readLine()) != null) {
                    writing.add(line);
                }
            } catch (IOException e) {
                System.out.println(e);
            }
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println(e);
            }
            int index5 = 0;
            int index6 = writing.size();
            while (index5 < index6) {

                index5 = index5 + 1;
            }


        }
        return writing;
    }

    ///////////////////////////////////////////////////////////////////////////
    public static String read(int index10) {
        //this will read a specific item from the file
        //this will read and return  the whole text file to a JFrame
        ArrayList<String> writings = new ArrayList<String>();
        String selecteditem = "";
        if (isFile(File)) {

            String filePath = Directory + "\\" + File;
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(filePath));
            } catch (Exception e) {
                System.out.println(e);
            }


            String line = "";

            try {
                writings.add(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                while ((line = reader.readLine()) != null) {
                    writings.add(line);
                }
            } catch (IOException e) {
                System.out.println(e);
            }
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println(e);
            }

            try {
                selecteditem = writings.get(index10);
            } catch (Exception e) {
                System.out.println(e);
            }


        }
        return selecteditem;
    }

    ///////////////////////////////////////////////////////////////////////////
    public static void clear() {
        //this will clear everything from the file
        String FilePath = Directory + "\\" + File;
        FileWriter bf = null;
        try {
            bf = new FileWriter(FilePath);
            bf.append("");


        } catch (IOException e) {
            System.out.println(e);
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    public static void clear(int index47) {
        //this will clear a certain line on the file
        ArrayList<String> writing = new ArrayList<String>();
        if (isFile(File)) {
            String filePath = Directory + "\\" + File;
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(filePath));
            } catch (Exception e) {
                System.out.println(e);
            }


            String line = "";

            try {
                writing.add(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                while ((line = reader.readLine()) != null) {
                    writing.add(line);
                }
            } catch (IOException e) {
                System.out.println(e);
            }
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println(e);
            }

            try {
                writing.remove(index47);


            } catch (Exception e) {

            }

            System.out.println(writing);
            int index2 = 0;
            int index3 = writing.size();
            FileWriter FileWriter = null;
            try {
                FileWriter = new FileWriter(filePath);
            } catch (Exception e) {
                System.out.println(e);
            }
            while (index2 < index3) {
                try {
                    FileWriter.append(writing.get(index2));

                    FileWriter.append("\n");
                } catch (IOException e) {
                    System.out.println(e);
                }
                index2 = index2 + 1;
            }
            try {
                FileWriter.close();
            } catch (IOException e) {
                System.out.println(e);
            }


        }
    }

    ///////////////////////////////////////////////////////////////////////////
    public static void Copy(String nameofnew, String dirNew, String dirOld, String NameOld) {

        toDir(dirOld);
        toFile(NameOld+ ".txt");
        ArrayList<String> words = readAll();
        int index1 = words.size();
        int index2 = 0;
        toDir(dirNew);
        toFile(nameofnew + ".txt");
        while (index2 < index1) {
            write(words.get(index2));
            index2++;
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    public static void replace(int index0, String rep) {
        //this will insert a new text item at the idex
        //this will write a string onto the next line on a specified file
        ArrayList<String> writing = new ArrayList<String>();
        if (isFile(File)) {

            String filePath = Directory + "\\" + File;
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(filePath));
            } catch (Exception e) {
                System.out.println(e);
            }


            String line = "";

            try {
                writing.add(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                while ((line = reader.readLine()) != null) {
                    writing.add(line);
                }
            } catch (IOException e) {
                System.out.println(e);
            }
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println(e);
            }


            //at this point we have a list of the items in teh file
            try {
                writing.remove(index0);
                writing.add(index0, rep);
            } catch (Exception e) {

            }


            int index2 = 0;
            int index3 = writing.size();
            FileWriter FileWriter = null;
            try {
                FileWriter = new FileWriter(filePath);
            } catch (Exception e) {
                System.out.println(e);
            }
            while (index2 < index3) {
                try {
                    FileWriter.append(writing.get(index2));

                    FileWriter.append("\n");
                } catch (IOException e) {
                    System.out.println(e);
                }
                index2 = index2 + 1;
            }
            try {
                FileWriter.close();
            } catch (IOException e) {
                System.out.println(e);
            }


        } else {

        }
    }

    public static String pad(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append(' ');
        }
        StringBuilder sd = new StringBuilder();
        sd.append(inputString);
        sd.append(sb.toString());

        return sd.toString();
    } public static String padLeft(String inputString, int length) {

        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append(' ');
        }
        StringBuilder sd = new StringBuilder();

        sd.append(sb.toString());
        sd.append(inputString);

        return sd.toString();
    }public static String padboth(String inputString, int length) {
      int need = length- inputString.length();
      int half = need / 2;
      int l = need - half;
      int r = need - l;

      String file =  inputString;
      file = padLeft(file, l+ file.length());

      file = pad(file,r+ l+inputString.length() );
      System.out.println(file);
      return file;

    }

    public static String insertPeriodically(
            String text, String insert, int period) {
        StringBuilder builder = new StringBuilder(
                text.length() + insert.length() * (text.length() / period) + 1);

        int index = 0;
        String prefix = "";
        while (index < text.length()) {
            // Don't put the insert in the very first iteration.
            // This is easier than appending it *after* each substring
            builder.append(prefix);
            prefix = insert;
            builder.append(text, index, Math.min(index + period, text.length()));
            index += period;
        }
        return builder.toString();
    }

    public static void copyDirectory(String sourceDirectoryLocation, String destinationDirectoryLocation) {
        try{
            Files.walk(Paths.get(sourceDirectoryLocation))
                    .forEach(source -> {
                        Path destination = Paths.get(destinationDirectoryLocation, source.toString()
                                .substring(sourceDirectoryLocation.length()));
                        try {
                            Files.copy(source, destination);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }catch(Exception e){

        }

    }
}